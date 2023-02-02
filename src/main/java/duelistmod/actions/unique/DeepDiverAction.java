package duelistmod.actions.unique;

import java.util.*;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.*;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardAndAddToHandEffect;

import basemod.BaseMod;
import duelistmod.*;
import duelistmod.abstracts.DuelistCard;
import duelistmod.helpers.GridSort;
import duelistmod.variables.Strings;

public class DeepDiverAction extends AbstractGameAction
{
	private AbstractPlayer p;
	private boolean upgrade;
	private ArrayList<AbstractCard> cards;
	private boolean randomize = false;
	private boolean etherealCheck = false;
	private boolean exhaustCheck = false;
	private boolean costChangeCheck = false;
	private boolean summonCheck = false;
	private boolean tributeCheck = false;
	private boolean summonChangeCombatCheck = false;
	private boolean tributeChangeCombatCheck = false;
	private boolean costChangeCombatCheck = false;
	private int lowCostRoll = 1;
	private int highCostRoll = 4;
	private int lowSummonRoll = 0;
	private int highSummonRoll = 0;
	private int lowTributeRoll = 0;
	private int highTributeRoll = 0;
	private boolean sendExtraToDiscard = false;
	private boolean damageBlockRandomize = false;

	public DeepDiverAction(boolean randomizeDamageAndBlock, ArrayList<AbstractCard> cardsToChooseFrom, boolean sendExtraToDiscard, int amount, boolean upgraded, boolean exhaust, boolean ethereal, boolean costChange, boolean summonCheck, boolean tributeCheck, boolean combat, int lowCost, int highCost, int lowTrib, int highTrib, int lowSummon, int highSummon)
	{
		this.p = AbstractDungeon.player;
		setValues(this.p, AbstractDungeon.player, 1);
		this.actionType = AbstractGameAction.ActionType.CARD_MANIPULATION;
		this.duration = Settings.ACTION_DUR_MED;
		this.upgrade = upgraded;
		this.amount = amount;
		this.cards = cardsToChooseFrom;
		this.randomize = true;
		this.exhaustCheck = exhaust;
		this.etherealCheck = ethereal;
		this.costChangeCheck = costChange;
		this.summonCheck = summonCheck;
		this.tributeCheck = tributeCheck;
		this.lowCostRoll = lowCost;
		this.highCostRoll = highCost;
		this.lowSummonRoll = lowSummon;
		this.highSummonRoll = highSummon;
		this.lowTributeRoll = lowTrib;
		this.highTributeRoll = highTrib;
		this.summonChangeCombatCheck = combat;
		this.tributeChangeCombatCheck = combat;
		this.costChangeCombatCheck = combat;
		this.sendExtraToDiscard = sendExtraToDiscard;
		this.damageBlockRandomize = randomizeDamageAndBlock;
	}
  
	public void update()
	{
		CardGroup tmp;
		if (this.duration == Settings.ACTION_DUR_MED)
		{
			tmp = new CardGroup(CardGroup.CardGroupType.UNSPECIFIED);
			for (AbstractCard gridCard : cards)
			{
				if (this.upgrade) { gridCard.upgrade(); }
				if (this.randomize)
				{
					if (!gridCard.isEthereal && etherealCheck) 
					{
		                gridCard.isEthereal = true;
		                gridCard.rawDescription = Strings.etherealForCardText + gridCard.rawDescription;
		    		}
		    		
		    		if (!gridCard.exhaust && exhaustCheck) 
		    		{
		                gridCard.exhaust = true;
		                gridCard.rawDescription = gridCard.rawDescription + DuelistMod.exhaustForCardText;
		    		}
		    		
		    		if (costChangeCheck && gridCard.cost > -1)
		    		{
		    			int randomNum = AbstractDungeon.cardRandomRng.random(lowCostRoll, highCostRoll);
		    			System.out.println("randomNum: " + randomNum);
		    			if (costChangeCombatCheck)
		    			{
		    				int gridCardBaseCost = gridCard.cost;
		    				gridCard.modifyCostForCombat(-gridCard.cost + randomNum);
			    			if (randomNum != gridCardBaseCost) { gridCard.isCostModified = true; }
		    			}
		    			else
		    			{
		    				int gridCardBaseCost = gridCard.cost;
		    				gridCard.setCostForTurn(-gridCard.cost + randomNum);
		    				if (randomNum != gridCardBaseCost) { gridCard.isCostModifiedForTurn = true; }
		    			}
		    		}       
		    		
		    		if (summonCheck && gridCard instanceof DuelistCard)
		    		{
		    			int randomNum = AbstractDungeon.cardRandomRng.random(lowSummonRoll, highSummonRoll);
		    			DuelistCard dC = (DuelistCard)gridCard;
		    			if (dC.isSummonCard())
		    			{
			    			if (summonChangeCombatCheck)
			    			{
			    				dC.modifySummons(randomNum);
			    			}
			    			else
			    			{
			    				dC.modifySummonsForTurn(randomNum);
			    			}
		    			}
		    		}
		    		
		    		if (tributeCheck && gridCard instanceof DuelistCard)
		    		{
		    			int randomNum = AbstractDungeon.cardRandomRng.random(lowTributeRoll, highTributeRoll);
		    			DuelistCard dC = (DuelistCard)gridCard;
		    			if (dC.isTributeCard())
		    			{
			    			if (tributeChangeCombatCheck)
			    			{
			    				dC.modifyTributes(-randomNum);
			    			}
			    			else
			    			{
			    				dC.modifyTributesForTurn(-randomNum);
			    			}
		    			}
		    		}
		    		
		    		if (damageBlockRandomize)
		    		{
		    			if (gridCard.damage > 0)
		    			{
		    				int low = gridCard.damage * -1;
		    				int high = gridCard.damage + 6;
		    				int roll = AbstractDungeon.cardRandomRng.random(low, high);
		    				AbstractDungeon.actionManager.addToTop(new ModifyDamageAction(gridCard.uuid, roll));
		    				gridCard.isDamageModified = true;
		    			}
		    			
		    			if (gridCard.block > 0)
		    			{
		    				int low = gridCard.block * -1;
		    				int high = gridCard.block + 6;
		    				int roll = AbstractDungeon.cardRandomRng.random(low, high);
		    				AbstractDungeon.actionManager.addToTop(new ModifyBlockAction(gridCard.uuid, roll));
		    				gridCard.isBlockModified = true;
		    			}
		    		}
					if (gridCard instanceof DuelistCard) {
						((DuelistCard)gridCard).fixUpgradeDesc();
					}
		            gridCard.initializeDescription();
				}
				tmp.addToTop(gridCard);
				if (DuelistMod.debug)
				{
					System.out.println("theDuelist:DeepDiverAction:update() ---> added " + gridCard.originalName + " into grid selection pool");
				}
			}
			
			Collections.sort(tmp.group, GridSort.getComparator());
			if (this.amount >= tmp.group.size())
			{
				for (AbstractCard c : tmp.group)
				{
					if (this.p.hand.size() == BaseMod.MAX_HAND_SIZE)
					{
						this.p.createHandIsFullDialog();
						if (sendExtraToDiscard) { this.p.discardPile.addToTop(cardCopy(c)); }
					}
					else
					{
						AbstractDungeon.effectList.add(new ShowCardAndAddToHandEffect(cardCopy(c)));
					}
					this.p.hand.refreshHandLayout();
					this.p.hand.applyPowers();
				}
				
				AbstractDungeon.gridSelectScreen.selectedCards.clear();
				this.p.hand.refreshHandLayout();
			}
			
			else
			{
				if (this.amount == 1) { AbstractDungeon.gridSelectScreen.open(tmp, this.amount, Strings.configChooseString + this.amount + Strings.configAddCardHandString, false); }
				else { AbstractDungeon.gridSelectScreen.open(tmp, this.amount, Strings.configChooseString + this.amount + Strings.configAddCardHandPluralString, false); }
			}
			tickDuration();
			return;
		}
		
		// If there are more cards to add to hand still and player hand has space, or if there are still cards to hand and we intend to discard them if the players hand has no space
		if ((AbstractDungeon.gridSelectScreen.selectedCards.size() != 0 && this.p.hand.size() < BaseMod.MAX_HAND_SIZE) || (AbstractDungeon.gridSelectScreen.selectedCards.size() != 0 && sendExtraToDiscard))
		{
			for (AbstractCard c : AbstractDungeon.gridSelectScreen.selectedCards)
			{
				c.unhover();
				c.stopGlowing();
				if (this.p.hand.size() == BaseMod.MAX_HAND_SIZE)
				{
					this.p.createHandIsFullDialog();
					if (sendExtraToDiscard) { this.p.discardPile.addToTop(cardCopy(c)); }
				}
				else
				{
					AbstractDungeon.effectList.add(new ShowCardAndAddToHandEffect(cardCopy(c)));
				}
				this.p.hand.refreshHandLayout();
				this.p.hand.applyPowers();
			}
			AbstractDungeon.gridSelectScreen.selectedCards.clear();
			this.p.hand.refreshHandLayout();
		}
		tickDuration();
	}
	
	private AbstractCard cardCopy(AbstractCard c)
	{
		AbstractCard retCard = c.makeStatEquivalentCopy();
		if (c.exhaust && !retCard.exhaust)
		{
			retCard.exhaust = true;
			retCard.rawDescription = retCard.rawDescription + DuelistMod.exhaustForCardText;
			if (retCard instanceof DuelistCard) {
				((DuelistCard)retCard).fixUpgradeDesc();
			}
			retCard.initializeDescription();
		}
		return retCard;
	}
}
