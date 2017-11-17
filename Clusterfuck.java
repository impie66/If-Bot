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
	private int SavingAntiFuck = 0;
	private int Racks = 0;
	private int Academy = 0;
	private int Gases = 0;
	private int MaxGases = 1;
	private Unit scouter;
	private boolean HasScoutUnit;
	private int scoutID = 0;
	private int Factories = 0;
	private int MaxFactories = 6;
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
	private int MarinesNeed = 8;
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
	private boolean ExpandEnabled = false;
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
	private HashSet enemyBuildingMemory = new HashSet();
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
	ArrayList<Integer> repairingBuildings = new ArrayList<Integer>(30);
	private int buildingTick = 0;
	private int savetries = 0;
	private int enemyRaceBonus = 0;
	private int MaxBases = 2;

	public void run() {
		mirror.getModule().setEventListener(this);
		mirror.startGame();
	}

	@Override
	public void onUnitCreate(Unit unit) {
		System.out.println("New unit discovered " + unit.getType());

		if (unit.getType() == UnitType.Terran_SCV) {
			Workers = Workers + 1;

		}

		if (unit.getType() == UnitType.Terran_SCV && HasScoutUnit == false && hasAttackpos == false) {
			scouter = unit;
			HasScoutUnit = true;
			scoutID = scouter.getID();
			System.out.println("Scouter has been picked.. It's id is .. " + scoutID);
		}

		if (unit.getType() == UnitType.Terran_Command_Center && unit.getPlayer() == self) {
			lastExpandPos = unit.getTilePosition();
			isExpanding = false;
			expanding = false;
			Bases = Bases + 1;
			buildwait = false;
			saving = false;
		}

		if (unit.getType() == UnitType.Terran_Command_Center && unit.getPlayer() == self) {
			for (Unit neutralUnit : unit.getUnitsInRadius(250)) {
				if (neutralUnit.getType() == UnitType.Resource_Mineral_Field) {
					income = (int) (income + 2.5);
				}
			}
		}

		if (unit.getType() == UnitType.Terran_Barracks && unit.getPlayer() == self) {
			ScoutSent = true;
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
			MaxFactories = MaxFactories + 2;
			reserves = reserves - unit.getType().mineralPrice();
			reserves = reserves - unit.getType().gasPrice();
			buildwait = false;
			saving = false;
		}
		if (unit.getType() == UnitType.Terran_Engineering_Bay && unit.getPlayer() == self) {

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
			if(BWTA.getNearestChokepoint(lastExpandPos).getPoint().toTilePosition().isValid() == true){
				unit.setRallyPoint(lastExpandPos.toPosition());
			}
			Tech = Tech + 1;
			factorybuilding = factorybuilding - 1;
			reserves = reserves - unit.getType().mineralPrice();
			buildwait = false;		
			saving = false;
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
			DifBuild = DifBuild + 1;
		}

		if (unit.getType() == UnitType.Terran_Firebat && unit.getPlayer() == self) {
			Bats = Bats + 1;
			DifBuild = DifBuild + 1;
		}

		if (unit.getType() == UnitType.Terran_Medic && unit.getPlayer() == self) {
			Medics = Medics + 1;
			DifBuild = DifBuild + 1;
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

		if (unit.getType() == UnitType.Terran_Refinery && unit.getPlayer() == self) {
			int local = 1;
			Unit Gas;
			Gas = unit;
			for (Unit myUnits : self.getUnits()) {
				if (local <= 2) {
					if (myUnits.getType() == UnitType.Terran_SCV && myUnits.isGatheringMinerals() == true
							&& myUnits.getID() != scoutID) {
						myUnits.gather(unit, false);
						local = local + 1;
						System.out.println(local);
						if (local > 3) {
							break;
						}
					}
				}
			}
		}
		
		if(unit.canAttack() == true && unit.getType().isWorker() == false && unit.getType().isBuilding() == false){
			MilUnits = MilUnits + 1;
		}

		if (unit.getType() == UnitType.Terran_Bunker) {
			BunkerStarted = false;
			Bunks = Bunks + 1;
		}

		if (unit.getType() == UnitType.Terran_Command_Center && unit.getPlayer() == self && attackNum > 2) {
			expanding = false;
			buildwait = false;
			saving = false;
			//for (Unit myUnits : self.getUnits()) {
				//if (local <= 10) {
				//	if (myUnits.getType() == UnitType.Terran_SCV && myUnits.isGatheringMinerals() == true) {
						//myUnits.move(unit.getPosition());
						//local = local + 1;
						//System.out.println(local);
						//if (local > 10) {
						//	break;
						//
					//}
				//}
			//}	
		}
		if (unit.getType() == UnitType.Terran_Supply_Depot) {
			supplyBuilding = supplyBuilding - 1;
		}

		if (unit.getType() == UnitType.Terran_Siege_Tank_Tank_Mode && unit.getPlayer() == self
				&& HasCommander == false) {
			Commander = unit;
			CommanderID = unit.getID();
			HasCommander = true;
			System.out.println("Commander has been picked.. It's id is .. " + CommanderID);
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

		if (unit.getID() == CommanderID) {
			System.out.println("Commander has been killed. Picking Another ");
			HasCommander = false;
		}

		if (unit.canAttack() == true && unit.getType().isWorker() == false && unit.getPlayer().isEnemy(self) == true) {
			EnemyUnits = EnemyUnits - 1;
		}

		if (unit.canAttack() == true && unit.getType().isBuilding() == false && unit.getType().isWorker() == false) {
			MilUnits = MilUnits - 1;
		}

		if (unit.getType() == UnitType.Terran_Marine && unit.getPlayer() == self) {
			Marines = Marines - 1;
		}

		if (unit.getType() == UnitType.Terran_Command_Center && unit.getPlayer() == self) {
			Bases = Bases - 1;
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
			int n = 0;
			Unit gas = unit.getTarget();
			if (n == 0) {
				for (Unit myUnit : self.getUnits()) {
					if (myUnit.getType() == UnitType.Terran_SCV && myUnit.isGatheringMinerals() == true && n < 1
							&& myUnit.getID() != scoutID) {
						if (gas.exists() == true) {
							myUnit.gather(gas);
							n = n + 1;
						} else {
							break;
						}

					}
				}
			}
		}

		if (unit.getType() == UnitType.Zerg_Zergling && unit.getPlayer().isEnemy(self)) {
			GroundThreat = GroundThreat - 1;
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

	}

	public void onUnitDiscover(Unit unit) {

		if (unit.getType() == UnitType.Terran_Barracks && unit.getPlayer().isEnemy(self)) {
			GroundThreat = GroundThreat + 1;
			enemyRace = 1;
			System.out.println("Hostile Unit Discovered " + unit.getType());
			scouter.move(unit.getPosition(), true);
		}

		if (unit.getType() == UnitType.Terran_Barracks && unit.getPlayer().isEnemy(self) && hasAttackpos == false) {
			enemyBasePos = unit.getPosition();
			System.out.println("No base location detected.  " + unit.getType() + " Is the new attack location.");

		}

		if (unit.getType() == UnitType.Terran_Factory && unit.getPlayer().isEnemy(self) && hasAttackpos == false) {
			enemyBasePos = unit.getPosition();
			System.out.println("No base location detected.  " + unit.getType() + " Is the new attack location.");

		}

		if (unit.getType() == UnitType.Protoss_Gateway && unit.getPlayer().isEnemy(self) && hasAttackpos == false) {
			enemyBasePos = unit.getPosition();
			System.out.println("No base location detected.  " + unit.getType() + " Is the new attack location.");

		}

		if (unit.getType() == UnitType.Terran_Starport && unit.getPlayer().isEnemy(self) && hasAttackpos == false) {
			enemyBasePos = unit.getPosition();
			System.out.println("No base location detected.  " + unit.getType() + " Is the new attack location.");

		}

		if (unit.getType() == UnitType.Protoss_Pylon && unit.getPlayer().isEnemy(self) && hasAttackpos == false) {
			enemyBasePos = unit.getPosition();
			System.out.println("No base location detected.  " + unit.getType() + " Is the new attack location.");

		}

		if (unit.getType() == UnitType.Protoss_Stargate && unit.getPlayer().isEnemy(self) && hasAttackpos == false) {
			enemyBasePos = unit.getPosition();
			System.out.println("No base location detected.  " + unit.getType() + " Is the new attack location.");

		}

		if (unit.getType() == UnitType.Protoss_Robotics_Facility && unit.getPlayer().isEnemy(self)
				&& hasAttackpos == false) {
			enemyBasePos = unit.getPosition();
			System.out.println("No base location detected.  " + unit.getType() + " Is the new attack location.");

		}

		if (unit.getType() == UnitType.Zerg_Creep_Colony && unit.getPlayer().isEnemy(self) && hasAttackpos == false) {
			enemyBasePos = unit.getPosition();
			System.out.println("No base location detected.  " + unit.getType() + " Is the new attack location.");

		}

		if (unit.getType() == UnitType.Zerg_Creep_Colony && unit.getPlayer().isEnemy(self) && hasAttackpos == false) {
			enemyBasePos = unit.getPosition();
			System.out.println("No base location detected.  " + unit.getType() + " Is the new attack location.");

		}

		if (unit.getType() == UnitType.Terran_Factory && unit.getPlayer().isEnemy(self)) {
			GroundThreat = GroundThreat + 2;
			enemyRace = 1;
			System.out.println("Hostile Unit Discovered " + unit.getType());
			scouter.move(unit.getPosition(), true);
		}

		if (unit.getType() == UnitType.Protoss_Gateway && unit.getPlayer().isEnemy(self)) {
			GroundThreat = GroundThreat + 1;
			enemyRace = 2;
			System.out.println("Hostile Unit Discovered " + unit.getType());
			scouter.move(unit.getPosition(), true);
		}

		if (unit.getType() == UnitType.Zerg_Hatchery && unit.getPlayer().isEnemy(self)) {
			GroundThreat = GroundThreat + 1;
			hasAttackpos = true;
			enemyBasePos = unit.getPosition();
			enemyRace = 3;
			System.out.println("Hostile Unit Discovered " + unit.getType());
			scouter.move(unit.getPosition(), true);
		}
		if (unit.getType() == UnitType.Terran_Command_Center && unit.getPlayer().isEnemy(self)) {
			GroundThreat = GroundThreat + 1;
			hasAttackpos = true;
			enemyBasePos = unit.getPosition();
			enemyRace = 1;
			System.out.println("Hostile Unit Discovered " + unit.getType());
			scouter.move(unit.getPosition(), true);
		}
		if (unit.getType() == UnitType.Protoss_Nexus && unit.getPlayer().isEnemy(self)) {
			GroundThreat = GroundThreat + 1;
			hasAttackpos = true;
			enemyBasePos = unit.getPosition();
			enemyRace = 2;
			System.out.println("Hostile Unit Discovered " + unit.getType());
			scouter.move(unit.getPosition(), true);
		}

		if (unit.getType() == UnitType.Protoss_Dark_Templar) {
			System.out.println("Hostile invisbile unit discovered " + unit.getType());
			for (Unit detectors : self.getUnits()) {
				if (detectors.getType() == UnitType.Terran_Comsat_Station && detectors.getEnergy() >= 50) {
					detectors.useTech(TechType.Scanner_Sweep, unit.getPosition());
					System.out.println("Scanned at " + unit.getPosition());
					break;

				}
			}
		}

		if (unit.getType() == UnitType.Zerg_Lurker && unit.getPlayer().isEnemy(self)) {
			System.out.println("Hostile invisbile unit discovered " + unit.getType());
			for (Unit detectors : self.getUnits()) {
				if (detectors.getType() == UnitType.Terran_Comsat_Station && detectors.getEnergy() >= 50) {
					detectors.useTech(TechType.Scanner_Sweep, unit.getPosition());
					System.out.println("Scanned at " + unit.getPosition());
					break;

				}
			}
		}

		if (unit.getType() == UnitType.Terran_Ghost && unit.getPlayer().isEnemy(self)) {
			System.out.println("Hostile invisbile unit discovered " + unit.getType());
			for (Unit detectors : self.getUnits()) {
				if (detectors.getType() == UnitType.Terran_Comsat_Station && detectors.getEnergy() >= 50) {
					detectors.useTech(TechType.Scanner_Sweep, unit.getPosition());
					System.out.println("Scanned at " + unit.getPosition());
					break;

				}
			}
		}

		if (unit.getType() == UnitType.Terran_Wraith && unit.getPlayer().isEnemy(self)) {
			System.out.println("Hostile invisbile unit discovered " + unit.getType());
			for (Unit detectors : self.getUnits()) {
				if (detectors.getType() == UnitType.Terran_Comsat_Station && detectors.getEnergy() >= 50) {
					detectors.useTech(TechType.Scanner_Sweep, unit.getPosition());
					System.out.println("Scanned at " + unit.getPosition());
					break;

				}
			}
		}

		if (unit.canAttack() == true && unit.getType().isWorker() == false && unit.getPlayer().isEnemy(self) == true) {
			EnemyUnits = EnemyUnits + 1;
			System.out.println("Enemy Militray Unit discovered " + unit.getType());
			
		}

		if (unit.canAttack() == true && unit.getType().isBuilding() == false && unit.getType().isWorker() == false) {
			MilUnits = MilUnits - 1;
		}

	}

	@Override
	public void onStart() {
		game = mirror.getGame();
		self = game.self();

		// Use BWTA to analyze map
		// This may take a few minutes if the map is processed first time!
		System.out.println("Analyzing map...");
		BWTA.readMap();
		BWTA.analyze();
		System.out.println("Map data ready");
		BasePos = self.getStartLocation().getPoint();
		Choke = BWTA.getNearestChokepoint(BasePos).getCenter();
		game.sendText("GL HF");
		System.out.println("Expands");
		System.out.println(baseLocations);
		System.out.println(repairingBuildings.size());
		getExpands();
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
		AMPS = (int) (Workers * 1.2);
		MPS = (int) (AMPS * 0.14);
		GPS = Gases * 3;
		MaxGol = 1 + (Tanks * 2);
		MaxWorkers = Bases * 24;
		MaxGases = Bases * 1;
		VulturesMax = (Tanks * 2) + 6;
		Tick = Tick + 1;
		buildingTick = buildingTick + 1;
		AddNeeds = AddNeeds + 1;
		needs = (Factories * 10) + (Racks * 5);
		APM = game.getAPM();
		game.enableFlag(1);
		// game.setTextSize(10);
		game.drawTextScreen(10, 10, "Playing as " + self.getName() + " - " + self.getRace() + " And with.. " + APM
				+ " APM" + " With.." + game.getAverageFPS() + "FPS");
		game.drawTextScreen(10, 20, "I have " + Bases + " Bases and i have " + Factories + " Factories" + " And i have.. " + " " + MilUnits + "Militray units.");
		game.drawTextScreen(10, 30, Tick + " Ticks");
		game.drawTextScreen(10, 40, "Enemy Ground Threat.. " + GroundThreat + " And Air Threat... " + AirThreat);
		game.drawTextScreen(10, 50, +Gases + "  " + MaxGases + " " + " " + Bunks + " " + supplyBuilding + " "
				+ attacking + " " + buildwait + " " + reserves + " " + reservesgas + " " + bwub);
		game.drawTextScreen(10, 60, "Attack Point is.." + enemyBasePos + " " + hasAttackpos + " EnemyUnits: " +  EnemyUnits);
		game.drawTextScreen(10, 70, expanding + " " + lastExpandPos + " " + ExpandPos + " " + income + " " + needs + " "
				+ isExpanding + " " + Tech + "  " + DifBuild + "  " + EnemyUnits);
		game.drawTextScreen(10, 80, "NB " + NewBuild + " LB " + LastBuild + " " + buildWaitFix + " " + SavingAntiFuck);
		game.drawTextScreen(10, 90,
				"Saving: " + saving + " buildwait: " + buildwait + " Building Name: " + buildingName + "  " + buildingTick);


		if (supplyBuilding < 0) {
			supplyBuilding = 0;
		}

		if (attacking == true) {
			Mines = Mines + 1;
		}

		if (MaxGases > 2) {
			MaxGases = 2;
		}
			
		if(buildingTick > 30){
			buildingTick = 0;
		}
		
		if(enemyRace > 0 && enemyRaceBonus == 0){
			if(enemyRace == 1){
				 enemyRaceBonus = 1;
			}
			if(enemyRace == 2){
				 enemyRaceBonus = 2;
			}
			if(enemyRace == 1){
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


		if (income < needs && expanding == false && ExpandEnabled == true && MilUnits > (EnemyUnits * enemyRaceBonus)) {
		saving = true;
		System.out.println("Saving for a cc to expand xddddddddddd");
		}
	
		StringBuilder units = new StringBuilder("My units:\n");

		
		//repairs list

		
		
		for (Unit myUnit : self.getUnits()) {
			units.append(myUnit.getType()).append(" ").append(myUnit.getTilePosition()).append("\n");

			if (saving == false) {

				if (myUnit.getType() == UnitType.Terran_Command_Center && self.minerals() >= 50 && Workers < MaxWorkers
						&& myUnit.isIdle() == true) {
					myUnit.train(UnitType.Terran_SCV);
				}

				if (myUnit.getType() == UnitType.Terran_Barracks && self.minerals() >= 50 && myUnit.isIdle() == true
						&& Marines < MarinesNeed && DifBuild == 1) {
					myUnit.train(UnitType.Terran_Marine);
				}

				if (myUnit.getType() == UnitType.Terran_Barracks && self.minerals() >= 50 && myUnit.isIdle() == true
						&& Marines < MarinesNeed && DifBuild == 2) {
					myUnit.train(UnitType.Terran_Marine);
				}

				if (myUnit.getType() == UnitType.Terran_Barracks && self.minerals() >= 50 && self.gas() >= 25
						&& myUnit.isIdle() == true && Medics < MedicsNeed && Academy > 0 && DifBuild == 3) {
					myUnit.train(UnitType.Terran_Medic);
				}

				if (myUnit.getType() == UnitType.Terran_Barracks && self.minerals() >= 100 && self.gas() >= 25
						&& myUnit.isIdle() == true && Bats < BatsNeed && Academy > 0) {
					myUnit.train(UnitType.Terran_Firebat);
				}

				if (myUnit.getType() == UnitType.Terran_Factory && self.minerals() >= 200 && self.gas() >= 50
						&& Gol <= MaxGol && myUnit.isIdle() == true && Armor > 0) {
					myUnit.train(UnitType.Terran_Goliath);
				}

				if (myUnit.getType() == UnitType.Terran_Factory && self.minerals() >= 150 && self.gas() >= 100
						&& myUnit.isIdle() == true) {
					myUnit.train(UnitType.Terran_Siege_Tank_Tank_Mode);
				}

				if (myUnit.getType() == UnitType.Terran_Factory && self.minerals() >= 80 && Vultures < VulturesMax
						&& myUnit.isIdle() == true) {
					myUnit.train(UnitType.Terran_Vulture);
				}

				if (myUnit.getType() == UnitType.Terran_Machine_Shop && self.minerals() >= 200 && self.gas() >= 200
						&& myUnit.isIdle() == true && myUnit.canResearch(TechType.Tank_Siege_Mode, true)) {
					myUnit.research(TechType.Tank_Siege_Mode);
				}

				if (myUnit.getType() == UnitType.Terran_Machine_Shop && self.minerals() >= 200 && self.gas() >= 100
						&& myUnit.isIdle() == true && myUnit.canResearch(TechType.Spider_Mines, true)) {
					myUnit.research(TechType.Spider_Mines);
				}

			}

			if (myUnit.getType() == UnitType.Terran_Bunker && myUnit.getLoadedUnits().size() != 4) {
				for (Unit bunks : self.getUnits()) {
					if (bunks.getType() == UnitType.Terran_Marine
							|| bunks.getType() == UnitType.Terran_Firebat && bunks.isIdle() == true) {
						myUnit.load(bunks);
					}
				}

			}

			if (myUnit.getType() == UnitType.Terran_Siege_Tank_Tank_Mode && myUnit.isAttacking() == true
					&& myUnit.canSiege() == true) {
				myUnit.useTech(TechType.Tank_Siege_Mode);
				System.out.println("Siege");
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

			if (myUnit.getType() == UnitType.Terran_Vulture && myUnit.isAttacking() == true) {
				System.out.println("Launch");
				Unit unitt = myUnit;
				System.out.println("Vulture");
				Unit targett = myUnit.getTarget();
				System.out.println("Target");
                Position Move = GetKitePos2(unitt, targett);
				System.out.println("Call");
				if (Move.isValid() == true) {
					System.out.println("Valid");
					unitt.move(Move);
					System.out.println("move");
					game.drawCircleMap(Move, 5, Color.Orange, false);
				}
				System.out.println("Not valid");
			}

			if (myUnit.getType() == UnitType.Terran_SCV && myUnit.isConstructing() == true && myUnit.isUnderAttack() == true) {
				Position pos = myUnit.getPosition();
				for (Unit Attackers : self.getUnits()) {
					if (Attackers.getType() == UnitType.Terran_Marine) {
						Attackers.attack(pos, true);
					}
					if (Attackers.getType() == UnitType.Terran_Medic) {
						Attackers.attack(pos, true);
					}
					if (Attackers.getType() == UnitType.Terran_Firebat) {
						Attackers.attack(pos, true);
					}
					if (Attackers.getType() == UnitType.Terran_Vulture) {
						Attackers.attack(pos, true);
					}
					if (Attackers.getType() == UnitType.Terran_Siege_Tank_Tank_Mode) {
						Attackers.attack(pos, true);
					}
					if (Attackers.getType() == UnitType.Terran_Siege_Tank_Siege_Mode) {
						myUnit.unsiege();
						Attackers.attack(pos, true);
					}

				}
			}

			if (myUnit.isIdle() && attacking == true) {
				myUnit.attack(enemyBasePos, true);
			} else if (attacking == false && myUnit.isMoving() == true && orderRetreat == false) {
				myUnit.attack(BasePos.toPosition(), false);
				orderRetreat = true;
			}

			if (myUnit.isConstructing() == true) {
				Position pos = myUnit.getPosition();
				game.drawCircleMap(pos, 20, Color.Brown);
				;
			}
			
			

			// if(NewBuild != null && game.canBuildHere(NewBuild, buildingName)
			// == false){
			// buildwait = false;
			// System.out.println("Building can't fit canceling it");
			// }

			if (myUnit.isIdle() && myUnit.getType() == UnitType.Terran_Medic) {
				for (Unit unitss : myUnit.getUnitsInRadius(800)) {
					if (unitss.getType() == UnitType.Terran_Marine || unitss.getType() == UnitType.Terran_Firebat && unitss.getPlayer() == self) {
						Position pos = unitss.getPosition();
					}

				}
			}

			if (myUnit.isUnderAttack() == true) {
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
					if (targets.getPlayer().isAlly(self)) {
						allies = allies + targets.getType().mineralPrice() + targets.getType().gasPrice();
					}
				}
				if (allies > hostiles) {
					System.out.println(allies + " A > H " + hostiles);
					myUnit.attack(lastorder, true);
				} else {
					if (Commander.exists() == true) {
						myUnit.move(Commander.getPosition());
						System.out.println(hostiles + " H > A " + allies);
					} else {
						Unit unit = myUnit;
						Unit target = unit.getTarget();
						Position Retreat = GetKitePos2(unit, target);
						myUnit.move(Retreat);
						System.out.println(hostiles + " H > A " + allies);
					}
				}
			}

			if (myUnit.isUnderAttack() == true && myUnit.getType().isWorker() == false
					&& myUnit.getType().isBuilding() == false) {
				for (Unit targets : myUnit.getUnitsInRadius(1000)) {
					if (targets.canAttack() == true && targets.getType().isBuilding() == false && targets.getType().isWorker() == false) {
						targets.attack(myUnit.getPosition());
					}
				}
			}

			if (myUnit.isIdle() == true || myUnit.isMoving() == true && myUnit.getType().isWorker() == false) {
				Position LastOrder = myUnit.getOrderTargetPosition();
				for (Unit unitss : self.getUnits()) {
					if (unitss.isAttacking() == true && unitss.getPlayer() == self) {
						Position pos = unitss.getTarget().getPosition();
						myUnit.attack(pos);
						myUnit.attack(LastOrder, true);
					}
				}
			}
			
			if(myUnit.isAttacking() == true && myUnit.isAttackFrame() == false){
				Unit target = myUnit.getTarget();
				Unit unit = myUnit;
				if(target.getType() == UnitType.Protoss_Zealot){
					 Position JukePos = getJukePos(target, unit);
					 if(JukePos.isValid() == true){
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
				System.out.println(attackNum);
				attacking = true;
				Tick = 0;

				if (attackNum == 1) {
					attacking = false;
				}
				
				if(factorybuilding > 0){
					factorybuilding = 0;
				}
				
				
				if (enemyBasePos.isValid() == true && hasAttackpos == true) {
					for (Unit Attackers : self.getUnits()) {
						if (Attackers.getType() == UnitType.Terran_Marine) {
							Attackers.attack(enemyBasePos, true);
						}
						if (Attackers.getType() == UnitType.Terran_Bunker && Attackers.getLoadedUnits().size() > 3) {
							Attackers.unloadAll();
						}
						if (Attackers.getType() == UnitType.Terran_Medic) {
							Attackers.attack(enemyBasePos, true);
						}
						if (Attackers.getType() == UnitType.Terran_Firebat) {
							Attackers.attack(enemyBasePos, true);
						}
						if (Attackers.getType() == UnitType.Terran_Vulture) {
							Attackers.attack(enemyBasePos, true);
						}
						if (Attackers.getType() == UnitType.Terran_Siege_Tank_Tank_Mode) {
							Attackers.attack(enemyBasePos, true);
						}
						if (Attackers.getType() == UnitType.Terran_Siege_Tank_Tank_Mode
								&& Attackers.isSieged() == true) {
							myUnit.unsiege();
							Attackers.attack(enemyBasePos, true);
						}
						if (Attackers.getType() == UnitType.Terran_Goliath) {
							Attackers.attack(enemyBasePos, true);
						}
					}
				} else {
					for (BaseLocation b : BWTA.getBaseLocations()) {
							Position AttackPos = b.getPosition();
							for (Unit Attackers : self.getUnits()) {
								if (Attackers.getType() == UnitType.Terran_Marine && Attackers.isIdle() == true) {
									Attackers.attack(AttackPos, true);
								}
								if (Attackers.getType() == UnitType.Terran_Bunker
										&& Attackers.getLoadedUnits().size() > 3) {
									Attackers.unloadAll();
								}
								if (Attackers.getType() == UnitType.Terran_Medic && Attackers.isIdle() == true) {
									Attackers.attack(AttackPos, true);
								}
								if (Attackers.getType() == UnitType.Terran_Firebat && Attackers.isIdle() == true) {
									Attackers.attack(AttackPos, true);
								}
								if (Attackers.getType() == UnitType.Terran_Vulture && Attackers.isIdle() == true) {
									Attackers.attack(AttackPos, true);
								}
								if (Attackers.getType() == UnitType.Terran_Siege_Tank_Tank_Mode
										&& Attackers.isIdle() == true) {
									Attackers.attack(AttackPos, true);
								}
								if (Attackers.getType() == UnitType.Terran_Siege_Tank_Siege_Mode
										&& Attackers.isIdle() == true) {
									myUnit.unsiege();
									Attackers.attack(AttackPos, true);
								}
								if (Attackers.getType() == UnitType.Terran_Goliath && Attackers.isIdle() == true) {
									Attackers.attack(AttackPos, true);
								}
							}
						
					}

				}

			}

			if (attackNum > 1 && MilUnits > EnemyUnits * 2 && attacking == false) {
				attacking = true;
				System.out.println("We may have the unit advantage, let's us push on.");
			}

			if (myUnit.getType() == UnitType.Terran_Vulture && myUnit.isMoving() == true && myUnit.getSpiderMineCount() != 0 && myUnit.canUseTech(TechType.Spider_Mines) == true) {
				Unit unit = myUnit;
				Position lastorder = myUnit.getTargetPosition();
				bwta.Region spiderRegion = BWTA.getRegion(unit.getPosition());
				if(unit.canUseTech(TechType.Spider_Mines, spiderRegion.getCenter()) == true){
					myUnit.useTech(TechType.Spider_Mines,spiderRegion.getCenter());
					System.out.println("Dropping Mine at " + spiderRegion.getCenter());
					myUnit.attack(lastorder, true);
				}
				
			}
			
//repair script decided it wanted to break everything
// please help
			
			
			 if(myUnit.getType().isBuilding() == true && myUnit.getHitPoints() < myUnit.getType().maxHitPoints() && myUnit.isBeingHealed() == false && myUnit.isBeingConstructed() == false){
			 System.out.println("building get repair");
			 Unit unit = myUnit;
			 Unit repairs = GetWorker();
			 if(repairingBuildings.isEmpty() == true){
			 System.out.println("list empty, adding it ");
				 if(repairs.getType() == UnitType.Terran_SCV && repairs.getID() != scoutID && repairs.isGatheringMinerals() == true){
					 Position oldOrder = repairs.getOrderTargetPosition();
					 repairs.repair(unit);
					 repairingBuildings.add(unit.getID());
					 UpdateRepairStringBuilder();
					 }
			}
			 if(repairingBuildings.contains(myUnit.getID()) == false && repairs.getType() == UnitType.Terran_SCV && repairs.getID() != scoutID && repairs.isGatheringMinerals() == true){
			 Position oldOrder = repairs.getOrderTargetPosition();
			 repairs.repair(unit);
			 repairingBuildings.add(unit.getID());
			 System.out.println("List now added unit");
			 UpdateRepairStringBuilder();
			 }
			 else {
				 System.out.println("Building " + unit.getType() + " already has an repairer");
			}
				 
			   }	
		
			 if(myUnit.getType().isBuilding() == true && myUnit.getHitPoints() == myUnit.getType().maxHitPoints()){
	     	 int ID = myUnit.getID();
				 int index = 0;
				 Iterator it = repairingBuildings.iterator(); 
				 while(it.hasNext()){
					 index = index + 1;
					 if(it.equals(ID)){
						 repairingBuildings.remove(index);
						 System.out.println("Removing building id " + ID + " At index: " + index);
						 UpdateRepairStringBuilder();
					 }
					 if(index >= repairingBuildings.size()){
						 break;
					 }
		         }
			 }

			if (AddNeeds > 600) {
				if (GroundThreat < 0) {
					GroundThreat = 0;
				}
				if (AirThreat < 0) {
					AirThreat = 0;
				}
				MarinesNeed = 15 + (GroundThreat * 1) + (Bunks * 4);
				BatsNeed = 4 + (GroundThreat * 3);
				MedicsNeed = 4 + (Marines / 2) + (Bats / 2) + (GroundThreat * 1);
			}

			if (Mines > 800) {
				Mines = 0;
			}

			if (DifBuild >= 4) {
				DifBuild = 1;
			}

			if (isExpanding == true) {
				game.drawCircleMap(ExpandPos.toPosition(), 25, Color.Cyan, false);
			}

			if (Academy == 0) {
				DifBuild = 1;
			}

			if (buildwait == true && bwub < 1) {
				bwub = Tick + 90;

			}

			if (Tick > bwub) {
				bwub = 0;
				buildwait = false;
			}

			if (SavingAntiFuck > Tick && saving == true && expanding == false) {
				saving = false;
				System.out.println("Saving Anti Fuck triggered at " + " " + SavingAntiFuck + "  " + "Ticks");
				SavingAntiFuck = 0;
			}

			if (buildWaitFix > Tick && buildwait == true && expanding == false) {
				buildwait = false;
				buildWaitFix = 0;
				System.out.println("Build wait fix triggered at " + " " + SavingAntiFuck + "  " + "Ticks");
			}

			if (myUnit.isLifted() == true && myUnit.isIdle() == true) {
				TilePosition LandLocation = getLandLocation(myUnit, self.getStartLocation());
				if (myUnit.canLand(LandLocation) == true) {
					myUnit.land(LandLocation);
				} else {
					System.out.println("unit Can't land lol rip");
				}
			}

			if (myUnit.isUnderAttack() && myUnit.getType().isBuilding()) {
			     saving = false;
			     buildwait = false;
				Position pos = myUnit.getPosition();
				for (Unit Defenders : self.getUnits()) {
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

			if (myUnit.isUnderAttack() && myUnit.getType().isBuilding() && MilUnits < 1) {
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
					if (medics.getType() == UnitType.Terran_Medic && medics.getEnergy() > 0 && medics.isMoving() == true
							|| medics.isIdle() == true) {
						medics.useTech(TechType.Healing, myUnit);
					}

				}

			}

			if (myUnit.isAttacking() == true && myUnit.getType() == UnitType.Terran_Marine
					&& myUnit.canUseTech(TechType.Stim_Packs) == true && myUnit.isStimmed() == false) {
				myUnit.useTech(TechType.Stim_Packs);
			}

			if (myUnit.isAttacking() == true && myUnit.getType() == UnitType.Terran_Firebat
					&& myUnit.canUseTech(TechType.Stim_Packs) == true && myUnit.isStimmed() == false) {
				myUnit.useTech(TechType.Stim_Packs);
			}

			if (myUnit.isUnderAttack() && myUnit.getType().isWorker() == true && myUnit.getID() != scoutID) {
				Position pos;
				pos = myUnit.getPosition();
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
					if (Defenders.getType() == UnitType.Terran_Siege_Tank_Tank_Mode && Defenders.isIdle() == true) {
						Defenders.attack(pos, false);
					}
					if (Marines < 1 && Defenders.getType() == UnitType.Terran_SCV && Defenders.isIdle() == true) {
						Defenders.attack(pos, false);
					}
				}
			}

			if (myUnit.getType() == UnitType.Terran_Factory && myUnit.canBuild(UnitType.Terran_Machine_Shop, true)) {
				myUnit.buildAddon(UnitType.Terran_Machine_Shop);
			}

			if (myUnit.getType() == UnitType.Terran_Command_Center
					&& myUnit.canBuild(UnitType.Terran_Comsat_Station, true)) {
				myUnit.buildAddon(UnitType.Terran_Comsat_Station);
			}

			// if(myUnit.equals(CCBuilder) && ExpandPos != null && game.canBuildHere(ExpandPos, UnitType.Terran_Command_Center, CCBuilder)){
			// System.out.println("Forcing CC build" + " ");
		//	 myUnit.build(UnitType.Terran_Command_Center, ExpandPos);
			//expanding = false;
			//buildwait = false;
		 //   saving = false;
			// }

			if (myUnit.getType() == UnitType.Terran_Command_Center
					&& myUnit.canBuild(UnitType.Terran_Comsat_Station, false)) {
				Position Postion = myUnit.getPosition();
				for (Unit buildings : myUnit.getUnitsInRadius(40)) {
					if (buildings.canLift() == true && buildings.getType() != UnitType.Terran_Command_Center) {
						buildings.lift();
						System.out.println("Lifting" + " " + buildings.getType());
					}
					if(buildings.getType() == UnitType.Terran_Supply_Depot && buildings.isUnderAttack() == false){
						for (Unit helpers : myUnit.getUnitsInRadius(40)) {
							if(helpers.canAttack() == true && helpers.getType().isBuilding() == false
							&& helpers.getType().isWorker() == false && helpers.isIdle() == true && buildings.exists() == true)
							{
								
								helpers.attack(buildings);
								
						}
					}

				}
			}
		}
			if (myUnit.getType() == UnitType.Terran_Factory && myUnit.canBuild(UnitType.Terran_Machine_Shop, false)) {
				Position Postion = myUnit.getPosition();
				for (Unit buildings : myUnit.getUnitsInRadius(40)) {
					if (buildings.canLift() == true && buildings.getType() != UnitType.Terran_Command_Center && buildings.canBuildAddon() == false) {
						buildings.lift();
						System.out.println("Lifting" + " " + buildings.getType());
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

			// if it's a worker and it's idle, send it to the closest mineral
			// patch
			if (myUnit.getType().isWorker() && myUnit.isIdle() && myUnit.isGatheringGas() == false
					&& myUnit.getID() != scoutID) {
				Unit closestMineral = null;

				// find the closest mineral
				for (Unit neutralUnit : game.neutral().getUnits()) {
					if (neutralUnit.getType().isMineralField() && neutralUnit.isBeingGathered() == false) {
						if (closestMineral == null
								|| myUnit.getDistance(neutralUnit) < myUnit.getDistance(closestMineral)) {
							closestMineral = neutralUnit;
						}
					}
				}

				// if a mineral patch was found, send the worker to gather it
				if (closestMineral != null) {
					myUnit.gather(closestMineral, false);
				}
			}
		}

		for (Unit EnemyUnits1 : game.enemy().getUnits()) {
			if (EnemyUnits1.isCloaked() || EnemyUnits1.isBurrowed() && EnemyUnits1.isDetected() == false
					&& EnemyUnits1.isAttacking() == true) {
				for (Unit detectors : self.getUnits()) {
					if (detectors.getType() == UnitType.Terran_Comsat_Station && detectors.getEnergy() >= 50) {
						detectors.useTech(TechType.Scanner_Sweep, EnemyUnits1.getPosition());
						System.out.println("Scanned at " + EnemyUnits1.getPosition());
						break;

					}
				}
			}

		}
			
		// expanding script
		//expanding
		//income < needs
		if (self.minerals() >= 400 && ExpandEnabled == true && income < needs && expanding == false) {
			expanding = true;
			isExpanding = true;
			saving = true;
			SavingAntiFuck = Tick + 200;
			buildWaitFix = buildWaitFix + 200;
			System.out.println("Expanding");
			Unit myUnit = GetWorker();
			CCBuilder = myUnit;
			System.out.println("SCV");
			TilePosition buildTile = NextExpand(myUnit);
			System.out.println("Call");
			if (buildTile != null && myUnit != null) {
				buildwait = true;
				myUnit.move(buildTile.toPosition());
				System.out.println("build");
				
			}
		}
		
		
		if(CCBuilder != null && CCBuilder.isMoving() == true && game.isVisible(ExpandPos) == true && expanding == true){
			CCBuilder.build(UnitType.Terran_Command_Center, ExpandPos);
			System.out.println("CC builder build CC");
		}

	
		//new code
		//building
		
		if(saving == false && buildwait == false && expanding == false && buildingTick == 20){
			buildingTick = 0;
			
			if (self.minerals() >= 100 && Bunks != Bases * 2 && AcademyFinshed == true && isExpanding == false && buildwait == false && saving == false && BunkerStarted == false) {
				buildwait = true;
				saving = true;
				SavingAntiFuck = Tick + 200;
				buildWaitFix = buildWaitFix + 200;
				System.out.println("Building Bunkers");
				Unit myUnit = GetWorker();
				if (lastExpandPos.isValid() == true) {
					TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Bunker,
					BWTA.getNearestChokepoint(lastExpandPos).getPoint().toTilePosition());
					if (buildTile != null && myUnit != null) {
						myUnit.build(UnitType.Terran_Bunker, buildTile);
						buildwait = true;
						BunkerStarted = true;

					}
				} else {
					TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Bunker, Choke.toTilePosition());
					if (buildTile != null && myUnit != null) {
						myUnit.build(UnitType.Terran_Bunker, buildTile);
						buildwait = true;

					}
				}
				

			}
						
			if (self.minerals() >= 100 && Gases < MaxGases && isExpanding == false && buildwait == false && saving == false) {
				saving = true;
				SavingAntiFuck = Tick + 200;
				buildWaitFix = buildWaitFix + 200;
				System.out.println("Building Refinery1");
				Unit myUnit = GetWorker();
				TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Refinery, self.getStartLocation());
				System.out.println(buildTile.toPosition());
				if (buildTile != null) {
					System.out.println("Building Refinery2");
					myUnit.build(UnitType.Terran_Refinery, buildTile);
					System.out.println("Building Refinery3");
					buildwait = true;
					System.out.println("Building Refinery4");
				}
			}
			
			
			if ((self.supplyTotal() - self.supplyUsed()) < 3 && self.minerals() >= 100 && supplyBuilding != 2 && buildwait == false && saving == false) {
				saving = true;
				SavingAntiFuck = Tick + 200;
				buildWaitFix = buildWaitFix + 200;
				System.out.println("Building Supply Depot");
				Unit myUnit = GetWorker();
				TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Supply_Depot, self.getStartLocation());
				if (buildTile != null && myUnit != null) {
					myUnit.build(UnitType.Terran_Supply_Depot, buildTile);
					buildwait = true;
				}
			}
			
			
			if (Factories < MaxFactories && self.minerals() >= 200 && self.gas() >= 150 && Racks > 0 && saving == false && buildwait == false && factorybuilding < 3) {
				saving = true;
				SavingAntiFuck = Tick + 200;
				buildWaitFix = buildWaitFix + 200;
				System.out.println("Building Factory at " + " LastBuild " + NewBuild);
				Unit myUnit = GetWorker();
				TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Factory, self.getStartLocation());
				if (buildTile != null && myUnit != null) {
					myUnit.build(UnitType.Terran_Factory, buildTile);
					buildwait = true;

				}
			}
			
			
			if (RacksBuilding + Racks < MaxRacks && self.minerals() >= 150 && buildwait == false && saving == false) {
				saving = true;
				SavingAntiFuck = Tick + 200;
				buildWaitFix = buildWaitFix + 200;
				System.out.println("Building Barracks");
				Unit myUnit = GetWorker();
				TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Barracks, self.getStartLocation());
				if (buildTile != null && myUnit != null) {
					myUnit.build(UnitType.Terran_Barracks, buildTile);
					buildwait = true;
				}
			}

			
			if (Factories > 1 && self.minerals() >= 100 && self.gas() >= 50 && Armor == 0 && saving == false && buildwait == false && Factories > 0 && buildingArmor == false) {
				saving = true;
				SavingAntiFuck = Tick + 200;
				buildWaitFix = buildWaitFix + 200;
				System.out.println("Building Armory");
				Unit myUnit = GetWorker();
				TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Armory, self.getStartLocation());
				if (buildTile != null && myUnit != null) {
					myUnit.build(UnitType.Terran_Armory, buildTile);
					buildwait = true;
					buildingArmor = true;

				}
			}
			
			if (self.minerals() >= 150 && isExpanding == false && AcademyBuilt == false && buildwait == false
					&& saving == false && Racks > 0) {
				saving = true;
				SavingAntiFuck = Tick + 200;
				buildWaitFix = buildWaitFix + 200;
				System.out.println("Academy");
				Unit myUnit = GetWorker();
				TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Academy, self.getStartLocation());
				if (buildTile != null && myUnit != null) {
					myUnit.build(UnitType.Terran_Academy, buildTile);
					buildwait = true;
				}
			}
			
			
			if (self.minerals() >= 150 && Factories > 1 && Bays == 0 && isExpanding == false && buildwait == false
					&& saving == false) {
				saving = true;
				SavingAntiFuck = Tick + 200;
				buildWaitFix = buildWaitFix + 200;
				System.out.println("Building Engineering Bay");
				Unit myUnit = GetWorker();
				TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Engineering_Bay, self.getStartLocation());
				if (buildTile != null && myUnit != null) {
					myUnit.build(UnitType.Terran_Engineering_Bay, buildTile);
					buildwait = true;

				}
			}

			if (self.minerals() >= (150 + reserves) && self.gas() >= 100 && StarPorts == 0 && saving == false
					&& buildwait == false && StarPorts > 0) {
				saving = true;
				SavingAntiFuck = Tick + 500;
				System.out.println("Building Starport");
				Unit myUnit = GetWorker();
				TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Starport, self.getStartLocation());
				if (buildTile != null && myUnit != null) {
					myUnit.build(UnitType.Terran_Starport, buildTile);
					buildwait = true;
				}
			}

			if (self.minerals() >= 100 && self.gas() >= 150 && TSF == 0 && saving == false && buildwait == false
					&& StarPorts > 0) {
				saving = true;
				SavingAntiFuck = Tick + 500;
				System.out.println("Building Science_Facility");
				Unit myUnit = GetWorker();
				TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Science_Facility, self.getStartLocation());
				if (buildTile != null && myUnit != null) {
					myUnit.build(UnitType.Terran_Science_Facility, buildTile);
					buildwait = true;

				}
			}
			

			
	//end		
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
				
				if(hasAttackpos == true){
					for (BaseLocation b2 : BWTA.getBaseLocations()) {
						// If this is a possible start location,
						if (b2.isStartLocation() == false) {
							// do something. For example send some unit to attack that
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
						System.out.println("Scanned at " + unit.getPosition());
						break;

					}
				}
			}

			if (cloak.isAttacking() == true && cloak.isCloaked() == true || cloak.isBurrowed() == true) {
				Unit unit = cloak;
				for (Unit detectors : self.getUnits()) {
					if (detectors.getType() == UnitType.Terran_Comsat_Station && detectors.getEnergy() >= 50) {
						detectors.useTech(TechType.Scanner_Sweep, unit.getPosition());
						System.out.println("Scanned at " + unit.getPosition());
						break;

					}
				}
			}
	
		}

	}
	

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
				if ((n.getType() == UnitType.Resource_Vespene_Geyser)&& (Math.abs(n.getTilePosition().getX() - aroundTile.getX()) < stopDist) && (Math.abs(n.getTilePosition().getY() - aroundTile.getY()) < stopDist))
					return n.getTilePosition();
			}
		}

		if (buildingType.isResourceDepot()) {
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
							if ((Math.abs(u.getTilePosition().getX() - LastX) < 4) && (Math.abs(u.getTilePosition().getY() - LastY) < 4)) {
								unitsInWay = true;
								NewBuild = new TilePosition(LastX, LastY);
							}
						}
						if (!unitsInWay && NewBuild != LastBuild) {
							LastBuild = new TilePosition(LastX, LastY);
							System.out.println("Chosen Location is at " + LastX + LastY + " building " + buildingType+ " getbuildtile dump");
							buildingName = buildingType;
							return new TilePosition(LastX, LastY);

						}
					}
				}
			}
			maxDist += 6;
		}

		if (ret == null)
			game.printf("Unable to find suitable build position for " + buildingType.toString());
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
		if (ret == null)
			game.printf("Unable to find suitable landing position ");
		return ret;
	}

	public TilePosition NextExpand(Unit builder) {
		boolean hasLocation = false;
		int stopdist = 3000;
		int dist = 0;
		while (hasLocation == false && dist < stopdist) {
			dist = dist + 100;
			for (BaseLocation Expand : BWTA.getBaseLocations()) {
				if (Expand.getGroundDistance(BWTA.getNearestBaseLocation(BasePos)) < dist && Expand.isStartLocation() == false) {
					game.printf("Expand Location found at: " + Expand.getTilePosition());
					hasLocation = true;
					return Expand.getTilePosition();
				}

			}

		}

		expanding = false;
		buildwait = false;
		saving = false;
		return null;
	}

	public TilePosition getExpands() {
		for (BaseLocation Expand : BWTA.getBaseLocations()) {
			System.out.println(Expand.getTilePosition());
			if (game.canBuildHere(Expand.getTilePosition(), UnitType.Terran_Command_Center) == true) {
				Iterator it = baseLocations.iterator();
				if (baseLocations.isEmpty() == true) {
					baseLocations.add(Expand.getTilePosition());
				} else {
					while (it.hasNext()) {
						if (it.equals(Expand.getTilePosition())) {
							System.out.println("Oh that baselocation has already been claimed for myself?????");
						} else {
							baseLocations.add(Expand.getTilePosition());
							System.out.println("Added " + Expand.getTilePosition() + " To an claimable baselocation.");
							ExpandPos = Expand.getTilePosition();
							return Expand.getTilePosition();
						}

					}
				}
			}

		}
		return null;
	}

	public Unit GetWorker() {
		List<Unit> Units = self.getUnits();
		for (Unit unit : Units) {
			if (unit.getType() == UnitType.Terran_SCV && unit.isGatheringMinerals() == true && unit.isConstructing() == false && unit.isMoving() == false && unit.getID() != scoutID) {
				Unit newUnit = unit;
				return unit;
			}
		}
		return null;
	}

	public Position GetKitePos(Unit unit, Unit target) {
		System.out.println("Called");
		Position Kite1 = new Position(target.getX() - unit.getX(), target.getY() - unit.getY());
		System.out.println("Pos1" + Kite1);
		double Kite2 = Math.atan2(Kite1.getX(), Kite1.getY());
		System.out.println("Pos2" + Kite2);
		int Int1 = (int) (64 * Math.cos(Kite2));
		System.out.println("math1" + Int1);
		int Int2 = (int) (64 * Math.sin(Kite2));
		System.out.println("math2" + Int2);
		Kite1 = new Position(Int1, Int2);
		System.out.println("New Kite1" + Kite1);
		return Kite1;
	}

	public Position GetKitePos2(Unit unitt, Unit targett) {
		Position fp1 = new Position(unitt.getX() - targett.getX(), unitt.getY() - targett.getY());
		Position fp2 = new Position(unitt.getX(), unitt.getY());
		Position fp3 = new Position(fp1.getX(), fp1.getY() + fp2.getX() + fp2.getY());

		return fp3;

	}
	
	public Position getJukePos(Unit unitt, Unit targett){
		Position fp1 =  new Position(unitt.getX() - targett.getX(), unitt.getY() - targett.getY());
		Position fp2 =  new Position(unitt.getX(), unitt.getY());
		Position fp3 = new Position(fp1.getX() + fp2.getX(), fp1.getY() + fp2.getY());
		Position Move = fp3;
		if(Move.isValid() == true && Move != null){
		return Move;
		}
		else
		{
		return null;
		}
	}
	
	public void UpdateRepairStringBuilder(){
		StringBuilder repairslist = new StringBuilder("Buildings that need repairing:\r");
		if(repairingBuildings != null){
			System.out.println("repairingbuildings now appending");
			 Iterator it = repairingBuildings.iterator(); 
            while(it.hasNext()){
            repairslist.append(it.toString()).append("\r");
             }
           game.drawTextScreen(10,300, repairslist.toString());
           game.printf(repairslist.toString());
		}
        
	}

}
