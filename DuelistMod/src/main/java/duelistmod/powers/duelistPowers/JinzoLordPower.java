package duelistmod.powers.duelistPowers;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.*;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import duelistmod.DuelistMod;
import duelistmod.abstracts.*;
import duelistmod.variables.*;



public class JinzoLordPower extends DuelistPower 
{
    public AbstractCreature source;
    public static final String POWER_ID = DuelistMod.makeID("JinzoLordPower");
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
    public static final String IMG = DuelistMod.makePath(Strings.JINZO_POWER);
    
    public JinzoLordPower(int amt)
    {
    	this(AbstractDungeon.player, AbstractDungeon.player, amt);
    }
    
    public JinzoLordPower(final AbstractCreature owner, final AbstractCreature source, int toonDmg) 
    {
        this.name = NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.type = PowerType.BUFF;
        this.isTurnBased = false;
        this.img = new Texture(IMG);
        this.source = source;
        this.amount = toonDmg;
        this.updateDescription();
    }
    
    @Override
    public void onPlayCard(AbstractCard c, AbstractMonster m) 
    {
    	if (c.hasTag(Tags.TRAP))
    	{
    		DuelistCard.damageAllEnemiesThornsNormal(this.amount);
    	}
    }
    
  
    @Override
	public void updateDescription() 
    {
    	this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }
}
