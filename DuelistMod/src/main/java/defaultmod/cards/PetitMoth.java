package defaultmod.cards;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.*;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import basemod.ReflectionHacks;
import defaultmod.DefaultMod;
import defaultmod.patches.*;
import defaultmod.powers.CocoonPower;

public class PetitMoth extends DuelistCard 
{
    // TEXT DECLARATION
    public static final String ID = DefaultMod.makeID("PetitMoth");
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String IMG = DefaultMod.makePath(DefaultMod.PETIT_MOTH);
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
    // /TEXT DECLARATION/

    // STAT DECLARATION
    private static final CardRarity RARITY = CardRarity.COMMON;
    private static final CardTarget TARGET = CardTarget.NONE;
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = AbstractCardEnum.DEFAULT_GRAY;
    private static final int COST = 1;
    private ArrayList<AbstractCard> tooltips;
    // /STAT DECLARATION/

    public PetitMoth() {
        super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
        this.baseBlock = this.block = 12;
        this.summons = 1;
        this.tags.add(DefaultMod.MONSTER);
        this.tags.add(DefaultMod.ALL);
        this.tags.add(DefaultMod.METAL_RAIDERS);
        this.tags.add(DefaultMod.GOOD_TRIB);
        this.originalName = this.name;
        this.isSummon = true;
        this.exhaust = true;
        tooltips = new ArrayList<>();
		tooltips.add(new CocoonRef());
		tooltips.add(new GreatRef());
    }

    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) 
    {
    	summon(p, this.summons, this);
    	block(this.block);
    }

    // Which card to return when making a copy of this card.
    @Override
    public AbstractCard makeCopy() {
        return new PetitMoth();
    }

    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(-1);
            this.rawDescription = UPGRADE_DESCRIPTION;
            this.initializeDescription();
        }
    }
    
    @Override
	public void renderCardTip(SpriteBatch sb) {
		super.renderCardTip(sb);
		boolean renderTip = (boolean) ReflectionHacks.getPrivate(this, AbstractCard.class, "renderTip");

		int count = 0;
		if (!Settings.hideCards && renderTip) {
			if (AbstractDungeon.player != null && AbstractDungeon.player.isDraggingCard) {
				return;
			}
			for (AbstractCard c : tooltips) {
				float dx = (AbstractCard.IMG_WIDTH * 0.9f - 5f) * drawScale;
				float dy = (AbstractCard.IMG_HEIGHT * 0.4f - 5f) * drawScale;
				if (current_x > Settings.WIDTH * 0.75f) {
					c.current_x = current_x + dx;
				} else {
					c.current_x = current_x - dx;
				}
				if (count == 0) {
					c.current_y = current_y + dy;
				} else {
					c.current_y = current_y - dy;
				}
				c.drawScale = drawScale * 0.8f;
				c.render(sb);
				count++;
			}
		}
	}

	@Override
	public void onTribute(DuelistCard tributingCard) 
	{
		if (tributingCard.hasTag(DefaultMod.COCOON))
		{
			if (tributingCard.upgraded)
			{
				if (player().hasPower(CocoonPower.POWER_ID))
				{
					CocoonPower power = (CocoonPower) player().getPower(CocoonPower.POWER_ID);
					power.amount++;
					power.updateDescription();
				}
				else { applyPowerToSelf(new CocoonPower(player(), player(), 0, 2)); }
			}
			
			else
			{
				if (player().hasPower(CocoonPower.POWER_ID))
				{
					CocoonPower power = (CocoonPower) player().getPower(CocoonPower.POWER_ID);
					power.amount++;
					power.updateDescription();
				}
				else { applyPowerToSelf(new CocoonPower(player(), player(), 0, 3)); }
			}
			
		}
	}


	@Override
	public void onResummon(int summons) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void summonThis(int summons, DuelistCard c, int var) 
	{

	}

	@Override
	public void summonThis(int summons, DuelistCard c, int var, AbstractMonster m) 
	{
	
	}

	@Override
	public String getID() {
		return ID;
	}
}