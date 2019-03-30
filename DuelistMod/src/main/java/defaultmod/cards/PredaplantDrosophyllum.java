package defaultmod.cards;

import java.util.ArrayList;

import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.cards.*;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import defaultmod.DefaultMod;
import defaultmod.patches.*;
import defaultmod.powers.*;

public class PredaplantDrosophyllum extends DuelistCard 
{
    // TEXT DECLARATION
    public static final String ID = DefaultMod.makeID("PredaplantDrosophyllum");
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String IMG = DefaultMod.makePath(DefaultMod.PREDAPLANT_DROSOPHYLLUM);
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
    // /TEXT DECLARATION/
    
    // STAT DECLARATION
    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.ENEMY;
    private static final CardType TYPE = CardType.ATTACK;
    public static final CardColor COLOR = AbstractCardEnum.DUELIST_MONSTERS;
    private static final AttackEffect AFX = AttackEffect.POISON;
    private static final int COST = 2;
    // /STAT DECLARATION/

    public PredaplantDrosophyllum() {
        super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
        this.tags.add(DefaultMod.MONSTER);
        this.tags.add(DefaultMod.PREDAPLANT);
        this.tags.add(DefaultMod.ALL);
        this.tags.add(DefaultMod.INSECT);
        this.tags.add(DefaultMod.PLANT);
        this.tags.add(DefaultMod.GOOD_TRIB);
        this.tributes = 2;
		this.originalName = this.name;
		this.baseDamage = this.damage = 16;
    }

    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) 
    {
    	ArrayList<AbstractCard> handCards = new ArrayList<AbstractCard>();
    	for (AbstractCard a : p.hand.group) { if (a.hasTag(DefaultMod.PLANT) && !a.equals(this) && !a.hasTag(DefaultMod.EXEMPT)) { handCards.add(a); }}  
    	ArrayList<DuelistCard> tributeList = tribute(p, this.tributes, false, this);
    	attack(m, AFX, this.damage);
    	if (tributeList.size() > 0 && handCards.size() > 0)
    	{
    		for (DuelistCard c : tributeList)
    		{
    			if (c.hasTag(DefaultMod.PREDAPLANT))
    			{
    				if (!this.upgraded)
    				{
	    				DuelistCard summon = (DuelistCard) returnRandomFromArrayAbstract(handCards);  	
			    		DuelistCard cardCopy = DuelistCard.newCopyOfMonster(summon.originalName);
						if (cardCopy != null)
						{
							if (!cardCopy.tags.contains(DefaultMod.TRIBUTE)) { cardCopy.misc = 52; }
							if (summon.upgraded) { cardCopy.upgrade(); }
							cardCopy.freeToPlayOnce = true;
							cardCopy.applyPowers();
							cardCopy.purgeOnUse = true;
							AbstractDungeon.actionManager.cardQueue.add(new CardQueueItem(cardCopy, m));
							cardCopy.onResummon(1);
							cardCopy.checkResummon();
						}
    				}
    				else
    				{
    					for (AbstractCard plant : handCards)
    					{
    						DuelistCard cardCopy = DuelistCard.newCopyOfMonster(plant.originalName);
    						if (cardCopy != null)
    						{
    							if (!cardCopy.tags.contains(DefaultMod.TRIBUTE)) { cardCopy.misc = 52; }
    							if (plant.upgraded) { cardCopy.upgrade(); }
    							cardCopy.freeToPlayOnce = true;
    							cardCopy.applyPowers();
    							cardCopy.purgeOnUse = true;
    							AbstractDungeon.actionManager.cardQueue.add(new CardQueueItem(cardCopy, m));
    							cardCopy.onResummon(1);
    							cardCopy.checkResummon();
    						}
    					}
    				}
    			}
    		}
    	}
    }

    // Which card to return when making a copy of this card.
    @Override
    public AbstractCard makeCopy() {
        return new PredaplantDrosophyllum();
    }

    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            //this.upgradeDamage(3);
            this.tributes = 3;
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
    	
  		// Mausoleum check
    	else if (p.hasPower(EmperorPower.POWER_ID))
		{
			EmperorPower empInstance = (EmperorPower)p.getPower(EmperorPower.POWER_ID);
			if (!empInstance.flag)
			{
				return true;
			}
			else
			{
				if (p.hasPower(SummonPower.POWER_ID)) { int temp = (p.getPower(SummonPower.POWER_ID).amount); if (temp >= this.tributes) { return true; } }
			}
		}
    	
    	// Check for # of summons >= tributes
    	else { if (p.hasPower(SummonPower.POWER_ID)) { int temp = (p.getPower(SummonPower.POWER_ID).amount); if (temp >= this.tributes) { return true; } } }
    	
    	// Player doesn't have something required at this point
    	this.cantUseMessage = this.tribString;
    	return false;
    }

	@Override
	public void onTribute(DuelistCard tributingCard) 
	{
		// Check for insect
		if (player().hasPower(VioletCrystalPower.POWER_ID) && tributingCard.hasTag(DefaultMod.INSECT)) { poisonAllEnemies(player(), 5); }
		else if (tributingCard.hasTag(DefaultMod.INSECT)) { poisonAllEnemies(player(), 3); }
	}


	@Override
	public void onResummon(int summons) {
		// TODO Auto-generated method stub
		
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