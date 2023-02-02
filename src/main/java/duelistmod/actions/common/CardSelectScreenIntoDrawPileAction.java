package duelistmod.actions.common;

import java.util.ArrayList;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.*;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.vfx.cardManip.*;

import basemod.BaseMod;
import duelistmod.*;
import duelistmod.abstracts.DuelistCard;
import duelistmod.variables.Strings;

public class CardSelectScreenIntoDrawPileAction extends AbstractGameAction
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
	private int lowCostRoll = 1;
	private int highCostRoll = 4;
	private int lowSummonRoll = 0;
	private int highSummonRoll = 0;
	private int lowTributeRoll = 0;
	private int highTributeRoll = 0;
  
	public CardSelectScreenIntoDrawPileAction(boolean upgraded, int amount, ArrayList<AbstractCard> cardsToChooseFrom)
	{
		this.p = AbstractDungeon.player;
		setValues(this.p, AbstractDungeon.player, 1);
		this.actionType = AbstractGameAction.ActionType.CARD_MANIPULATION;
		this.duration = Settings.ACTION_DUR_MED;
		this.upgrade = upgraded;
		this.amount = amount;
		this.cards = cardsToChooseFrom;
		this.randomize = false;
	}
	
	public CardSelectScreenIntoDrawPileAction(boolean upgraded, int amount, ArrayList<AbstractCard> cardsToChooseFrom, boolean randomize, boolean combat)
	{
		this.p = AbstractDungeon.player;
		setValues(this.p, AbstractDungeon.player, 1);
		this.actionType = AbstractGameAction.ActionType.CARD_MANIPULATION;
		this.duration = Settings.ACTION_DUR_MED;
		this.upgrade = upgraded;
		this.amount = amount;
		this.cards = cardsToChooseFrom;
		this.randomize = randomize;
		this.exhaustCheck = true;
		this.etherealCheck = true;
		this.costChangeCheck = true;
		this.summonCheck = true;
		this.tributeCheck = true;
		this.lowCostRoll = 1;
		this.highCostRoll = 5;
		this.lowSummonRoll = 0;
		this.highSummonRoll = 2;
		this.lowTributeRoll = 0;
		this.highTributeRoll = 1;
		this.summonChangeCombatCheck = combat;
		this.tributeChangeCombatCheck = combat;
	}
	
	public CardSelectScreenIntoDrawPileAction(ArrayList<AbstractCard> cardsToChooseFrom, int amount, boolean upgraded, boolean exhaust, boolean ethereal, boolean costChange)
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
	}
	
	public CardSelectScreenIntoDrawPileAction(ArrayList<AbstractCard> cardsToChooseFrom, int amount, boolean upgraded, boolean exhaust, boolean ethereal, boolean costChange, boolean summonCheck, boolean tributeCheck)
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
	}
	
	public CardSelectScreenIntoDrawPileAction(ArrayList<AbstractCard> cardsToChooseFrom, int amount, boolean upgraded, boolean exhaust, boolean ethereal, boolean costChange, boolean summonCheck, boolean tributeCheck, boolean combat, int lowCost, int highCost, int lowTrib, int highTrib, int lowSummon, int highSummon)
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
		    		
		    		if (costChangeCheck)
		    		{
		    			int randomNum = AbstractDungeon.cardRandomRng.random(lowCostRoll, highCostRoll);
		    			gridCard.costForTurn = randomNum;
		    			gridCard.isCostModifiedForTurn = true;
		    		}       
		    		
		    		if (summonCheck && gridCard instanceof DuelistCard)
		    		{
		    			int randomNum = AbstractDungeon.cardRandomRng.random(lowSummonRoll, highSummonRoll);
		    			DuelistCard dC = (DuelistCard)gridCard;
		    			if (summonChangeCombatCheck)
		    			{
		    				dC.modifySummons(randomNum);
		    			}
		    			else
		    			{
		    				dC.modifySummonsForTurn(randomNum);
		    			}
		    		}
		    		
		    		if (tributeCheck && gridCard instanceof DuelistCard)
		    		{
		    			int randomNum = AbstractDungeon.cardRandomRng.random(lowTributeRoll, highTributeRoll);
		    			DuelistCard dC = (DuelistCard)gridCard;
		    			if (tributeChangeCombatCheck)
		    			{
		    				dC.modifyTributes(-randomNum);
		    			}
		    			else
		    			{
		    				dC.modifyTributesForTurn(-randomNum);
		    			}
		    		}
					if (gridCard instanceof DuelistCard) {
						((DuelistCard)gridCard).fixUpgradeDesc();
					}
		            gridCard.initializeDescription();
				}
				tmp.addToTop(gridCard);
			}
			
			if (this.amount == 1) { AbstractDungeon.gridSelectScreen.open(tmp, this.amount, Strings.configChooseString + this.amount + Strings.configAddCardHandString, false); }
			else { AbstractDungeon.gridSelectScreen.open(tmp, this.amount, Strings.configChooseString + this.amount + Strings.configAddCardHandPluralString, false); }
			tickDuration();
			return;
		}
		if (AbstractDungeon.gridSelectScreen.selectedCards.size() != this.amount && this.p.hand.size() < BaseMod.MAX_HAND_SIZE)
		{
			for (AbstractCard c : AbstractDungeon.gridSelectScreen.selectedCards)
			{
				c.unhover();
				c.stopGlowing();
				if (this.p.hand.size() == BaseMod.MAX_HAND_SIZE)
				{
					this.p.createHandIsFullDialog();
					//this.p.discardPile.addToTop(c);
				}
				else
				{
					AbstractDungeon.effectList.add(new ShowCardAndAddToDrawPileEffect(c, true, false));
				}
				this.p.hand.refreshHandLayout();
				this.p.hand.applyPowers();
			}
			AbstractDungeon.gridSelectScreen.selectedCards.clear();
			this.p.hand.refreshHandLayout();
		}
		tickDuration();
	}
}
