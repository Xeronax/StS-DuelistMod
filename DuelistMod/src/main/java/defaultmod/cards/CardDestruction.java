package defaultmod.cards;

import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import defaultmod.DefaultMod;
import defaultmod.actions.unique.CardDestructionAction;
import defaultmod.patches.*;

public class CardDestruction extends DuelistCard 
{
    // TEXT DECLARATION
    public static final String ID = defaultmod.DefaultMod.makeID("CardDestruction");
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String IMG = DefaultMod.makePath(DefaultMod.CARD_DESTRUCTION);
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
    // /TEXT DECLARATION/

    // STAT DECLARATION
    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.NONE;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = AbstractCardEnum.DEFAULT_GRAY;
    private static final int COST = 2;
    private static final int CARDS = 1;
    // /STAT DECLARATION/

    public CardDestruction() {
        super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
        this.magicNumber = this.baseMagicNumber = CARDS;
        this.exhaust = true;
        this.tags.add(DefaultMod.SPELL);
        this.tags.add(DefaultMod.GENERATION_DECK);
		this.startingGenDeckCopies = 1;
        this.originalName = this.name;
        this.setupStartingCopies();
    }

    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) 
    {
    	// Record hand size
    	int handSize = AbstractDungeon.player.hand.size() - 1;
    	if (handSize < 0) { handSize = 0; }
    	
    	// Discard all cards
    	AbstractDungeon.actionManager.addToTop(new DiscardAction(p, p, handSize, true));
    	
    	// Copy all into random 0-cost, exhaust Duelist Cards
    	for (int i = 0; i < handSize; i++)
    	{
    		AbstractDungeon.actionManager.addToBottom(new CardDestructionAction(this.upgraded));
    	}
    	
    	/*
    	if (!this.upgraded)
    	{
	    	// For each discarded card, add a random card to hand
	    	for (int i = 0; i < handSize; i++)
	    	{
	    	
	    		DuelistCard randomMonster = (DuelistCard) returnTrulyRandomDuelistCard();
				randomMonster.costForTurn = 0;
				randomMonster.isCostModifiedForTurn = true;
				randomMonster.exhaust = true;
				randomMonster.rawDescription = randomMonster.rawDescription + " NL Exhaust.";
				randomMonster.initializeDescription();
				addCardToHand(randomMonster);
				
	    		AbstractDungeon.actionManager.addToTop(new CardDestructionAction(false));
	    	}
    	}
    	else
    	{
    		// For each discarded card, add 1 random upgraded card to hand
	    	for (int i = 0; i < handSize; i++)
	    	{
	    		
	    		DuelistCard randomMonster = (DuelistCard) returnTrulyRandomDuelistCard();
				randomMonster.costForTurn = 0;
				randomMonster.isCostModifiedForTurn = true;
				randomMonster.upgrade();
				randomMonster.exhaust = true;
				randomMonster.rawDescription = randomMonster.rawDescription + " NL Exhaust.";
				randomMonster.initializeDescription();
				addCardToHand(randomMonster);
			
	    	}
    	}
    	*/
    }

    // Which card to return when making a copy of this card.
    @Override
    public AbstractCard makeCopy() {
        return new CardDestruction();
    }

    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.rawDescription = UPGRADE_DESCRIPTION;
            this.initializeDescription();
        }
    }

	@Override
	public void onTribute(DuelistCard tributingCard) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void onResummon(int summons) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void summonThis(int summons, DuelistCard c, int var) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void summonThis(int summons, DuelistCard c, int var, AbstractMonster m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getID() {
		return ID;
	}
}