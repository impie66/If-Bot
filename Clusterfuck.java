import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.HashSet;
import java.util.Random;
import java.lang.*;

import bwapi.*;
import bwta.BWTA;
import bwta.BaseLocation;

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
	private int MaxBases = 3;
	private int SavingAntiFuck = 0;
	private int Racks = 0;
	private int Academy = 0;
	private int Gases = 0;
	private int MaxGases = 0;
	private Unit scouter;
	private boolean HasScoutUnit;
	private int scoutID = 0;
	private int Factories = 0;
	private int MaxFactories = 5;
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
	private int factorybuilding = 0;
	ArrayList<Integer> repairingBuildings = new ArrayList<Integer>();
	ArrayList<Position> enemyBuildingMemory = new ArrayList<Position>();
	ArrayList<BaseLocation> claimedBaseLocations = new ArrayList<BaseLocation>();
	ArrayList<Unit> enemyUnits = new ArrayList<Unit>();
	ArrayList<Unit> myUnits = new ArrayList<Unit>();
	ArrayList<Unit> myMinerals = new ArrayList<Unit>();
	ArrayList<Unit> gasWorkers = new ArrayList<Unit>();
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



	public void run() {
		mirror.getModule().setEventListener(this);
		mirror.startGame();
		
	}

	@Override
	public void onUnitCreate(Unit unit) {

		if (unit.getType() == UnitType.Terran_Bunker && unit.getPlayer() == self) {
			LastBunkerPos = unit.getTilePosition();
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
			isExpanding = false;
			expanding = false;
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
					System.out.println("Adding mineral to claimed mineral's list with size of: " + myMinerals.size());
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
			MaxFactories = MaxFactories + 2;
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
		}

		if (unit.getType() == UnitType.Terran_Science_Facility && unit.getPlayer() == self) {
			TSF = 1;
		}

		if (unit.getType() == UnitType.Terran_Engineering_Bay && unit.getPlayer() == self) {
			Bays = 1;
		}

	}

	public void onUnitDestroy(Unit unit) {

		if (enemyUnits.contains(unit) == true) {
			int index = enemyUnits.indexOf(unit);
			enemyUnits.remove(index);
			// game.sendText("Unit " + unit.getType().toString() + " is now
			// removered from the enemyUnit's list with current size of " +
			// enemyUnits.size());
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

		if (unit.canAttack() == true && unit.getType().isWorker() == false && unit.getPlayer().isEnemy(self) == true) {
			boolean istrue = IsMilitrayUnit(unit);
			if (istrue == true) {
				EnemyUnits = EnemyUnits - 1;
			}
		}

		if (unit.canAttack() == true && unit.getType().isBuilding() == false && unit.getType().isWorker() == false) {
			MilUnits = MilUnits - 1;
		}

		if (unit.getType() == UnitType.Terran_Marine && unit.getPlayer() == self) {
			Marines = Marines - 1;
		}

		if (unit.getType() == UnitType.Terran_Command_Center && unit.getPlayer() == self) {
			Position pos = unit.getPosition();
			Bases = Bases - 1;
			income = income - (int) (BWTA.getNearestBaseLocation(pos).getMinerals().size() * 2.5);
			MaxGases = MaxGases - BWTA.getNearestBaseLocation(pos).getGeysers().size();
			if (claimedBaseLocations.contains(BWTA.getNearestBaseLocation(pos)) == true) {
				int index = claimedBaseLocations.indexOf(BWTA.getNearestBaseLocation(pos));
				claimedBaseLocations.remove(index);
				game.sendText("Base Destroyed, removing it from claimed bases");
				for (Unit unit1 : BWTA.getNearestBaseLocation(pos).getMinerals()) {
					if (myMinerals.contains(unit1) == true) {
						int index1 = myMinerals.indexOf(unit1);
						myMinerals.remove(index1);
					}

				}

			}

		}
		
		
		if (unit.getType() == UnitType.Terran_Command_Center && unit.getPlayer() == self) {
			System.out.print("CC destroy start");
			Position pos = unit.getPosition();
			if (claimedBaseLocations.contains(BWTA.getNearestBaseLocation(pos)) == true) {
				System.out.print("Contains CC");
				int index = claimedBaseLocations.indexOf(BWTA.getNearestBaseLocation(pos));
				claimedBaseLocations.remove(index);
				System.out.print("Removered from claimed bases");
					
				}

		}

		if (unit.getType() == UnitType.Terran_SCV && unit.getPlayer() == self && unit.getID() == scoutID) {
			HasScoutUnit = false;

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

		if (unit.getType() == UnitType.Terran_Bunker && unit.getPlayer() == self) {
			Bunks = Bunks - 1;
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

		if (unit.getType() == UnitType.Zerg_Zergling && unit.getPlayer().isEnemy(self)) {
		}

		if (unit.getType() == UnitType.Zerg_Hydralisk && unit.getPlayer().isEnemy(self)) {
		}

		if (unit.getType() == UnitType.Terran_Marine && unit.getPlayer().isEnemy(self)) {
		}

		if (unit.getType() == UnitType.Terran_Firebat && unit.getPlayer().isEnemy(self)) {
		}

		if (unit.getType() == UnitType.Protoss_Dragoon && unit.getPlayer().isEnemy(self)) {
		}

		if (unit.getType() == UnitType.Protoss_Zealot && unit.getPlayer().isEnemy(self)) {
		}

		if (unit.getType() == UnitType.Terran_Command_Center && unit.getPlayer().isEnemy(self)
				&& hasAttackpos == true) {
			hasAttackpos = false;
		}

		if (unit.getType() == UnitType.Protoss_Nexus && unit.getPlayer().isEnemy(self) && hasAttackpos == true) {
			hasAttackpos = false;
		}

		if (unit.getType() == UnitType.Zerg_Hatchery && unit.getPlayer().isEnemy(self) && hasAttackpos == true) {
			hasAttackpos = false;
		}

		if (unit.getType() == UnitType.Zerg_Lair && unit.getPlayer().isEnemy(self) && hasAttackpos == true) {
			hasAttackpos = false;
		}

		if (unit.getType() == UnitType.Zerg_Hive && unit.getPlayer().isEnemy(self) && hasAttackpos == true) {
			hasAttackpos = false;
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

		if (unit.getPlayer().isEnemy(self) && enemyUnits.contains(unit) == false && unit.getType().isWorker() == false
				&& unit.getType().isBuilding() == false && unit.getType() != UnitType.Terran_Vulture_Spider_Mine
				&& unit.getType().isSpell() == false) {
			enemyUnits.add(unit);
			// game.sendText("Added " + unit.getType().toString() + " To
			// enemyUnits list with current size of " + enemyUnits.size());
		}

		if (unit.getType() == UnitType.Zerg_Mutalisk && AirThreat == 0) {
			AirThreat = 4;
		}

		if (unit.getType() == UnitType.Terran_Barracks && unit.getPlayer().isEnemy(self)) {
			GroundThreat = GroundThreat + 1;
			enemyRace = 1;
			scouter.move(unit.getPosition(), true);
		}

		if (unit.getType() == UnitType.Terran_Barracks && unit.getPlayer().isEnemy(self) && hasAttackpos == false) {
			enemyBasePos = unit.getPosition();

		}

		if (unit.getType() == UnitType.Terran_Factory && unit.getPlayer().isEnemy(self) && hasAttackpos == false) {
			enemyBasePos = unit.getPosition();

		}

		if (unit.getType() == UnitType.Protoss_Gateway && unit.getPlayer().isEnemy(self) && hasAttackpos == false) {
			enemyBasePos = unit.getPosition();

		}

		if (unit.getType() == UnitType.Terran_Starport && unit.getPlayer().isEnemy(self) && hasAttackpos == false) {
			enemyBasePos = unit.getPosition();
			AirThreat = AirThreat + 1;

		}

		if (unit.getType() == UnitType.Protoss_Pylon && unit.getPlayer().isEnemy(self) && hasAttackpos == false) {
			enemyBasePos = unit.getPosition();

		}

		if (unit.getType() == UnitType.Protoss_Stargate && unit.getPlayer().isEnemy(self) && hasAttackpos == false) {
			enemyBasePos = unit.getPosition();
			AirThreat = AirThreat + 4;

		}

		if (unit.getType() == UnitType.Protoss_Stargate && unit.getPlayer().isEnemy(self)) {
			enemyBasePos = unit.getPosition();
			AirThreat = AirThreat + 4;

		}

		if (unit.getType() == UnitType.Zerg_Spire && unit.getPlayer().isEnemy(self) && hasAttackpos == false) {
			enemyBasePos = unit.getPosition();
			AirThreat = AirThreat + 4;

		}

		if (unit.getType() == UnitType.Protoss_Robotics_Facility && unit.getPlayer().isEnemy(self)
				&& hasAttackpos == false) {
			enemyBasePos = unit.getPosition();

		}

		if (unit.getType() == UnitType.Zerg_Creep_Colony && unit.getPlayer().isEnemy(self) && hasAttackpos == false) {
			enemyBasePos = unit.getPosition();

		}

		if (unit.getType() == UnitType.Zerg_Creep_Colony && unit.getPlayer().isEnemy(self) && hasAttackpos == false) {
			enemyBasePos = unit.getPosition();

		}

		if (unit.getType() == UnitType.Terran_Factory && unit.getPlayer().isEnemy(self)) {
			GroundThreat = GroundThreat + 2;
			enemyRace = 1;
			scouter.move(unit.getPosition(), true);
		}

		if (unit.getType() == UnitType.Protoss_Gateway && unit.getPlayer().isEnemy(self)) {
			GroundThreat = GroundThreat + 1;
			enemyRace = 2;
			scouter.move(unit.getPosition(), true);
		}

		if (unit.getType() == UnitType.Zerg_Hatchery && unit.getPlayer().isEnemy(self)) {
			GroundThreat = GroundThreat + 1;
			hasAttackpos = true;
			enemyBasePos = unit.getPosition();
			enemyRace = 3;
			scouter.move(unit.getPosition(), true);
		}
		if (unit.getType() == UnitType.Terran_Command_Center && unit.getPlayer().isEnemy(self)) {
			GroundThreat = GroundThreat + 1;
			hasAttackpos = true;
			enemyBasePos = unit.getPosition();
			enemyRace = 1;
			scouter.move(unit.getPosition(), true);
		}
		if (unit.getType() == UnitType.Protoss_Nexus && unit.getPlayer().isEnemy(self)) {
			GroundThreat = GroundThreat + 1;
			hasAttackpos = true;
			enemyBasePos = unit.getPosition();
			enemyRace = 2;
			scouter.move(unit.getPosition(), true);
		}

		// if (unit.getType() == UnitType.Protoss_Dark_Templar) {
		// System.out.println("Hostile invisbile unit discovered " +
		// unit.getType());
		// for (Unit detectors : self.getUnits()) {
		// if (detectors.getType() == UnitType.Terran_Comsat_Station &&
		// detectors.getEnergy() >= 50) {
		// detectors.useTech(TechType.Scanner_Sweep, unit.getPosition());
		// System.out.println("Scanned at " + unit.getPosition());
		// break;

		// }
		// }
		// }

		// if (unit.getType() == UnitType.Zerg_Lurker &&
		// unit.getPlayer().isEnemy(self)) {
		// System.out.println("Hostile invisbile unit discovered " +
		// unit.getType());
		// for (Unit detectors : self.getUnits()) {
		// if (detectors.getType() == UnitType.Terran_Comsat_Station &&
		// detectors.getEnergy() >= 50) {
		// detectors.useTech(TechType.Scanner_Sweep, unit.getPosition());
		// System.out.println("Scanned at " + unit.getPosition());
		// break;
		//
		// }
		// }
		// }

		// if (unit.getType() == UnitType.Terran_Ghost &&
		// unit.getPlayer().isEnemy(self)) {
		// System.out.println("Hostile invisbile unit discovered " +
		// unit.getType());
		// for (Unit detectors : self.getUnits()) {
		// if (detectors.getType() == UnitType.Terran_Comsat_Station &&
		// detectors.getEnergy() >= 50) {
		// detectors.useTech(TechType.Scanner_Sweep, unit.getPosition());
		// System.out.println("Scanned at " + unit.getPosition());
		// break;

		// }
		// }
		// }

		// if (unit.getType() == UnitType.Terran_Wraith &&
		// unit.getPlayer().isEnemy(self)) {
		// System.out.println("Hostile invisbile unit discovered " +
		// unit.getType());
		// for (Unit detectors : self.getUnits()) {
		// if (detectors.getType() == UnitType.Terran_Comsat_Station &&
		// detectors.getEnergy() >= 50) {
		// detectors.useTech(TechType.Scanner_Sweep, unit.getPosition());
		// System.out.println("Scanned at " + unit.getPosition());
		// break;
		//
		// }
		// }
		// }

		// end of discover
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
		LastX = self.getStartLocation().getX();
		LastY = self.getStartLocation().getY();
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
		Tick = Tick + 1;
		buildingTick = buildingTick + 1;
		LastBuildTick = LastBuildTick + 1;
		AddNeeds = AddNeeds + 1;
		needs = (Factories * 10) + (Racks * 5);
		APM = game.getAPM();
		claimedBaseLocations.add(BWTA.getNearestBaseLocation(self.getStartLocation()));
		game.enableFlag(1);
		// game.setTextSize(10);
		game.drawTextScreen(10, 10, "Playing as " + self.getName() + " - " + self.getRace() + " And with.. " + APM
				+ " APM" + " With.." + game.getAverageFPS() + "FPS");
		game.drawTextScreen(10, 20, "I have " + Bases + " Bases and i have " + Factories + " Factories"
				+ " And i have.. " + " " + myUnits.size() + "Militray units.");
		game.drawTextScreen(10, 30, Tick + " Ticks");
		game.drawTextScreen(10, 40, "Enemy Ground Threat.. " + GroundThreat + " And Air Threat... " + AirThreat);
		game.drawTextScreen(10, 50, +Gases + "  " + MaxGases + " " + " " + Bunks + " " + supplyBuilding + " "
				+ attacking + " " + buildwait + " " + reserves + " " + reservesgas + " " + bwub);
		game.drawTextScreen(10, 60,
				"Attack Point is.." + enemyBasePos + " " + hasAttackpos + " EnemyUnits: " + enemyUnits.size() + " Last Regroup At: " + RegroupPos);
		game.drawTextScreen(10, 70,
				"Expanding is : " + expanding + " and is being placed? " + ExpandPlacing + " Last Expand was at: "
						+ lastExpandPos + " current expand pos " + ExpandPos + " income: " + income + " " + needs
						+ " needs: ");
		game.drawTextScreen(10, 80, "NB " + NewBuild + " LB " + LastBuild + " " + buildWaitFix + " " + SavingAntiFuck);
		game.drawTextScreen(10, 90, "Saving: " + saving + " buildwait: " + buildwait + " Building Name: " + buildingName
				+ "  " + buildingTick + " Diff Build: " + DifBuild);
		game.drawTextScreen(10,100, "Versing " + game.enemy().getName() + " as "  + game.enemy().getRace() + " ");

		if (game.getFrameCount() % game.getLatencyFrames() != 0) {

			if (supplyBuilding < 0) {
				supplyBuilding = 0;
			}

			if (attacking == true) {
				Mines = Mines + 1;
			}

			if (buildingTick > 30) {
				buildingTick = 0;
			}
			
			if(MaxWorkers > 48){
				MaxWorkers = 48;
			}
			
			if(saving == true && self.minerals() > 2000 && self.gas() > 500){
				saving = false;
				buildwait = false;
			}

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

			if (income < needs && ExpandEnabled == true && myUnits.size() > (EnemyUnits * enemyRaceBonus + 10)) {
				saving = true;
				if(needsToExpand == false){
					needsToExpand = true;
				}
			}
			
			if(RegroupPos != null){
				if(RegroupPos.isValid() == true) {
				game.drawCircleMap(RegroupPos, 35, Color.Red, true);
				}
			}

			StringBuilder units = new StringBuilder("My units:\n");

			// repairs list

			for (Unit myUnit : self.getUnits()) {
				units.append(myUnit.getType()).append(" ").append(myUnit.getTilePosition()).append("\n");

				if (saving == false) {

					if (myUnit.getType() == UnitType.Terran_Command_Center && self.minerals() >= 50
							&& Workers < MaxWorkers && myUnit.isIdle() == true) {
						myUnit.train(UnitType.Terran_SCV);
					}

					if (myUnit.getType() == UnitType.Terran_Barracks && self.minerals() >= 50 && myUnit.isIdle() == true
							&& Marines < MarinesNeed && DifBuild == 1 && AcademyBuilt == true) {
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
						
						if (myUnit.getType() == UnitType.Terran_Factory && self.minerals() >= 80 && Vultures < VulturesMax
								&& myUnit.isIdle() == true) {
								myUnit.train(UnitType.Terran_Vulture);
							}

					}

					if (myUnit.getType() == UnitType.Terran_Machine_Shop && self.minerals() >= 200 && self.gas() >= 100
							&& myUnit.isIdle() == true && myUnit.canResearch(TechType.Spider_Mines, true)) {
						myUnit.research(TechType.Spider_Mines);
					}
					
					if (myUnit.getType() == UnitType.Terran_Machine_Shop & myUnit.isIdle() == true && myUnit.canUpgrade(UpgradeType.Charon_Boosters) == true) {
						myUnit.upgrade(UpgradeType.Charon_Boosters);
					}
					
					if (myUnit.getType() == UnitType.Terran_Armory && myUnit.isIdle() == true && myUnit.canUpgrade(UpgradeType.Terran_Vehicle_Weapons) == true){
						myUnit.upgrade(UpgradeType.Terran_Vehicle_Weapons);
					}
					
					if (myUnit.getType() == UnitType.Terran_Armory && myUnit.isIdle() == true && myUnit.canUpgrade(UpgradeType.Terran_Vehicle_Plating) == true){
						myUnit.upgrade(UpgradeType.Terran_Vehicle_Plating);
					}
					
					
					if (myUnit.getType() == UnitType.Terran_Academy && myUnit.isIdle() == true && Factories > 1 && myUnit.canResearch(TechType.Stim_Packs) == true){
						myUnit.research(TechType.Stim_Packs);
						
					}
					
					
					

				}

				if (saving == true && self.minerals() <= 1000 && self.gas() <= 500 && expanding == false) {
					for (Unit buildings : self.getUnits()) {
						// best way to get the bot to build after its build
						// frozen is probably max the supply and let it spam.
						if (buildings.getType() == UnitType.Terran_Factory && self.minerals() >= 150
								&& self.gas() >= 100 && buildings.isIdle() == true) {
							buildings.train(UnitType.Terran_Siege_Tank_Tank_Mode);
						}
						if (buildings.getType() == UnitType.Terran_Barracks && self.minerals() >= 50
								&& buildings.isIdle() == true && Marines < MarinesNeed && AcademyBuilt == true) {
							buildings.train(UnitType.Terran_Marine);
						}

						if (buildings.getType() == UnitType.Terran_Barracks && self.minerals() >= 50 && self.gas() >= 25
								&& buildings.isIdle() == true && Medics < MedicsNeed && AcademyBuilt == true) {
							buildings.train(UnitType.Terran_Medic);
						}

						if (buildings.getType() == UnitType.Terran_Barracks && self.minerals() >= 100
								&& self.gas() >= 25 && buildings.isIdle() == true && Bats < BatsNeed
								&& AcademyBuilt == true) {
							buildings.train(UnitType.Terran_Firebat);
						}
					}

				}

				if (myUnit.getType() == UnitType.Terran_Bunker && myUnit.getLoadedUnits().size() != 4
						&& myUnit.isBeingConstructed() == false) {
					int amount = 0;
					for (Unit bunks : myUnits) {
						if (amount <= 3) {
							if (bunks.isIdle() == true && bunks.getType() == UnitType.Terran_Marine
									|| bunks.getType() == UnitType.Terran_Firebat) {
								if (myUnit.exists() == true) {
									myUnit.load(bunks);
									int index = myUnits.indexOf(bunks);
									myUnits.remove(index);
									amount = amount + 1;

								}
							}
						}
					}

				}

				if (myUnit.getType() == UnitType.Terran_Siege_Tank_Tank_Mode && myUnit.canSiege() == true
						&& myUnit.isAttacking() == true || myUnit.isUnderAttack()) {
					myUnit.useTech(TechType.Tank_Siege_Mode);
				}
				

				if (myUnit.getType() == UnitType.Terran_Siege_Tank_Siege_Mode && myUnit.isIdle() == true) {
					int hostile = 0;
					Unit unit = myUnit;
					for (Unit targets : unit.getUnitsInRadius(500)) {
						if (targets.getPlayer().isEnemy(self) && targets.isFlying() == false) {
							hostile = hostile + 1;
						}
					}
					if (hostile < 1) {
						unit.unsiege();
						break;
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

				if (myUnit.getType() == UnitType.Terran_SCV && myUnit.isConstructing() == true && myUnit.isUnderAttack() == true) {
					Position pos = myUnit.getPosition();
					for (Unit Attackers : myUnits) {
						if (Attackers.getType() == UnitType.Terran_Marine && Attackers.isAttacking() == false) {
							Attackers.attack(pos, true);
						}
						if (Attackers.getType() == UnitType.Terran_Medic) {
							Attackers.attack(pos, true);
						}
						if (Attackers.getType() == UnitType.Terran_Firebat && Attackers.isAttacking() == false) {
							Attackers.attack(pos, true);
						}
						if (Attackers.getType() == UnitType.Terran_Vulture && Attackers.isAttacking() == false) {
							Attackers.attack(pos, true);
						}
						if (Attackers.getType() == UnitType.Terran_Siege_Tank_Tank_Mode) {
							Attackers.attack(pos, true);
						}
						if (Attackers.getType() == UnitType.Terran_Siege_Tank_Siege_Mode && Attackers.isAttacking() == false) {
							myUnit.unsiege();
							Attackers.attack(pos, true);
						}

					}
				}

				if (myUnit.isIdle() && attacking == true && myUnit.getType().isWorker() == false) {
					if (enemyBuildingMemory.isEmpty() == false) {
						for (Position P : enemyBuildingMemory) {
							myUnit.attack(P, true);
						}
					} else {
						for (BaseLocation b : BWTA.getBaseLocations()) {
							if (b.getPoint().isValid() == true) {
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

				// if (myUnit.isConstructing() == true && ExpandPlacing ==
				// false) {
				// TilePosition pos = null;
				// pos = myUnit.getOrderTargetPosition().toTilePosition();
				// if(pos != null){
				// if(game.canBuildHere(pos, buildingName) == false){
				// game.printf("SCV can't build there. ");
				// buildwait = false;
				// saving = false;
				// }
				// }
				// }

				if (myUnit.isIdle() && myUnit.getType() == UnitType.Terran_Medic) {
					for (Unit unitss : myUnit.getUnitsInRadius(800)) {
						if (unitss.getType() == UnitType.Terran_Marine
								|| unitss.getType() == UnitType.Terran_Firebat && unitss.getPlayer() == self) {
							Position pos = unitss.getPosition();
						}

					}
				}

				// combat sim

				if (myUnit.isUnderAttack() == true && myUnit.getType().isBuilding() == false) {
					Position lastorder = myUnit.getTargetPosition();
					int hostiles = 0;
					int allies = 0;
					for (Unit targets : myUnit.getUnitsInRadius(300)) {
						if (targets.getPlayer().isEnemy(self)) {
							hostiles = hostiles + targets.getType().mineralPrice() + targets.getType().gasPrice();
							if (targets.getType() == UnitType.Protoss_Photon_Cannon) {
								hostiles = hostiles + 700;
							}
							if (targets.getType() == UnitType.Zerg_Sunken_Colony) {
								hostiles = hostiles + 700;
							}
							if (targets.getType() == UnitType.Protoss_Zealot) {
								hostiles = hostiles + 200;
							}

						}
						if (targets.getPlayer().isAlly(self) && targets.getType().isBuilding() == false) {
							allies = allies + targets.getType().mineralPrice() + targets.getType().gasPrice();
						}
					}
					if (allies > hostiles) {
					} else {
							//if (myUnit.isAttacking() == false && myUnit.canMove() == true) {
								//Position regroup = Regroup();
							//	if (regroup != null && myUnit.hasPath(regroup) == true) {
									//myUnit.attack(regroup);
								//}

							//}
					}
				}
				// end of combat sim

				if (myUnit.isUnderAttack() == true && myUnit.getType().isWorker() == false
						&& myUnit.getType().isBuilding() == false) {
					for (Unit targets : myUnit.getUnitsInRadius(1000)) {
						if (targets.canAttack() == true && targets.getType().isBuilding() == false
								&& targets.getType().isWorker() == false && targets.isAttacking() == false) {
							targets.attack(myUnit.getPosition());
						}
					}
				}

				if (attacking == true && myUnit.getType().isWorker() == false && myUnit.isIdle() == true
						&& myUnits.size() > (enemyUnits.size() * enemyRaceBonus)) {
					Position LastOrder = myUnit.getOrderTargetPosition();
					for (Unit unitss : self.getUnits()) {
						if (unitss.isAttacking() == true && myUnits.size() >= (enemyUnits.size() * enemyRaceBonus + 5)) {
							Position pos = unitss.getTarget().getPosition();
							if (myUnit.isAttacking() == false) {
								myUnit.attack(pos);
								myUnit.attack(LastOrder, true);
							}
						}
					}
				}

				if (myUnit.isAttacking() == true && myUnit.getType().isWorker() == false) {
					Unit target = myUnit.getOrderTarget();
					Unit unit = myUnit;
					if (target.getType() == UnitType.Protoss_Zealot) {
						Position JukePos = getJukePos(target, unit);
						if (JukePos.isValid() == true) {
							myUnit.move(JukePos);
						}
					}
					if (target.getType() == UnitType.Zerg_Zergling) {
						Position JukePos = getJukePos(target, unit);
						if (JukePos.isValid() == true) {
							myUnit.move(JukePos);
						}
					}

				}

				if (scouter.isUnderAttack() == true) {
					TilePosition pos = self.getStartLocation();
					scouter.move(pos.getPoint().toPosition(), false);
				}

				if (Tick > 2500 && attacking == true) {
					attacking = false;
				}

				if (attacking == true && MilUnits < 5) {
					attacking = false;
				}

				if (Tick > (8500 - (attackNum * 1000))) {
					buildwait = false;
					Mines = 0;
					attackNum = attackNum + 1;
					orderRetreat = false;
					attacking = true;
					Tick = 0;

					if (attackNum > 4) {
						attackNum = 4;
					}

					if (factorybuilding < 0) {
						factorybuilding = 0;
					}

					if (needs >= income && ExpandEnabled == true && myUnits.size() >= (enemyUnits.size() * enemyRaceBonus + 10) && Bases <= MaxBases) {
						saving = true;
						expanding = true;

					}

					for (Unit Attackers : myUnits) {
						boolean isMilitray = IsMilitrayUnit(Attackers);
						if(Attackers.getType() == UnitType.Terran_Bunker && Attackers.getLoadedUnits().size() > 0){
							Attackers.unloadAll();
						}
						if (enemyBuildingMemory.isEmpty() == false) {
							game.sendText("Attacking, remembered locations");
							for (Position P : enemyBuildingMemory) {
								if (isMilitray == true) {
									Attackers.attack(P);
									
								}
							}
						} else {
							game.sendText("No remembered locations, attacking all base locations.");
							for (BaseLocation b : BWTA.getBaseLocations()) {
								if (b.getPoint().isValid() == true) {
									for (Unit Attackers2 : myUnits) {
										boolean isMilitray2 = IsMilitrayUnit(Attackers2);
										if (isMilitray2 == true) {
											Attackers2.attack(b.getPoint());
										}
									}
								}
							}

						}
					}

				}
				
				
				if(attacking == true && myUnits.size() < (enemyUnits.size() * enemyRaceBonus + 10)){
					attacking = false;
					GlobalRetreat();
					
				}
				
				

				if (attackNum > 1 && myUnits.size() > (enemyUnits.size() * enemyRaceBonus + 10) && attacking == false) {
					attacking = true;
					// game.sendText("AHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
				}
				// we may have

				// if (myUnit.getType() == UnitType.Terran_Vulture &&
				// myUnit.getSpiderMineCount() >= 1 && Mines > 799) {
				// Unit unit = myUnit;
				// System.out.println("Mines Trigger");
				// Position lastorder = unit.getTargetPosition();
				// bwta.Region spiderRegion =
				// BWTA.getRegion(unit.getPosition());
				// if(unit.canUseTech(TechType.Spider_Mines,
				// spiderRegion.getCenter()) == true){
				// unit.useTech(TechType.Spider_Mines,spiderRegion.getCenter());
				// unit.attack(lastorder, true);
				// System.out.println("Dropping Mine at " +
				// spiderRegion.getCenter());
				///
				// }

				// }

				if (myUnit.getType() == UnitType.Terran_Vulture && myUnit.getSpiderMineCount() != 0 && Mines == 300) {
					Unit unit = myUnit;
					if (myUnit.canUseTech(TechType.Spider_Mines, myUnit.getPosition()) == true
							&& myUnit.getLastCommand() != UnitCommand.useTech(unit, TechType.Spider_Mines)) {
						Position lastorder = unit.getTargetPosition();
						unit.useTech(TechType.Spider_Mines, unit.getPosition());
						unit.attack(lastorder, true);
					}

				}

				// mines

				// repair script decided it wanted to break everything
				// please help

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
					} else {
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
					buildwait = false;
				}
				

				if (SavingAntiFuck <= Tick && saving == true && expanding == false && income > needs && needsToExpand == false) {
					//game.sendText("No building's been placed recently, as meatshield would say. Freeing up the $");
					if (SavingAntiFuck > 8500 - attackNum) {
						SavingAntiFuck = SavingAntiFuck - (8500 - attackNum);

					}
					saving = false;
					SavingAntiFuck = Tick + 1000;
					buildingName = null;
					LastX = self.getStartLocation().getX();
					LastY = self.getStartLocation().getY();
				}

				if (buildWaitFix <= Tick && buildwait == true && expanding == false) {
					if (buildWaitFix > 8500 - (attackNum * 500)) {
						buildWaitFix = buildWaitFix - 8500;
					}
					game.sendText("BuildWait timer expired, ressetting build conditions.");
					buildwait = false;
					buildWaitFix = Tick + 1000;
					buildingName = null;
					LastX = self.getStartLocation().getX();
					LastY = self.getStartLocation().getY();
				}

				if (Tick > LastBuildTick && expanding == false) {
					game.sendText("No building has been detected in the last 200 ticks, resetting build conditions");
					buildwait = false;
					LastBuildTick = Tick + 1000;
					buildingName = null;
					LastX = self.getStartLocation().getX();
					LastY = self.getStartLocation().getY();
					if (expanding == false) {
						saving = false;
					}

				}
				
				
				if (myUnit.isLifted() == true && myUnit.isIdle() == true) {
					TilePosition LandLocation = getLandLocation(myUnit, self.getStartLocation());
					if (myUnit.canLand(LandLocation) == true) {
						myUnit.land(LandLocation);
					} else {
					}
				}

				if (myUnit.isUnderAttack() && myUnit.getType().isBuilding()) {
					if (needsToExpand == true || expanding == true) {
						saving = false;
						buildwait = false;
					}	
					Position pos = myUnit.getPosition();
					for (Unit Defenders : myUnits) {
						if (Defenders.getType() == UnitType.Terran_Marine) {
							Defenders.attack(pos, true);
						}
						if (Defenders.getType() == UnitType.Terran_Firebat) {
							Defenders.attack(pos, true);
						}
						if (Defenders.getType() == UnitType.Terran_Medic) {
							Defenders.attack(pos, true);
						}
						if (Defenders.getType() == UnitType.Terran_Vulture) {
							Defenders.attack(pos, true);
						}
						if (Defenders.getType() == UnitType.Terran_Siege_Tank_Tank_Mode) {
							Defenders.attack(pos, true);
						}
						if (Defenders.getType() == UnitType.Terran_Goliath) {
							Defenders.attack(pos, true);
						}
					}
				}

				if (myUnit.isUnderAttack() && myUnit.getType().isBuilding() && myUnits.size() < 5 && attackNum <= 1) {
					Position Pos = myUnit.getPosition();
					for (Unit Defenders : self.getUnits()) {
						if (Defenders.getType() == UnitType.Terran_SCV) {
							Defenders.attack(Pos, true);
						}
					}

				}

				if (myUnit.isUnderAttack() == true && myUnit.getType() == UnitType.Terran_Marine
						|| myUnit.getType() == UnitType.Terran_Firebat) {
					for (Unit medics : self.getUnits()) {
						if (medics.getType() == UnitType.Terran_Medic && medics.isMoving() == true
								|| medics.isIdle() == true) {
							medics.useTech(TechType.Healing, myUnit);
						}

					}

				}

				if (myUnit.isAttacking() == true && myUnit.getType() == UnitType.Terran_Marine
						&& myUnit.canUseTech(TechType.Stim_Packs) == true && myUnit.isStimmed() == false) {
					myUnit.useTech(TechType.Stim_Packs);
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
				
				
				if(myUnit.isMoving() == true && myUnit.isUnderAttack() == true && myUnit.isAttacking() == false){
					myUnit.attack(myUnit.getPosition());
				}

				if (myUnit.isAttacking() == true && myUnit.getType() == UnitType.Terran_Firebat
						&& myUnit.canUseTech(TechType.Stim_Packs) == true && myUnit.isStimmed() == false) {
					myUnit.useTech(TechType.Stim_Packs);
				}

				if (myUnit.isUnderAttack() == true && myUnit.getType().isWorker() == true
						&& myUnit.getID() != scoutID) {
					Position pos = myUnit.getPosition();
					for (Unit hostiles : game.getUnitsInRadius(pos, 160)) {
						if (hostiles.getPlayer().isEnemy(self) == true && hostiles.isAttacking() == true
								|| hostiles.isMoving() == true) {
							if (pos.isValid() == true) {
								pos = hostiles.getPosition();
							} else {
								pos = myUnit.getPosition();
							}

						}
					}
					for (Unit Defenders : self.getUnits()) {
						if (Defenders.getType() == UnitType.Terran_Marine && Defenders.isIdle() == true) {
							Defenders.attack(pos, false);
						}
						if (Defenders.getType() == UnitType.Terran_Firebat && Defenders.isIdle() == true) {
							Defenders.attack(pos, false);
						}
						if (Defenders.getType() == UnitType.Terran_Medic && Defenders.isIdle() == true) {
							Defenders.attack(pos, false);
						}
						if (Defenders.getType() == UnitType.Terran_Vulture && Defenders.isIdle() == true) {
							Defenders.attack(pos, false);
						}
						if (Defenders.getType() == UnitType.Terran_Goliath && Defenders.isIdle() == true) {
							Defenders.attack(pos, false);
						}
						if (Defenders.getType() == UnitType.Terran_Siege_Tank_Tank_Mode && Defenders.isIdle() == true) {
							Defenders.attack(pos, false);
						}
						if (myUnits.size() < 5 && Defenders.getType() == UnitType.Terran_SCV
								&& Defenders.isGatheringGas() == false && attackNum <= 1) {
							Defenders.attack(pos, false);
						}
					}
				}

				if (myUnit.getType() == UnitType.Terran_Factory
						&& myUnit.canBuild(UnitType.Terran_Machine_Shop, true)) {
					myUnit.buildAddon(UnitType.Terran_Machine_Shop);
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
					for (Unit buildings : myUnit.getUnitsInRadius(45)) {
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
						&& myUnit.canBuild(UnitType.Terran_Machine_Shop, false)) {
					Position Postion = myUnit.getPosition();
					for (Unit buildings : myUnit.getUnitsInRadius(25)) {
						if (buildings.canLift() == true && buildings.getType() != UnitType.Terran_Command_Center
								&& buildings.canBuildAddon(UnitType.Terran_Machine_Shop) == false
								&& buildings.canTrain(UnitType.Terran_Siege_Tank_Tank_Mode) == false) {
							buildings.lift();
						}
					}
				}

				if (myUnit.getID() == scoutID && ScoutSent == false && myUnit.isIdle() == true) {
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

				if (myUnit.getType().isWorker() && myUnit.isIdle() && myUnit.isGatheringGas() == false
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
				
				

			}

			

			for (Unit EnemyUnits1 : game.enemy().getUnits()) {
				if (EnemyUnits1.isCloaked() || EnemyUnits1.isBurrowed() && EnemyUnits1.isDetected() == false
						&& EnemyUnits1.isAttacking() == true) {
					if (StealthUnitsDetected == false) {
						StealthUnitsDetected = true;
						AirThreat = AirThreat + 2;

					}
					for (Unit detectors : self.getUnits()) {
						if (detectors.getType() == UnitType.Terran_Comsat_Station && detectors.getEnergy() >= 50) {
							detectors.useTech(TechType.Scanner_Sweep, EnemyUnits1.getPosition());
							break;

						}
					}
				}

			}

			for (Unit u : game.enemy().getUnits()) {
				// if this unit is in fact a building
				if (u.getType().isBuilding()) {
					// check if we have it's position in memory and add it if we
					// don't
					if (!enemyBuildingMemory.contains(u.getPosition())) {
						enemyBuildingMemory.add(u.getPosition());
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
			if (self.minerals() >= 400 && ExpandEnabled == true && income < needs && expanding == false && Bases <= MaxBases) {
				game.sendText("Expanding");
				expanding = true;
				saving = true;
				Unit myUnit = GetWorker();
				CCBuilder = myUnit;
				TilePosition buildTile = NextExpand(CCBuilder);
				if (buildTile != null && myUnit != null) {
					buildwait = true;
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
					game.printf("Can't place expand at " + ExpandPos + " Making sure we dont try that ever again.");
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
				SavingAntiFuck = Tick + 120;
				buildWaitFix = buildWaitFix + 120;
				
				if(SavingAntiFuck >= 8500 - (attackNum * 500)){
					SavingAntiFuck = 100;
				}
				
				if(buildWaitFix >= 8500 - (attackNum * 500)){
					buildWaitFix = 100;
				}


				if (self.minerals() >= 100 && Bunks <= 1 && AcademyFinshed == true && isExpanding == false
						&& saving == false && BunkerStarted == false) {
					saving = true;
					SavingAntiFuck = Tick + 200;
					buildWaitFix = buildWaitFix + 200;
					Unit myUnit = GetWorker();	
					if (Bases > 1) {
						if (Bunks > 0) {
							TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Bunker, LastBunkerPos);
							if (buildTile != null && myUnit != null) {
								myUnit.build(UnitType.Terran_Bunker, buildTile);
								buildwait = true;
								BunkerStarted = true;
								LastBuildTick = Tick + 200;

							}
						} else {
							TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Bunker,
									BWTA.getNearestChokepoint(lastExpandPos).getPoint().toTilePosition());
							if (buildTile != null && myUnit != null) {
								myUnit.build(UnitType.Terran_Bunker, buildTile);
								buildwait = true;
								BunkerStarted = true;
								LastBuildTick = Tick + 200;
							}
						}
					}
					if (Bases == 1) {
						if (Bunks > 0) {
							TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Bunker, LastBunkerPos);
							if (buildTile != null && myUnit != null) {
								myUnit.build(UnitType.Terran_Bunker, buildTile);
								buildwait = true;
								BunkerStarted = true;
								LastBuildTick = Tick + 200;

							}
						} else {
							TilePosition bunkertile = BWTA.getNearestChokepoint(BasePos).getPoint().toTilePosition();
							TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Bunker, bunkertile);
							if (buildTile != null && myUnit != null) {
								myUnit.build(UnitType.Terran_Bunker, buildTile);
								buildwait = true;
								LastBuildTick = Tick + 200;
							}

						}
					}

				}

				if (self.minerals() >= 100 && Gases < MaxGases && isExpanding == false && buildwait == false
						&& saving == false && AcademyBuilt == true) {
					saving = true;
					// SavingAntiFuck = Tick + 200;
					// buildWaitFix = buildWaitFix + 200;
					Unit myUnit = GetWorker();
					TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Refinery, self.getStartLocation());
					if (buildTile != null) {
						myUnit.build(UnitType.Terran_Refinery, buildTile);
						buildwait = true;
						LastBuildTick = Tick + 200;
					}
				}

				if (self.minerals() >= 100 && supplyBuilding <= supplyBuildingMax && saving == false
						&& RacksBuilding + Racks > 1 && (self.supplyTotal() - self.supplyUsed()) < 3
						|| self.supplyUsed() > self.supplyTotal()) {
					saving = true;
					// SavingAntiFuck = Tick + 200;
					// buildWaitFix = buildWaitFix + 200;
					Unit myUnit = GetWorker();
					TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Supply_Depot,
							self.getStartLocation());
					if (buildTile.isValid() == true && myUnit.exists() == true
							&& game.canBuildHere(buildTile, UnitType.Terran_Supply_Depot, myUnit) == true) {
						myUnit.build(UnitType.Terran_Supply_Depot, buildTile);
						game.drawCircleMap(buildTile.toPosition(), 10, Color.Yellow, false);
						buildwait = true;
						LastBuildTick = Tick + 200;

					} else {
					}
				}

				if (Racks + RacksBuilding <= MaxRacks - 1 && self.minerals() >= 150 && saving == false) {
					saving = true;
					// SavingAntiFuck = Tick + 200;
					// buildWaitFix = buildWaitFix + 200;
					Unit myUnit = GetWorker();
					TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Barracks, self.getStartLocation());
					if (buildTile != null && myUnit != null) {
						myUnit.build(UnitType.Terran_Barracks, buildTile);
						buildwait = true;
						LastBuildTick = Tick + 200;
					
					}
				}

				if ((Factories + FactoriesBuilding) < MaxFactories && self.minerals() >= 200 && self.gas() >= 150 && Bunks > 0
						&& saving == false && factorybuilding < 3) {
					saving = true;
					SavingAntiFuck = Tick + 200;
					buildWaitFix = buildWaitFix + 200;
					Unit myUnit = GetWorker();
					TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Factory, self.getStartLocation());
					if (buildTile != null && myUnit != null) {
						myUnit.build(UnitType.Terran_Factory, buildTile);
						buildwait = true;
						LastBuildTick = Tick + 200;
						

					}
				}

				if (Factories > 1 && self.minerals() >= 100 && self.gas() >= 50 && Armor == 0 && saving == false
						&& buildwait == false && Factories > 0 && buildingArmor == false) {
					saving = true;
					// SavingAntiFuck = Tick + 200;
					// buildWaitFix = buildWaitFix + 200;
					Unit myUnit = GetWorker();
					TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Armory, self.getStartLocation());
					if (buildTile != null && myUnit != null) {
						myUnit.build(UnitType.Terran_Armory, buildTile);
						buildwait = true;
						buildingArmor = true;
						LastBuildTick = Tick + 200;
						

					}
				}

				if (self.minerals() >= 150 && isExpanding == false && AcademyBuilt == false && buildwait == false
						&& saving == false && Racks > 0) {
					saving = true;
					// SavingAntiFuck = Tick + 200;
					// buildWaitFix = buildWaitFix + 200;
					Unit myUnit = GetWorker();
					TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Academy, self.getStartLocation());
					if (buildTile != null && myUnit != null) {
						myUnit.build(UnitType.Terran_Academy, buildTile);
						buildwait = true;
						LastBuildTick = Tick + 200;
						
					}
				}

				if (BayCompleted == false && self.minerals() > 125 && buildwait == false && saving == false && Factories > 0) {
					saving = true;
					// SavingAntiFuck = Tick + 200;
					// buildWaitFix = buildWaitFix + 200;
					Unit myUnit = GetWorker();
					TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Engineering_Bay, self.getStartLocation());
					if (buildTile != null && myUnit != null) {
						myUnit.build(UnitType.Terran_Engineering_Bay, buildTile);
						buildwait = true;
						LastBuildTick = Tick + 200;
						
					}
				}

				if (self.minerals() > 75 && AirThreat > 0 && Turrets <= (AirThreat * 2) && BayCompleted == true
						&& Factories > 1 && buildwait == false && saving == false) {
					saving = true;
					SavingAntiFuck = Tick + 200;
					buildWaitFix = buildWaitFix + 200;
					Unit myUnit = GetWorker();
					TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Missile_Turret,
							self.getStartLocation());
					if (buildTile != null && myUnit != null) {
						myUnit.build(UnitType.Terran_Missile_Turret, buildTile);
						buildwait = true;
						LastBuildTick = Tick + 200;
						
					}
				}
				
				
				if(self.minerals() > 600 && self.gas() > 600 && factorybuilding <= 3){
					game.sendText("I have alot of money, spamming shit");
					saving = true;
					SavingAntiFuck = Tick + 200;
					buildWaitFix = buildWaitFix + 200;
					Unit myUnit = GetWorker();
					UnitType building = SpamSpend(self.minerals(), self.gas(), macroBuildings);
					if(building == null){
						building = UnitType.Terran_Factory;
					}
					TilePosition buildTile = getBuildTile(myUnit, building, self.getStartLocation());
					if (buildTile != null && myUnit != null) {
						myUnit.build(UnitType.Terran_Factory, buildTile);
						buildwait = true;
						LastBuildTick = Tick + 200;
						
				}
					
				}

			}

			// end

		}

		if (HasScoutUnit == true && ScoutSent == true && scouter.isMoving() == false) {
			scouter.stop();
			for (BaseLocation b : BWTA.getBaseLocations()) {
				// If this is a possible start location,
				if (b.isStartLocation()) {
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

		for (Unit cloak : game.enemy().getUnits()) {

			if (cloak.isAttacking() == true && cloak.isBurrowed() == true) {
				Unit unit = cloak;
				for (Unit detectors : self.getUnits()) {
					if (detectors.getType() == UnitType.Terran_Comsat_Station && detectors.getEnergy() >= 50) {
						detectors.useTech(TechType.Scanner_Sweep, unit.getPosition());
						break;

					}
				}
			}

			if (cloak.isAttacking() == true && cloak.isCloaked() == true || cloak.isBurrowed() == true) {
				Unit unit = cloak;
				for (Unit detectors : self.getUnits()) {
					if (detectors.getType() == UnitType.Terran_Comsat_Station && detectors.getEnergy() >= 50) {
						detectors.useTech(TechType.Scanner_Sweep, unit.getPosition());
						break;

					}
				}
			}

		}

	} // end of lat frames

	public static void main(String[] args) {
		new TestBot1().run();

	}

	// Returns a suitable TilePosition to build a given building type near
	// specified TilePosition aroundTile, or null if not found. (builder
	// parameter is our worker)
	public TilePosition getBuildTile(Unit builder, UnitType buildingType, TilePosition aroundTile) {
		TilePosition ret = null;
		int maxDist = 6;
		int stopDist = 310;
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
			for (LastX = aroundTile.getX() - maxDist; LastX <= aroundTile.getX() + maxDist; LastX++) {
				for (LastY = aroundTile.getY() - maxDist; LastY <= aroundTile.getY() + maxDist; LastY++) {
					if (game.canBuildHere(new TilePosition(LastX, LastY), buildingType, builder, false)) {
						// units that are blocking the tile
						boolean unitsInWay = false;
						for (Unit u : game.getAllUnits()) {
							if (u.getID() == builder.getID())
								continue;
							if ((Math.abs(u.getTilePosition().getX() - LastX) < 4)
									&& (Math.abs(u.getTilePosition().getY() - LastY) < 4)) {
								unitsInWay = true;
								NewBuild = new TilePosition(LastX, LastY);
							}
						}
						if (!unitsInWay && NewBuild != LastBuild && game.isVisible(new TilePosition(LastX, LastY))) {
							LastBuild = new TilePosition(LastX, LastY);
							buildingName = buildingType;
							return new TilePosition(LastX, LastY);

						}
					}
				}
			}
			maxDist += 6;
		}

		return ret;

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
					if (building.canLand(new TilePosition(LastX1, LastY1)) == true) {
						return new TilePosition(LastX1, LastY1);
					}
				}

			}

		}
		return ret;
	}

	public TilePosition NextExpand(Unit builder) {
		game.printf("Get Expands");
		boolean hasLocation = false;
		int stopdist = 7000;
		int dist = 0;
		int i = 0;
		int max = BWTA.getBaseLocations().size();
		boolean alreadyTaken;
		while (hasLocation == false && dist < stopdist) {
			dist = dist + 100;
			for (BaseLocation Expand : BWTA.getBaseLocations()) {
				alreadyTaken = false;
				int AmountofBases = BWTA.getBaseLocations().size();
				if (Expand.getGroundDistance(BWTA.getNearestBaseLocation(BasePos)) < dist
						&& BWTA.getGroundDistance(Expand.getTilePosition(), self.getStartLocation().getPoint()) > 50
						&& claimedBaseLocations.contains(Expand) == false) {
					game.printf("Expand Found at: " + Expand.getPosition() + " With distance from base at: "
							+ BWTA.getGroundDistance(Expand.getTilePosition(), self.getStartLocation().getPoint()));
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

	// public TilePosition getExpands() {
	// for (BaseLocation Expand : BWTA.getBaseLocations()) {
	// System.out.println(Expand.getTilePosition());
	// if (game.canBuildHere(Expand.getTilePosition(),
	// UnitType.Terran_Command_Center) == true) {
	// Iterator it = baseLocations.iterator();
	// if (baseLocations.isEmpty() == true) {
	// baseLocations.add(Expand.getTilePosition());
	// } else {
	// while (it.hasNext()) {
	// if (it.equals(Expand.getTilePosition())) {
	// System.out.println("Oh that baselocation has already been claimed for
	// myself?????");
	// } else {
	// baseLocations.add(Expand.getTilePosition());
	// System.out.println("Added " + Expand.getTilePosition() + " To an
	// claimable baselocation.");
	// ExpandPos = Expand.getTilePosition();
	// return Expand.getTilePosition();
	// }

	// }
	// }
	// }

	// }
	// return null;
	// }

	public Unit GetWorker() {
		for (Unit unit : self.getUnits()) {
			if (unit.getType() == UnitType.Terran_SCV && unit.isGatheringMinerals() == true
					&& unit.isConstructing() == false && unit.isMoving() == false && unit.getID() != scoutID
					&& unit.isRepairing() == false && unit.isTraining() == false) {
				return unit;
			}
		}
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

	public boolean IsMilitrayUnit(Unit unit) {

		if (unit.canAttack() == true && unit.getType().isWorker() == false && unit.getPlayer().isEnemy(self) == true) {
			return true;

		}

		return false;

	}

	// Returns a suitable TilePosition to build a given building type near
	// specified TilePosition aroundTile, or null if not found. (builder
	// parameter is our worker)
	public TilePosition ShitExpandPlacement(Unit builder, UnitType buildingType, TilePosition aroundTile) {
		TilePosition ret = null;
		int maxDist = 1;
		int stopDist = 3;

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
			for (int i = aroundTile.getX() - maxDist; i <= aroundTile.getX() + maxDist; i++) {
				for (int j = aroundTile.getY() - maxDist; j <= aroundTile.getY() + maxDist; j++) {
					if (game.canBuildHere(new TilePosition(i, j), buildingType, builder, false)) {
						// units that are blocking the tile
						boolean unitsInWay = false;
						for (Unit u : game.getAllUnits()) {
							if (u.getID() == builder.getID())
								continue;
							if ((Math.abs(u.getTilePosition().getX() - i) < 4)
									&& (Math.abs(u.getTilePosition().getY() - j) < 4))
								unitsInWay = true;
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

		return ret;
	}
	
	
	public Position GetSiegeLocation(Unit tank) {
		TilePosition ret = null;
		int maxDist = 1;
		int stopDist = 3;
		// Refinery, Assimilator, Extractor
		while ((maxDist < stopDist) && (ret == null)) {
			for (int i = tank.getX() - maxDist; i <= tank.getX() + maxDist; i++) {
				for (int j = tank.getY() - maxDist; j <= tank.getY() + maxDist; j++) {
					if (tank.canUseTech(TechType.Tank_Siege_Mode, new Position(i, j)) == true) {
                         return new Position(i, j);
					}
				}
			}
			maxDist += 1;
		}

		return null;
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
			i.attack(Choke);
			}
			
		}
	
	
	public UnitType SpamSpend(int mins, int gas, int macroBuildings) {
		
		if(mins > 500 && gas > 500){
			return UnitType.Terran_Factory;
		}
		
		if(mins > 2000 && self.supplyTotal() <= 200){
			return UnitType.Terran_Supply_Depot;
		}
					
		return null;
	}
		
		
	}
	
	
