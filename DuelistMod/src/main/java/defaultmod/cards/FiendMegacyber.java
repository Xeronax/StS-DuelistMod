package defaultmod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import defaultmod.DefaultMod;
import defaultmod.patches.*;
import defaultmod.powers.*;

public class FiendMegacyber extends DuelistCard 
{
    // TEXT DECLARATION
    public static final String ID = defaultmod.DefaultMod.makeID("FiendMegacyber");
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String IMG = DefaultMod.makePath(DefaultMod.FIEND_MEGACYBER);
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
    // /TEXT DECLARATION/
    
    // STAT DECLARATION
    private static final CardRarity RARITY = CardRarity.COMMON;
    private static final CardTarget TARGET = CardTarget.ENEMY;
    private static final CardType TYPE = CardType.ATTACK;
    public static final CardColor COLOR = AbstractCardEnum.DEFAULT_GRAY;
    private static final AttackEffect AFX = AttackEffect.SLASH_HORIZONTAL;
    private static final int COST = 0;
    private static final int DAMAGE = 20;
    private static final int TRIBUTES = 1;
    private static final int U_TRIBUTES = -1;
    // /STAT DECLARATION/

    public FiendMegacyber() {
        super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
        this.baseDamage = DAMAGE;
        this.magicNumber = this.baseMagicNumber = TRIBUTES;
        this.tags.add(DefaultMod.MONSTER);
        this.misc = 0;
    }

    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) 
    {
    	tribute(p, this.magicNumber, false, this);
		
    	// Check if target has spell counters
		if (m.hasPower(SpellCounterPower.POWER_ID))
		{
        	// Get target spell counter count
	    	int counters = m.getPower(SpellCounterPower.POWER_ID).amount;
	    	if (counters >= 10) { attack(m, AFX, this.damage); }
		}
    }

    // Which card to return when making a copy of this card.
    @Override
    public AbstractCard makeCopy() {
        return new FiendMegacyber();
    }

    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(U_TRIBUTES);
            this.rawDescription = UPGRADE_DESCRIPTION;
            this.initializeDescription();
        }
    }
    
    // If player doesn't have enough summons, can't play card
 	@Override
 	public boolean canUse(AbstractPlayer p, AbstractMonster m)
 	{
 		// Check super canUse()
 		boolean canUse = super.canUse(p, m); 
 		if (!canUse) { return false; }
 		
 		// Pumpking & Princess
  		else if (this.misc == 52) { return true; }

 		// Check for # of summons >= tributes
 		else { if (p.hasPower(SummonPower.POWER_ID)) { int temp = (p.getPower(SummonPower.POWER_ID).amount); if (temp >= TRIBUTES) { return true; } } }

 		// Player doesn't have something required at this point
 		this.cantUseMessage = "Not enough Summons";
 		return false;
 	}
}