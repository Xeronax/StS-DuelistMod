package duelistmod.cards.other.orbCards;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.orbs.AbstractOrb;

import duelistmod.*;
import duelistmod.abstracts.DuelistCard;
import duelistmod.interfaces.*;
import duelistmod.orbs.Glitch;
import duelistmod.patches.*;
import duelistmod.variables.*;

public class GlitchOrbCard extends DuelistCard  implements OrbCard
{
    // TEXT DECLARATION
    public static final String ID = DuelistMod.makeID("GlitchOrbCard");
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String IMG = DuelistMod.makeCardPath("GlitchOrbCard.png");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
    // /TEXT DECLARATION/

    // STAT DECLARATION
    private static final CardRarity RARITY = CardRarity.SPECIAL;
    private static final CardTarget TARGET = CardTarget.SELF;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = AbstractCardEnum.DUELIST_SPELLS;
    private static final int COST = 0;
    // /STAT DECLARATION/

    public GlitchOrbCard() {
        super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
        this.tags.add(Tags.ORB_CARD);
        this.tags.add(Tags.NO_METRONOME);
        this.originalName = this.name;
        this.dontTriggerOnUseCard = true;
		this.showEvokeValue = true;
		this.showEvokeOrbCount = 1;
    }

    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) 
    {
    	AbstractOrb orb = new Glitch();
    	channel(orb);
    }

    // Which card to return when making a copy of this card.
    @Override
    public AbstractCard makeCopy() 
    {
        return new GlitchOrbCard();
    }

    
    // Upgraded stats.
    @Override
    public void upgrade() 
    {
       
    }

	@Override
	public void onTribute(DuelistCard tributingCard) 
	{
		
		
	}


	@Override
	public void onResummon(int summons) 
	{
		
		
	}

	@Override
	public void summonThis(int summons, DuelistCard c, int var) 
	{
		
	}

	@Override
	public void summonThis(int summons, DuelistCard c, int var, AbstractMonster m) 
	{
		
	}

	@Override
	public String getID() {
		return ID;
	}

	@Override
	public void optionSelected(AbstractPlayer arg0, AbstractMonster arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
}