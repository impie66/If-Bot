
import java.lang.reflect.Constructor;		
import java.math.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashSet;
import java.util.Random;

import java.util.Collections;
import java.util.HashMap;
import java.util.Collection;
import java.applet.Applet;
import java.applet.AudioClip;
import java.lang.*;
import bwapi.*;
import bwta.BWTA;
import bwta.BaseLocation;
import bwta.Chokepoint;
import jfap.*;

public class ClusterFuck extends DefaultBWListener {

	private int Workers = 0;
	private int AMPS = 0;
	private int MPS = 0;
	private TilePosition LastBuild;
	private int needs;
	private int GPS = 0;
	private int income = 0;
	private int MaxWorkers = 17;
	private int MaxRacks = 2;
	private int Bases = 0;
	private int MaxBases = 4;
	private int Racks = 0;
	private int Academy = 0;
	private int Gases = 0;
	private int MaxGases = 0;
	private Unit scouter;
	private boolean HasScoutUnit;
	private int scoutID = 0;
	private int Factories = 0;
	private int MaxFactories = 1;
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
	private boolean buildwait = false;
	private int Bunks = 0;
	private int LastX = 0;
	private int LastY = 0;
	private boolean HasExpanded = false;
	private int APM = 0;
	private int enemyRace = 0;
	private int supplyBuilding = 0;
	private int Tech = 0;
	private int DifBuild = 1;
	private int MilUnits = 0;
	private int bwub = 0;
	private boolean attacking = false;
	private boolean expanding = false;
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
	int mainChoke = 0;
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
	ArrayList<Unit> enemyDefences = new ArrayList<Unit>();
	ArrayList<Unit> retreatingTanks = new ArrayList<Unit>();
	ArrayList<BaseLocation> scoutedLocations = new ArrayList<BaseLocation>();
	ArrayList<BaseLocation> myBases = new ArrayList<BaseLocation>();
	HashMap<Integer, Integer> bunkersSize = new HashMap<>();
	ArrayList<UnitType> pUnits = new ArrayList<UnitType>();
	HashMap <Integer, Integer> playerScores = new HashMap<>();
	HashMap<Integer, ArrayList<Position>> playerBuildings = new HashMap<>();
	HashMap<TilePosition, Integer> baseWorkers = new HashMap<>();
	HashMap<TilePosition, Integer> maxWorkers = new HashMap<>();
	HashMap<Unit, TilePosition> tWorkers = new HashMap<>();
	HashMap<Unit, TilePosition> employees = new HashMap<>();
	HashMap<Unit, ArrayList<Unit>> jukers = new HashMap<>();
	HashMap<Unit, Integer> simedUnits = new HashMap<>();
	HashMap<Unit, UnitType> CQ = new HashMap<>();
	HashMap<Unit, Integer > unitSquads = new HashMap<>();
	HashMap<Unit, Integer> retreatingUnits = new HashMap<>();
	HashMap<BaseLocation, Integer> enemyBases = new HashMap<>();
	static ArrayList<Squad> Squads = new ArrayList<Squad>();
	static ArrayList<buildQueue> buildQueue = new ArrayList<buildQueue>();
	static HashMap<Squad, Integer> emptySquads = new HashMap<Squad, Integer>();
	private int buildingTick = 0;
	private int enemyRaceBonus = 0;
	private int LastBuildTick = 0;
	private TilePosition LastBunkerPos;
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
	private Position ralleyPoint = null;
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
	int SquadCheck = 0;
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
	int numberOfRetreats = 0;
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
	boolean tourament = false;
	int scoutTime = 0;
	int lastSimScore = 0;
	int removeUnits = 0;
	int miniFap = 40;
	int moveFap = 0;
	boolean wasAttacking = false;
	boolean scouterFleeing = false;


	void run() {
		mirror.getModule().setEventListener(this);
		mirror.startGame();
		
	}


	public void onUnitCreate(Unit unit) {
		boolean isMilitray = IsMilitrayUnit(unit);
	

		if(pBuildings.isEmpty() == false){
			if(unit.getType().isBuilding() == true && pBuildings.get(0) == unit.getType() && unit.getPlayer() == self){
				game.sendText("Priority Building Done! " + unit.getType().toString());
				boolean isTech = false;
				if(unit.getType() == UnitType.Terran_Academy || unit.getType() == UnitType.Terran_Science_Facility){
					isTech = true;
				}
				
				if(isInBQ(unit.getType()) == true && isTech == true){
					buildQueue bq = getBQWithType(unit.getType());
					if(bq != null){
						buildQueue.remove(bq);
						game.sendText("Build queue contains priority unit! removing it from BQ");
					}
				}
				pBuildings.remove(0);
				pWorkers.remove(0);
				buildTypes.remove(unit.getType());
				pPosition.remove(0);
				if(pBuildingsBuilt.contains(unit.getType()) == false){
					pBuildingsBuilt.add(unit.getType());
				}

			}
			
		}
		
		if(isMilitray == true){
			assignUnit(unit);
		}
		
		if(unit.getType() == UnitType.Terran_Medic){
			assignUnit(unit);
		}
		if(unit.getType().isBuilding() == true){
			UnitType type = unit.getType();
			if(isInBQ(type)){
				CQ.remove(type);
				buildQueue bq = getBQWithType(type);
				if(bq != null){
					buildQueue.remove(bq);
				}
			}
			else{
				//System.out.println(unit.getType() +  " is not in the BQ");
			}
		}
		
		if(buildTypes.contains(unit.getType()) == true){
			buildTypes.remove(unit.getType());
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

		if (unit.getType() == UnitType.Terran_SCV && HasScoutUnit == false && unit.getPlayer() == self && totalFrames < 6000) {
			scouter = unit;
			HasScoutUnit = true;
			scoutID = scouter.getID();
		}

		if (unit.getType() == UnitType.Terran_Command_Center && unit.getPlayer() == self) {
		
			lastExpandPos = unit.getTilePosition();
			Position pos = unit.getPosition();
			if(Bases > 1){
				LastExpandFrame = totalFrames + 1500;
				MaxRacks = MaxRacks + 2;
				MaxFactories = MaxFactories + 1;
				MaxBunks = 2;
				buildQueue.add(new buildQueue(buildQueue.size() + 1, UnitType.Terran_Refinery, null));
				buildQueue.add(new buildQueue(buildQueue.size() + 1, UnitType.Terran_Barracks, null));
				buildQueue.add(new buildQueue(buildQueue.size() + 1, UnitType.Terran_Barracks, null));
				buildQueue.add(new buildQueue(buildQueue.size() + 1, UnitType.Terran_Factory, null));
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
			BaseLocation loc = BWTA.getNearestBaseLocation(pos);
			TilePosition tile = loc.getTilePosition();
			//System.out.println("New Code for map is: " + code);
			
			if(maxWorkers.containsKey(tile) == false){
				int newa = loc.getMinerals().size() * 2 + loc.getGeysers().size() * 3;
				maxWorkers.put(tile, newa);
				//System.out.println("MaxWorkers size in total is now: " + maxWorkers.size());
			}
			
			if(baseWorkers.containsKey(tile) == false){
				baseWorkers.put(tile, 0);
				//System.out.println("baseWorkers size in total is now: " + baseWorkers.size());
			}
			
			
		}
		
		

		if (unit.getType() == UnitType.Terran_Command_Center && unit.getPlayer() == self) {
			Position pos = unit.getPosition();
			BaseLocation loc = BWTA.getNearestBaseLocation(pos);
			
			income = income + (int) (BWTA.getNearestBaseLocation(pos).getMinerals().size() * 5);
			MaxGases = MaxGases + BWTA.getNearestBaseLocation(pos).getGeysers().size();
			for (Unit minerals : BWTA.getNearestBaseLocation(pos).getMinerals()) {
				if (myMinerals.contains(minerals) == false) {
					myMinerals.add(minerals);
					//System.out.println("Adding mineral to claimed mineral's list with size of: " + myMinerals.size());
				}
			}
			

			
			if(myBases.contains(BWTA.getNearestBaseLocation(pos)) == false){
				myBases.add(BWTA.getNearestBaseLocation(pos));
			}
			
			for (Unit minerals : BWTA.getNearestBaseLocation(pos).getGeysers()) {
				if (claimedGas.contains(minerals) == false) {
					claimedGas.add(minerals);
				}
			}
			
			
		}
		
		if (unit.getType() == UnitType.Terran_Barracks && unit.getPlayer() == self) {
			RacksBuilding = RacksBuilding + 1;
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
		//System.out.println("Unit: " + unit.getType() + " " + totalFrames);
		if (unit.getType() == UnitType.Terran_Refinery && unit.getPlayer() == self) {
			Gases = Gases + 1;
			buildwait = false;
			saving = false;
			
		}
		
		if(unit.getPlayer() == self && unit.getType() == UnitType.Terran_Refinery){
			if(CQ.containsValue(unit.getType())){
				CQ.remove(unit.getType());
				//System.out.println("Unit: " + unit.getType() + " " + totalFrames);
				if(buildQueue.isEmpty() == false){
					//System.out.println("Morph value " + buildQueue.get(0).getType());
					if(buildQueue.get(0).getType() == unit.getType()){
					buildQueue.remove(0);
					//System.out.println("Removed: " +  buildQueue.get(0).getType() + " because it was finished");
					}
					
				}
			}
		}

	}

	public void onUnitComplete(Unit unit) {
		boolean isMilitray = IsMilitrayUnit(unit);
	
		if(retreatingTanks.contains(unit) == true && ralleyPoint != null){
			unit.move(ralleyPoint);
			retreatingTanks.remove(unit);
		}

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
				Position new1 = game.getRegionAt(ralleyPoint).getClosestAccessibleRegion().getCenter();
				unit.attack(new1);
				}
			}
			
			if(ralleyPoint == null){
				//Position choke = BWTA.getNearestChokepoint(self.getStartLocation()).getCenter();
				//Region regions = game.getRegionAt(choke).getClosestAccessibleRegion();
				//ralleyPoint = regions.getCenter();
				Position pos = GetBunkerChoke();
				if(pos != null){
				ralleyPoint = pos;
				Position new1 = game.getRegionAt(ralleyPoint).getClosestAccessibleRegion().getCenter();
				unit.attack(new1);
				}
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
			BaseLocation loc = BWTA.getNearestBaseLocation(unit.getPosition());
			TilePosition tile = loc.getTilePosition();
			int amount = baseWorkers.get(tile);
			TilePosition assigned = employees.get(unit);
			for (Unit myUnits : myWorkers) {
				if (local <= 2) {
					if (myUnits.getType() == UnitType.Terran_SCV && myUnits.isGatheringMinerals() == true
							&& myUnits.getID() != scoutID) {
						myUnits.gather(unit, false);
						gasWorkers.add(myUnits);
						baseWorkers.put(tile, amount + 1);
						if(assigned != tile){
							baseWorkers.put(assigned, amount - 1);
						}
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
			Bunks = Bunks + 1;
			ralleyPoint = unit.getPosition();
			for(Squad squad : Squads){
				squad.setRetreatPos(unit.getPosition());
			}
			
		}
		
		if (unit.getType() == UnitType.Terran_Command_Center && unit.getPlayer() == self) {
			expanding = false;
			AlreadyExpanding = false;
			ExpandPlacing = false;
			buildwait = false;
			saving = false;
			BaseLocation loc = BWTA.getNearestBaseLocation(unit.getPosition());
			TilePosition tile = loc.getTilePosition();
			int local = 0;
			if(Bases > 1){
				for (Unit myUnits : myWorkers) {
					if (local <= 6) {
						if (myUnits.getType() == UnitType.Terran_SCV && myUnits.isGatheringMinerals() == true && employees.containsKey(myUnits)) {
							myUnits.move(unit.getPosition());
							int amount = baseWorkers.get(tile);
							int neww = baseWorkers.put(tile, amount + 1);
							local = local + 1;
							if(BWTA.getNearestBaseLocation(employees.get(myUnits)) != loc){
								TilePosition employed = employees.get(myUnits);
								baseWorkers.put(employed, baseWorkers.get(employed) - 1);
								employees.put(myUnits, tile);
							}
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
			Position pos = unit.getPosition();
			if(myBases.contains(BWTA.getNearestBaseLocation(pos)) == false){
				myBases.add(BWTA.getNearestBaseLocation(pos));
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
			MaxRacks = MaxRacks + 2;
			int bonus = (estimatedEnemyScore / 100) + (InvadersScore / 25) + 1;
			MarinesNeedBonus = MarinesNeedBonus + bonus;
		}	

		if (unit.getType() == UnitType.Terran_Factory && unit.getPlayer() == self) {
			Factories = Factories + 1;
			FactoriesBuilding = FactoriesBuilding - 1;
			int bonus = (estimatedEnemyScore / 100) + (InvadersScore / 25) + 1;
			MarinesNeedBonus = bonus;
		}
		
		if (unit.getType() == UnitType.Protoss_Gateway && unit.getPlayer() == self) {
			Factories = Factories + 1;
			FactoriesBuilding = FactoriesBuilding - 1;
			MarinesNeedBonus = MarinesNeedBonus + 6;
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
		
		if(unitSquads.containsKey(unit) == true){
			Squad squad = getSquad(unitSquads.get(unit));
			if(squad != null){
				squad.removeUnit(unit);
			}
			unitSquads.remove(unit);
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
		if(enemyDefences.contains(unit) == true){
			enemyDefences.remove(unit);
		}
		
	    ArrayList<BaseLocation> bass = buildBasesFromMap();
	    if(bass.isEmpty() == false){
	    	for(BaseLocation asf : bass){
	    		int dist = unit.getPosition().getApproxDistance(asf.getPoint());
	    		int value = enemyBases.get(asf);
	    		if(dist > 400){
	    			enemyBases.put(asf, value - getScoreOf(unit));
	    			break;
	    		}
	    	}
	    }
		

		}
		
		if(unit.getType().isResourceDepot() == true && enemyBases.containsKey(BWTA.getNearestBaseLocation(unit.getPosition())) == true){
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
			if(newbuilder != null){
				if (newbuilder.exists() == true && building.exists() == true) {
					newbuilder.rightClick(building);
				}
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
			TilePosition tile = BWTA.getNearestBaseLocation(unit.getPosition()).getTilePosition();
			if(maxWorkers.containsKey(tile) == true){
				maxWorkers.put(tile, maxWorkers.get(tile) - 2);
			}
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

		if (unit.getType().isResourceDepot() && unit.getPlayer().equals(self)) {
			Position pos = unit.getPosition();
			BaseLocation loc = BWTA.getNearestBaseLocation(pos);;
			TilePosition tile = loc.getTilePosition();
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
			
			if(maxWorkers.containsKey(tile) == true) {
				maxWorkers.remove(tile);
			}
			
			if(baseWorkers.containsKey(tile) == true) {
				maxWorkers.remove(tile);
			}
			
			if(myBases.contains(BWTA.getNearestBaseLocation(pos)) == true){
				myBases.remove(BWTA.getNearestBaseLocation(pos));
			}
			if(myWorkers.isEmpty() == false){
				for(Unit units : myWorkers){
					if(employees.containsKey(units) == true){
						if(employees.containsValue(tile) == true){
							employees.remove(units);
						}
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
			
			if(employees.containsKey(unit) == true){
			TilePosition tile = employees.get(unit);
			
			if(baseWorkers.containsKey(tile) == true){
				baseWorkers.put(tile, baseWorkers.get(tile) - 1);
			}
			
			if(employees.containsKey(unit) == true){
				employees.remove(unit);
			}
			
			
			}
			
			
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
			String str = CheckOpener(unit.getPlayer());
			if(unit.getPlayer() != self && unit.getType() == UnitType.Terran_Bunker || unit.getType() == UnitType.Protoss_Photon_Cannon || unit.getType() == UnitType.Zerg_Sunken_Colony){
			enemyDefenceScore = enemyDefenceScore + p;;
				if(enemyDefences.contains(unit) == false){
					enemyDefences.add(unit);
				}
				
			    ArrayList<BaseLocation> bass = buildBasesFromMap();
			    if(bass.isEmpty() == false){
			    	for(BaseLocation asf : bass){
			    		int dist = unit.getPosition().getApproxDistance(asf.getPoint());
			    		int value = enemyBases.get(asf);
			    		if(dist > 400){
			    			enemyBases.put(asf, value + getScoreOf(unit));
			    			break;
			    		}
			    	}
			    }
				
				if(unit.getType().isResourceDepot() == true && claimedBaseLocations.contains(BWTA.getNearestBaseLocation(unit.getPosition())) == false){
					claimedBaseLocations.add(BWTA.getNearestBaseLocation(unit.getPosition()));
				}
			}
		}
		
		
		int p = getGhostScore(unit);
		
		if(unit.getPlayer() != self && p != 0 && scoredBuildings.contains(unit) == false){
			enemyGhostPoints = enemyGhostPoints + p;
			scoredBuildings.add(unit);
		}
		
		
		
		if(unit.getType().isResourceDepot() == true && enemyBases.containsKey(BWTA.getNearestChokepoint(unit.getPosition())) == false && game.enemies().contains(unit.getPlayer())){
			Position pos = unit.getPosition();
			BaseLocation base = BWTA.getNearestBaseLocation(unit.getTilePosition());
			Chokepoint choke = BWTA.getNearestChokepoint(pos);
			enemyBases.put(base, 0);
			Region cRegion = game.getRegionAt(choke.getCenter());
			if(enemyChokes.contains(cRegion) == false){
				enemyChokes.add(cRegion);
			}
			for(Region region : cRegion.getNeighbors()){
				if(region.isAccessible() == true && enemyChokes.contains(region) == false){
					enemyChokes.add(region);
				}
			}
			
			if(enemyBases.size() > 2){
				int score = enemyBases.get(base);
				BuildSquadToCounter(score+500, unit.getPosition());
				game.sendText("All your base are belongs to us");
			}

		}
		
		
		if(unit.getPlayer() == game.enemy() && ismil == true && enemyRushUnits.contains(unit) == false && totalFrames < 9500){
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
		
		
		if(unit.getType().isFlyer() == true && unit.getPlayer() == game.enemy() && unit.getType().isBuilding() == false && unit.canAttack() == true && unit.getType() != UnitType.Protoss_Interceptor && unit.getType().groundWeapon().damageAmount() > 0){
			AirThreat = AirThreat + 1;
		}


		if (unit.getType() == UnitType.Protoss_Gateway && unit.getPlayer().isEnemy(self)) {
			enemyRace = 2;
		}


		if (unit.getType() == UnitType.Terran_Command_Center && unit.getPlayer().isEnemy(self)) {
			enemyRace = 1;
		}
		if (unit.getType() == UnitType.Protoss_Nexus && unit.getPlayer().isEnemy(self)) {
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
		CustomGreetings(game.enemy().toString());
		if(game.getPlayers().size() > 3){
			TeamGameMode = true;
		}
		
		int numP = game.enemies().size();
	
		if(TeamGameMode == true){
			for(Player players : game.enemies()){
				playerScores.put(players.getID(), 0);
				playerBuildings.put(players.getID(), new ArrayList<Position>());
				//System.out.println(players.getName() + " Id is: " + players.getID());
			}
			DoneCreatingList = true;
			//System.out.println("List building done");
			
		}
		
		if(TeamGameMode == true){
			if(playerScores.isEmpty() == true){
				//System.out.println("Player scores is empty");
			}
			
			if(playerBuildings.isEmpty() == true){
				//System.out.println("Player buildings is empty");
			}
		}
		
		if(TeamGameMode == false){
		Strategy = GetStrategy(game.enemy().getRace().toString());
		}
		// getExpands();
		BaseLocation = BWTA.getNearestBaseLocation(BasePos);
		
		//for(BaseLocation bases : BWTA.getBaseLocations()){
			//if(bases.isStartLocation() == true){
			//System.out.println(bases.getPosition());
			//}
		//}
		//System.out.println(game.mapName());
		//System.out.println(game.mapHash());
		Position temp = GetBunkerChoke();
		if(temp != null){
			ralleyPoint = GetBunkerChoke();
		}
		getOpener();
	
	}
	
	private void getOpener() {
		if(ralleyPoint == null){
			ralleyPoint = GetBunkerChoke();
		}
		buildQueue.add(new buildQueue(0, UnitType.Terran_Supply_Depot, null));
		buildQueue.add(new buildQueue(buildQueue.size() + 1, UnitType.Terran_Barracks, null));
		buildQueue.add(new buildQueue(buildQueue.size() + 1, UnitType.Terran_Barracks, null));
		buildQueue.add(new buildQueue(buildQueue.size() + 1, UnitType.Terran_Bunker, ralleyPoint.toTilePosition()));
		buildQueue.add(new buildQueue(buildQueue.size() + 1, UnitType.Terran_Bunker, ralleyPoint.toTilePosition()));
		buildQueue.add(new buildQueue(buildQueue.size() + 1, UnitType.Terran_Refinery, null));
		buildQueue.add(new buildQueue(buildQueue.size() + 1, UnitType.Terran_Barracks, null));
		buildQueue.add(new buildQueue(buildQueue.size() + 1, UnitType.Terran_Academy, null));
		buildQueue.add(new buildQueue(buildQueue.size() + 1, UnitType.Terran_Engineering_Bay, null));
		buildQueue.add(new buildQueue(buildQueue.size() + 1, UnitType.Terran_Missile_Turret, ralleyPoint.toTilePosition()));
		buildQueue.add(new buildQueue(buildQueue.size() + 1, UnitType.Terran_Barracks, null));
		buildQueue.add(new buildQueue(buildQueue.size() + 1, UnitType.Terran_Barracks, null));
		buildQueue.add(new buildQueue(buildQueue.size() + 1, UnitType.Terran_Factory, null));
		buildQueue.add(new buildQueue(buildQueue.size() + 1, UnitType.Terran_Starport, null));
		game.sendText(buildQueue.size() + " Buildings to open with");
	}


	public void onUnitShow(Unit unit){
		
		if(estimatedEnemyScore > fapMyScores){
			UpdateStrats();
		}
		
		if(unit.getPlayer().isEnemy(self) && IsMilitrayUnit(unit) == true){	
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
				if(HowManyDoIHave(UnitType.Terran_Bunker) == 0 && pBuildings.contains(UnitType.Terran_Bunker) == false){
					pBuildings.add(UnitType.Terran_Bunker);
					game.sendText("Enemy Attack incoming, building bunker!");
					if(ralleyPoint != null){
					pPosition.add(ralleyPoint.toTilePosition());
					}
					else {	
						Position pos = GetBunkerChoke();
						if(pos != null){
							pPosition.add(pos.toTilePosition());
						}
					}
				}
				
			}
			
			if(totalFrames < 9000){
				if(fapMyScores < InvadersScore){
					UnitType type = GetRecommendedCounter(unit.getType());
						int amount = Math.round(getScoreOf(unit) / 55);
						if(pUnits.size() < amount * 2){
							for (int i = 0; i < amount; i++){
								if(type != null){
									pUnits.add(UnitType.Terran_Firebat);
								}
								else {
									pUnits.add(UnitType.Terran_Marine);
								}
							}
						}
						//System.out.println("Enemy Attack Detected, pUniting: " + amount + " Units");
					}
			}
		}
		
		if(unit.getType() == UnitType.Protoss_Dark_Templar && HowManyDoIHave(UnitType.Terran_Missile_Turret) == 0 && pBuildings.contains(UnitType.Terran_Missile_Turret) == false){
			pBuildings.add(UnitType.Terran_Missile_Turret);
			pPosition.add(ralleyPoint.toTilePosition());
			pBuildings.add(UnitType.Terran_Missile_Turret);
			pPosition.add(self.getStartLocation());
		}
		
		if(unit.getType() == UnitType.Zerg_Lurker && HowManyDoIHave(UnitType.Terran_Missile_Turret) == 0 && pBuildings.contains(UnitType.Terran_Missile_Turret) == false){
			pBuildings.add(UnitType.Terran_Missile_Turret);
			pPosition.add(ralleyPoint.toTilePosition());
			pBuildings.add(UnitType.Terran_Missile_Turret);
			pPosition.add(self.getStartLocation());
		}
		
		//end of onUnitShow
		
	}
	

	@Override
	public void onFrame() {
		AMPS = (int) (Workers * 2);
		MPS = (int) (AMPS * 0.14);
		GPS = Gases * 3;
		MaxGol = 3 + (enemyFlyers.size() * 2);
		MaxWorkers = 2 + (myMinerals.size() * 1) + (MaxGases * 3);
		VulturesMax = (Tanks * 2) + 6;
		MarinesNeed = 10 + (Bunks * 4) + (Tanks * 5) + MarinesNeedBonus + (InvadersScore / 25) + (enemyRushScore / 50) + enemyGhostPoints / 50;
		MedicsNeed = Math.round(Marines / 4) + 2;
		BatsNeed = Math.round(game.enemy().allUnitCount(UnitType.Protoss_Zealot) / 2) + Math.round(game.enemy().allUnitCount(UnitType.Zerg_Zergling) / 6) + 3;
		Tick = Tick + 1;
		buildingTick = buildingTick + 1;
		AddNeeds = AddNeeds + 1;
		needs = (Factories * 20) + (Racks * 20);
		APM = game.getAPM();
		game.enableFlag(1);
		// game.setTextSize(10);`
		//game.drawTextScreen(10, 10, "Playing as " + self.getName() + " - " + self.getRace() + " And with.. " + APM
		//		+ " APM" + " With.." + game.getAverageFPS() + "FPS" + " Total Frames: " + totalFrames);
		//game.drawTextScreen(10, 20, "I have " + Bases + " Bases and i have " + Factories + " Factories"
			//	+ " and i have: " + Racks + " Barracks" + " And i have.. " + " " + myUnits.size() + "Militray units.");
		//game.drawTextScreen(10, 30, enemyFlyers.size() + " Early game threat: " + enemyRushScore);
		//game.drawTextScreen(10, 40, "EnemyUnits: " + enemyUnits.size() + " My Fap Score: " + fapMyScores + " Enemy Production Score: " + enemyGhostPoints + " Estimated Enemy Score: " + estimatedEnemyScore + " Enemy Defence Score: " + enemyDefenceScore);
		//game.drawTextScreen(10, 50, "income: " + income + " " + " needs: " + needs   + " Am i currently saving for an expansion: " + needsToExpand + " Am i currently expanding: " + expanding);
		//game.drawTextScreen(10, 30, "Versing " + game.enemy().getName() + " as "  + game.enemy().getRace() + " ");
		game.drawTextScreen(10, 10, "Strategy: " + Strats + " " + " Frames: " + updateStrategy);
		//game.drawTextScreen(10, 80, "Invaders: " + sScore);
		//game.drawTextScreen(10, 90, "Early Marine Amount: " + MarinesNeed);
		//game.drawTextScreen(10, 70, Squads.size() + " Squads");
		
//		if (game.getFrameCount() % game.getLatencyFrames() != 0) {
			
		
//		if(game.mapName() == "(2)ThirdWorld1.0" || game.mapName() == "(4)Sparkle1.1" ){
//			ExpandEnabled = false;
//			sdsddhgfio = true;
//		}
//		
		
		StringBuilder sPlayerScores = new StringBuilder("Enemy Player Scores:\n");
		StringBuilder sPlayerSize = new StringBuilder("Enemy Player Building Size:\n");
		StringBuilder cqs = new StringBuilder("Construction Queue:\n");
		StringBuilder squads = new StringBuilder("Squads:\n");
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
		
		if(Squads.isEmpty() == false){
			for(Squad sq : Squads){
				int index = sq.getId();
				int score = sq.getScore();
				int tScore= sq.getTargetScore();
				int size = sq.getUnits().size();
				if(sq.getUnits().isEmpty() == false){
				System.out.println("Append");
				squads.append("Squad: ").append(index).append(" ").append("Score: ").append(score).append(" ").append("TScore: ").append(tScore).append(" ").append("Size: ").append(size).append("\n");
				}
			}
			
			game.drawTextScreen(10, 30, squads.toString());
			
		}
		
		if(buildQueue.isEmpty() == false){
			if(buildQueue.size() <= 4){
				for(buildQueue bq : buildQueue){
					cqs.append("Item: ").append(bq.getType()).append("\n");
				}
			}
			else{
				for(int i=0;i<=3;i++){
					cqs.append("Item: ").append(buildQueue.get(i).getType()).append("\n");
				}
				cqs.append("+ " + buildQueue.size() + " more items:");
			}
			
			game.drawTextScreen(300, 30, cqs.toString());
			
		}
			

			totalFrames = totalFrames + 1;
			updateStrategy = updateStrategy + 1;
			canExpandCheck = canExpandCheck + 1;
			checkInvaders++;
			
			
			if (supplyBuilding < 0) {
				supplyBuilding = 0;
			}
			
			if(totalFrames > 3500){
				if(self.supplyUsed() != 200 && (self.supplyTotal() - self.supplyUsed()) < 5 && pBuildings.contains(UnitType.Terran_Supply_Depot) == false && self.incompleteUnitCount(UnitType.Terran_Supply_Depot) == 0){
						//buildQueue.add(new buildQueue(buildQueue.size() + 1, UnitType.Terran_Supply_Depot, null));
						//buildQueue.add(new buildQueue(buildQueue.size() + 1, UnitType.Terran_Supply_Depot, null));
						pBuildings.add(UnitType.Terran_Supply_Depot);
						pPosition.add(null);
				}
			}
			
			if (lureCheck != 0){
				lureCheck++;
			}
			
			if(scoutTime != 0){
				scoutTime++;
			}
			
			if(SquadCheck <= 199){
				SquadCheck++;
			}
			
			if(SquadCheck >= 200){
				SquadCheck = 0;
				CheckSquadGoals();
			}
			
			if(scoutTime >= 15){
				scoutTime = 0;
			}

			if(checkInvaders > 20){
				CheckInvaders();
				checkInvaders = 0;
			}
			
			if(lureCheck > 30){
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
			
			if(customTargets == 5){
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
				if(MaxBunks > 2){
					MaxBunks = 2;
				}
				
			}
			
			if(expanding == true){
				expandFrames = expandFrames + 1;
			}
			
			if(scienceFinished == true && scienceStarted == false){
				scienceStarted = true;
			}
			
			if (buildingTick > 100) {
				buildingTick = 0;
			}
			
			if(saving == true && LastBuildTick == 0){
				saving = false;
			}
			
			if(self.supplyUsed() > 7 && ScoutSent == false){
				ScoutSent = true;
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

			if (income < needs && ExpandEnabled == true && LastExpandFrame < totalFrames && Bases != 5 && needsToExpand == false){
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
				simCallFrames++;
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
			
			if(moveFap > 0){
				moveFap++;
			}
			
			if(moveFap > 15){
				moveFap=0;
			}
			
			if(totalFrames > 8000 && enemyRushScore != 0){
				enemyRushScore = 0;
			}
			
			if(needsToExpand == true && saving == false && CanExpand() == true){
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
			
//			if(attacking == false && myUnits.isEmpty() == false && lureCheck == 0){
//				lureCheck = 1;
//					for(Unit unit : myUnits){
//						if(unit.getOrder() == Order.AttackUnit || unit.getOrder() == Order.AttackMove || unit.isAttacking() == true){
//							Unit bunker = GetNearestBunker(unit.getPosition());
//							if(bunker != null){
//								if(unit.getDistance(bunker.getPosition()) > 600 && myRegions.contains(unit.getRegion()) == true){
//									Unit target = unit.getOrderTarget();
//									if(target == null){
//										for(Unit unit1 : game.getUnitsInRadius(unit.getOrderTargetPosition(), 70)){
//											if(unit1.getPlayer().isEnemy(self) == true){
//												target = unit1;
//												break;
//											}
//										}
//									}
//										if(target != null){
//											ArrayList<Unit> ass1 = GetMyUnitsNearby(unit.getPosition(), 250, true);
//											ArrayList<Unit> ass2 = GetEnemyUnitsNearby(target.getPosition(), 250, true);
//											boolean canWin = jFaplocal(ass1, ass2, 1);
//											if(canWin == false){
//											int bonus = 0;
//											if(self.getUpgradeLevel(UpgradeType.U_238_Shells) > 0){
//												bonus = 24;
//											}
//										if(GetAverageRange(target.getPosition()) <= UnitType.Terran_Marine.groundWeapon().maxRange() + bonus) {
//												if(BunkerCanAttackAnything(bunker) == false){
//													Position runTo = GetRegionBehindBunker(bunker, target).getCenter();
//													if(runTo != null){
//														unit.move(runTo);
//														game.drawCircleMap(runTo, 30, bwapi.Color.Red);
//													}
//												}
//											}
//											break;
//										}
//										break;
//										}
//									}
//							}
//						}
//					}
//				}
			
		
			for(BaseLocation bases : BWTA.getBaseLocations()){
				
				if(game.isVisible(bases.getTilePosition()) == true 
				&& game.canBuildHere(bases.getTilePosition(), UnitType.Terran_Command_Center) == true
				&& claimedBaseLocations.contains(bases) == true && bases.getTilePosition() != self.getStartLocation() && expanding == false){
					claimedBaseLocations.remove(bases);
					game.sendText("OIL DETECTED AT " + bases.getTilePosition() + " Deploying US forces");
		
				}
				if(scoutedLocations.isEmpty() == false){
					if(game.isVisible(bases.getTilePosition())== true && scoutedLocations.contains(bases) == true){
						scoutedLocations.remove(bases);
					}
				}
				
				
				TilePosition tile = bases.getTilePosition();
				if(baseWorkers.containsKey(tile) == true && maxWorkers.containsKey(tile) == true){
					int max = 0;
					int workers = baseWorkers.get(tile);
					max = maxWorkers.get(tile);
					game.drawTextMap(bases.getPoint(), "Workers: " + workers + " Max Workers: " + max);
				}
				
				
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

			if (HowManyDoIHave(UnitType.Terran_Academy) == 0) {
				DifBuild = 1;
			}

			if (buildwait == true && bwub < 1) {
				bwub = Tick + 90;

			}

			if (Tick > bwub) {
				bwub = 0;
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
			
		
			if(HowManyOrderedToBuild(UnitType.Terran_Supply_Depot) == 0 && supplyBuilding > 0){
				supplyBuilding = 0;
			}
			
			if (self.minerals() >= 400 && ExpandEnabled == true && needsToExpand == true && expanding == false && Bases <= MaxBases && totalFrames > LastExpandFrame && CanExpand() == true) {
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
			if(buildQueue.isEmpty() == false && saving == false && buildingTick == 99){
				buildingTick = 31;
				buildQueue next = buildQueue.get(0);
				UnitType type = next.getType();
				TilePosition where = next.getPos();
				boolean isd = false;
				if(type == UnitType.Terran_Refinery && self.allUnitCount(UnitType.Terran_Refinery) >= claimedGas.size()){
					buildQueue.remove(0);
				}
				if(type == UnitType.Terran_Missile_Turret || type == UnitType.Terran_Bunker){
					isd = true;
				}
				//boolean asd = next.checkIfBuilt();
				if(queuedOrBetter(type) == false){
					//System.out.println("Size: " + buildQueue.size());
					//System.out.println("Queued: " + queuedOrBetter(type));
					if(game.canMake(type) == true){
						//System.out.println("Type: " + type.toString());
						if(where != null){
							//System.out.println("Where: " + where);
						}
						Unit myUnit = GetWorker();
						if(myUnit != null){
							if(where == null){
								where = myUnit.getTilePosition();
								//System.out.println("Pos not set, pos is now: " + where);
							}
							if(isd == false){
							TilePosition buildTile = getBuildTile(myUnit, type, where);
								if (buildTile != null) {
									saving = true;
									myUnit.build(type, buildTile);
									if(CQ.containsKey(myUnit) == false){
									CQ.put(myUnit, type);
									}
								}	
						}
						else {
								TilePosition buildTile = game.getBuildLocation(type, where);
								if (buildTile != null) {
									saving = true;
									myUnit.build(type, buildTile);
									if(CQ.containsKey(myUnit) == false){
									CQ.put(myUnit, type);
									}
								}		
							}
						}
					}
				}
			}
			else {
				
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
						//System.out.println(type.toString());
						TilePosition pos = pPosition.get(0);
						//System.out.println("Pos: " + pos);
						if(myUnit != null){
							if(pos == null){
								pos = myUnit.getTilePosition();
								//System.out.println("Pos not set, pos is now: " + pos);
							}
							TilePosition buildTile = getBuildTile(myUnit, type, pos);
							if (buildTile != null) {
								saving = true;
								myUnit.build(type, buildTile);
								buildTypes.add(type);
								if(pWorkers.contains(myUnit) == false){
									Pair pair = new Pair<Unit, UnitType>(myUnit, type);
									pWorkers.add(pair);
									//System.out.println("Adding to pWorkers");
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
			
			if(DifBuild == 5 && HowManyDoIHave(UnitType.Terran_Marine) + HowManyDoIHave(UnitType.Terran_Medic) < 15){
				DifBuild++;
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
			
				if(simedUnits.containsKey(myUnit) == true){
					int value = simedUnits.get(myUnit);
					simedUnits.put(myUnit, value - 1);
					if(value < 0){
						simedUnits.remove(myUnit);
					}
				}
				
				if(CQ.containsKey(myUnit) == true && myUnit.isConstructing() == true){
					game.drawTextMap(myUnit.getOrderTargetPosition(), CQ.get(myUnit).toString());
				}
				
				
				
				if(retreatingUnits.containsKey(myUnit) == true){
					int value = retreatingUnits.get(myUnit);
					if(value > 0){
						retreatingUnits.put(myUnit, value - 1);
					}
					if(value < 0){
						retreatingUnits.remove(myUnit);
					}
				}

				// jukers
//				if(jukers.containsKey(myUnit) == true){
//					if(jukers.get(myUnit).isEmpty() == false){
//						ArrayList<Unit> list = jukers.get(myUnit);
//						for(Unit units : list){
//							if(units.isVisible() == true && units.getTarget() == myUnit){
//								Position regroup = GetKitePos(myUnit, units);
//								if(regroup != null){
//									if(regroup.isValid() == true){
//										myUnit.move(regroup);
//									}
//	
//								}
//							}
//							
//							if(units.isVisible() == false || units.exists() == false){
//								jukers.remove(units);
//							}
//						}
//					}
//				}
				
				if(myUnit.isMoving() == true && myUnit.isUnderAttack() == true && attacking == false && moveFap == 0 && IsMilitrayUnit(myUnit) == true){
					ArrayList<Unit> mine = GetMyUnitsNearby(myUnit.getPosition(), 220, false);
					ArrayList<Unit> notmine = GetEnemyUnitsNearby(myUnit.getPosition(), 300, false);	
					boolean canWin = ScoreFap(mine, notmine, 2);
					Unit attacker = null;
					attacker = GetAttacker(myUnit, 300);
					if(attacker == null){
						attacker = notmine.get(0);
					}
					if(canWin == true){
						for(Unit units : mine){
							boolean isStacking = orderStacking(units, attacker.getPosition());
							if(units.exists() == true && units.isAttacking() == false && isStacking == false){
								units.attack(attacker.getPosition());
							}
						}
					}
						
				}
					
			
				
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
				
				if(employees.containsKey(myUnit) == true){
					game.drawLineMap(myUnit.getPosition(), employees.get(myUnit).toPosition(), Color.Black);
				}
				
				if(employees.isEmpty() == false && baseWorkers.isEmpty() == false && maxWorkers.isEmpty() == false){
					if(myUnit.isGatheringGas() || myUnit.isGatheringMinerals()){	
					Position target = myUnit.getPosition();
					//getOrderTargetPosition();
					BaseLocation loc = BWTA.getNearestBaseLocation(target);
					BaseLocation value = null;
					if(employees.containsKey(myUnit)){
						 value = BWTA.getNearestBaseLocation(employees.get(myUnit));
					}
					
					if(value != null){
						if(employees.containsKey(myUnit) && loc != value){
							//game.sendText("Hey, You don't work here!");
							game.pingMinimap(myUnit.getPosition());
							myUnit.move(employees.get(myUnit).toPosition());
						}
						
						if(baseWorkers.containsKey(loc.getTilePosition()) && maxWorkers.containsKey(loc.getTilePosition()) && employees.containsKey(myUnit)){
							if(baseWorkers.get(loc.getTilePosition()) > maxWorkers.get(loc.getTilePosition())){
								game.sendText("BaseWorkers is full, mining at a new base");
								employees.remove(myUnit);
								baseWorkers.put(loc.getTilePosition(), baseWorkers.get(loc.getTilePosition()) - 1);
							}
						}
					}
				}
				}
				
				if(myUnit.isUnderStorm() && myUnit.getPosition().getApproxDistance(ralleyPoint) > 700){
					if(ralleyPoint != null && myUnit.isMoving() == false){
						myUnit.move(ralleyPoint);
						for(Unit units : GetMyUnitsNearby(myUnit.getPosition(), 100, false)){
							if(units.isMoving() == false && units.getPosition().getApproxDistance(ralleyPoint) > 700){
								units.move(ralleyPoint);
							}
						}
					}
				}
				
	
				
				
				boolean isMil = IsMilitrayUnit(myUnit);
				
				if(CQ.containsKey(myUnit) && myUnit.isConstructing() == false){
				if(CQ.size() > 1){
					saving = false;
				}
				System.out.println("CQ: " + CQ.get(myUnit).toString());
				CQ.remove(myUnit);
					
				}

				if(constructingWorkers.contains(myUnit) == true && myUnit.isConstructing() == false && myUnit.hasPath(myUnit.getOrderTargetPosition()) == false){
				int index = constructingWorkers.indexOf(myUnit);
				constructingWorkers.remove(index);
				saving = false;
				buildwait = false;
				game.sendText("SCV can't path to construction area");
				}
				
						
				if(myUnit.isUnderAttack() == true && defenderCall == true && myUnit.isUnderStorm() == false && myUnit.equals(scouter) == false){
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
								DifBuild++;
							}
		
							if (myUnit.getType() == UnitType.Terran_Barracks && self.minerals() >= 50 && myUnit.isIdle() == true
									&& Marines < MarinesNeed && DifBuild == 2 && HowManyDoIHave(UnitType.Terran_Academy) > 0) {
								myUnit.train(UnitType.Terran_Marine);
								DifBuild++;
							}
		
							if (myUnit.getType() == UnitType.Terran_Barracks && self.minerals() >= 50 && self.gas() >= 25
									&& myUnit.isIdle() == true && Medics < MedicsNeed && game.canMake(UnitType.Terran_Medic)
									&& DifBuild == 3) {
								myUnit.train(UnitType.Terran_Medic);
								DifBuild++;
							}
		
							if (myUnit.getType() == UnitType.Terran_Barracks && self.minerals() >= 100 && self.gas() >= 25
									&& myUnit.isIdle() == true && Bats < BatsNeed && game.canMake(UnitType.Terran_Firebat) && DifBuild == 4) {
								myUnit.train(UnitType.Terran_Firebat);
								DifBuild++;
							}

								if (myUnit.getType() == UnitType.Terran_Factory && self.minerals() >= 150 && self.gas() >= 100
										&& myUnit.isIdle() == true && DifBuild == 5) {
									myUnit.train(UnitType.Terran_Siege_Tank_Tank_Mode);
									DifBuild++;
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
								if(game.canMake(type, buildings) == true && buildings.isIdle() == true){
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
									//game.sendText("HEY, YOU GET TO EAT ONCE YOU FINSIH BUILDING " + type);
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
					
					
					if (myUnit.getType() == UnitType.Terran_Academy && myUnit.isIdle() == true && saving == false && myUnit.canUpgrade(UpgradeType.U_238_Shells) == true){
						myUnit.upgrade(UpgradeType.U_238_Shells);
					}
					
					
					if (myUnit.getType() == UnitType.Terran_Academy && myUnit.isIdle() == true && saving == false && Racks > 1 && myUnit.canResearch(TechType.Stim_Packs) == true && IsUpgradingorBetter(UpgradeType.U_238_Shells) == true){
						myUnit.research(TechType.Stim_Packs);
			
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
				
		
				if (myUnit.getType() == UnitType.Terran_Bunker && myUnit.isCompleted() == true && myUnit.getLoadedUnits().size() != 4) {
					int myID = myUnit.getID();
					if(bunkersSize.get(myID) != null){
						int amount = bunkersSize.get(myID);
						if(amount != 4){
							for(Unit units : myUnits){
								if(units.getType() == UnitType.Terran_Marine && units.isCompleted() == true && units.isIdle() && units.isLoaded() == false){
										units.rightClick(myUnit);
										int neww = amount + 1;
										bunkersSize.put(myID, neww);
										myUnits.remove(units);
										Squad squad = getSquad(units);
										if(squad != null){
											squad.removeUnit(units);
										}
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



				if (myUnit.isIdle() && IsMilitrayUnit(myUnit) == true && myUnit.isLoaded() == false) {
					getSquadOrders(myUnit);
					
					
					
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
				
				if (myUnit.isIdle() && myUnit.getType() == UnitType.Terran_Medic) {
					getSquadOrders(myUnit);
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
				
				

				if (isInCombat(myUnit) == true && myUnit.getType().isBuilding() == false && simCallFrames == 0 && myUnit.getType().isWorker() == false && !simedUnits.containsKey(myUnit)) {
					int bonus = 1;	
					simCallFrames = 1;
					Unit attacker = null;
					boolean canRetreat = true;
					int attackerx = 0;	
					int attackery = 0;
			
					if(enemyChokes.contains(myUnit.getRegion()) == true){
						//if our unit is in an enemy chokepoint
						bonus = 3;
					}
					
					if(myUnit.getPosition().getApproxDistance(self.getStartLocation().toPosition()) < 2000){
						canRetreat = false;
					}
					
					// We will make a new list of units nearby, sort them,  and then to give to the function.
					
					ArrayList<Unit> mine = new ArrayList<Unit>();
					ArrayList<Unit> hostile = new ArrayList<Unit>();
					
					for(Unit units : game.getUnitsInRadius(myUnit.getPosition(), 220)){
						boolean bool = IsMilitrayUnit(units);
						boolean bool1 = IsMilitrayBuilding(units);
						
						if(units.getPlayer() == self && bool == true && mine.contains(units) == false && bool == true){
							mine.add(units);
						}
						
						if(units.getPlayer() == self && bool1 == true && mine.contains(units) == false && bool1 == true){
							mine.add(units);
						}
					
						if(units.getPlayer().isEnemy(self) && bool == true && hostile.contains(units) == false){
							hostile.add(units);
							if(attacker == null){
								attacker = units;
								attackerx = attacker.getX();
								attackery = attacker.getY();
							}
						}
						
						if(units.getPlayer().isEnemy(self) && bool1 == true && hostile.contains(units) == false){
							hostile.add(units);
						}
						
						
					}
				
					boolean canWin = jFaplocal(mine, hostile, bonus);	
					
					if(canWin == true){
						for(Unit unit : mine){
							if(retreatingUnits.containsKey(unit) == true){
								retreatingUnits.remove(unit);
								if(unit.isAttacking() == false){
									unit.stop();
								}
							}
						}
					}
					
					if(canWin == false && canRetreat == true){
						//System.out.println("Can't win");
						Position regroup = null;
						if(attacker == null){
							regroup = ralleyPoint;
						}
						if(attacker.isVisible() == false){
						//System.out.println("Is not visible");
						regroup = GetJukePosManual(myUnit, attackerx, attackery);
						} else {
						regroup = GetKitePos(myUnit, attacker);
						//System.out.println("Is visible");
						}
						
						if(regroup != null){
								for(Unit unitss : mine){
									if(unitss != null){
										if(unitss.isMoving() == false){
											unitss.move(regroup);
											if(!simedUnits.containsKey(unitss)){
												simedUnits.put(unitss, 70);
											}
											if(!retreatingUnits.containsKey(unitss)){
												retreatingUnits.put(unitss, 160);
											}
										}
									}
									if(unitss != null){
										if(unitss.getType() == UnitType.Terran_Siege_Tank_Siege_Mode){
											retreatingTanks.add(unitss);
											unitss.unsiege();
										}
									}
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
						&& myUnit.isBeingHealed() == false && myUnit.isBeingConstructed() == false && IsMilitrayBuilding(myUnit) == true && repairingBuildings.contains(myUnit.getID()) == false) {
					// don't repair buildings that are under attack unless they are an MilitrayBuilding
					
					if(repairingBuildings.isEmpty() || repairingBuildings.contains(myUnit.getID()) == false){
						repairingBuildings.add(myUnit.getID());
					}
					
					//System.out.println("Trigger repair");
					Unit unit = myUnit;
					ArrayList<Unit> repairers = GetWorkerAmount(3);
					if(repairers != null){
						for(Unit repairs : repairers){
							repairs.repair(unit);
						}
					}
					else {
						//System.out.println("Get workers is null");
					}

				}
				
				if (myUnit.getType().isBuilding() == true && myUnit.getHitPoints() < myUnit.getType().maxHitPoints()
						&& myUnit.isBeingHealed() == false && myUnit.isBeingConstructed() == false && IsMilitrayBuilding(myUnit) == false && myUnit.isUnderAttack() == false) {
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
						Position regroup = GetKitePos(myUnit, attacker);
						if(regroup.isValid() == false){
							regroup.makeValid();
						}
						myUnit.move(regroup);
					}
					
				}


			if(myUnit.isAttacking() == true && customTargets == 0){
					customTargets = 1;
					ArrayList<Unit> myUnits = GetMyUnitsNearby(myUnit.getPosition(), 180, true);
					ArrayList<Unit> notMyUnits = new ArrayList<Unit>();
					for(Unit units : game.getUnitsInRadius(myUnit.getPosition(), 180)){
						if(game.enemies().contains(units.getPlayer()) == true && ShouldBeFocused(units) == true){
							notMyUnits.add(units);
						}
						if(notMyUnits.isEmpty() == false){
							for(Unit unitss : notMyUnits){
								for(Unit unit : myUnits){
									int dist = unit.getPosition().getApproxDistance(unitss.getPosition());
									int range = unit.getType().groundWeapon().maxRange();
									if(unitss != null){
										if(unit.canAttack(unitss) == true && dist <= range + (range * 0.10)){
										unit.attack(unitss);
										game.drawCircleMap(unitss.getPosition(), 15, bwapi.Color.Green);
										}
									}
								}
								break;
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
					if(employees.containsKey(myUnit) == true){
						Unit closestMineral = null;
						for (Unit neutralUnit : myMinerals) {
							if (closestMineral == null
									|| myUnit.getDistance(neutralUnit) < myUnit.getDistance(closestMineral)) {
								closestMineral = neutralUnit;
								if (closestMineral != null) {
									BaseLocation loc = BWTA.getNearestBaseLocation(closestMineral.getPosition());
									myUnit.gather(closestMineral, false);
								}
							}
						}
					}
					else {
						BaseLocation loc = GetBaseToGatherAt();
						if(loc != null){
						myUnit.move(loc.getPosition());
						int code = loc.hashCode();
						TilePosition tile = loc.getTilePosition();
						if(baseWorkers.containsKey(tile) == true){
							//System.out.println("Contains base");
							baseWorkers.put(tile, baseWorkers.get(tile) + 1);
							employees.put(myUnit, tile);
								
							}
						}
						else {
							//System.out.println("404_BASE_NOT_FOUND");
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
							break;
						}
					}
					
					
				}
				
//				if(scouter != null && scoutTime == 0){
//					scoutTime = 1;
//					if(scouter.exists() && scouter.isCompleted() == true && scouter.isMoving() == true){
//						for(Unit units : game.getUnitsInRadius(myUnit.getPosition(), 300)){
//							boolean asds = isTargettingUnit(units, scouter);
//							//System.out.println("is Targetting: " + asds);
//							if(IsMilitrayUnit(units) == true){
//								System.out.println("Unit: " + units.getType().toString() + " Is a militray unit and should not be hugged");
//							}
//							if(game.enemies().contains(units.getPlayer()) && asds == true){
//								System.out.println("TRIGGER ATTACK");
//								game.drawCircleMap(units.getPosition(), 30, bwapi.Color.Yellow);
//								Position flee = GetKitePos2(scouter, units);
//								if(flee != null){
//									System.out.println("flee not null");
//										if(flee.isValid() == true){
//										myUnit.move(flee);
//										System.out.println("is valid");
//										game.pingMinimap(flee);
//										break;
//										}
//									}
//									else{
//										if(ralleyPoint != null){
//										myUnit.move(ralleyPoint);
//										System.out.println("Flee to regroup");
//										break;
//										}
//									}
//								break;						
//							}
//							
//						}
//				}
//			}
				
				
			if(scouter != null){
				if(scouter.isUnderAttack() == true && scouterFleeing == false){
					if(ralleyPoint != null){
						scouter.move(ralleyPoint);
						scouterFleeing = true;
					}
					else {
						scouter.move(self.getStartLocation().toPosition());
					}
				}
				
				if(scouterFleeing == true && myUnit.isUnderAttack() == false){
					scouter.stop();
					scouterFleeing = false;
				}
				
			}
				
				// end of myUnits loop

			}
		//SQUADS
		
			if(Squads.isEmpty() == false){
				for(Squad squad : Squads){
					int index = Squads.indexOf(squad);
					int score = squad.getScore();
					int tScore = squad.getTargetScore();
					int size = squad.getUnitSize();
					boolean attacking = squad.isAttacking();
					Position draw;
					Unit drawer = getSquadUnit(squad);
					if(squad.getUnits().isEmpty() == false){
						if(drawer != null){
							draw = drawer.getPosition();
						}
						else {
							System.out.println("Drawer");
							draw = squad.getUnits().get(0).getPosition();
						}
					game.drawTextMap(draw, "Squad: " + index + " score: " + score + " tScore: " + tScore + " Size: " + size);
					}

					//game.drawTextMap(draw, "Squad: " + index + " attacking: " + attacking  + " retreating " + ret + " AWR " + aw);
					//game.drawTextMap(draw, "Squad: " + index);
						if(squad.AWR() == true && squad.getScore() >= squad.getTargetScore() && squad.isDefending() == false && attacking == true){
							squad.attack();
						}
						
						if(squad.isDefending() == true && squad.canFreeRoam() == true && squad.getScore() >= squad.getTargetScore()){
							squad.attack();
						}
							
					}
				
				}
					
			if(TeamGameMode == false){

				for (Unit EnemyUnits1 : game.enemy().getUnits()) {
					
					boolean isMil = IsMilitrayUnit(EnemyUnits1);
					if(EnemyUnits1.isCloaked() || EnemyUnits1.isBurrowed()){
						if (EnemyUnits1.isAttacking() == true
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
										//System.out.println("List for player: " + EnemyUnits1.getPlayer().getName() + " is null");
									}
								
								if (!enemyBuildingMemory.contains(EnemyUnits1.getPosition())) {
									enemyBuildingMemory.add(EnemyUnits1.getPosition());
									scoutedLocations.clear();
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
					break;
				}
		}
	}
	else{
		Position pos1 = enemyBuildingMemory.get(0);
		if(totalFrames < 7000){
			for(bwta.Region region : BWTA.getRegions()){
				if(region.getDistance(pos1) < 400){
					scouter.move(region.getCenter(), true);
				}
			}
		} else {
			for(Position pos : enemyBuildingMemory){
					scouter.move(pos, true);
					break;
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
		new ClusterFuck().run();

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
						if (!unitsInWay && NewBuild != LastBuild) {
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
							&& claimedBaseLocations.contains(Expand) == false) {
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
	
	
	public Position GetBunkerChoke(){
		int dist = 0;
		BaseLocation nextBase = null;
		while (nextBase == null) {
			dist = dist + 200;
			for (BaseLocation Expand : BWTA.getBaseLocations()) {
				int AmountofBases = BWTA.getBaseLocations().size();
				int tree = BWTA.getGroundDistance2(BasePos, Expand.getTilePosition());
					if (Expand.getGroundDistance(BWTA.getNearestBaseLocation(BasePos)) < dist
					&& BWTA.getGroundDistance(Expand.getTilePosition(), self.getStartLocation().getPoint()) > 50) {
						nextBase = Expand;
						break;
					}
			}
		}
				if(nextBase != null){
					bwta.Region bregion = BWTA.getRegion(nextBase.getPoint());
					int lowest = 0;
					Chokepoint chosen = null;
					ArrayList<Chokepoint> cocks = getChokesNearby(bregion.getCenter(), 750);
					for(Chokepoint chokes : cocks){
							int distt = 0;
							int thiss = 0;
							int amount = 0;
							for(BaseLocation bases : BWTA.getBaseLocations()){
								if(bases.isStartLocation() == true){
									int dsfdsf = BWTA.getGroundDistance2(chokes.getCenter().toTilePosition(), bases.getTilePosition());
									distt = distt + dsfdsf;
									amount++;
								}
							}
							thiss = distt / amount;
							if(thiss < lowest || chosen == null){
								lowest = thiss;
								chosen = chokes;
							}
						
						
						if(chosen != null){
						return chosen.getCenter();
						}
						else {
							return null;
						}
					
					}
				}
				return null;


	}
	
	
	public Chokepoint GetMainChoke(){
		bwta.Region bregion = BWTA.getRegion(self.getStartLocation());
		int lowest = 0;
		Chokepoint chosen = null;
		for(Chokepoint chokes : bregion.getChokepoints()){
			int distt = 0;
			int thiss = 0;
			int amount = 0;
			for(BaseLocation bases : BWTA.getBaseLocations()){
				if(bases.isStartLocation() == true){
					int dsfdsf = BWTA.getGroundDistance2(chokes.getCenter().toTilePosition(), bases.getTilePosition());
					distt = distt + dsfdsf;
					amount++;
				}
			}
			thiss = distt / amount;
			if(thiss < lowest || chosen == null){
				lowest = thiss;
				chosen = chokes;
			}
		}
		
		if(chosen != null){
		return chosen;
		}
		else {
			return null;
		}
		

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
	
	public ArrayList<Unit> GetWorkerAmount(int amount) {
		int i = 0;
		ArrayList<Unit> workers = new ArrayList<Unit>();
		for (Unit unit : myWorkers) {
			if(i <= amount){
				if (unit.getType() == UnitType.Terran_SCV && unit.isGatheringMinerals() == true && workers.contains(unit) == false && unit.getID() != scoutID) {
						i++;
						workers.add(unit);
				}
			}
		}
		if(workers.size() >= 3){
		return workers;
		}
		else {
		return null;
		}
		

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
		if(targett != null){
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
		return null;
	}
	
	public Position GetJukePosManual(Unit unit, int enemyx, int enemyy){
		int unitx = unit.getX();
		int unity = unit.getY();
		int targetx = enemyx;
		int targety = enemyy;
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



	public Position Regroup(ArrayList<Unit> units) {
		int X = 0;
		int Y = 0;
		int max = units.size();
		for (Unit unit : units) {
			int unitX = unit.getX();
			int unitY = unit.getY();
			X = X + unitX;
			Y = Y + unitY;
		}
		
		X = X / max;
		Y = Y / max;
		
		Position pos = new Position(X, Y);
		return pos;
		

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
		
		for(Squad squad : Squads){
			if(squad.isAttacking() == true){
				squad.setAttack(false);
			}
			squad.retreatAllUnits();
		}
		
		
			
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
		
		if(unit.getPosition().getApproxDistance(pos) < 75){
			return true;
		}
		
		return false;
	}
	
	
	public void DefenceCall(Unit victim){
		ArrayList<Unit> ass2 = GetEnemyUnitsNearby(victim.getPosition(), 350, true);
		boolean canWin = false;
		Position pos = victim.getPosition();
		int eScore = 0;
		Squad sq = getSquadTargetted(pos);
		boolean breaking = false;
		for(Unit unit : ass2){
			eScore = eScore + getScoreOf(unit);
		}
		
		if(victim != scouter){
			
		if(fapMyScores < InvadersScore && victim != scouter && canWin == false && victim.getPosition().getApproxDistance(self.getStartLocation().toPosition()) < 1000){
			PullTheBoys(victim.getPosition());
		}
		
			if(defenderCall == true){
			defenceCallFrames = 1;
			defenderCall = false;
			}
			
			if(sq != null){
				if(sq.getTargetScore() != eScore){
					sq.setTargetScore(eScore);
				}
			}
			
			if(attacking == false){
				for(Squad i : Squads){
					if(i.getScore() >= eScore){
						i.setTargetScore(eScore);
						i.setAWR(true);
						i.setDefence(true);
						i.target = pos;
						System.out.println("Squad: " + i.getId() + " Now assigned to defend " + pos);
						breaking = true;
						break;
					}
				}

			}
			
			if(sq == null && breaking == false){
				// if are not attacking, we'll send a new squad to defend it
				 BuildSquadToCounter(eScore, pos);
				 System.out.println("No Squad assigned to defend " + pos + " Assigning a new squad");
			}
			else {
				sq.setTargetScore(eScore);
				if(sq.priority() != 1){
					sq.setPriority(1);
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

	if(TeamGameMode == false){
		int dist = AvergeDistanceToRalleyPoint();
		
		if(dist > 2000 && CanWin == true && wasAttacking == false){
			shouldregroup = true;
		}
		
	if(fapMyScores > InvadersScore && InvadersScore > 0){
		Strats = "Defending the Motherland";
	}
		

	if(CanWin == true){
		
			UnitType type = NextTechGoal();
			
			if(type != null){
				if(type == UnitType.Terran_Bunker || type == UnitType.Terran_Missile_Turret){
					if(pBuildings.contains(type) == false){
					pBuildings.add(type);
					pPosition.add(null);
					}
				}
				if(fapMyScores >= InvadersScore){
					if(pBuildings.contains(type) == false){
					pBuildings.add(type);
					pPosition.add(null);
					}
				}
			}

				
			if(InvadersScore < fapMyScores){
				attacking = true;
				wasAttacking = true;
				picked = true;
				Strats = "Full Attack";
				GlobalAttack();
				allSquadsAttack();
			}
			

		}
		else {
			attacking = false;
			picked = true;
			Strats = "Waiting for more army strength";
			 GlobalRetreat();
		}
				
	}
	else {
	
		int target = GetPlayerTarget();
		if(target != 10){
		boolean shouldregroup1 = false;
		if(playerBuildings.get(target).isEmpty() == false){
		shouldregroup1 = ShouldRegroup(playerBuildings.get(target).get(0));
		//System.out.println("Should Regroup: " + shouldregroup1);
		}
		
		String names = game.getPlayer(target).getName();
		//System.out.println("Targetted player is: " + names);
		//if we have a target in ffa

		TeamModeTargetPlayer = target;
		if(InvadersScore == 0){
			attacking = true;
			Strats = "Full Attack";
			picked = true;
			GlobalAttack();
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
	int threshold = (int) Math.round(estimatedEnemyScore * 0.95);
	int i = 0;
	boolean usingInts = ShouldSimUnits();
	
	if(usingInts == true){
		if(jFapGlobal() == true){
			return true;
		}
	}
	
	if(enemyUnits.isEmpty() == false){
		for(Unit units : enemyUnits){
			if(units.isVisible() == true){
				i = i + getScoreOf(units);
			}
			
			if(i >= threshold){
				return true;
			}	
		}
		
		if(i >= threshold){
			return true;
		}
	}
	
	
	if(fapMyScores > (estimatedEnemyScore + enemyDefenceScore + enemyGhostPoints)){
		return true;
	}
	return false;
}


public void ThinkUnit(Unit myUnit){
	
	if(myUnit.isUnderStorm() && myUnit.getPosition().getApproxDistance(ralleyPoint) > 300){
		if(ralleyPoint != null){
			myUnit.move(ralleyPoint);
		}
	}

	if (myUnit.getType() == UnitType.Terran_Marine && myUnit.canUseTech(TechType.Stim_Packs) == true && myUnit.isStimmed() == false && myUnit.getHitPoints() > 30) {
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
	
//	if(myUnit.isAttacking() == true && myUnit.getType() == UnitType.Terran_Marine && myUnit.getOrder() == Order.AttackUnit){
//		//System.out.println("Trigger");
//		Unit target = myUnit.getTarget();
//		UnitType type = null;
//		if(target != null && target.exists() == true){
//		type = target.getType();
//		}
//		if(jukers.containsKey(myUnit) == false){
//			jukers.put(myUnit, new ArrayList<Unit>());
//		}
//		
//		if(type != null){
//			if(type == UnitType.Protoss_Zealot && ShouldJuke(myUnit.getPosition()) == true){
//				if(jukers.containsKey(myUnit) == true){
//					ArrayList<Unit> list = jukers.get(myUnit);
//					if(list.contains(target) == false){
//						list.add(target);
//					}
//					jukers.put(myUnit, list);
//				}
//			}
//		}
//		
//		
//	}
	
	
}



private boolean ShouldJuke(Position position) {
	int allies = GetMyUnitsNearby(position, 300, false).size();
	int enemies = GetEnemyUnitsNearby(position, 300, false).size();
	if(allies >= enemies * 6 + 1){
		return true;
	}
	return false;
}


public boolean CanExpand(){
	// TODO Yolo expands. Expanding even if enemy score is greater then mine if needs > income * 0.20 (20% of my income)
	// also TODO is a fancy color in eclipse =D
	// Stop Ctrl-f'ing my code Hannes
	// nuke nuke hannes bregberg nuke more nukes ghost stuff bio bot
	if(enemyBuildingMemory.isEmpty() == true && totalFrames < 7500){
		// don't expand without intell
		return false;
	}
	
	if(estimatedEnemyScore == 0 && enemyDefenceScore > 600){
		// if the enemy is turtling hard
		return true;
	}
	
	if((estimatedEnemyScore * 4 + 300) < enemyDefenceScore){
		// if the enemy is turtling hard
		return true;
	}
	
	if(needs >= income * 2){
		// if we need to badly expand
		return true;
	}
	
	if(HowManyDoIHave(UnitType.Terran_Academy) == 0){
		// don't expand unless you have an academy to deal with zealots because they are OP.
		return false;
	}
	
	
	if(TeamGameMode == false){
		int expandscore = InvadersScore + Math.round(estimatedEnemyScore / 2) + enemyGhostPoints;
		//System.out.println("Expand score: " + expandscore);
		if(fapMyScores >= expandscore){
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
	boolean needsScan = false;
	
	for (Unit targets : game.getUnitsInRadius(pos, 200)) {
		int damage = targets.getType().groundWeapon().damageAmount() + targets.getType().airWeapon().damageAmount();
		
		if (targets.getPlayer().isEnemy(self) && IsMilitrayUnit(targets) == true) {
			simulator.addUnitPlayer2(new JFAPUnit(targets));
			if(targets.isDetected() == false && targets.getType() == UnitType.Zerg_Lurker || targets.getType() == UnitType.Protoss_Dark_Templar){
				needsScan = true;
			}
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
	int isMain = (int) (fapMyScores * 0.75);
	//is 65% or more of my army in this battle?
	if(preSimScores.first > isMain){
		if(preSimScores.first < preSimScores.second){
			//and if we can't win
			if(Strats == "Full Attack"){
					Strats = "Regrouping Due to major calculated loss";
					allSquadsRetreat();
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
	
	if(needsScan == true && getTotalScanEnergy() < 50){
		return false;
	}
	
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
		
		if (buildings.getType() == UnitType.Terran_Factory && game.canMake(UnitType.Terran_Siege_Tank_Tank_Mode) && buildings.isIdle() == true) {
			buildings.train(UnitType.Terran_Siege_Tank_Tank_Mode);
		}
		
		if (buildings.getType() == UnitType.Terran_Barracks && game.canMake(UnitType.Terran_Marine) && buildings.isIdle() == true) {
					buildings.train(UnitType.Terran_Marine);
		}

		if (buildings.getType() == UnitType.Terran_Starport && game.canMake(UnitType.Terran_Battlecruiser) == true && buildings.isIdle() == true) {
			buildings.train(UnitType.Terran_Battlecruiser);
		}
		
	}
}


public void PullTheBoys(Position pos){
	if(BWTA.getGroundDistance(self.getStartLocation(), pos.toTilePosition()) < 2000){
		for(Unit unit : myWorkers){
			if(unit.isGatheringMinerals() == true && unit.isRepairing() == false){
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
	
	if(auxType == UnitType.Terran_Medic || auxType == UnitType.Terran_Science_Vessel){
		return 20;
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
		if(unit.getOrderTarget() == myUnit || unit.getTarget() == myUnit){
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
			i = unit.getPosition().getApproxDistance(pos);
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
	boolean debug = false;
	boolean needscan = false;
	for(Unit unit : mine){
		simulator.addUnitPlayer1(new JFAPUnit(unit));
	}
	
	for(Unit unit : enemy){
		simulator.addUnitPlayer2(new JFAPUnit(unit));
		if(unit.getType() == UnitType.Zerg_Lurker || unit.getType() == UnitType.Protoss_Dark_Templar){
			needscan = true;
		}
	}
	

	Pair<Integer, Integer> preSimScores = simulator.playerScores();
	int preSimFriendlyUnitCount = simulator.getState().first.size();
	simulator.simulate(40);
	
	Pair<Integer, Integer> postSimScores = simulator.playerScores();
	int postSimFriendlyUnitCount = simulator.getState().first.size();
	int myLosses = preSimFriendlyUnitCount - postSimFriendlyUnitCount;
	int myScoreDiff = preSimScores.first - postSimScores.first;
	int enemyScoreDiff = preSimScores.second - postSimScores.second;
	if(debug == true){
	System.out.println("Mine Size : " + mine.size());
	System.out.println("Enemy Size : " + enemy.size());
	System.out.println("P1 Pre: " + preSimScores.first);
	System.out.println("P2 Pre : " + preSimScores.second);
	System.out.println("P1 Post: " + postSimScores.first);
	System.out.println("P2 Post : " + postSimScores.second);
	System.out.println("Needs Scan : " + needscan);		
	}
	// if we can win
	
	if(needscan == true && getTotalScanEnergy() < 50){
		return false;
	}
	
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
	
	if(type == UnitType.Terran_Firebat){
		if(Racks > 0 && game.canMake(UnitType.Terran_Firebat) == true){
			return true;
		}
	}
	
	if(game.canMake(type) == true){
		return true;
	}
	
	return false;
}

public UnitType NextTechGoal(){
	// t = 1
	// p = 2
	// z = 3
	
		if(InvadersScore > 0){
			return null;
		}
		
		if(expanding == true){
			return null;
		}
		
		if(AcademyBuilt == false && buildTypes.contains(UnitType.Terran_Academy) == false && HowManyDoIHave(UnitType.Terran_Academy) == 0 && fapMyScores >= enemyRushScore + enemyGhostPoints){
			return UnitType.Terran_Academy;
		}
		
		if(Bays == 0 && buildTypes.contains(UnitType.Terran_Engineering_Bay) == false && HowManyDoIHave(UnitType.Terran_Engineering_Bay) == 0 && fapMyScores >= enemyRushScore + enemyGhostPoints){
			return UnitType.Terran_Engineering_Bay;
		}
		
		if(Factories == 0 && buildTypes.contains(UnitType.Terran_Factory) == false && HowManyDoIHave(UnitType.Terran_Factory) == 0 && Racks >= MaxRacks && fapMyScores >= enemyRushScore && Gases > 0 && fapMyScores > 750){
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
	
	if(myUnits.isEmpty()){
		return false;
	}

	if(game.isVisible(pos.toTilePosition()) == false){
		// if the position is not visible, we shall go off distance to the ralleyPoint. 
		Position pos1 = ralleyPoint;
		for(Unit units : myUnits){
			dist = dist + units.getPosition().getApproxDistance(ralleyPoint);
		}
	}
	else {
		for(Unit units : myUnits){
			dist = dist + units.getPosition().getApproxDistance(pos);
			//System.out.println("Dist is now: " + dist);
		}
		

	}
	dist = Math.round(dist / myUnits.size());
	//System.out.println("Dist Final is: " + dist);
	
	if(dist > 2000){
		return true;
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
		int dist = unit.getPosition().getApproxDistance(target.getPosition());
		int range = unit.getType().groundWeapon().maxRange();
		if(unit.isInWeaponRange(target) == true && dist <= range + (range * 0.55)){
			score = score + getScoreOf(unit);
		}
		if(score >= targetscore){
			return true;
		}
	}
	
	for(Unit unit : myBunkers){
	if(unit.getLoadedUnits().size() > 0){
		if(unit.getPosition().getApproxDistance(target.getPosition()) < 400){
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

public boolean BunkerCanAttackAnything(Unit bunker){
	
	if(bunker.getLoadedUnits().isEmpty() == true){
		return false;
	}
	
	for(Unit units : bunker.getLoadedUnits()){
		for(Unit eunits : GetEnemyUnitsNearby(bunker.getPosition(), 170, false)){
			if(units.isInWeaponRange(eunits) == true){
				return true;
			}
		}
	}
	
	return false;
	
}

public boolean ShouldBeFocused(Unit weeheads){
	
	if(weeheads.getType() == UnitType.Terran_Vulture_Spider_Mine){
		return true;
	}
	
	if(weeheads.getType() == UnitType.Zerg_Lurker && getTotalScanEnergy() > 50){
		return true;
	}
	
	if(weeheads.getType() == UnitType.Terran_SCV && weeheads.isRepairing() == true){
		return true;
	}
	
	if(weeheads.getType() == UnitType.Terran_Medic){
		return true;
	}
	
	if(weeheads.getType() == UnitType.Protoss_High_Templar){
		return true;
	}
	
	if(weeheads.getType() == UnitType.Protoss_Carrier){
		return true;
	}
	

	return false;
	
}

public ArrayList<Unit> GetMyUnitsNearby(Position pos, int radius, boolean include){
	 ArrayList<Unit> Mine = new ArrayList<Unit>();
	for (Unit targets : game.getUnitsInRadius(pos, radius)) {
		int damage = targets.getType().groundWeapon().damageAmount() + targets.getType().airWeapon().damageAmount();
		if (targets.getPlayer() == self && IsMilitrayUnit(targets) == true && Mine.contains(targets) == false) {
			Mine.add(targets);

		}
		if(targets.getPlayer().isAlly(self) && targets.getType() == UnitType.Terran_Bunker && targets.getLoadedUnits().size() > 0 &&Mine.contains(targets) == false && include == true ){
			Mine.add(targets);
		}
	}
	
	return Mine;

	
}

public ArrayList<Unit> GetEnemyUnitsNearby(Position pos, int radius, boolean include){
	 ArrayList<Unit> Mine = new ArrayList<Unit>();
	for (Unit targets : game.getUnitsInRadius(pos, radius)) {
		int damage = targets.getType().groundWeapon().damageAmount() + targets.getType().airWeapon().damageAmount();
		if (targets.getPlayer().isEnemy(self) == true && IsMilitrayUnit(targets) == true && Mine.contains(targets) == false) {
			Mine.add(targets);

		}
		if(targets.getPlayer().isEnemy(self) == true && IsMilitrayBuilding(targets) == true && include == true){
			Mine.add(targets);
		}
	}
	
	return Mine;

	
}

public void BuildSquadToCounter(int tscore, Position pos){
	int cscore = 0;
	boolean breaking = false;
	
	// if our total score isnt big enough to defend, we'll send all there
	if(tscore > fapMyScores){
		for(Squad squad : Squads){
			squad.newTarget(pos);
			squad.setDefence(true);
		}
		breaking = true;

	}
	
	if(breaking != true){
	// if we are big enough, we'll build a squad and assign it that POS.
		Squad i = new Squad(Squads.size() + 1);
		Squads.add(i);
		i.newTarget(pos);
		i.setPriority(1);
		i.setTargetScore(tscore);
		i.setAWR(true);
		i.setDefence(true);
		ArrayList<Unit> yes = getUnitsNotInSquad(i);
		int squadScore = 0;
		for(Unit units : yes){
			if(squadScore >= tscore){
				break;
			}
			
			if(i.getUnits().contains(units) == false){
				squadScore = squadScore + getScoreOf(units);
				i.absorbUnit(units);
			}
		}
		
	}

}

public int GetAverageRange(Position pos){
	int total = 0;
	int amount = 0;
	for(Unit units : GetEnemyUnitsNearby(pos, 300, true)){
		total = total + units.getType().groundWeapon().maxRange();
		amount++;
	}
	return Math.round(total / amount);
}

public UnitType GetRecommendedCounter(UnitType type){
	
	if(type == UnitType.Protoss_Zealot && game.canMake(UnitType.Terran_Firebat) == true){
		return UnitType.Terran_Firebat;
	}
	
	return null;
	
}

public String CheckOpener(Player ply){
	
	if(ply.allUnitCount(UnitType.Zerg_Spawning_Pool) == 1 && ply.allUnitCount(UnitType.Zerg_Drone) < 7){
		return "6 Pool";
	}
	
	return null;
	
}

public void AddUnitAmountToPUnits(UnitType type, int amount){
	for (int i = 0; i < amount; i++){
		pUnits.add(type);
	}
}

public boolean isTargettingUnit(Unit target, Unit victim){
	if(target.exists() == true){
		if(target.getTarget().equals(victim)|| target.getOrderTarget().equals(victim) || target.getOrderTargetPosition().equals(victim.getPosition())){
			return true;
		}
	}
	return false;
}



public boolean ShouldSimUnits(){
	int amount = 0;
	int threshhold = 1;
	int max = enemyUnits.size();
	
	if(enemyUnits.isEmpty() == true){
		return false;
	}
	
	if(SameArmy() == true){
		// basically if the army is the same as the last fap sim we can just decide using that data again
		return true;
	}
	
	for(Unit units : enemyUnits){
		if(units.isVisible() == true){
			amount++;
		}
	}
	
	if(amount >= max){
		return true;
	}
	
	return false;
}

public boolean jFapGlobal(){
	JFAP simulator = new JFAP(game);
	simulator.clear();
	
	for(Unit unit : myUnits){
		simulator.addUnitPlayer1(new JFAPUnit(unit));
	}
	
	for(Unit unit : enemyUnits){
		simulator.addUnitPlayer2(new JFAPUnit(unit));
	}
	
	for(Unit unit : enemyDefences){
		simulator.addUnitPlayer2(new JFAPUnit(unit));
	}

	Pair<Integer, Integer> preSimScores = simulator.playerScores();
	int preSimFriendlyUnitCount = simulator.getState().first.size();
	simulator.simulate(75);
	Pair<Integer, Integer> postSimScores = simulator.playerScores();
	int postSimFriendlyUnitCount = simulator.getState().first.size();
	int myLosses = preSimFriendlyUnitCount - postSimFriendlyUnitCount;
	int myScoreDiff = preSimScores.first - postSimScores.first;
	int enemyScoreDiff = preSimScores.second - postSimScores.second;
	//System.out.println("Me : " + myScoreDiff);
	//System.out.println("Enemy : " + enemyScoreDiff);
	// if we can win
	lastSimScore = preSimScores.second;
	if (postSimScores.first >= postSimScores.second) {
		return true;
	} 
	else {
		return false;
	}
	
}

public boolean SameArmy(){
	
	if(estimatedEnemyScore == lastSimScore){
		return true;
	}
	
	return false;
}

public BaseLocation GetBaseToGatherAt(){
	if(myBases.isEmpty() == false){
		int lowest = 0;
		BaseLocation chosen = null;
		for(BaseLocation bases : myBases){
			int code = bases.hashCode();
			TilePosition tile = bases.getTilePosition();
			if(baseWorkers.containsKey(tile) && maxWorkers.containsKey(tile)){
				int amount = baseWorkers.get(tile);
				int max = maxWorkers.get(tile);
				if(amount <= max){ 
					if(amount <= lowest || chosen == null){
					lowest = baseWorkers.get(tile);
					chosen = bases;
					}
				}
			}
	
		}
		if(chosen != null){
			return chosen;
		}
		else {
			return null;
		}
	}	
	
	return null;
}

public boolean isWorking(Unit unit){
	
	if(unit.isConstructing() == false){
		if(unit.isGatheringGas() || unit.isGatheringMinerals() || unit.isCarryingGas() || unit.isCarryingMinerals()){
			return true;
		}
	}
	 return false;
}

	
public boolean IsHealing(Unit unit){
	if(unit.getOrder() == Order.HealMove && unit.getOrder() == Order.MedicHeal || unit.getOrder() == Order.MedicHealToIdle){
		return true;
	}
	
	return false;
}

public void GlobalAttack(){
	
Position attack = getAttackTarget();
if(Squads.isEmpty() == false){
	for(Squad sq : Squads){
		if(attack != null && sq.getTarget() == null){
			setAllTarget(attack);
		}
	}
}

allSquadsAttack();

}

public boolean isInCombat(Unit unit){
	if(unit.isAttacking() || unit.isUnderAttack() || unit.isStartingAttack()){
		return true;
	}
	
	return false;
}

public boolean ScoreFap(ArrayList<Unit> mine, ArrayList<Unit> hostile, int bonus){
	int a = 0;
	int h = 0;
	boolean needscan = false;
	
	if(bonus < 1){
		bonus = 1;
	}
	
	for(Unit units : mine){
		a = a + getScoreOf(units);
	}
	
	for(Unit units : hostile){
		h = h + getScoreOf(units);
		if(units.isDetected() == false && units.getType() == UnitType.Zerg_Lurker || units.getType() == UnitType.Protoss_Dark_Templar){
			needscan = true;
		}
	}
	
	if(needscan == true && getTotalScanEnergy() < 50){
		return false;
	}

	
	if(a >= h * bonus){
		return true;
	}
	
	
	return false;
}


public void CustomGreetings(String str){

	if(str == "Ecgberht"){
		game.sendText("Sorry it has to come to this, M'lord");
		game.sendText("But it's time to hand over the throne");
	}
	
	
}

public boolean IsUpgradingorBetter(UpgradeType type){
	
	if(self.isUpgrading(type) || self.getMaxUpgradeLevel(type) > 0){
		return true;
	}
	
	return false;

}

public int AvergeDistanceToRalleyPoint(){
	int max = 0;
	
	if(myUnits.isEmpty() == true){
		return 0;
	}
	
	for(Unit units : myUnits){
		int dist = units.getPosition().getApproxDistance(ralleyPoint);
		max = max + dist;
	}
	return max / myUnits.size();

	
}

public int maxDepots(){
	if(totalFrames < 4000){
		return 1;
	}
	else {
		return Bases * 2;
	}
}

public int HowManyInQueue(UnitType type){
	int i = 0;
	for(UnitType types : buildTypes){
		if(type == types){
			i++;
		}
	}
	
	return i;
}

public int HowManyInQueueCQ(UnitType type){
	int amount = 0;
	if(CQ.containsValue(type) == true){
		return 1;
	}
	
	return 0;

}

public boolean isInCQ(UnitType type){
	if(CQ.containsValue(type) == true){
		return true;
	}
	
	return false;

}

public boolean queuedOrBetter(UnitType type){
	if(CQ.isEmpty() == true){
		return false;
	}
	
	if(CQ.containsValue(type)){
		return true;
	}
	
	return false;
}

class Squad {
int id;
ArrayList<Unit> units;	
int score;
Position target;
boolean attacking;
boolean AWR;
// ^^ attack when ready
String squadName;
int targetScore;
int priority;
// ^^ how important is this squad to get more units?
boolean retreating;
Position retreatPos;
boolean defending;
boolean freeRoam;

int getId(){
	return this.id;
}

boolean isDefending(){
	return defending;
}

ArrayList<Unit> getUnits(){
	return this.units;
}

int getScore(){
	return this.score;
}

Position getTarget(){
	return this.target;
}

boolean isAttacking(){
	return this.attacking;
}

String getName(){
	return this.squadName;
}

int getTargetScore(){
	return this.targetScore;
}

int getUnitSize(){
	if(units.isEmpty()){
		return 0;
	}
	else {
		return units.size();
	}
}

int priority(){
	return this.priority;
}

boolean AWR(){
	return this.AWR;
}


public Squad(int newid){
	this.id = newid;
	this.units = new ArrayList<Unit> ();
	this.score = 0;
	this.target = null;
	this.attacking = false;
	this.squadName = "asf";
	this.targetScore = 0;
	this.AWR = false;
	this.priority = 3;
	this.retreating = false;
	this.defending = false;
	this.freeRoam = false;
	if(ralleyPoint != null){
	this.retreatPos = ralleyPoint;
	}
	else {
		this.retreatPos = GetBunkerChoke();
	}
	
}

void absorbUnit(Unit unit){
	if(IsMilitrayUnit(unit) == true || unit.getType() == UnitType.Terran_Medic){
		if(units.contains(unit) == false){
			units.add(unit);
		}
		
		if(unitSquads.containsKey(unit) == false){
			unitSquads.put(unit, id);
			System.out.println("Unit: " + unit.getType().toString() + " now assigned to squad: " + this.id);
		}
		
		if(unitSquads.get(unit) != id){
			unitSquads.put(unit, id);
		}
		
		if(Squads.size() > 1){
		removeDupes(unit);
		}
		updateScore();
	}
	else {
		System.out.println("Unit is not a militray unit!");
	}
	
	
}

void updateScore(){
	int i = 0;
	for(Unit unit : units){
		if(unit.exists()){
		i = i + getScoreOf(unit);
		}
	}
	this.score = i;
}

boolean targetIsValid(){
	if(this.target != null){
		if(this.target.isValid() == true){
			return true;
		}
	}
	return false;
}


void Regroup(Position pos){
	if(this.isRetreating() == false && attacking == true){
		if(this.units.isEmpty() == false){
			for(Unit unit : units){
				if(isARetreater(unit) == false && isInCombat(unit) == false){
					unit.move(pos);
				}
			}
		}
	}
}

void newTarget(Position pos){
	this.target = pos;
}

void attack(){
	this.attacking = true;
	this.retreating = false;
	this.defending = false;
	Position pos = this.target;
	
	if(pos == null){
		pos = getAttackTarget();
	}
	
	for(Unit unit : this.units){
		unit.attack(pos);
	}
	
}

void setAttack(boolean bool){
	this.attacking = bool;
	this.retreating = false;
}

void newTargetScore(int score){
	this.targetScore = score;
}

void setAWR(boolean bool){
	this.AWR = bool;
}

void retreat(){
	if(this.retreatPos != null){
		this.retreating = true;
		this.attacking = false;
		this.AWR = false;
		this.defending = false;
	}
}

Position getRetreatPos(){
	return this.retreatPos;
}

boolean isRetreating(){
	return this.retreating;
}

void setPriority(int i){
	this.priority = i;
}

boolean isDead(){
	if(this.units.isEmpty() == true){
		return true;
	}
	
	return false;
}

void retreatAllUnits(){
	if(this.units.isEmpty() == false){
		Position pos = this.getRetreatPos();
		for(Unit unit : this.units){
			if(pos != null && unit.getPosition().getApproxDistance(pos) > 300){
				unit.move(pos);
			}
		}
	}
}

void allUnitsAttack(){
	Position pos = this.getTarget();
	for(Unit unit : this.units){
		if(pos != null){
			if(isARetreater(unit) == false){
			unit.attack(pos);
			}
		}
	}
}


void removeUnit(Unit unit){
	if(this.getUnits().contains(unit) == true){
		this.getUnits().remove(unit);
		updateScore();
		unitSquads.remove(unit);
	}
}

void removeFromSquad(Unit unit){
	if(this.getUnits().contains(unit) == true){
		this.getUnits().remove(unit);
		updateScore();
	}
}

void setRetreatPos(Position pos){
	this.retreatPos = pos;
}

boolean isAtTarget(){
	int i = 0;
	int max = 0;
	
	if(this.target == null){
		return false;
	}
	
	if(this.units.isEmpty() == false){
		max = (int) (this.units.size() - Math.round(this.units.size() * 0.45));
		for(Unit unit : this.units){
			if(unit.isIdle() == true){
				if(unit.getPosition().getApproxDistance(this.target) < 200){
					i++;
				}
			}
		}
		
		if(i>=max){
			return true;
		}
	}
	
	return false;
}

void remove(){
	Squads.remove(this);
	if(this.getUnits().isEmpty() == false){
		for(Unit unit : this.getUnits()){
			this.removeUnit(unit);
		}
	}
}


void setDefence(boolean set){
	this.defending = set;
}


void setTargetScore(int value){
	this.targetScore = value;
}


void setFreeRoam(boolean bool){
	this.freeRoam = bool;
}

boolean canFreeRoam(){
	return this.canFreeRoam();
}

}
// end of squad class

public class buildQueue{
	UnitType type;
	TilePosition pos;
	int id;
	boolean checkIfBuilt;
	
	
	public buildQueue(int idd, UnitType btype, TilePosition location){
		this.type = btype;
		this.pos = location;
		this.id = idd; 
		this.checkIfBuilt = false;
	}
	
	public buildQueue(int idd, UnitType btype){
		this.type = btype;
		this.pos = null;
		this.id = idd; 
		this.checkIfBuilt = false;
	}
	
	public buildQueue(int idd, UnitType btype, TilePosition location, boolean iff){
		this.type = btype;
		this.pos = location;
		this.id = idd; 
		this.checkIfBuilt = iff;
	}
	
	public buildQueue(int idd, UnitType btype, boolean iff){
		this.type = btype;
		this.pos = null;
		this.id = idd; 
		this.checkIfBuilt = iff;
	}
	
	UnitType getType(){
		return this.type;
	}
	
	TilePosition getPos(){
		return pos;
	}
	
	boolean checkIfBuilt(){
		return this.checkIfBuilt;
	}
}




Squad getSquad(int index){
	
	for(Squad Squad : Squads){
		if(Squad.getId() == index){
			return Squad;
		}
	}
	return null;
}

Squad getSquad(Unit unit){
	if(unitSquads.containsKey(unit) == true){
		Squad squad = getSquad(unitSquads.get(unit));
		if(squad != null){
			return squad;
		}
	}
	
	//if this doesn't work we'll rape java till we get it
	for(Squad squad : Squads){
		for(Unit units : squad.getUnits()){
			if(units.equals(unit) == true){
				return squad;
			}
		}
	}
	
	return null;
}

void assignUnit(Unit unit){
	if(Squads.isEmpty() == false){
	int i = 1;
	int ii = 0;
	int max = Squads.size();
	boolean found = false;
	while(found == false && Squads.isEmpty() == false){ 
		System.out.println("While");
		for(Squad squad : Squads){
			int index = Squads.indexOf(squad);
			//System.out.println("Squad: " + index);
			int score = squad.getScore();
			//System.out.println("Squad: " + index + " score: " + score);
			int target = squad.getTargetScore();
			//System.out.println("Squad: " + index + " targetScore: " + target);
			//System.out.println("Squad: " + index + " priority " + squad.priority());
			if(squad.priority() <= i && score <= target && target > 0){
				squad.absorbUnit(unit);
				//System.out.println("Added unit to squad with target score: " + squad.getId());
				found = true;
			}
			if(squad.priority() <= i && squad.getUnitSize() <= 25){
				squad.absorbUnit(unit);
				//System.out.println("Added unit to squad: " + squad.getId());
				found = true;
			}
			ii++;
			if(ii > max){
				//System.out.println("All squads goals filled, new squad");
				Squad neww = new Squad(0);
				Squads.add(neww);
				neww.absorbUnit(unit);
				found = true;
				break;
			}
			
		}
		i++;
	}
	
	}
	else {
		System.out.println("NO squads");
		Squad neww = new Squad(0);
		Squads.add(neww);
		neww.absorbUnit(unit);
	}

}

void allSquadsAttack(){
	for(Squad squad : Squads){
		squad.attack();
	}
}

void allSquadsRetreat(){
	for(Squad squad : Squads){
		if(squad.isDefending() == false){
		squad.retreatAllUnits();
		}
		
		if(squad.isDefending() == true && squad.getScore() < squad.getTargetScore()){
			squad.retreatAllUnits();
		}
		
	}
}

void setAllAttack(){
	for(Squad squad : Squads){
		if(squad.isDefending() == false){
		squad.setAttack(true);
		}
	}
}

void setAllRetreat(){
	for(Squad squad : Squads){
		squad.retreat();
	}
}

void setAllAWR(){
	for(Squad squad : Squads){
		squad.setAWR(true);
	}
}

void setAllTarget(Position pos){
	for(Squad squad : Squads){
		if(squad.isDefending() == false){
		squad.newTarget(pos);
		}
	}
}


Squad getSquadTargetted(Position pos){
	if(Squads.isEmpty() == true){
		return null;
	}
	
	for(Squad squad : Squads){
		if(squad.getTarget() != null){
			if(squad.getTarget().getDistance(pos) < 800){
				return squad;
			}
		}
		else {
			return null;
		}
	}
	
	return null;

}


public Position getAttackTarget(){
	
	if (enemyBuildingMemory.isEmpty() == false) {
		// if we are not in a FFA
		if(TeamGameMode == false){
			return enemyBuildingMemory.get(0);
		}
	} else {
		if(scoutedLocations.isEmpty()){
			for(BaseLocation base : BWTA.getBaseLocations()){
				if(scoutedLocations.contains(base) == false){
					scoutedLocations.add(base);
				}
			}
		}
		for (BaseLocation b : scoutedLocations) {
			if (game.isVisible(b.getTilePosition()) == false && b.isIsland() == false) {
				return b.getPosition();
			}
		}
	}
	
	return null;
}

void removeDupes(Unit unit){
	Squad home = getSquad(unit);
	
	for(Squad squad : Squads){
		if(squad.getUnits().contains(unit) == true && squad != home){
			squad.removeFromSquad(unit);
		}
	}
	
}

boolean isInQueue(UnitType types){
	if(buildQueue.isEmpty() == true){
		return false;
	}
	
	for(buildQueue q : buildQueue){
		if(q.getType() == types){
			return true;
		}
	}
	return false;
}

ArrayList<Unit> getUnitsNotInSquad(Squad sq){
	ArrayList<Unit> ret = new ArrayList<Unit> ();
	for(Unit unit : myUnits){
		if(getSquad(unit) != sq && ret.contains(unit) == false){
			ret.add(unit);
		}
	}
	return ret;
}

int getTotalAttackScore(Position pos, int min){
	int i = 0;
	if(Squads.isEmpty() == false){
		for(Squad sq : Squads){
			if(sq.getTarget().getApproxDistance(pos) < min){
				i = i + sq.getScore();
			}
		}
	}
	return i;
}

void CheckSquadGoals(){
	squadUnitCheck();
	System.out.println("Squad Goals");
	if(Squads.isEmpty() == false){
		Position value;
		if(ralleyPoint == null){
			value = BWTA.getNearestChokepoint(self.getStartLocation().toPosition()).getPoint();
		}
		else {
			value = ralleyPoint;
		}
		
		for(Squad squad : Squads){
			if(squad.getUnits().isEmpty() == false && SquadsAverageDistTo(squad, value) > 300){
				System.out.println("regroup check");
				int i = squad.getUnitSize();
				int o = 0;
				int ffinal;
				Unit leader = squad.getUnits().get(0);
				for(Unit unit : squad.getUnits()){
					//o = o + unit.getDistance(leader.getPosition());
					o = o + unit.getPosition().getApproxDistance(leader.getPosition());
				}
				
				ffinal = o / i;
				
				if(ffinal > i*5+700){
					Position regroup = Regroup(squad.getUnits());
					squad.Regroup(regroup);
				}
				
			}
			
			if(squad.AWR() == true && squad.getScore() >= squad.getTargetScore() && squad.isDefending() == false){
				squad.attack();
			}
			
			if(squad.isDefending() == true && game.isVisible(squad.getTarget().toTilePosition()) == true && Squads.size() > 1){
				ArrayList<Unit> eunits =  GetEnemyUnitsNearby(squad.getTarget(), 200, false);
				if(eunits.isEmpty() == true){
					squad.setDefence(false);
					squad.setAttack(attacking);
					squad.setTargetScore(0);
					squad.setAWR(false);
					squad.target = getAttackTarget();
				}
			}
			
			if(squad.getUnits().isEmpty() == false){
				System.out.println("loaded or exist check");
				for(Unit unit : squad.getUnits()){
					if(unit.exists() == false || unit.isLoaded() == true){
						squad.removeUnit(unit);
					}
				}
			}
			
			if(squad.isAtTarget() == true){
				System.out.println("is at target");
				Position pos = getAttackTarget();
				if(pos != null){
					squad.newTarget(pos);
				}
				
			}
			
		
		}
	}
	
	
	
	
}

void squadUnitCheck(){
	if(this.myUnits.isEmpty() == false){
		for(Unit unit : myUnits){
			if(unitSquads.containsKey(unit) == true){
				for(Squad sq : Squads){
					if(sq.getUnits().contains(unit) == true && sq.getId() != unitSquads.get(unit)){
						sq.removeFromSquad(unit);
						Squad proper = Squads.get(unitSquads.get(unit));
						if(proper != null){
							proper.absorbUnit(unit);
							System.out.println("Fixed unit assigned to the wrong squad");
						}
					}
				}
			}
		}
	}
}


Unit getSquadUnit(Squad sq){
	if(sq.getUnits().isEmpty() == false){
		for(Unit unit : sq.getUnits()){
			if(unit.exists() == true){
				return unit;
			}
		}
	}
	
	return null;
}

boolean isARetreater(Unit unit){
	if(retreatingUnits.containsKey(unit) == true){
		return true;
	}
	return false;
}

boolean isInBQ(UnitType type){
	if(buildQueue.isEmpty() == true){
		return false;
	}
	
	for(buildQueue bq : buildQueue){
		if(bq.getType() == type){
			return true;
		}
	}
	
	return false;
}

buildQueue getBQWithType(UnitType type){
	if(buildQueue.isEmpty() == true){
		return null;
	}
	
	for(buildQueue bq : buildQueue){
		if(bq.getType() == type){
			return bq;
		}
	}
	
	return null;
}


int SquadsAverageDistTo(Squad squad, Position pos){
	int ffinal = 0;
	for(Unit unit : squad.getUnits()){
		int i = squad.getUnitSize();
		int o = 0;
		for(Unit units : squad.getUnits()){
			//o = o + units.getDistance(pos);
			o = o + unit.getPosition().getApproxDistance(pos);
		}
		ffinal = o / i;
	}
	return ffinal;
}

ArrayList<Chokepoint> getChokesNearby(Position pos, int range){
	ArrayList<Chokepoint> asf = new ArrayList<Chokepoint> ();
	for(Chokepoint cock : BWTA.getChokepoints()){
		if(cock.getDistance(pos) <= range && asf.contains(cock) == false){
			asf.add(cock);
		}
	}
	
	return asf;
}


void getSquadOrders(Unit myUnit){
	Squad sq = getSquad(myUnit);

	if(sq != null){
		Position retreat = sq.getRetreatPos();
		Position attack = sq.getTarget();
		int myScore = sq.getScore();
		int eScore = sq.getTargetScore();
		boolean asd = false;
		boolean isTank = false;
		if(myUnit.getType() == UnitType.Terran_Siege_Tank_Siege_Mode){
			isTank = true;
		}
		if(retreatingUnits.containsKey(myUnit) == true){
			asd = true;
		}
		
	if(sq.canFreeRoam() == false){
		if(sq.isRetreating() == true && myUnit.getPosition().getApproxDistance(retreat) > 150 && asd == false && isTank == false){
			myUnit.move(retreat);
		}
		
		if(sq.isAttacking() == true && myUnit.getPosition().getApproxDistance(attack) > 250 && asd == false && isTank == false){
			myUnit.attack(attack);
		}
		
		if(attacking == true && sq.isAttacking() == true){
			myUnit.attack(attack);
		}
		
		if(sq.isRetreating() == true && myUnit.getPosition().getApproxDistance(retreat) > 150 && asd == false && isTank == true){
			myUnit.unsiege();
		}
	}
	else {
		if(sq.isRetreating() == true && myUnit.getPosition().getApproxDistance(retreat) > 150 && asd == false && isTank == false){
			myUnit.move(retreat);
		}
		
		if(sq.isAttacking() == true && myUnit.getPosition().getApproxDistance(attack) > 250 && asd == false && isTank == false){
			myUnit.attack(attack);
		}
		
		if(sq.isAttacking() == true || sq.isDefending() == true){
			myUnit.attack(attack);
		}
		
		if(sq.isRetreating() == true && myUnit.getPosition().getApproxDistance(retreat) > 150 && asd == false && isTank == true){
			myUnit.unsiege();
		}
	}
	
	
	}
	
}
	
	
	
ArrayList<bwta.BaseLocation> buildBasesFromMap(){
	int max = enemyBases.size();
	ArrayList<bwta.BaseLocation> list = new ArrayList<bwta.BaseLocation>();
	for(BaseLocation bass : enemyBases.keySet()){
		list.add(bass);
	}
	
	return list;
}

boolean CanLeaveBase(){
	int o = 0;
	int max = enemyUnits.size();
	int ffinal = 0;
	for(Unit unit : enemyUnits){
		o = o + unit.getPosition().getApproxDistance(self.getStartLocation().toPosition());
	}
	ffinal = o / max;
	
	if(ffinal > 1200){
		return true;
	}
	else {
		return false;
	}
	
	
}

	
}
// end of bot class

	
	
