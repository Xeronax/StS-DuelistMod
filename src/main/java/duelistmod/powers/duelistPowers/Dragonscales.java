package duelistmod.powers.duelistPowers;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.*;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.ThornsPower;

import duelistmod.DuelistMod;
import duelistmod.abstracts.*;
import duelistmod.dto.AnyDuelist;
import duelistmod.powers.incomplete.BoosterDragonPower;
import duelistmod.relics.GoldenScale;
import duelistmod.variables.Tags;

public class Dragonscales extends DuelistPower
{	
	public AbstractCreature source;

    public static final String POWER_ID = DuelistMod.makeID("Dragonscales");
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
    public static final String IMG = DuelistMod.makePowerPath("Dragonscales.png");
	
	public Dragonscales(int stacks) {
		this(AbstractDungeon.player, AbstractDungeon.player, stacks);
	}
	
	public Dragonscales(AbstractCreature owner, AbstractCreature source, int stacks) {
		//super(owner, source, stacks);
		this.name = NAME;
        this.ID = POWER_ID;
        this.owner = owner;
		AnyDuelist duelist = AnyDuelist.from(this);
        this.type = PowerType.BUFF;
        this.isTurnBased = false;
        this.canGoNegative = false;
        this.img = new Texture(IMG);
        this.source = source;
        this.amount = stacks;
        if (duelist.hasPower(BoosterDragonPower.POWER_ID)) {
			this.amount += duelist.getPower(BoosterDragonPower.POWER_ID).amount;
		}
		if (duelist.hasRelic(GoldenScale.ID)) {
			this.amount += 2;
		}
        updateDescription(); 
	}
	
	public void convertToThorns()
	{
		DuelistCard.applyPowerToSelf(new ThornsPower(AbstractDungeon.player, this.amount));
		DuelistCard.removePower(this, this.owner);
	}
	public int getInc()
	{
		float mod = (float)this.amount / (float)DuelistMod.dragonScalesSelectorIndex;
		return (int)(mod) * DuelistMod.dragonScalesModIndex;
	}
	
	@Override
	public float modifyBlock(float blkAmt, AbstractCard card)
	{
		if (card.hasTag(Tags.DRAGON)) { return blkAmt + getInc(); }
		return blkAmt;
	}

	@Override
	public void updateDescription()
	{
		int dmgBuff = getInc();
		this.description = DESCRIPTIONS[0] + dmgBuff + DESCRIPTIONS[1];
	}
}
