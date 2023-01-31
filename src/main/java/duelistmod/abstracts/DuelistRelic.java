package duelistmod.abstracts;

import java.util.ArrayList;
import java.util.List;

import basemod.IUIElement;
import com.badlogic.gdx.graphics.Texture;
import com.evacipated.cardcrawl.mod.stslib.relics.ClickableRelic;
import com.evacipated.cardcrawl.mod.stslib.relics.SuperRareRelic;
import com.evacipated.cardcrawl.modthespire.lib.SpireConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.*;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import basemod.abstracts.CustomRelic;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.monsters.*;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import duelistmod.DuelistMod;
import duelistmod.dto.DuelistConfigurationData;
import duelistmod.dto.RelicConfigData;
import duelistmod.helpers.Util;
import duelistmod.relics.MillenniumCoin;
import duelistmod.rewards.BoosterPack;
import duelistmod.ui.configMenu.DuelistDropdown;
import duelistmod.ui.configMenu.DuelistLabeledToggleButton;
import duelistmod.ui.configMenu.RefreshablePage;
import duelistmod.ui.configMenu.SpecificConfigMenuPageWithJson;

public abstract class DuelistRelic extends CustomRelic implements ClickableRelic
{
	protected boolean showIdInConfig;
	protected boolean showDescriptionInConfig;
	protected boolean showRarityInConfig;
	protected int configDescMaxLines;
	protected int configDescMaxWidth;
	
	public DuelistRelic(String id, Texture texture, Texture outline, RelicTier tier, LandingSound sfx) 
	{
		this(id, texture, outline, tier, sfx, null);
	}
	
	public DuelistRelic(String id, Texture texture, Texture outline, RelicTier tier, LandingSound sfx, Integer counter)
	{
		super(id, texture, outline, tier, sfx);
		if (counter != null) {
			this.setCounter(counter);
		}
		this.showDescriptionInConfig = true;
		this.showIdInConfig = true;
		this.showRarityInConfig = true;
		this.configDescMaxLines = 4;
		this.configDescMaxWidth = 70;
	}
	
	@Override
    public void onRightClick() 
    {
    	if (this.counter > 0)
    	{
    		flash();
    		this.counter--;
    	}
    }

	@Override
	public void obtain() {
		super.obtain();
		if (AbstractDungeon.player == null || AbstractDungeon.player.relics == null) return;

		if (this instanceof MillenniumCoin) return;
		boolean isMillenniumRelic = Util.isMillenniumItem(this, true);
		if (!isMillenniumRelic) return;

		for (AbstractRelic relic : AbstractDungeon.player.relics) {
			if (relic instanceof MillenniumCoin) {
				((MillenniumCoin)relic).gainGold();
				return;
			}
		}
	}
	
	protected void addToBot(final AbstractGameAction action) {
        AbstractDungeon.actionManager.addToBottom(action);
    }
    
    protected void addToTop(final AbstractGameAction action) {
        AbstractDungeon.actionManager.addToTop(action);
    }

	protected List<DuelistDropdown> configAddAfterDisabledBox(ArrayList<IUIElement> settingElements) { return new ArrayList<>(); }

	protected List<DuelistDropdown> configAddAfterDescription(ArrayList<IUIElement> settingElements) { return new ArrayList<>(); }

	public RelicConfigData getDefaultConfig() { return new RelicConfigData(); }

	public RelicConfigData getActiveConfig() { return DuelistMod.relicCanSpawnConfigMap.getOrDefault(this.relicId, this.getDefaultConfig()); }

	public void updateConfigSettings(RelicConfigData data) {
		DuelistMod.relicCanSpawnConfigMap.put(this.relicId, data);
		this.callUpdateDesc();
		if (AbstractDungeon.player != null && AbstractDungeon.player.relics != null && AbstractDungeon.player.hasRelic(this.relicId)) {
			AbstractRelic r = AbstractDungeon.player.getRelic(this.relicId);
			if (r instanceof DuelistRelic) {
				DuelistRelic dr = (DuelistRelic) r;
				dr.callUpdateDesc();
			}
		}
		for (RefreshablePage page : DuelistMod.refreshablePages) {
			if (page instanceof SpecificConfigMenuPageWithJson) {
				SpecificConfigMenuPageWithJson pageWithJson = (SpecificConfigMenuPageWithJson)page;

				DuelistRelic configRef = pageWithJson.config.relic();
				if (configRef != null) {
					configRef.callUpdateDesc();
					if (pageWithJson.image != null) {
						pageWithJson.image.tooltip = configRef.getHoverConfigIconTooltip();
					}
				}
			}
		}
		try
		{
			SpireConfig config = new SpireConfig("TheDuelist", "DuelistConfig",DuelistMod.duelistDefaults);
			String relicConfigMap = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(DuelistMod.relicCanSpawnConfigMap);
			config.setString("relicCanSpawnConfigMap", relicConfigMap);
			config.save();
		} catch (Exception e) { e.printStackTrace(); }
	}

	public void callUpdateDesc() {}

	public DuelistConfigurationData getConfigurations() {
		if (this.tier == RelicTier.SPECIAL || this.tier == RelicTier.STARTER) {
			return null;
		}
		RESET_Y(); LINEBREAK(); LINEBREAK(); LINEBREAK(); LINEBREAK();
		ArrayList<IUIElement> settingElements = new ArrayList<>();
		String tooltip = "When enabled, " + this.name + " will not spawn during runs. Disabled by default.";
		settingElements.add(new DuelistLabeledToggleButton("Disable " + this.name, tooltip,DuelistMod.xLabPos, DuelistMod.yPos, Settings.CREAM_COLOR, FontHelper.charDescFont, DuelistMod.relicCanSpawnConfigMap.getOrDefault(this.relicId, this.getDefaultConfig()).getDisabled(), DuelistMod.settingsPanel, (label) -> {}, (button) ->
		{
			RelicConfigData data = this.getActiveConfig();
			data.setDisabled(button.enabled);
			this.updateConfigSettings(data);
		}));
		LINEBREAK(35);

		List<DuelistDropdown> dropdownsPre = this.configAddAfterDisabledBox(settingElements);
		List<DuelistDropdown> dropdownsPost = this.configAddAfterDescription(settingElements);

		settingElements.addAll(dropdownsPost);
		settingElements.addAll(dropdownsPre);

		return new DuelistConfigurationData(this.name, settingElements, this);
	}

	public String getHoverConfigIconTooltip() {
		return "#bID: " + this.relicId + " NL #bRarity: " + this.getRarityDisplayName() + " NL " + this.getUpdatedDescription();
	}

	public String getRarityDisplayName() {
		switch (this.tier) {
			case STARTER:
				return "Starter";
			case COMMON:
				return "Common";
			case UNCOMMON:
				return "Uncommon";
			case RARE:
				return "Rare";
			case SPECIAL:
				return "Special";
			case BOSS:
				return "Boss";
			case SHOP:
				return "Shop";
			default:
				if (this instanceof SuperRareRelic) {
					return "Super Rare";
				}
				return "Unknown";
		}
	}

	@Override
	public boolean canSpawn() {
		boolean idCheck = DuelistMod.relicCanSpawnConfigMap.getOrDefault(this.relicId, this.getDefaultConfig()).getDisabled();
		if (idCheck) return false;

		if (this.tier == RelicTier.COMMON && DuelistMod.disableAllCommonRelics) {
			return false;
		}
		if (this.tier == RelicTier.UNCOMMON && DuelistMod.disableAllUncommonRelics) {
			return false;
		}
		if (this.tier == RelicTier.RARE && DuelistMod.disableAllRareRelics) {
			return false;
		}
		if (this.tier == RelicTier.SHOP && DuelistMod.disableAllShopRelics) {
			return false;
		}
		if (this.tier == RelicTier.BOSS && DuelistMod.disableAllBossRelics) {
			return false;
		}
		return true;
	}

	public void LINEBREAK() {
		DuelistMod.linebreak();
	}

	public void LINEBREAK(int extra) {
		DuelistMod.linebreak(extra);
	}

	public void RESET_Y() {
		DuelistMod.yPos = DuelistMod.startingYPos;
	}
    
    public void onReceiveBoosterPack(BoosterPack pack) { }
    
	public void onSoulChange(int newSouls, int change) { }
	
	public void onGainVines() { }
	
    public int modifyShadowDamage() { return 0; }
    
    public int modifyUndeadDamage() { return 0; }
	
	public void onTribute(DuelistCard tributedMon, DuelistCard tributingMon) { }
	
	public void onSummon(DuelistCard summoned, int amountSummoned) { }
	
	public void onIncrement(int amount, int newMaxSummons) { }
	
	public void onResummon(DuelistCard resummoned) { }
	
	public void onResummon(DuelistCard resummoned, boolean actual) { if (actual) { this.onResummon(resummoned); }}
	
	public int modifyResummonAmt(AbstractCard resummoningCard) { return 0; }
	
	public boolean allowResummon(AbstractCard resummoningCard) { return true; }
	
	public boolean allowRevive() { return true; }
	
	public int modifyReviveListSize() { return 0; }
	
	public boolean upgradeResummon(AbstractCard resummoningCard) { return false; }
	
	public int modifyReviveCost(ArrayList<AbstractCard> entombedList) { return 0; }
	
	public void onSynergyTribute() { }
	
	public void onLoseArtifact() { }
	
	public void onOverflow(int amt) { }
	
	public void onFish(ArrayList<AbstractCard> discarded, ArrayList<AbstractCard> aquasDiscarded) { }
	
	public float modifyBlock(float blockAmount, AbstractCard card) { return blockAmount; }
	
	public void onEnemyUseCard(final AbstractCard card) { }
	
	public void onDetonate() { }
	
	public void onSolder() { }
	
	public void onPassRoulette() { }
	
	public int modifySummons(int magicAmt) { return magicAmt; }
	
	public int modifyTributes(int magicAmt) { return magicAmt; }
	
	public int modifySummons(int magicAmt, AbstractCard card) { return this.modifySummons(magicAmt); }
	
	public int modifyTributes(int magicAmt, AbstractCard card) { return this.modifyTributes(magicAmt); }
	
	public float modifyEntomb(float magicAmt) { return magicAmt; }
	
	public float modifyEntomb(float magicAmt, AbstractCard card) { return this.modifyEntomb(magicAmt); }
	
	public float modifyMagicNumber(float magicAmt) { return magicAmt; }
	
	public float modifyMagicNumber(float magicAmt, AbstractCard card) { return this.modifyMagicNumber(magicAmt); }

	public float modifySecondMagicNumber(float magicAmt) { return magicAmt; }
	
	public float modifySecondMagicNumber(float magicAmt, AbstractCard card) { return this.modifySecondMagicNumber(magicAmt); }
	
	public float modifyThirdMagicNumber(float magicAmt) { return magicAmt; }
	
	public float modifyThirdMagicNumber(float magicAmt, AbstractCard card) { return this.modifyThirdMagicNumber(magicAmt); }

	public boolean modifyCanUse(final AbstractCreature p, final DuelistCard card) { return true; }

	public String cannotUseMessage(final AbstractPlayer p, final AbstractMonster m, final DuelistCard card) { return "Cannot use due to relic: " + this.name; }
}
