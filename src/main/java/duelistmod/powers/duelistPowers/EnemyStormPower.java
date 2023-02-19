package duelistmod.powers.duelistPowers;

import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import duelistmod.actions.enemyDuelist.EnemyChannelAction;
import duelistmod.orbs.enemy.EnemyLightning;

public class EnemyStormPower extends AbstractPower {
    public static final String POWER_ID = "Storm";
    private static final PowerStrings powerStrings;
    public static final String NAME;
    public static final String[] DESCRIPTIONS;

    public EnemyStormPower(AbstractCreature owner, int amount) {
        this.name = NAME;
        this.ID = "Storm";
        this.owner = owner;
        this.amount = amount;
        this.updateDescription();
        this.loadRegion("storm");
    }

    public void onUseCard(AbstractCard card, UseCardAction action) {
        if (card.type == AbstractCard.CardType.POWER && this.amount > 0) {
            this.flash();

            for(int i = 0; i < this.amount; ++i) {
                this.addToBot(new EnemyChannelAction(new EnemyLightning()));
            }
        }

    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }

    static {
        powerStrings = CardCrawlGame.languagePack.getPowerStrings("Storm");
        NAME = powerStrings.NAME;
        DESCRIPTIONS = powerStrings.DESCRIPTIONS;
    }
}
