package duelistmod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.orbs.Frost;
import duelistmod.DuelistMod;
import duelistmod.abstracts.DuelistCard;
import duelistmod.dto.AnyDuelist;
import duelistmod.orbs.enemy.EnemyFrost;
import duelistmod.patches.AbstractCardEnum;
import duelistmod.variables.Tags;

import java.util.List;

public class BlizzardWarrior extends DuelistCard {
    public static final String ID = DuelistMod.makeID("BlizzardWarrior");
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String IMG = DuelistMod.makeCardPath("BlizzardWarrior.png");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;

    private static final CardRarity RARITY = CardRarity.COMMON;
    private static final CardTarget TARGET = CardTarget.ENEMY;
    private static final CardType TYPE = CardType.ATTACK;
    public static final CardColor COLOR = AbstractCardEnum.DUELIST_MONSTERS;
    private static final AttackEffect AFX = AttackEffect.SMASH;
    private static final int COST = 2;

    public BlizzardWarrior() {
        super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
        this.baseDamage = this.damage = 10;
        this.upgradeDmg = 4;
        this.summons = this.baseSummons = 1;
        this.showEvokeValue = true;
        this.showEvokeOrbCount = 2;
        this.baseMagicNumber = this.magicNumber = 2;
        this.isSummon = true;
        this.tags.add(Tags.MONSTER);
        this.tags.add(Tags.WARRIOR);
        this.tags.add(Tags.ALL);
        this.misc = 0;
        this.originalName = this.name;
        this.enemyIntent = AbstractMonster.Intent.ATTACK;
    }
    
    @Override
    public void update() {
		super.update();
    	this.showEvokeOrbCount = this.magicNumber;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        duelistUseCard(p, m);
    }

    @Override
    public void duelistUseCard(AbstractCreature owner, List<AbstractCreature> targets) {
        preDuelistUseCard(owner, targets);
        summon();
        if (targets.size() > 0) {
            attack(targets.get(0), AFX, this.damage);
        }
        AnyDuelist duelist =  AnyDuelist.from(this);
        AbstractOrb frost = duelist.player() ? new Frost() : new EnemyFrost();
        duelist.channel(frost, this.magicNumber);
        postDuelistUseCard(owner, targets);
    }

    @Override
    public AbstractCard makeCopy() {
        return new BlizzardWarrior();
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeDamage(this.upgradeDmg);
            if (DuelistMod.hasUpgradeBuffRelic) { this.upgradeBaseCost(1); }
            this.rawDescription = UPGRADE_DESCRIPTION;
            this.fixUpgradeDesc();
            this.initializeDescription();
        }
    }
}
