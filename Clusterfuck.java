import java.lang.reflect.Constructor;
import java.util.Random;

import bwapi.*;
import bwta.BWTA;
import bwta.BaseLocation;

public class TestBot1 extends DefaultBWListener {

    private int Workers = 0;
    private int AMPS = 0;
    private int MPS = 0;
    private int needs;
    private int GPS = 0;
    private int income = 0;
    private int MaxWorkers = 19;
    private int MaxRacks = 1;
    private int Bases = 0;
    private int Racks = 0;
    private int Academy = 0;
    private int Gases = 0;
    private int MaxGases = 1;
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
    private int MarinesNeed = 4;
    private int BatsNeed = 3;
    private int MedicsNeed = 4;
    private int AddNeeds = 0;
    private int Vultures = 0;
    private int VulturesMax = 0;
    private int Expand = 0;
    private int attackNum = 0;
    private boolean orderRetreat = false;
    private int Bunks = 0;
    private int LastX;
    private int LastY;
    private boolean HasExpanded = false;
    private int APM = 0;
    private int enemyRace = 0;
    private int ArmySize = 0;
    private int forceSupply = 0;
    private int supplyBuilding = 0;
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
    private TilePosition lastExpandPos;
    private Position MainChoke;
    private Position Choke;
    private TilePosition BasePos;
    private boolean cheats = true;
    

	private Mirror mirror = new Mirror();
   
    private Game game;

    private Player self;
	private Unit GetBuilder;
	private int attack;

    public void run() {
        mirror.getModule().setEventListener(this);
        mirror.startGame();
    }

    @Override
    public void onUnitCreate(Unit unit) {
        System.out.println("New unit discovered " + unit.getType());
        
        
        if(unit.getType() == UnitType.Terran_SCV){
        	Workers = Workers + 1;
        }
        
        if(unit.getType() == UnitType.Terran_SCV && HasScoutUnit == false){
        	scouter = unit;
        	HasScoutUnit = true;
        	scoutID = scouter.getID();
        	System.out.println("Scouter has been picked.. It's id is .. " + scoutID);
        }
        
        
        if(unit.getType() == UnitType.Terran_Command_Center && unit.getPlayer() == self){
        	lastExpandPos = unit.getTilePosition();
        	isExpanding = false;
        	expanding = false;
        	Bases = Bases + 1;
        }
        
        if(unit.getType() == UnitType.Terran_Command_Center && unit.getPlayer() == self){
        	for (Unit neutralUnit : unit.getUnitsInRadius(250)) {
        		if(neutralUnit.getType() == UnitType.Resource_Mineral_Field){
        			income = (int) (income + 2.5);
        		}
        	}
        }
           
        
        if(unit.getType() == UnitType.Terran_Barracks && unit.getPlayer() == self){
        	Racks = Racks + 1;
        }
        
        
        if(unit.getType() == UnitType.Terran_Refinery && unit.getPlayer() == self){
        	Gases = Gases + 1;
        }
        
        if(unit.getType() == UnitType.Terran_Academy && unit.getPlayer() == self){
        	Academy = Academy + 1;
        }
        
        if(unit.getType() == UnitType.Terran_Armory && unit.getPlayer() == self){
        	Armor = Armor + 1;
        	MaxFactories = MaxFactories + 2;
        }
        if(unit.getType() == UnitType.Terran_Engineering_Bay && unit.getPlayer() == self){
        	Bays = Bays + 1;
        }
        if(unit.getType() == UnitType.Terran_Missile_Turret && unit.getPlayer() == self){
        	Turrets = Turrets + 1;
        }
        
        if(unit.getType() == UnitType.Terran_Supply_Depot && unit.getPlayer() == self){
        	supplyBuilding = supplyBuilding + 1;
        }
        
        if(unit.getType() == UnitType.Terran_Factory && unit.getPlayer() == self){
        	Factories = Factories + 1;
        }
        
        if(unit.getType() == UnitType.Terran_Starport && unit.getPlayer() == self){
        	StarPorts = StarPorts + 1;
        }
        
        if(unit.getType() == UnitType.Terran_Science_Facility && unit.getPlayer() == self){
        	TSF = TSF + 1;
        }
        
        if(unit.getType() == UnitType.Terran_Marine && unit.getPlayer() == self){
        	Marines = Marines + 1;
        }
        
        if(unit.getType() == UnitType.Terran_Firebat && unit.getPlayer() == self){
        	Bats = Bats + 1;
        }
        
        if(unit.getType() == UnitType.Terran_Medic && unit.getPlayer() == self){
        	Medics = Medics + 1;
        }
        
        if(unit.getType() == UnitType.Terran_Vulture && unit.getPlayer() == self){
        	Vultures = Vultures + 1;
        }
        
        if(unit.getType() == UnitType.Terran_Siege_Tank_Tank_Mode  && unit.getPlayer() == self){
        	Tanks = Tanks + 1;
        }
        
        
        if(unit.getType() == UnitType.Terran_Medic && unit.getPlayer() == self){
        	Medics = Medics + 1;
        }
        
        if(unit.getType() == UnitType.Terran_Firebat && unit.getPlayer() == self){
        	Bats = Bats + 1;
        }
       
          
   }
    
    public void onEnd(boolean isWinner){
// A little bit of kung pow doesn't hurt anyone.
    	Random rand = new Random();
    	int  n = rand.nextInt(3) + 1;
    	
    	if(isWinner == true && n == 1){
    		game.sendText("GG");
    		
    	}
    	if(isWinner == true && n == 2){
    		game.sendText("Ha, face to foot style, how'd you like it?");
    		
    	}
    	if(isWinner == true && n == 3){
    		game.sendText("Oh yeah? Try my nuts to your fist style.");
    		
    	}
    	if(isWinner == false && n == 1){
    		game.sendText("I must apologize for Wimp Lo, he is an idiot. We have purposely trained him wrong, as a joke");
    	}
    	if(isWinner == false && n == 2){
    		game.sendText("Please stop, Wimp Lo sucks as a fighter, a child could beat him.");
    	}
    	if(isWinner == false && n == 3){
    		game.sendText(" I'm bleeding, making me the victor.");
    	}
     
     
     
    }
    
    public void onUnitMorph(Unit unit) {
        if(unit.getType() == UnitType.Terran_Refinery && unit.getPlayer() == self){
        	Gases = Gases + 1;
        }
    	
    }
    
    
    public void onUnitComplete(Unit unit) {
    	
        if(unit.getType() == UnitType.Terran_Refinery && unit.getPlayer() == self){
        	int local = 1;
        	Unit Gas;
        	Gas = unit;
        	for (Unit myUnits: self.getUnits()) {
        		if(local <= 2){
        		if (myUnits.getType() == UnitType.Terran_SCV && myUnits.isGatheringMinerals() == true){
        			myUnits.gather(unit, false);
        			local = local + 1;
        			System.out.println(local);
        			if(local > 3){
        				break;
        			}
        		}
        	}
        }
      }
        
        if(unit.getType() == UnitType.Terran_Barracks && unit.getPlayer() == self){
        	}
        
        if(unit.getType() == UnitType.Terran_Factory && unit.getPlayer() == self){
        	unit.buildAddon(UnitType.Terran_Machine_Shop);
        	}
        
        if(unit.getType() == UnitType.Terran_Academy && unit.getPlayer() == self && self.minerals() > 150 && self.gas() >= 150){
        	unit.upgrade(UpgradeType.U_238_Shells);
        }
        
        if(unit.getType() == UnitType.Terran_Armory && unit.getPlayer() == self && self.minerals() > 150 && self.gas() >= 150){
        	unit.upgrade(UpgradeType.Terran_Vehicle_Weapons);
        }
        
        if(unit.getType() == UnitType.Terran_Academy && unit.getPlayer() == self && self.minerals() > 150 && self.gas() >= 150){
        	unit.research(TechType.Stim_Packs);
        }
        
        if(unit.getType() == UnitType.Terran_Machine_Shop && unit.getPlayer() == self && self.minerals() > 100 && self.gas() >= 100){
        	unit.research(TechType.Spider_Mines);
        }
        
        if(unit.getType() == UnitType.Terran_Machine_Shop && unit.getPlayer() == self && self.minerals() > 150 && self.gas() >= 100){
        	unit.research(TechType.Tank_Siege_Mode);
        }
        
        if(unit.getType() == UnitType.Terran_Bunker){
        	Bunks = Bunks + 1;
        }
        
        if(unit.getType() == UnitType.Terran_Command_Center && unit.getPlayer() == self && attackNum > 2){
        	expanding = false;
        	int local = 0;
        	for (Unit myUnits: self.getUnits()) {
        		if(local <= 7){
        		if (myUnits.getType() == UnitType.Terran_SCV && myUnits.isGatheringMinerals() == true){
        			myUnits.move(unit.getPosition());
        			local = local + 1;
        			System.out.println(local);
        			if(local > 7){
        				break;
        			}
        		}
        	}
        }

        }
        
        if(unit.getType() == UnitType.Terran_Supply_Depot){
        	supplyBuilding = supplyBuilding - 1;
        }
        
        if(unit.getType() == UnitType.Terran_Siege_Tank_Tank_Mode  && unit.getPlayer() == self && HasCommander == false){
        	Commander = unit;
        	CommanderID = unit.getID();
        	HasCommander = true;
        	System.out.println("Commander has been picked.. It's id is .. " + CommanderID);
        }
        
        

        
    }
    
    public void onUnitDestroy(Unit unit){
    	
        if(unit.getID() == CommanderID){
        	System.out.println("Commander has been killed. Picking Another ");
        	HasCommander = false;
        }
    	
        if(unit.getType() == UnitType.Terran_Marine && unit.getPlayer() == self){
        	Marines = Marines - 1;
        }
        
        if(unit.getType() == UnitType.Terran_SCV && unit.getPlayer() == self && unit.getID() == scoutID){
        	HasScoutUnit = false;
        	
        }
               
        if(unit.getType() == UnitType.Terran_Barracks && unit.getPlayer() == self){
        	Racks = Racks - 1;
        }
        
        if(unit.getType() == UnitType.Terran_Academy && unit.getPlayer() == self){
        	Academy = 0;
        }
        
        if(unit.getType() == UnitType.Terran_Factory && unit.getPlayer() == self){
        	Factories = Factories - 1;
        }
        
        if(unit.getType() == UnitType.Terran_Bunker && unit.getPlayer() == self){
        	Bunks = Bunks - 1;
        }
           
        if(unit.getType() == UnitType.Terran_SCV && unit.getPlayer() == self){
        	Workers = Workers - 1;
        }
        
        if(unit.getType() == UnitType.Terran_SCV && unit.isGatheringGas() == true && unit.getPlayer() == self){
        	int n = 0;
        	Unit gas = unit.getTarget();
        	if(n == 0){
        		for (Unit myUnit : self.getUnits()) {
        			if(myUnit.getType() == UnitType.Terran_SCV && myUnit.isGatheringMinerals() == true && n < 1){
        				myUnit.gather(gas);
        				n = n + 1;
        			}
        		}
        		}
        	}
              
        if(unit.getType() == UnitType.Zerg_Zergling && unit.getPlayer().isEnemy(self)){
        	GroundThreat = GroundThreat - 1;
        }
        
        if(unit.getType() == UnitType.Zerg_Hydralisk && unit.getPlayer().isEnemy(self)){
        }
        
        if(unit.getType() == UnitType.Terran_Marine && unit.getPlayer().isEnemy(self)){
        }
        
        if(unit.getType() == UnitType.Terran_Firebat && unit.getPlayer().isEnemy(self)){
        }
        
        if(unit.getType() == UnitType.Protoss_Dragoon && unit.getPlayer().isEnemy(self)){
        }
        
        if(unit.getType() == UnitType.Protoss_Zealot && unit.getPlayer().isEnemy(self)){
        }
        
        if(unit.getType() == UnitType.Terran_Command_Center && unit.getPlayer().isEnemy(self) && hasAttackpos == true){
        	hasAttackpos = false;
        }
        
        if(unit.getType() == UnitType.Protoss_Nexus && unit.getPlayer().isEnemy(self) && hasAttackpos == true){
        	hasAttackpos = false;
        }
        
        if(unit.getType() == UnitType.Zerg_Hatchery && unit.getPlayer().isEnemy(self) && hasAttackpos == true){
        	hasAttackpos = false;
        }
        
        if(unit.getType() == UnitType.Zerg_Lair && unit.getPlayer().isEnemy(self) && hasAttackpos == true){
        	hasAttackpos = false;
        }
        
        if(unit.getType() == UnitType.Zerg_Hive && unit.getPlayer().isEnemy(self) && hasAttackpos == true){
        	hasAttackpos = false;
        }
        
	
    }
    
    public void onUnitDiscover(Unit unit){
    	
        if(unit.getType() == UnitType.Terran_Barracks && unit.getPlayer().isEnemy(self)){
        	GroundThreat = GroundThreat + 1;
        	enemyRace = 1;
        	System.out.println("Hostile Unit Discovered " + unit.getType());
        	scouter.move(unit.getPosition(), true);
        }
        
        if(unit.getType() == UnitType.Terran_Barracks && unit.getPlayer().isEnemy(self) && hasAttackpos == false){
        	enemyBasePos = unit.getPosition();
        	System.out.println("No base location detected.  " + unit.getType() + " Is the new attack location.");

        }
        
        if(unit.getType() == UnitType.Terran_Factory && unit.getPlayer().isEnemy(self) && hasAttackpos == false){
        	enemyBasePos = unit.getPosition();
        	System.out.println("No base location detected.  " + unit.getType() + " Is the new attack location.");

        }
        
        if(unit.getType() == UnitType.Protoss_Gateway && unit.getPlayer().isEnemy(self) && hasAttackpos == false){
        	enemyBasePos = unit.getPosition();
        	System.out.println("No base location detected.  " + unit.getType() + " Is the new attack location.");

        }
        
        if(unit.getType() == UnitType.Terran_Starport && unit.getPlayer().isEnemy(self) && hasAttackpos == false){
        	enemyBasePos = unit.getPosition();
        	System.out.println("No base location detected.  " + unit.getType() + " Is the new attack location.");

        }
        
        if(unit.getType() == UnitType.Protoss_Pylon && unit.getPlayer().isEnemy(self) && hasAttackpos == false){
        	enemyBasePos = unit.getPosition();
        	System.out.println("No base location detected.  " + unit.getType() + " Is the new attack location.");

        }
        
        if(unit.getType() == UnitType.Protoss_Stargate && unit.getPlayer().isEnemy(self) && hasAttackpos == false){
        	enemyBasePos = unit.getPosition();
        	System.out.println("No base location detected.  " + unit.getType() + " Is the new attack location.");

        }
        
        if(unit.getType() == UnitType.Protoss_Robotics_Facility && unit.getPlayer().isEnemy(self) && hasAttackpos == false){
        	enemyBasePos = unit.getPosition();
        	System.out.println("No base location detected.  " + unit.getType() + " Is the new attack location.");

        }   
        
        if(unit.getType() == UnitType.Zerg_Creep_Colony && unit.getPlayer().isEnemy(self) && hasAttackpos == false){
        	enemyBasePos = unit.getPosition();
        	System.out.println("No base location detected.  " + unit.getType() + " Is the new attack location.");

        } 
        
        if(unit.getType() == UnitType.Zerg_Creep_Colony && unit.getPlayer().isEnemy(self) && hasAttackpos == false){
        	enemyBasePos = unit.getPosition();
        	System.out.println("No base location detected.  " + unit.getType() + " Is the new attack location.");

        } 
        
        if(unit.getType() == UnitType.Terran_Factory && unit.getPlayer().isEnemy(self)){
        	GroundThreat = GroundThreat + 2;
        	enemyRace = 1;
        	System.out.println("Hostile Unit Discovered " + unit.getType());
        	scouter.move(unit.getPosition(), true);
        }
        
        if(unit.getType() == UnitType.Protoss_Gateway && unit.getPlayer().isEnemy(self)){
        	GroundThreat = GroundThreat + 1;
        	enemyRace = 2;
        	System.out.println("Hostile Unit Discovered " + unit.getType());
        	scouter.move(unit.getPosition(), true);
        }
        
        if(unit.getType() == UnitType.Zerg_Hatchery && unit.getPlayer().isEnemy(self)){
        	GroundThreat = GroundThreat + 1;
        	hasAttackpos = true;
        	enemyBasePos = unit.getPosition();
        	enemyRace = 3;
        	System.out.println("Hostile Unit Discovered " + unit.getType());
        	scouter.move(unit.getPosition(), true);
        }
        if(unit.getType() == UnitType.Terran_Command_Center && unit.getPlayer().isEnemy(self)){
        	GroundThreat = GroundThreat + 1;
        	hasAttackpos = true;
        	enemyBasePos = unit.getPosition();
        	enemyRace = 1;
        	System.out.println("Hostile Unit Discovered " + unit.getType());
        	scouter.move(unit.getPosition(), true);
        }
        if(unit.getType() == UnitType.Protoss_Nexus && unit.getPlayer().isEnemy(self)){
        	GroundThreat = GroundThreat + 1;
        	hasAttackpos = true;
        	enemyBasePos = unit.getPosition();
        	enemyRace = 2;
        	System.out.println("Hostile Unit Discovered " + unit.getType());
        	scouter.move(unit.getPosition(), true);
        }
        
        if(unit.getType() == UnitType.Protoss_Dark_Templar){
        	GroundThreat = GroundThreat + 3;
        	System.out.println("Hostile invisbile unit discovered " + unit.getType());
        	 for (Unit detectors : self.getUnits()) {
        		 if(detectors.getType() == UnitType.Terran_Comsat_Station && detectors.getEnergy() >= 50){
        			 detectors.useTech(TechType.Scanner_Sweep, unit.getPosition());
        			 System.out.println("Scanned at " + unit.getPosition());
        			 break;
        			 
        		 }
        		 }
        }
        
        if(unit.getType() == UnitType.Zerg_Lurker && unit.getPlayer().isEnemy(self)){
        	GroundThreat = GroundThreat + 3;
        	System.out.println("Hostile invisbile unit discovered " + unit.getType());
        	 for (Unit detectors : self.getUnits()) {
        		 if(detectors.getType() == UnitType.Terran_Comsat_Station && detectors.getEnergy() >= 50){
        			 detectors.useTech(TechType.Scanner_Sweep, unit.getPosition());
        			 System.out.println("Scanned at " + unit.getPosition());
        			 break;
        			 
        		 }
        		 }
        }
        
        if(unit.getType() == UnitType.Terran_Ghost && unit.getPlayer().isEnemy(self)){
        	GroundThreat = GroundThreat + 3;
        	System.out.println("Hostile invisbile unit discovered " + unit.getType());
        	 for (Unit detectors : self.getUnits()) {
        		 if(detectors.getType() == UnitType.Terran_Comsat_Station && detectors.getEnergy() >= 50){
        			 detectors.useTech(TechType.Scanner_Sweep, unit.getPosition());
        			 System.out.println("Scanned at " + unit.getPosition());
        			 break;
        			 
        		 }
        		 }
        }
        
        if(unit.getType() == UnitType.Terran_Wraith && unit.getPlayer().isEnemy(self)){
        	GroundThreat = GroundThreat + 3;
        	System.out.println("Hostile invisbile unit discovered " + unit.getType());
        	 for (Unit detectors : self.getUnits()) {
        		 if(detectors.getType() == UnitType.Terran_Comsat_Station && detectors.getEnergy() >= 50){
        			 detectors.useTech(TechType.Scanner_Sweep, unit.getPosition());
        			 System.out.println("Scanned at " + unit.getPosition());
        			 break;
        			 
        		 }
        	}
        }
             
    }
 
         
   

    @Override
    public void onStart() {
        game = mirror.getGame();
        self = game.self();
        
        //Use BWTA to analyze map
        //This may take a few minutes if the map is processed first time!
        System.out.println("Analyzing map...");
        BWTA.readMap();
        BWTA.analyze();
        System.out.println("Map data ready");
        BasePos = self.getStartLocation().getPoint();           
   }
    
    public static Color Wlue; {
    	Wlue = Color.Blue;
    }
    
    public static Color Wed; {
    	Wed = Color.Red;
    }
 

	@Override
    public void onFrame() {
    	AMPS = (int) (Workers * 1.2);
    	MPS = (int) (AMPS * 0.14);
    	GPS = Gases * 3;
    	MaxGol = (Tanks * 2) + 4;
    	MaxWorkers = Bases * 17;
    	MaxGases = Bases * 1;
    	VulturesMax = (Tanks * 2) + 6;
    	Tick = Tick + 1;
    	AddNeeds = AddNeeds + 1;
    	needs = (Factories * 10) + (Racks * 5);
    	APM = game.getAPM();
        //game.setTextSize(10);
        game.drawTextScreen(10, 10, "Playing as " + self.getName() + " - " + self.getRace() + " And with.. " + APM + " APM" + " With.." + game.getAverageFPS() + "FPS");
        game.drawTextScreen(10, 20, "I have " + Bases + " Bases and i have " + Factories + " Factories");
        game.drawTextScreen(10, 30, Tick + " Ticks");
        game.drawTextScreen(10, 40, "Enemy Ground Threat.. " + GroundThreat + " And Air Threat... " + AirThreat);
        game.drawTextScreen(10, 50, + Gases + "  " + MaxGases + " " + " " + Bunks + " " + supplyBuilding + " " + attacking);
        game.drawTextScreen(10, 60, "Attack Point is.." + enemyBasePos + " " + hasAttackpos);
        game.drawTextScreen(10, 70, expanding + " " + lastExpandPos + " " + ExpandPos + " " + income + " " + needs + " " + isExpanding);
        		
        if(supplyBuilding < 0){
        	supplyBuilding = 0;
        }
        
        if(attacking == true){
        	Mines = Mines + 1;
        }
        
        if(MaxGases > 2){
        	MaxGases = 2;
        }
    
        StringBuilder units = new StringBuilder("My units:\n");

        //iterate through my units
        for (Unit myUnit : self.getUnits()) {
            units.append(myUnit.getType()).append(" ").append(myUnit.getTilePosition()).append("\n");

            //if there's enough minerals, train an SCV
            
            if (myUnit.getType() == UnitType.Terran_Command_Center && self.minerals() >= 50 && Workers < MaxWorkers && myUnit.isIdle() == true){
                myUnit.train(UnitType.Terran_SCV);
            }
            
            if(expanding == false){
            if (myUnit.getType() == UnitType.Terran_Barracks && self.minerals() >= 50 && myUnit.isIdle() == true && Marines < MarinesNeed){
                myUnit.train(UnitType.Terran_Marine);
            }
            
            if (myUnit.getType() == UnitType.Terran_Barracks && self.minerals() >= 100 && self.gas() >= 25 && myUnit.isIdle() == true  && Bats < BatsNeed && Academy > 0){
                myUnit.train(UnitType.Terran_Firebat);
            }
            
            if (myUnit.getType() == UnitType.Terran_Barracks && self.minerals() >= 50 && self.gas() >= 25 && myUnit.isIdle() == true  && Medics < MedicsNeed && Academy > 0){
                myUnit.train(UnitType.Terran_Medic);
            }
            
            if (myUnit.getType() == UnitType.Terran_Factory && self.minerals() >= 200 && self.gas() >= 50 && Gol < MaxGol && myUnit.isIdle() == true && Armor > 0){
                myUnit.train(UnitType.Terran_Goliath);
            }
            
            if (myUnit.getType() == UnitType.Terran_Factory && self.minerals() >= 150 && self.gas() >= 100 && myUnit.isIdle() == true){
                myUnit.train(UnitType.Terran_Siege_Tank_Tank_Mode);
            }
            
            if (myUnit.getType() == UnitType.Terran_Factory && self.minerals() >= 100 && Vultures < VulturesMax && myUnit.isIdle() == true){
                myUnit.train(UnitType.Terran_Vulture);
            }
            
            }
            
            
            if (myUnit.getType() == UnitType.Terran_Machine_Shop && self.minerals() >= 200 && self.gas() >= 200 && myUnit.isIdle() == true && myUnit.canResearch(TechType.Tank_Siege_Mode, true)){
                myUnit.research(TechType.Tank_Siege_Mode);
            }
            
            if (myUnit.getType() == UnitType.Terran_Machine_Shop && self.minerals() >= 200 && self.gas() >= 200 && myUnit.isIdle() == true && myUnit.canResearch(TechType.Spider_Mines, true)){
                myUnit.research(TechType.Spider_Mines);
            }
            
            if (myUnit.getType() == UnitType.Terran_Bunker && myUnit.getLoadedUnits().size() != 4){
            	 for (Unit bunks : self.getUnits()) {
            		 if(bunks.getType() == UnitType.Terran_Marine && bunks.isIdle() == true){
            			 myUnit.load(bunks);
            		 }
            	 }
                
            }
            
            if(myUnit.getType() == UnitType.Terran_Siege_Tank_Tank_Mode && myUnit.isAttacking() == true && myUnit.canSiege() == true){
            	myUnit.useTech(TechType.Tank_Siege_Mode);
            }
            
            if(myUnit.getType() == UnitType.Terran_Siege_Tank_Siege_Mode && myUnit.isIdle() == true){
            	int hostile = 0;
            	Unit unit = myUnit;
             for(Unit targets : unit.getUnitsInRadius(400)){
            	if(targets.getPlayer().isEnemy(self) && targets.isFlying() == false){
            	 hostile = hostile + 1;
            	}
             }     
       	       if(hostile < 1){
    		   unit.unsiege();
    		    break;
    	              }
            }
                   
            if(myUnit.getType() == UnitType.Terran_SCV && myUnit.isConstructing() && myUnit.isUnderAttack() == true){
            	Position pos = myUnit.getPosition();
            	for (Unit Attackers  : self.getUnits()) {
            		if(Attackers.getType() == UnitType.Terran_Marine){
            		Attackers.attack(pos, true);
            		}
            		if(Attackers.getType() == UnitType.Terran_Medic){
            		Attackers.attack(pos, true);
            		}
            		if(Attackers.getType() == UnitType.Terran_Firebat){
            		Attackers.attack(pos, true);
            		}
            		if(Attackers.getType() == UnitType.Terran_Vulture){
            		Attackers.attack(pos, true);
            		}
            		if(Attackers.getType() == UnitType.Terran_Siege_Tank_Tank_Mode){
            			Attackers.attack(pos,  true);
            		}
            		if(Attackers.getType() == UnitType.Terran_Siege_Tank_Siege_Mode){
            			myUnit.unsiege();
            			Attackers.attack(pos, true);
            		}
            		
 			}
           }
                    
            if(myUnit.isIdle() && attacking == true){
            	myUnit.attack(enemyBasePos, true);
            }
            else if (attacking == false && myUnit.isMoving() == true && orderRetreat == false){
            	myUnit.attack(BasePos.toPosition(), false);
            	orderRetreat = true;
            }
            
            
            if(myUnit.isUnderAttack() == true){
            	Position lastorder = myUnit.getTargetPosition();
            	int hostiles = 0;
            	int allies = 0;
                for(Unit targets : myUnit.getUnitsInRadius(400)){
                	if(targets.getPlayer().isEnemy(self)){
                	 hostiles = hostiles + targets.getType().mineralPrice() + targets.getType().gasPrice();
             		if(targets.getType() == UnitType.Protoss_Photon_Cannon){
            			hostiles = hostiles + 700;
            		}
            		if(targets.getType() == UnitType.Zerg_Sunken_Colony){
            			hostiles = hostiles + 700;
            		}
            		if(targets.getType() == UnitType.Protoss_Zealot){
            			hostiles = hostiles + 200;
            		}

                	}	
                	if(targets.getPlayer().isAlly(self)){
                   	 allies = allies + targets.getType().mineralPrice() + targets.getType().gasPrice();
                   	 
                }
            }
                if(allies > hostiles){
          		  System.out.println(allies + " A > H " + hostiles);
          		  myUnit.attack(lastorder, true);
                	}
                else {
                	if(Commander.exists() == true){
              		  myUnit.move(Commander.getPosition());
              		  System.out.println(hostiles + " H > A " + allies);
          		  }
          		  else{
              		  myUnit.move(BasePos.toPosition());
              		  System.out.println(hostiles + " H > A " + allies);
          		  }
                }
            }     
           
            if(myUnit.isUnderAttack() == true && myUnit.getType().isWorker() == false && myUnit.getType().isBuilding() == false){
            	for(Unit targets : myUnit.getUnitsInRadius(600)){
            		if(targets.isIdle() == true && targets.getType().isWorker() == false){
            			targets.attack(myUnit.getPosition());
            		}
            	}
            }
	
            if(scouter.isUnderAttack() == true){
            TilePosition pos = self.getStartLocation();
        	scouter.move(pos.getPoint().toPosition(), false);
            }
            
            if(Tick > 2500 && attacking == true){
            	attacking = false;
            }
  
            if(Tick > (7000 - (attackNum * 500))){
            	Mines = 0;
            	attackNum = attackNum + 1;
            	orderRetreat = false;
            	System.out.println(attackNum);
            	attacking = true;
            	Tick = 0;
            	if(enemyBasePos.isValid() == true && hasAttackpos == true){ 
                 	for (Unit Attackers  : self.getUnits()) {
                		if(Attackers.getType() == UnitType.Terran_Marine){
                		Attackers.attack(enemyBasePos, true);
                		}
                		if(Attackers.getType() == UnitType.Terran_Bunker && Attackers.getLoadedUnits().size() > 3){
                		Attackers.unloadAll();
                		}
                		if(Attackers.getType() == UnitType.Terran_Medic){
                		Attackers.attack(enemyBasePos, true);
                		}
                		if(Attackers.getType() == UnitType.Terran_Firebat){
                		Attackers.attack(enemyBasePos, true);
                		}
                		if(Attackers.getType() == UnitType.Terran_Vulture){
                		Attackers.attack(enemyBasePos, true);
                		}
                		if(Attackers.getType() == UnitType.Terran_Siege_Tank_Tank_Mode){
                			Attackers.attack(enemyBasePos, true);
                		}
                		if(Attackers.getType() == UnitType.Terran_Siege_Tank_Tank_Mode && Attackers.isSieged() == true){
                			myUnit.unsiege();
                			Attackers.attack(enemyBasePos, true);
                		}
                		if(Attackers.getType() == UnitType.Terran_Goliath){
                			myUnit.unsiege();
                			Attackers.attack(enemyBasePos, true);
                		}
                 	}
    	          }		
            	else {
            		for (BaseLocation b : BWTA.getBaseLocations()) {
            			if (b.isStartLocation()) {
                         	for (Unit Attackers  : self.getUnits()) {
                        		if(Attackers.getType() == UnitType.Terran_Marine){
                        		Attackers.attack(enemyBasePos, true);
                        		}
                        		if(Attackers.getType() == UnitType.Terran_Bunker && Attackers.getLoadedUnits().size() > 3){
                        		Attackers.unloadAll();
                        		}
                        		if(Attackers.getType() == UnitType.Terran_Medic){
                        		Attackers.attack(enemyBasePos, true);
                        		}
                        		if(Attackers.getType() == UnitType.Terran_Firebat){
                        		Attackers.attack(enemyBasePos, true);
                        		}
                        		if(Attackers.getType() == UnitType.Terran_Vulture){
                        		Attackers.attack(enemyBasePos, true);
                        		}
                        		if(Attackers.getType() == UnitType.Terran_Siege_Tank_Tank_Mode){
                        			Attackers.attack(enemyBasePos, true);
                        		}
                        		if(Attackers.getType() == UnitType.Terran_Siege_Tank_Siege_Mode){
                        			myUnit.unsiege();
                        			Attackers.attack(enemyBasePos, true);
                        		}
                         	}
            			}
            		}
            		
            	}
            
          }
            
           if(myUnit.getType() == UnitType.Terran_Vulture && myUnit.isMoving() == true && myUnit.getSpiderMineCount() != 0 && Mines > 400){
        	   Unit unit = myUnit;
        	   Position lastorder = myUnit.getTargetPosition();
        	   for (Unit Rines  : self.getUnits()) {
        		   if(Rines.getType() == UnitType.Terran_Marine || Rines.getType() == UnitType.Terran_Firebat){
        			   if(unit.canUseTech(TechType.Spider_Mines, Rines.getPosition()) == true){
        	        	   myUnit.useTech(TechType.Spider_Mines, myUnit.getPosition());
        	        	   myUnit.attack(lastorder, true);
        	        	   break;
        			   }
           }
          }
        }
          
           if(AddNeeds > 600){
        	   if(GroundThreat < 0){
        		   GroundThreat = 0;
        	   }
        	   if(AirThreat < 0){
        		   AirThreat = 0;
        	   }
        	   MarinesNeed = 8 + (GroundThreat * 1);
        	   BatsNeed = 4 +  (GroundThreat + 2);
        	   MedicsNeed = 3 + (Marines / 2) + (Bats / 2) + (GroundThreat * 1);
           }
           
           if(Mines > 800){
        	   Mines = 0;
           }
           
           if(isExpanding == true){
        	   game.drawCircleMap(ExpandPos.toPosition(), 25, Color.Cyan, false);
           }
          
            
            if(myUnit.isUnderAttack() && myUnit.getType().isBuilding()){
            	Position pos = myUnit.getPosition();
            	for (Unit Defenders : self.getUnits()) {
            		if(Defenders.getType() == UnitType.Terran_Marine){
            			Defenders.attack(pos, true);
            		}
            		if(Defenders.getType() == UnitType.Terran_Firebat){
            			Defenders.attack(pos, true);
            		}
            		if(Defenders.getType() == UnitType.Terran_Medic){
            			Defenders.attack(pos, true);
            		}
            		if(Defenders.getType() == UnitType.Terran_Vulture){
            			Defenders.attack(pos, true);
            		}
            		if(Defenders.getType() == UnitType.Terran_Siege_Tank_Tank_Mode){
            			Defenders.attack(pos, true);
            		}
            		if(Defenders.getType() == UnitType.Terran_Goliath){
            			Defenders.attack(pos, true);
            		}
            		if(Marines < 1 && Defenders.getType() == UnitType.Terran_SCV){
            			Defenders.attack(pos, true);
            		}
            
            	
            	}
            }
            
            if(myUnit.isAttacking() == true && myUnit.getType() == UnitType.Terran_Marine && myUnit.canUseTech(TechType.Stim_Packs) == true && myUnit.isStimmed() == false){
            	myUnit.useTech(TechType.Stim_Packs);
            }
            
            if(myUnit.isAttacking() == true && myUnit.getType() == UnitType.Terran_Marine && myUnit.canUseTech(TechType.Stim_Packs) == true && myUnit.isStimmed() == false){
            	myUnit.useTech(TechType.Stim_Packs);
            }
            
            if(myUnit.isUnderAttack() && myUnit.getType().isWorker() == true && myUnit.getID() != scoutID){ 
            	Position pos;
            	pos = myUnit.getPosition();
            	for (Unit Defenders : self.getUnits()) {
            		if(Defenders.getType() == UnitType.Terran_Marine){
            			Defenders.attack(pos, false);
            		}
            		if(Defenders.getType() == UnitType.Terran_Firebat){
            			Defenders.attack(pos, false);
            		}
            		if(Defenders.getType() == UnitType.Terran_Medic){
            			Defenders.attack(pos, false);
            		}
            		if(Defenders.getType() == UnitType.Terran_Vulture){
            			Defenders.attack(pos, false);
            		}
            		if(Defenders.getType() == UnitType.Terran_Siege_Tank_Tank_Mode){
            			Defenders.attack(pos, false);
            		}
            		if(Marines < 1 && Defenders.getType() == UnitType.Terran_SCV){
            			Defenders.attack(pos, false);
            		}
            	}
            }
            
            if(myUnit.getType() == UnitType.Terran_Factory && myUnit.canBuild(UnitType.Terran_Machine_Shop, true)){
            	myUnit.buildAddon(UnitType.Terran_Machine_Shop);
            }
            
            if(myUnit.getType() == UnitType.Terran_Command_Center && myUnit.canBuild(UnitType.Terran_Comsat_Station, true)){
            	myUnit.buildAddon(UnitType.Terran_Comsat_Station);
            }

            //if it's a worker and it's idle, send it to the closest mineral patch
            if (myUnit.getType().isWorker() && myUnit.isIdle() && myUnit.getID() != scoutID && myUnit.isGatheringGas() == false){
                Unit closestMineral = null;

                //find the closest mineral
                for (Unit neutralUnit : game.neutral().getUnits()) {
                    if (neutralUnit.getType().isMineralField() && neutralUnit.isBeingGathered() == false){
                        if (closestMineral == null || myUnit.getDistance(neutralUnit) < myUnit.getDistance(closestMineral)) {
                            closestMineral = neutralUnit;
                        }
                    }
                }

                //if a mineral patch was found, send the worker to gather it
                if (closestMineral != null) {
                    myUnit.gather(closestMineral, false);
                }
            }
        }
        
        
        if ((self.supplyTotal() - self.supplyUsed()) < 3 && self.minerals() >= 100 && supplyBuilding != 2 && game.getFPS() > 20 && isExpanding == false) {     
        	for (Unit myUnit : self.getUnits()) {
        		if (myUnit.getType() == UnitType.Terran_SCV && myUnit.isCarryingMinerals() == true && myUnit.getID() != scoutID){
        			TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Supply_Depot, self.getStartLocation());
        			if (buildTile != null) {
            				myUnit.build(UnitType.Terran_Supply_Depot, buildTile);
            				forceSupply = 1;
            				break;
        			}
        		}
        	}	
        }
     
        
        
        if (self.minerals() >= 120 && Gases < MaxGases && isExpanding == false) {      
        	for (Unit myUnit : self.getUnits()) {
        		if (myUnit.getType() == UnitType.Terran_SCV && myUnit.isGatheringGas() == false && myUnit.isCarryingGas() == false && myUnit.getID() != scoutID){
        			TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Refinery, self.getStartLocation());
        			if (buildTile != null) {
            				myUnit.build(UnitType.Terran_Refinery, buildTile);
            				break;
        			}
        		}
        	}
        }
        
        
        if (Racks < MaxRacks && self.minerals() >= 150 && isExpanding == false){
	for (Unit myUnit : self.getUnits()) {
		if (myUnit.getType() == UnitType.Terran_SCV && myUnit.isGatheringGas() == false && myUnit.isCarryingGas() == false && myUnit.getID() != scoutID){
			TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Barracks, self.getStartLocation());
			if (buildTile != null) {
				myUnit.build(UnitType.Terran_Barracks, buildTile);
				break;
			}
		}
	}
}
             
        if (Factories < MaxFactories && self.minerals() >= 200 && self.gas() >= 150 && isExpanding == false){
	for (Unit myUnit : self.getUnits()) {
		if (myUnit.getType() == UnitType.Terran_SCV && myUnit.isCarryingMinerals() == true && myUnit.isGatheringGas() == false && myUnit.isCarryingGas() == false && myUnit.getID() != scoutID){
			TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Factory, self.getStartLocation());
			if (buildTile != null) {
				myUnit.build(UnitType.Terran_Factory, buildTile);
				break;
			}
		}
	}
} 
        
        if (Factories == MaxFactories && self.minerals() >= 200 && self.gas() >= 150 && isExpanding == false && needs > income){
	for (Unit myUnit : self.getUnits()) {
		if (myUnit.getType() == UnitType.Terran_SCV && myUnit.isCarryingMinerals() == true && myUnit.isGatheringGas() == false && myUnit.isCarryingGas() == false && myUnit.getID() != scoutID){
			TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Factory, self.getStartLocation());
			if (buildTile != null) {
				myUnit.build(UnitType.Terran_Factory, buildTile);
				break;
			}
		}
	}
} 
        	
         
        if (self.minerals() >= 100 && Bunks != 2 && Academy > 0 && isExpanding == false){
	for (Unit myUnit : self.getUnits()) {
		if (myUnit.getType() == UnitType.Terran_SCV && myUnit.isCarryingMinerals() == true && myUnit.isGatheringGas() == false && myUnit.isCarryingGas() == false && myUnit.getID() != scoutID){
			TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Bunker, self.getStartLocation());
			if (buildTile != null) {
				myUnit.build(UnitType.Terran_Bunker, buildTile);
				break;
			}
		}
	}
}
    
        
        
        if (self.minerals() >= 150 && isExpanding == false && Academy == 0){
	for (Unit myUnit : self.getUnits()) {
		if (myUnit.getType() == UnitType.Terran_SCV && myUnit.isCarryingMinerals() == true && myUnit.isGatheringGas() == false && myUnit.isCarryingGas() == false && myUnit.getID() != scoutID){
			TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Academy, self.getStartLocation());
			if (buildTile != null) {
				myUnit.build(UnitType.Terran_Academy, buildTile);
				break;
			}
		}
	}
}
        
        if (self.minerals() >= 150 && Factories > 1 && Bays == 0 && isExpanding == false) {     
       	for (Unit myUnit : self.getUnits()) {
       		if (myUnit.getType() == UnitType.Terran_SCV && myUnit.isCarryingMinerals() == false && myUnit.isGatheringGas() == false && myUnit.getID() != scoutID){
       			TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Engineering_Bay, self.getStartLocation());
       			if (buildTile != null) {
           				myUnit.build(UnitType.Terran_Engineering_Bay, buildTile);
           				break;
       			}
       		}
       	}
       }
        
        if (self.minerals() >= 150 && Bunks > 1 && Turrets < 2 && isExpanding == false) {     
       	for (Unit myUnit : self.getUnits()) {
       		if (myUnit.getType() == UnitType.Terran_SCV && myUnit.isCarryingMinerals() == false && myUnit.isGatheringGas() == false && myUnit.isCarryingGas() == false && myUnit.getID() != scoutID){
       			TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Missile_Turret, Choke.toTilePosition());
       			if (buildTile != null) {
           				myUnit.build(UnitType.Terran_Missile_Turret, buildTile);
           				break;
       			}
       		}
       	}
       }
       

        
        if (self.minerals() >= 400 && ExpandEnabled == true && income < needs && isExpanding == false && HasScoutUnit == true){
        	isExpanding = true;
        	expanding = true;
        	System.out.println("Expanding");
        	for (Unit myUnit : self.getUnits()) {
        		if (myUnit.getType() == UnitType.Terran_SCV && myUnit.getID() == scoutID){
        			System.out.println("SCV");
        			TilePosition buildTile = NextExpand();
        			TilePosition buildTile2 = getBuildTile(myUnit, UnitType.Terran_Command_Center, buildTile);
        			System.out.println("Call");
        			if (buildTile != null) {
        				myUnit.build(UnitType.Terran_Command_Center, buildTile2);
               			System.out.println("build");
        				break;	
        			}
        		}
        	}
        }
        
        if (Factories > 1 && self.minerals() >= 100 && self.gas() >= 50 && Armor == 0 && isExpanding == false){
       	for (Unit myUnit : self.getUnits()) {
       		if (myUnit.getType() == UnitType.Terran_SCV && myUnit.isGatheringGas() == false && myUnit.isCarryingGas() == false && myUnit.getID() != scoutID){
       			TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Armory,self.getStartLocation());
       			if (buildTile != null) {
       				myUnit.build(UnitType.Terran_Armory, buildTile);
       				break;
       			}
       		}
       	}
       }
        
        if (self.minerals() >= 150 && self.gas() >= 100 && StarPorts == 0 && isExpanding == false){
       	for (Unit myUnit : self.getUnits()) {
       		if (myUnit.getType() == UnitType.Terran_SCV && myUnit.isGatheringGas() == false && myUnit.isCarryingGas() == false && myUnit.getID() != scoutID){
       			TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Starport,self.getStartLocation());
       			if (buildTile != null) {
       				myUnit.build(UnitType.Terran_Starport, buildTile);
       				break;
       			}
       		}
       	}
       }
        
        if (self.minerals() >= 100 && self.gas() >= 150 && TSF == 0 && isExpanding == false){
           	for (Unit myUnit : self.getUnits()) {
           		if (myUnit.getType() == UnitType.Terran_SCV && myUnit.isGatheringGas() == false && myUnit.isCarryingGas() == false && myUnit.getID() != scoutID){
           			TilePosition buildTile = getBuildTile(myUnit, UnitType.Terran_Science_Facility,self.getStartLocation());
           			if (buildTile != null) {
           				myUnit.build(UnitType.Terran_Science_Facility, buildTile);
           				break;
           			}
           		}
           	}
           }
        
        

        
     if(HasScoutUnit == true && scouter.isIdle() == true){
    	 for (BaseLocation b : BWTA.getBaseLocations()) {
    			// If this is a possible start location,
    			if (b.isStartLocation()){
    				// do something. For example send some unit to attack that position:
    				scouter.move(b.getPosition(), true);
    				
    			}
    		}
     }
     
    
}

	public static void main(String[] args) {
        new TestBot1().run();
        
    }
	
	// Returns a suitable TilePosition to build a given building type near
	// specified TilePosition aroundTile, or null if not found. (builder parameter is our worker)
	public TilePosition getBuildTile(Unit builder, UnitType buildingType, TilePosition aroundTile) {
		TilePosition ret = null;
		int maxDist = 6;
		int stopDist = 160;

		// Refinery, Assimilator, Extractor
		if (buildingType.isRefinery()) {
			for (Unit n : game.neutral().getUnits()) {
				if ((n.getType() == UnitType.Resource_Vespene_Geyser) &&
						( Math.abs(n.getTilePosition().getX() - aroundTile.getX()) < stopDist ) &&
						( Math.abs(n.getTilePosition().getY() - aroundTile.getY()) < stopDist )
						) return n.getTilePosition();
			}
		}
		
		if(buildingType.isResourceDepot()){
			maxDist = 1;
		}
			
		while ((maxDist < stopDist) && (ret == null)) {
			for (LastX=aroundTile.getX()-maxDist; LastX<=aroundTile.getX()+maxDist; LastX++) {
				for (LastY=aroundTile.getY()-maxDist; LastY<=aroundTile.getY()+maxDist; LastY++) {
					if (game.canBuildHere(new TilePosition(LastX,LastY), buildingType, builder, false)) {
						// units that are blocking the tile
						boolean unitsInWay = false;
						for (Unit u : game.getAllUnits()) {
							if (u.getID() == builder.getID()) continue;
							if ((Math.abs(u.getTilePosition().getX()-LastX) < 4) && (Math.abs(u.getTilePosition().getY()-LastY) < 4)) unitsInWay = true;
						}
						if (!unitsInWay) {
							return new TilePosition(LastX, LastY);
						}
					}
				}
			}
			maxDist += 6;
		}

		if (ret == null) game.printf("Unable to find suitable build position for "+buildingType.toString());
		return ret;
	}
	
	public TilePosition NextExpand() {
        for(BaseLocation Expand : BWTA.getBaseLocations()){
        	BaseLocation Expand1 = BWTA.getNearestBaseLocation(Expand.getPosition());
        	System.out.println(Expand.getTilePosition());
        	if(BWTA.getGroundDistance(lastExpandPos, Expand1.getTilePosition()) < 1500 && game.canBuildHere(Expand1.getTilePosition(), UnitType.Terran_Command_Center) == true){
    			System.out.println(BWTA.getGroundDistance(lastExpandPos, Expand1.getTilePosition()));
        			System.out.println("ExpandPos " + Expand1.getTilePosition());
        			ExpandPos = Expand1.getTilePosition();
            		return Expand1.getTilePosition();
        	}
        	
        }
			expanding = false;
			return null;
	}	

}
