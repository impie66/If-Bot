
import java.lang.reflect.Constructor;		
import java.math.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashSet;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.util.Collections;
import java.util.HashMap;
import java.util.Collection;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.lang.*;
import bwapi.*;
import bwapi.Pair;
import bwta.BWTA;
import bwta.BaseLocation;
import bwta.Chokepoint;
import jfap.*;
import javafx.util.*;
import  sun.audio.*;
import  java.io.*;
import java.io.File;


public class TestBot1 extends DefaultBWListener {

	private int Workers = 0;
	private int AMPS = 0;
	private int MPS = 0;
	private TilePosition LastBuild;
	private int needs;
	private int GPS = 0;
	private int income = 0;
	private int MaxWorkers = 17;
	private int MaxRacks = 3;
	private int Bases = 0;
	private int MaxBases = 4;
	private int SavingAntiFuck = 0;
	private int Racks = 0;
	private int Academy = 0;
	private int Gases = 0;
	private int MaxGases = 0;
	private Unit scouter;
	private boolean HasScoutUnit;
	private int scoutID = 0;
	private int Factories = 0;
	private int MaxFactories = 2;
	private int StarPorts = 0;
	private int TSF = 0;
	private int Marines = 0;
	private int Tanks = 0;
	private int Bats = 0;
	private int Gol = 0;
	private int MaxGol = 0;
	private int Medics = 0;
	private int walker = 0;
	private int GroundThreat = 0;
	private int AirThreat = 0;
	private int Tick = 0;
	private int AttackTick = 0;
	private int Mines = 0;
	private int Bays = 0;
	private int Turrets = 0;
	private int Armor = 0;
	private int MarinesNeed = 10;
	private int BatsNeed = 4;
	private int MedicsNeed = 4;
	private int AddNeeds = 0;
	private int Vultures = 0;
	private int VulturesMax = 7;
	private int attackNum = 0;
	private boolean buildwait = false;
	private boolean orderRetreat = false;
	private int Bunks = 0;
	private int LastX = 0;
	private int LastY = 0;
	private boolean HasExpanded = false;
	private int APM = 0;
	private int enemyRace = 0;
	private int ArmySize = 0;
	private int forceSupply = 0;
	private int supplyBuilding = 0;
	private int Tech = 0;
	private int DifBuild = 1;
	private int MilUnits = 0;
	private int EnemyUnits = 0;
	private int bwub = 0;
	private boolean attacking = false;
	private boolean expanding = false;
	private boolean hasAttackpos;
	private Position enemyBasePos;
	private Unit Commander;
	private int CommanderID;
	private boolean HasCommander = false;
	private boolean ExpandEnabled = true;
	private Color EColor;
	private TilePosition ExpandPos;
	private boolean isExpanding = false;
	private boolean saving = false;
	private int reserves = 0;
	private int reservesgas = 0;
	private TilePosition lastExpandPos;
	private Position MainChoke;
	private Position Choke;
	private TilePosition BasePos;
	private boolean cheats = true;
	private HashSet currentBuildPlacements = new HashSet();
	private HashSet baseLocations = new HashSet();
	private TilePosition NewBuild;
	private boolean AcademyBuilt = false;
	private boolean AcademyFinshed = false;
	private Mirror mirror = new Mirror();
	private int buildWaitFix = 0;
	private int ExpansionNumber = 0;
	private Game game;
	private UnitType buildingName;
	private Player self;
	private Unit GetBuilder;
	private int attack;
	private int RacksBuilding;
	private boolean ScoutSent;
	private Unit CCBuilder = null;
	private BaseLocation BaseLocation;
	private boolean BunkerStarted = false;
	private boolean BunkerFinshed = true;
	private boolean buildingArmor = false;
	private boolean armorFinshed = false;
	private boolean scienceStarted = false;
	private boolean scienceFinished = false;
	private int factorybuilding = 0;
	ArrayList<Integer> repairingBuildings = new ArrayList<Integer>();
	ArrayList<Position> enemyBuildingMemory = new ArrayList<Position>();
	ArrayList<BaseLocation> claimedBaseLocations = new ArrayList<BaseLocation>();
	ArrayList<Unit> enemyUnits = new ArrayList<Unit>();
	ArrayList<Unit> enemyWorkers = new ArrayList<Unit>();
	ArrayList<Unit> myUnits = new ArrayList<Unit>();
	ArrayList<Unit> enemyRushUnits = new ArrayList<Unit>();
	ArrayList<Unit> enemyBases = new ArrayList<Unit>();
	ArrayList<Unit> myMinerals = new ArrayList<Unit>();
	ArrayList<Unit> gasWorkers = new ArrayList<Unit>();
	ArrayList<Unit> availableGas = new ArrayList<Unit>();
	ArrayList<Unit> constructingWorkers = new ArrayList<Unit>();
	ArrayList<UnitType> buildTypes = new ArrayList<UnitType>();
	ArrayList<Unit> myWorkers = new ArrayList<Unit>();
	ArrayList<Unit> myComSats = new ArrayList<Unit>();
	ArrayList<Unit> myMedics = new ArrayList<Unit>();
	ArrayList<Unit> productionBuildings = new ArrayList<Unit>();
	ArrayList<Unit> bunkersFilled = new ArrayList<Unit>();
	ArrayList<Unit> bunkerUnits = new ArrayList<Unit>();
	ArrayList<Unit> scoredBuildings = new ArrayList<Unit>();
	ArrayList<Position> ScanLocations = new ArrayList<Position>();
	ArrayList<Region> myRegions = new ArrayList<Region>();
	ArrayList<Unit> enemyFlyers = new ArrayList<Unit>();
	ArrayList<Unit> enemyBuildings = new ArrayList<Unit>();
	ArrayList<Integer> fapIDs = new ArrayList<Integer>();
	ArrayList<Region> enemyChokes = new ArrayList<Region>();
	ArrayList<UnitType> pBuildings = new ArrayList<UnitType>();
	ArrayList<Pair<Unit, UnitType>> pWorkers = new ArrayList<Pair<Unit, UnitType>>();
	ArrayList<UnitType> pWorkersBuilds = new ArrayList<UnitType>();
	ArrayList<UnitType> pBuildingsBuilt = new ArrayList<UnitType>();
	ArrayList<Integer> pBuildingsBuiltAmount = new ArrayList<Integer>();
	ArrayList<Integer> pAmount = new ArrayList<Integer>();
	ArrayList<TilePosition> pPosition = new ArrayList<TilePosition>();
	ArrayList<Unit> myBunkers = new ArrayList<Unit>();
	ArrayList<Unit> claimedGas = new ArrayList<Unit>();
	ArrayList<Unit> enemyAttackers = new ArrayList<Unit>();
	HashMap<Integer, Integer> bunkersSize = new HashMap<>();
	ArrayList<UnitType> pUnits = new ArrayList<UnitType>();
	HashMap <Integer, Integer> playerScores = new HashMap<>();
	HashMap<Integer, ArrayList<Position>> playerBuildings = new HashMap<>();
	private int buildingTick = 0;
	private int savetries = 0;
	private int enemyRaceBonus = 0;
	private int LastBuildTick = 0;
	private TilePosition LastBunkerPos;
	private int supplyBuildingMax = 1;
	private boolean AlreadyExpanding = false;
	private boolean EnablePrints = false;
	private boolean BayCompleted = false;
	private boolean StealthUnitsDetected = false;
	private boolean SafetoExpand = false;
	private boolean ExpandPlacing = false;
	private Position RegroupPos;
	private int FactoriesBuilding = 0;
	private boolean needsToExpand = false;
	private String Strategy = null;
	private int GameSpeed = 0;
	private int macroBuildings = 0;
	private Position ralleyPoint = null;
	private TilePosition comsatLocation;
	int DifBuildMax = 4;
	Unit macrobuilder;
	boolean buildingMacroBuilding = false;
	boolean simEnabled = true;
	private int detectionNeeded = 2; 
	private int defenceCallFrames = 30;
	boolean defenderCall = true;
	boolean BCTech = false;
	int totalFrames = 0;
	int simCallFrames = 0;
	int enemyFrames = 0;
	int checkBases = 0;
	int PortsBuilding = 0;
	int bunkersBuilding = 0;
	int MarinesNeedBonus = 0;
	String Strats = "Unknown";
	int updateStrategy = 0;
	int fapMyScores = 0;
	int fapEnemyScores = 0;
	int canExpandCheck = 0;
	boolean ValidBasesClaimed = false;
	int expandFrames = 0;
	boolean NextCallToAttack = false;
	int LastExpandFrame = 0;
	boolean startedDet = false;
	boolean finishedDet = true;
	int SupplyDepotsMax = 1;
	int ExpandingBonus = 0;
	int enemyGhostPoints = 0;
	int MaxBunks;
	int FullAttacks = 0;
	int lastExpandCheck = 0;
	boolean drawOrderLines = false;
	int searchSiege = 0;
	int Targets = 0;
	int savingUnFreeze = 0;
	boolean siegeResearched = true;
	int SVCheck = 0;
	int lastCheckUnits = 0;
	int fapEnemyHighest = 0;
	boolean sdsddhgfio = false;
	int blindCounts = 0;
	int tempBunks = 0;
	int customTargets = 0;
	int estimatedEnemyScore = 0;
	int lastEst = 0;
	int lureCheck = 0;
	int enemyDefenceScore = 0;
	int AggressiveNess = 200;
	int placementIncrease = 5;
	String focus;
	boolean ForcingExpand = false;
	int checkInvaders = 0;
	int InvadersScore = 0;
	UnitType NextTech = null;
	boolean TeamGameMode = false;
	int TeamModeTargetPlayer = 10;
	boolean DoneCreatingList = false;
	int enemyRushScore = 0;


	public void run() {
		mirror.getModule().setEventListener(this);
		mirror.startGame();
		
	}


	public void onUnitCreate(Unit unit) {
		boolean isMilitray = IsMilitrayUnit(unit);
	

		if(pBuildings.isEmpty() == false){
			if(unit.getType().isBuilding() == true && pBuildings.get(0) == unit.getType() && unit.getPlayer() == self){
				game.sendText("Priority Building Done! " + unit.getType().toString());
				pBuildings.remove(0);
				pWorkers.remove(0);
				buildTypes.remove(unit.getType());
				pPosition.remove(0);
				if(pBuildingsBuilt.contains(unit.getType()) == false){
					pBuildingsBuilt.add(unit.getType());
				}
				if(pBuildings.isEmpty() == true){
					pAmount.remove(0);
				}

			}
			
		}	
		
		if(unit.getType() == UnitType.Terran_Physics_Lab){
			BCTech = true;
		}
		

		if(unit.getType().isBuilding() == true){
			LastBuildTick = totalFrames + 130;
		}
		
		if(unit.getType() == UnitType.Terran_Starport){
			PortsBuilding = PortsBuilding + 1;
		}

		if (unit.getType() == UnitType.Terran_Bunker && unit.getPlayer() == self) {
			int myID = unit.getID();
			if(bunkersSize.containsValue(myID) == false){
				bunkersSize.put(myID, 0);
			}
			LastBunkerPos = unit.getTilePosition();
			bunkersBuilding = bunkersBuilding + 1;
			tempBunks--;
		}

		if (unit.getType() == UnitType.Terran_SCV && unit.getPlayer() == self) {
			Workers = Workers + 1;
		}

		if (unit.getType() == UnitType.Terran_SCV && HasScoutUnit == false && unit.getPlayer() == self) {
			scouter = unit;
			HasScoutUnit = true;
			scoutID = scouter.getID();
		}

		if (unit.getType() == UnitType.Terran_Command_Center && unit.getPlayer() == self) {
			Position pos = unit.getPosition();
			lastExpandPos = unit.getTilePosition();
			if(Bases > 1){
				LastExpandFrame = totalFrames + 1500;
				MaxRacks = MaxRacks + 2;
				MaxFactories = MaxFactories + 1;
			}
			ExpandingBonus = 0;	
			isExpanding = false;
			expanding = false;
			needsToExpand = false;
			ExpandPlacing = false;
			Bases = Bases + 1;
			buildwait = false;
			saving = false;
			AlreadyExpanding = true;


			if(claimedBaseLocations.contains(BWTA.getNearestBaseLocation(pos)) == false){
				claimedBaseLocations.add(BWTA.getNearestBaseLocation(pos));
			}
			
			if(Bases == 2){
			startedDet = false;
			Region baseChoke = game.getRegionAt(BWTA.getNearestChokepoint(unit.getPosition()).getCenter());
			LastBunkerPos = baseChoke.getCenter().toTilePosition();
			MaxBunks = MaxBunks + 2;
			boolean kilo = ShouldMoveRalleyPoint(unit.getPosition());
				if(kilo == true){
					ralleyPoint = baseChoke.getCenter();
				}
			
			}	
			
			for(Region region : game.getAllRegions()){
				if(region.getDistance(unit.getRegion()) < 800 && myRegions.contains(region) == false && region.isAccessible() == true){
					myRegions.add(region);
				}
			}

			
			
		}

		if (unit.getType() == UnitType.Terran_Command_Center && unit.getPlayer() == self) {
			Position pos = unit.getPosition();
			income = income + (int) (BWTA.getNearestBaseLocation(pos).getMinerals().size() * 5);
			MaxGases = MaxGases + BWTA.getNearestBaseLocation(pos).getGeysers().size();
			for (Unit minerals : BWTA.getNearestBaseLocation(pos).getMinerals()) {
				if (myMinerals.contains(minerals) == false) {
					myMinerals.add(minerals);
					//System.out.println("Adding mineral to claimed mineral's list with size of: " + myMinerals.size());
				}
			}
			
			for (Unit minerals : BWTA.getNearestBaseLocation(pos).getGeysers()) {
				if (claimedGas.contains(minerals) == false) {
					claimedGas.add(minerals);
				}
			}
		}
		
		if (unit.getType() == UnitType.Terran_Barracks && unit.getPlayer() == self) {
			ScoutSent = true;
			RacksBuilding = RacksBuilding + 1;
			supplyBuildingMax = 2;
			buildwait = false;
			saving = false;
			reserves = reserves - unit.getType().mineralPrice();
		}

		if (unit.getType() == UnitType.Terran_Refinery && unit.getPlayer() == self) {
			Gases = Gases + 1;
			Tech = Tech + 1;
			buildwait = false;
			reserves = reserves - unit.getType().mineralPrice();
		}

		if (unit.getType() == UnitType.Terran_Academy && unit.getPlayer() == self) {
			AcademyBuilt = true;
			Tech = Tech + 1;
			reserves = reserves - unit.getType().mineralPrice();
			buildwait = false;
			saving = false;
		}

		if (unit.getType() == UnitType.Terran_Armory && unit.getPlayer() == self) {
			reserves = reserves - unit.getType().mineralPrice();
			reserves = reserves - unit.getType().gasPrice();
			buildwait = false;
			saving = false;
		}
		if (unit.getType() == UnitType.Terran_Engineering_Bay && unit.getPlayer() == self) {
			BayCompleted = true;;
			reserves = reserves - unit.getType().mineralPrice();
			buildwait = false;
			saving = false;
		}
		if (unit.getType() == UnitType.Terran_Missile_Turret && unit.getPlayer() == self) {
			Turrets = Turrets + 1;
			startedDet = true;
			buildwait = false;
			saving = false;
		}

		if (unit.getType() == UnitType.Terran_Supply_Depot && unit.getPlayer() == self) {
			supplyBuilding = supplyBuilding + 1;
			reserves = reserves - unit.getType().mineralPrice();
			buildwait = false;
			saving = false;
		}

		if (unit.getType() == UnitType.Terran_Factory && unit.getPlayer() == self) {
			Tech = Tech + 1;
			factorybuilding = factorybuilding - 1;
			reserves = reserves - unit.getType().mineralPrice();
			buildwait = false;
			saving = false;
			FactoriesBuilding = FactoriesBuilding + 1;
		}

		if (unit.getType() == UnitType.Terran_Starport && unit.getPlayer() == self) {
			reserves = reserves - unit.getType().mineralPrice();
			reserves = reserves - unit.getType().gasPrice();
			buildwait = false;
			saving = false;
		}

		if (unit.getType() == UnitType.Terran_Science_Facility && unit.getPlayer() == self) {
			buildwait = false;
			saving = false;
			scienceStarted = true;
		}

		if (unit.getType() == UnitType.Terran_Marine && unit.getPlayer() == self) {
			Marines = Marines + 1;
		}

		if (unit.getType() == UnitType.Terran_Firebat && unit.getPlayer() == self) {
			Bats = Bats + 1;
		}

		if (unit.getType() == UnitType.Terran_Medic && unit.getPlayer() == self) {
			Medics = Medics + 1;
		}

		if (unit.getType() == UnitType.Terran_Vulture && unit.getPlayer() == self) {
			Vultures = Vultures + 1;
		}

		if (unit.getType() == UnitType.Terran_Siege_Tank_Tank_Mode && unit.getPlayer() == self) {
			Tanks = Tanks + 1;
		}

		if (unit.getType() == UnitType.Terran_Medic && unit.getPlayer() == self) {
			Medics = Medics + 1;
		}

		if (unit.getType() == UnitType.Terran_Goliath && unit.getPlayer() == self) {
			
		}
		
		if (unit.getType() == UnitType.Terran_Science_Vessel && unit.getPlayer() == self) {
			TSF = TSF + 1;
		}

	}

	public void onEnd(boolean isWinner) {
		// A little bit of kung pow doesn't hurt anyone.
		Random rand = new Random();
		int n = rand.nextInt(3) + 1;

		if (isWinner == true && n == 1) {
			game.sendText("GG");

		}
		if (isWinner == true && n == 2) {
			game.sendText("Ha, face to foot style, how'd you like it?");

		}
		if (isWinner == true && n == 3) {
			game.sendText("Oh yeah? Try my nuts to your fist style.");

		}
		if (isWinner == false && n == 1) {
			game.sendText(
					"I must apologize for Wimp Lo, he is an idiot. We have purposely trained him wrong, as a joke");
		}
		if (isWinner == false && n == 2) {
			game.sendText("Please stop, Wimp Lo sucks as a fighter, a child could beat him.");
		}
		if (isWinner == false && n == 3) {
			game.sendText(" I'm bleeding, making me the victor.");
		}

	}

	public void onUnitMorph(Unit unit) {
		if (unit.getType() == UnitType.Terran_Refinery && unit.getPlayer() == self) {
			Gases = Gases + 1;
			buildwait = false;
			saving = false;
		}

	}

	public void onUnitComplete(Unit unit) {
		boolean isMilitray = IsMilitrayUnit(unit);
	


		if (unit.getType() == UnitType.Terran_Barracks && unit.getPlayer().isEnemy(self)) {
			GroundThreat = GroundThreat + 2;
			enemyRace = 1;
		}
		
		if (unit.getPlayer().isEnemy(self) && unit.getType() == UnitType.Terran_Bunker || unit.getType() == UnitType.Protoss_Photon_Cannon || unit.getType() == UnitType.Zerg_Sunken_Colony ) {
				if(ScanLocations.contains(unit.getPosition()) == false){
					ScanLocations.add(unit.getPosition());
					}
		}
		
		


		if (unit.getType() == UnitType.Protoss_Gateway && unit.getPlayer().isEnemy(self)) {
			GroundThreat = GroundThreat + 4;


		}

		if (unit.getType() == UnitType.Terran_Factory && unit.getPlayer().isEnemy(self)) {
			GroundThreat = GroundThreat + 2;
			enemyRace = 1;
		}
		
		if (unit.getType() == UnitType.Zerg_Hatchery && unit.getPlayer().isEnemy(self)) {
			GroundThreat = GroundThreat + 2;
		}
		
		
		
		
		if(unit.getType() == UnitType.Terran_Barracks ||
		unit.getType() == UnitType.Terran_Factory ||
		unit.getType() == UnitType.Terran_Starport
		&& productionBuildings.contains(unit) == false){
			productionBuildings.add(unit);
		}
		
		if(isMilitray == true && unit.getType() != UnitType.Terran_Siege_Tank_Tank_Mode){
			if(ralleyPoint != null){
				if(InvadersScore == 0){
				unit.attack(ralleyPoint);
				}
			}
			
			if(ralleyPoint == null){
				Position choke = BWTA.getNearestChokepoint(self.getStartLocation()).getCenter();
				Region regions = game.getRegionAt(choke).getClosestAccessibleRegion();
				ralleyPoint = regions.getCenter();
				unit.attack(ralleyPoint);
			}
		}
		
		if(unit.getType().isWorker() == true && myWorkers.contains(unit) == false && unit.getPlayer() == self){
			myWorkers.add(unit);
		}
		
		if(unit.getType() == UnitType.Terran_Comsat_Station && myComSats.contains(unit) == false){
			 myComSats.add(unit);
		}
		
		if(unit.getType() == UnitType.Terran_Medic && myMedics.contains(unit) == false){
			 myMedics.add(unit);
		}
		
		if(unit.getType() == UnitType.Terran_Physics_Lab){
			BCTech = true;
		}
		
		if(unit.getType() == UnitType.Terran_Bunker && unit.getPlayer() == self){
			bunkersBuilding = bunkersBuilding - 1;
		}

		
		if (unit.getPlayer() == self && myUnits.contains(unit) == false && unit.getType().isWorker() == false
				&& unit.getType().isBuilding() == false && unit.getType().isSpell() == false
				&& unit.getType() != UnitType.Terran_Vulture_Spider_Mine) {
			myUnits.add(unit);
			int score = getScoreOf(unit);
			fapMyScores = fapMyScores + score;

		}
		
		if (unit.getType() == UnitType.Terran_Refinery && unit.getPlayer() == self) {
			int local = 1;
			Unit Gas;
			Gas = unit;
			for (Unit myUnits : myWorkers) {
				if (local <= 2) {
					if (myUnits.getType() == UnitType.Terran_SCV && myUnits.isGatheringMinerals() == true
							&& myUnits.getID() != scoutID) {
						myUnits.gather(unit, false);
						gasWorkers.add(myUnits);
						local = local + 1;
						if (local > 3) {
							break;
						}
					}
				}
			}
		}

		if (unit.canAttack() == true && unit.getType().isWorker() == false && unit.getType().isBuilding() == false) {
			MilUnits = MilUnits + 1;
		}

		if (unit.getType() == UnitType.Terran_Bunker && unit.getPlayer() == self) {
			LastBunkerPos = unit.getTilePosition();
			BunkerStarted = false;
			Bunks = Bunks + 1;
			ralleyPoint = unit.getPosition();
			
			
		}
		
		if (unit.getType() == UnitType.Terran_Command_Center && unit.getPlayer() == self) {
			expanding = false;
			AlreadyExpanding = false;
			ExpandPlacing = false;
			buildwait = false;
			saving = false;
			int local = 0;
			for (Unit myUnits : myWorkers) {
				if (local <= 6) {
					if (myUnits.getType() == UnitType.Terran_SCV && myUnits.isGatheringMinerals() == true) {
						myUnits.move(unit.getPosition());
						local = local + 1;
					}
				}
				else{
					break;
				}
				if(myWorkers.size() < 3){
					break;
				}
			}
		}
		
		
	
		
		if (unit.getType() == UnitType.Terran_Supply_Depot) {
			supplyBuilding = supplyBuilding - 1;
		}

		if (unit.getType() == UnitType.Terran_Siege_Tank_Tank_Mode && unit.getPlayer() == self
				&& HasCommander == false) {
			Commander = unit;
			CommanderID = unit.getID();
			HasCommander = true;
		}

		if (unit.getType() == UnitType.Terran_Barracks && unit.getPlayer() == self) {
			RacksBuilding = RacksBuilding - 1;
			Racks = Racks + 1;
		}

		if (unit.getType() == UnitType.Terran_Academy && unit.getPlayer() == self) {
			AcademyFinshed = true;
			int bonus = (estimatedEnemyScore / 100) + (InvadersScore / 25) + 1;
			MarinesNeedBonus = MarinesNeedBonus + bonus;
		}	

		if (unit.getType() == UnitType.Terran_Factory && unit.getPlayer() == self) {
			Factories = Factories + 1;
			FactoriesBuilding = FactoriesBuilding - 1;
			int bonus = (estimatedEnemyScore / 100) + (InvadersScore / 25) + 1;
			MarinesNeedBonus = bonus;
			if(DifBuildMax == 4){
				DifBuildMax = 4;
			}
		}

		if (unit.getType() == UnitType.Terran_Starport && unit.getPlayer() == self) {
			StarPorts = StarPorts + 1;
		}

		if (unit.getType() == UnitType.Terran_Armory && unit.getPlayer() == self) {
			Armor = Armor + 1;
		}

		if (unit.getType() == UnitType.Terran_Science_Facility && unit.getPlayer() == self && scienceFinished == false) {
			scienceFinished = true; 
			MaxFactories = MaxFactories + 1;
		}

		if (unit.getType() == UnitType.Terran_Engineering_Bay && unit.getPlayer() == self) {
			Bays = 1;
		}

	}

	public void onUnitDestroy(Unit unit) {
		
		if(enemyWorkers.contains(unit) == true){
			enemyWorkers.remove(unit);
		}
		
		
		if(enemyBuildings.contains(unit) == true){
			enemyBuildings.remove(unit);
		}
		
		
		int p = getGhostScore(unit);
		
		if(unit.getPlayer().isEnemy(self) == true && p != 0 && scoredBuildings.contains(unit) == true ){
			enemyGhostPoints = enemyGhostPoints - p;

		}
		
		if(unit.getPlayer().isEnemy(self) && unit.getType() == UnitType.Terran_Bunker || unit.getType() == UnitType.Protoss_Photon_Cannon || unit.getType() == UnitType.Zerg_Sunken_Colony){
		int k = getScoreOf(unit);
		enemyDefenceScore = enemyDefenceScore - k;
		}
		
		if(unit.getType().isResourceDepot() == true && enemyBases.contains(unit) == true){
			enemyBases.remove(unit);
		}
		
		if(enemyRushUnits.contains(unit) == true){
			enemyRushUnits.remove(unit);
			int score = getScoreOf(unit);
			enemyRushScore = enemyRushScore - score;
		}
		
		if(constructingWorkers.contains(unit) == true){
			constructingWorkers.remove(unit);
			saving = false;
			buildwait = false;
			
		}
		
		if(productionBuildings.contains(unit) == true){
			productionBuildings.remove(unit);
		}
		
		
		if(unit.getType().isWorker() == true && myWorkers.contains(unit) == true){
			myWorkers.remove(unit);
		}
		
		if(unit.getType() == UnitType.Terran_Comsat_Station && myComSats.contains(unit) == true){
			 myComSats.remove(unit);
		}
		
		if(unit.getType() == UnitType.Terran_Medic && myMedics.contains(unit) == true){
			 myMedics.remove(unit);
		}
		
		
		
		
		if(repairingBuildings.contains(unit) == true){
			int index = repairingBuildings.indexOf(unit);
			repairingBuildings.remove(index);
		}
		
		
		if(enemyFlyers.contains(unit) == true){
			enemyFlyers.remove(unit);
		}
		
		if (enemyUnits.contains(unit) == true) {
			int index = enemyUnits.indexOf(unit);
			enemyUnits.remove(index);
			int score = getScoreOf(unit);
			estimatedEnemyScore = estimatedEnemyScore - score;
			
			if(TeamGameMode == true){
			int pID = unit.getPlayer().getID();
			int pScore = playerScores.get(pID);
			int newScore = pScore - score;
			playerScores.put(pID, newScore);
			}
			
		}
		
		if (fapIDs.contains(unit.getID()) == true) {
			fapIDs.remove(unit.getID());
		}

		if (myUnits.contains(unit) == true) {
			int index = myUnits.indexOf(unit);
			myUnits.remove(index);
			int score = getScoreOf(unit);
			fapMyScores = fapMyScores - score;
			// game.sendText("Unit " + unit.getType().toString() + " is now
			// removered from myUnit's list with current size of " +
			// myUnits.size());
		}

		if (unit == CCBuilder) {
			expanding = false;
			saving = false;
			AlreadyExpanding = false;
			ExpandPlacing = false;
			needsToExpand = false;
			if (claimedBaseLocations.contains(BWTA.getNearestBaseLocation(ExpandPos)) == true) {
				int index = claimedBaseLocations.indexOf(BWTA.getNearestBaseLocation(ExpandPos));
				claimedBaseLocations.remove(index);
			}

		}
		
		if(gasWorkers.contains(unit) == true){
			int index = gasWorkers.indexOf(unit);
			gasWorkers.remove(index);
			game.sendText("Removing gas worker at index: " + index );
		}

		if (unit.isConstructing() == true && unit.getPlayer() == self) {
			Unit building = unit.getOrderTarget();
			Unit newbuilder = GetWorker();
			if (newbuilder.exists() == true && building.exists() == true) {
				newbuilder.rightClick(building);
			}
		}

		if (unit.isRepairing() == true && unit.getPlayer() == self) {
			Unit building = unit.getOrderTarget();
			int buildingID = unit.getOrderTarget().getID();
			if (building.getHitPoints() != building.getType().maxHitPoints()
					&& repairingBuildings.contains(buildingID) == true) {
				int index = repairingBuildings.indexOf(buildingID);
				repairingBuildings.remove(index);
			}

		}

		if (unit.getType() == UnitType.Resource_Mineral_Field
				|| unit.getType() == UnitType.Resource_Mineral_Field_Type_2
				|| unit.getType() == UnitType.Resource_Mineral_Field_Type_3) {
			income = income - (int) 5;
		}

		if (unit.getID() == CommanderID) {
			HasCommander = false;
		}


		if (unit.getType() == UnitType.Terran_Marine && unit.getPlayer() == self) {
			Marines = Marines - 1;
		}
		
		if (unit.getType() == UnitType.Terran_Vulture && unit.getPlayer() == self) {
			Vultures = Vultures - 1;
		}
		
		if (unit.getType() == UnitType.Terran_Science_Vessel && unit.getPlayer() == self) {
			TSF = TSF - 1;
		}
		
		if (unit.getType() == UnitType.Terran_Firebat && unit.getPlayer() == self) {
			Bats = Bats - 1;
		}

		if (unit.getType() == UnitType.Terran_Command_Center && unit.getPlayer() == self) {
			Position pos = unit.getPosition();
			Bases = Bases - 1;	
			income = income - (int) (BWTA.getNearestBaseLocation(pos).getMinerals().size() * 5);
			MaxGases = MaxGases - BWTA.getNearestBaseLocation(pos).getGeysers().size();
			if (claimedBaseLocations.contains(BWTA.getNearestBaseLocation(pos)) == true) {
				int index = claimedBaseLocations.indexOf(BWTA.getNearestBaseLocation(pos));
				claimedBaseLocations.remove(index);
				for (Unit unit1 : BWTA.getNearestBaseLocation(pos).getMinerals()) {
					if (myMinerals.contains(unit1) == true) {
						int index1 = myMinerals.indexOf(unit1);
						myMinerals.remove(index1);
					}

				}

			}

		}
		
		
		if (unit.getType() == UnitType.Terran_Command_Center && unit.getPlayer() == self) {
			Position pos = unit.getPosition();
			BaseLocation location = BWTA.getNearestBaseLocation(pos);
			int index = claimedBaseLocations.indexOf(BWTA.getNearestBaseLocation(pos));
			if (index != 0) {
				claimedBaseLocations.remove(index);
				}

		}

		if (unit.getType() == UnitType.Terran_SCV && unit.getPlayer() == self && unit.getID() == scoutID) {
			HasScoutUnit = false;

		}
		
		if (unit.getType() == UnitType.Terran_Medic && unit.getPlayer() == self) {
			Medics = Medics - 1;
		}

		if (unit.getType() == UnitType.Terran_Barracks && unit.getPlayer() == self) {
			Racks = Racks - 1;
		}

		if (unit.getType() == UnitType.Terran_Academy && unit.getPlayer() == self) {
			Academy = 0;
		}

		if (unit.getType() == UnitType.Terran_Factory && unit.getPlayer() == self) {
			Factories = Factories - 1;
		}

		if (unit.getType() == UnitType.Terran_SCV && unit.getPlayer() == self) {
			Workers = Workers - 1;
		}

		if (unit.getType() == UnitType.Terran_SCV && unit.isGatheringGas() == true
				|| unit.isCarryingGas() == true && unit.getPlayer() == self) {
			Unit gas = unit.getTarget();
			Unit myUnit = GetWorker();
			if (gas.exists() == true && myUnit.exists() == true) {
				myUnit.gather(gas);
			}

		}

		if (unit.getType() == UnitType.Terran_SCV && unit.isConstructing() == true) {
			Unit target = unit.getTarget();
			if(target != null){
				if (target.getType() == UnitType.Terran_Command_Center) {
					expanding = false;
					saving = false;
				}
			}
		}
		
		if (unit.getType() == UnitType.Terran_Goliath && unit.getPlayer() == self) {
			Gol = Gol - 1;
		}
		
		if (unit.getType() == UnitType.Terran_Bunker && unit.getPlayer() == self) {
			Bunks = Bunks - 1;
			if(myBunkers.contains(unit) == true){
				int index = myBunkers.indexOf(unit);
				myBunkers.remove(unit);
				bunkersSize.remove(index);
			}
		
		}


	}

	public void onUnitDiscover(Unit unit) {
		 
		boolean ismil = IsMilitrayUnit(unit);
		//System.out.println("Is hostile? " + unit.getPlayer().isEnemy(self));
		//System.out.println("Is Mil" + ismil + " Unit: " + unit.getType().toString());
		
		
		if(unit.getPlayer().isEnemy(self) == true && unit.getType().isWorker() == true && enemyWorkers.contains(unit) == false){
			enemyWorkers.add(unit);
		}
		
		if(unit.getPlayer().isEnemy(self) == true && unit.getType().isBuilding() == true && enemyBuildings.contains(unit) == false){
			int p = getScoreOf(unit);
			enemyBuildings.add(unit);
			CheckBuilding(unit);
			if(unit.getPlayer() != self && unit.getType() == UnitType.Terran_Bunker || unit.getType() == UnitType.Protoss_Photon_Cannon || unit.getType() == UnitType.Zerg_Sunken_Colony){
			enemyDefenceScore = enemyDefenceScore + p;;
			}
		}
		
		
		int p = getGhostScore(unit);
		
		if(unit.getPlayer() != self && p != 0 && scoredBuildings.contains(unit) == false){
			enemyGhostPoints = enemyGhostPoints + p;
			scoredBuildings.add(unit);
		}
		
		
		
		if(unit.getType().isResourceDepot() == true && enemyBases.contains(unit) == false && unit.getPlayer().isEnemy(self)){
			enemyBases.add(unit);
			Position pos = unit.getPosition();
			BaseLocation base = BWTA.getNearestBaseLocation(unit.getTilePosition());
			Chokepoint choke = BWTA.getNearestChokepoint(pos);
			Region cRegion = game.getRegionAt(choke.getCenter());
			if(enemyChokes.contains(cRegion) == false){
				enemyChokes.add(cRegion);
			}
			for(Region region : cRegion.getNeighbors()){
				if(region.isAccessible() == true && enemyChokes.contains(region) == false){
					enemyChokes.add(region);
				}
			}


		}
		
		
		if(unit.getPlayer() == game.enemy() && ismil == true && enemyRushUnits.contains(unit) == false && totalFrames < 7500){
			enemyRushUnits.add(unit);
			int score = getScoreOf(unit);
			enemyRushScore = enemyRushScore + score;
		}

		if (unit.getPlayer().isEnemy(self) == true && enemyUnits.contains(unit) == false && ismil == true && unit.getType().isBuilding() == false) {
			enemyUnits.add(unit);
			int score = getScoreOf(unit);
			if(TeamGameMode == true){
			int pID = unit.getPlayer().getID();
			int pScore = playerScores.get(pID);
			int newScore = pScore + score;
			playerScores.put(pID, newScore);
			}
			estimatedEnemyScore = estimatedEnemyScore + score;
			
		}
		
		
		
		if (unit.getPlayer().isEnemy(self) == true && fapIDs.contains(unit.getID()) == false && ismil == true) {
			fapIDs.add(unit.getID());
		}
		
		if(unit.getType().isFlyer() == true && unit.getPlayer() == game.enemy() && unit.getType().isBuilding() == false && unit.canAttack() == true && unit.getType() != UnitType.Protoss_Interceptor && unit.getType().groundWeapon().damageAmount() > 0){
			AirThreat = AirThreat + 1;
		}


		if (unit.getType() == UnitType.Protoss_Gateway && unit.getPlayer().isEnemy(self)) {
			enemyRace = 2;
		}


		if (unit.getType() == UnitType.Terran_Command_Center && unit.getPlayer().isEnemy(self)) {
			hasAttackpos = true;
			enemyRace = 1;
		}
		if (unit.getType() == UnitType.Protoss_Nexus && unit.getPlayer().isEnemy(self)) {
			hasAttackpos = true;;
			enemyRace = 2;
		}
		

		
	
	}
	
	
	public void onNukeDetect(Position target){
		updateStrategy = 0;
		// TFW YOUR BOT TRIES TO REGROUP NICELY FOR THE NUKE
		for(Unit units: game.getUnitsInRadius(target, 500)){
				if(units.getPlayer() == self){
					Position regroup = RunFromPos(units, target);
						if(regroup != null){
								if(regroup.isValid() == true && units.isMoving() == false){
									units.move(regroup);
								}
						}
				}
		}
		

	}
	
	


	@Override
	public void onStart() {
		game = mirror.getGame();
		self = game.self();
		// Use BWTA to analyze map
		// This may take a few minutes if the map is processed first time!
		BWTA.readMap();
		BWTA.analyze();
		BasePos = self.getStartLocation().getPoint();
		Choke = BWTA.getNearestChokepoint(BasePos).getCenter();
		game.sendText("1800 Free Elo Ryan speaking how am i be of service?");
		if(game.isMultiplayer() == false){
			game.setLocalSpeed(GameSpeed);
		}

		if(game.getPlayers().size() > 3){
			TeamGameMode = true;
		}
		
		int numP = game.enemies().size();
		System.out.println("Amount of enemy players detected is: " + numP);
		
//		for (int i = 0; i < numP; i++) { 
//		    playerScores.add(0);
//		    playerBuildings.add(new ArrayList<Position>());
//		}

		
		if(TeamGameMode == true){
			for(Player players : game.enemies()){
				playerScores.put(players.getID(), 0);
				playerBuildings.put(players.getID(), new ArrayList<Position>());
				System.out.println(players.getName() + " Id is: " + players.getID());
			}
			DoneCreatingList = true;
			System.out.println("List building done");
			
		}
		
		if(TeamGameMode == true){
			if(playerScores.isEmpty() == true){
				System.out.println("Player scores is empty");
			}
			
			if(playerBuildings.isEmpty() == true){
				System.out.println("Player buildings is empty");
			}
		}
		
		if(TeamGameMode == false){
		Strategy = GetStrategy(game.enemy().getRace().toString());
		}
		// getExpands();
		BaseLocation = BWTA.getNearestBaseLocation(BasePos);
	
	}
	
	public void onUnitShow(Unit unit){
		
		if(estimatedEnemyScore > fapMyScores){
			UpdateStrats();
		}
		

		if(scouter != null){
			if(scouter.exists() && scouter.isCompleted() == true && scouter.isMoving() == true){
				if(unit.getPlayer().isEnemy(self) && unit.getOrder() == Order.AttackUnit && unit.getOrderTarget() == scouter){							
					game.drawCircleMap(unit.getPosition(), 30, bwapi.Color.Yellow);
					Position flee = GetKitePos2(scouter, unit);
					if(flee != null){
						if(flee.isValid() == true){
						scouter.move(flee);
						}
					}
								
				}
			}
		}
		
		if(unit.getPlayer().isEnemy(self)){	
			bwapi.Region rego = game.getRegionAt(unit.getOrderTargetPosition());
			
			if(myRegions.contains(rego) == true){
		        //System.out.println("Attacker Detected region");
			}
			else {
				//System.out.println("Not in one of my regions");
			}
			
			if(unit.getOrderTargetPosition().getApproxDistance(self.getStartLocation().toPosition()) < 2000){
				//System.out.println("Attacker Detected distance");
				InvadersScore = InvadersScore + getScoreOf(unit);
				//game.sendText("!");
			}
			
			if(totalFrames < 9000){
				if(fapMyScores < InvadersScore){
						int amount = Math.round(getScoreOf(unit) / 55);
						for (int i = 0; i < amount; i++){
							pUnits.add(UnitType.Terran_Marine);
						}
						System.out.println("Enemy Attack Detected, pUniting: " + amount + " Marines");
					}
			}
		}
		
		
		//end of onUnitShow
		
	}
	

	@Override
	public void onFrame() {
		AMPS = (int) (Workers * 2);
		MPS = (int) (AMPS * 0.14);
		GPS = Gases * 3;
		MaxGol = 3 + (AirThreat * 2);
		MaxWorkers = 2 + (myMinerals.size() * 1) + (MaxGases * 3);
		VulturesMax = (Tanks * 2) + 6;
		MarinesNeed = 5 + (Bunks * 4) + (Tanks * 5) + MarinesNeedBonus + (InvadersScore / 25) + (enemyRushScore / 50);
		MedicsNeed = Math.round(MarinesNeed / 4); 
		BatsNeed = 4;
		Tick = Tick + 1;
		buildingTick = buildingTick + 1;
		AddNeeds = AddNeeds + 1;
		needs = (Factories * 20) + (Racks * 20);
		APM = game.getAPM();
		game.enableFlag(1);
		// game.setTextSize(10);`
		game.drawTextScreen(10, 10, "Playing as " + self.getName() + " - " + self.getRace() + " And with.. " + APM
				+ " APM" + " With.." + game.getAverageFPS() + "FPS" + " Total Frames: " + totalFrames);
		game.drawTextScreen(10, 20, "I have " + Bases + " Bases and i have " + Factories + " Factories"
				+ " und ich Habe: " + Racks + " Barracks" + " And i have.. " + " " + myUnits.size() + "Militray units.");
		game.drawTextScreen(10, 30, enemyFlyers.size() + " Early game threat: " + enemyRushScore);
		game.drawTextScreen(10, 40, "EnemyUnits: " + enemyUnits.size() + " My Fap Score: " + fapMyScores + " Enemy Production Score: " + enemyGhostPoints + " Estimated Enemy Score: " + estimatedEnemyScore + " Enemy Defence Score: " + enemyDefenceScore);
		game.drawTextScreen(10, 50, "income: " + income + " " + needs + " needs: " + " Am i currently saving for an expansion: " + needsToExpand + " Am i currently expanding: " + expanding);
		//game.drawTextScreen(10, 30, "Versing " + game.enemy().getName() + " as "  + game.enemy().getRace() + " ");
		game.drawTextScreen(10, 60, "Strategy: " + Strats + " " + " Frames: " + updateStrategy);
		//game.drawTextScreen(10, 80, "Invaders: " + sScore);
		//game.drawTextScreen(10, 90, "Early Marine Amount: " + MarinesNeed);
		
//		if (game.getFrameCount() % game.getLatencyFrames() != 0) {
			
		
//		if(game.mapName() == "(2)ThirdWorld1.0" || game.mapName() == "(4)Sparkle1.1" ){
//			ExpandEnabled = false;
//			sdsddhgfio = true;
//		}
//		
		
		StringBuilder sPlayerScores = new StringBuilder("Enemy Player Scores:\n");
		StringBuilder sPlayerSize = new StringBuilder("Enemy Player Building Size:\n");
//		
		if(DoneCreatingList == true && playerScores.isEmpty() == false && playerBuildings.isEmpty() == false){
			for (Player p123 : game.enemies()){
				int pID = p123.getID();
				int pScore = playerScores.get(pID);
				int pBuildSize = playerBuildings.get(pID).size();
				sPlayerScores.append(p123.getName()).append(" ").append(pScore).append("\n");
				sPlayerSize.append(p123.getName()).append(" ").append(pBuildSize).append("\n");
				}
		}
			

			totalFrames = totalFrames + 1;
			updateStrategy = updateStrategy + 1;
			canExpandCheck = canExpandCheck + 1;
			checkInvaders++;
			
			
			if (supplyBuilding < 0) {
				supplyBuilding = 0;
			}
			
			
			if (lureCheck != 0){
				lureCheck++;
			}

			if(checkInvaders > 20){
				CheckInvaders();
				checkInvaders = 0;
			}
			
			if(lureCheck > 10){
				lureCheck = 0;
			}
			
			if (attacking == true) {
				Mines = Mines + 1;
			}
		
			if(lastExpandCheck != 0){
				lastExpandCheck = lastExpandCheck + 1; 
			}
			
			if(SVCheck != 0){
				SVCheck = SVCheck + 1;
			}
			
			if(SVCheck == 70){
				SVCheck = 0;
			}
			
			if(customTargets == 15){
				customTargets = 0;
			}
			
			if(customTargets > 0){
				customTargets++;
			}
			
			if(lastExpandCheck > 250){
				lastExpandCheck = 0;
			}
			
			if(savingUnFreeze != 0){
				savingUnFreeze = savingUnFreeze + 1; 
			}
			
			if(savingUnFreeze > 600){
				savingUnFreeze = 0;
			}
			
			if(self.minerals() > 700 && savingUnFreeze == 0 && saving == true && expanding == false){
				saving = false;
				game.sendText("Saving for something that doesnt exist? NOPE.");
				savingUnFreeze = 1;
			}
			
			if(totalFrames < 10000){
				
				MaxBunks = (enemyRushScore / 300) + 1;
				if(MaxBunks > 3){
					MaxBunks = 3;
				}
				
			}
			
			if(expanding == true){
				expandFrames = expandFrames + 1;
			}
			
			if(scienceFinished == true && scienceStarted == false){
				scienceStarted = true;
			}
			
			if (buildingTick > 30) {
				buildingTick = 0;
			}
			
			if(saving == true && LastBuildTick == 0){
				saving = false;
			}

//			if(saving == true && self.minerals() > 2000 && self.gas() > 500){
//				saving = false;
//				buildwait = false;
//			}


			// t = 1
			// p = 2
			// z = 3

			if (enemyRace > 0 && enemyRaceBonus == 0) {
				if (enemyRace == 1) {
					enemyRaceBonus = (int) 0.5;
				}

				if (enemyRace == 2) {
					enemyRaceBonus = (int) 0.5;
				}
				if (enemyRace == 3) {
					enemyRaceBonus = (int) 0.5;
				}
			}
				

			if (saving == true) {
				game.drawCircleMap(LastBuild.toPosition(), 25, bwapi.Color.Cyan, false);
				game.drawCircleMap(NewBuild.toPosition(), 25, bwapi.Color.Cyan, false);
			}
			

			if (scouter.isVisible() == true) {
				Position pos = scouter.getPoint();
				game.drawCircleMap(pos, 25, bwapi.Color.Purple, false);
			}

			if (expanding == true && CCBuilder.exists() == true) {
				Position pos = CCBuilder.getPoint();
				game.drawCircleMap(pos, 25, bwapi.Color.White, false);
			}

			if (income < needs && ExpandEnabled == true && LastExpandFrame < totalFrames && Bunks > 0 && Bases != 5 && needsToExpand == false){
				boolean canDoOfThat = CanExpand();
				if(canDoOfThat = true){
					needsToExpand = true;
				}
			}
			
			if(RegroupPos != null){
				game.drawCircleMap(RegroupPos, 35, bwapi.Color.Red, true);
			}
			
			if(defenderCall == false){
				defenceCallFrames = defenceCallFrames + 1;
			}
			
			if(defenceCallFrames >= 30){
				defenceCallFrames = 0;
				defenderCall = true;
			}
			
			if(simCallFrames != 0){
				simCallFrames = simCallFrames + 1;
			}
			
			if(simCallFrames > 20){
				simCallFrames = 0;
			}
			
			if(enemyFrames > 30){
				enemyFrames = 1;
			}
			
			
			if(searchSiege > 0){
				searchSiege = searchSiege + 1;
			}
			
			if(searchSiege == 30){
				searchSiege = 0;
			}
			
			if(Targets > 0){
				Targets = Targets + 1;
			}
			
			if(Targets == 30){
				Targets = 0;
			}
			
			if(enemyFrames != 0){
				enemyFrames = enemyFrames + 1;
			}
			
			if(enemyFrames > 30){
				enemyFrames = 0;
			}

			if(checkBases != 0){
				checkBases = checkBases + 1;
				
			}
			
			if(checkBases > 100){
				checkBases = 0;
			}
			
			if(updateStrategy >= AggressiveNess){
				UpdateStrats();
				updateStrategy = 0;
			}
			
			if(totalFrames > 8000 && enemyRushScore != 0){
				enemyRushScore = 0;
			}
			
			if(needsToExpand == true && saving == false && fapMyScores > InvadersScore){
				saving = true;
			}
			if (saving == true && self.minerals() >= 700 && self.gas() >= 300){
				if(pUnits.isEmpty() == true){
					for (Unit buildings : productionBuildings) {
						// best way to get the bot to build after its build
						// frozen is probably max the supply and let it spam.
						
						if (buildings.getType() == UnitType.Terran_Factory && self.minerals() >= 600
								&& self.gas() >= 300 && buildings.isIdle() == true) {
							buildings.train(UnitType.Terran_Siege_Tank_Tank_Mode);
						}
						if (buildings.getType() == UnitType.Terran_Barracks && self.minerals() >= 700
								 && AcademyBuilt == true && buildings.isIdle() == true) {
									buildings.train(UnitType.Terran_Marine);
						}
	
						if (buildings.getType() == UnitType.Terran_Starport && game.canMake(UnitType.Terran_Battlecruiser) == true && self.minerals() >= 700 && self.gas() >= 300 && buildings.isIdle() == true) {
							buildings.train(UnitType.Terran_Battlecruiser);
					}
	
					}
				}
				else{
					UnitType type = pUnits.get(0);
					for (Unit buildings : productionBuildings) {
						if(game.canMake(type, buildings) == true){
							buildings.train(type);
							game.sendText("Training Priority Unit: " + type.toString());
							pUnits.remove(0);
						}
	
					}
				}

			}
			
			if(attacking == false && myUnits.isEmpty() == false && lureCheck == 0){
				lureCheck = 1;
					for(Unit unit : myUnits){
						if(unit.getType().isWorker() == false && unit.getOrder() == Order.AttackUnit || unit.getOrder() == Order.AttackMove || unit.isAttacking() == true){
							Unit bunker = GetNearestBunker(unit.getPosition());
							if(bunker != null){
								if(unit.getDistance(bunker.getPosition()) > 400 && myRegions.contains(unit.getRegion()) == true){
									Unit target = unit.getOrderTarget();
									if(target == null){
										for(Unit unit1 : game.getUnitsInRadius(unit.getOrderTargetPosition(), 70)){
											if(unit1.getPlayer().isEnemy(self) == true){
												target = unit1;
												break;
											}
										}
									}
										if(target != null){
											int bonus = 0;
											if(self.getUpgradeLevel(UpgradeType.U_238_Shells) > 0){
												bonus = 24;
											}
										if(target.getType().groundWeapon().maxRange() <= UnitType.Terran_Marine.groundWeapon().maxRange() + bonus) {
												if(BunkerCanAttack(bunker, target) == false){
													Position runTo = GetRegionBehindBunker(bunker, target).getCenter();
													if(runTo != null){
														unit.move(runTo);
														game.drawCircleMap(runTo, 30, bwapi.Color.Red);
													}
												}
											}
											break;
										}
										break;
									}
							}
						}
					}
				}
			
		
			for(BaseLocation bases : BWTA.getBaseLocations()){
				
				if(game.isVisible(bases.getTilePosition()) == true 
				&& game.canBuildHere(bases.getTilePosition(), UnitType.Terran_Command_Center) == true
				&& claimedBaseLocations.contains(bases) == true && bases.getTilePosition() != self.getStartLocation() && expanding == false){
					claimedBaseLocations.remove(bases);
					game.sendText("OIL DETECTED AT " + bases.getTilePosition() + " Deploying US forces");
		
				}
				
//				int dist = (int) BWTA.getGroundDistance(self.getStartLocation(), bases.getTilePosition());
//				game.drawTextMap(bases.getPoint(), "Distance to base: " + dist);
//				

			}
			
			if(enemyChokes.isEmpty() == false){
				for(Region region : enemyChokes){
					game.drawCircleMap(region.getPoint(), 20, bwapi.Color.White);
				}
			}

			if (Mines > 300) {
				Mines = 0;
			}

			if (DifBuild > DifBuildMax) {
				DifBuild = 1;
			}
			

			if (isExpanding == true) {
				game.drawCircleMap(ExpandPos.toPosition(), 25, bwapi.Color.Cyan, false);
			}

			if (AcademyBuilt == false) {
				DifBuild = 1;
			}

			if (buildwait == true && bwub < 1) {
				bwub = Tick + 90;

			}

			if (Tick > bwub) {
				bwub = 0;
			}
			
			SupplyDepotsMax = Bases * 2;
				
			if(saving == true && expanding == false && constructingWorkers.isEmpty() == true){
				saving = false;
				game.sendText("Workers union demands pay increase or they will strike");
			}

			if (totalFrames > LastBuildTick && saving == true && LastBuildTick != 0) {
				saving = false;
				LastBuildTick = 0;

			}
			
			if(buildingMacroBuilding == true)
				if(macrobuilder.isConstructing() == false){
				saving = false;
				macrobuilder = null;
				buildingMacroBuilding = false;
			}
			
			if(buildingMacroBuilding == true){
				if(macrobuilder != null){
					game.drawCircleMap(macrobuilder.getPosition(), 10, bwapi.Color.Yellow);
					game.drawTextMap(macrobuilder.getPosition(), "Communist Sympathiser");
					
				}
			}
			
			
			if(HowManyOrderedToBuild(UnitType.Terran_Supply_Depot) == 0 && supplyBuilding > 0){
				supplyBuilding = 0;
			}
			
			if (self.minerals() >= 400 && ExpandEnabled == true && needsToExpand == true && expanding == false && Bases <= MaxBases && totalFrames > LastExpandFrame ) {
				game.sendText("Expanding");
				ExpandingBonus = 400;
				expanding = true;
				saving = true;
				Unit myUnit = GetWorker();
				CCBuilder = myUnit;
				TilePosition buildTile = NextExpand(CCBuilder);
				if (buildTile != null && myUnit != null) {
					CCBuilder.move(buildTile.toPosition(), false);

				}
				
				if(buildTile == null){
					expanding = false;
				}
			
		}
			if (expanding == true && ExpandPos.isValid() == true
					&& game.canBuildHere(ExpandPos, UnitType.Terran_Command_Center)) {
				if (game.isVisible(ExpandPos) == true && CCBuilder.isConstructing() == false) {
					CCBuilder.build(UnitType.Terran_Command_Center, ExpandPos);
				} else if (CCBuilder.isMoving() == false || CCBuilder.isGatheringMinerals() == true) {
					CCBuilder.move(ExpandPos.toPosition());
				}

			}

			if (expanding == true && game.isVisible(ExpandPos) == true && self.minerals() > 400) {
				if (game.canBuildHere(ExpandPos, UnitType.Terran_Command_Center) == false
					&& CCBuilder.isConstructing() == false){
					expanding = false;
					ExpandPlacing = false;
					saving = false;
					buildwait = false;
					//game.printf("Can't place expand at " + ExpandPos + " Making sure we dont try that ever again.");
				}
			}

			if (expanding == true && CCBuilder.exists() == true
					&& CCBuilder.hasPath(ExpandPos.toPosition()) == false) {
				game.sendText("Unable to path to expand location");
				expanding = false;
				ExpandPlacing = false;
				saving = false;
				buildwait = false;
			}
			// new code
			// building
		if(pBuildings.isEmpty() == true){
			if (saving == false && expanding == false && buildingTick == 20) {
				buildingTick = 0;

				if (game.canMake(UnitType.Terran_Bunker) == true && (Bunks + bunkersBuilding) <=  MaxBunks - 1 && saving == false  && bunkersBuilding < MaxBunks) {
					Region chokeRegion = game.getRegionAt(BWTA.getNearestChokepoint(lastExpandPos).getCenter());
					TilePosition bunkertile = null;
					Unit myUnit = GetWorker();	
					placementIncrease = 10;
					if(Bunks == 0 || bunkersBuilding == 0){
						bunkertile = BWTA.getNearestChokepoint(lastExpandPos).getCenter().toTilePosition();
					}
					else{
						bunkertile = LastBunkerPos;
					}
					if(myUnit != null){
//					TilePosition DefenderableTile = getDefendableTile(myUnit, UnitType.Terran_Bunker, bunkertile);
					TilePosition DefenderableTile = game.getBuildLocation(UnitType.Terran_Bunker, bunkertile);
					Region buildRegion = game.getRegionAt(DefenderableTile.toPosition());
					if (DefenderableTile != null && myUnit != null) {
						saving = true;
						myUnit.build(UnitType.Terran_Bunker, DefenderableTile);
						buildTypes.add(UnitType.Terran_Bunker);
						tempBunks++;
						if(Bunks > 1){
							Conscript();
						}
						if(constructingWorkers.contains(myUnit) == false){
						constructingWorkers.add(myUnit);
						}

						if(LastBuildTick == 0){
						LastBuildTick = totalFrames + 100;
						}
					}
					else {
						saving = false;
						placementIncrease = placementIncrease + 2;
					}

				}
			}

				if (self.minerals() >= 100 && Gases < MaxGases && isExpanding == false && buildwait == false
						&& saving == false && Racks > 2) {
					Unit myUnit = GetWorker();
					TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Refinery, self.getStartLocation());
					if (buildTile != null) {
						saving = true;
						if(constructingWorkers.contains(myUnit) == false){
						constructingWorkers.add(myUnit);
						}
						myUnit.build(UnitType.Terran_Refinery, buildTile);
						buildTypes.add(UnitType.Terran_Refinery);
						if(LastBuildTick == 0){
							LastBuildTick = totalFrames + 100;
						}
					}
				}
				
				if (self.minerals() >= 100 && supplyBuilding <= SupplyDepotsMax && saving == false && self.supplyUsed() != 200 && (self.supplyTotal() - self.supplyUsed()) < 3
						|| self.supplyUsed() > self.supplyTotal()) {

					boolean killing = false;
					 SavingAntiFuck = Tick + 200;
					 buildWaitFix = buildWaitFix + 200;
					Unit myUnit = GetWorker();
					if(myUnit == null){
						saving = false;
						//game.sendText("FBI tracer detected, deleteing webcam drivers and running incognito mode");
						killing = true;
						
					}
					if(killing == false){
					TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Supply_Depot, myUnit.getTilePosition());
					if (buildTile != null && buildTile != null && myUnit.exists() == true) {
						saving = true;
						if(game.canBuildHere(buildTile, UnitType.Terran_Supply_Depot) == false){
							game.sendText("Oh hey now your a null star, get the fuck out. Don't crash meee");
						}
						else if(buildTile != null){
						myUnit.build(UnitType.Terran_Supply_Depot, buildTile);
						buildTypes.add(UnitType.Terran_Supply_Depot);
						if(constructingWorkers.contains(myUnit) == false){
						constructingWorkers.add(myUnit);
						}
						game.drawCircleMap(buildTile.toPosition(), 10, bwapi.Color.Yellow, false);
						if(LastBuildTick == 0){
						LastBuildTick = totalFrames + 100;
						}
						}
						
					}
					else {
						saving = false;
					}
				}
			}
				if (Racks + RacksBuilding <= MaxRacks - 1 && self.minerals() >= (150 + ExpandingBonus) && saving == false) {
					// SavingAntiFuck = Tick + 200;
					// buildWaitFix = buildWaitFix + 200;
					Unit myUnit = GetWorker();
					if(myUnit != null){
					TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Barracks, myUnit.getTilePosition());
					if (buildTile != null && myUnit != null) {
						saving = true;
						myUnit.build(UnitType.Terran_Barracks, buildTile);
						buildTypes.add(UnitType.Terran_Barracks);
						if(constructingWorkers.contains(myUnit) == false){
						constructingWorkers.add(myUnit);
						}
						if(LastBuildTick == 0){
						LastBuildTick = totalFrames + 100;
						}
					
					}
					else {
						saving = false;
					}

					}
				}
				
//				if (self.minerals() >= 700 && expanding == false) {
//					// SavingAntiFuck = Tick + 200;
//					// buildWaitFix = buildWaitFix + 200;
//					Unit myUnit = GetWorker();
//					if(myUnit != null){
//					TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Barracks, myUnit.getTilePosition());
//					if (buildTile != null && myUnit != null) {
//						saving = true;
//						myUnit.build(UnitType.Terran_Barracks, buildTile);
//						if(constructingWorkers.contains(myUnit) == false){
//						constructingWorkers.add(myUnit);
//						}
//						if(LastBuildTick == 0){
//						LastBuildTick = totalFrames + 100;
//						}
//					
//					}
//					else {
//						saving = false;
//					}
//
//					}
//				}
				

				if ((Factories + FactoriesBuilding) < MaxFactories && self.minerals() >= (200 + ExpandingBonus) && self.gas() >= 150 && Bunks > 0 && saving == false && Bays > 0) {
					SavingAntiFuck = Tick + 200;
					buildWaitFix = buildWaitFix + 200;
					Unit myUnit = GetWorker();
					if(myUnit != null){
					TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Factory, myUnit.getTilePosition());
					if (buildTile != null && myUnit != null) {
						saving = true;
						myUnit.build(UnitType.Terran_Factory, buildTile);
						buildTypes.add(UnitType.Terran_Factory);
						if(constructingWorkers.contains(myUnit) == false){
						constructingWorkers.add(myUnit);
						}
						if(LastBuildTick == 0){
						LastBuildTick = totalFrames + 100;
						}
						

					}
					else {
						saving = false;
					}

				}
			}
				if (game.canMake(UnitType.Terran_Armory) && Armor == 0 && saving == false) {
					boolean sdfg = BuildingAlreadyBeingOrdered(UnitType.Terran_Armory, 1);
					if(sdfg == false){
						Unit myUnit = GetWorker();
						if(myUnit != null){
						TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Armory, myUnit.getTilePosition());
						if (buildTile != null && myUnit != null) {
							saving = true;
							myUnit.build(UnitType.Terran_Armory, buildTile);
							buildTypes.add(UnitType.Terran_Armory);
							if(constructingWorkers.contains(myUnit) == false){
							constructingWorkers.add(myUnit);
							}
							if(LastBuildTick == 0){
								LastBuildTick = totalFrames + 100;
							}
							
	
						}
						else {
							saving = false;
						}
	
					}
				}
			}

				if (self.minerals() >= (150 + ExpandingBonus) && isExpanding == false && AcademyBuilt == false && saving == false && Racks > 0 && Bunks > 0) {
					// SavingAntiFuck = Tick + 200;
					// buildWaitFix = buildWaitFix + 200;
					Unit myUnit = GetWorker();
					if(myUnit != null){
					TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Academy, self.getStartLocation());
					if (buildTile != null && myUnit != null) {
						saving = true;
						myUnit.build(UnitType.Terran_Academy, buildTile);
						buildTypes.add(UnitType.Terran_Academy);
						if(constructingWorkers.contains(myUnit) == false){
						constructingWorkers.add(myUnit);
						}
						if(LastBuildTick == 0){
						LastBuildTick = totalFrames + 100;
						}
						
					}
					else {
						saving = false;
					}

				}
			}
				if (BayCompleted == false && self.minerals() > (125 + ExpandingBonus) && saving == false && AcademyBuilt == true) {
					 SavingAntiFuck = Tick + 200;
					 buildWaitFix = buildWaitFix + 200;
					Unit myUnit = GetWorker();
					if(myUnit != null){
					TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Engineering_Bay, self.getStartLocation());
					if (buildTile != null && myUnit != null) {
						saving = true;
						myUnit.build(UnitType.Terran_Engineering_Bay, buildTile);
						buildTypes.add(UnitType.Terran_Engineering_Bay);
						if(constructingWorkers.contains(myUnit) == false){
						constructingWorkers.add(myUnit);
						}
						if(LastBuildTick == 0){
						LastBuildTick = totalFrames + 100;
						}
						
					}
					else {
						saving = false;
					}

				}
			}
			if (game.canMake(UnitType.Terran_Missile_Turret) && Turrets <= (enemyFlyers.size() * 4) + 1 && saving == false && enemyFlyers.isEmpty() == false) {
					SavingAntiFuck = Tick + 200;
					Unit myUnit = GetWorker();
					if(myUnit != null){
					TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Missile_Turret, myUnit.getTilePosition());
					if (buildTile != null && myUnit != null) {
					saving = true;
					myUnit.build(UnitType.Terran_Missile_Turret, buildTile);
					buildTypes.add(UnitType.Terran_Missile_Turret);
					if(constructingWorkers.contains(myUnit) == false){
					constructingWorkers.add(myUnit);
					}
						if(LastBuildTick == 0){
						LastBuildTick = totalFrames + 100;
						}
						
					}
					else {
						saving = false;
					}
				}
			}
			
			if (game.canMake(UnitType.Terran_Missile_Turret) == true && BayCompleted == true && startedDet == false && Bunks > 0) {
				Unit myUnit = GetWorker();
				placementIncrease = 5;
				TilePosition loc = null;
				if(myUnit != null){
				if(Bunks == 0 || bunkersBuilding == 0){
					loc = LastBunkerPos;
				}
				else {
					loc = ralleyPoint.toTilePosition();
				}
				//TilePosition DefenderableTile = getBuildTile(myUnit, UnitType.Terran_Missile_Turret, loc);
				TilePosition DefenderableTile = game.getBuildLocation(UnitType.Terran_Missile_Turret, loc, placementIncrease);
				if (DefenderableTile != null && myUnit != null) {
				game.sendText("Started detection near ramp");
				saving = true;
				myUnit.build(UnitType.Terran_Missile_Turret, DefenderableTile);
				buildTypes.add(UnitType.Terran_Missile_Turret);
				if(constructingWorkers.contains(myUnit) == false){
				constructingWorkers.add(myUnit);
				}
					if(LastBuildTick == 0){
					LastBuildTick = totalFrames + 100;
					}
					
				}
				else {
					placementIncrease = placementIncrease + 2;
					saving = false;
				}
			}
		}
			


				
			
			//This supply script is for building system lock up. 

			if ((PortsBuilding + StarPorts) == 0 && self.minerals() > (150 + ExpandingBonus) && self.gas() > 100 && buildwait == false && saving == false && Factories > 0) {
	
				 SavingAntiFuck = Tick + 200;
				 buildWaitFix = buildWaitFix + 200;
				Unit myUnit = GetWorker();
				if(myUnit != null){
				TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Starport, self.getStartLocation());
				if (buildTile != null && myUnit != null) {
					saving = true;
					myUnit.build(UnitType.Terran_Starport, buildTile);
					buildTypes.add(UnitType.Terran_Starport);
					if(constructingWorkers.contains(myUnit) == false){
					constructingWorkers.add(myUnit);
					}
					if(LastBuildTick == 0){
					LastBuildTick = totalFrames + 100;
					}
					
				}
				else {
					saving = false;
				}

			}
		}
			
			if (game.canMake(UnitType.Terran_Science_Facility) == true && scienceStarted == false && self.minerals() > (100 + ExpandingBonus) && self.gas() > 200 && saving == false){
				Unit myUnit = GetWorker();
				if(myUnit != null){
				TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Science_Facility, myUnit.getTilePosition());
				if (buildTile != null && myUnit != null) {
					saving = true;
					myUnit.build(UnitType.Terran_Science_Facility, buildTile);
					buildTypes.add(UnitType.Terran_Science_Facility);
					if(constructingWorkers.contains(myUnit) == false){
					constructingWorkers.add(myUnit);
					}
					if(LastBuildTick == 0){
					LastBuildTick = totalFrames + 100;
					}
					
				}
				else {
					saving = false;
				}

			}
		}
			



		}
	}
		// else if there is priority buildings that need to be built
		else {
			UnitType first = pBuildings.get(0);
				if(game.canMake(first) == false){
					saving = true;
					//System.out.println("Can't make " + first.toString());
					// save for the building
				}
				else {
					boolean bees94 = isOrderToBuildOrBetter(pBuildings.get(0));
						if(bees94 == false){
						// if not, build it\
						Unit myUnit = GetWorker();
						UnitType type = pBuildings.get(0);
						System.out.println(type.toString());
						TilePosition pos = pPosition.get(0);
						System.out.println("Pos: " + pos);
						if(myUnit != null){
							if(pos == null){
								pos = myUnit.getTilePosition();
								System.out.println("Pos not set, pos is now: " + pos);
							}
							TilePosition buildTile = getBuildTile(myUnit, type, pos);
							if (buildTile != null) {
								saving = true;
								myUnit.build(type, buildTile);
								buildTypes.add(type);
								if(constructingWorkers.contains(myUnit) == false){
								constructingWorkers.add(myUnit);
								}
								if(pWorkers.contains(myUnit) == false){
									Pair pair = new Pair<Unit, UnitType>(myUnit, type);
									pWorkers.add(pair);
									System.out.println("Adding to pWorkers");
								}
		
							}
					}
				}
			}
		}

		
			
			if(Bats >= BatsNeed && DifBuild == 4){	
				DifBuild++;
			}
			
			if(Medics >= MedicsNeed && DifBuild == 3){
				DifBuild++;
			}
			
			if(DifBuild > DifBuildMax){
				DifBuild = 1;
			}
			
			
			if(ralleyPoint != null){
				game.drawCircleMap(ralleyPoint, 100, bwapi.Color.Green);
			}
			

			for(Unit unit : enemyFlyers){
				if(unit.exists() == false){
					enemyFlyers.remove(unit);
				}
			}
			
		for (Unit myUnit : self.getUnits()) {
				
				if(myUnit.isSelected() == true && drawOrderLines == true){
				game.drawTextMap(myUnit.getPosition().getX(), myUnit.getPosition().getY(), myUnit.getOrder().toString());
				game.drawLineMap(myUnit.getPosition().getX(), myUnit.getPosition().getY(), myUnit.getOrderTargetPosition().getX(),
				myUnit.getOrderTargetPosition().getY(), bwapi.Color.Black);
				}
				
				if(myUnit.isStartingAttack() || myUnit.isAttacking() == true){
					ThinkUnit(myUnit);
				}
				
				if(pWorkers.isEmpty() == false){
					if(pWorkers.contains(myUnit) == true){
						game.drawCircleMap(myUnit.getPosition(), 20, bwapi.Color.Black);
					}
				}
				
				if(myUnit.isAttacking() == true && searchSiege == 0){
					for(Unit units : myUnit.getUnitsInRadius(120)){
						if(units.getType() == UnitType.Terran_Siege_Tank_Tank_Mode && units.isSieged() == false){
							units.siege();
						}
					}
				}
				
				if(myUnit.isUnderStorm()){
					Bullet bullets = GetNearestBullet(BulletType.Psionic_Storm, myUnit.getPosition());
					if(bullets != null){
						Position runto = RunFromPos(myUnit, bullets.getPosition());
						System.out.println(runto);
							if(runto != null){
								System.out.println("Dist to runTo: " + myUnit.getPosition().getApproxDistance(runto));
								if(runto.isValid() == true){
									myUnit.move(runto);
									System.out.println("Is Valid");
								}
								else {
									myUnit.move(ralleyPoint.getPoint());
								}
						}
					}
					else {
						System.out.println("Bullets are null");
					}
				}

				
				boolean isMil = IsMilitrayUnit(myUnit);
				
				if(constructingWorkers.contains(myUnit) == true && myUnit.isConstructing() == false){
				int index = constructingWorkers.indexOf(myUnit);
				constructingWorkers.remove(index);
				saving = false;
				buildwait = false;
				}
				
				if(constructingWorkers.contains(myUnit) == true && myUnit.isConstructing() == false && myUnit.hasPath(myUnit.getOrderTargetPosition()) == false){
				int index = constructingWorkers.indexOf(myUnit);
				constructingWorkers.remove(index);
				saving = false;
				buildwait = false;
				game.sendText("SCV can't path to construction area");
				}
				
				
				if(myUnit.getType() == UnitType.Terran_Physics_Lab && BCTech == false){
					BCTech = true;
					game.sendText("wget www.ifBot.weebly.com/src/ShitBot/Lab.docx -OutFile D:/danface.txt");
				}
				
				
				if(myUnit.isUnderAttack() == true && defenderCall == true){
					DefenceCall(myUnit);
				}
					
				
//			
//				if(myUnit.isAttacking() || myUnit.isMoving() && myUnit.isGatheringMinerals() == false && myUnit.isGatheringGas() == false){
//					Position fuckthisshit = new Position(0,0);
//					game.drawTextMap(myUnit.getPosition().getX(), myUnit.getPosition().getY(), myUnit.getOrder().toString());
//					if(myUnit.getOrderTargetPosition() != fuckthisshit){
//						game.drawLineMap(myUnit.getPosition().getX(), myUnit.getPosition().getY(), myUnit.getOrderTargetPosition().getX(),
//								myUnit.getOrderTargetPosition().getY(), bwapi.Color.Orange);
//					}
//
//				}
				

				if (saving == false) {
						if(pUnits.isEmpty() == true){
							if(CanMakeWorkers() == true){
								if (myUnit.getType() == UnitType.Terran_Command_Center && self.minerals() >= 50
										&& Workers < MaxWorkers && myUnit.isIdle() == true) {
									myUnit.train(UnitType.Terran_SCV);
								}
							}
		
							if (myUnit.getType() == UnitType.Terran_Barracks && self.minerals() >= 50 && myUnit.isIdle() == true
									&& Marines < MarinesNeed && DifBuild == 1) {
								myUnit.train(UnitType.Terran_Marine);
								DifBuild = DifBuild + 1;
							}
		
							if (myUnit.getType() == UnitType.Terran_Barracks && self.minerals() >= 50 && myUnit.isIdle() == true
									&& Marines < MarinesNeed && DifBuild == 2 && AcademyBuilt == true) {
								myUnit.train(UnitType.Terran_Marine);
								DifBuild = DifBuild + 1;
							}
		
							if (myUnit.getType() == UnitType.Terran_Barracks && self.minerals() >= 50 && self.gas() >= 25
									&& myUnit.isIdle() == true && Medics < MedicsNeed && AcademyBuilt == true
									&& DifBuild == 3) {
								myUnit.train(UnitType.Terran_Medic);
								DifBuild = DifBuild + 1;
							}
		
							if (myUnit.getType() == UnitType.Terran_Barracks && self.minerals() >= 100 && self.gas() >= 25
									&& myUnit.isIdle() == true && Bats < BatsNeed && AcademyBuilt == true && DifBuild == 4) {
								myUnit.train(UnitType.Terran_Firebat);
								DifBuild = DifBuild + 1;
							}

								if (myUnit.getType() == UnitType.Terran_Factory && self.minerals() >= 150 && self.gas() >= 100
										&& myUnit.isIdle() == true && DifBuild == 5) {
									myUnit.train(UnitType.Terran_Siege_Tank_Tank_Mode);
									DifBuild = DifBuild + 1;
								}
							

								if (myUnit.getType() == UnitType.Terran_Factory && self.minerals() >= 150 && self.gas() >= 100
										&& myUnit.isIdle() == true) {
									myUnit.train(UnitType.Terran_Siege_Tank_Tank_Mode);
								}
		
							if (myUnit.getType() == UnitType.Terran_Factory && self.minerals() >= 100 && self.gas() >= 50
									&& Gol <= enemyFlyers.size() + 2 && myUnit.isIdle() == true && Armor > 0 && Tanks > 3) {
								myUnit.train(UnitType.Terran_Goliath);
								Gol = Gol + 1;
		
							}
							
							if (myUnit.getType() == UnitType.Terran_Starport && scienceFinished == true && self.minerals() >= 100 && self.gas() > 225 && TSF <= detectionNeeded
									&& myUnit.isIdle() == true) {
									myUnit.train(UnitType.Terran_Science_Vessel);
							}
							
							if (myUnit.getType() == UnitType.Terran_Starport && game.canMake(UnitType.Terran_Battlecruiser) == true && myUnit.isIdle() == true) {
									myUnit.train(UnitType.Terran_Battlecruiser);
							}
					
					}
					else{
						boolean hgi = HasTechFor(pUnits.get(0));
						if(hgi == true){
							UnitType type = pUnits.get(0);
							for (Unit buildings : productionBuildings) {
								if(game.canMake(type, buildings) == true){
									buildings.train(type);
									game.sendText("Training Priority Unit: " + type.toString());
									pUnits.remove(0);
								}
			
							}
						}
						else {
							UnitType type = pUnits.get(0);
							game.sendText("No requirements for: " + type.toString() + " Blaming Someone on discord for it");
							pUnits.remove(0);
							
						}
					}



					if (myUnit.getType() == UnitType.Terran_Machine_Shop && self.minerals() >= 200 && self.gas() >= 200
							&& myUnit.isIdle() == true && myUnit.canResearch(TechType.Tank_Siege_Mode, true) && Tanks > 1) {
						myUnit.research(TechType.Tank_Siege_Mode);
						siegeResearched = true;

					}
					
					
					if(pBuildings.isEmpty() == false && pWorkers.isEmpty() == false){
						for(Pair<Unit, UnitType> pear : pWorkers){
							Unit worker = pear.first;
							if(worker != null){
								if(worker.isConstructing() == false){
									String type = pBuildings.get(0).toString();
									game.sendText("HEY, YOU GET TO EAT ONCE YOU FINSIH BUILDING " + type);
									pWorkers.remove(0);
									break;
								}
							}
							
						}
					}
					
//					if (myUnit.getType() == UnitType.Terran_Factory && self.minerals() >= 80 && Vultures < VulturesMax
//							&& myUnit.isIdle() == true) {
//							myUnit.train(UnitType.Terran_Vulture);
//					}
					


					if (myUnit.getType() == UnitType.Terran_Machine_Shop && self.minerals() >= 200 && self.gas() >= 100
							&& myUnit.isIdle() == true && myUnit.canResearch(TechType.Spider_Mines, true) && Vultures > 0) {
						myUnit.research(TechType.Spider_Mines);
					}
					
					if (myUnit.getType() == UnitType.Terran_Machine_Shop & myUnit.isIdle() == true && myUnit.canUpgrade(UpgradeType.Charon_Boosters) == true && Gol > 4) {
						myUnit.upgrade(UpgradeType.Charon_Boosters);
					}
					
					if (myUnit.getType() == UnitType.Terran_Armory && myUnit.isIdle() == true && myUnit.canUpgrade(UpgradeType.Terran_Vehicle_Weapons) == true){
						myUnit.upgrade(UpgradeType.Terran_Vehicle_Weapons);
					}
					
					if (myUnit.getType() == UnitType.Terran_Armory && myUnit.isIdle() == true && myUnit.canUpgrade(UpgradeType.Terran_Vehicle_Plating) == true){
						myUnit.upgrade(UpgradeType.Terran_Vehicle_Plating);
					}
					
					
					if (myUnit.getType() == UnitType.Terran_Academy && myUnit.isIdle() == true && saving == false && Racks > 1 && myUnit.canResearch(TechType.Stim_Packs) == true){
						myUnit.research(TechType.Stim_Packs);
						
					}
					
					if (myUnit.getType() == UnitType.Terran_Academy && myUnit.isIdle() == true && saving == false && Factories > 0 && myUnit.canUpgrade(UpgradeType.U_238_Shells) == true){
						myUnit.upgrade(UpgradeType.U_238_Shells);
					}
					
					if (myUnit.getType() == UnitType.Terran_Engineering_Bay && myUnit.isIdle() == true && saving == false && Factories > 0 && myUnit.canUpgrade(UpgradeType.Terran_Infantry_Weapons)){
						myUnit.upgrade(UpgradeType.Terran_Infantry_Weapons);
						
						
					}
					
					if (myUnit.getType() == UnitType.Terran_Engineering_Bay && myUnit.isIdle() == true && saving == false && Factories > 0 && myUnit.canUpgrade(UpgradeType.Terran_Infantry_Armor)){
						myUnit.upgrade(UpgradeType.Terran_Infantry_Armor);
						
						
					}
					


				}
				
				if(ExpandPlacing == true) {
					
					
					if (myUnit.getType() == UnitType.Terran_Factory && self.minerals() >= 600 && self.gas() >= 100
							&& myUnit.isIdle() == true) {
						myUnit.train(UnitType.Terran_Siege_Tank_Tank_Mode);
					}
					
					
					if (myUnit.getType() == UnitType.Terran_Barracks && self.minerals() >= 600 && myUnit.isIdle() == true) {
						myUnit.train(UnitType.Terran_Marine);
					}
					
					
//					if (myUnit.getType() == UnitType.Terran_Factory && self.minerals() >= 600 && myUnit.isIdle() == true) {
//						myUnit.train(UnitType.Terran_Vulture);
//					}
					
					
					if (myUnit.getType() == UnitType.Terran_Starport && self.minerals() > 900 && self.gas() > 400 && game.canMake(UnitType.Terran_Battlecruiser) && myUnit.isIdle() == true) {
						myUnit.train(UnitType.Terran_Battlecruiser);
					}
					
					
								
					
				}
				
		
				if (myUnit.getType() == UnitType.Terran_Bunker && myUnit.isBeingConstructed() == false && myUnit.getLoadedUnits().size() != 4) {
					int myID = myUnit.getID();
					if(bunkersSize.get(myID) != null){
						int amount = bunkersSize.get(myID);
						if(amount != 4){
							for(Unit units : myUnits){
								if(units.isCompleted() == true && units.isIdle() == true || units.isMoving() == true){
									units.rightClick(myUnit);
									int neww = amount + 1;
									bunkersSize.put(myID, neww);
									myUnits.remove(units);
									break;
									
								}
							}
						}
						
					}
					else {
						game.sendText("Can't find object in hashmap for item: " + myID + " Blaming someone on discord for it");
					}

				}
						
				if(myUnit.getType() == UnitType.Terran_Bunker && myUnit.getLoadedUnits().size() == 4 && bunkersFilled.contains(myUnit) == false){
					bunkersFilled.add(myUnit);
				}
				
				if(bunkersFilled.contains(myUnit) == true){
					game.drawCircleMap(myUnit.getPosition(), 100, bwapi.Color.Purple);
				}

				if (myUnit.getType() == UnitType.Terran_Siege_Tank_Siege_Mode && myUnit.isSieged() == true && myUnit.isIdle() == true) {
					boolean hostiles = false;
					for (Unit targets : myUnit.getUnitsInRadius(400)) {
						if (targets.getPlayer().isEnemy(self) && myUnit.canAttack(targets) == true) {
							hostiles = true;
							break;
						}
					}
					if(hostiles == false){
						myUnit.unsiege();
					}

				}

				// if (myUnit.getType() == UnitType.Terran_Vulture &&
				// myUnit.isAttacking() == true) {
				// System.out.println("Launch");
				// Unit unitt = myUnit;
				// System.out.println("Vulture");
				// Unit targett = myUnit.getTarget();
				// System.out.println("Target");
				// Position Move = GetKitePos2(unitt, targett);
				// System.out.println("Call");
				// if (Move.isValid() == true) {
				// System.out.println("Valid");
				// unitt.move(Move);
				// System.out.println("move");
				// game.drawCircleMap(Move, 5, Color.Orange, false);
				// }
				// System.out.println("Not valid");
				// }



				if (myUnit.isIdle() && attacking == true && myUnit.getType().isWorker() == false && myUnit.getType() != UnitType.Terran_Medic) {
					if (enemyBuildingMemory.isEmpty() == false) {
						// if we are not in a FFA
						if(TeamGameMode == false){
							myUnit.attack(enemyBuildingMemory.get(0), false);
						}
					} else {
						for (BaseLocation b : BWTA.getBaseLocations()) {
							if (game.isVisible(b.getTilePosition()) == false && b.isIsland() == false) {
								myUnit.attack(b.getPosition());
								break;
							}
						}
					}
					
					if(DoneCreatingList == true && playerBuildings.isEmpty() == false && TeamGameMode == true){
						//if we are in a FFA
						int target = GetPlayerTarget();
						if(target != 10){
							Position pos = playerBuildings.get(target).get(0);
							if(pos != null){
								myUnit.attack(pos, false);
							}
						}

						}
				}

				if (myUnit.isConstructing() == true) {
					Position pos = myUnit.getPosition();
					game.drawCircleMap(pos, 20, bwapi.Color.Brown);

				}
				
				//science vesseles
				
				
				if(myUnit.getType() == UnitType.Terran_Science_Vessel && myUnit.isIdle()){
					boolean a = false;
					for(Unit unit : myUnits){
						if(unit.isAttacking() == true || unit.isAttackFrame() == true){
							Position pos = unit.getPosition();
							if(pos != null){
								myUnit.move(pos);
								a = true;
								break;
							}
						}
					}
					if(a == false){
						for(Unit unit : myUnits){
							if(unit.isMoving() == true){
								Position pos = unit.getPosition();
									if(pos != null){
										myUnit.move(pos);
										a = true;
										break;
									}
							}
						}
					}
				}
				
				if(myUnit.getType() == UnitType.Terran_Medic && myUnit.isIdle()){
					boolean a = false;
					for(Unit unit : myUnits){
						if(unit.isAttacking() == true || unit.isAttackFrame() == true){
							Position pos = unit.getPosition();
							if(pos != null){
								myUnit.move(pos);
								a = true;
								break;
							}
						}
					}
					if(a == false){
						for(Unit unit : myUnits){
							if(unit.isMoving() == true){
								Position pos = unit.getPosition();
									if(pos != null){
										myUnit.move(pos);
										a = true;
										break;
									}
							}
						}
					}
				}

				if(myUnit.getType() == UnitType.Terran_Science_Vessel && myUnit.getEnergy() > 100 && SVCheck == 0){
					SVCheck = 1;
					for(Unit units : myUnit.getUnitsInRadius(300)){
						if(units.isUnderAttack() == true && units.getPlayer() == self && myUnit.canUseTech(TechType.Defensive_Matrix, units) == true && units.isDefenseMatrixed() == false){
							myUnit.useTech(TechType.Defensive_Matrix, units);
						}
					}
				}

				// combat sim
				
				

				if (myUnit.isStartingAttack() == true || myUnit.isAttackFrame() == true && myUnit.getType().isBuilding() == false && simCallFrames == 0 && myUnit.getType().isWorker() == false) {
					int bonus = 1;	
					simCallFrames = 1;
					Unit attacker = GetAttacker(myUnit, 300);
					boolean canRetreat = true;
//			
//					if(myUnit.getRegion().getDistance(BWTA.getNearestChokepoint(myUnit.getPosition()).getRegions().first) < 600 && Strats == "Full Attack" &&
//						myUnit.getDistance(self.getStartLocation().toPosition()) > 2000 &&
//						myUnit.getDistance(enemyBasePos.getPoint()) < 3000){
//						gaf = true;
//						bonus = myUnit.getRegion().getDefensePriority();
//					}
					
					if(enemyChokes.contains(myUnit.getRegion()) == true){
						//if our unit is in an enemy chokepoint
						bonus = 3;
					}
					
					if(myUnit.getDistance(self.getStartLocation().toPosition()) < 2000){
						canRetreat = false;
					}
					
					// We will make a new list of units nearby, sort them,  and then to give to the function.
					
					ArrayList<Unit> mine = new ArrayList<Unit>();
					ArrayList<Unit> hostile = new ArrayList<Unit>();
					
					for(Unit units : game.getUnitsInRadius(myUnit.getPosition(), 220)){
						boolean bool = IsMilitrayUnit(units);
						boolean bool1 = IsMilitrayBuilding(units);
						
						if(units.getPlayer() == self && bool == true && mine.contains(units) == false){
							mine.add(units);
						}
						
						if(units.getPlayer() == self && bool1 == true && mine.contains(units) == false){
							mine.add(units);
						}
					
						if(units.getPlayer().isEnemy(self) && bool == true && hostile.contains(units) == false){
							hostile.add(units);
						}
						
						if(units.getPlayer().isEnemy(self) && bool1 == true && hostile.contains(units) == false){
							hostile.add(units);
						}
						
						
					}
					
					boolean canWin = jFaplocal(mine, hostile, bonus);
					//System.out.println(canWin);
					//System.out.println(bonus);
				
					if(canWin == false && canRetreat == true){
						Position regroup = GetJukePos2(myUnit, attacker);
						if(regroup != null){
							if(regroup.isValid() == true){
								for(Unit unitss : mine){
									if(unitss != null){
										if(unitss.isMoving() == false){
											unitss.move(regroup);
										}
									}
								}
							}
							else {
								game.sendText("Regroup is not valid");
							}
						}
					}

			}
				
				
				
			// end of combat sim
					
				//for all units


//				if (myUnit.isAttacking() == true && myUnit.isAttackFrame() == false && myUnit.getType() == UnitType.Terran_Marine && myUnit.getType().isWorker() == false) {
//					Unit target = myUnit.getOrderTarget();
//					Unit unit = myUnit;
//					if (target.getType() == UnitType.Protoss_Zealot) {
//						Position JukePos = getJukePos(target, unit);
//						if (JukePos != null) {
//							myUnit.move(JukePos);
//							System.out.println("Juking at: " + JukePos);
//						}
//				}
//					if (target.getType() == UnitType.Zerg_Zergling) {
//						Position JukePos = getJukePos(target, unit);
//						if (JukePos.isValid() == true) {
//							myUnit.move(JukePos);
//							
//						}
//					}
//
//				}

				// repair script decided it wanted to break everything

				
				if (myUnit.getType().isBuilding() == true && myUnit.getHitPoints() < myUnit.getType().maxHitPoints()
						&& myUnit.isBeingHealed() == false && myUnit.isBeingConstructed() == false) {
					Unit unit = myUnit;
					int index = 0;
					Unit repairs = GetWorker();
					if (repairingBuildings.isEmpty() == true) {
						if (repairs.getType() == UnitType.Terran_SCV && repairs.getID() != scoutID
								&& repairs.isGatheringMinerals() == true) {
							Position oldOrder = repairs.getOrderTargetPosition();
							repairs.repair(unit);
							repairingBuildings.add(unit.getID());
						}
					}
					if (repairingBuildings.contains(myUnit.getID()) == false && repairs.getType() == UnitType.Terran_SCV
							&& repairs.getID() != scoutID && repairs.isGatheringMinerals() == true) {
						Position oldOrder = repairs.getOrderTargetPosition();
						repairs.repair(unit);
						repairingBuildings.add(unit.getID());
					}
			

				}
		
				

				if (myUnit.getType().isBuilding() == true && myUnit.getHitPoints() == myUnit.getType().maxHitPoints()
						&& repairingBuildings.contains(myUnit.getID()) == true) {
					int ID = myUnit.getID();
					if (repairingBuildings.contains(ID) == true) {
						int index = repairingBuildings.indexOf(ID);
						repairingBuildings.remove(index);
					}

				}


				if (myUnit.isLifted() == true && myUnit.isIdle() == true) {
					TilePosition LandLocation = getLandLocation(myUnit, myUnit.getTilePosition());
					if (LandLocation != null) {
						if(myUnit.canLand(LandLocation) == true){
							myUnit.land(LandLocation);
						}
						
					}

				}



				if (myUnit.isUnderAttack() == true && myUnit.getType() == UnitType.Terran_Marine
						|| myUnit.getType() == UnitType.Terran_Firebat || myUnit.getType() == UnitType.Terran_Medic ) {
					for (Unit medics : myMedics) {
						if (medics.getType() == UnitType.Terran_Medic && medics.getEnergy() > 5  && medics.isMoving() == true
								|| medics.isIdle() == true) {
							medics.useTech(TechType.Healing, myUnit);
						}

					}

				}
				
				if(myUnit.isUnderAttack() == true && myUnit.getType() == UnitType.Terran_Medic){
					Unit attacker = GetAttacker(myUnit, 200);
					if(attacker != null && myUnit.isMoving() == false){
						Position regroup = GetJukePos2(myUnit, attacker);
						if(regroup.isValid() == false){
							regroup.makeValid();
						}
						myUnit.move(regroup);
					}
					
				}


			if(myUnit.isAttacking() == true && customTargets == 0){
					customTargets = 1;
					for(Unit pooheads : myUnit.getUnitsInRadius(300)){
						ArrayList<Unit> meinUnits = new ArrayList<Unit>();
						ArrayList<Unit> meinNichtUnits = new ArrayList<Unit>();
						boolean dan = IsMilitrayUnit(pooheads);
						if(pooheads.getPlayer() == self && dan == true && pooheads.getType().isWorker() == false){
							meinUnits.add(pooheads);
						}
						if(pooheads.getPlayer().isEnemy(self) && dan == true){
							meinNichtUnits.add(pooheads);
						}
						
						if(pooheads.getType().isWorker() == true && pooheads.isRepairing() == true && pooheads.getPlayer().isEnemy(self)){
							meinNichtUnits.add(pooheads);
						}
						
						for(Unit weeheads : meinNichtUnits){
							if(weeheads.getType() == UnitType.Zerg_Lurker ||
								weeheads.getType() == UnitType.Terran_Medic || 
								weeheads.getType() == UnitType.Protoss_High_Templar || 
								weeheads.getType() == UnitType.Protoss_Carrier ||
								weeheads.getType() == UnitType.Zerg_Defiler ||
								weeheads.getType() == UnitType.Terran_SCV){
								for(Unit unit : meinUnits){
									if(weeheads != null){
										if(unit.canAttack(weeheads) == true && unit.getType().isWorker() == false){
											unit.attack(weeheads);
											game.drawCircleMap(weeheads.getPosition(), 15, bwapi.Color.Green);
										}
									}
								}
							}
						}
					}
				}
				
				//To stop the bot freezing
				//defence
				//defence
				//defenceFrames
				//defenceCallFrames
				//
				

				
				if (myUnit.getType() == UnitType.Terran_Factory
						&& myUnit.canBuild(UnitType.Terran_Machine_Shop, true) && myUnit.isCompleted() == true) {
					myUnit.buildAddon(UnitType.Terran_Machine_Shop);
				}
				
				if (myUnit.getType() == UnitType.Terran_Starport && myUnit.canBuild(UnitType.Terran_Control_Tower, true) && myUnit.isCompleted() == true) {
					myUnit.buildAddon(UnitType.Terran_Control_Tower);
				}
				
				if (myUnit.getType() == UnitType.Terran_Science_Facility
						&& myUnit.canBuild(UnitType.Terran_Physics_Lab, true) && myUnit.isCompleted() == true) {
					myUnit.buildAddon(UnitType.Terran_Physics_Lab);
					BCTech = true;
					
				}

				if (myUnit.getType() == UnitType.Terran_Command_Center
						&& myUnit.canBuild(UnitType.Terran_Comsat_Station, true) && myUnit.isCompleted() == true) {
					myUnit.buildAddon(UnitType.Terran_Comsat_Station);
				}
 
				if (myUnit.getType() == UnitType.Terran_Command_Center
						&& myUnit.canBuild(UnitType.Terran_Comsat_Station, false)) {
					Position Postion = myUnit.getPosition();
					for (Unit buildings : myUnit.getUnitsInRadius(30)) {
						if (buildings.canLift() == true && buildings.getType() != UnitType.Terran_Command_Center) {
							buildings.lift();
						}
						if (buildings.getType() == UnitType.Terran_Supply_Depot) {
							for (Unit helpers : myUnit.getUnitsInRadius(200)) {
								if (helpers.canAttack() == true && helpers.getType().isBuilding() == false
										&& helpers.getType().isWorker() == false && helpers.isIdle() == true
										&& buildings.exists() == true) {
									helpers.attack(buildings);

								}
							}

						}
					}
				}
		
				
				// TODO: FIX THIS SHIT CURRENTLY REPORTING 0 CURRENT HARVESTERS
//				if(myUnit.getType() == UnitType.Terran_Refinery && myUnit.isBeingGathered() == false && myUnit.isCompleted() == true && myUnit.getResources() != myUnit.getInitialResources()){
//					int amount = amountOfGasHarvesters(myUnit);
//					if(amount != 3 && myWorkers.size() > 13){
//						for (int i = 0; i!=3; i++){
//							Unit worker = GetWorker();
//							if(myUnit != null){
//								worker.gather(myUnit);
//								if(gasWorkers.contains(worker) == false){
//								gasWorkers.add(worker);
//								}
//							}
//						}
//					}
//				}
				
				if (myUnit.getType() == UnitType.Terran_Factory && myUnit.canBuild(UnitType.Terran_Machine_Shop, false) && myUnit.isLifted() == false && myUnit.isCompleted() == true) {
					myUnit.lift();
				}
				
				if (myUnit.getType() == UnitType.Terran_Starport && myUnit.canBuild(UnitType.Terran_Control_Tower, false) && myUnit.isLifted() == false && myUnit.isCompleted() == true) {
					myUnit.lift();

				}
				
				if (myUnit.getType() == UnitType.Terran_Science_Facility && myUnit.canBuild(UnitType.Terran_Physics_Lab, false) && myUnit.isLifted() == false && myUnit.isCompleted() == true) {
					myUnit.lift();

				}
				
				if (myUnit.getID() == scoutID && ScoutSent == false && myUnit.isIdle() == true && myMinerals.isEmpty() == false) {
					Unit closestMineral = null;
					for (Unit neutralUnit : game.neutral().getUnits()) {
						if (neutralUnit.getType().isMineralField() && neutralUnit.isBeingGathered() == false) {
							if (closestMineral == null
									|| myUnit.getDistance(neutralUnit) < myUnit.getDistance(closestMineral)) {
								closestMineral = neutralUnit;
							}
						}
					}

					if (closestMineral != null) {
						myUnit.gather(closestMineral, false);
					}
				}

				// if it's a worker and it's idle, send it to the closest
				// mineral
				// patch

				if (myUnit.getType().isWorker() && myUnit.isIdle() == true && myUnit.isGatheringGas() == false
						&& myUnit.getID() != scoutID && gasWorkers.contains(myUnit) == false) {
					Unit closestMineral = null;
					for (Unit neutralUnit : myMinerals) {
						if (closestMineral == null
								|| myUnit.getDistance(neutralUnit) < myUnit.getDistance(closestMineral)) {
							closestMineral = neutralUnit;
							if (closestMineral != null) {
								myUnit.gather(closestMineral, false);
							}
						}
					}
				}
				
				if(myUnit.isIdle() == true && gasWorkers.contains(myUnit) == true){
					int index = 0;
					int max = self.getUnits().size();
					for(Unit unit : self.getUnits()){
						if(index >= max && gasWorkers.contains(myUnit) == true){
							int indexx = gasWorkers.indexOf(myUnit);
							gasWorkers.remove(indexx);
							game.sendText("No sign of free oil, sending it back to the t-34 factories");
						}
						if(unit.getType() == UnitType.Terran_Refinery == true && unit.isBeingGathered() == false){
							myUnit.gather(unit);
						}
					}
					
					
				}
				
				if(scouter != null){
					if(scouter.exists() && scouter.isCompleted() == true && scouter.isMoving() == true){
						for(Unit units : myUnit.getUnitsInRadius(scouter.getType().sightRange())){
							if(units.getPlayer().isEnemy(self) && units.getOrder() == Order.AttackUnit && units.getOrderTarget() == scouter){							
								game.drawCircleMap(units.getPosition(), 30, bwapi.Color.Yellow);
								Position flee = GetKitePos2(scouter, units);
								if(flee != null){
									if(flee.isValid() == true){
									myUnit.move(flee);
									}
								}
								break;						
							}
							
						}
					}
			}
				

				
				// end of myUnits loop

			}
			
			if(TeamGameMode == false){

				for (Unit EnemyUnits1 : game.enemy().getUnits()) {
					
					boolean isMil = IsMilitrayUnit(EnemyUnits1);
					if(EnemyUnits1.isCloaked() || EnemyUnits1.isBurrowed()){
						if (EnemyUnits1.isDetected() == false && EnemyUnits1.isAttacking() == true
							&& isMil == true && HasUnitsNearbyToCombat(EnemyUnits1) == true ) {
							for (Unit detectors : myComSats) {
								if (detectors.getType() == UnitType.Terran_Comsat_Station && detectors.getEnergy() >= 50) {
									detectors.useTech(TechType.Scanner_Sweep, EnemyUnits1.getPosition());
									break;
								}
							}
						}
					}
					
					if (EnemyUnits1.getType().isBuilding() && EnemyUnits1.isLifted() == false) {
						if (!enemyBuildingMemory.contains(EnemyUnits1.getPosition())) {
							enemyBuildingMemory.add(EnemyUnits1.getPosition());
						}
					}
					
				
					if(EnemyUnits1.isFlying() && isMil == true && enemyFlyers.contains(EnemyUnits1) == false){
						enemyFlyers.add(EnemyUnits1);
						int score = getScoreOf(EnemyUnits1);
						if(Armor == 0 && Factories > 0 && pBuildings.contains(UnitType.Terran_Armory) == false){
							pBuildings.add(UnitType.Terran_Armory);
							pPosition.add(null);
						}
						if(Armor > 0 && EnemyUnits1.getType().groundWeapon().damageAmount() > 0){
						UnitType auxType = UnitType.Terran_Goliath;
						int amount = ((auxType.destroyScore() * auxType.maxHitPoints()) / (auxType.maxHitPoints() * 2) / score) + 1;
						//game.sendText("AIR UNITS DETECTED, ADDING " + amount + " Of Golaiths to counter: " + EnemyUnits1.getType().toString());
						int i;
						for (i = 0; i < amount; i++) { 
							pUnits.add(UnitType.Terran_Goliath);
						}
						
						}
					}		
						
					if(EnemyUnits1.isVisible() == true){
						String name = GetCustomName(EnemyUnits1.getType());
						game.drawTextMap(EnemyUnits1.getPosition(), name);
					}
					
	
				}
			}
			else {
			if(DoneCreatingList == true && playerBuildings.isEmpty() == false){
					for (Player P : game.enemies()) {
						for (Unit EnemyUnits1 : P.getUnits()) {
							if (EnemyUnits1.getType().isBuilding() && EnemyUnits1.isLifted() == false) {
									int index = EnemyUnits1.getPlayer().getID();
									//System.out.println("Index is: " + index);
									ArrayList<Position> list = playerBuildings.get(index);
									if(list != null){
										if(list.contains(EnemyUnits1.getPosition()) == false){
											list.add(EnemyUnits1.getPosition());
											playerBuildings.put(index, list);
										}
									}
									else {
										System.out.println("List for player: " + EnemyUnits1.getPlayer().getName() + " is null");
									}
								
								if (!enemyBuildingMemory.contains(EnemyUnits1.getPosition())) {
									enemyBuildingMemory.add(EnemyUnits1.getPosition());
								}
							}
							
							boolean isMil = IsMilitrayUnit(EnemyUnits1);
							if(EnemyUnits1.isCloaked() || EnemyUnits1.isBurrowed()){
								if (EnemyUnits1.isDetected() == false && EnemyUnits1.isAttacking() == true
									&& isMil == true && HasUnitsNearbyToCombat(EnemyUnits1) == true ) {
									for (Unit detectors : myComSats) {
										if (detectors.getType() == UnitType.Terran_Comsat_Station && detectors.getEnergy() >= 50) {
											detectors.useTech(TechType.Scanner_Sweep, EnemyUnits1.getPosition());
											break;
										}
									}
								}
							}
						}
					}
				}
			}
			
			for(Region region : myRegions){
				game.drawCircleMap(region.getCenter(), 10, bwapi.Color.White);
			}


			if(TeamGameMode == true){
				if(DoneCreatingList == true && playerBuildings.isEmpty() == false){
					for(Player pp : game.enemies()){
						int index1 = pp.getID();
						ArrayList<Position> items = playerBuildings.get(index1);
						for (Position p : items) {
							// compute the TilePosition corresponding to our remembered
							// Position p
							TilePosition tileCorrespondingToP = new TilePosition(p.getX() / 32, p.getY() / 32);
			
							// if that tile is currently visible to us...
							if (game.isVisible(tileCorrespondingToP)) {
			
								// loop over all the visible enemy buildings and find out if
								// at least
								// one of them is still at that remembered position
								boolean buildingStillThere = false;
								for (Unit u : pp.getUnits()) {
									if ((u.getType().isBuilding()) && (u.getPosition().equals(p) )) {
										buildingStillThere = true;
										break;
									}
								}
			
								// if there is no more any building, remove that position
								// from our memory
								if (buildingStillThere == false) {
									int index = enemyBuildingMemory.indexOf(p);
									items.remove(index);
									game.sendText("Building not there for player: " + pp.getName() +  " removing: " + p.toString());
									break;
								}
							}
						}
						playerBuildings.put(index1, items);
					}
				}
			}
			else {
				for (Position p : enemyBuildingMemory) {
					// compute the TilePosition corresponding to our remembered
					// Position p
					TilePosition tileCorrespondingToP = new TilePosition(p.getX() / 32, p.getY() / 32);
	
					// if that tile is currently visible to us...
					if (game.isVisible(tileCorrespondingToP)) {
	
						// loop over all the visible enemy buildings and find out if
						// at least
						// one of them is still at that remembered position
					boolean buildingStillThere = false;
				for (Unit u : game.enemy().getUnits()) {
							if ((u.getType().isBuilding()) && (u.getPosition().equals(p))) {
								buildingStillThere = true;
								break;
						}
						}
	
						// if there is no more any building, remove that position
						// from our memory
						if (buildingStillThere == false) {
							int index = enemyBuildingMemory.indexOf(p);
						enemyBuildingMemory.remove(index);
							game.sendText("Building not there, removing: " + p.toString());
							break;
						}
					}
				}
			}
			
			// expanding script
			// expanding
			// income < needs

	if(TeamGameMode == false){
		if (HasScoutUnit == true && ScoutSent == true && scouter.isMoving() == false || scouter.isIdle() == true) {
			if(enemyBuildingMemory.isEmpty() == true){
			scouter.move(self.getStartLocation().toPosition());
			for (BaseLocation b : BWTA.getBaseLocations()) {
				if (b.isStartLocation() && game.isExplored(b.getTilePosition()) == false) {
					scouter.move(b.getPosition());

				}
		}
	}
	else{
		for(Position pos : enemyBuildingMemory){
			if(game.isVisible(pos.toTilePosition()) == false && pos.isValid() == true){
				scouter.move(pos);
			}
		}
	}
		
			
			
		}
	}
	// if we are in a FFA
	else {
		if (HasScoutUnit == true && ScoutSent == true && scouter.isMoving() == false || scouter.isIdle() == true) {
			boolean found = false;
			for (BaseLocation b : BWTA.getBaseLocations()) {
				if (b.isStartLocation() && game.isExplored(b.getTilePosition()) == false) {
					scouter.move(b.getPosition());
					found = true;
				}
		}
			if(found == false){
				for (BaseLocation b : BWTA.getBaseLocations()) {
					if (b.isStartLocation() && game.isExplored(b.getTilePosition()) == true) {
						scouter.move(b.getPosition());
						found = true;
					}
				}
			}
			
		}
	}
	
		if(ExpandPos != null){
			if (ExpandPos.isValid()) {
				game.drawCircleMap(ExpandPos.toPosition(), 25, bwapi.Color.Cyan, false);
			}
		}
		
		if(Commander != null){
			if (Commander.exists()) {
				game.drawCircleMap(Commander.getPosition(), 25, bwapi.Color.Orange, false);
			}
		}
		
		if(playerScores.isEmpty() == false|| playerBuildings.isEmpty() == false ){
		game.drawTextScreen(100, 90, sPlayerScores.toString());
		game.drawTextScreen(300, 90, sPlayerSize.toString());
		}
		
	}
//}
	
	
	
	

	// end of lat frames

	public static void main(String[] args) {
		new TestBot1().run();

	}

	// Returns a suitable TilePosition to build a given building type near
	// specified TilePosition aroundTile, or null if not found. (builder
	// parameter is our worker)
	public TilePosition getBuildTile(Unit builder, UnitType buildingType, TilePosition aroundTile) {
		TilePosition ret = null;
		int maxDist = 6;
		int stopDist = 150;
		// Refinery, Assimilator, Extractor
		if (buildingType.isRefinery()) {
			
			if(claimedGas.isEmpty() == false){
				for(Unit unit : claimedGas){
					if(unit.getType() == UnitType.Resource_Vespene_Geyser){
						return unit.getTilePosition();
					}
				}
			}
			else {
			for (Unit n : game.neutral().getUnits()) {
				if ((n.getType() == UnitType.Resource_Vespene_Geyser)
						&& (Math.abs(n.getTilePosition().getX() - aroundTile.getX()) < stopDist)
						&& (Math.abs(n.getTilePosition().getY() - aroundTile.getY()) < stopDist))
					return n.getTilePosition();
			}
		}
	}

		if (buildingType.isResourceDepot()) {
			maxDist = 1;
		}



		while ((maxDist < stopDist) && (ret == null)) {
			for (int x = aroundTile.getX() - maxDist; x <= aroundTile.getX() + maxDist; x++) {
				for (int y = aroundTile.getY() - maxDist; y <= aroundTile.getY() + maxDist; y++) {
					if (game.canBuildHere(new TilePosition(x, y), buildingType, builder, false)) {
						// units that are blocking the tile
						boolean unitsInWay = false;
						for (Unit u : game.getAllUnits()) {
							if (u.getID() == builder.getID())
								continue;
							if ((Math.abs(u.getTilePosition().getX() - x) < 4)
									&& (Math.abs(u.getTilePosition().getY() - y) < 4)) {
								unitsInWay = true;
								NewBuild = new TilePosition(x, y);
							}
						}
						if (!unitsInWay && NewBuild != LastBuild && game.isVisible(new TilePosition(x, y))) {
							LastBuild = new TilePosition(x, y);
							buildingName = buildingType;
							return new TilePosition(x, y);

						}
			
					}
				}
			}
			maxDist += 6;
		}
		game.sendText("Something went wrong, returning null for build");
		return null;

	}
	
	
	public TilePosition getDefendableTile(Unit builder, UnitType buildingType, TilePosition aroundTile) {
		TilePosition ret = null;
		int maxDist = 1;
		int stopDist = 10;
		// Refinery, Assimilator, Extractor
		if (buildingType.isRefinery()) {
			for (Unit n : game.neutral().getUnits()) {
				if ((n.getType() == UnitType.Resource_Vespene_Geyser)
						&& (Math.abs(n.getTilePosition().getX() - aroundTile.getX()) < stopDist)
						&& (Math.abs(n.getTilePosition().getY() - aroundTile.getY()) < stopDist))
					return n.getTilePosition();
			}
		}

		while ((maxDist < stopDist) && (ret == null)) {
			for (int x = aroundTile.getX() - maxDist; x <= aroundTile.getX() + maxDist; x++) {
				for (int y = aroundTile.getY() - maxDist; y <= aroundTile.getY() + maxDist; y++) {
					if (game.canBuildHere(new TilePosition(x, y), buildingType, builder, false)) {
						// units that are blocking the tile
						boolean unitsInWay = false;
						for (Unit u : game.getAllUnits()) {
							if (u.getID() == builder.getID())
								continue;
							if ((Math.abs(u.getTilePosition().getX() - x) < 4)
									&& (Math.abs(u.getTilePosition().getY() - y) < 4)) {
								unitsInWay = true;
								NewBuild = new TilePosition(x, y);
							}
						}
						if (!unitsInWay && NewBuild != LastBuild && game.isVisible(new TilePosition(x, y))) {
							LastBuild = new TilePosition(x, y);
							buildingName = buildingType;
							return new TilePosition(x, y);

						}
			
					}
				}
			}
		}
		game.sendText("Something went wrong, returning null for build");
		return null;

	}
	
	
	public TilePosition getLandLocation(Unit building, TilePosition aroundTile) {
		TilePosition ret = null;
		int LastX1 = building.getX();
		int LastY1 = building.getY();
		int maxDist = 10;
		int stopDist = 600;
		
		while ((maxDist < stopDist) && (ret == null)) {
			for (LastX1 = aroundTile.getX() - maxDist; LastX1 <= aroundTile.getX() + maxDist; LastX1++) {
				for (LastY1 = aroundTile.getY() - maxDist; LastY1 <= aroundTile.getY() + maxDist; LastY1++) {
					if (building.canLand(new TilePosition(LastX1, LastY1)) == true) {
						return new TilePosition(LastX1, LastY1);
					}
				}

			}

		}
		return ret;
	}

	public TilePosition NextExpand(Unit builder) {
		boolean hasLocation = false;
		int stopdist = 5000;
		int dist = 0;
		int i = 0;
		int max = BWTA.getBaseLocations().size();
		boolean alreadyTaken;
		while (hasLocation == false && dist < stopdist) {
			dist = dist + 200;
				for (BaseLocation Expand : BWTA.getBaseLocations()) {
					alreadyTaken = false;
					int AmountofBases = BWTA.getBaseLocations().size();
					int tree = (int) BWTA.getGroundDistance(BasePos, Expand.getTilePosition());
					if (Expand.getGroundDistance(BWTA.getNearestBaseLocation(BasePos)) < dist
							&& BWTA.getGroundDistance(Expand.getTilePosition(), self.getStartLocation().getPoint()) > 50
							&& claimedBaseLocations.contains(Expand) == false) {;
						if (Bases > 1 && BWTA.getGroundDistance(lastExpandPos, Expand.getTilePosition()) > 150) {
							hasLocation = true;
							claimedBaseLocations.add(Expand);
							ExpandPos = Expand.getTilePosition();
							return Expand.getTilePosition();
						}
						if (Bases == 1 && alreadyTaken == false) {
							hasLocation = true;
							claimedBaseLocations.add(Expand);
							ExpandPos = Expand.getTilePosition();
							return Expand.getTilePosition();
						}
	
						if (dist >= stopdist) {
							ValidBasesClaimed = true;
							expanding = false;
							game.sendText("Yeah, Straight from the top of my dome ran outta of places to drop a CC and call home");
							saving = false;
							return null;
						}
					}
	
				}

		}
		ValidBasesClaimed = true;
		expanding = false;
		needsToExpand = false;
		buildwait = false;
		saving = false;
		return null;
	}


	public Unit GetWorker() {
		for (Unit unit : myWorkers) {
			if (unit.getType() == UnitType.Terran_SCV && unit.isGatheringMinerals() == true
					&& unit.isConstructing() == false && unit.isMoving() == false
					&& unit.isRepairing() == false && unit.isTraining() == false) {
				if(unit.getID() != scoutID){
				return unit;
				}
			}
		}
		//System.out.println("Get Worker returning null");
		return null;
		

	}

	public Position GetKitePos(Unit unit, Unit target) {
		Position Kite1 = new Position(target.getX() - unit.getX(), target.getY() - unit.getY());
		double Kite2 = Math.atan2(Kite1.getX(), Kite1.getY());
		int Int1 = (int) (64 * Math.cos(Kite2));
		int Int2 = (int) (64 * Math.sin(Kite2));
		Kite1 = new Position(Int1, Int2);
		return Kite1;
	}

	public Position GetKitePos2(Unit unitt, Unit targett) {
		Position fp1 = new Position(unitt.getX() - targett.getX(), unitt.getY() - targett.getY());
		Position fp2 = new Position(unitt.getX(), unitt.getY());
		Position fp3 = new Position(fp1.getX(), fp1.getY() + fp2.getX() + fp2.getY());
		return fp3;

	}

	public Position getJukePos(Unit unitt, Unit targett) {
		Position fp1 = new Position(unitt.getX() - targett.getX(), unitt.getY() - targett.getY());
		Position fp2 = new Position(unitt.getX(), unitt.getY());
		Position fp3 = new Position(fp1.getX() + fp2.getX(), fp1.getY() + fp2.getY());
		Position Move = fp3;
		if (Move.isValid() == true && Move != null) {
			return Move;
		} else {
			return null;
		}
	}
	
	public Position GetJukePos2(Unit unit, Unit targett){
		int unitx = unit.getX();
		int unity = unit.getY();
		int targetx = targett.getX();
		int targety = targett.getY();
		int finalx = unitx + unitx - targetx;
		int finaly = unity + unity - targetx;
		Position Final = new Position(finalx, finaly);
		if(Final.isValid() == true){
			return Final;
		}
		else{
			Position goat = Final.makeValid();
			if(goat != null){
				return goat;
			}
		}
		return null;
	}
	
	public Position RunFromPos(Unit unit, Position pos){
		int unitx = unit.getX();
		int unity = unit.getY();
		int targetx = pos.getX();
		int targety = pos.getY();
		int finalx = unitx + unitx - targetx;
		int finaly = unity + unity - targetx;
		Position Final = new Position(finalx, finaly);
		if(Final.isValid() == true){
			return Final;
		}
		return null;
	}
	
	

	public boolean IsMilitrayUnit(Unit unit) {
		int Damage = unit.getType().groundWeapon().damageAmount() + unit.getType().airWeapon().damageAmount();
		if(Damage > 0 && unit.getType().isWorker() == false && unit.getType().isBuilding() == false && unit.getType().isSpell() == false){
			return true;
		}
		return false;
	}
		
		public boolean IsMilitrayBuilding(Unit unit) {
			if(unit.getType() == UnitType.Terran_Bunker ||
			unit.getType() == UnitType.Terran_Missile_Turret ||
			unit.getType() == UnitType.Zerg_Sunken_Colony ||
			unit.getType() == UnitType.Zerg_Spore_Colony ||
			unit.getType() == UnitType.Protoss_Photon_Cannon){
				return true;
			}
		

		return false;

	}



	public Position Regroup() {
		int X = 0;
		int Y = 0;
		int index = 0;
		int max = myUnits.size();
		for (Unit unit : myUnits) {
			index = index + 1;
			int unitX = unit.getX();
			int unitY = unit.getY();
			X = X - unitX / myUnits.size();
			Y = Y - unitY / myUnits.size();
			if (index >= max) {
				Position pos = new Position(X, Y);
				if (pos.isValid() == false) {
					pos.makeValid();
					RegroupPos = pos;
					return pos;
				}
				return pos;

			}

		}

		return null;

	}
	
	public String GetStrategy(String enemyRace) {
		boolean hasStrategy = false;
		
		if(enemyRace == "Zerg"){
			//game.printf("Bio");
			return "Bio";
			
		}
		
		if(enemyRace == "Protoss"){
			Random rand = new Random();
			int n = rand.nextInt(3) + 1;
			if(n == 4){
				//game.printf("Bio");
				return "Bio";
				
			}
			else {
				//game.printf("Mech");
				return "Mech";
			}
				
			
		}
		
		if(enemyRace == "Terran"){
			Random rand = new Random();
			int n = rand.nextInt(3) + 1;
			
			if(n == 4){
				//game.printf("Bio");
				return "Bio";
			}
			else {
				//game.printf("Mech");
				return "Mech";
			}
				
			
		}
		
		return null;
	}
	
	public void GlobalRetreat(){
		
		for(Unit i: myUnits){
			if(ralleyPoint != null){
				i.move(ralleyPoint);
			}
				
		}
		
		for(Unit i : myMedics){
			if(ralleyPoint != null){
				i.move(ralleyPoint);
			}
		}
		
		
			
		}
	
	
	public UnitType SpamSpend(int mins, int gas, int macroBuildings) {
		
		
		if(macroBuildings >= 5){
			return null;
		}
		
	
		
		if(mins > 1000 && gas > 500){
			return UnitType.Terran_Factory;
		}
			
		
		if(mins > 1200){
			return UnitType.Terran_Barracks;
		}
		
		
					
		return null;
	}
	
	
	public boolean IsAttackMoving(Unit unit){
		if(unit.getOrder() == Order.AttackMove){
			return true;
		}
		return false;
	}
	
	public boolean IsABusy(Unit unit){
		if(unit.getOrder() == Order.AttackMove || unit.isAttacking() == true){
			return true;
		}
		return false;
	}
	
	public boolean orderStacking(Unit unit, Position pos){
		if(unit.getOrderTargetPosition() == pos){
			return true;
		}
		
		return false;
	}
	
	
	public void DefenceCall(Unit victim){
		
	boolean canWin = jFapDefenceCheck(victim.getPosition());
	//TODO this whole thing
	//grabbing the score of invaders and sending a squad of units against it with similar or greater score
	
		if(defenderCall == true && canWin == true){
		defenceCallFrames = 1;
		defenderCall = false;
		
		
		if(myUnits.size() < 6 && totalFrames < 8500 && victim != scouter && canWin == false){
			PullTheBoys(victim.getPosition());
			game.sendText("PULL THE BOYS");
			// When we met I was sure out to lunch
			// Now my empty cup tastes as sweet as the punch
			// Sweet as the punch
		}
		
		
		//System.out.println("Victim script triggered at: " + totalFrames);
		if(victim.getType().isWorker() == true && victim.getID() != scoutID && canWin == true){
			for(Unit defenders : myUnits){
				boolean isMil = IsMilitrayUnit(defenders);
				int dist = defenders.getDistance(victim);
				if(defenders.isAttacking() == false && dist > 100){
					boolean stacking = orderStacking(defenders, victim.getPosition());
					if(stacking == false){
						defenders.attack(victim.getPosition());
					}
				}
			}
		}
		
		if(victim.getType().isBuilding() == true && canWin == true){
			for(Unit defenders : myUnits){
				boolean isMil = IsMilitrayUnit(defenders);
				int dist = defenders.getDistance(victim);
				if(defenders.isAttacking() == false && dist > 100){
					boolean stacking = orderStacking(defenders, victim.getPosition());
					if(stacking == false){
						defenders.attack(victim.getPosition());
					}
				}
			}
		}
		
		if(victim.getType().isWorker() == false && victim.getType().isBuilding() == false && canWin == true){
			ArrayList<Unit> meinUnits = new ArrayList<Unit>();
			ArrayList<Unit> meinNichtUnits = new ArrayList<Unit>();
			for(Unit units : game.getUnitsInRadius(victim.getPosition(), 450)){
				boolean isMil = IsMilitrayUnit(units);
				if(units.getPlayer() == self && isMil == true && meinUnits.contains(units) == false){
					meinUnits.add(units);
				}
				
				if(units.getPlayer().isEnemy(self) && isMil == true && meinNichtUnits.contains(units) == false){
					meinNichtUnits.add(units);
				}
			}
			boolean sdf = jFaplocal(meinUnits, meinNichtUnits, 1);
			if(sdf == true){
				for(Unit unit1 : meinUnits){
					int dist = unit1.getDistance(victim);
					if(unit1.isAttacking() == false && dist > 100){
						boolean stacking = orderStacking(unit1, victim.getPosition());
						if(stacking == false){
							unit1.attack(victim.getPosition());
						}
					}
				}
			}
		}
		
		
		// end of defending. 
		
	}
	
}
	
public void GlobalAttack(Position pos) {
		for(Unit defenders : myUnits){
			int dist = defenders.getDistance(pos);
			if(defenders.isAttacking() == false && dist > 100){
				boolean stacking = orderStacking(defenders, pos);
				if(stacking == false){
					defenders.attack(pos);
				}
			}
		}

	
}

public void UpdateStrats(){
	int scan = getTotalScanEnergy();
	UpdateMyScore();
	boolean shouldEarlyAttack = false;
	int total = 0;	
	boolean CanWin = CanWinAttack();
	boolean picked = false;

	Strats = "Justifying War Goals";
	boolean canExpand = CanExpand();
	boolean shouldregroup = false;
	if(enemyBuildingMemory.isEmpty() == false){
	shouldregroup = ShouldRegroup(enemyBuildingMemory.get(0));
	//System.out.println("ShouldRegroup: " + shouldregroup);
	}
	
	
	if(TeamGameMode == false){
	
	
	if(Bunks > 0){
	shouldEarlyAttack = true;
	}
	
	if(Bunks == 0){
		shouldEarlyAttack = false;
	}

	
	if (totalFrames > 16000){
		shouldEarlyAttack = true;
	}


	if(CanWin == true && shouldEarlyAttack == true && shouldregroup == false){
		
			UnitType type = NextTechGoal();
				
			if(type != null){
				if(pBuildings.contains(type) == false){
				pBuildings.add(type);
				pPosition.add(null);
				}
			}
				
			if(InvadersScore == 0){
				attacking = true;
				picked = true;
				Strats = "Full Attack";
			}

		}
		
		else if(shouldregroup == true) {
			attacking = false;
			picked = true;
			Strats = "Regrouping main army";
			GlobalRetreat();
			if(pBuildings.size() > 1){
				RemoveAllButFirstTech();
				int sizze = pBuildings.size() - 1;
				game.sendText("Removed: " + sizze + " Building queued for construction" );
			}
		}
		else if(shouldregroup == false){
			attacking = false;
			picked = true;
			Strats = "Waiting for more strength";
			GlobalRetreat();
			if(pBuildings.size() > 1){
				RemoveAllButFirstTech();
				int sizze = pBuildings.size() - 1;
				game.sendText("Removed: " + sizze + " Building queued for construction" );
			}

		}
		
	}
	else {

		if(Bunks > 0){
			Conscript();
		}
			
		if(Bunks < 1){
				shouldEarlyAttack = false;
		}
			
		if (totalFrames > 16000){
				shouldEarlyAttack = true;
		}
		

		int target = GetPlayerTarget();
		if(target != 10){
		boolean shouldregroup1 = false;
		if(playerBuildings.get(target).isEmpty() == false){
		shouldregroup1 = ShouldRegroup(playerBuildings.get(target).get(0));
		System.out.println("Should Regroup: " + shouldregroup1);
		}
		
		String names = game.getPlayer(target).getName();
		System.out.println("Targetted player is: " + names);
		//if we have a target in ffa

		TeamModeTargetPlayer = target;
		if(InvadersScore == 0){
			attacking = true;
			Strats = "Full Attack";
			picked = true;
		}
		else if(shouldregroup1 == true) {
			attacking = false;
			picked = true;
			Strats = "Regrouping main army";
			GlobalRetreat();
		}
		else if(shouldregroup1 == false) {
			attacking = false;
			picked = true;
			Strats = "Waiting for more army strength";
			GlobalRetreat();
		}

		
		}
		else {
			attacking = false;
			picked = true;
			Strats = "Waiting for more army strength";
			GlobalRetreat();
		}
		
		
	}
	
	
}

public void LocalAttack(Position pos, int radius){
	
}



public boolean CanWin(){
	
	if(fapMyScores > (estimatedEnemyScore + enemyDefenceScore)){
		return true;
	}
	return false;
}

public boolean CanWinAttack(){
	
	if(fapMyScores > (estimatedEnemyScore + enemyDefenceScore + enemyGhostPoints)){
		return true;
	}
	return false;
}


public void ThinkUnit(Unit myUnit){
	
	if (myUnit.getType() == UnitType.Terran_Marine && myUnit.canUseTech(TechType.Stim_Packs) == true && myUnit.isStimmed() == false) {
		myUnit.useTech(TechType.Stim_Packs);
	}
	
	if (myUnit.getType() == UnitType.Terran_Siege_Tank_Tank_Mode && myUnit.canUseTech(TechType.Tank_Siege_Mode) == true) {
		myUnit.useTech(TechType.Tank_Siege_Mode);
	}
	
	if (myUnit.getType() == UnitType.Terran_Firebat && myUnit.canUseTech(TechType.Stim_Packs) == true && myUnit.isStimmed() == false) {
		myUnit.useTech(TechType.Stim_Packs);
	}
	
	if (myUnit.getType() == UnitType.Terran_Vulture && myUnit.isAttacking() == true && myUnit.getSpiderMineCount() != 0) {
		Unit unit = myUnit;
		if (myUnit.canUseTech(TechType.Spider_Mines, myUnit.getPosition()) == true
				&& myUnit.getLastCommand() != UnitCommand.useTech(unit, TechType.Spider_Mines)) {
			Position lastorder = unit.getTargetPosition();
			unit.useTech(TechType.Spider_Mines, unit.getPosition());
			unit.attack(lastorder, true);
		}

	}
	
	
}

public void Banzai(){
	

	for (Unit Attackers : myUnits) {

		boolean isAMoving = IsAttackMoving(Attackers);
		boolean isMilitray2 = IsMilitrayUnit(Attackers);
		


		if (enemyBuildingMemory.isEmpty() == false) {
			//game.sendText("Attacking, remembered locations");
			Position P = enemyBuildingMemory.get(1);
				if (isMilitray2 == true && isAMoving == false || Attackers.isAttacking() == false) {
					boolean isStacking = orderStacking(Attackers, P);
					boolean busy = IsABusy(Attackers);
					if(isStacking == false && busy == false){
						Attackers.attack(P);
					}
					
					
			}
		} else {
			//game.sendText("No remembered locations, attacking all base locations.");
			for (BaseLocation b : BWTA.getBaseLocations()) {
				if (b.getPoint().isValid() == true && game.isVisible(b.getTilePosition()) == false) {
					for (Unit Attackers2 : myUnits) {
						boolean isMilitray3 = IsMilitrayUnit(Attackers2);
							if (isMilitray3 == true && isAMoving == false || Attackers.isAttacking() == false) {
								boolean isStacking = orderStacking(Attackers2, b.getPoint());
								boolean busy = IsABusy(Attackers2);
								if(isStacking == false && busy == false){
									Attackers2.attack(b.getPoint());
								}
				
							}
						}
				}
			}

		}
	}
}
	



public boolean CanExpand(){
	// TODO Yolo expands. Expanding even if enemy score is greater then mine if needs > income * 0.20 (20% of my income)
	// also TODO is a fancy color in eclipse =D
	// Stop Ctrl-f'ing my code Hannes
	// nuke nuke hannes bregberg nuke more nukes ghost stuff bio bot
	if(TeamGameMode == false){
		if(fapMyScores > InvadersScore + Math.round(estimatedEnemyScore / 3)){
			return true;
		}
		else{
			return false;
		}
	}
	else {
		int highest = GetHighestPlayerScore();
		if(fapMyScores > InvadersScore + Math.round(highest / 1.5)){
			return true;
		}
		return false;
	}

}

public boolean jFapDefenceCheck(Position pos){
	JFAP simulator = new JFAP(game);
	simulator.clear();
	
	for (Unit targets : game.getUnitsInRadius(pos, 200)) {
		int damage = targets.getType().groundWeapon().damageAmount() + targets.getType().airWeapon().damageAmount();
		
		if (targets.getPlayer().isEnemy(self) && damage > 0) {
			simulator.addUnitPlayer2(new JFAPUnit(targets)); // Adds an enemy unit to the simulator

			
		}

		if(targets.getPlayer().isAlly(self) && targets.getType() == UnitType.Terran_Bunker && targets.getLoadedUnits().size() > 0 ){
			simulator.addUnitPlayer1(new JFAPUnit(targets));
		}
	}
	
	for(Unit unit : myUnits){
		simulator.addUnitPlayer1(new JFAPUnit(unit));
	}
	
	Pair<Integer, Integer> preSimScores = simulator.playerScores();
	int preSimFriendlyUnitCount = simulator.getState().first.size();
	simulator.simulate(50);
	int isMain = (int) (fapMyScores * 0.65);
	//is 65% or more of my army in this battle?
	if(preSimScores.first > isMain){
		if(preSimScores.first < preSimScores.second){
			//and if we can't win
			if(Strats == "Full Attack"){
					Strats = "Regrouping Due to major calculated loss";
					GlobalRetreat();
			}
		}
	}
	//int regionbonus = (game.getRegionAt(pos).getDefensePriority() / 3);
	

	Pair<Integer, Integer> postSimScores = simulator.playerScores();
	int postSimFriendlyUnitCount = simulator.getState().first.size();
	int myLosses = preSimFriendlyUnitCount - postSimFriendlyUnitCount;
	int myScoreDiff = preSimScores.first - postSimScores.first;
	int enemyScoreDiff = preSimScores.second - postSimScores.second;
	//System.out.println("Me : " + myScoreDiff);
	//System.out.println("Enemy : " + enemyScoreDiff);
	// if we can win
	if (postSimScores.first > postSimScores.second) {
		return true;
	} 
	else {
		return false;
	}
	


}


public void Conscript(){
	
//	for(Unit bunkers : myBunkers){
//		if(bunkers.getType() == UnitType.Terran_Bunker && bunkers.getLoadedUnits().size() > 0){
//			for(Unit loaded : bunkers.getLoadedUnits()){
//				if(bunkerUnits.contains(loaded) == false){
//					bunkerUnits.add(loaded);
//				}
//			}
//			
//			
//			
//		}
//	}
//
//	
//	for(Unit units : self.getUnits()){
//		boolean isMilitray2 = IsMilitrayUnit(units);
//		if(bunkerUnits.isEmpty() == false && bunkerUnits.contains(units) == false && isMilitray2 == true && myUnits.contains(units) == false){
//			myUnits.add(units);
//			System.out.println("Added unit: " + units.getType().toString() + " To active unit pool");
//		}
//		
//
//	}
	

}


public void PreAttackScan(){
	int i = 1;
	int max = ScanLocations.size();
		Position nextScan = ScanLocations.get(i);
		for (Unit detectors : myComSats) {
				if(max == 0){
					break;
				}
				int bonus = 0;
				i = i + 1;
				if (detectors.getType() == UnitType.Terran_Comsat_Station && detectors.getEnergy() >= 100) {
					detectors.useTech(TechType.Scanner_Sweep, nextScan);
					bonus = bonus + 50;
				}
				
				if(nextScan == null){
					break;
				}
				
				if(i >= max){
					break;
				}
				
				if(updateStrategy > 410){
					break;
				}
		}
	
}

public void PanicBuildMil(){
	for (Unit buildings : productionBuildings) {
		
		// best way to get the bot to build after its build
		// frozen is probably max the supply and let it spam.
		
		if (buildings.getType() == UnitType.Terran_Factory && self.minerals() >= 600
				&& self.gas() >= 300 && buildings.isIdle() == true) {
			buildings.train(UnitType.Terran_Siege_Tank_Tank_Mode);
		}
		if (buildings.getType() == UnitType.Terran_Barracks && self.minerals() >= 700
				 && AcademyBuilt == true && buildings.isIdle() == true) {
					buildings.train(UnitType.Terran_Marine);
		}

		if (buildings.getType() == UnitType.Terran_Starport && game.canMake(UnitType.Terran_Battlecruiser) == true && self.minerals() >= 700 && self.gas() >= 300 && buildings.isIdle() == true) {
			buildings.train(UnitType.Terran_Battlecruiser);
		}

	}
}


public void PullTheBoys(Position pos){
	if(BWTA.getGroundDistance(self.getStartLocation(), pos.toTilePosition()) < 2000){
		for(Unit unit : myWorkers){
			if(unit.isGatheringMinerals() == true){
			boolean isBusy = IsABusy(unit);
			if(isBusy == false){
				unit.attack(pos);
				}
			}
		}
	}
}

public int getTotalScanEnergy(){
	int fishguy4000 = 0;
	for(Unit unit: myComSats){
		fishguy4000 = fishguy4000 + unit.getEnergy();
	}
	return fishguy4000;
}


public int getGhostScore(Unit unit){

	
	if (unit.getType() == UnitType.Terran_Factory && unit.getPlayer().isEnemy(self)) {
		return 200;
	}
	
	if (unit.getType() == UnitType.Terran_Barracks && unit.getPlayer().isEnemy(self)) {
		return 100;
	}
	
	if (unit.getType() == UnitType.Protoss_Gateway && unit.getPlayer().isEnemy(self)) {
		return 150;
	}
	
	if (unit.getType() == UnitType.Zerg_Hatchery && unit.getPlayer().isEnemy(self)) {
		return 150;
	}
	
	return 0;
	
}

public int getScoreOf(Unit fu){
	// Stolen and modified slightly from jFap's code directly
	
	UnitType auxType = fu.getType();
	int health = fu.getHitPoints();
	int score = fu.getType().destroyScore();
	int maxHealth = fu.getType().maxHitPoints();
	
	if(auxType == UnitType.Terran_Medic || auxType == UnitType.Terran_Science_Facility){
		return 0;
	}
	
	if(auxType == UnitType.Terran_Marine){
		return ((auxType.destroyScore() * auxType.maxHitPoints()) / (auxType.maxHitPoints() * 2)) + 25;
	}
	return ((auxType.destroyScore() * auxType.maxHitPoints()) / (auxType.maxHitPoints() * 2));
}


public int amountOfGasHarvesters(Unit target){
	int eyes = 0;
	for(Unit unit : myWorkers){
		if(unit.isGatheringGas() == true && unit.getOrderTargetPosition() == target.getPosition()){
			eyes++;
		}
	}
	game.sendText("" + eyes);
	return eyes;
	
}


public boolean IsInChoke(Unit unit){
	
if(enemyChokes.contains(unit.getRegion()) == true){
	return true;
}
else {
	return false;
}

}


public void CheckBuilding(Unit unit){
	if(unit.getType() == UnitType.Zerg_Spire || unit.getType() == UnitType.Protoss_Stargate || unit.getType() == UnitType.Terran_Starport){
		if(Bays > 0){
		game.sendText("Air Unit production building detected, responsive unit: Missile Turret");
		pBuildings.add(UnitType.Terran_Missile_Turret);
		pPosition.add(null);;
		}
		else {
			pBuildings.add(UnitType.Terran_Engineering_Bay);
			pPosition.add(null);
			pBuildings.add(UnitType.Terran_Missile_Turret);
			pPosition.add(null);
			pBuildings.add(UnitType.Terran_Missile_Turret);
			pPosition.add(null);
			pBuildings.add(UnitType.Terran_Missile_Turret);
			pPosition.add(null);
		}
	}
	

	if(unit.getType() == UnitType.Protoss_Templar_Archives){
		if(Bays > 0){
		game.sendText("DT production building detected, responsive unit: Missile Turret");
		pBuildings.add(UnitType.Terran_Missile_Turret);
		pPosition.add(ralleyPoint.toTilePosition());
		}
		else {
			pBuildings.add(UnitType.Terran_Engineering_Bay);
			pPosition.add(null);
			pBuildings.add(UnitType.Terran_Missile_Turret);
			pPosition.add(ralleyPoint.toTilePosition());

		}


	}



	
	
}


public boolean isOrderToBuildOrBetter(UnitType type){
	int iHave = HowManyDoIHave(type);
	int ordered = HowManyOrderedToBuild(type);

	if(ordered > 0){
		return true;
	}
	
	return false;
}

public void PAddAmount(UnitType type, int i){
	int index = pBuildingsBuiltAmount.indexOf((pBuildingsBuilt.indexOf(type)));
	int amountInside = pBuildingsBuiltAmount.get(pBuildingsBuilt.indexOf(type));
	int needed = amountInside + i;
	pBuildingsBuiltAmount.add(index, needed);
}



public void CheckInvaders(){
	int i = 0;
	for(Unit unit : game.getUnitsInRadius(self.getStartLocation().toPosition(), 2000)){
		int bonus = getScoreOf(unit);
		boolean isMil = IsMilitrayUnit(unit);
		if(isMil == true && unit.getPlayer().isEnemy(self)){
			i = i + bonus;
		}
	}
	
//	
//	for(Unit unit : enemyUnits){
//		if(unit.isVisible() == true){
//			bwapi.Region rego = game.getRegionAt(unit.getOrderTargetPosition());
//			if(myRegions.contains(rego) == true){
//				int bonus = getScoreOf(unit);
//				i = i + bonus;
//				System.out.println("Attacker Detected");
//				
//			}
//			else {
//				//System.out.println("Not in one of my regions");
//			}
//		}
//	}
	
	InvadersScore = i;
}


public String GetCustomName(UnitType type){
	
	if(type == UnitType.Terran_Marine){
		return "Shooty Boy";
	}
	
	if(type == UnitType.Terran_Medic){
		return "Gamer Girl";
	}
	
	if(type == UnitType.Terran_Siege_Tank_Tank_Mode){
		return "Angry Rectangle";
	}
	
	if(type == UnitType.Terran_Siege_Tank_Siege_Mode){
		return "Slightly More Angrier Rectangle";
	}
	
	if(type == UnitType.Protoss_Zealot){
		return "Imba Unit";
	}
	
	if(type == UnitType.Protoss_Dragoon){
		return "Walking Cannon";
	}
	
	if(type == UnitType.Zerg_Zergling){
		return "Cute Dog";
	}
	
	if(type == UnitType.Zerg_Hydralisk){
		return "Very Angry Goat";
	}
	
	if(type == UnitType.Zerg_Mutalisk){
		return "Bin Chicken";
	}
	
	if(type == UnitType.Zerg_Lurker){
		return "Karambwan";
	}
	
	if(type == UnitType.Terran_Vulture){
		return "Skateboard";
	}
	
	if(type == UnitType.Terran_Firebat){
		return "Vietnam Flashbacks";
	}
	
	if(type == UnitType.Terran_Goliath){
		return "3 Marines Duct Taped to a Missile Turret";
	}
	
	if(type == UnitType.Protoss_High_Templar){
		return "Al Gore";
	}
		
	if(type == UnitType.Protoss_Archon){
		return "Super Saiyan gone super Saiyan";
	}
	
	if(type == UnitType.Zerg_Overlord){
		return "My sister";
	}
	
	return type.toString();
}


public Position ChooseDefendableArea(Unit unit) {
	return null;
	
}

public Unit GetAttacker(Unit myUnit, int radius){
	for(Unit unit : game.getUnitsInRadius(myUnit.getPosition(), radius)){
		if(unit.getOrderTarget() == myUnit){
			return unit;
		}
	}
	return null;
}

public void UpdateMyScore(){
	int total = 0;
	for(Unit unit : myUnits){
		if(bunkerUnits.contains(unit) == false || unit.isLoaded() == false){
			int score = getScoreOf(unit);
			total = total + score;
		}

	}
	fapMyScores = total;
}

public boolean ShouldMoveRalleyPoint(Position pos){
	
	if(pos.getApproxDistance(ralleyPoint) > 2000){
		return true;
	}
	
	return false;
}

public boolean BuildingAlreadyBeingOrdered(UnitType type, int amount){
int i = 0;
for(UnitType type1 : buildTypes){
	if(type1 == type){
		i++;
	}
}

if(i >= amount){
	return true;
}
	
return false;


}

public boolean HasBunkerNearRegroup(){
	for(Unit unit : game.getUnitsInRadius(ralleyPoint.getPoint(), 100)){
		if(unit.getType() == UnitType.Terran_Bunker && unit.getPlayer() == self){
			return true;
		}
	}
	
	return false;
}

public boolean BunkersCanAttack(Unit target){
	for(Unit unit : myBunkers){
		if(unit.getLoadedUnits().size() > 0 && unit.canAttack(target) == true){
			return true;
		}
	}
	return false;
}


public Unit GetNearestBunker(Position pos){
	int i = 0;
	Unit local = null;
	for(Unit unit : myBunkers){
		if(unit.getDistance(pos) <= i || i == 0){
			i = unit.getDistance(pos);
			local = unit;
		}
	}
	if(local != null){
		return local;
	}
	else {
		return null;
	}
	
}

public boolean jFaplocal(ArrayList<Unit> mine, ArrayList<Unit> enemy, int bonus){
	JFAP simulator = new JFAP(game);
	simulator.clear();
	
	for(Unit unit : mine){
		simulator.addUnitPlayer1(new JFAPUnit(unit));
	}
	
	for(Unit unit : enemy){
		simulator.addUnitPlayer2(new JFAPUnit(unit));
	}
	

	Pair<Integer, Integer> preSimScores = simulator.playerScores();
	int preSimFriendlyUnitCount = simulator.getState().first.size();
	simulator.simulate(50);
	int isMain = (int) (fapMyScores * 0.65);
	//is 65% or more of my army in this battle?
	if(preSimScores.first > isMain){
		if(preSimScores.first < preSimScores.second){
			//and if we can't win
			if(Strats == "Full Attack"){
					Strats = "Regrouping Due to major calculated loss";
					attacking = false;
					GlobalRetreat();
			}
		}
	}

	

	Pair<Integer, Integer> postSimScores = simulator.playerScores();
	int postSimFriendlyUnitCount = simulator.getState().first.size();
	int myLosses = preSimFriendlyUnitCount - postSimFriendlyUnitCount;
	int myScoreDiff = preSimScores.first - postSimScores.first;
	int enemyScoreDiff = preSimScores.second - postSimScores.second;
	//System.out.println("Me : " + myScoreDiff);
	//System.out.println("Enemy : " + enemyScoreDiff);
	// if we can win
	if (postSimScores.first > postSimScores.second * bonus) {
		return true;
	} 
	else {
		return false;
	}
	
}

public boolean HasTechFor(UnitType type){
	if(type == UnitType.Terran_Goliath){
		if(Factories > 0 && Armor > 0){
			return true;
		}
	}
	if(type == UnitType.Terran_Marine){
		if(Racks > 0){
			return true;
		}
	}
	return false;
}

public UnitType NextTechGoal(){
	
	if(Bays == 0 && buildTypes.contains(UnitType.Terran_Engineering_Bay) == false && HowManyDoIHave(UnitType.Terran_Engineering_Bay) == 0){
		return UnitType.Terran_Engineering_Bay;
	}
	
	if(AcademyBuilt == false && buildTypes.contains(UnitType.Terran_Academy) == false && HowManyDoIHave(UnitType.Terran_Academy) == 0){
		return UnitType.Terran_Academy;
	}
	
	if(Factories == 0 && buildTypes.contains(UnitType.Terran_Factory) == false && HowManyDoIHave(UnitType.Terran_Factory) == 0 && Racks >= MaxRacks){
		return UnitType.Terran_Factory;
	}
	
	if(Armor == 0 && buildTypes.contains(UnitType.Terran_Armory) == false && HowManyDoIHave(UnitType.Terran_Armory) == 0 && Factories > 0){
		return UnitType.Terran_Armory;
	}
	
	if(StarPorts == 0 && buildTypes.contains(UnitType.Terran_Starport) == false && HowManyDoIHave(UnitType.Terran_Starport) == 0 && fapMyScores > 1500 && Factories > 0){
		return UnitType.Terran_Starport;
	}
	
	if(TSF == 0 && buildTypes.contains(UnitType.Terran_Science_Facility) == false && HowManyDoIHave(UnitType.Terran_Science_Facility) == 0 && fapMyScores > 1500 && StarPorts > 0 ){
		return UnitType.Terran_Science_Facility;
	}
	
	return null;
}

public void RemoveAllButFirstTech(){
	if(pBuildings.size() != 1){
		for (int i = 0; i < pBuildings.size(); i++){
			if(i != 0){
				pBuildings.remove(i);
			}
		}
	}
}


public int HowManyDoIHave(UnitType type){
	int i = 0;
	for(Unit unit : self.getUnits()){
		if(unit.getType() == type){
			i++;
		}
	}
	
	return i;
}

public int HowManyDoIHaveCompleted(UnitType type){
	int i = 0;
	for(Unit unit : self.getUnits()){
		if(unit.getType() == type && unit.isCompleted() == true){
			i++;
		}
	}
	
	return i;
}

public int HowManyOrderedToBuild(UnitType type){
	int i = 0;
	
	if(pWorkers.isEmpty()){
		return 0;
	}
	
	for(Pair<Unit, UnitType> pear : pWorkers){
		if(pear.second == type){
			i++;
		}
	}
	return i;
}

public int GetPlayerTarget() {
	for(Player p : game.enemies()){
		if(p.isDefeated() == false){
			int index = p.getID();
			int tscore = playerScores.get(index);
			if(fapMyScores > tscore){
				return index;
			}
		}
	}
	return 10;
	
}

public int GetHighestPlayerScore() {
	int highest = 0;
	int pplayer = 10;
	for(Player p : game.enemies()){
		if(p.isDefeated() == false){
			int index = p.getID();
			int tscore = playerScores.get(index);
			if(tscore >= highest){
				pplayer = p.getID();
				highest = tscore;
			}
		}
	}
	if(pplayer != 10){
		return highest;
	}
	else {
		return 1300;
	}
	
}

public boolean ShouldRegroup(Position pos) {
	// TODO fix this shit
int dist = 0;
boolean hasUnitsNearby = false;

	if(game.isVisible(pos.toTilePosition()) == false){
		return false;
	}

	if(myUnits.isEmpty() == false){

		for(Unit units : myUnits){
				dist = dist + units.getPosition().getApproxDistance(pos);
				System.out.println("Dist is now: " + dist);
		
		}
		
		dist = Math.round(dist / myUnits.size());
		System.out.println("Dist Final is: " + dist);

		if(dist > 3000){
			return true;
		}
		return false;
	}
	else {
		return false;
	}
	
}

public Region GetRegionBehindBunker(Unit bunker, Unit runfrom){
	int dist = 0;
	Region target = null;
	Region bunkerRegion = bunker.getRegion();
	
	for(Region regions : bunkerRegion.getNeighbors()){
		if(bunkerRegion.getDistance(regions) < dist){
			dist = bunkerRegion.getDistance(regions);
			target = regions;
		}
	}
	
	if(target != null){
		return target;
	}
	
	
	
	return null;
}

public boolean DoesOutRangeBunker(Unit bunker, Unit target){
	int hasRange = self.getUpgradeLevel(UpgradeType.U_238_Shells);
	int brange = UnitType.Terran_Marine.groundWeapon().maxRange();
	int range = target.getType().groundWeapon().maxRange();
	int bonus = 0;
	
	if(target.getType() == UnitType.Protoss_Dragoon && target.getPlayer().getUpgradeLevel(UpgradeType.Singularity_Charge) == 1){
		return true;
	}
	
	
	if(range > brange){
		return true;
	}
	
	return false;
}

public Bullet GetNearestBullet(BulletType type, Position pos){
	//System.out.println("Trigger Function");
	//System.out.println("Size: " + game.getBullets().size());
	int lowest = 0;
	Bullet bullet1 = null;
	for(Bullet bullets : game.getBullets()){
		if(bullets.getSource().getType() == UnitType.Protoss_High_Templar){
			System.out.println("Is Type");
			if(bullets.getPosition().getApproxDistance(pos) <= lowest || bullet1 == null){
				lowest = bullets.getPosition().getApproxDistance(pos);
				bullet1 = bullets;
			}
		}
	}
	if(bullet1 != null){
		return bullet1;
	}
	else {
		return null;
	}
}

public boolean UnitIsAttackingUnit(Unit attacker, Unit victim){
	if(attacker.getOrder() == Order.AttackUnit && attacker.getOrderTarget() == victim){
		return true;
	}
	
	if(attacker.getOrder() == Order.AttackMove && attacker.getOrderTargetPosition() == victim.getPosition()){
		return true;
	}
	
	return false;
}

public boolean CanMakeWorkers(){
	if(InvadersScore > 0){
		return false;
	}
	
	return true;
}

public boolean HasUnitsNearbyToCombat(Unit target){
	int score = 0;
	int targetscore = getScoreOf(target);
	
	if(fapMyScores < estimatedEnemyScore){
		return true;
	}
	
	for(Unit unit : myUnits){
		if(unit.isInWeaponRange(target) == true){
			score = score + getScoreOf(unit);
		}
		if(score >= targetscore){
			return true;
		}
	}
	
	for(Unit unit : myBunkers){
	if(unit.getLoadedUnits().size() > 0){
		if(unit.getDistance(target.getPosition()) < 400){
			score = score + getScoreOf(unit);
			}
		}
		if(score >= targetscore){
			return true;
		}
	}
	
	if(score >= targetscore){
		return true;
	}
	
	
	return false;
	
}

public boolean BunkerCanAttack(Unit bunker, Unit Target){
	
	if(bunker.getLoadedUnits().isEmpty() == true){
		return false;
	}
	
	for(Unit units : bunker.getLoadedUnits()){
		if(units.isInWeaponRange(Target) == true){
			return true;
		}
	}
	
	return false;
	
}


		
}
	
	
