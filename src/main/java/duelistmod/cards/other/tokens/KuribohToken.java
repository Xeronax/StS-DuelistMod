package duelistmod.cards.other.tokens;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.*;

import duelistmod.DuelistMod;
import duelistmod.abstracts.*;
import duelistmod.patches.AbstractCardEnum;
import duelistmod.variables.*;

public class KuribohToken extends TokenCard 
{
    // TEXT DECLARATION
    public static final String ID = DuelistMod.makeID("KuribohToken");
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String IMG = DuelistMod.makePath(Strings.KURIBOH_TOKEN);
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
    // /TEXT DECLARATION/

    // STAT DECLARATION
    private static final CardRarity RARITY = CardRarity.SPECIAL;
    private static final CardTarget TARGET = CardTarget.SELF;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = AbstractCardEnum.DUELIST;
    private static final int COST = 0;
    // /STAT DECLARATION/

    public KuribohToken() { super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET); this.tags.add(Tags.GOOD_TRIB); this.tags.add(Tags.TOKEN); this.tags.add(Tags.FIEND); this.tags.add(Tags.KURIBOH);this.purgeOnUse = true; this.summons = this.baseSummons = 1; this.baseMagicNumber = this.magicNumber = 1;}
    public KuribohToken(String tokenName) { super(ID, tokenName, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET); this.tags.add(Tags.GOOD_TRIB); this.tags.add(Tags.TOKEN); this.tags.add(Tags.FIEND); this.tags.add(Tags.KURIBOH); this.purgeOnUse = true; this.summons = this.baseSummons = 1; this.baseMagicNumber = this.magicNumber = 1;}
   
    @Override public void use(AbstractPlayer p, AbstractMonster m) 
    { 
    	summon(); 
    }
    
    @Override public AbstractCard makeCopy() { return new KuribohToken(); }
    
    @Override
    public void customOnTribute(DuelistCard tc)
    {
    	if ((tc == null || !tc.hasTag(Tags.DRAGON)) && !AbstractDungeon.player.hasPower(IntangiblePlayerPower.POWER_ID) && this.magicNumber > 0) { applyPowerToSelf(new IntangiblePlayerPower(AbstractDungeon.player, this.magicNumber));}
    }

	@Override public void upgrade() 
	{
		if (canUpgrade()) {
			if (this.timesUpgraded > 0) { this.upgradeName(NAME + "+" + this.timesUpgraded); }
	    	else { this.upgradeName(NAME + "+"); }
			this.upgradeSummons(1);
            this.rawDescription = UPGRADE_DESCRIPTION;
            this.fixUpgradeDesc();
            this.initializeDescription();
        }
	}
	

}
