package duelistmod.actions.common;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.*;
import com.megacrit.cardcrawl.cards.AbstractCard.CardTags;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import duelistmod.abstracts.DuelistCard;
import duelistmod.variables.Strings;

public class FetchFromTag extends AbstractGameAction
{
	private AbstractPlayer p;
	private boolean upgrade = false;
	private CardTags searchTag;
	private CardGroup source;
	
	public FetchFromTag(int amount, CardGroup source, CardTags tag)
	{
		this.p = AbstractDungeon.player;
		setValues(this.p, AbstractDungeon.player, amount);
		this.actionType = AbstractGameAction.ActionType.CARD_MANIPULATION;
		this.duration = Settings.ACTION_DUR_MED;
		this.searchTag = tag;
		this.source = source;
	}

	public FetchFromTag(int amount, CardGroup source, CardTags tag, boolean upgraded)
	{
		this.p = AbstractDungeon.player;
		setValues(this.p, AbstractDungeon.player, amount);
		this.actionType = AbstractGameAction.ActionType.CARD_MANIPULATION;
		this.duration = Settings.ACTION_DUR_MED;
		this.upgrade = upgraded;
		this.searchTag = tag;
		this.source = source;
	}


	public void update() {
		CardGroup tmp;
		if (this.duration == Settings.ACTION_DUR_MED) 
		{
			tmp = new CardGroup(CardGroup.CardGroupType.UNSPECIFIED);
			for (AbstractCard c : source.group) 
			{
				if (c.hasTag(this.searchTag))
				{
					tmp.addToRandomSpot(c);
				}
			}

			// No cards in discard pile
			if (tmp.size() == 0) 
			{
				this.isDone = true;
				return; 
			}
			
			// Only 1 card in draw pile
			if (tmp.size() == 1) 
			{
				AbstractCard card = tmp.getTopCard();
				if (this.upgrade) { card.upgrade(); }
				DuelistCard.addCardToHand(card);
				source.removeCard(card);
				this.isDone = true;
				return; 
			}
			
			// Not enough cards in draw to satisfy requested # cards, but some cards in draw
			if (tmp.size() <= this.amount) 
			{
				for (int i = 0; i < tmp.size(); i++) 
				{
					AbstractCard card = tmp.getNCardFromTop(i);
					if (this.upgrade) { card.upgrade(); }
					DuelistCard.addCardToHand(card);
					source.removeCard(card);
				}
				this.isDone = true;
				return;
			}

			// Open card selection window
			if (this.amount == 1) 
			{
				AbstractDungeon.gridSelectScreen.open(tmp, this.amount, Strings.configChooseAString + searchTag.name().toLowerCase() + Strings.configAddCardHandString, false);
			} 
			else 
			{
				AbstractDungeon.gridSelectScreen.open(tmp, this.amount, Strings.configChooseString + this.amount + " " + searchTag.name().toLowerCase() + Strings.configAddCardHandPluralString, false);
			}
			tickDuration();
			return;
		}



		if (AbstractDungeon.gridSelectScreen.selectedCards.size() != 0)
		{
			for (AbstractCard c : AbstractDungeon.gridSelectScreen.selectedCards) 
			{
				c.unhover();
				c.stopGlowing();
				if (this.upgrade) { c.upgrade(); }
				DuelistCard.addCardToHand(c);
				source.removeCard(c);
			
			}
			AbstractDungeon.gridSelectScreen.selectedCards.clear();
		}
		tickDuration();
	}
}


