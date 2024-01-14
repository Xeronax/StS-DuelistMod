package duelistmod.helpers.poolhelpers;

import java.util.ArrayList;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.blue.*;
import com.megacrit.cardcrawl.cards.colorless.*;
import com.megacrit.cardcrawl.cards.green.*;
import com.megacrit.cardcrawl.cards.red.*;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import duelistmod.DuelistMod;
import duelistmod.cards.*;
import duelistmod.cards.incomplete.*;
import duelistmod.cards.incomplete.KaiserSeaHorse;
import duelistmod.cards.metronomes.*;
import duelistmod.cards.pools.aqua.*;
import duelistmod.cards.pools.beast.AloofLupine;
import duelistmod.cards.pools.beast.AncientCrimsonApe;
import duelistmod.cards.pools.beast.BusterGundilCubicBehemoth;
import duelistmod.cards.pools.beast.CattleCall;
import duelistmod.cards.pools.beast.DreamingNemleria;
import duelistmod.cards.pools.beast.EarthboundImmortalCusillu;
import duelistmod.cards.pools.beast.FirewingPegasus;
import duelistmod.cards.pools.beast.GladiatorBeastEssedarii;
import duelistmod.cards.pools.beast.GreenBaboon;
import duelistmod.cards.pools.beast.KinkaByo;
import duelistmod.cards.pools.beast.NemleriaDreamDefenderCouette;
import duelistmod.cards.pools.beast.NemleriaDreamDefenderOreiller;
import duelistmod.cards.pools.beast.NemleriaDreamDevourerReveil;
import duelistmod.cards.pools.beast.NemleriaRepette;
import duelistmod.cards.pools.beast.NimbleMomonga;
import duelistmod.cards.pools.beast.NobleKnightsShieldBearer;
import duelistmod.cards.pools.beast.OjamaPink;
import duelistmod.cards.pools.beast.PhantomBeastRockLizard;
import duelistmod.cards.pools.beast.RushRecklessly;
import duelistmod.cards.pools.beast.SeaKoala;
import duelistmod.cards.pools.beast.SuperNimbleMegaHamster;
import duelistmod.cards.pools.beast.SweetDreamsNemleria;
import duelistmod.cards.pools.beast.TriBrigadeBarrenBlossom;
import duelistmod.cards.pools.beast.TriBrigadeRampantRampager;
import duelistmod.cards.pools.beast.TriBrigadeRendezvous;
import duelistmod.cards.pools.dragons.*;
import duelistmod.cards.pools.fiend.AcidTrapHole;
import duelistmod.cards.pools.fiend.CheerfulCoffin;
import duelistmod.cards.pools.fiend.CosmicHorrorGangiel;
import duelistmod.cards.pools.fiend.DarkHunter;
import duelistmod.cards.pools.fiend.FiresOfDoomsday;
import duelistmod.cards.pools.fiend.SkullArchfiend;
import duelistmod.cards.pools.fiend.SlateWarrior;
import duelistmod.cards.pools.gusto.CaamSerenityOfGusto;
import duelistmod.cards.pools.gusto.DaigustoSphreez;
import duelistmod.cards.pools.gusto.GustoGulldo;
import duelistmod.cards.pools.gusto.MustoOracleOfGusto;
import duelistmod.cards.pools.increment.InfernoidTierra;
import duelistmod.cards.pools.increment.Kuribee;
import duelistmod.cards.pools.increment.Kurivolt;
import duelistmod.cards.pools.insects.*;
import duelistmod.cards.pools.machine.*;
import duelistmod.cards.pools.naturia.*;
import duelistmod.cards.pools.pharaoh.PharaohBlessing;
import duelistmod.cards.pools.pharaoh.RainbowMedicine;
import duelistmod.cards.pools.pharaoh.TombOfThePharaoh;
import duelistmod.cards.pools.plant.GreedyVenomFusionDragon;
import duelistmod.cards.pools.plant.PredaplantBufolicula;
import duelistmod.cards.pools.plant.PredaplantCordyceps;
import duelistmod.cards.pools.plant.PredaplantDragostapelia;
import duelistmod.cards.pools.plant.PredaplantMorayNepenthes;
import duelistmod.cards.pools.plant.PredaplantOphrysScorpio;
import duelistmod.cards.pools.plant.PredaplantSpiderOrchid;
import duelistmod.cards.pools.plant.PredaplantSquidDrosera;
import duelistmod.cards.pools.plant.StarvingVenomPredapowerFusionDragon;
import duelistmod.cards.pools.toon.CreepyConey;
import duelistmod.cards.pools.warrior.AdvanceForce;
import duelistmod.cards.pools.warrior.ElectromagneticShield;
import duelistmod.cards.pools.warrior.LightningBlade;
import duelistmod.cards.pools.warrior.NitroWarrior;
import duelistmod.cards.pools.warrior.WhiteHowling;
import duelistmod.cards.pools.zombies.*;
import duelistmod.enums.StartingDeck;
import org.apache.commons.lang3.StringUtils;

public class BasicPool 
{

	public static ArrayList<AbstractCard> pharaohBasics(boolean full, int level) {
		ArrayList<AbstractCard> cards = new ArrayList<>();

		if (full) {
			cards.add(new GoldenApples());
			cards.add(new PowerWall());
			cards.add(new Jinzo());
			cards.add(new Kuriboh());
			cards.add(new LightningVortex());
			cards.add(new MagicCylinder());
			cards.add(new MirrorForce());
			cards.add(new PowerGiant());
			cards.add(new PreventRat());
			cards.add(new Terraforming());
			cards.add(new WingedKuriboh10());
			cards.add(new WingedKuriboh9());
			switch (level) {
				case 1:
					// Duelist
					cards.add(new FinalFlame());
					cards.add(new ChangeHeart());
					cards.add(new DarklordSuperbia());
					cards.add(new BlackPendant());
					cards.add(new BlockGolem());
					cards.add(new Blockman());
					cards.add(new BattleguardKing());
					cards.add(new ReleaseFromStone());
					cards.add(new HammerShot());
					cards.add(new CatapultZone());
					cards.add(new FuryFire());
					cards.add(new FutureFusion());
					cards.add(new HeavyStorm());
					cards.add(new PotDichotomy());
					cards.add(new BarricadeborgBlocker());

					// Red
					cards.add(new Combust());
					cards.add(new SearingBlow());
					cards.add(new SwordBoomerang());
					cards.add(new FlameBarrier());
					cards.add(new Rampage());
					break;
				case 2:
					cards.add(new WormApocalypse());
					cards.add(new WormWarlord());
					cards.add(new SeedCannon());
					cards.add(new Sangan());
					cards.add(new CardDestruction());
					cards.add(new CheerfulCoffin());
					cards.add(new MagicalStone());
					cards.add(new AcidTrapHole());
					cards.add(new StarvingVenomPredapowerFusionDragon());
					cards.add(new PredaplantSpiderOrchid());
					cards.add(new PredaplantBufolicula());
					cards.add(new PredaplantOphrysScorpio());
					cards.add(new PredaplantDragostapelia());
					cards.add(new PredaplantCordyceps());

					// Green
					cards.add(new Alchemize());
					cards.add(new BouncingFlask());
					cards.add(new NoxiousFumes());
					cards.add(new Outmaneuver());
					cards.add(new PoisonedStab());
					cards.add(new InfiniteBlades());
					break;
				case 3:
					// Duelist
					cards.add(new DarkMagicianGirl());

					// Blue
					cards.add(new RipAndTear());
					cards.add(new CoreSurge());
					cards.add(new Consume());
					cards.add(new AutoShields());
					cards.add(new Aggregate());
					cards.add(new Skim());
					cards.add(new Stack());
					cards.add(new DoomAndGloom());
					break;
				case 4:
					cards.add(new JamBreeding());
					cards.add(new StormingMirrorForce());
					break;
				case 5:
					cards.add(new ReinforcementsArmy());
					break;
			}
		}

		switch (level) {
			case 1:
				// Duelist
				cards.add(new DummyGolem());
				cards.add(new ForbiddenLance());
				cards.add(new Kuribohrn());
				cards.add(new Polymerization());
				cards.add(new RadiantMirrorForce());
				cards.add(new RedHeadedOni());
				cards.add(new RockBombardment());
				cards.add(new WormKing());
				cards.add(new UltraPolymerization());
				cards.add(new UltimateOffering());
				cards.add(new StrayLambs());
				cards.add(new LabyrinthWall());
				cards.add(new HarpieFeather());
				cards.add(new GiantSoldierSteel());
				cards.add(new GemArmadillo());
				cards.add(new EvilswarmHeliotrope());
				cards.add(new EarthEffigy());
				cards.add(new EarthGiant());
				cards.add(new GreenBaboon());
				cards.add(new HaneHane());
				cards.add(new MagicHoleGolem());
				cards.add(new PotAvarice());
				cards.add(new PotGreed());

				// Red
				cards.add(new DoubleTap());
				cards.add(new Rupture());
				cards.add(new SeverSoul());
				break;
			case 2:
				// Duelist
				cards.add(new GreenGraveOni());
				cards.add(new BlueRoseDragon());
				cards.add(new FeatherPho());
				cards.add(new ShiranuiSwordsaga());
				cards.add(new ShiranuiSunsaga());
				cards.add(new ShiranuiSpectralsword());
				cards.add(new ShiranuiSpectralswordShade());
				cards.add(new ShiranuiShogunsaga());
				cards.add(new ShiranuiSmith());
				cards.add(new ShiranuiSquiresaga());
				cards.add(new HundredFootedHorror());
				cards.add(new LordPoison());
				cards.add(new ReptiliannePoison());
				cards.add(new PoisonOldMan());
				cards.add(new GigaMantis());
				cards.add(new GracefulCharity());
				cards.add(new BottomlessTrapHole());
				cards.add(new FishKicks());
				cards.add(new DoomcaliberKnight());
				cards.add(new MarkRose());
				cards.add(new GreedyVenomFusionDragon());
				cards.add(new PredaplantSquidDrosera());
				cards.add(new PredaplantMorayNepenthes());

				// Green
				cards.add(new EscapePlan());
				cards.add(new WellLaidPlans());
				cards.add(new PhantasmalKiller());
				break;
			case 3:
				// Duelist
				cards.add(new BlueBloodedOni());
				cards.add(new ElectromagneticShield());
				cards.add(new SolemnStrike());
				cards.add(new BigFire());
				cards.add(new LightningRodLord());
				cards.add(new ElectromagneticShield());
				cards.add(new Electrowhip());
				cards.add(new NitroWarrior());
				cards.add(new OrbMetronome());
				cards.add(new PotGenerosity());
				cards.add(new Gagagigo());
				cards.add(new LightningBlade());
				cards.add(new InsectPrincess());
				cards.add(new PoseidonBeetle());
				cards.add(new RedRisingDragon());
				cards.add(new SeaKoala());
				cards.add(new CyberArchfiend());
				cards.add(new EarthboundImmortalCusillu());
				cards.add(new BlizzardPrincess());
				cards.add(new DarkHunter());
				cards.add(new RainbowDarkDragon());
				cards.add(new WhiteHowling());
				cards.add(new LegendaryFisherman());
				cards.add(new InfernoFireBlast());
				cards.add(new GalaxyTyranno());
				cards.add(new DoomShaman());
				cards.add(new CosmicHorrorGangiel());
				cards.add(new AncientGearGadjiltron());
				cards.add(new QueenDragunDjinn());
				cards.add(new AdvanceForce());
				cards.add(new Relinquished());
				cards.add(new StatueAnguishPattern());
				cards.add(new DiffusionWaveMotion());

				//Blue
				cards.add(new Tempest());
				cards.add(new StaticDischarge());
				cards.add(new WhiteNoise());
				cards.add(new Amplify());
				cards.add(new ForceField());
				cards.add(new Heatsinks());
				break;
			case 4:
				cards.add(new PurplePainOni());
				cards.add(new ClearKuriboh());
				cards.add(new DarkHole());
				cards.add(new DarkMirrorForce());
				cards.add(new Mathematician());
				cards.add(new PotGreed());
				cards.add(new ScrapFactory());
				cards.add(new FluteKuriboh());
				break;
			case 5:
				cards.add(new Raigeki());
				cards.add(new YellowBelliedOni());
				cards.add(new DokiDoki());
				cards.add(new SilverApples());
				break;
		}

		cards.add(new AttackTheMoon());
		cards.add(new RockSunrise());
		cards.add(new BattleFootballer());
		cards.add(new BigKoala());
		cards.add(new ObeliskTormentor());
		cards.add(new OneForOne());
		cards.add(new RushRecklessly());
		cards.add(new YamiForm());
		cards.add(new ImperialOrder());
		cards.add(new GolemSentry());
		cards.add(new DropOff());
		cards.add(new Fissure());
		cards.add(new GiantTrapHole());

		// Creators
		if (!DuelistMod.persistentDuelistData.CardPoolSettings.getRemoveCreator()) {
			cards.add(new TheCreator());
			cards.add(new DarkCreator());
		}

		// Ascension-locked cards
		if (AbstractDungeon.ascensionLevel < 10) {
			cards.add(new DestructPotion());
			cards.add(new Wiseman());
		}

		if (AbstractDungeon.ascensionLevel < 15) {
			cards.add(new DianKeto());
			cards.add(new RedMedicine());
			cards.add(new Reload());
			cards.add(new ForbiddenChalice());
			cards.add(new MillenniumGolem());
			cards.add(new MillenniumMetronome());
			cards.add(new MillenniumScorpion());
		}
		
		return cards;
	}
	
	public static ArrayList<AbstractCard> ascendedBasics() {
		ArrayList<AbstractCard> cards = new ArrayList<>();
		cards.add(new AloofLupine());
		cards.add(new FlyingSaucer());
		cards.add(new DarkMirrorForce());
		cards.add(new Fissure());
		cards.add(new FlameSwordsman());
		cards.add(new FortressWarrior());
		cards.add(new GaiaFierce());
		cards.add(new GoldenApples());
		cards.add(new HammerShot());
		cards.add(new HaneHane());
		cards.add(new Hinotama());
		cards.add(new ImperialOrder());
		cards.add(new JudgeMan());
		cards.add(new LabyrinthWall());
		cards.add(new MillenniumShield());
		cards.add(new ObeliskTormentor());
		cards.add(new FeatherPho());
		cards.add(new PotDichotomy());
		cards.add(new PotGenerosity());
		cards.add(new PotGreed());
		cards.add(new PreventRat());
		cards.add(new RadiantMirrorForce());
		cards.add(new Raigeki());
		cards.add(new Sangan());
		cards.add(new ScrapFactory());
		cards.add(new ShardGreed());
		cards.add(new SmashingGround());
		cards.add(new SphereKuriboh());
		cards.add(new StormingMirrorForce());
		cards.add(new Terraforming());
		cards.add(new BigFire());
		cards.add(new UltimateOffering());
		cards.add(new ValkMagnet());
		cards.add(new AlphaMagnet());
		cards.add(new BetaMagnet());
		cards.add(new GammaMagnet());
		cards.add(new Mathematician());
		cards.add(new BattleOx());
		cards.add(new FluteKuriboh());
		cards.add(new WingedKuriboh());
		cards.add(new CastleDarkIllusions());
		cards.add(new ChangeHeart());
		cards.add(new JamBreeding());
		cards.add(new BigKoala());
		cards.add(new BattleguardKing());
		cards.add(new BattleFootballer());
		cards.add(new EvilswarmHeliotrope());
		cards.add(new WormApocalypse());
		cards.add(new WormBarses());
		cards.add(new WormKing());
		cards.add(new GauntletWarrior());
		cards.add(new GaiaMidnight());
		cards.add(new GilfordLegend());
		cards.add(new ReinforcementsArmy());
		cards.add(new BlockGolem());
		cards.add(new GiantSoldierSteel());
		cards.add(new WingedKuriboh9());
		cards.add(new WingedKuriboh10());
		cards.add(new Kuribohrn());
		cards.add(new PowerGiant());
		cards.add(new RainbowBridge());
		cards.add(new EarthquakeGiant());
		cards.add(new RainbowKuriboh());
		cards.add(new ClearKuriboh());
		cards.add(new BigEye());
		cards.add(new YamiForm());
		cards.add(new RainbowOverdragon());
		cards.add(new SilverApples());
		cards.add(new DarklordSuperbia());
		cards.add(new LightningVortex());
		cards.add(new BlackPendant());
		cards.add(new LightningRodLord());
		cards.add(new MudGolem());
		cards.add(new Mudora());
		cards.add(new MudragonSwamp());
		cards.add(new FlameTiger());
		cards.add(new ForbiddenLance());
		cards.add(new FutureFusion());
		cards.add(new ElectromagneticShield());
		cards.add(new Electrowhip());
		cards.add(new FuryFire());
		cards.add(new CharcoalInpachi());
		cards.add(new MagicCylinder());
		cards.add(new RockSunrise());
		cards.add(new UltraPolymerization());
		cards.add(new MillenniumScorpion());
		cards.add(new MillenniumMetronome());
		cards.add(new OrbMetronome());
		cards.add(new Jinzo());
		cards.add(new OneForOne());
		cards.add(new DigitalBug());
		cards.add(new Solidarity());
		cards.add(new RedHeadedOni());
		cards.add(new BlueBloodedOni());
		cards.add(new GreenGraveOni());
		cards.add(new PurplePainOni());
		cards.add(new Ookazi());

		
		// megatype pool cards
		cards.add(new KamionTimelord());
		cards.add(new RainbowRefraction());
		cards.add(new CrystalRaigeki());
		cards.add(new RainbowRuins());
		cards.add(new RainbowDragon());
		//cards.add(new HourglassLife());
		cards.add(new Eva());
		cards.add(new HappyLover());
		cards.add(new DunamesDarkWitch());
		cards.add(new RainbowNeos());
		cards.add(new RainbowFlower());

		boolean p1Wins = StartingDeck.PHARAOH_I.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		boolean p2Wins = StartingDeck.PHARAOH_II.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		boolean p3Wins = StartingDeck.PHARAOH_III.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		boolean p4Wins = StartingDeck.PHARAOH_IV.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		boolean p5Wins = StartingDeck.PHARAOH_V.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		if (p1Wins || p2Wins || p3Wins || p4Wins || p5Wins) {
			cards.add(new PharaohBlessing());
			cards.add(new TombOfThePharaoh());
			if (AbstractDungeon.ascensionLevel < 15) {
				cards.add(new RainbowMedicine());
			}
		}

		return cards;
	}
	
	public static ArrayList<AbstractCard> fullBasic(String deckName)
	{
		ArrayList<AbstractCard> cards = new ArrayList<AbstractCard>();
		if (deckName.equals("Dragon Deck")) { cards.addAll(dragonBasics(true)); }
		else if (deckName.equals("Naturia Deck")) { cards.addAll(naturiaBasics(true)); }
		else if (deckName.equals("Insect Deck")) { cards.addAll(insectBasics(true)); }
		else if (deckName.equals("Machine Deck")) { cards.addAll(machineBasics(true)); }
		else if (deckName.equals("Aqua Deck")) { cards.addAll(aquaBasics(true)); }
		else if (deckName.equals("Zombie Deck")) { cards.addAll(zombBasics(true)); }
		else if (deckName.equals("Metronome Deck")) { cards.addAll(metBasics(true)); }
		else if (deckName.equals("Beast Deck")) { cards.addAll(beastBasics(true)); }
		else if (deckName.equals("Increment Deck")) { cards.addAll(incrementBasics(true)); }
		else if (deckName.equals("Pharaoh I")) { cards.addAll(pharaohBasics(true, 1)); }
		else if (deckName.equals("Pharaoh II")) { cards.addAll(pharaohBasics(true, 2)); }
		else if (deckName.equals("Pharaoh III")) { cards.addAll(pharaohBasics(true, 3)); }
		else if (deckName.equals("Pharaoh IV")) { cards.addAll(pharaohBasics(true, 4)); }
		else if (deckName.equals("Pharaoh V")) { cards.addAll(pharaohBasics(true, 5)); }
		else if (deckName.equals("Toon Deck")) { cards.addAll(toonBasics(true)); }
		else
		{
			cards.add(new FinalFlame());
			cards.add(new Ookazi());
			cards.add(new AttackTheMoon());
			cards.add(new AloofLupine());
			cards.add(new RockBombardment());
			cards.add(new BattleFootballer());
			cards.add(new BattleOx());
			cards.add(new BattleguardKing());
			cards.add(new BigEye());
			cards.add(new BigFire());
			cards.add(new BigKoala());
			cards.add(new BlackPendant());
			cards.add(new BlockGolem());
			cards.add(new Blockman());
			cards.add(new BlueBloodedOni());
			cards.add(new CastleDarkIllusions());
			cards.add(new CatapultZone());
			cards.add(new ChangeHeart());
			cards.add(new ClearKuriboh());
			cards.add(new Cloning());
			cards.add(new DarkFactory());
			cards.add(new DarkHole());
			cards.add(new DarkMirrorForce());
			cards.add(new DarklordSuperbia());
			cards.add(new DestroyerGolem());
			cards.add(new DokiDoki());
			cards.add(new DropOff());
			cards.add(new DummyGolem());
			cards.add(new EarthEffigy());
			cards.add(new EarthGiant());
			cards.add(new EarthquakeGiant());
			cards.add(new ElectromagneticShield());
			cards.add(new Electrowhip());
			cards.add(new EvilswarmHeliotrope());
			cards.add(new FeatherPho());
			cards.add(new Fissure());
			cards.add(new FlameTiger());
			cards.add(new FluteKuriboh());
			cards.add(new ForbiddenLance());
			cards.add(new FuryFire());
			cards.add(new FutureFusion());
			cards.add(new GaiaMidnight());
			cards.add(new GauntletWarrior());
			cards.add(new GemArmadillo());
			cards.add(new GemElephant());
			cards.add(new GiantSoldierSteel());
			cards.add(new GiantTrapHole());
			cards.add(new GilfordLegend());
			cards.add(new GoldenApples());
			cards.add(new GolemSentry());
			cards.add(new GraniteLoyalist());
			cards.add(new GreenGraveOni());
			cards.add(new GreyGreedOni());
			cards.add(new HammerShot());
			cards.add(new HaneHane());
			cards.add(new HarpieFeather());
			cards.add(new HeavyStorm());
			cards.add(new Hinotama());
			cards.add(new ImperialOrder());
			cards.add(new JamBreeding());
			cards.add(new Jinzo());
			cards.add(new Kuriboh());
			cards.add(new Kuribohrn());
			cards.add(new LabyrinthWall());
			//cards.add(new LightningDarts());
			cards.add(new LightningRodLord());
			cards.add(new LightningVortex());
			cards.add(new MagicCylinder());
			cards.add(new MagicHoleGolem());
			cards.add(new MagicalStone());
			cards.add(new Mathematician());
			cards.add(new Mausoleum());
			cards.add(new MillenniumMetronome());
			cards.add(new MillenniumGolem());
			cards.add(new MillenniumScorpion());
			cards.add(new MillenniumShield());
			cards.add(new MirrorForce());
			cards.add(new MudGolem());
			cards.add(new Mudora());
			cards.add(new MudragonSwamp());
			cards.add(new ObeliskTormentor());
			cards.add(new OneForOne());
			cards.add(new OrbMetronome());
			cards.add(new Polymerization());
			cards.add(new PotAvarice());
			cards.add(new PotDichotomy());
			cards.add(new PotForbidden());
			cards.add(new PotGenerosity());
			cards.add(new PotGreed());
			cards.add(new PowerGiant());
			cards.add(new PowerWall());
			cards.add(new PreventRat());
			cards.add(new PurplePainOni());
			cards.add(new RadiantMirrorForce());
			cards.add(new Raigeki());
			cards.add(new RainbowBridge());
			cards.add(new RainbowGravity());
			cards.add(new RainbowJar());
			cards.add(new RainbowKuriboh());
			cards.add(new RainbowLife());
			cards.add(new RainbowOverdragon());
			cards.add(new RedHeadedOni());
			cards.add(new ReinforcementsArmy());
			cards.add(new ReleaseFromStone());
			cards.add(new RockSunrise());
			cards.add(new Sangan());
			cards.add(new ScrapFactory());
			cards.add(new ShardGreed());
			cards.add(new SilverApples());
			cards.add(new SlotMachine());
			cards.add(new SmashingGround());
			cards.add(new SolemnStrike());
			cards.add(new Solidarity());
			cards.add(new SphereKuriboh());
			cards.add(new StormingMirrorForce());
			cards.add(new StrayLambs());
			cards.add(new Terraforming());
			cards.add(new TimeSeal());
			cards.add(new UltimateOffering());
			cards.add(new UltraPolymerization());
			cards.add(new WeepingIdol());
			cards.add(new WingedKuriboh());
			cards.add(new WingedKuriboh10());
			cards.add(new WingedKuriboh9());
			cards.add(new Wiretap());
			cards.add(new WormApocalypse());
			cards.add(new WormBarses());
			cards.add(new WormKing());
			cards.add(new WormWarlord());
			cards.add(new YamiForm());
			cards.add(new YellowBelliedOni());
			cards.add(new RushRecklessly());
			cards.add(new RisingEnergy());

			// Creators
			if (!DuelistMod.persistentDuelistData.CardPoolSettings.getRemoveCreator()) { cards.add(new TheCreator()); cards.add(new DarkCreator()); }

			// Ascension-locked cards
			if (AbstractDungeon.ascensionLevel < 10)
			{
				cards.add(new DestructPotion());
				cards.add(new Wiseman());
			}

			if (AbstractDungeon.ascensionLevel < 15)
			{
				cards.add(new DianKeto());
				cards.add(new RedMedicine());
				cards.add(new Reload());
				cards.add(new ForbiddenChalice());
			}
			// END Ascension-locked cards
		}

		if (!StringUtils.equalsAnyIgnoreCase(deckName, "Pharaoh I", "Pharaoh II", "Pharaoh III", "Pharaoh IV", "Pharaoh V")) {
			boolean p1Wins = StartingDeck.PHARAOH_I.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
			boolean p2Wins = StartingDeck.PHARAOH_II.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
			boolean p3Wins = StartingDeck.PHARAOH_III.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
			boolean p4Wins = StartingDeck.PHARAOH_IV.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
			boolean p5Wins = StartingDeck.PHARAOH_V.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
			if (p1Wins || p2Wins || p3Wins || p4Wins || p5Wins) {
				cards.add(new PharaohBlessing());
				cards.add(new TombOfThePharaoh());
				if (AbstractDungeon.ascensionLevel < 15) {
					cards.add(new RainbowMedicine());
				}
			}
		}

		
		if (DuelistMod.debug)
		{
			DuelistMod.logger.info("Printing all basic cards!!");
			int counter = 1;
			for (AbstractCard c : cards)
			{
				DuelistMod.logger.info("[" + counter + "]: " + c.name);
				counter++;
			}
		}
		
		//DuelistMod.archetypeCards.addAll(cards);
		return cards;
	}

	public static ArrayList<AbstractCard> smallBasic(String deckName)
	{
		ArrayList<AbstractCard> cards = new ArrayList<AbstractCard>();
		if (deckName.equals("Dragon Deck")) { cards.addAll(dragonBasics(false)); }
		else if (deckName.equals("Naturia Deck")) { cards.addAll(naturiaBasics(false)); }
		else if (deckName.equals("Insect Deck")) { cards.addAll(insectBasics(false)); }
		else if (deckName.equals("Machine Deck")) { cards.addAll(machineBasics(false)); }
		else if (deckName.equals("Aqua Deck")) { cards.addAll(aquaBasics(false)); }
		else if (deckName.equals("Zombie Deck")) { cards.addAll(zombBasics(false)); }
		else if (deckName.equals("Metronome Deck")) { cards.addAll(metBasics(false)); }
		else if (deckName.equals("Beast Deck")) { cards.addAll(beastBasics(false)); }
		else if (deckName.equals("Increment Deck")) { cards.addAll(incrementBasics(false)); }
		else if (deckName.equals("Pharaoh I")) { cards.addAll(pharaohBasics(false, 1)); }
		else if (deckName.equals("Pharaoh II")) { cards.addAll(pharaohBasics(false, 2)); }
		else if (deckName.equals("Pharaoh III")) { cards.addAll(pharaohBasics(false, 3)); }
		else if (deckName.equals("Pharaoh IV")) { cards.addAll(pharaohBasics(false, 4)); }
		else if (deckName.equals("Pharaoh V")) { cards.addAll(pharaohBasics(false, 5)); }
		else if (deckName.equals("Toon Deck")) { cards.addAll(toonBasics(false)); }
		else
		{
			//cards.add(new CastleWalls());
			//cards.add(new CelticGuardian());
			//cards.add(new Cloning());		
			//cards.add(new DarkFactory());
			//cards.add(new DarkHole());
			//cards.add(new DarkMirrorForce());
			//cards.add(new Fissure());
			//cards.add(new FlameSwordsman());
			cards.add(new AloofLupine());
			cards.add(new FortressWarrior());
			cards.add(new GaiaFierce());
			cards.add(new GoldenApples());
			//cards.add(new HammerShot());
			cards.add(new HaneHane());
			//cards.add(new HarpieFeather());
			//cards.add(new HeavyStorm());
			//cards.add(new Hinotama());
			cards.add(new ImperialOrder());
			//cards.add(new JudgeMan());
			//cards.add(new Kuriboh());
			cards.add(new LabyrinthWall());
			cards.add(new Mausoleum());
			//cards.add(new MirrorForce());
			//cards.add(new MillenniumShield());
			cards.add(new ObeliskTormentor());
			//cards.add(new FeatherPho());
			//cards.add(new PotAvarice());
			//cards.add(new PotForbidden());
			//cards.add(new PotDichotomy());
			cards.add(new PotGenerosity());
			cards.add(new PotGreed());
			cards.add(new PreventRat());
			//cards.add(new RadiantMirrorForce());
			cards.add(new Raigeki());
			//cards.add(new Sangan());
			//cards.add(new Scapegoat());
			cards.add(new ScrapFactory());
			cards.add(new ShardGreed());
			cards.add(new SmashingGround());
			//cards.add(new SphereKuriboh());
			//cards.add(new StormingMirrorForce());
			//cards.add(new StrayLambs());
			//cards.add(new Terraforming());
			//cards.add(new BigFire());
			//cards.add(new UltimateOffering());
			cards.add(new Wiretap());
			//cards.add(new Mathematician());
			//cards.add(new BattleOx());
			cards.add(new FluteKuriboh());
			cards.add(new WingedKuriboh());
			//cards.add(new CastleDarkIllusions());
			cards.add(new ChangeHeart());
			//cards.add(new JamBreeding());
			cards.add(new Polymerization());
			cards.add(new BigKoala());
			//cards.add(new BattleguardKing());		
			cards.add(new BattleFootballer());
			//cards.add(new EarthquakeGiant());
			//cards.add(new EvilswarmHeliotrope());
			//cards.add(new WormApocalypse());
			//cards.add(new WormBarses());
			//cards.add(new WormWarlord());
			//cards.add(new WormKing());
			//cards.add(new GauntletWarrior());		
			//cards.add(new GaiaMidnight());		
			//cards.add(new GilfordLegend());
			cards.add(new ReinforcementsArmy());
			//cards.add(new BlockGolem());
			//cards.add(new DokiDoki());
			//cards.add(new GiantSoldierSteel());
			//cards.add(new RainbowJar());
			cards.add(new WingedKuriboh9());
			//cards.add(new WingedKuriboh10());
			//cards.add(new MagicalStone());
			//cards.add(new Kuribohrn());
			//cards.add(new DropOff());
			cards.add(new PowerGiant());
			cards.add(new RainbowBridge());
			cards.add(new EarthGiant());
			//cards.add(new RainbowKuriboh());
			//cards.add(new ClearKuriboh());
			//cards.add(new Linkuriboh());
			//cards.add(new GiantTrapHole());
			//cards.add(new BigEye());
			cards.add(new YamiForm());
			cards.add(new RainbowOverdragon());
			//cards.add(new RainbowGravity());
			//cards.add(new RainbowLife());
			cards.add(new SilverApples());
			//cards.add(new DarklordSuperbia());	
			cards.add(new LightningVortex());
			//cards.add(new BlackPendant());	
			//cards.add(new LightningRodLord());	
			cards.add(new ForbiddenLance());
			//cards.add(new FutureFusion());
			//cards.add(new ElectromagneticShield());
			//cards.add(new Electrowhip());
			//cards.add(new FuryFire());
			//cards.add(new MudGolem());	
			//cards.add(new Mudora());	
			//cards.add(new MudragonSwamp());	
			//cards.add(new FlameTiger());
			//cards.add(new RockSunrise());
			//cards.add(new UltraPolymerization());
			cards.add(new MillenniumScorpion());
			//cards.add(new Metronome());
			cards.add(new OneForOne());
			//cards.add(new OrbMetronome());
			cards.add(new Solidarity());
			//cards.add(new Overworked());
			cards.add(new Jinzo());
			cards.add(new GolemSentry());
			cards.add(new Blockman());
			//cards.add(new AttackTheMoon());
			cards.add(new EarthEffigy());
			//cards.add(new DestroyerGolem());
			//cards.add(new DummyGolem());
			cards.add(new GemElephant());
			cards.add(new GemArmadillo());
			cards.add(new RisingEnergy());
			
			// Creators
			if (!DuelistMod.persistentDuelistData.CardPoolSettings.getRemoveCreator()) { cards.add(new TheCreator()); cards.add(new DarkCreator()); }
			
			// Ascension-locked cards		
			if (AbstractDungeon.ascensionLevel < 10)
			{
				cards.add(new DestructPotion());
				cards.add(new Wiseman());
			} 
			
			if (AbstractDungeon.ascensionLevel < 15)
			{
				cards.add(new DianKeto());
				cards.add(new RedMedicine());
				cards.add(new Reload());
				cards.add(new ForbiddenChalice());
			}
			// END Ascension-locked cards
		}

		if (!StringUtils.equalsAnyIgnoreCase(deckName, "Pharaoh I", "Pharaoh II", "Pharaoh III", "Pharaoh IV", "Pharaoh V")) {
			boolean p1Wins = StartingDeck.PHARAOH_I.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
			boolean p2Wins = StartingDeck.PHARAOH_II.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
			boolean p3Wins = StartingDeck.PHARAOH_III.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
			boolean p4Wins = StartingDeck.PHARAOH_IV.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
			boolean p5Wins = StartingDeck.PHARAOH_V.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
			if (p1Wins || p2Wins || p3Wins || p4Wins || p5Wins) {
				cards.add(new PharaohBlessing());
				cards.add(new TombOfThePharaoh());
				if (AbstractDungeon.ascensionLevel < 15) {
					cards.add(new RainbowMedicine());
				}
			}
		}
		
		if (DuelistMod.debug)
		{
			DuelistMod.logger.info("Printing all basic cards!! (reduced basic set)");
			int counter = 1;
			for (AbstractCard c : cards)
			{
				DuelistMod.logger.info("[" + counter + "]: " + c.name);
				counter++;
			}
		}
		
		//DuelistMod.archetypeCards.addAll(cards);
		return cards;
	}
	
	public static ArrayList<AbstractCard> metBasics(boolean full)
	{
		ArrayList<AbstractCard> cards = new ArrayList<>();
		if (full)
		{
			cards.add(new Ookazi());
			cards.add(new BattleFootballer());
			cards.add(new BattleguardKing());	
			cards.add(new BattleOx());
			cards.add(new BigEye());	
			cards.add(new BigFire());
			cards.add(new BigKoala());
			cards.add(new BlackPendant());	
			cards.add(new BlockGolem());
			cards.add(new Blockman());
			cards.add(new DestroyerGolem());
			cards.add(new DummyGolem());
			cards.add(new EarthEffigy());
			cards.add(new EarthGiant());
			cards.add(new EarthquakeGiant());
			cards.add(new EvilswarmHeliotrope());
			cards.add(new GaiaMidnight());		
			cards.add(new GauntletWarrior());		
			cards.add(new MagicCylinder());
			cards.add(new MillenniumGolem());
			cards.add(new MillenniumShield());
			cards.add(new RushRecklessly());
		}

		cards.add(new AloofLupine());
		cards.add(new BlueBloodedOni());
		cards.add(new ClearKuriboh());	
		cards.add(new DarkFactory());		
		cards.add(new FeatherPho());
		cards.add(new ForbiddenLance());
		cards.add(new FuryFire());		
		cards.add(new GemArmadillo());
		cards.add(new GemElephant());
		cards.add(new GiantSoldierSteel());
		cards.add(new GolemSentry());
		cards.add(new GraniteLoyalist());		
		cards.add(new GreenGraveOni());
		cards.add(new GreyGreedOni());
		cards.add(new HaneHane());
		cards.add(new HarpieFeather());
		cards.add(new ImperialOrder());
		cards.add(new Jinzo());
		cards.add(new LabyrinthWall());		
		cards.add(new MagicHoleGolem());
		cards.add(new MagicalStone());
		cards.add(new OneForOne());
		cards.add(new PowerWall());
		cards.add(new PreventRat());
		cards.add(new PurplePainOni());
		cards.add(new Raigeki());
		cards.add(new RedHeadedOni());
		cards.add(new Sangan());
		cards.add(new ScrapFactory());
		cards.add(new SolemnStrike());
		cards.add(new Solidarity());
		cards.add(new TimeSeal());
		cards.add(new WeepingIdol());
		cards.add(new Wiretap());
		cards.add(new WormApocalypse());
		cards.add(new WormBarses());
		cards.add(new WormKing());
		cards.add(new WormWarlord());
		cards.add(new YamiForm());
		cards.add(new YellowBelliedOni());
		cards.add(new RisingEnergy());
		
		// Base Game Cards
		if (DuelistMod.persistentDuelistData.CardPoolSettings.getBaseGameCards() && DuelistMod.isNotAllCardsPoolType())
		{
			cards.add(new Alchemize());
			cards.add(new BouncingFlask());
			cards.add(new Chaos());
			cards.add(new Chrysalis());
			cards.add(new CreativeAI());
			cards.add(new Discovery());
			cards.add(new Distraction());
			cards.add(new HelloWorld());
			cards.add(new InfernalBlade());
			cards.add(new JackOfAllTrades());
			cards.add(new Juggernaut());
			cards.add(new Magnetism());
			cards.add(new Metamorphosis());
			cards.add(new Transmutation());
			cards.add(new WhiteNoise());			
		}

		// Creators
		//if (!DuelistMod.creatorBtnBool) { cards.add(new TheCreator()); cards.add(new DarkCreator()); }
		
		// Ascension-locked cards		
		if (AbstractDungeon.ascensionLevel < 10)
		{
			cards.add(new DestructPotion());
			cards.add(new Wiseman());			
		} 
		
		if (AbstractDungeon.ascensionLevel < 15)
		{
			cards.add(new RedMedicine());
		}

		boolean p1Wins = StartingDeck.PHARAOH_I.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		boolean p2Wins = StartingDeck.PHARAOH_II.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		boolean p3Wins = StartingDeck.PHARAOH_III.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		boolean p4Wins = StartingDeck.PHARAOH_IV.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		boolean p5Wins = StartingDeck.PHARAOH_V.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		if (p1Wins || p2Wins || p3Wins || p4Wins || p5Wins) {
			cards.add(new PharaohBlessing());
			cards.add(new TombOfThePharaoh());
			if (AbstractDungeon.ascensionLevel < 15) {
				cards.add(new RainbowMedicine());
			}
		}
		
		return cards;
	}
	
	public static ArrayList<AbstractCard> zombBasics(boolean full)
	{
		ArrayList<AbstractCard> cards = new ArrayList<>();
		if (full)
		{
			cards.add(new BigEye());
			cards.add(new BlackPendant());
			cards.add(new BlueBloodedOni());
			cards.add(new ChangeHeart());
			cards.add(new CorrodingShark());
			cards.add(new DarkAssailant());
			cards.add(new DarkFusion());
			cards.add(new DarkHole());
			cards.add(new DarkMirrorForce());	
			cards.add(new EarthGiant());
			cards.add(new GhostrickRenovation());
			cards.add(new ForbiddenLance());
			cards.add(new FuryFire());
			cards.add(new GhostrickAngel());
			cards.add(new GhostrickDoll());		
			cards.add(new GhostrickDullahan());
			cards.add(new GhostrickFairy());
			cards.add(new GhostrickGoRound());
			cards.add(new GhostrickLantern());
			cards.add(new GhostrickMary());
			cards.add(new GhostrickNekomusume());
			cards.add(new GhostrickSocuteboss());
			cards.add(new GhostrickWitch());
			cards.add(new GhostrickYukiOnna());
			cards.add(new GigastoneOmega());
			cards.add(new GlowUpBloom());
			cards.add(new GreenGraveOni());
			cards.add(new GreyGreedOni());
			cards.add(new ImperialTomb());
			cards.add(new MagicalGhost());			
			cards.add(new MonsterEgg());
			cards.add(new OneForOne());			
			cards.add(new PlaguespreaderZombie());			
			cards.add(new PotGenerosity());
			cards.add(new PurplePainOni());
			cards.add(new RedHeadedOni());
			cards.add(new Relinkuriboh());
			cards.add(new SeaMonsterTheseus());	
			cards.add(new TrapHole());
			cards.add(new YamiForm());
			cards.add(new Ookazi());
			cards.add(new RushRecklessly());
		}

		cards.add(new AloofLupine());
		cards.add(new BaconSaver());
		cards.add(new BeastPharaoh());
		cards.add(new BloodSucker());
		cards.add(new BookTaiyou());
		cards.add(new BurningSkullHead());
		cards.add(new CallGrave());
		cards.add(new CallHaunted());
		cards.add(new CalledByGrave());
		cards.add(new EnmaJudgement());
		cards.add(new FinalFusion());
		cards.add(new FlameGhost());
		cards.add(new FlashFusion());
		cards.add(new FossilDragon());		
		cards.add(new FossilKnight());
		cards.add(new FossilSkullConvoy());
		cards.add(new FossilSkullbuggy());
		cards.add(new FusionDevourer());
		cards.add(new FusionFire());
		cards.add(new FutureFusion());			
		cards.add(new GatesDarkWorld());
		cards.add(new HardSellinZombie());
		cards.add(new HumptyGrumpty());
		cards.add(new MagicalizedFusion());
		cards.add(new MiracleFusion());
		cards.add(new PyramidLight());
		cards.add(new RebornZombie());
		cards.add(new ReturnToDoomed());
		cards.add(new ShiftingShadows());
		cards.add(new ShiranuiSamurai());
		cards.add(new ShiranuiSamuraisaga());
		cards.add(new ShiranuiShogunsaga());
		cards.add(new ShiranuiSkillsagaSupremacy());
		cards.add(new ShiranuiSmith());
		cards.add(new ShiranuiSolitaire());
		cards.add(new ShiranuiSpectralsword());
		cards.add(new ShiranuiSpectralswordShade());
		cards.add(new ShiranuiSpiritmaster());
		cards.add(new ShiranuiSquire());
		cards.add(new ShiranuiSquiresaga());
		cards.add(new ShiranuiSunsaga());
		cards.add(new ShiranuiSwordmaster());
		cards.add(new ShiranuiSwordsaga());
		cards.add(new SkullFlame());
		cards.add(new Skullgios());
		cards.add(new SphereChaos());
		cards.add(new SupersonicSkullFlame());
		cards.add(new SynchroFusionist());
		cards.add(new TimeFusion());
		cards.add(new PMCaptor());
		cards.add(new YellowBelliedOni());
		cards.add(new RisingEnergy());
		
		// Base Game Cards
		if (DuelistMod.persistentDuelistData.CardPoolSettings.getBaseGameCards() && DuelistMod.isNotAllCardsPoolType())
		{
			cards.add(new Footwork()); 			 
			cards.add(new CorpseExplosion()); 
			cards.add(new Malaise()); 
			cards.add(new BeamCell()); 
			cards.add(new WellLaidPlans()); 
		}

		// Creators
		if (!DuelistMod.persistentDuelistData.CardPoolSettings.getRemoveCreator()) { cards.add(new TheCreator()); cards.add(new DarkCreator()); }
		
		// Ascension-locked cards		
		if (AbstractDungeon.ascensionLevel < 10)
		{
			cards.add(new DestructPotion());
			cards.add(new Wiseman());			
		} 
		
		if (AbstractDungeon.ascensionLevel < 15)
		{
			cards.add(new RedMedicine());
		}

		boolean p1Wins = StartingDeck.PHARAOH_I.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		boolean p2Wins = StartingDeck.PHARAOH_II.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		boolean p3Wins = StartingDeck.PHARAOH_III.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		boolean p4Wins = StartingDeck.PHARAOH_IV.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		boolean p5Wins = StartingDeck.PHARAOH_V.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		if (p1Wins || p2Wins || p3Wins || p4Wins || p5Wins) {
			cards.add(new PharaohBlessing());
			cards.add(new TombOfThePharaoh());
			if (AbstractDungeon.ascensionLevel < 15) {
				cards.add(new RainbowMedicine());
			}
		}
		
		return cards;
	}
	
	public static ArrayList<AbstractCard> aquaBasics(boolean full)
	{
		ArrayList<AbstractCard> cards = new ArrayList<>();
		if (full)
		{
			cards.add(new FluteKuriboh());
			cards.add(new LightningVortex());
			cards.add(new MadLobster());	
			cards.add(new MillenniumShield());
			cards.add(new ObeliskTormentor());
			cards.add(new OneForOne());
			cards.add(new PotDichotomy());
			cards.add(new PotGreed());
			cards.add(new PreventRat());
			cards.add(new ReinforcementsArmy());
			cards.add(new RushRecklessly());
		}

		cards.add(new AloofLupine());
		cards.add(new Ameba());
		cards.add(new AquamirrorCycle());
		cards.add(new BarrierStatue());
		cards.add(new BattleOx());		
		cards.add(new BigEye());			
		cards.add(new BlizzardDefender());	
		cards.add(new BlueBloodedOni());
		cards.add(new ChangeHeart());
		cards.add(new ChrysalisDolphin());
		cards.add(new ColdFeet());
		cards.add(new CraniumFish());	
		cards.add(new DeepDiver());	
		cards.add(new DupeFrog());
		cards.add(new ElementalBurst());	
		cards.add(new FeatherPho());
		cards.add(new Fissure());		
		cards.add(new FreezingBeast());
		cards.add(new FutureFusion());	
		cards.add(new GeneralGantal());	
		cards.add(new GilfordLegend());
		cards.add(new GishkiAquamirror());
		cards.add(new GishkiMarker());
		cards.add(new GishkiNoellia());
		cards.add(new GoldenApples());
		cards.add(new GraydleImpact());
		cards.add(new HammerShot());
		cards.add(new ImperialOrder());
		cards.add(new JamBreeding());	
		cards.add(new KaiserSeaHorse());
		cards.add(new LegendaryFisherman());
		cards.add(new Polymerization());
		cards.add(new PoseidonWave());	
		cards.add(new PotAvarice());		
		cards.add(new Salvage());		
		cards.add(new SangaWater());	
		cards.add(new ShardGreed());
		cards.add(new SmashingGround());
		cards.add(new SolemnStrike());
		cards.add(new SphereKuriboh());
		cards.add(new YamiForm());
		cards.add(new RisingEnergy());
		cards.add(new BarricadeborgBlocker());

		// Creators
		if (!DuelistMod.persistentDuelistData.CardPoolSettings.getRemoveCreator()) { cards.add(new TheCreator()); cards.add(new DarkCreator()); }
		
		// Ascension-locked cards		
		if (AbstractDungeon.ascensionLevel < 10)
		{
			cards.add(new DestructPotion());
			cards.add(new Wiseman());			
		} 
		
		if (AbstractDungeon.ascensionLevel < 15)
		{
			cards.add(new DianKeto());
			cards.add(new RedMedicine());
			cards.add(new Reload());
			cards.add(new ForbiddenChalice());
		}

		boolean p1Wins = StartingDeck.PHARAOH_I.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		boolean p2Wins = StartingDeck.PHARAOH_II.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		boolean p3Wins = StartingDeck.PHARAOH_III.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		boolean p4Wins = StartingDeck.PHARAOH_IV.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		boolean p5Wins = StartingDeck.PHARAOH_V.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		if (p1Wins || p2Wins || p3Wins || p4Wins || p5Wins) {
			cards.add(new PharaohBlessing());
			cards.add(new TombOfThePharaoh());
			if (AbstractDungeon.ascensionLevel < 15) {
				cards.add(new RainbowMedicine());
			}
		}
		
		return cards;
	}
	
	public static ArrayList<AbstractCard> beastBasics(boolean full) {
		ArrayList<AbstractCard> cards = new ArrayList<>();

		if (full) {
			cards.add(new RainbowKuriboh());
			cards.add(new WhiteHowling());
			cards.add(new WingedKuriboh9());
			cards.add(new WingedKuriboh10());
			cards.add(new OneForOne());
			cards.add(new PotGreed());
			cards.add(new AttackTheMoon());
			cards.add(new RockBombardment());
			cards.add(new BattleFootballer());
			cards.add(new MirrorForce());
			cards.add(new ShardGreed());
			cards.add(new Ookazi());
			cards.add(new FinalFlame());
			cards.add(new NobleKnightsShieldBearer());
			cards.add(new ForbiddenLance());
		}

		cards.add(new FlameTiger());
		cards.add(new Fissure());
		cards.add(new PotGenerosity());
		cards.add(new RisingEnergy());
		cards.add(new HammerShot());
		cards.add(new NimbleMomonga());
		cards.add(new WingedKuriboh());
		cards.add(new FluteKuriboh());
		cards.add(new CreepyConey());
		cards.add(new SilverApples());
		cards.add(new GoldenApples());
		cards.add(new SpiritualForest());
		cards.add(new DarklordSuperbia());
		cards.add(new LightningVortex());
		cards.add(new DarkSimorgh());
		cards.add(new ImperialOrder());
		cards.add(new BeastFangs());
		cards.add(new LabyrinthWall());
		cards.add(new HeavyStorm());
		cards.add(new MagicHoleGolem());
		cards.add(new ThreateningRoar());
		cards.add(new DaigustoSphreez());
		cards.add(new CattleCall());
		cards.add(new BusterGundilCubicBehemoth());
		cards.add(new NemleriaRepette());
		cards.add(new SweetDreamsNemleria());
		cards.add(new SeaKoala());
		cards.add(new NemleriaDreamDevourerReveil());
		cards.add(new NemleriaDreamDefenderCouette());
		cards.add(new NemleriaDreamDefenderOreiller());
		cards.add(new GladiatorBeastEssedarii());
		cards.add(new DreamingNemleria());
		cards.add(new SuperNimbleMegaHamster());
		cards.add(new PhantomBeastRockLizard());
		cards.add(new KinkaByo());
		cards.add(new Kuribee());
		cards.add(new GreenBaboon());
		cards.add(new FirewingPegasus());
		cards.add(new TriBrigadeRendezvous());
		cards.add(new DewlorenTigerKing());
		cards.add(new EarthboundImmortalCusillu());
		cards.add(new CaamSerenityOfGusto());
		cards.add(new MustoOracleOfGusto());
		cards.add(new GustoGulldo());
		cards.add(new TriBrigadeBarrenBlossom());
		cards.add(new TriBrigadeRampantRampager());

		// Ojama cards
		if (!DuelistMod.persistentDuelistData.CardPoolSettings.getRemoveOjama()) {
			cards.add(new OjamaRed());
			cards.add(new OjamaBlue());
			cards.add(new OjamaBlack());
			cards.add(new OjamaGreen());
			cards.add(new OjamaKnight());
			cards.add(new OjamaDeltaHurricane());
			cards.add(new Ojamatch());
			cards.add(new OjamaYellow());
			cards.add(new OjamaDuo());
			cards.add(new OjamaCountry());
			cards.add(new OjamaKing());
			cards.add(new OjamaTrio());
			cards.add(new Ojamuscle());
			cards.add(new OjamaPajama());
			cards.add(new Ojamassimilation());
			cards.add(new OjamaEmperor());
			cards.add(new Ojamagic());
			cards.add(new OjamaPink());
		}

		// Creators
		if (!DuelistMod.persistentDuelistData.CardPoolSettings.getRemoveCreator()) {
			cards.add(new TheCreator());
			cards.add(new DarkCreator());
		}

		// Ascension-locked cards		
		if (AbstractDungeon.ascensionLevel < 10)
		{
			cards.add(new DestructPotion());
			cards.add(new Wiseman());
		}

		if (AbstractDungeon.ascensionLevel < 15)
		{
			cards.add(new DianKeto());
			cards.add(new RedMedicine());
			cards.add(new Reload());
			cards.add(new ForbiddenChalice());
		}

		boolean p1Wins = StartingDeck.PHARAOH_I.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		boolean p2Wins = StartingDeck.PHARAOH_II.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		boolean p3Wins = StartingDeck.PHARAOH_III.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		boolean p4Wins = StartingDeck.PHARAOH_IV.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		boolean p5Wins = StartingDeck.PHARAOH_V.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		if (p1Wins || p2Wins || p3Wins || p4Wins || p5Wins) {
			cards.add(new PharaohBlessing());
			cards.add(new TombOfThePharaoh());
			if (AbstractDungeon.ascensionLevel < 15) {
				cards.add(new RainbowMedicine());
			}
		}
		
		return cards;
	}
	
	public static ArrayList<AbstractCard> dragonBasics(boolean full)
	{
		ArrayList<AbstractCard> cards = new ArrayList<>();
		if (full)
		{
			cards.add(new AquaDolphin());
			cards.add(new BattleguardKing());	
			cards.add(new BigFire());
			cards.add(new GalaxySoldier());
			cards.add(new HaneHane());
			cards.add(new Hinotama());
			cards.add(new MagicalStone());
			cards.add(new OrbMetronome());
			cards.add(new PotGreed());
			cards.add(new RainbowBridge());
			cards.add(new StrayLambs());
			cards.add(new Terraforming());
			cards.add(new UltimateOffering());
			cards.add(new Ookazi());
			cards.add(new RushRecklessly());
		}
		cards.add(new AloofLupine());
		cards.add(new BigEye());	
		cards.add(new BigKoala());
		cards.add(new BlackPendant());	
		cards.add(new BlockGolem());
		cards.add(new BlueBloodedOni());
		cards.add(new DarkFactory());
		cards.add(new DefensiveTactics());
		cards.add(new FeatherPho());
		cards.add(new ForbiddenLance());
		cards.add(new GoldenApples());
		cards.add(new GreenGraveOni());
		cards.add(new GreyGreedOni());		
		cards.add(new HarpieFeather());		
		cards.add(new ImperialOrder());
		cards.add(new JamBreeding());
		cards.add(new RisingEnergy());
		cards.add(new LabyrinthWall());
		cards.add(new Mausoleum());
		cards.add(new ObeliskTormentor());		
		cards.add(new PotGenerosity());		
		cards.add(new PreventRat());
		cards.add(new PurplePainOni());
		cards.add(new Raigeki());		
		cards.add(new RainbowOverdragon());
		cards.add(new ReinforcementsArmy());
		cards.add(new ScrapFactory());
		cards.add(new ShardGreed());
		cards.add(new SlotMachine());
		cards.add(new SmashingGround());
		cards.add(new Solidarity());		
		cards.add(new YamiForm());
		cards.add(new YellowBelliedOni());
		cards.add(new RainbowDragon());
		
		// Creators
		if (!DuelistMod.persistentDuelistData.CardPoolSettings.getRemoveCreator()) { cards.add(new TheCreator()); cards.add(new DarkCreator()); }
		
		// Ascension-locked cards		
		if (AbstractDungeon.ascensionLevel < 10)
		{
			cards.add(new DestructPotion());
			cards.add(new Wiseman());			
		} 
		
		if (AbstractDungeon.ascensionLevel < 15)
		{
			cards.add(new DianKeto());
			cards.add(new RedMedicine());
			cards.add(new Reload());
			cards.add(new ForbiddenChalice());
		}

		boolean p1Wins = StartingDeck.PHARAOH_I.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		boolean p2Wins = StartingDeck.PHARAOH_II.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		boolean p3Wins = StartingDeck.PHARAOH_III.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		boolean p4Wins = StartingDeck.PHARAOH_IV.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		boolean p5Wins = StartingDeck.PHARAOH_V.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		if (p1Wins || p2Wins || p3Wins || p4Wins || p5Wins) {
			cards.add(new PharaohBlessing());
			cards.add(new TombOfThePharaoh());
			if (AbstractDungeon.ascensionLevel < 15) {
				cards.add(new RainbowMedicine());
			}
		}
		
		return cards;
	}
	
	public static ArrayList<AbstractCard> machineBasics(boolean full)
	{
		ArrayList<AbstractCard> cards = new ArrayList<>();
		if (DuelistMod.persistentDuelistData.GameplaySettings.getQuickTimeEvents()) { cards.add(new MachinaCannon()); }
		else { cards.add(new FlyingSaucer()); }
		if (full)
		{
			//cards.add(new BigEye());
			cards.add(new BigFire());
			cards.add(new BlockGolem());
			cards.add(new FutureFusion());
			cards.add(new GemElephant());
			cards.add(new Hinotama());
			cards.add(new Kuriboh());
			cards.add(new Kuribohrn());
			//cards.add(new LightningDarts());
			cards.add(new LightningVortex());
			cards.add(new MagicalStone());
			cards.add(new PerfectMachineKing());
			cards.add(new Sangan());
			cards.add(new Solidarity());
			cards.add(new Terraforming());
			cards.add(new UltimateOffering());
			cards.add(new Ookazi());
			cards.add(new RushRecklessly());
			cards.add(new StrayLambs());
		}
		cards.add(new AloofLupine());
		cards.add(new BattleFootballer());
		cards.add(new BlackPendant());	
		cards.add(new BlastingRuins());	
		cards.add(new ChangeHeart());			
		cards.add(new DreadnoughtDreadnoid());
		cards.add(new FluteKuriboh());
		cards.add(new GoldenApples());		
		cards.add(new GracefulCharity());
		cards.add(new IronCall());
		cards.add(new KarakuriKlock());
		cards.add(new LabyrinthWall());		
		cards.add(new Linkuriboh());		
		cards.add(new LostGuardian());
		cards.add(new MegafleetDragon());
		cards.add(new MillenniumShield());
		cards.add(new Polymerization());
		cards.add(new JunkSpeeder());
		cards.add(new PotGreed());
		cards.add(new PowerGiant());
		cards.add(new PowerWall());
		cards.add(new Raigeki());
		cards.add(new RisingEnergy());
		cards.add(new QuickCharger());
		cards.add(new ScrapFactory());
		cards.add(new SeismicShockwave());
		cards.add(new ShardGreed());
		cards.add(new SystemDown());		
		cards.add(new TimeSeal());
		cards.add(new WingedKuriboh());
		cards.add(new Wiretap());
		cards.add(new WormWarlord());
		cards.add(new YamiForm());
		cards.add(new Kurivolt());
		
		// Creators
		if (!DuelistMod.persistentDuelistData.CardPoolSettings.getRemoveCreator()) { cards.add(new TheCreator()); cards.add(new DarkCreator()); }
		
		// Ascension-locked cards		
		if (AbstractDungeon.ascensionLevel < 10)
		{
			cards.add(new DestructPotion());
			cards.add(new Wiseman());			
		} 
		
		if (AbstractDungeon.ascensionLevel < 15)
		{
			cards.add(new DianKeto());
			cards.add(new RedMedicine());
			cards.add(new Reload());
			cards.add(new ForbiddenChalice());
		}

		boolean p1Wins = StartingDeck.PHARAOH_I.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		boolean p2Wins = StartingDeck.PHARAOH_II.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		boolean p3Wins = StartingDeck.PHARAOH_III.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		boolean p4Wins = StartingDeck.PHARAOH_IV.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		boolean p5Wins = StartingDeck.PHARAOH_V.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		if (p1Wins || p2Wins || p3Wins || p4Wins || p5Wins) {
			cards.add(new PharaohBlessing());
			cards.add(new TombOfThePharaoh());
			if (AbstractDungeon.ascensionLevel < 15) {
				cards.add(new RainbowMedicine());
			}
		}
		
		return cards;
	}
	
	public static ArrayList<AbstractCard> naturiaBasics(boolean full)
	{
		ArrayList<AbstractCard> cards = new ArrayList<AbstractCard>();
		if (full)
		{
			cards.add(new BigFire());
			cards.add(new DarkHole());
			cards.add(new HaneHane());
			cards.add(new MagicCylinder());
			cards.add(new PotDichotomy());
			cards.add(new PotForbidden());
			cards.add(new PowerWall());
			cards.add(new Sangan());
			cards.add(new Ookazi());
			cards.add(new RushRecklessly());
		}
		cards.add(new AloofLupine());
		cards.add(new RockBombardment());
		cards.add(new BigEye());	
		cards.add(new BigKoala());
		cards.add(new BlockGolem());
		cards.add(new Blockman());
		cards.add(new CatapultZone());
		cards.add(new ChangeHeart());
		cards.add(new RisingEnergy());
		cards.add(new DestroyerGolem());
		cards.add(new DummyGolem());
		cards.add(new EarthEffigy());
		cards.add(new Fissure());
		cards.add(new FluteKuriboh());
		cards.add(new FutureFusion());		
		cards.add(new GemArmadillo());
		cards.add(new GemElephant());
		cards.add(new GoldenApples());
		cards.add(new GolemSentry());
		cards.add(new GraniteLoyalist());		
		cards.add(new HammerShot());		
		cards.add(new HeavyStorm());
		cards.add(new ImperialOrder());
		cards.add(new MagicHoleGolem());
		cards.add(new MillenniumGolem());
		cards.add(new MillenniumScorpion());
		cards.add(new MillenniumShield());
		cards.add(new MudGolem());	
		cards.add(new Mudora());	
		cards.add(new MudragonSwamp());	
		cards.add(new ObeliskTormentor());
		cards.add(new Polymerization());
		cards.add(new PotAvarice());		
		cards.add(new PotGenerosity());		
		cards.add(new ReleaseFromStone());
		cards.add(new RockSunrise());
		cards.add(new ShardGreed());
		cards.add(new SliferSky());
		cards.add(new SphereKuriboh());
		cards.add(new Terraforming());		
		cards.add(new UltimateOffering());
		cards.add(new WeepingIdol());
		cards.add(new WingedKuriboh());
		cards.add(new Wiretap());
		cards.add(new YamiForm());
		
		// Creators
		if (!DuelistMod.persistentDuelistData.CardPoolSettings.getRemoveCreator()) { cards.add(new TheCreator()); cards.add(new DarkCreator()); }
		
		// Ascension-locked cards		
		if (AbstractDungeon.ascensionLevel < 10)
		{
			cards.add(new DestructPotion());
			cards.add(new Wiseman());			
		} 
		
		if (AbstractDungeon.ascensionLevel < 15)
		{
			cards.add(new DianKeto());
			cards.add(new RedMedicine());
			cards.add(new Reload());
			cards.add(new ForbiddenChalice());
		}

		boolean p1Wins = StartingDeck.PHARAOH_I.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		boolean p2Wins = StartingDeck.PHARAOH_II.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		boolean p3Wins = StartingDeck.PHARAOH_III.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		boolean p4Wins = StartingDeck.PHARAOH_IV.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		boolean p5Wins = StartingDeck.PHARAOH_V.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		if (p1Wins || p2Wins || p3Wins || p4Wins || p5Wins) {
			cards.add(new PharaohBlessing());
			cards.add(new TombOfThePharaoh());
			if (AbstractDungeon.ascensionLevel < 15) {
				cards.add(new RainbowMedicine());
			}
		}
		
		return cards;
	}

	public static ArrayList<AbstractCard> incrementBasics(boolean full) {
		ArrayList<AbstractCard> cards = new ArrayList<>();

		if (full) {
			cards.add(new RockBombardment());
			cards.add(new DestroyerGolem());
			cards.add(new DropOff());
			cards.add(new Mathematician());
			cards.add(new MillenniumMetronome());
			cards.add(new MillenniumGolem());
			cards.add(new MillenniumScorpion());
			cards.add(new MillenniumShield());
			cards.add(new MirrorForce());
			cards.add(new Polymerization());
			cards.add(new Terraforming());
			cards.add(new BookSecret());
			cards.add(new ExterioFang());
			cards.add(new FossilDig());
			cards.add(new Salvage());
		}

		cards.add(new AttackTheMoon());
		cards.add(new AloofLupine());
		cards.add(new BattleFootballer());
		cards.add(new BattleguardKing());
		cards.add(new BigKoala());
		cards.add(new BlockGolem());
		cards.add(new Blockman());
		cards.add(new CastleDarkIllusions());
		cards.add(new DarkFactory());
		cards.add(new DummyGolem());
		cards.add(new EarthEffigy());
		cards.add(new EarthGiant());
		cards.add(new EarthquakeGiant());
		cards.add(new EvilswarmHeliotrope());
		cards.add(new GemArmadillo());
		cards.add(new GemElephant());
		cards.add(new GiantSoldierSteel());
		cards.add(new GoldenApples());
		cards.add(new HaneHane());
		cards.add(new HarpieFeather());
		cards.add(new ImperialOrder());
		cards.add(new JamBreeding());
		cards.add(new LabyrinthWall());
		cards.add(new MagicCylinder());
		cards.add(new MagicHoleGolem());
		cards.add(new FiresOfDoomsday());
		cards.add(new ObeliskTormentor());
		cards.add(new PotGreed());
		cards.add(new PowerGiant());
		cards.add(new PreventRat());
		cards.add(new RainbowLife());
		cards.add(new RainbowRuins());
		cards.add(new RainbowOverdragon());
		cards.add(new ReleaseFromStone());
		cards.add(new RisingEnergy());
		cards.add(new RushRecklessly());
		cards.add(new ScrapFactory());
		cards.add(new SilverApples());
		cards.add(new StormingMirrorForce());
		cards.add(new ThreateningRoar());
		cards.add(new WeepingIdol());
		cards.add(new YamiForm());
		cards.add(new AncientCrimsonApe());
		cards.add(new RedMirror());
		cards.add(new SkullArchfiend());
		cards.add(new SlateWarrior());
		cards.add(new AutorokketDragon());
		cards.add(new SliferSky());
		cards.add(new EnchantingMermaid());
		cards.add(new InfernoidTierra());
		cards.add(new ApprenticeIllusionMagician());
		cards.add(new SangaEarth());

		// Creators
		if (!DuelistMod.persistentDuelistData.CardPoolSettings.getRemoveCreator()) {
			cards.add(new TheCreator());
			cards.add(new DarkCreator());
		}

		// Ascension-locked cards
		if (AbstractDungeon.ascensionLevel < 10)
		{
			cards.add(new DestructPotion());
			cards.add(new Wiseman());
		}

		if (AbstractDungeon.ascensionLevel < 15)
		{
			cards.add(new DianKeto());
			cards.add(new RedMedicine());
			cards.add(new Reload());
			cards.add(new ForbiddenChalice());
		}

		boolean p1Wins = StartingDeck.PHARAOH_I.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		boolean p2Wins = StartingDeck.PHARAOH_II.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		boolean p3Wins = StartingDeck.PHARAOH_III.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		boolean p4Wins = StartingDeck.PHARAOH_IV.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		boolean p5Wins = StartingDeck.PHARAOH_V.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		if (p1Wins || p2Wins || p3Wins || p4Wins || p5Wins) {
			cards.add(new PharaohBlessing());
			cards.add(new TombOfThePharaoh());
			if (AbstractDungeon.ascensionLevel < 15) {
				cards.add(new RainbowMedicine());
			}
		}

		return cards;
	}
	
	public static ArrayList<AbstractCard> insectBasics(boolean full)
	{
		ArrayList<AbstractCard> cards = new ArrayList<AbstractCard>();
		if (full)
		{
			cards.add(new BattleFootballer());
			cards.add(new BlackPendant());	
			cards.add(new Cloning());
			cards.add(new EarthquakeGiant());
			cards.add(new ForbiddenLance());
			cards.add(new FuryFire());
			cards.add(new HammerShot());
			cards.add(new HaneHane());
			cards.add(new HeavyStorm());
			cards.add(new FluteKuriboh());
			cards.add(new OrbMetronome());
			cards.add(new PowerGiant());
			cards.add(new Solidarity());
			cards.add(new Ookazi());
			cards.add(new RushRecklessly());
		}

		cards.add(new AloofLupine());
		cards.add(new BigEye());	
		cards.add(new BigKoala());		
		cards.add(new ChangeHeart());				
		cards.add(new DarklordSuperbia());	
		cards.add(new EarthGiant());		
		cards.add(new ElectromagneticShield());
		cards.add(new RisingEnergy());
		cards.add(new Fissure());	
		cards.add(new FutureFusion());
		cards.add(new GoldenApples());		
		cards.add(new HarpieFeather());	
		cards.add(new ImperialOrder());
		cards.add(new Kuriboh());
		cards.add(new LabyrinthWall());
		cards.add(new LightningVortex());
		cards.add(new Mausoleum());
		cards.add(new MillenniumScorpion());
		cards.add(new MudGolem());	
		cards.add(new Mudora());	
		cards.add(new MudragonSwamp());			
		cards.add(new Polymerization());
		cards.add(new PotGenerosity());
		cards.add(new PotGreed());		
		cards.add(new PowerWall());
		cards.add(new PreventRat());
		cards.add(new Raigeki());
		cards.add(new RainbowBridge());
		cards.add(new ReinforcementsArmy());
		cards.add(new Sangan());
		cards.add(new ShardGreed());
		cards.add(new SilverApples());	
		cards.add(new SphereKuriboh());
		cards.add(new Terraforming());
		cards.add(new UltimateOffering());
		cards.add(new UltraPolymerization());
		cards.add(new WingedKuriboh());
		cards.add(new WormApocalypse());
		cards.add(new WormBarses());
		cards.add(new WormKing());
		cards.add(new WormWarlord());
		cards.add(new YamiForm());
		cards.add(new YellowBelliedOni());
		
		// Creators
		if (!DuelistMod.persistentDuelistData.CardPoolSettings.getRemoveCreator()) { cards.add(new TheCreator()); cards.add(new DarkCreator()); }
		
		// Ascension-locked cards		
		if (AbstractDungeon.ascensionLevel < 10)
		{
			cards.add(new DestructPotion());
			cards.add(new Wiseman());			
		} 
		
		if (AbstractDungeon.ascensionLevel < 15)
		{
			cards.add(new DianKeto());
			cards.add(new RedMedicine());
			cards.add(new Reload());
			cards.add(new ForbiddenChalice());
		}

		boolean p1Wins = StartingDeck.PHARAOH_I.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		boolean p2Wins = StartingDeck.PHARAOH_II.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		boolean p3Wins = StartingDeck.PHARAOH_III.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		boolean p4Wins = StartingDeck.PHARAOH_IV.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		boolean p5Wins = StartingDeck.PHARAOH_V.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		if (p1Wins || p2Wins || p3Wins || p4Wins || p5Wins) {
			cards.add(new PharaohBlessing());
			cards.add(new TombOfThePharaoh());
			if (AbstractDungeon.ascensionLevel < 15) {
				cards.add(new RainbowMedicine());
			}
		}
		
		return cards;
	}

	public static ArrayList<AbstractCard> toonBasics(boolean full)
	{
		ArrayList<AbstractCard> cards = new ArrayList<>();

		// temporary if/else block until basic cards are configured properly
		if (full) {
			cards.add(new FinalFlame());
			cards.add(new Ookazi());
			cards.add(new AttackTheMoon());
			cards.add(new AloofLupine());
			cards.add(new RockBombardment());
			cards.add(new BattleFootballer());
			cards.add(new BattleOx());
			cards.add(new BattleguardKing());
			cards.add(new BigEye());
			cards.add(new BigFire());
			cards.add(new BigKoala());
			cards.add(new BlackPendant());
			cards.add(new BlockGolem());
			cards.add(new Blockman());
			cards.add(new BlueBloodedOni());
			cards.add(new CastleDarkIllusions());
			cards.add(new CatapultZone());
			cards.add(new ChangeHeart());
			cards.add(new ClearKuriboh());
			cards.add(new Cloning());
			cards.add(new DarkFactory());
			cards.add(new DarkHole());
			cards.add(new DarkMirrorForce());
			cards.add(new DarklordSuperbia());
			cards.add(new DestroyerGolem());
			cards.add(new DokiDoki());
			cards.add(new DropOff());
			cards.add(new DummyGolem());
			cards.add(new EarthEffigy());
			cards.add(new EarthGiant());
			cards.add(new EarthquakeGiant());
			cards.add(new ElectromagneticShield());
			cards.add(new Electrowhip());
			cards.add(new EvilswarmHeliotrope());
			cards.add(new FeatherPho());
			cards.add(new Fissure());
			cards.add(new FlameTiger());
			cards.add(new FluteKuriboh());
			cards.add(new ForbiddenLance());
			cards.add(new FuryFire());
			cards.add(new FutureFusion());
			cards.add(new GaiaMidnight());
			cards.add(new GauntletWarrior());
			cards.add(new GemArmadillo());
			cards.add(new GemElephant());
			cards.add(new GiantSoldierSteel());
			cards.add(new GiantTrapHole());
			cards.add(new GilfordLegend());
			cards.add(new GoldenApples());
			cards.add(new GolemSentry());
			cards.add(new GraniteLoyalist());
			cards.add(new GreenGraveOni());
			cards.add(new GreyGreedOni());
			cards.add(new HammerShot());
			cards.add(new HaneHane());
			cards.add(new HarpieFeather());
			cards.add(new HeavyStorm());
			cards.add(new Hinotama());
			cards.add(new ImperialOrder());
			cards.add(new JamBreeding());
			cards.add(new Jinzo());
			cards.add(new Kuriboh());
			cards.add(new Kuribohrn());
			cards.add(new LabyrinthWall());
			//cards.add(new LightningDarts());
			cards.add(new LightningRodLord());
			cards.add(new LightningVortex());
			cards.add(new MagicCylinder());
			cards.add(new MagicHoleGolem());
			cards.add(new MagicalStone());
			cards.add(new Mathematician());
			cards.add(new Mausoleum());
			cards.add(new MillenniumMetronome());
			cards.add(new MillenniumGolem());
			cards.add(new MillenniumScorpion());
			cards.add(new MillenniumShield());
			cards.add(new MirrorForce());
			cards.add(new MudGolem());
			cards.add(new Mudora());
			cards.add(new MudragonSwamp());
			cards.add(new ObeliskTormentor());
			cards.add(new OneForOne());
			cards.add(new OrbMetronome());
			cards.add(new Polymerization());
			cards.add(new PotAvarice());
			cards.add(new PotDichotomy());
			cards.add(new PotForbidden());
			cards.add(new PotGenerosity());
			cards.add(new PotGreed());
			cards.add(new PowerGiant());
			cards.add(new PowerWall());
			cards.add(new PreventRat());
			cards.add(new PurplePainOni());
			cards.add(new RadiantMirrorForce());
			cards.add(new Raigeki());
			cards.add(new RainbowBridge());
			cards.add(new RainbowGravity());
			cards.add(new RainbowJar());
			cards.add(new RainbowKuriboh());
			cards.add(new RainbowLife());
			cards.add(new RainbowOverdragon());
			cards.add(new RedHeadedOni());
			cards.add(new ReinforcementsArmy());
			cards.add(new ReleaseFromStone());
			cards.add(new RockSunrise());
			cards.add(new Sangan());
			cards.add(new ScrapFactory());
			cards.add(new ShardGreed());
			cards.add(new SilverApples());
			cards.add(new SlotMachine());
			cards.add(new SmashingGround());
			cards.add(new SolemnStrike());
			cards.add(new Solidarity());
			cards.add(new SphereKuriboh());
			cards.add(new StormingMirrorForce());
			cards.add(new StrayLambs());
			cards.add(new Terraforming());
			cards.add(new TimeSeal());
			cards.add(new UltimateOffering());
			cards.add(new UltraPolymerization());
			cards.add(new WeepingIdol());
			cards.add(new WingedKuriboh());
			cards.add(new WingedKuriboh10());
			cards.add(new WingedKuriboh9());
			cards.add(new Wiretap());
			cards.add(new WormApocalypse());
			cards.add(new WormBarses());
			cards.add(new WormKing());
			cards.add(new WormWarlord());
			cards.add(new YamiForm());
			cards.add(new YellowBelliedOni());
			cards.add(new RushRecklessly());
			cards.add(new RisingEnergy());
		}
		else {
			//cards.add(new CastleWalls());
			//cards.add(new CelticGuardian());
			//cards.add(new Cloning());
			//cards.add(new DarkFactory());
			//cards.add(new DarkHole());
			//cards.add(new DarkMirrorForce());
			//cards.add(new Fissure());
			//cards.add(new FlameSwordsman());
			cards.add(new AloofLupine());
			cards.add(new FortressWarrior());
			cards.add(new GaiaFierce());
			cards.add(new GoldenApples());
			//cards.add(new HammerShot());
			cards.add(new HaneHane());
			//cards.add(new HarpieFeather());
			//cards.add(new HeavyStorm());
			//cards.add(new Hinotama());
			cards.add(new ImperialOrder());
			//cards.add(new JudgeMan());
			//cards.add(new Kuriboh());
			cards.add(new LabyrinthWall());
			cards.add(new Mausoleum());
			//cards.add(new MirrorForce());
			//cards.add(new MillenniumShield());
			cards.add(new ObeliskTormentor());
			//cards.add(new FeatherPho());
			//cards.add(new PotAvarice());
			//cards.add(new PotForbidden());
			//cards.add(new PotDichotomy());
			cards.add(new PotGenerosity());
			cards.add(new PotGreed());
			cards.add(new PreventRat());
			//cards.add(new RadiantMirrorForce());
			cards.add(new Raigeki());
			//cards.add(new Sangan());
			//cards.add(new Scapegoat());
			cards.add(new ScrapFactory());
			cards.add(new ShardGreed());
			cards.add(new SmashingGround());
			//cards.add(new SphereKuriboh());
			//cards.add(new StormingMirrorForce());
			//cards.add(new StrayLambs());
			//cards.add(new Terraforming());
			//cards.add(new BigFire());
			//cards.add(new UltimateOffering());
			cards.add(new Wiretap());
			//cards.add(new Mathematician());
			//cards.add(new BattleOx());
			cards.add(new FluteKuriboh());
			cards.add(new WingedKuriboh());
			//cards.add(new CastleDarkIllusions());
			cards.add(new ChangeHeart());
			//cards.add(new JamBreeding());
			cards.add(new Polymerization());
			cards.add(new BigKoala());
			//cards.add(new BattleguardKing());
			cards.add(new BattleFootballer());
			//cards.add(new EarthquakeGiant());
			//cards.add(new EvilswarmHeliotrope());
			//cards.add(new WormApocalypse());
			//cards.add(new WormBarses());
			//cards.add(new WormWarlord());
			//cards.add(new WormKing());
			//cards.add(new GauntletWarrior());
			//cards.add(new GaiaMidnight());
			//cards.add(new GilfordLegend());
			cards.add(new ReinforcementsArmy());
			//cards.add(new BlockGolem());
			//cards.add(new DokiDoki());
			//cards.add(new GiantSoldierSteel());
			//cards.add(new RainbowJar());
			cards.add(new WingedKuriboh9());
			//cards.add(new WingedKuriboh10());
			//cards.add(new MagicalStone());
			//cards.add(new Kuribohrn());
			//cards.add(new DropOff());
			cards.add(new PowerGiant());
			cards.add(new RainbowBridge());
			cards.add(new EarthGiant());
			//cards.add(new RainbowKuriboh());
			//cards.add(new ClearKuriboh());
			//cards.add(new Linkuriboh());
			//cards.add(new GiantTrapHole());
			//cards.add(new BigEye());
			cards.add(new YamiForm());
			cards.add(new RainbowOverdragon());
			//cards.add(new RainbowGravity());
			//cards.add(new RainbowLife());
			cards.add(new SilverApples());
			//cards.add(new DarklordSuperbia());
			cards.add(new LightningVortex());
			//cards.add(new BlackPendant());
			//cards.add(new LightningRodLord());
			cards.add(new ForbiddenLance());
			//cards.add(new FutureFusion());
			//cards.add(new ElectromagneticShield());
			//cards.add(new Electrowhip());
			//cards.add(new FuryFire());
			//cards.add(new MudGolem());
			//cards.add(new Mudora());
			//cards.add(new MudragonSwamp());
			//cards.add(new FlameTiger());
			//cards.add(new RockSunrise());
			//cards.add(new UltraPolymerization());
			cards.add(new MillenniumScorpion());
			//cards.add(new Metronome());
			cards.add(new OneForOne());
			//cards.add(new OrbMetronome());
			cards.add(new Solidarity());
			//cards.add(new Overworked());
			cards.add(new Jinzo());
			cards.add(new GolemSentry());
			cards.add(new Blockman());
			//cards.add(new AttackTheMoon());
			cards.add(new EarthEffigy());
			//cards.add(new DestroyerGolem());
			//cards.add(new DummyGolem());
			cards.add(new GemElephant());
			cards.add(new GemArmadillo());
			cards.add(new RisingEnergy());
		}

		if (full) {
			// cards.add(some card)
		}
		// cards.add(some card)

		// Creators
		if (!DuelistMod.persistentDuelistData.CardPoolSettings.getRemoveCreator()) { cards.add(new TheCreator()); cards.add(new DarkCreator()); }

		// Ascension-locked cards
		if (AbstractDungeon.ascensionLevel < 10)
		{
			cards.add(new DestructPotion());
			cards.add(new Wiseman());
		}

		if (AbstractDungeon.ascensionLevel < 15)
		{
			cards.add(new DianKeto());
			cards.add(new RedMedicine());
			cards.add(new Reload());
			cards.add(new ForbiddenChalice());
		}

		boolean p1Wins = StartingDeck.PHARAOH_I.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		boolean p2Wins = StartingDeck.PHARAOH_II.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		boolean p3Wins = StartingDeck.PHARAOH_III.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		boolean p4Wins = StartingDeck.PHARAOH_IV.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		boolean p5Wins = StartingDeck.PHARAOH_V.getActiveConfig().getStats().getVictories().getAllRuns() > 0;
		if (p1Wins || p2Wins || p3Wins || p4Wins || p5Wins) {
			cards.add(new PharaohBlessing());
			cards.add(new TombOfThePharaoh());
			if (AbstractDungeon.ascensionLevel < 15) {
				cards.add(new RainbowMedicine());
			}
		}

		return cards;
	}
}
