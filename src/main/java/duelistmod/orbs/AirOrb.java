package duelistmod.orbs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.core.*;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.*;
import com.megacrit.cardcrawl.localization.OrbStrings;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.vfx.combat.*;

import duelistmod.*;
import duelistmod.abstracts.*;
import duelistmod.helpers.Util;
import duelistmod.powers.*;
import duelistmod.relics.AeroRelic;
import duelistmod.variables.Tags;

@SuppressWarnings("unused")
public class AirOrb extends DuelistOrb
{
	public static final String ID = DuelistMod.makeID("Air");
	private static final OrbStrings orbString = CardCrawlGame.languagePack.getOrbString(ID);
	public static final String[] DESC = orbString.DESCRIPTION;
	private final float vfxIntervalMin = 0.15F;
	private final float vfxIntervalMax = 0.8F;
	private float vfxTimer = 0.5F; 	
	protected static final float VFX_INTERVAL_TIME = 0.25F;
	private static final float PI_DIV_16 = 0.19634955F;
	private static final float ORB_WAVY_DIST = 0.05F;
	private static final float PI_4 = 12.566371F;
	private static final float ORB_BORDER_SCALE = 1.2F;
	
	public AirOrb() {
		this.setID(ID);
		this.inversion = "Smoke";
		this.img = ImageMaster.loadImage(DuelistMod.makePath("orbs/Air.png"));
		this.name = orbString.NAME;
		this.baseEvokeAmount = this.evokeAmount = Util.getOrbConfiguredEvoke(this.name);
		this.basePassiveAmount = this.passiveAmount = Util.getOrbConfiguredPassive(this.name);
		this.configShouldAllowEvokeDisable = true;
		this.configShouldAllowPassiveDisable = true;
		this.updateDescription();
		this.angle = MathUtils.random(360.0F);
		this.channelAnimTimer = 0.5F;
		originalEvoke = this.baseEvokeAmount;
		originalPassive = this.basePassiveAmount;
		checkFocus();
	}

	@Override
	public void updateDescription()
	{
		applyFocus();
		if (this.owner != null && (this.owner.hasPower(AerodynamicsPower.POWER_ID) || this.owner.hasRelic(AeroRelic.ID)))
		{
			if (this.evokeAmount == 1) { this.description = DESC[4] + DESC[1] + this.evokeAmount + DESC[2]; }
			else { this.description = DESC[4] + DESC[1] + this.evokeAmount + DESC[3]; }
		}
		else
		{
			if (this.evokeAmount  == 1) { this.description = DESC[0] + DESC[1] + this.evokeAmount + DESC[2]; }
			else { this.description = DESC[0] + DESC[1] + this.evokeAmount + DESC[3]; }
		}
	}

	@Override
	public void onEvoke()
	{
		applyFocus();
		if (Util.getOrbConfiguredEvokeDisabled(this.name)) return;

		if (doesNotHaveNegativeFocus()) {
			this.owner.increaseOrbSlots(this.evokeAmount);
		}
	}
	
	@Override
	public void onEndOfTurn()
	{
		checkFocus();
	}

	@Override
	public void onStartOfTurn()
	{
		if (this.owner.hasPower(AerodynamicsPower.POWER_ID) || this.owner.hasRelic(AeroRelic.ID))
		{
			this.triggerPassiveEffect();
		}
		else if (doesNotHaveNegativeFocus())
		{
			applyFocus();
			int roll = AbstractDungeon.cardRandomRng.random(1, 10);
			if (this.owner.hasPower(SummonPower.POWER_ID))
			{
				SummonPower instance = (SummonPower) this.owner.getPower(SummonPower.POWER_ID);
				if (instance.isEveryMonsterCheck(Tags.DRAGON, false))
				{
					roll += 2;
				}
			}
			if (roll > 5)
			{
				this.triggerPassiveEffect();
				//if (gpcCheck()) { this.triggerPassiveEffect(); }
			}
		}
	}

	public void triggerPassiveEffect()
	{
		if (Util.getOrbConfiguredPassiveDisabled(this.name)) return;

		if (this.owner.player()) {
			AbstractDungeon.actionManager.addToTop(new VFXAction(new OrbFlareEffect(this, OrbFlareEffect.OrbFlareColor.DARK), 0.1f));
		}
		DuelistCard.channelRandomOffensive(this.owner);
	}

	@Override
	//Taken from frost orb and modified a bit. Works to draw the basic orb image.
	public void render(SpriteBatch sb) 
	{
		sb.setColor(new Color(1.0F, 1.0F, 1.0F, this.c.a / 2.0F));
		sb.setBlendFunction(770, 1);
		sb.setColor(new Color(1.0F, 1.0F, 1.0F, this.c.a / 2.0F));
		sb.draw(this.img, this.cX - 48.0F, this.cY - 48.0F + this.bobEffect.y, 48.0F, 48.0F, 96.0F, 96.0F, this.scale + 
		MathUtils.sin(this.angle / 12.566371F) * 0.05F + 0.19634955F, this.scale * 1.2F, this.angle, 0, 0, 96, 96, false, false);
		sb.draw(this.img, this.cX - 48.0F, this.cY - 48.0F + this.bobEffect.y, 48.0F, 48.0F, 96.0F, 96.0F, this.scale * 1.2F, this.scale + 
		MathUtils.sin(this.angle / 12.566371F) * 0.05F + 0.19634955F, -this.angle, 0, 0, 96, 96, false, false);
		sb.setBlendFunction(770, 771);
		sb.setColor(this.c);
		sb.draw(this.img, this.cX - 48.0F, this.cY - 48.0F + this.bobEffect.y, 48.0F, 48.0F, 96.0F, 96.0F, this.scale, this.scale, this.angle / 12.0F, 0, 0, 96, 96, false, false);
		renderText(sb);
		this.hb.render(sb);
	}
	
	@Override
	public void updateAnimation()
	{
		applyFocus();
		super.updateAnimation();
		this.angle += Gdx.graphics.getDeltaTime() * 120.0F;
		this.vfxTimer -= Gdx.graphics.getDeltaTime();
		if (this.vfxTimer < 0.0F) 
		{
			AbstractDungeon.effectList.add(new DarkOrbPassiveEffect(this.cX, this.cY));
			this.vfxTimer = 0.25F;
		}	
	}

	@Override
	public void playChannelSFX()
	{
		CardCrawlGame.sound.playV("theDuelist:AirChannel", 1.0F);
	}

	@Override
	protected void renderText(SpriteBatch sb)
	{
		renderInvertText(sb, false);
		// Render evoke amount text
		//FontHelper.renderFontCentered(sb, FontHelper.cardEnergyFont_L, Integer.toString(this.evokeAmount), this.cX + NUM_X_OFFSET, this.cY + this.bobEffect.y / 2.0F + NUM_Y_OFFSET - 4.0F * Settings.scale, new Color(0.2F, 1.0F, 1.0F, this.c.a), this.fontScale);
		// Render passive amount text
		//FontHelper.renderFontCentered(sb, FontHelper.cardEnergyFont_L, Integer.toString(this.passiveAmount), this.cX + NUM_X_OFFSET, this.cY + this.bobEffect.y / 2.0F + NUM_Y_OFFSET + 20.0F * Settings.scale, this.c, this.fontScale);
	}

	@Override
	public AbstractOrb makeCopy()
	{
		return new AirOrb();
	}

	@Override
	public void applyFocus() 
	{
		this.passiveAmount = this.basePassiveAmount;
		this.evokeAmount = this.baseEvokeAmount;
	}
}
