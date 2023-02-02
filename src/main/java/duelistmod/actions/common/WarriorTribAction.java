package duelistmod.actions.common;

import java.util.*;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.*;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import duelistmod.DuelistMod;
import duelistmod.abstracts.DuelistCard;
import duelistmod.cards.other.tempCards.*;
import duelistmod.helpers.*;

public class WarriorTribAction extends AbstractGameAction
{
	private AbstractPlayer p;
	private ArrayList<DuelistCard> cards;
	private boolean randomTarget = true;
	private AbstractMonster target;
	private boolean resummon = true;
	private boolean canCancel = false;
  
	public WarriorTribAction(ArrayList<DuelistCard> cardsToChooseFrom)
	{
		this.p = AbstractDungeon.player;
		this.actionType = AbstractGameAction.ActionType.CARD_MANIPULATION;
		this.duration = Settings.ACTION_DUR_MED;
		this.amount = 1;
		this.cards = cardsToChooseFrom;
		this.resummon = true;
		this.canCancel = true;
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
				if (this.target == null) { Util.log("Is this it? Big bug guy? A"); }
				if (randomTarget || this.target == null) { this.target = AbstractDungeon.getRandomMonster(); }
		        gridCard.initializeDescription();
				tmp.addToTop(gridCard);
				if (DuelistMod.debug) { System.out.println("theDuelist:CardSelectScreenResummonAction:update() ---> added " + gridCard.originalName + " into grid selection pool"); }
			}
			
			Collections.sort(tmp.group, GridSort.getComparator());
			if (this.canCancel) { for (int i = 0; i < this.amount; i++) { tmp.addToTop(new CancelCard()); }}
			AbstractDungeon.gridSelectScreen.open(tmp, this.amount, "Warrior Tribute: Choose any Stance", false, false, false, false);
			tickDuration();
			return;
			
		}
		
		if ((AbstractDungeon.gridSelectScreen.selectedCards.size() != 0))
		{
			for (AbstractCard c : AbstractDungeon.gridSelectScreen.selectedCards)
			{
				c.unhover();
				c.stopGlowing();
				if (!(c instanceof CancelCard) && !(c instanceof SplendidCancel))
				{
					if (c instanceof DuelistCard && this.resummon && this.target != null)
					{
						DuelistCard.resummon(c, this.target);
						Util.log("CardSelectScreenResummonAction :: fullResummon triggered with " + c.name);
					}
					else if (c instanceof DuelistCard && !this.resummon && this.target != null)
					{
						DuelistCard.playNoResummon((DuelistCard)c, false, this.target, false);
						Util.log("CardSelectScreenResummonAction :: playNoResummon triggered with " + c.name);
					}
					
					else if (this.target == null)
					{
						DuelistCard.resummon(c, AbstractDungeon.getRandomMonster());
					}
				}
			}
			AbstractDungeon.gridSelectScreen.selectedCards.clear();
			this.p.hand.refreshHandLayout();
		}
		tickDuration();
	}
}
