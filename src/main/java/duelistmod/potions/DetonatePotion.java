package duelistmod.potions;

import basemod.IUIElement;
import basemod.ModLabel;
import com.megacrit.cardcrawl.core.*;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.PowerTip;
import com.megacrit.cardcrawl.localization.PotionStrings;
import com.megacrit.cardcrawl.potions.AbstractPotion;

import duelistmod.DuelistMod;
import duelistmod.abstracts.*;
import duelistmod.dto.AnyDuelist;
import duelistmod.dto.DuelistConfigurationData;
import duelistmod.helpers.Util;
import duelistmod.variables.Colors;

import java.util.ArrayList;

public class DetonatePotion extends DuelistPotion {


    public static final String POTION_ID = DuelistMod.makeID("DetonatePotion");
    private static final PotionStrings potionStrings = CardCrawlGame.languagePack.getPotionString(POTION_ID);
    
    public static final String NAME = potionStrings.NAME;
    public static final String[] DESCRIPTIONS = potionStrings.DESCRIPTIONS;

    public DetonatePotion() {
        // The bottle shape and inside is determined by potion size and color. The actual colors are the main DefaultMod.java
    	super(NAME, POTION_ID, PotionRarity.UNCOMMON, PotionSize.BOLT, PotionEffect.OSCILLATE, Colors.BLACK, Colors.LIGHT_PURPLE, Colors.BLACK);
        
        // Potency is the damage/magic number equivalent of potions.
        this.potency = this.getPotency();
        
        // Initialize the Description
        this.description = DESCRIPTIONS[0] + this.potency + DESCRIPTIONS[1];
        
       // Do you throw this potion at an enemy or do you just consume it.
        this.isThrown = false;
        
        // Initialize the on-hover name + description
        //this.tips.add(new PowerTip(this.name, this.description));
        
    }

    
    
    @Override
    public boolean canSpawn()
    {
		boolean superCheck = super.canSpawn();
		if (!superCheck) return false;
    	if (Util.deckIs("Machine Deck")) { return true; }
    	return false;
    }

    @Override
    public void use(AbstractCreature target) 
    {
    	DuelistCard.detonationTributeStatic(AnyDuelist.from(AbstractDungeon.player), this.potency, false, false, 1, false);
    }
    
    @Override
    public AbstractPotion makeCopy() {
        return new DetonatePotion();
    }

    // This is your potency.
    @Override
    public int getPotency(final int potency) {
    	int pot = 3;
    	return pot;
    }
    
    @Override
    public void initializeData() {
        this.potency = this.getPotency();
        this.description =  DESCRIPTIONS[0] + this.potency + DESCRIPTIONS[1];
        this.tips.clear();
        this.tips.add(new PowerTip(this.name, this.description));
        this.tips.add(new PowerTip("Detonate", DESCRIPTIONS[2]));
    }
    
    public void upgradePotion()
    {
      this.potency += 1;
      this.tips.clear();
      this.tips.add(new PowerTip(this.name, this.description));
      this.tips.add(new PowerTip("Detonate", DESCRIPTIONS[2]));
    }
}
