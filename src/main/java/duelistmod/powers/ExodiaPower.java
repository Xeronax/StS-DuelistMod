package duelistmod.powers;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.*;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;

import duelistmod.DuelistMod;
import duelistmod.abstracts.DuelistCard;
import duelistmod.cards.*;
import duelistmod.dto.AnyDuelist;
import duelistmod.helpers.Util;
import duelistmod.variables.Strings;


public class ExodiaPower extends AbstractPower 
{
	public AbstractCreature source;
	public static final String POWER_ID = DuelistMod.makeID("ExodiaPower");
	private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
	public static final String NAME = powerStrings.NAME;
	public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
	public static final String IMG = DuelistMod.makePath(Strings.EXODIA_POWER);
	private int effectDmg = 0;
	public ArrayList<DuelistCard> pieces = new ArrayList<DuelistCard>();
	
	public ExodiaPower(final AbstractCreature owner, final AbstractCreature source, DuelistCard piece) 
	{
		this.name = NAME;
		this.ID = POWER_ID;
		this.owner = owner;
		this.type = PowerType.BUFF;
		this.isTurnBased = false;
		this.img = new Texture(IMG);
		this.source = source;
		addPiece(piece);
		this.amount++; 
		this.updateDescription();		
	}
	
	public ExodiaPower()
	{
		this.name = NAME;
		this.ID = POWER_ID;
		this.owner = AbstractDungeon.player;
		this.type = PowerType.BUFF;
		this.isTurnBased = false;
		this.img = new Texture(IMG);
		this.source = AbstractDungeon.player;
		addPiece(new ExodiaLA());
		addPiece(new ExodiaLL());
		addPiece(new ExodiaRA());
		addPiece(new ExodiaRL());
		addPiece(new ExodiaHead());
		this.amount = 5;
		this.effectDmg = 25;
		this.updateDescription();	
	}
	
	public void headDamage(int dmg)
	{
		this.effectDmg += dmg;
		updateDescription();
	}
	
	@Override
    public void onDrawOrDiscard() 
    {
		if (this.amount != this.pieces.size()) { this.amount = this.pieces.size(); }
    }
	
	@Override
    public void atStartOfTurn() 
    {
		if (this.amount != this.pieces.size()) { this.amount = this.pieces.size(); }
    }
    
    @Override
    public void onPlayCard(AbstractCard c, AbstractMonster m) 
    {
    	if (this.amount != this.pieces.size()) { this.amount = this.pieces.size(); }
    }

	@Override
	public void atEndOfTurn(final boolean isPlayer) 
	{
		// If player has all 5 pieces
		if (checkForAllPieces())
		{
			// Setup copy of damage
			int newDmg = this.effectDmg;
			AnyDuelist duelist = AnyDuelist.from(this);

			// Manipulate damage value if player has Obliterate buff, and then remove the buff
			if (duelist.hasPower(ObliteratePower.POWER_ID))
			{
				newDmg = newDmg * 2;
				DuelistCard.removePower(duelist.getPower(ObliteratePower.POWER_ID), duelist.creature());
			}

			// Attack all enemies for the damage value, animation/sfx/afx are handled inside attack function
			DuelistCard.exodiaAttack(newDmg, duelist);
			
			// Remove either this power or a stack of Exodia Renewal buff if the player has it
			if (!duelist.hasPower(ExodiaRenewalPower.POWER_ID)) {
				DuelistCard.removePower(this, duelist.creature());
			}
        	else {
				DuelistCard.reducePower(duelist.getPower(ExodiaRenewalPower.POWER_ID), duelist.creature(), 1);
			}
		}
		
		updateDescription();
	}
	
	public void addNewPiece(DuelistCard piece)
	{
		if (!addPiece(piece)) { this.amount++; Util.log("Exodia Power incremented amount by 1"); }
		this.updateDescription();
	}
	
	public boolean addPiece(DuelistCard piece)
	{
		boolean found = false;
		for (DuelistCard c : pieces) {
			if (c.exodiaName.equals(piece.exodiaName)) {
				found = true;
				break;
			}
		}
		if (!found) { pieces.add(piece); }
		updateDescription();
		return found;
	}
	
	public boolean checkForAllPieces()
	{
		if (pieces.size() < 5) { return false; }
		else
		{
			if (!checkForPiece("Head"))   { 	return false; 	}
			if (!checkForPiece("Left Arm")) { 	return false; 	}
			if (!checkForPiece("Left Leg")) { 	return false;	}
			if (!checkForPiece("Right Arm")) { 	return false; 	}
			return checkForPiece("Right Leg");
		}
	}
	
	public boolean checkForAllPiecesButHead()
	{
		if (pieces.size() < 4) { return false; }
		else
		{
			if (!checkForPiece("Left Arm")) { return false; 	}
			if (!checkForPiece("Left Leg")) { return false;		}
			if (!checkForPiece("Right Arm")) { return false; 	}
			return checkForPiece("Right Leg");
		}
	}
	
	public boolean checkForPiece(String pieceName) {
		for (DuelistCard c : pieces) {
			if (c.exodiaName.equals(pieceName)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkForLegs()
	{
		return checkForPiece("Left Leg") && checkForPiece("Right Leg");
	}
	
	public boolean checkForArms()
	{
		return checkForPiece("Left Arm") && checkForPiece("Right Arm");
	}
	
	@Override
	public void updateDescription() 
	{
		if (this.amount != this.pieces.size()) { this.amount = this.pieces.size(); }
		if (this.amount == 0) 
		{ 
			this.description = DESCRIPTIONS[0] + DESCRIPTIONS[1] + 0;
		}
		else if (checkForAllPieces())
		{
			this.description = DESCRIPTIONS[2] + this.effectDmg;
		}
		else if (checkForLegs() && checkForArms())
		{
			this.description = DESCRIPTIONS[0] + DuelistMod.exodiaAlmostAllString;
		}
		else if (checkForLegs() && !checkForArms())
		{
			String descr = DuelistMod.exodiaBothLegsString;
			if (checkForPiece("Left Arm")) { descr += DuelistMod.exodiaLeftArmString; }
			if (checkForPiece("Right Arm")) { descr += DuelistMod.exodiaRightArmString; }
			int endingIndex = descr.lastIndexOf(",");
	        String finalPiece = descr.substring(0, endingIndex) + ".";
			this.description = DESCRIPTIONS[0] + finalPiece;
		}
		else if (checkForArms() && !checkForLegs())
		{
			String descr = DuelistMod.exodiaBothArmsString;
			if (checkForPiece("Left Leg")) { descr += DuelistMod.exodiaLeftLegString; }
			if (checkForPiece("Right Leg")) { descr += DuelistMod.exodiaRightLegString; }
			int endingIndex = descr.lastIndexOf(",");
	        String finalPiece = descr.substring(0, endingIndex) + ".";
			this.description = DESCRIPTIONS[0] + finalPiece;
		}
		else
		{
			StringBuilder pieceString = new StringBuilder();
			for (DuelistCard c : pieces) { pieceString.append(c.exodiaName).append(", "); }
			int endingIndex = pieceString.lastIndexOf(",");
	        String finalPiece = pieceString.substring(0, endingIndex) + ".";
			this.description = DESCRIPTIONS[0] + finalPiece;
		}
		
	}
}
