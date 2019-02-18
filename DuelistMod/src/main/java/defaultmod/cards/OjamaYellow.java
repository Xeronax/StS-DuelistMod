package defaultmod.cards;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import defaultmod.DefaultMod;
import defaultmod.patches.*;

public class OjamaYellow extends DuelistCard 
{
    // TEXT DECLARATION
    public static final String ID = defaultmod.DefaultMod.makeID("OjamaYellow");
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String IMG = DefaultMod.makePath(DefaultMod.OJAMA_YELLOW);
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
    // /TEXT DECLARATION/

    // STAT DECLARATION
    private static final CardRarity RARITY = CardRarity.COMMON;
    private static final CardTarget TARGET = CardTarget.NONE;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = AbstractCardEnum.DEFAULT_GRAY;
    private static final int COST = 0;
    private static final int SUMMONS = 1;
    private static final int CARDS = 2;
    // /STAT DECLARATION/

    public OjamaYellow() {
        super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
        this.baseMagicNumber = this.magicNumber = CARDS;
        this.tags.add(DefaultMod.MONSTER);
        this.tags.add(DefaultMod.OJAMA);
		this.originalName = this.name;
		this.exhaust = true;
    }

    
    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) 
    {
    	summon(p, SUMMONS);
		
		// Add random cards to hand
		for (int i = 0; i < this.magicNumber; i++)
		{
			//AbstractCard card = AbstractDungeon.returnTrulyRandomCardInCombat().makeCopy();
			DuelistCard randomMonster = (DuelistCard) returnTrulyRandomFromSet(DefaultMod.MONSTER);
			int randomNum = AbstractDungeon.cardRandomRng.random(1, 3);
			//card.costForTurn = randomNum;
			randomMonster.costForTurn = randomNum;
			randomMonster.isEthereal = true;
			randomMonster.rawDescription = "Ethereal. NL " + randomMonster.rawDescription;
			addCardToHand(randomMonster);
		}
    }

    // Which card to return when making a copy of this card.
    @Override
    public AbstractCard makeCopy() {
        return new OjamaYellow();
    }

    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(2);
            //this.upgradeBaseCost(0);
            this.rawDescription = UPGRADE_DESCRIPTION;
            this.initializeDescription();
        }
    }
}