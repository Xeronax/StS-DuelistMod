package defaultmod.powers;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.core.*;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;

import defaultmod.DefaultMod;
import defaultmod.cards.Mausoleum;


public class EmperorPower extends AbstractPower 
{
    public AbstractCreature source;
    public static final String POWER_ID = defaultmod.DefaultMod.makeID("EmperorPower");
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
    public static final String IMG = DefaultMod.makePath(DefaultMod.EMPEROR_POWER);
    private static int TURN_DMG = 1;
    public boolean flag = false;

    public EmperorPower(AbstractCreature owner, int newAmount) 
    {
        this.name = NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.amount = newAmount;
        this.updateDescription();
        this.img = new Texture(IMG);
        this.isTurnBased = false;
    }

    @Override
    public void atStartOfTurn() 
    {
    	flag = false;
    	Mausoleum.damageSelf(TURN_DMG);
    }
    
    @Override
	public void updateDescription() 
    {
    	this.description = DESCRIPTIONS[0] + TURN_DMG + DESCRIPTIONS[1];
    }
}