package duelistmod.cards.pools.naturia;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import duelistmod.DuelistMod;
import duelistmod.abstracts.DuelistCard;
import duelistmod.dto.AnyDuelist;
import duelistmod.helpers.Util;
import duelistmod.patches.AbstractCardEnum;
import duelistmod.powers.duelistPowers.VinesPower;
import duelistmod.variables.Tags;

public class SeedSacredTree extends DuelistCard 
{
    // TEXT DECLARATION
    public static final String ID = DuelistMod.makeID("SeedSacredTree");
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String IMG = DuelistMod.makeCardPath("SeedSacredTree.png");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
    // /TEXT DECLARATION/

    // STAT DECLARATION
    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.SELF;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = AbstractCardEnum.DUELIST_SPELLS;
    private static final int COST = -2;
    // /STAT DECLARATION/

    public SeedSacredTree() {
        super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
        this.baseMagicNumber = this.magicNumber = 3;	// Vines
        this.baseSecondMagic = this.secondMagic = 2;	// Self-dmg
        this.selfRetain = true;
        this.tags.add(Tags.SPELL);
        this.originalName = this.name;
        this.enemyIntent = AbstractMonster.Intent.MAGIC;
    }
    
    @Override
    public void onRetained() {
        AnyDuelist duelist = AnyDuelist.from(this);
        duelist.applyPowerToSelf(Util.vinesPower(this.magicNumber, duelist));
        duelist.damageSelfNotHP(this.secondMagic);
    }

    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) 
    {
    	
    }

    // Which card to return when making a copy of this card.
    @Override
    public AbstractCard makeCopy() {
        return new SeedSacredTree();
    }

    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(2);
            this.rawDescription = UPGRADE_DESCRIPTION;
            this.fixUpgradeDesc();
            this.initializeDescription();
        }
    }

    @Override
    public boolean canUse(AbstractPlayer p, AbstractMonster m) { return false; }













}
