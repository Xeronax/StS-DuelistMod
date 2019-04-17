package duelistmod.relics;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;

import basemod.abstracts.CustomRelic;
import duelistmod.*;
import duelistmod.powers.ToonWorldPower;

public class MillenniumEye extends CustomRelic {
    
    /*
     * https://github.com/daviscook477/BaseMod/wiki/Custom-Relics
     * 
     * Summon 1 on combat start
     */

    // ID, images, text.
    public static final String ID = duelistmod.DuelistMod.makeID("MillenniumEye");
    public static final String IMG = DuelistMod.makePath(Strings.M_EYE_RELIC);
    public static final String OUTLINE = DuelistMod.makePath(Strings.M_EYE_RELIC_OUTLINE);

    public MillenniumEye() {
        super(ID, new Texture(IMG), new Texture(OUTLINE), RelicTier.COMMON, LandingSound.MAGICAL);
    }

    // Summon 1 on turn start
    @Override
    public void atBattleStart() 
    {
        this.flash();
        AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new ToonWorldPower(AbstractDungeon.player, AbstractDungeon.player, 2, true)));
    
    }

    // Description
    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }

    // Which relic to return on making a copy of this relic.
    @Override
    public AbstractRelic makeCopy() {
        return new MillenniumEye();
    }

}