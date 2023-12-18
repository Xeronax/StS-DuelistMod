package duelistmod.cards.pools.insects;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.PoisonPower;

import duelistmod.DuelistMod;
import duelistmod.abstracts.DuelistCard;
import duelistmod.cards.other.statuses.ColdBlooded;
import duelistmod.patches.AbstractCardEnum;
import duelistmod.variables.Tags;

public class ReptiliannePoison extends DuelistCard {
    public static final String ID = DuelistMod.makeID("ReptiliannePoison");
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String IMG = DuelistMod.makeCardPath("ReptiliannePoison.png");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;

    private static final CardRarity RARITY = CardRarity.COMMON;
    private static final CardTarget TARGET = CardTarget.ENEMY;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = AbstractCardEnum.DUELIST_SPELLS;
    private static final int COST = 1;

    public ReptiliannePoison() {
        super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
        this.originalName = this.name;
        this.baseMagicNumber = this.magicNumber = 9;
        this.secondMagic = this.baseSecondMagic = 2;
        this.misc = 0;
        this.tags.add(Tags.SPELL);
        this.tags.add(Tags.ARCANE);
        this.cardsToPreview = new ColdBlooded();
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
    	applyPower(new PoisonPower(m, p, this.magicNumber), m);
    	this.addToBot(new MakeTempCardInDrawPileAction(new ColdBlooded(), this.secondMagic, true, true));
    }

    @Override
    public void upgrade() {
        if (canUpgrade()) {
        	if (this.timesUpgraded > 0) { this.upgradeName(NAME + "+" + this.timesUpgraded); }
	    	else { this.upgradeName(NAME + "+"); }
        	this.upgradeMagicNumber(2);
            this.rawDescription = UPGRADE_DESCRIPTION;
            this.fixUpgradeDesc();
            this.initializeDescription();
        }
    }
    
    @Override
    public boolean canUpgrade() {
        return this.magicNumber < 12;
    }

	@Override
    public AbstractCard makeCopy() {
        return new ReptiliannePoison();
    }

}
