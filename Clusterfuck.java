
import java.lang.reflect.Constructor;		
import java.math.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.HashSet;
import java.util.Random;
import java.lang.*;
import bwapi.*;
import bwapi.Pair;
import bwta.BWTA;
import bwta.BaseLocation;
import jfap.*;
import javafx.util.*;

public class TestBot1 extends DefaultBWListener {

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
	private int SavingAntiFuck = 0;
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
	private int BatsNeed = 3;
	private int MedicsNeed = 4;
	private int AddNeeds = 0;
	private int Vultures = 0;
	private int VulturesMax = 7;
	private int Expand = 0;
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
	ArrayList<Unit> myUnits = new ArrayList<Unit>();
	ArrayList<Unit> myMinerals = new ArrayList<Unit>();
	ArrayList<Unit> gasWorkers = new ArrayList<Unit>();
	ArrayList<Unit> availableGas = new ArrayList<Unit>();
	ArrayList<Unit> constructingWorkers = new ArrayList<Unit>();
	ArrayList<Unit> myWorkers = new ArrayList<Unit>();
	ArrayList<Unit> myComSats = new ArrayList<Unit>();
	ArrayList<Unit> myMedics = new ArrayList<Unit>();
	ArrayList<Unit> productionBuildings = new ArrayList<Unit>();
	ArrayList<Unit> bunkersFilled = new ArrayList<Unit>();
	ArrayList<Unit> bunkerUnits = new ArrayList<Unit>();
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




	public void run() {
		mirror.getModule().setEventListener(this);
		mirror.startGame();
		
	}


	public void onUnitCreate(Unit unit) {
		boolean isMilitray = IsMilitrayUnit(unit);
		
		
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
			LastBunkerPos = unit.getTilePosition();
			bunkersBuilding = bunkersBuilding + 1;
			MarinesNeedBonus = 10;
		}

		if (unit.getType() == UnitType.Terran_SCV) {
			Workers = Workers + 1;
		}

		if (unit.getType() == UnitType.Terran_SCV && HasScoutUnit == false && hasAttackpos == false) {
			scouter = unit;
			HasScoutUnit = true;
			scoutID = scouter.getID();
		}

		if (unit.getType() == UnitType.Terran_Command_Center && unit.getPlayer() == self) {
			Position pos = unit.getPosition();
			lastExpandPos = unit.getTilePosition();
			LastExpandFrame = LastExpandFrame + 8000;
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
					
				
		}

		if (unit.getType() == UnitType.Terran_Command_Center && unit.getPlayer() == self) {
			Position pos = unit.getPosition();
			income = income + (int) (BWTA.getNearestBaseLocation(pos).getMinerals().size() * 2.5);
			MaxGases = MaxGases + BWTA.getNearestBaseLocation(pos).getGeysers().size();
			for (Unit minerals : BWTA.getNearestBaseLocation(pos).getMinerals()) {
				if (myMinerals.contains(minerals) == false) {
					myMinerals.add(minerals);
					//System.out.println("Adding mineral to claimed mineral's list with size of: " + myMinerals.size());
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
			MaxRacks = MaxRacks + 1;
			reserves = reserves - unit.getType().mineralPrice();
			buildwait = false;
			saving = false;
			
		}

		if (unit.getType() == UnitType.Terran_Armory && unit.getPlayer() == self) {
			MaxFactories = MaxFactories + 1;
			reserves = reserves - unit.getType().mineralPrice();
			reserves = reserves - unit.getType().gasPrice();
			buildwait = false;
			saving = false;
			MaxRacks = MaxRacks + 1;
		}
		if (unit.getType() == UnitType.Terran_Engineering_Bay && unit.getPlayer() == self) {
			BayCompleted = true;;
			reserves = reserves - unit.getType().mineralPrice();
			buildwait = false;
			saving = false;
		}
		if (unit.getType() == UnitType.Terran_Missile_Turret && unit.getPlayer() == self) {
			Turrets = Turrets + 1;
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
			reserves = reserves - unit.getType().mineralPrice();
			reserves = reserves - unit.getType().gasPrice();
			buildwait = false;
			saving = false;
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

		if (unit.getType() == UnitType.Terran_Firebat && unit.getPlayer() == self) {
			Bats = Bats + 1;
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
		
		
		if(unit.getType() == UnitType.Terran_Barracks ||
		unit.getType() == UnitType.Terran_Factory ||
		unit.getType() == UnitType.Terran_Starport
		&& productionBuildings.contains(unit) == false){
			productionBuildings.add(unit);
			
		}
		
		if(isMilitray == true){
			if(ralleyPoint != null){
				unit.attack(ralleyPoint);
			}
			
			if(ralleyPoint == null){
				ralleyPoint = BWTA.getNearestChokepoint(self.getStartLocation()).getCenter();
				unit.attack(ralleyPoint);
			}
		}
		
		if(unit.getType().isWorker() == true && myWorkers.contains(unit) == false){
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
		
		if(unit.getType() == UnitType.Terran_Bunker){
			bunkersBuilding = bunkersBuilding - 1;
		}

		
		if (unit.getPlayer() == self && myUnits.contains(unit) == false && unit.getType().isWorker() == false
				&& unit.getType().isBuilding() == false && unit.getType().isSpell() == false
				&& unit.getType() != UnitType.Terran_Vulture_Spider_Mine) {
			myUnits.add(unit);
			// game.sendText("Added " + unit.getType().toString() + " To myUnits
			// list with current size of " + myUnits.size());
			// System.out.println("Added " + unit.getType().toString() + " To
			// myUnits list with current size of " + myUnits.size());
		}

		if (unit.getType() == UnitType.Terran_Refinery && unit.getPlayer() == self) {
			int local = 1;
			Unit Gas;
			Gas = unit;
			for (Unit myUnits : self.getUnits()) {
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

		if (unit.getType() == UnitType.Terran_Bunker) {
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
			for (Unit myUnits : self.getUnits()) {
				if (local <= 6) {
					if (myUnits.getType() == UnitType.Terran_SCV && myUnits.isGatheringMinerals() == true) {
						myUnits.move(unit.getPosition());
						local = local + 1;
						if (local > 10) {
							break;
						}
					}
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
			
		}

		if (unit.getType() == UnitType.Terran_Factory && unit.getPlayer() == self) {
			Factories = Factories + 1;
			FactoriesBuilding = FactoriesBuilding - 1;
		}

		if (unit.getType() == UnitType.Terran_Starport && unit.getPlayer() == self) {
			StarPorts = StarPorts + 1;
		}

		if (unit.getType() == UnitType.Terran_Armory && unit.getPlayer() == self) {
			Armor = Armor + 1;
			MarinesNeedBonus = 100;
			MedicsNeed = 10;
			MaxFactories = MaxFactories + 2;
		}

		if (unit.getType() == UnitType.Terran_Science_Facility && unit.getPlayer() == self) {
			scienceFinished = true; 
			MaxFactories = MaxFactories + 2;
			MaxRacks = MaxRacks + 3;
		}

		if (unit.getType() == UnitType.Terran_Engineering_Bay && unit.getPlayer() == self) {
			Bays = 1;
		}

	}

	public void onUnitDestroy(Unit unit) {
		
		
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
		
		
		if(unit.getType().isFlyer() == true && unit.getPlayer() == game.enemy() && unit.getType().isBuilding() == false && unit.canAttack() == true && unit.getType() != UnitType.Protoss_Interceptor){
			AirThreat = AirThreat - 1;
		}

		
		if (enemyUnits.contains(unit) == true) {
			int index = enemyUnits.indexOf(unit);
			enemyUnits.remove(index);
			// game.sendText("Unit " + unit.getType().toString() + " is now removered from the enemyUnit's list with current size of " + enemyUnits.size());
		}

		if (myUnits.contains(unit) == true) {
			int index = myUnits.indexOf(unit);
			myUnits.remove(index);
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
			income = income - (int) 2.5;
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
		
		

		if (unit.getType() == UnitType.Terran_Command_Center && unit.getPlayer() == self) {
			Position pos = unit.getPosition();
			Bases = Bases - 1;	
			income = income - (int) (BWTA.getNearestBaseLocation(pos).getMinerals().size() * 2.5);
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
			if (target.getType() == UnitType.Terran_Command_Center) {
				expanding = false;
				saving = true;
			}
		}
		
		if (unit.getType() == UnitType.Terran_Goliath && unit.getPlayer() == self) {
			Gol = Gol - 1;
		}

	}

	public void onUnitDiscover(Unit unit) {
		boolean ismil = IsMilitrayUnit(unit);
		//System.out.println("Is hostile? " + unit.getPlayer().isEnemy(self));
		//System.out.println("Is Mil" + ismil + " Unit: " + unit.getType().toString());

		if (unit.getPlayer().isEnemy(self) == true && enemyUnits.contains(unit) == false && ismil == true) {
			enemyUnits.add(unit);
	}
		
		if(unit.getType().isFlyer() == true && unit.getPlayer() == game.enemy() && unit.getType().isBuilding() == false && unit.canAttack() == true && unit.getType() != UnitType.Protoss_Interceptor){
			AirThreat = AirThreat + 1;
		}



		if (unit.getType() == UnitType.Terran_Barracks && unit.getPlayer().isEnemy(self)) {
			GroundThreat = GroundThreat + 2;
			enemyRace = 1;
		}


		if (unit.getType() == UnitType.Protoss_Gateway && unit.getPlayer().isEnemy(self)) {
			enemyBasePos = unit.getPosition();
			GroundThreat = GroundThreat + 4;

		}

		if (unit.getType() == UnitType.Terran_Starport && unit.getPlayer().isEnemy(self)) {
			enemyBasePos = unit.getPosition();
			AirThreat = AirThreat + 1;

		}


		if (unit.getType() == UnitType.Protoss_Stargate && unit.getPlayer().isEnemy(self)) {
			enemyBasePos = unit.getPosition();
			AirThreat = AirThreat + 4;

		}


		if (unit.getType() == UnitType.Terran_Factory && unit.getPlayer().isEnemy(self)) {
			GroundThreat = GroundThreat + 2;
			enemyRace = 1;
		}

		if (unit.getType() == UnitType.Protoss_Gateway && unit.getPlayer().isEnemy(self)) {
			enemyRace = 2;
		}

		if (unit.getType() == UnitType.Zerg_Hatchery && unit.getPlayer().isEnemy(self)) {
			hasAttackpos = true;
			enemyBasePos = unit.getPosition();
			enemyRace = 3;
			GroundThreat = GroundThreat + 2;
		}
		if (unit.getType() == UnitType.Terran_Command_Center && unit.getPlayer().isEnemy(self)) {
			hasAttackpos = true;
			enemyBasePos = unit.getPosition();
			enemyRace = 1;
		}
		if (unit.getType() == UnitType.Protoss_Nexus && unit.getPlayer().isEnemy(self)) {
			hasAttackpos = true;
			enemyBasePos = unit.getPosition();
			enemyRace = 2;
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
		game.setLocalSpeed(GameSpeed);
		Strategy = GetStrategy(game.enemy().getRace().toString());
		// getExpands();
		BaseLocation = BWTA.getNearestBaseLocation(BasePos);
	
	}

	public static Color Wlue;
	{
		Wlue = Color.Blue;
	}

	public static Color Wed;
	{
		Wed = Color.Red;
	}

	@Override
	public void onFrame() {
		AMPS = (int) (Workers * 2);
		MPS = (int) (AMPS * 0.14);
		GPS = Gases * 3;
		MaxGol = 3 + (AirThreat * 2);
		MaxWorkers = Bases * 16;
		VulturesMax = (Tanks * 2) + 6;
		MedicsNeed = MarinesNeed / 4;
		MarinesNeed = 5 + (Bunks * 4) + (GroundThreat * 2) + (Tanks * 5) + MarinesNeedBonus;
		Tick = Tick + 1;
		buildingTick = buildingTick + 1;
		AddNeeds = AddNeeds + 1;
		needs = (Factories * 10) + (Racks * 15);
		APM = game.getAPM();
		claimedBaseLocations.add(BWTA.getNearestBaseLocation(self.getStartLocation()));
		game.enableFlag(1);
		// game.setTextSize(10);`
		game.drawTextScreen(10, 10, "Playing as " + self.getName() + " - " + self.getRace() + " And with.. " + APM
				+ " APM" + " With.." + game.getAverageFPS() + "FPS");
		game.drawTextScreen(10, 20, "I have " + Bases + " Bases and i have " + Factories + " Factories"
				+ " And i have.. " + " " + myUnits.size() + "Militray units.");
		game.drawTextScreen(10, 30, Tick + " Ticks" + " Total Frames " + totalFrames);
		game.drawTextScreen(10, 40, "Enemy Ground Threat.. " + GroundThreat + " And Air Threat... " + AirThreat);
		game.drawTextScreen(10, 50, +Gases + "  " + MaxGases + " " + " " + Bunks + " " + supplyBuilding + " "
				+ attacking + " " + buildwait + " " + reserves + " " + reservesgas + " " + bwub);
		game.drawTextScreen(10, 60,
				"Attack Point is.." + enemyBasePos + " " + hasAttackpos + " EnemyUnits: " + enemyUnits.size() + " Last Regroup At: " + RegroupPos);
		game.drawTextScreen(10, 70,
				"Expanding is : " + expanding + " and is being placed? " + ExpandPlacing + " Last Expand was at: "
						+ lastExpandPos + " current expand pos " + ExpandPos + " income: " + income + " " + needs
						+ " needs: ");
		game.drawTextScreen(10,80, "Versing " + game.enemy().getName() + " as "  + game.enemy().getRace() + " ");
		game.drawTextScreen(10, 90, "" + game.getLatencyFrames() + " " + LastBuildTick);
		game.drawTextScreen(10, 100, "Strategy: " + Strats + " " + " Frames: " + updateStrategy);
		
		

//		if (game.getFrameCount() % game.getLatencyFrames() != 0) {
			
			totalFrames = totalFrames + 1;
			updateStrategy = updateStrategy + 1;
			canExpandCheck = canExpandCheck + 1;

			if (supplyBuilding < 0) {
				supplyBuilding = 0;
			}
			
			if (attacking == true) {
				Mines = Mines + 1;
			}
			
			if(expanding == true){
				expandFrames = expandFrames + 1;
			}

			if (buildingTick > 30) {
				buildingTick = 0;
			}
			
			if(MaxWorkers > 56){
				MaxWorkers = 56;
			}
			
			if(saving == true && LastBuildTick == 0){
				saving = false;
			}
			
			
//			if(saving == true && self.minerals() > 2000 && self.gas() > 500){
//				saving = false;
//				buildwait = false;
//			}

			if (hasAttackpos == false && enemyBuildingMemory.isEmpty() == false) {
				hasAttackpos = true;
			}
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
				game.drawCircleMap(LastBuild.toPosition(), 25, Color.Cyan, false);
				game.drawCircleMap(NewBuild.toPosition(), 25, Color.Cyan, false);
			}
			

			if (scouter.isVisible() == true) {
				Position pos = scouter.getPoint();
				game.drawCircleMap(pos, 25, Color.Purple, false);
			}

			if (expanding == true && CCBuilder.exists() == true) {
				Position pos = CCBuilder.getPoint();
				game.drawCircleMap(pos, 25, Color.White, false);
			}

			if (income < needs && ExpandEnabled == true && myUnits.size() > 15 && LastExpandFrame < totalFrames){
				saving = true;
				if(needsToExpand == false){
					needsToExpand = true;
				}
			}
			
			if(RegroupPos != null){
				game.drawCircleMap(RegroupPos, 35, Color.Red, true);
			}
			
			if(defenderCall == false){
				defenceCallFrames = defenceCallFrames + 1;
			}
			
			if(defenceCallFrames >= 55){
				defenceCallFrames = 0;
				defenderCall = true;
			}
			
			if(simCallFrames != 0){
				simCallFrames = simCallFrames + 1;
			}
			
			if(simCallFrames > 15){
				simCallFrames = 0;
			}
			
			if(enemyFrames > 30){
				enemyFrames = 1;
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
			
			if(updateStrategy >= 1000){
				UpdateStrats();
				updateStrategy = 0;
			}

			// repairs list
			
			
			if (saving == true && self.minerals() >= 700 && self.gas() >= 300){
				
				for (Unit buildings : productionBuildings) {
					// best way to get the bot to build after its build
					// frozen is probably max the supply and let it spam.
					
					if (buildings.getType() == UnitType.Terran_Factory && self.minerals() >= 600
							&& self.gas() >= 300 && buildings.isIdle() == true) {
						buildings.train(UnitType.Terran_Siege_Tank_Tank_Mode);
					}
					if (buildings.getType() == UnitType.Terran_Barracks && self.minerals() >= 700
							 && AcademyBuilt == true && buildings.isIdle() == true) {
						
							if(DifBuild == 1){
								buildings.train(UnitType.Terran_Marine);
								DifBuild = DifBuild + 1;
							}
							
							if(DifBuild == 2){
								buildings.train(UnitType.Terran_Marine);
								DifBuild = DifBuild + 1;
							}
							if(DifBuild == 3){
								buildings.train(UnitType.Terran_Marine);
								DifBuild = DifBuild + 1;
							}
							if(DifBuild == 4){
								buildings.train(UnitType.Terran_Medic);
								DifBuild = DifBuild + 1;
							}

				



					}

					if (buildings.getType() == UnitType.Terran_Barracks && self.minerals() >= 700 && self.gas() >= 300
							 && AcademyBuilt == true && buildings.isIdle() == true) {
						buildings.train(UnitType.Terran_Medic);
					}
					
					if (buildings.getType() == UnitType.Terran_Starport && game.canMake(UnitType.Terran_Battlecruiser) == true && self.minerals() >= 700 && self.gas() >= 300 && buildings.isIdle() == true) {
						buildings.train(UnitType.Terran_Battlecruiser);
				}

				}

			}
			
			
//			if (Tick > (8500 - (attackNum * 1000)) && attacking == false) {
//				//timed attacked
//				if(attackNum == 0){
//					attacking = false;
//				}
//				
//				buildwait = false;
//				Mines = 0;
//				attackNum = attackNum + 1;
//				orderRetreat = false;
//				Tick = 0;
//				JFAP simulator = new JFAP(game); 
//				simulator.clear();
//				Pair<Integer, Integer> preSimScores = simulator.playerScores();
//				int preSimFriendlyUnitCount = simulator.getState().first.size();
//
//				
//				for(Unit unit : myUnits){
//					simulator.addUnitPlayer1(new JFAPUnit(unit)); 
//				}
//				
//				for(Unit unit : enemyUnits){
//					simulator.addUnitPlayer2(new JFAPUnit(unit)); 
//				}
//				simulator.simulate(50);
//					Pair<Integer, Integer> postSimScores = simulator.playerScores();
//					int postSimFriendlyUnitCount = simulator.getState().first.size();
//					int myLosses = preSimFriendlyUnitCount - postSimFriendlyUnitCount;
//					int myScoreDiff = preSimScores.first - postSimScores.first;
//					int enemyScoreDiff = preSimScores.second - postSimScores.second;
//					//System.out.println("Me : " + Math.abs(myScoreDiff));
//					//System.out.println("Enemy : " + Math.abs(enemyScoreDiff));
//					
//					if (Math.abs(myScoreDiff) >= Math.abs(enemyScoreDiff)) {
//						attacking = true;
//						game.sendText("I could probably lose the game here if i attack.. Let's do it");
//					} 
//					else{
//						attacking = false;
//						game.sendText("Our merciful lord, jFap has requested that there shall not be any attacks today.");
//						
//					}
//						
//				
//
//				if (attackNum > 4) {
//					attackNum = 4;
//				}
//
//				if (factorybuilding < 0) {
//					factorybuilding = 0;
//				}
//
//				if (needs >= income && ExpandEnabled == true && Bases <= MaxBases) {
//					saving = true;
//					needsToExpand = true;
//
//				}
//				
//				if(attacking == true){
//
//				for (Unit Attackers : myUnits) {
//			
//					boolean isAMoving = IsAttackMoving(Attackers);
//					boolean isMilitray2 = IsMilitrayUnit(Attackers);
//					
//			
//
//					if (enemyBuildingMemory.isEmpty() == false) {
//						game.sendText("Attacking, remembered locations");
//						for (Position P : enemyBuildingMemory) {
//							if (isMilitray2 == true && isAMoving == false || Attackers.isAttacking() == false) {
//								boolean isStacking = orderStacking(Attackers, P);
//								boolean busy = IsABusy(Attackers);
//								if(isStacking == false && busy == false){
//									Attackers.attack(P);
//								}
//								
//								
//							}
//						}
//					} else {
//						game.sendText("No remembered locations, attacking all base locations.");
//						for (BaseLocation b : BWTA.getBaseLocations()) {
//							if (b.getPoint().isValid() == true && game.isVisible(b.getTilePosition()) == false) {
//								for (Unit Attackers2 : myUnits) {
//									boolean isMilitray3 = IsMilitrayUnit(Attackers2);
//										if (isMilitray3 == true && isAMoving == false || Attackers.isAttacking() == false) {
//											boolean isStacking = orderStacking(Attackers2, b.getPoint());
//											boolean busy = IsABusy(Attackers2);
//											if(isStacking == false && busy == false){
//												Attackers2.attack(b.getPoint());
//											}
//							
//										}
//									}
//							}
//						}
//
//					}
//				}
//
//			}
//		}
		
			for(BaseLocation bases : BWTA.getBaseLocations()){
				
				if(game.isVisible(bases.getTilePosition()) == true 
				&& game.canBuildHere(bases.getTilePosition(), UnitType.Terran_Command_Center) == true
				&& claimedBaseLocations.contains(bases) == true && bases.getTilePosition() != self.getStartLocation() && expanding == false){
					claimedBaseLocations.remove(bases);
					game.sendText("OIL DETECTED AT " + bases.getTilePosition() + " Deploying US forces");
					
					
				}
			}

			if (Mines > 300) {
				Mines = 0;
			}

			if (DifBuild > 4) {
				DifBuild = 1;
			}
			

			if (isExpanding == true) {
				game.drawCircleMap(ExpandPos.toPosition(), 25, Color.Cyan, false);
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
			
			if(self.minerals() > 2000 && self.gas() > 800 && saving == true){
				saving = false;
			}
			
			
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
					game.drawCircleMap(macrobuilder.getPosition(), 10, Color.Yellow);
					game.drawTextMap(macrobuilder.getPosition(), "Communist Sympathiser");
					
				}
			}
			
			
			
			

			if (self.minerals() >= 400 && ExpandEnabled == true && income <	needs && needsToExpand == true && expanding == false && Bases <= MaxBases && canExpandCheck > 300 && totalFrames > LastExpandFrame) {
				boolean canExpand = CanExpand();
				canExpandCheck = 0;
				if(canExpand == true){
				game.sendText("Expanding");
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

			if (saving == false && buildwait == false && expanding == false && buildingTick == 20) {
				buildingTick = 0;
				


				if (self.minerals() >= 100 && (Bunks + bunkersBuilding) <= 1 + Math.round(GroundThreat / 4) && AcademyFinshed == true && isExpanding == false
						&& saving == false && BunkerStarted == false) {
					SavingAntiFuck = Tick + 200;
					buildWaitFix = buildWaitFix + 200;
					Unit myUnit = GetWorker();	
					if(myUnit != null){
					TilePosition bunkertile = BWTA.getNearestChokepoint(BasePos).getPoint().toTilePosition();
					TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Bunker, bunkertile);
					if (buildTile != null && myUnit != null) {
						saving = true;
						myUnit.build(UnitType.Terran_Bunker, buildTile);
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

				if (self.minerals() >= 100 && Gases < MaxGases && isExpanding == false && buildwait == false
						&& saving == false && Racks > 0) {
					Unit myUnit = GetWorker();
					TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Refinery, self.getStartLocation());
					if (buildTile != null) {
						if(constructingWorkers.contains(myUnit) == false){
						constructingWorkers.add(myUnit);
						}
						myUnit.build(UnitType.Terran_Refinery, buildTile);
						if(LastBuildTick == 0){
							LastBuildTick = totalFrames + 100;
						}
					}
				}
				
				if (self.minerals() >= 100 && supplyBuilding <= SupplyDepotsMax && saving == false
						&& RacksBuilding + Racks > 1 && (self.supplyTotal() - self.supplyUsed()) < 3
						|| self.supplyUsed() > self.supplyTotal()) {

					boolean killing = false;
					 SavingAntiFuck = Tick + 200;
					 buildWaitFix = buildWaitFix + 200;
					Unit myUnit = GetWorker();
					if(myUnit == null){
						saving = false;
						game.sendText("FBI tracer detected, deleteing webcam drivers and running incognito mode");
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
						if(constructingWorkers.contains(myUnit) == false){
						constructingWorkers.add(myUnit);
						}
						game.drawCircleMap(buildTile.toPosition(), 10, Color.Yellow, false);
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
				if (Racks + RacksBuilding <= MaxRacks - 1 && self.minerals() >= 150 && saving == false) {
					// SavingAntiFuck = Tick + 200;
					// buildWaitFix = buildWaitFix + 200;
					Unit myUnit = GetWorker();
					if(myUnit != null){
					TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Barracks, myUnit.getTilePosition());
					if (buildTile != null && myUnit != null) {
						saving = true;
						myUnit.build(UnitType.Terran_Barracks, buildTile);
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
				
				if (self.minerals() >= 700 && expanding == false) {
					// SavingAntiFuck = Tick + 200;
					// buildWaitFix = buildWaitFix + 200;
					Unit myUnit = GetWorker();
					if(myUnit != null){
					TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Barracks, myUnit.getTilePosition());
					if (buildTile != null && myUnit != null) {
						saving = true;
						myUnit.build(UnitType.Terran_Barracks, buildTile);
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
				

				if ((Factories + FactoriesBuilding) < MaxFactories && self.minerals() >= 200 && self.gas() >= 150 && Bunks > 0
						&& saving == false && Bays > 0) {
					SavingAntiFuck = Tick + 200;
					buildWaitFix = buildWaitFix + 200;
					Unit myUnit = GetWorker();
					if(myUnit != null){
					TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Factory, myUnit.getTilePosition());
					if (buildTile != null && myUnit != null) {
						saving = true;
						myUnit.build(UnitType.Terran_Factory, buildTile);
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
				if (Factories > 0 && self.minerals() >= 100 && self.gas() >= 50 && Armor == 0 && saving == false
						&& buildwait == false && buildingArmor == false && scienceStarted == true) {
					Unit myUnit = GetWorker();
					if(myUnit != null){
					TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Armory, self.getStartLocation());
					if (buildTile != null && myUnit != null) {
						saving = true;
						myUnit.build(UnitType.Terran_Armory, buildTile);
						if(constructingWorkers.contains(myUnit) == false){
						constructingWorkers.add(myUnit);
						}
						buildingArmor = true;
						if(LastBuildTick == 0){
							LastBuildTick = totalFrames + 100;
						}
						

					}
					else {
						saving = false;
					}

				}
			}

				if (self.minerals() >= 150 && isExpanding == false && AcademyBuilt == false && saving == false && Racks > 0) {
					// SavingAntiFuck = Tick + 200;
					// buildWaitFix = buildWaitFix + 200;
					Unit myUnit = GetWorker();
					if(myUnit != null){
					TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Academy, self.getStartLocation());
					if (buildTile != null && myUnit != null) {
						saving = true;
						myUnit.build(UnitType.Terran_Academy, buildTile);
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
				if (BayCompleted == false && self.minerals() > 125 && buildwait == false && saving == false && AcademyFinshed == true) {
					 SavingAntiFuck = Tick + 200;
					 buildWaitFix = buildWaitFix + 200;
					Unit myUnit = GetWorker();
					if(myUnit != null){
					TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Engineering_Bay, self.getStartLocation());
					if (buildTile != null && myUnit != null) {
						saving = true;
						myUnit.build(UnitType.Terran_Engineering_Bay, buildTile);
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
			if (self.minerals() > 75 && AirThreat > 0 && Turrets <= (AirThreat * 4) && BayCompleted == true && buildwait == false && saving == false) {
					SavingAntiFuck = Tick + 200;
					buildWaitFix = buildWaitFix + 200;
					Unit myUnit = GetWorker();
					if(myUnit != null){
					TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Missile_Turret, self.getStartLocation());
					if (buildTile != null && myUnit != null) {
					saving = true;
					myUnit.build(UnitType.Terran_Missile_Turret, buildTile);
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
			
			if (self.minerals() > 75 && startedDet == false && BayCompleted == true && saving == false) {
				Unit myUnit = GetWorker();
				if(myUnit != null){
				TilePosition buildTile = getMissileTile(myUnit, UnitType.Terran_Missile_Turret, MainChoke.toTilePosition());
				if (buildTile != null && myUnit != null) {
				saving = true;
				startedDet = true;
				myUnit.build(UnitType.Terran_Missile_Turret, buildTile);
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
			


				
			
			//This supply script is for building system lock up. 

			if ((PortsBuilding + StarPorts) == 0 && self.minerals() > 150 && self.gas() > 100 && buildwait == false && saving == false && Factories > 0) {
	
				 SavingAntiFuck = Tick + 200;
				 buildWaitFix = buildWaitFix + 200;
				Unit myUnit = GetWorker();
				if(myUnit != null){
				TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Starport, self.getStartLocation());
				if (buildTile != null && myUnit != null) {
					saving = true;
					myUnit.build(UnitType.Terran_Starport, buildTile);
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
			
			if (scienceStarted == false && self.minerals() > 100 && self.gas() > 150 && buildwait == false && saving == false && StarPorts > 0){
				Unit myUnit = GetWorker();
				if(myUnit != null){
				TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Science_Facility, self.getStartLocation());
				if (buildTile != null && myUnit != null) {
					saving = true;
					scienceStarted = true;
					myUnit.build(UnitType.Terran_Science_Facility, buildTile);
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
			

			// end of building script

		}
			
//			if (self.minerals() >= 1000 && self.supplyTotal() == self.supplyUsed()) {
//				 SavingAntiFuck = Tick + 200;
//				 buildWaitFix = buildWaitFix + 200;
//				Unit myUnit = GetWorker();
//				if(myUnit != null){
//				TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Supply_Depot, myUnit.getTilePosition());
//				if (buildTile != null && buildTile.isValid() == true && myUnit.exists() == true) {
//					myUnit.build(UnitType.Terran_Supply_Depot, buildTile);
//					if(constructingWorkers.contains(myUnit) == false){
//					constructingWorkers.add(myUnit);
//					}
//					game.drawCircleMap(buildTile.toPosition(), 10, Color.Yellow, false);
//					if(LastBuildTick == 0){
//					LastBuildTick = totalFrames + 100;
//					}
//
//
//			}
//				else {
//					saving = false;
//				}
//		}
//	}
			
			
			if(Bats >= BatsNeed && DifBuild == 4){	
				DifBuild = 1;
			}
			
			if(Medics >= MedicsNeed && DifBuild == 3){
				DifBuild = 1;
			}
			
			if(DifBuild > DifBuildMax){
				DifBuild = 1;
			}
			
			
			if(ralleyPoint != null){
				game.drawCircleMap(ralleyPoint, 100, Color.Green);
			}
			
			
			for (Unit cloak : enemyUnits) {
				boolean asdf = IsMilitrayUnit(cloak);
				

				if (cloak.isAttackFrame() == true && cloak.isBurrowed() == true) {
					Unit unit = cloak;
					for (Unit detectors : myComSats) {
						if (detectors.getType() == UnitType.Terran_Comsat_Station && detectors.getEnergy() >= 50) {
							detectors.useTech(TechType.Scanner_Sweep, unit.getPosition());
							break;

						}
					}
				}

				if (cloak.isAttackFrame() == true && cloak.isCloaked() == true) {
					Unit unit = cloak;
					for (Unit detectors : myComSats) {
						if (detectors.getType() == UnitType.Terran_Comsat_Station && detectors.getEnergy() >= 50) {
							detectors.useTech(TechType.Scanner_Sweep, unit.getPosition());
							break;

						}
					}
				}

			}
			
			
			
			
			
			

			for (Unit myUnit : self.getUnits()) {
				
				if(myUnit.isStartingAttack() || myUnit.isAttacking() == true){
					ThinkUnit(myUnit);
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
					game.sendText("wget www.ifBot.weebly.com/src/ShitBot/Lab.midi -OutFile D:/danface.txt");
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

					if (myUnit.getType() == UnitType.Terran_Command_Center && self.minerals() >= 50
							&& Workers < MaxWorkers && myUnit.isIdle() == true) {
						myUnit.train(UnitType.Terran_SCV);
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
					


					if (myUnit.getType() == UnitType.Terran_Factory && self.minerals() >= 100 && self.gas() >= 50
							&& Gol <= MaxGol && myUnit.isIdle() == true && Armor > 0) {
						myUnit.train(UnitType.Terran_Goliath);
						Gol = Gol + 1;

					}

					if (myUnit.getType() == UnitType.Terran_Factory && self.minerals() >= 150 && self.gas() >= 100
							&& myUnit.isIdle() == true) {
						myUnit.train(UnitType.Terran_Siege_Tank_Tank_Mode);
					}

					if (myUnit.getType() == UnitType.Terran_Machine_Shop && self.minerals() >= 200 && self.gas() >= 200
							&& myUnit.isIdle() == true && myUnit.canResearch(TechType.Tank_Siege_Mode, true)) {
						myUnit.research(TechType.Tank_Siege_Mode);

					}
					
//					if (myUnit.getType() == UnitType.Terran_Factory && self.minerals() >= 80 && Vultures < VulturesMax
//							&& myUnit.isIdle() == true) {
//							myUnit.train(UnitType.Terran_Vulture);
//					}
					
					if (myUnit.getType() == UnitType.Terran_Starport && scienceFinished == true && self.minerals() >= 100 && self.gas() > 225 && TSF <= detectionNeeded
							&& myUnit.isIdle() == true) {
							myUnit.train(UnitType.Terran_Science_Vessel);
					}
					
					if (myUnit.getType() == UnitType.Terran_Starport && game.canMake(UnitType.Terran_Battlecruiser) == true && myUnit.isIdle() == true) {
							myUnit.train(UnitType.Terran_Battlecruiser);
					}

					if (myUnit.getType() == UnitType.Terran_Machine_Shop && self.minerals() >= 200 && self.gas() >= 100
							&& myUnit.isIdle() == true && myUnit.canResearch(TechType.Spider_Mines, true)) {
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
					
					
					// upgrades

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
				
				//ralleypoint code rapes apm(for some reason)
				
				
//				if(myUnit.getType() == UnitType.Terran_Factory && ralleyPoint != null && myUnit.getRallyPosition() != ralleyPoint) {
//				myUnit.setRallyPoint(ralleyPoint);
//				}
//				
//				if(myUnit.getType() == UnitType.Terran_Factory && ralleyPoint != null && myUnit.getRallyPosition() != ralleyPoint) {
//					myUnit.setRallyPoint(ralleyPoint);
//				}
//				
				
				if(myUnit.exists() && myUnits.contains(myUnit) == true){
					myUnits.remove(myUnit);
				}
				



				if (myUnit.getType() == UnitType.Terran_Bunker && myUnit.isBeingConstructed() == false && bunkersFilled.contains(myUnit) == false && myUnit.getLoadedUnits().size() != 4) {
					int need = 4 -  myUnit.getLoadedUnits().size();
					int amount = 0;
					for (Unit bunks : myUnits) {
						if (amount <= need && need != 0) {
							if (bunks.isIdle() == true && bunks.getType() == UnitType.Terran_Marine && bunks.isCompleted() == true) {
									myUnit.load(bunks);
									myUnits.remove(bunks);
									amount = amount + 1;
							}
						}
					}
					
					
				}
				
				if(myUnit.getOrder() == Order.EnterTransport && myUnit.getOrderTarget().getLoadedUnits().size() == 4){
					myUnit.stop();
					 System.out.println("Stop");
					if(myUnits.contains(myUnit) == false){
						 System.out.println("Re adding");
						myUnits.add(myUnit);
					}
				}
				
				if(myUnit.getType() == UnitType.Terran_Bunker && myUnit.getLoadedUnits().size() == 4 && bunkersFilled.contains(myUnit) == false){
					bunkersFilled.add(myUnit);
					
					for(Unit units : myUnit.getLoadedUnits()){
						if(bunkerUnits.contains(units) == false){
							bunkerUnits.add(units);
						}
					}
					
				}
				
				if(bunkersFilled.contains(myUnit) == true){
					game.drawCircleMap(myUnit.getPosition(), 100, Color.Purple);
				}

				
				if (myUnit.getType() == UnitType.Terran_Siege_Tank_Tank_Mode && myUnit.canSiege() == false
						&& myUnit.isAttacking() == true || myUnit.isUnderAttack()) {
					game.drawCircleMap(myUnit.getPosition(), 20, Color.Purple);
				}
				
				
				

				if (myUnit.getType() == UnitType.Terran_Siege_Tank_Siege_Mode && myUnit.isSieged() == true && myUnit.isIdle() == true) {
					boolean hostiles = false;
					for (Unit targets : myUnit.getUnitsInRadius(300)) {
						if (targets.getPlayer().isEnemy(self) && myUnit.canAttack(targets) == true) {
							hostiles = true;
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



				if (myUnit.isIdle() && attacking == true && myUnit.getType().isWorker() == false) {
					if (enemyBuildingMemory.isEmpty() == false) {
						for (Position P : enemyBuildingMemory) {
							myUnit.attack(P, true);
						}
					} else {
						for (BaseLocation b : BWTA.getBaseLocations()) {
							if (b.getPoint().isValid() == true && game.isVisible(b.getTilePosition()) == false) {
								myUnit.attack(b.getPosition(), true);
							}
						}
					}

					if (attacking == false && myUnit.isAttacking() == true && orderRetreat == false) {
						myUnit.attack(BasePos.toPosition(), false);
						orderRetreat = true;
					}

				}

				if (myUnit.isConstructing() == true) {
					Position pos = myUnit.getPosition();
					game.drawCircleMap(pos, 20, Color.Brown);

				}
				
				//science vesseles
				
				
				if(myUnit.getType() == UnitType.Terran_Science_Vessel && myUnit.isIdle()){
					for(Unit unit : myUnits){
						if(unit.isAttacking() == true || unit.isAttackFrame() == true){
							Position pos = unit.getPosition();
							if(pos != null){
								myUnit.move(pos);
							}
						}
					}
				}



				// combat sim
				
				

				if (simEnabled == true && myUnit.isUnderAttack() == true && myUnit.getType().isBuilding() == false && simCallFrames == 0) {
					boolean noRetreat = false;
					//System.out.println("Combat sim called at: " + totalFrames);
					simCallFrames = 1;
					if(myUnit.getDistance(BasePos.toPosition()) < 300){
						noRetreat = true;
					}
					
					
					boolean hasEnemyPos = false;
					Unit Enemy = null;
					// jFap and underestimate units some times. So im giving it abit of a boost to score.;
					JFAP simulator = new JFAP(game);
					simulator.clear();
					Pair<Integer, Integer> preSimScores = simulator.playerScores();
					int preSimFriendlyUnitCount = simulator.getState().first.size();
					simulator.simulate(15);
					//int regionbonus = (game.getRegionAt(myUnit.getPosition()).getDefensePriority() / 3);
					
					for (Unit targets : myUnit.getUnitsInRadius(200)) {
						
						int damage = targets.getType().groundWeapon().damageAmount() + targets.getType().airWeapon().damageAmount();
						
						if (targets.getPlayer().isEnemy(self) && damage > 0) {
							simulator.addUnitPlayer2(new JFAPUnit(targets)); // Adds an enemy unit to the simulator
							
							if(hasEnemyPos == false) {
							hasEnemyPos = true;
							Enemy = targets;
							}
							
						}
						if (targets.getPlayer().isAlly(self) && damage > 0) {
							simulator.addUnitPlayer1(new JFAPUnit(targets)); // Adds an enemy unit to the simulator
						}
						
						// >terran player
						// >forgetting about bunkers
						// >danface.jpg
	
					}
					Pair<Integer, Integer> postSimScores = simulator.playerScores();
					int postSimFriendlyUnitCount = simulator.getState().first.size();
					int myLosses = preSimFriendlyUnitCount - postSimFriendlyUnitCount;
					int myScoreDiff = preSimScores.first - postSimScores.first;
					int enemyScoreDiff = preSimScores.second - postSimScores.second;
					//System.out.println("Me : " + myScoreDiff);
					//System.out.println("Enemy : " + enemyScoreDiff);
					// if we can win
					if (postSimScores.first >= postSimScores.second ) {
						
					} 
					// if we cant
					else {
						if(Enemy != null && noRetreat == false){
						Position regroup = GetJukePos2(myUnit, Enemy);
						if(regroup != null){
							for(Unit unitss : myUnit.getUnitsInRadius(300)){
								if(unitss.getType() == UnitType.Terran_Siege_Tank_Siege_Mode && unitss.canUnsiege() == true){
									unitss.unsiege();
								}
								if(unitss.isMoving() == false && regroup != null && regroup.isValid() == true){
									unitss.move(regroup);
								}
							}
						}
					}

				}
			}
				
				
				
			// end of combat sim
					
				//for all units


				if (attacking == true && myUnit.getType().isWorker() == false && myUnit.isIdle() == true) {
					Position LastOrder = myUnit.getOrderTargetPosition();
					for (Unit unitss : self.getUnits()) {
						boolean isAMoving = IsAttackMoving(unitss);
						boolean isBusy = IsABusy(unitss);
						if (unitss.isAttacking() == true) {
							Position pos = unitss.getTarget().getPosition();
							if (isBusy == false) {
								boolean isStacking = orderStacking(myUnit, unitss.getPosition());
								if(isStacking == false){	
									myUnit.attack(pos);
									myUnit.attack(LastOrder, true);
								}

							}
						}
					}
				}

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

				if (scouter.isUnderAttack() == true) {
					TilePosition pos = self.getStartLocation();
					if(scouter.getOrderTargetPosition() != pos.toPosition()){
						scouter.move(pos.getPoint().toPosition(), false);
					}
					
					
				}



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
					TilePosition LandLocation = getLandLocation(myUnit, self.getStartLocation());
					if (myUnit.canLand(LandLocation) == true) {
						myUnit.land(LandLocation);
					} else {
						
					}
				}



				if (myUnit.isUnderAttack() == true && myUnit.getType() == UnitType.Terran_Marine
						|| myUnit.getType() == UnitType.Terran_Firebat) {
					for (Unit medics : myMedics) {
						if (medics.getType() == UnitType.Terran_Medic && medics.getEnergy() > 5  && medics.isMoving() == true
								|| medics.isIdle() == true) {
							medics.useTech(TechType.Healing, myUnit);
						}

					}

				}



				//if (myUnit.isAttacking() == true) {
				//	Unit target = myUnit.getOrderTarget();
					//if (target != null && target.isBeingHealed() == true) {
						//for (Unit medics : game.getUnitsInRadius(target.getPosition(), 50)) {
							//if (medics.getLastCommand() == UnitCommand.useTech(target, TechType.Healing) == true) {
								//if (myUnit.canAttack(medics) == true) {
								//	myUnit.attack(medics);
								//}
						//	}
						//}//
					//}
			//	}
				
				//To stop the bot freezing
				//defence
				//defence
				//defenceFrames
				//defenceCallFrames
				//
				

				
				if (myUnit.getType() == UnitType.Terran_Factory
						&& myUnit.canBuild(UnitType.Terran_Machine_Shop, true)) {
					myUnit.buildAddon(UnitType.Terran_Machine_Shop);
				}
				
				if (myUnit.getType() == UnitType.Terran_Starport && myUnit.canBuild(UnitType.Terran_Control_Tower, true)) {
					myUnit.buildAddon(UnitType.Terran_Control_Tower);
				}
				
				if (myUnit.getType() == UnitType.Terran_Science_Facility
						&& myUnit.canBuild(UnitType.Terran_Physics_Lab, true)) {
					myUnit.buildAddon(UnitType.Terran_Physics_Lab);
					BCTech = true;
					
				}

				if (myUnit.getType() == UnitType.Terran_Command_Center
						&& myUnit.canBuild(UnitType.Terran_Comsat_Station, true)) {
					myUnit.buildAddon(UnitType.Terran_Comsat_Station);
				}
 
				// if(myUnit.equals(CCBuilder) && ExpandPos != null &&
				// game.canBuildHere(ExpandPos, UnitType.Terran_Command_Center,
				// CCBuilder)){
				// System.out.println("Forcing CC build" + " ");
				// myUnit.build(UnitType.Terran_Command_Center, ExpandPos);
				// expanding = false;
				// buildwait = false;
				// saving = false;
				// }

				if (myUnit.getType() == UnitType.Terran_Command_Center
						&& myUnit.canBuild(UnitType.Terran_Comsat_Station, false)) {
					Position Postion = myUnit.getPosition();
					for (Unit buildings : myUnit.getUnitsInRadius(10)) {
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
				if (myUnit.getType() == UnitType.Terran_Factory
						&& myUnit.canBuild(UnitType.Terran_Machine_Shop, false) && myUnit.isLifted() == false) {
					Position Postion = myUnit.getPosition();
					for (Unit buildings : myUnit.getUnitsInRadius(25)) {
						if (buildings.canLift() == true && buildings.getType() != UnitType.Terran_Command_Center
								&& buildings.canBuildAddon(UnitType.Terran_Machine_Shop) == false
								&& buildings.canTrain(UnitType.Terran_Siege_Tank_Tank_Mode) == false) {
							buildings.lift();
						}
					}
				}
				
				if (myUnit.getType() == UnitType.Terran_Starport && myUnit.canBuild(UnitType.Terran_Control_Tower, false) && myUnit.isLifted() == false) {
					myUnit.lift();

				}
				
				if (myUnit.getType() == UnitType.Terran_Science_Facility && myUnit.canBuild(UnitType.Terran_Physics_Lab, false) && myUnit.isLifted() == false) {
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
				
			//	if(myUnit.getType() == UnitType.Terran_Refinery == true && myUnit.isBeingGathered() == false && myUnit.isCompleted() == true && Workers > 14){
				//	int i = 0;
				//	while(i <= 2){
				//		Unit workers = GetWorker();
					//	if(i >= 4){
					//		break;
					//	}
					//	if(myUnit.exists() == true && workers.canGather(myUnit) == true){
					//		workers.gather(myUnit);
					//		i = i + 1;
					//		if(i >= 4){
						//		break;
					//		}

					//	}
					//	else
					//	{
						//	game.sendText("Can't gather gas, alt f4ing and complaining on discord");
						//}
				//	}
					

					
				//}
				
				// end of myUnits loop

			}
			
			
			for(Region regions : game.getAllRegions()){
				game.drawTextMap(regions.getCenter(), "Strategic Value: " + regions.getDefensePriority());
			}

			

			for (Unit EnemyUnits1 : game.enemy().getUnits()) {
				boolean isMil = IsMilitrayUnit(EnemyUnits1);
				if (EnemyUnits1.isCloaked() || EnemyUnits1.isBurrowed() && EnemyUnits1.isDetected() == false
						&& EnemyUnits1.isAttacking() == true) {
					if (StealthUnitsDetected == false) {
						StealthUnitsDetected = true;
						AirThreat = AirThreat + 2;

					}
					for (Unit detectors : myComSats) {
						if (detectors.getType() == UnitType.Terran_Comsat_Station && detectors.getEnergy() >= 50) {
							detectors.useTech(TechType.Scanner_Sweep, EnemyUnits1.getPosition());
							break;

						}
					}
				}
				
				if (EnemyUnits1.getType().isBuilding() && EnemyUnits1.isLifted() == false) {
					// check if we have it's position in memory and add it if we
					// don't
					if (!enemyBuildingMemory.contains(EnemyUnits1.getPosition())) {
						enemyBuildingMemory.add(EnemyUnits1.getPosition());
					}
				}
				

			}


			// loop over all the positions that we remember
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
			
			// expanding script
			// expanding
			// income < needs


		if (HasScoutUnit == true && ScoutSent == true && scouter.isMoving() == false || scouter.isIdle() == true) {
			scouter.move(self.getStartLocation().toPosition(), false);
			for (BaseLocation b : BWTA.getBaseLocations()) {
				// If this is a possible start location,
				if (b.isStartLocation() && game.isVisible(b.getTilePosition()) == false) {
					// do something. For example send some unit to attack that
					// position:
					scouter.move(b.getPosition(), true);

				}

				if (enemyBuildingMemory.size() > 1) {
					for (BaseLocation b2 : BWTA.getBaseLocations()) {
						// If this is a possible start location,
						if (b2.isStartLocation() == false) {
							// do something. For example send some unit to
							// attack that
							// position:
							scouter.move(b2.getPosition(), true);

						}
					}
				}
			}
		}

		if (ExpandPos.isValid()) {
			game.drawCircleMap(ExpandPos.toPosition(), 25, Color.Cyan, false);
		}
		if (Commander.exists()) {
			game.drawCircleMap(Commander.getPosition(), 25, Color.Orange, false);
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
		int stopDist = 500;
		// Refinery, Assimilator, Extractor
		if (buildingType.isRefinery()) {
			for (Unit n : game.neutral().getUnits()) {
				if ((n.getType() == UnitType.Resource_Vespene_Geyser)
						&& (Math.abs(n.getTilePosition().getX() - aroundTile.getX()) < stopDist)
						&& (Math.abs(n.getTilePosition().getY() - aroundTile.getY()) < stopDist))
					return n.getTilePosition();
			}
		}

		if (buildingType.isResourceDepot()) {
			maxDist = 1;
		}

		if (buildingType.canAttack() == true) {
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

	public TilePosition getLandLocation(Unit building, TilePosition aroundTile) {
		TilePosition ret = null;
		int LastX1 = building.getX();
		int LastY1 = building.getY();
		int maxDist = 6;
		int stopDist = 310;

		while ((maxDist < stopDist) && (ret == null)) {
			for (LastX1 = aroundTile.getX() - maxDist; LastX1 <= aroundTile.getX() + maxDist; LastX1++) {
				for (LastY1 = aroundTile.getY() - maxDist; LastY1 <= aroundTile.getY() + maxDist; LastY1++) {
					if (building.canLand(new TilePosition(LastX1, LastY1)) == true && Math.round(BWTA.getGroundDistance(new TilePosition(LastX1, LastY1), self.getStartLocation())) < 200) {
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
			dist = dist + 500;
			for (BaseLocation Expand : BWTA.getBaseLocations()) {
				alreadyTaken = false;
				int AmountofBases = BWTA.getBaseLocations().size();
				if (Expand.getGroundDistance(BWTA.getNearestBaseLocation(BasePos)) < dist
						&& BWTA.getGroundDistance(Expand.getTilePosition(), self.getStartLocation().getPoint()) > 50
						&& claimedBaseLocations.contains(Expand) == false && Expand.isIsland() == false) {
					//game.printf("Expand Found at: " + Expand.getPosition() + " With distance from base at: "
						//	+ BWTA.getGroundDistance(Expand.getTilePosition(), self.getStartLocation().getPoint()));
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
						expanding = false;
						game.sendText("Yeah, Straight from the top of my dome, ran outta of places to drop a CC and call home");
						saving = false;
						return null;
					}
				}

			}

		}

		expanding = false;
		buildwait = false;
		saving = false;
		return null;
	}


	public Unit GetWorker() {
		for (Unit unit : myWorkers) {
			if (unit.getType() == UnitType.Terran_SCV && unit.isGatheringMinerals() == true
					&& unit.isConstructing() == false && unit.isMoving() == false && unit.getID() != scoutID
					&& unit.isRepairing() == false && unit.isTraining() == false) {
				return unit;
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
		return null;
	}
	
	

	public boolean IsMilitrayUnit(Unit unit) {
		int Damage = unit.getType().groundWeapon().damageAmount() + unit.getType().airWeapon().damageAmount();
		
		if(Damage > 0 && unit.getType().isWorker() == false && unit.getType().isBuilding() == false && unit.getType().isSpell() == false){
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
				if(i.isAttacking() == true && ralleyPoint != null){
					if(i.getType() == UnitType.Terran_Marine && i.canUseTech(TechType.Stim_Packs) == true){
						i.useTech(TechType.Stim_Packs);
						i.move(ralleyPoint);
						}
					}
				
				if(i.isAttacking() == false && ralleyPoint != null){
					i.move(ralleyPoint);
				}
				
				if(i.isSieged() == true && ralleyPoint != null){
					i.unsiege();
					i.move(ralleyPoint, true);
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
	
		if(defenderCall == true && canWin == true){
		defenceCallFrames = 1;
		defenderCall = false; 
		
		//System.out.println("Victim script triggered at: " + totalFrames);
		if(victim.getType().isWorker() == true && victim.getID() != scoutID){
			for(Unit defenders : myUnits){
				int dist = defenders.getDistance(victim);
				if(defenders.isAttacking() == false && dist > 100){
					boolean stacking = orderStacking(defenders, victim.getPosition());
					if(stacking == false){
						defenders.attack(victim.getPosition());
					}
				}
			}
		}
		
		if(victim.getType().isBuilding() == true){
			for(Unit defenders : myUnits){
				int dist = defenders.getDistance(victim);
				if(defenders.isAttacking() == false && dist > 100){
					boolean stacking = orderStacking(defenders, victim.getPosition());
					if(stacking == false){
						defenders.attack(victim.getPosition());
					}
				}
			}
		}
		
		if(victim.getType().isWorker() == false && victim.getType().isBuilding() == false){
			for(Unit defenders : victim.getUnitsInRadius(200)){
				int dist = defenders.getDistance(victim);
				if(defenders.isAttacking() == false && dist > 100){
					boolean stacking = orderStacking(defenders, victim.getPosition());
					if(stacking == false){
						defenders.attack(victim.getPosition());
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
	boolean CanWin = JFapGlobal();
	Strats = "Justifying War Goals";

	
	if(CanWin == true && fapMyScores >= (fapEnemyScores * 0.25) && myUnits.size() > 10){
		if(NextCallToAttack == true){
		attacking = true;
		Strats = "Full Attack";
		Banzai();
		}
		else{
			GlobalRetreat();
			attacking = false;
			NextCallToAttack = true;
			Strats = "Regrouping to attack";
		}
	}
	
	
	if(CanWin == false){
		attacking = false;
		Strats = "Regrouping";
		GlobalRetreat();
	}
	
	if(Strats == "Justifying War Goals"){
		GlobalRetreat();
		attacking = false;
		Strats = "Regrouping";
		NextCallToAttack = false;
		
	}
	
	
	
	
}

public void LocalAttack(Position pos, int radius){
	
}

public boolean JFapGlobal(){

	JFAP simulator = new JFAP(game); 
	simulator.clear();
	Pair<Integer, Integer> preSimScores = simulator.playerScores();
	int preSimFriendlyUnitCount = simulator.getState().first.size();

	
	for(Unit unit : myUnits){
		simulator.addUnitPlayer1(new JFAPUnit(unit)); 
	}
	
	for(Unit unit : enemyUnits){
		simulator.addUnitPlayer2(new JFAPUnit(unit)); 
	}
	simulator.simulate(50);
		Pair<Integer, Integer> postSimScores = simulator.playerScores();
		int postSimFriendlyUnitCount = simulator.getState().first.size();
		int myLosses = preSimFriendlyUnitCount - postSimFriendlyUnitCount;
		int myScoreDiff = preSimScores.first - postSimScores.first;
		int enemyScoreDiff = preSimScores.second - postSimScores.second;
		fapMyScores = postSimScores.first;
		fapEnemyScores = postSimScores.second;
		//System.out.println("Me : " + Math.abs(myScoreDiff));
		//System.out.println("Enemy : " + Math.abs(enemyScoreDiff));
		
		if (Math.abs(myScoreDiff) >= Math.abs(enemyScoreDiff)) {
			return true;
		} 
		else{
			return false;
			
		}
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
			for (Position P : enemyBuildingMemory) {
				if (isMilitray2 == true && isAMoving == false || Attackers.isAttacking() == false) {
					boolean isStacking = orderStacking(Attackers, P);
					boolean busy = IsABusy(Attackers);
					if(isStacking == false && busy == false){
						Attackers.attack(P);
					}
					
					
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
	return JFapGlobal();

}

public boolean jFapDefenceCheck(Position pos){
	JFAP simulator = new JFAP(game);
	simulator.clear();
	Pair<Integer, Integer> preSimScores = simulator.playerScores();
	int preSimFriendlyUnitCount = simulator.getState().first.size();
	simulator.simulate(15);
	//int regionbonus = (game.getRegionAt(pos).getDefensePriority() / 3);
	
	for (Unit targets : game.getUnitsInRadius(pos, 170)) {
		int damage = targets.getType().groundWeapon().damageAmount() + targets.getType().airWeapon().damageAmount();
		
		if (targets.getPlayer().isEnemy(self) && damage > 0) {
			simulator.addUnitPlayer2(new JFAPUnit(targets)); // Adds an enemy unit to the simulator

			
		}
		if (targets.getPlayer().isAlly(self) && damage > 0) {
			simulator.addUnitPlayer1(new JFAPUnit(targets)); // Adds an enemy unit to the simulator
		}
		
		// >terran player
		// >forgetting about bunkers
		// >danface.jpg
		if(targets.getPlayer().isAlly(self) && targets.getType() == UnitType.Terran_Bunker && targets.getLoadedUnits().size() > 0 ){
			simulator.addUnitPlayer1(new JFAPUnit(targets));
		}
	}
	
	for (Unit unit : myUnits){
		simulator.addUnitPlayer1(new JFAPUnit(unit));
	}
	
	
	Pair<Integer, Integer> postSimScores = simulator.playerScores();
	int postSimFriendlyUnitCount = simulator.getState().first.size();
	int myLosses = preSimFriendlyUnitCount - postSimFriendlyUnitCount;
	int myScoreDiff = preSimScores.first - postSimScores.first;
	int enemyScoreDiff = preSimScores.second - postSimScores.second;
	//System.out.println("Me : " + myScoreDiff);
	//System.out.println("Enemy : " + enemyScoreDiff);
	// if we can win
	if (postSimScores.first >= postSimScores.second ) {
		return true;
	} 
	
	
	
	return false;
}


//public void CheckBunkers(){
//	
//	for(Unit bunkers : self.getUnits()){
//		if(bunkers.getType() == UnitType.Terran_Bunker && bunkers.getLoadedUnits().size() > 0){
//			for(Unit loaded : bunkers.getLoadedUnits()){
//				if(bunkerUnits.contains(loaded) == false){
//					bunkerUnits.add(loaded);
//				}
//			}
//			
//		}
//	}
//
//	
//
//}


//public boolean isInBunker(Unit unit){
//	
//	if(bunkerUnits.contains(unit) == true){
//		return true;
//	}
//	else
//	{
//		return false;
//	}
//
//}
//
//
//public void RemoveBunkerUnits(){
//	
//	CheckBunkers();
//	System.out.println(bunkerUnits.size());
//	int total = 0;
//	for(Unit units : bunkerUnits){
//		if(myUnits.contains(units) == true){
//			System.out.println("trigger");
//				myUnits.remove(units);
//				total = total + 1;
//		}
//	}
//		
//	game.sendText("Pulled " + total + " units from the active militray list.");
//}

public void MakeSomeUnits(int mins, int gas){
	
	
		
}

public void UpgradeSomeShit(int mins, int gas){
	
	
	
	
}


	public TilePosition getMissileTile(Unit builder, UnitType buildingType, TilePosition aroundTile) {
			TilePosition ret = null;
			int maxDist = 3;
			int stopDist = 40;
	
			while ((maxDist < stopDist) && (ret == null)) {
				for (int i=aroundTile.getX()-maxDist; i<=aroundTile.getX()+maxDist; i++) {
					for (int j=aroundTile.getY()-maxDist; j<=aroundTile.getY()+maxDist; j++) {
						if (game.canBuildHere(new TilePosition(i,j), buildingType, builder, false)) {
							// units that are blocking the tile
							boolean unitsInWay = false;
							for (Unit u : game.getAllUnits()) {
								if (u.getID() == builder.getID()) continue;
								if ((Math.abs(u.getTilePosition().getX()-i) < 4) && (Math.abs(u.getTilePosition().getY()-j) < 4)) unitsInWay = true;
							}
							if (!unitsInWay) {
								return new TilePosition(i, j);
							}
							// creep for Zerg
	
						}
					}
				}
				maxDist += 2;
			}
	
			if (ret == null) game.sendText("Unable to find suitable build position for "+buildingType.toString());
			return ret;
		}
		
	
		
		
	}
	
	
		
	
	
	
