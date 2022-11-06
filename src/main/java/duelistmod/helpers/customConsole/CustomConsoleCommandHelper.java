package duelistmod.helpers.customConsole;

import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.orbs.Dark;
import com.megacrit.cardcrawl.orbs.Frost;
import com.megacrit.cardcrawl.orbs.Lightning;
import com.megacrit.cardcrawl.orbs.Plasma;
import duelistmod.abstracts.DuelistCard;
import duelistmod.helpers.Util;
import duelistmod.orbs.AirOrb;
import duelistmod.orbs.Alien;
import duelistmod.orbs.Anticrystal;
import duelistmod.orbs.Black;
import duelistmod.orbs.Blaze;
import duelistmod.orbs.Blood;
import duelistmod.orbs.Buffer;
import duelistmod.orbs.Consumer;
import duelistmod.orbs.DarkMillenniumOrb;
import duelistmod.orbs.DragonOrb;
import duelistmod.orbs.DragonPlusOrb;
import duelistmod.orbs.DuelistCrystal;
import duelistmod.orbs.DuelistGlass;
import duelistmod.orbs.DuelistHellfire;
import duelistmod.orbs.DuelistLight;
import duelistmod.orbs.Earth;
import duelistmod.orbs.FireOrb;
import duelistmod.orbs.Gadget;
import duelistmod.orbs.Gate;
import duelistmod.orbs.Glitch;
import duelistmod.orbs.Lava;
import duelistmod.orbs.LightMillenniumOrb;
import duelistmod.orbs.Metal;
import duelistmod.orbs.MillenniumOrb;
import duelistmod.orbs.Mist;
import duelistmod.orbs.MonsterOrb;
import duelistmod.orbs.Moon;
import duelistmod.orbs.Mud;
import duelistmod.orbs.ReducerOrb;
import duelistmod.orbs.Sand;
import duelistmod.orbs.Shadow;
import duelistmod.orbs.Smoke;
import duelistmod.orbs.Splash;
import duelistmod.orbs.Storm;
import duelistmod.orbs.Summoner;
import duelistmod.orbs.Sun;
import duelistmod.orbs.Surge;
import duelistmod.orbs.TokenOrb;
import duelistmod.orbs.VoidOrb;
import duelistmod.orbs.WaterOrb;
import duelistmod.orbs.WhiteOrb;

import java.util.ArrayList;

public class CustomConsoleCommandHelper {

    public static ArrayList<String> getOrbNames() {
        ArrayList<String> orbs = new ArrayList<>();
        orbs.add("Air");
        orbs.add("Alien");
        orbs.add("Anticrystal");
        orbs.add("Black");
        orbs.add("Blaze");
        orbs.add("Buffer");
        orbs.add("Consumer");
        orbs.add("DarkMillenniumOrb");
        orbs.add("DragonOrb");
        orbs.add("DragonOrb+");
        orbs.add("Crystal");
        orbs.add("Glass");
        orbs.add("Hellfire");
        orbs.add("Light");
        orbs.add("Earth");
        orbs.add("Fire");
        orbs.add("Gadget");
        orbs.add("Gate");
        orbs.add("Glitch");
        orbs.add("Lava");
        orbs.add("LightMillenniumOrb");
        orbs.add("Metal");
        orbs.add("MillenniumOrb");
        orbs.add("Mist");
        orbs.add("MonsterOrb");
        orbs.add("Moon");
        orbs.add("Mud");
        orbs.add("Reducer");
        orbs.add("Sand");
        orbs.add("Shadow");
        orbs.add("Smoke");
        orbs.add("Splash");
        orbs.add("Storm");
        orbs.add("Summoner");
        orbs.add("Sun");
        orbs.add("Surge");
        orbs.add("TokenOrb");
        orbs.add("Void");
        orbs.add("Water");
        orbs.add("White");
        orbs.add("Dark");
        orbs.add("Lightning");
        orbs.add("Frost");
        orbs.add("Plasma");
        return orbs;
    }

    public static void channel(String orb, int amount) {
        AbstractOrb output = null;

        switch (orb) {
            case "Air": output = new AirOrb(); break;
            case "Alien": output = new Alien(); break;
            case "Anticrystal": output = new Anticrystal(); break;
            case "Black": output = new Black(); break;
            case "Blaze": output = new Blaze(); break;
            case "Blood": output = new Blood(); break;
            case "Buffer": output = new Buffer(); break;
            case "Consumer": output = new Consumer(); break;
            case "DarkMillenniumOrb": output = new DarkMillenniumOrb(); break;
            case "DragonOrb": output = new DragonOrb(); break;
            case "DragonOrb+": output = new DragonPlusOrb(); break;
            case "Crystal": output = new DuelistCrystal(); break;
            case "Glass": output = new DuelistGlass(); break;
            case "Hellfire": output = new DuelistHellfire(); break;
            case "Light": output = new DuelistLight(); break;
            case "Earth": output = new Earth(); break;
            case "Fire": output = new FireOrb(); break;
            case "Gadget": output = new Gadget(); break;
            case "Gate": output = new Gate(); break;
            case "Glitch": output = new Glitch(); break;
            case "Lava": output = new Lava(); break;
            case "LightMillenniumOrb": output = new LightMillenniumOrb(); break;
            case "Metal": output = new Metal(); break;
            case "MillenniumOrb": output = new MillenniumOrb(); break;
            case "Mist": output = new Mist(); break;
            case "MonsterOrb": output = new MonsterOrb(); break;
            case "Moon": output = new Moon(); break;
            case "Mud": output = new Mud(); break;
            case "Reducer": output = new ReducerOrb(); break;
            case "Sand": output = new Sand(); break;
            case "Shadow": output = new Shadow(); break;
            case "Smoke": output = new Smoke(); break;
            case "Splash": output = new Splash(); break;
            case "Storm": output = new Storm(); break;
            case "Summoner": output = new Summoner(1); break;
            case "Sun": output = new Sun(); break;
            case "Surge": output = new Surge(); break;
            case "TokenOrb": output = new TokenOrb(); break;
            case "Void": output = new VoidOrb(); break;
            case "Water": output = new WaterOrb(); break;
            case "White": output = new WhiteOrb(); break;
            case "Dark": output = new Dark(); break;
            case "Lightning": output = new Lightning(); break;
            case "Frost": output = new Frost(); break;
            case "Plasma": output = new Plasma(); break;
            default:
                Util.log("Orb not implemented for basemod console: " + orb, true);
                break;
        }

        try {
            if (output != null) {
                DuelistCard.channel(output.getClass().getDeclaredConstructor().newInstance(), amount);
            }
        } catch (Exception ex) {
            StringBuilder st = new StringBuilder();
            for (StackTraceElement s : ex.getStackTrace()) {
               st.append(s.toString());
            }
            Util.log("Exception while attempting to construct instance of orb: " + orb, false);
            Util.log(ex.getMessage(), false);
            Util.log(st.toString(), false);
        }
    }

}