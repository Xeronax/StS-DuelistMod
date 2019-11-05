package duelistmod.actions.common;

import java.util.*;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.*;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import duelistmod.abstracts.DuelistCard;
import duelistmod.cards.other.tempCards.CancelCard;
import duelistmod.helpers.GridSort;
import duelistmod.variables.Tags;

public class CardSelectScreenModifyMagicNumberAction extends AbstractGameAction
{
	private AbstractPlayer p;
	private ArrayList<AbstractCard> cards;
	private boolean canCancel = false;
	private int magicBonus = 0;
	private HashMap<UUID, AbstractCard> originalMap = new HashMap<UUID, AbstractCard>();

	public CardSelectScreenModifyMagicNumberAction(ArrayList<AbstractCard> cardsToChooseFrom, int amount, int magic, boolean canCancel)
	{
		this.p = AbstractDungeon.player;
		this.actionType = AbstractGameAction.ActionType.CARD_MANIPULATION;
		this.duration = Settings.ACTION_DUR_MED;	
		this.amount = amount;
		this.cards = cardsToChooseFrom;
		this.canCancel = canCancel;
		this.magicBonus = magic;
	}

	public void update()
	{
		CardGroup tmp;
		if (this.duration == Settings.ACTION_DUR_MED)
		{
			tmp = new CardGroup(CardGroup.CardGroupType.UNSPECIFIED);
			for (AbstractCard c : cards) 
			{ 
				if (!c.hasTag(Tags.NO_MAGIC_MOD) && c.magicNumber > 0) 
				{
					AbstractCard copy = c.makeStatEquivalentCopy();
					tmp.addToTop(copy);
					originalMap.put(copy.uuid, c);
				}
			}
			Collections.sort(tmp.group, GridSort.getComparator());
			if (this.canCancel && tmp.group.size() > 0) { for (int i = 0; i < this.amount; i++) { tmp.addToTop(new CancelCard()); }}
			if (this.amount == 1 && tmp.group.size() > 0) { AbstractDungeon.gridSelectScreen.open(tmp, this.amount, "Choose " + this.amount + " Card to Modify", false); }
			else if (tmp.group.size() > 0) { AbstractDungeon.gridSelectScreen.open(tmp, this.amount,  "Choose " + this.amount + " Cards to Modify", false); }
			tickDuration();
			return;
		}
		
		if ((AbstractDungeon.gridSelectScreen.selectedCards.size() != 0))
		{
			for (AbstractCard c : AbstractDungeon.gridSelectScreen.selectedCards)
			{
				c.unhover();
				if (!(c instanceof CancelCard))
				{
					AbstractCard original = originalMap.get(c.uuid);
					if (original instanceof DuelistCard)
					{
						modify((DuelistCard) original, this.magicBonus);
					}
					else
					{
						original.baseMagicNumber += this.magicBonus;
						if (original.baseMagicNumber < 0) { original.baseMagicNumber = 0; }
						original.magicNumber = original.baseMagicNumber;
					}
				}
			}
			AbstractDungeon.gridSelectScreen.selectedCards.clear();
			this.p.hand.refreshHandLayout();
		}
		tickDuration();
	}
	
	private void modify(DuelistCard original, int magic)
	{
		if (original.hasTag(Tags.MAGIC_NUMBER_BUFFS_SCALE_BY_10)) { magic = magic * 10; }
		if (original.hasTag(Tags.BAD_MAGIC))
		{
			original.baseMagicNumber -= magic;
			if (original.baseMagicNumber < 0) { original.baseMagicNumber = 0; }
			original.magicNumber = original.baseMagicNumber;
			original.isMagicNumberModified = true;
		}
		else
		{
			original.baseMagicNumber += magic;
			if (original.baseMagicNumber < 0) { original.baseMagicNumber = 0; }
			original.magicNumber = original.baseMagicNumber;
			original.isMagicNumberModified = true;
		}
	}
}
