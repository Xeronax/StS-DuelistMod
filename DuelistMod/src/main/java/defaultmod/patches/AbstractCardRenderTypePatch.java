package defaultmod.patches;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evacipated.cardcrawl.modthespire.lib.*;
import com.evacipated.cardcrawl.modthespire.patcher.PatchingException;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.helpers.FontHelper;
import defaultmod.DefaultMod;
import javassist.CannotCompileException;
import javassist.CtBehavior;
import java.util.ArrayList;

@SpirePatch(clz=AbstractCard.class,method="renderType")
public class AbstractCardRenderTypePatch 
{
    @SpireInsertPatch(localvars={"text"},locator = Locator.class)
    public static void Insert(AbstractCard __instance, SpriteBatch sb, @ByRef String[] text) 
    {
        boolean isSpell = DefaultMod.isSpell(__instance);
        boolean isTrap = DefaultMod.isTrap(__instance);
        boolean isMonster = DefaultMod.isMonster(__instance);
        boolean isToken = DefaultMod.isToken(__instance);
        boolean isArchetype = DefaultMod.isArchetype(__instance);
        
        if (isMonster) 			{ text[0] = "Monster"; 	} 
        else if (isTrap) 		{ text[0] = "Trap";  	} 
        else if (isSpell) 		{ text[0] = "Spell";    }
        else if (isToken)		{ text[0] = "Token"; 	}
        else if (isArchetype)	{ text[0] = "Set";}
    }

    public static class Locator extends SpireInsertLocator 
    {
        public int[] Locate(CtBehavior ctMethodToPatch) throws CannotCompileException, PatchingException 
        {
            Matcher finalMatcher = new Matcher.MethodCallMatcher(FontHelper.class, "renderRotatedText");
            return LineFinder.findInOrder(ctMethodToPatch, new ArrayList<>(), finalMatcher);
        }
    }
}
