package duelistmod.events;

import java.util.ArrayList;

import basemod.IUIElement;
import basemod.eventUtil.util.Condition;
import com.evacipated.cardcrawl.modthespire.lib.SpireConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.*;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.localization.EventStrings;
import com.megacrit.cardcrawl.relics.*;

import duelistmod.DuelistMod;
import duelistmod.abstracts.DuelistEvent;
import duelistmod.dto.DuelistConfigurationData;
import duelistmod.dto.EventConfigData;
import duelistmod.relics.*;
import duelistmod.ui.configMenu.DuelistLabeledToggleButton;

public class RelicDuplicator extends DuelistEvent {


    public static final String ID = DuelistMod.makeID("RelicDuplicator");
    public static final String IMG = DuelistMod.makeEventPath("RelicDuplicator.png");
    private static final EventStrings eventStrings = CardCrawlGame.languagePack.getEventString(ID);
    private static final String NAME = eventStrings.NAME;
    private static final String[] DESCRIPTIONS = eventStrings.DESCRIPTIONS;
    private static final String[] OPTIONS = eventStrings.OPTIONS;
    private int screenNum = 0;
    private int goldCost = 0;
    private AbstractRelic dupeRelic;

    public RelicDuplicator() {
        super(ID, NAME, DESCRIPTIONS[0], IMG);
        this.noCardsInRewards = true;
        ArrayList<AbstractRelic> locRelics = this.getDuplicableRelics();
        Condition bothConditions = () -> {
            if (AbstractDungeon.player == null) return false;
            ArrayList<AbstractRelic> check = this.getDuplicableRelics();
            return !this.getActiveConfig().getDisabled() && check.size() > 0;
        };
        this.spawnCondition = bothConditions;
        this.bonusCondition = bothConditions;
        boolean dungeonCheck = AbstractDungeon.player != null && AbstractDungeon.getCurrMapNode() != null && AbstractDungeon.getCurrRoom() != null;
        if (dungeonCheck && locRelics.size() > 0) {
            this.goldCost = AbstractDungeon.cardRandomRng.random(100, 300);
            if (goldCost > AbstractDungeon.player.gold) { goldCost = AbstractDungeon.player.gold; }
            this.dupeRelic = locRelics.get(AbstractDungeon.cardRandomRng.random(locRelics.size() - 1));
            String colr = FontHelper.colorString(this.dupeRelic.name, "g");
            imageEventText.setDialogOption(OPTIONS[0] + colr + OPTIONS[1] + goldCost + OPTIONS[2]);
            imageEventText.setDialogOption(OPTIONS[4]);
        } else if (dungeonCheck) {
            imageEventText.setDialogOption(OPTIONS[3], true);
            imageEventText.setDialogOption(OPTIONS[4]);
        }
    }

    @Override
    protected void buttonEffect(int i) {
        switch (screenNum) {
            case 0:
                switch (i) {
                    case 0:
                    	this.imageEventText.updateBodyText("Enjoy your duplicated relic! Thanks for letting me make so many extras for myself!");
                    	this.imageEventText.updateDialogOption(0, OPTIONS[4]);
                        this.imageEventText.clearRemainingOptions();
                    	AbstractDungeon.getCurrRoom().spawnRelicAndObtain((float) (Settings.WIDTH / 2), (float) (Settings.HEIGHT / 2), this.dupeRelic.makeCopy());
                        AbstractDungeon.player.loseGold(this.goldCost);
                    	logDuelistMetric(NAME, "Duplicated Relic - " + dupeRelic.name);
                        screenNum = 1;
                        break;
                    case 1:
                    	this.imageEventText.updateBodyText("Yeah who would want two of a relic anyway...");
                        this.imageEventText.updateDialogOption(0, OPTIONS[4]);
                        this.imageEventText.clearRemainingOptions();
                        logDuelistMetric(NAME, "Leave");
                        screenNum = 1;
                }
                break;
            case 1:
                openMap();
                break;

        }
    }

    private ArrayList<AbstractRelic> getDuplicableRelics() {
        if (AbstractDungeon.player != null) {
            AbstractPlayer p = AbstractDungeon.player;
            ArrayList<AbstractRelic> locRelics = new ArrayList<>();
            String idToCheck;
            idToCheck = MonsterEggRelic.ID;
            if (p.hasRelic(idToCheck)) {
                locRelics.add(p.getRelic(idToCheck));
            }
            idToCheck = MerchantNecklace.ID;
            if (p.hasRelic(idToCheck)) {
                locRelics.add(p.getRelic(idToCheck));
            }
            idToCheck = DuelistUrn.ID;
            if (p.hasRelic(idToCheck)) {
                locRelics.add(p.getRelic(idToCheck));
            }
            idToCheck = DuelistLetterOpener.ID;
            if (p.hasRelic(idToCheck)) {
                locRelics.add(p.getRelic(idToCheck));
            }
            idToCheck = DuelistCoin.ID;
            if (p.hasRelic(idToCheck)) {
                locRelics.add(p.getRelic(idToCheck));
            }
            idToCheck = AknamkanonsEssence.ID;
            if (p.hasRelic(idToCheck)) {
                locRelics.add(p.getRelic(idToCheck));
            }
            idToCheck = KaibaToken.ID;
            if (p.hasRelic(idToCheck)) {
                locRelics.add(p.getRelic(idToCheck));
            }
            idToCheck = BirdFacedUrn.ID;
            if (p.hasRelic(idToCheck)) {
                locRelics.add(p.getRelic(idToCheck));
            }
            idToCheck = Anchor.ID;
            if (p.hasRelic(idToCheck)) {
                locRelics.add(p.getRelic(idToCheck));
            }
            idToCheck = BagOfMarbles.ID;
            if (p.hasRelic(idToCheck)) {
                locRelics.add(p.getRelic(idToCheck));
            }
            idToCheck = BloodVial.ID;
            if (p.hasRelic(idToCheck)) {
                locRelics.add(p.getRelic(idToCheck));
            }
            idToCheck = BronzeScales.ID;
            if (p.hasRelic(idToCheck)) {
                locRelics.add(p.getRelic(idToCheck));
            }
            idToCheck = DarkstonePeriapt.ID;
            if (p.hasRelic(idToCheck)) {
                locRelics.add(p.getRelic(idToCheck));
            }
            idToCheck = DeadBranch.ID;
            if (p.hasRelic(idToCheck)) {
                locRelics.add(p.getRelic(idToCheck));
            }
            idToCheck = SpellcasterOrb.ID;
            if (p.hasRelic(idToCheck)) {
                locRelics.add(p.getRelic(idToCheck));
            }
            idToCheck = DragonRelic.ID;
            if (p.hasRelic(idToCheck)) {
                locRelics.add(p.getRelic(idToCheck));
            }
            idToCheck = MillenniumRod.ID;
            if (p.hasRelic(idToCheck)) {
                locRelics.add(p.getRelic(idToCheck));
            }

            return locRelics;
        }
        return new ArrayList<>();
    }

    @Override
    public DuelistConfigurationData getConfigurations() {
        RESET_Y(); LINEBREAK(); LINEBREAK(); LINEBREAK(); LINEBREAK();
        ArrayList<IUIElement> settingElements = new ArrayList<>();
        EventConfigData onLoad = this.getActiveConfig();
        String tooltip = "When enabled, allows you encounter this event during runs. Enabled by default.";
        settingElements.add(new DuelistLabeledToggleButton("Event Enabled", tooltip,DuelistMod.xLabPos, DuelistMod.yPos, Settings.CREAM_COLOR, FontHelper.charDescFont, !onLoad.getDisabled(), DuelistMod.settingsPanel, (label) -> {}, (button) ->
        {
            EventConfigData data = this.getActiveConfig();
            data.setDisabled(!button.enabled);
            DuelistMod.eventConfigSettingsMap.put(this.duelistEventId, data);
            try
            {
                SpireConfig config = new SpireConfig("TheDuelist", "DuelistConfig",DuelistMod.duelistDefaults);
                String eventConfigMap = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(DuelistMod.eventConfigSettingsMap);
                config.setString("eventConfigSettingsMap", eventConfigMap);
                config.save();
            } catch (Exception e) { e.printStackTrace(); }
        }));
        return new DuelistConfigurationData(this.title, settingElements, this);
    }
}

