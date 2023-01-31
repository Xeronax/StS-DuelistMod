package duelistmod.powers.duelistPowers;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.GameActionManager;
import com.megacrit.cardcrawl.core.*;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;

import duelistmod.DuelistMod;
import duelistmod.abstracts.*;
import duelistmod.dto.AnyDuelist;
import duelistmod.helpers.Util;

public class NaturiaStagBeetlePower extends DuelistPower
{	
	public AbstractCreature source;

    public static final String POWER_ID = DuelistMod.makeID("NaturiaStagBeetlePower");
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
    public static final String IMG = DuelistMod.makePowerPath("NaturiaStagBeetlePower.png");
	
	public NaturiaStagBeetlePower(AbstractCreature owner, AbstractCreature source, int turns)
	{ 
		this.name = NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.type = PowerType.BUFF;
        this.isTurnBased = false;
        this.canGoNegative = false;
        this.img = new Texture(IMG);
        this.source = source;
        this.amount = turns;
		updateDescription(); 
	}
	
	@Override
	public void atStartOfTurn()
	{
		if (GameActionManager.turn%2 == 0)
		{
			this.amount = DuelistCard.powerTribute(AbstractDungeon.player, 0, true);
			updateDescription();
		}
		else
		{
			if (this.amount > 0)
			{
				AnyDuelist duelist = AnyDuelist.from(this);
				duelist.applyPowerToSelf(Util.vinesPower(this.amount2, duelist));
				updateDescription();
			}
		}
	}
	
	@Override
	public void atEndOfTurn(boolean isPlayer)
	{
		updateDescription();
	}

	@Override
	public void updateDescription()
	{
		if (this.amount < 0) { this.amount = 0; }
		if (GameActionManager.turn%2 == 0) { this.description = DESCRIPTIONS[1] + this.amount + DESCRIPTIONS[2]; } 
		else { this.description = DESCRIPTIONS[0]; }
	}

}
