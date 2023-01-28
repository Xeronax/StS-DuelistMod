package duelistmod.cards.metronomes.typed;

import java.util.ArrayList;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import duelistmod.DuelistMod;
import duelistmod.abstracts.*;
import duelistmod.cards.other.tempCards.CancelCard;
import duelistmod.patches.AbstractCardEnum;
import duelistmod.variables.Tags;

public class RareNatureMetronome extends MetronomeCard 
{
    // TEXT DECLARATION
    public static final String ID = getCARDID();
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    //public static final String IMG = DuelistMod.makeCardPath("MetronomeAttack.png");		// Attack
    public static final String IMG = DuelistMod.makeCardPath("Metronome.png");				// Skill
    //public static final String IMG = DuelistMod.makeCardPath("MetronomePower.png");		// Power
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
    // /TEXT DECLARATION/

    // STAT DECLARATION
    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.ENEMY;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = AbstractCardEnum.DUELIST_SPELLS;
    private static final int COST = 1;
    public final CardTags resTag;
    // /STAT DECLARATION/

    public RareNatureMetronome() {
        super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
        this.tags.add(Tags.ALLOYED);
        this.tags.add(Tags.EXEMPT);
        this.tags.add(Tags.METRONOME);
        this.tags.add(Tags.NEVER_GENERATE);
        this.tags.add(Tags.SPELL);
        this.baseMagicNumber = this.magicNumber = 1;
        this.originalName = this.name;       
        this.returnsMultiple = true;
        this.resTag = Tags.NATURIA;
    }

    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) 
    {
    	metronomeAction(m);
    }
    
    @Override
	public ArrayList<AbstractCard> returnCards()
	{
        if (this.magicNumber > 0) {
            ArrayList<AbstractCard> tmp = findAllOfTypeForResummon(this.resTag, Tags.INSECT, 1);
            tmp.addAll(findAllOfTypeForResummon(Tags.SPIDER, Tags.BUG, 1));
            tmp.addAll(findAllOfTypeForResummon(Tags.PLANT, Tags.PREDAPLANT, 1));
            while (tmp.size() > this.magicNumber) {
                tmp.remove(AbstractDungeon.cardRandomRng.random(tmp.size() - 1));
            }
            return tmp;
        }
        return new ArrayList<>();
	}
    
    public AbstractCard returnCard()
    {
		return new CancelCard();				
    }

    // Which card to return when making a copy of this card.
    @Override
    public AbstractCard makeCopy() {
        return new RareNatureMetronome();
    }

    // Upgraded stats.
    @Override
    public void upgrade() 
    {
        if (!upgraded)
        {
        	if (this.timesUpgraded > 0) { this.upgradeName(NAME + "+" + this.timesUpgraded); }
	    	else { this.upgradeName(NAME + "+"); }
            this.rawDescription = UPGRADE_DESCRIPTION;
            this.fixUpgradeDesc();
            this.initializeDescription();
        }
    }
    
    // AUTOSETUP - ID/IMG - Id, Img name, and class name all must match to use this
    public static String getCARDID()
    {
    	return DuelistMod.makeID(getCurClassName());
    }
    
	public static CardStrings getCardStrings()
    {
    	return CardCrawlGame.languagePack.getCardStrings(getCARDID());
    }
    
    public static String getIMG()
    {
    	return DuelistMod.makeCardPath(getCurClassName() + ".png");
    }
    
    public static String getCurClassName()
    {
    	return (new CurClassNameGetter()).getClassName();
    }

    public static class CurClassNameGetter extends SecurityManager{
    	public String getClassName(){
    		return getClassContext()[1].getSimpleName();
    	}
    }


	









}
