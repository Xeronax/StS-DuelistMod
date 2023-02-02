package duelistmod.actions.unique;

import java.util.*;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.*;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import duelistmod.*;
import duelistmod.abstracts.DuelistCard;
import duelistmod.cards.other.tempCards.CancelCard;
import duelistmod.helpers.GridSort;
import duelistmod.variables.Strings;

public class CallMummyAction extends AbstractGameAction
{
	private AbstractPlayer p;
	private boolean upgrade;
	private ArrayList<AbstractCard> cards;
	private boolean damageBlockRandomize = false;
	private boolean randomTarget = true;
	private AbstractMonster target;
	private boolean resummon = true;
	private boolean canCancel = false;

	public CallMummyAction(ArrayList<AbstractCard> cardsToChooseFrom, int amount, boolean upgraded, boolean randomizeBlockDamage, AbstractMonster m, boolean canCancel)
	{
		this.p = AbstractDungeon.player;
		this.actionType = AbstractGameAction.ActionType.CARD_MANIPULATION;
		this.duration = Settings.ACTION_DUR_MED;
		this.upgrade = upgraded;
		this.amount = amount;
		this.cards = cardsToChooseFrom;
		this.damageBlockRandomize = randomizeBlockDamage;
		this.target = m;
		this.randomTarget = false;
		this.canCancel = canCancel;
	}

	public void update()
	{
		CardGroup tmp;
		if (this.duration == Settings.ACTION_DUR_MED)
		{
			tmp = new CardGroup(CardGroup.CardGroupType.UNSPECIFIED);
			for (AbstractCard card : cards)
			{
				AbstractCard gridCard = card.makeStatEquivalentCopy();
				if (this.upgrade) { gridCard.upgrade(); }
				if (randomTarget) { this.target = AbstractDungeon.getRandomMonster(); }
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
		        gridCard.initializeDescription();
				tmp.addToTop(gridCard);
				if (DuelistMod.debug) { System.out.println("theDuelist:CardSelectScreenResummonAction:update() ---> added " + gridCard.originalName + " into grid selection pool"); }
			}
			
			Collections.sort(tmp.group, GridSort.getComparator());
			if (this.canCancel) { for (int i = 0; i < this.amount; i++) { tmp.addToTop(new CancelCard()); }}
			if (this.randomTarget && this.resummon)
			{
				if (this.amount == 1) { AbstractDungeon.gridSelectScreen.open(tmp, this.amount, Strings.configChooseString + this.amount + Strings.configResummonRandomlyString, false); }
				else { AbstractDungeon.gridSelectScreen.open(tmp, this.amount, Strings.configChooseString + this.amount + Strings.configResummonRandomlyPluralString, false); }
				tickDuration();
				return;
			}
			else if (!this.randomTarget && this.resummon)
			{
				if (this.amount == 1) { AbstractDungeon.gridSelectScreen.open(tmp, this.amount, Strings.configChooseString + this.amount + Strings.configResummonRandomlyTargetString, false); }
				else { AbstractDungeon.gridSelectScreen.open(tmp, this.amount, Strings.configChooseString + this.amount + Strings.configResummonRandomlyTargetPluralString, false); }
				tickDuration();
				return;
			}
			else if (this.randomTarget && !this.resummon)
			{
				if (this.amount == 1) { AbstractDungeon.gridSelectScreen.open(tmp, this.amount, Strings.configChooseString + this.amount + Strings.configCardPlayString, false); }
				else { AbstractDungeon.gridSelectScreen.open(tmp, this.amount, Strings.configChooseString + this.amount + Strings.configCardPlayPluralString, false); }
				tickDuration();
				return;
			}
			else if (!this.randomTarget && !this.resummon)
			{
				if (this.amount == 1) { AbstractDungeon.gridSelectScreen.open(tmp, this.amount, Strings.configChooseString + this.amount + Strings.configCardPlayTargetString, false); }
				else { AbstractDungeon.gridSelectScreen.open(tmp, this.amount, Strings.configChooseString + this.amount + Strings.configCardPlayTargetPluralString, false); }
				tickDuration();
				return;
			}
		}
		
		if ((AbstractDungeon.gridSelectScreen.selectedCards.size() != 0))
		{
			for (AbstractCard c : AbstractDungeon.gridSelectScreen.selectedCards)
			{
				c.unhover();
				c.stopGlowing();
				if (!(c instanceof CancelCard))
				{
					if (this.resummon && this.target != null)
					{
						DuelistCard.resummon(c, this.target, true);
					}
					else if (!this.resummon && this.target != null)
					{
						DuelistCard.playNoResummon((DuelistCard)c, false, this.target, false);
					}
				}
			}
			AbstractDungeon.gridSelectScreen.selectedCards.clear();
			this.p.hand.refreshHandLayout();
		}
		tickDuration();
	}
}
