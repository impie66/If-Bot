
<h1>If Bot(ConcurrentModificationException Bot)</h1>

Really bad Brood war AI Designed by me using rules and ALOT of if statements fueled by alot of vodka, Pasta and discord Shit Posting.

<h2><b>Features</b></h2>


* Giant lines of marines a moving
* Siege Tanks that unsiege instantly after shooting
* 2000 APM for one marine to stim
* A free for all building system 
* A fuckload of bunkers
* jFap Combat Sim
* Expanding repairing, And unit abilities
* Alot of global variables
* Alot of useless variables
* Science Vessels, Battlecruisers, Vultures, Golaiths
* Infantry && Armor Upgrades

<hr />

<h2>Running If Bot Locally</h2>

32 bit JRE is required to run If Bot and starcraft 1.1.6
The SSCAIT tourament website will explain how to get starcraft 1.16 you can view it [here](https://sscaitournament.com/index.php?action=tutorial)

1. Download the Jar file from the SSCAIT website or directly [Here](https://sscaitournament.com/bot_binary.php?bot=If+Bot)
2. Paste ifBot.jar inside the bwapi-data folder inside starcraft game files
3. Modify bwapi.ini so the race is TERRAN and ai field is empty example: ai  = 
4. run a CMD command java -jar ifBot.jar file. 
5. Launch Chaos launcher with BWAPI injected(Tick BWAPI 4.1.2 injector (Release)), make sure the BWAPi.ini file is set up correctly (read #2)


<hr />

<h2>What Issues did i face when developing the bot?</h2>
I started programming my AI with no programming experience at all. it was tough, but it was worth it.


<hr />

<h2>Updates</h2>

<b>Build 14th June 2018:</b>

* Bot now attacks based on enemy Defences(Globally) and enemy unit scores
* Bot is less likely to attack near an enemy chokepoint within 2000 distance of the enemy base(To reduce mass suicide at chokepoints)
* Bot now builds more marines based difference between the enemy's and i's fap scores.
* Bot now builds more bunkers to defend against rush attacks
Unfortunally it counts globally, it will build bunkers even when the units arent attacking me
* Added a basic and untested anti lure script to stop units from being lured from bunkers when i'm the bot is defending

<hr />

<b>Build 29th June 2018:</b>

* UH UH UH UH STAYING ALIVE, STAYING ALIVE!!
* Bot now expands rapidly if conditions are right
* Siege tanks now longer take a paid vacation when unsiegeing
* Bot now builds reactionary Golaiths in responce to enemy Air
* Basic nuke avoidiance script (Fuck you Stock Terran AI and Hannes)
* Now builds Bunkers and Missile Turrets to defend 2nd base
* Gave enemy units "special" names
* After a harsh whipping, the bot no longer upgrades spider mines when no vultures are on the field
* Oh and vultures are disabled
* Installed AVG free edition onto my Jar File so it can no longer get hacked from github
* Custom Unit Targetting (E.G Targetting Repairing SCV"s, Medics, High Templars)
* A load of shit i did drunk
* A load of shit that i deleted when i was sober the next day

<hr />

<b>Build 9th September 2018:</b>

I took abit a break from developing for about 2 weeks, and then moved a couple weeks later.

Changelog latest = new Changelog(String date){

*Added Basic FFA support(Bot will attack the weakest player in the match) (Currently Disabled)

* Bot nows expands early if the enemy is turtling
* Manually increased zealots score because they are fucking imba.
* Bot will now automatically hates ANY protoss player
* Adjusted the early marine count from Not Enought -> Marine hell levels
* Fixed multiple units trying to load into a full bunker and not counting as the main militray force(They will just stand there idle FOREVER.)
* Bot now regroups based on unit distance and not just every X frames	
* Broke FAP again and couldnt be fucked fixing it
* Added storm dodging(Basic)
* Priority Building and Unit system Bot will now attempt to save for these items and build them ASAP. 
* Added more bugs and crashes
* Bot no longer does the BBS build.
* Bot now will scan cloaked/burrowed units when army is nearby to attack it instead of whenever it is spotted.
* Medics now suicide a little less
* Nerfed the amount of sleep daily from 8 -> 5
* Bot will now react to 6 pool. (It'll just make marines for awhile)
* Bot now poop reacts anything C++ related on discord
* Bot no longer repairs buildings that are under attack unless they are a bunker or a Missile turret
* Bot now stores which baseLocations it has scouted when the enemy is not found
* Bot now repairs bunkers and missile turrets with 3 scvs instead of 1 (Krais0 Style)
* Bot now assigns workers to bases. Workers will have a lines pointing to what base they are assigned to
* Bot will now only build workers during safe conditions
* Bot will now sell Spare APM to the highest korean bidder. Profits go to Scott's Tots
* Bot will now bet against itself in spritecraft
* Bot now doesn't try to co-base with the same base as the enemy!
* Bot now pulls workers to defend itself
* Bot will now also regroup before attacking automatically based on average distance
* Marines now don't stim below 30 health
* Changed the likelyness of the scout dieing from 100% -> 120%

}

Danke auf alle lesen dies, habe ein gut tag. 	


Current line count is: <b><strong>5737</b></strong>
(Some blocks of code are commented out)


Special thanks to Adakite, Jabbo, Tyr, Yegers and N00by for helping me debug my FFA code and everyone else who helped me on the discord. I love you guys. 

<hr />

![suffering,txt](https://i.imgur.com/Xo422hY.gif)
BCs?
![suffering,txt](https://i.imgur.com/KkulnQg.gif)
Colonizing the enemy
![suffering,txt](https://i.imgur.com/LahNhaL.gif)
STRATEGIC BASE DESIGN

![soup](https://i.imgur.com/bCd8VUn.gif)
<br />
Introducing BWEB1 -- If Bot's Zergling tight wall system.

![pineapples](https://i.imgur.com/vtKL4SK.gif)
<br />
Jaedong's imba bbs tank medic build

![carrots](https://i.imgur.com/VKQCH4R.gif)
<br />
Appropriate decision making 

![pees](https://i.imgur.com/jLaH6yl.png)
<br />
Smart Walling System

![onions](https://i.imgur.com/sQbEDx3.gif)
<br />
Worker Management

![apples](https://i.imgur.com/hA3hQ84.gif)
<br />
Every crash long file

![oranges](https://i.imgur.com/NZm6Jag.png)
<br />
The Maginot Line recreated in Starcraft

![jedks](https://i.imgur.com/ntL9doU.png)
<br />

![scv](https://i.imgur.com/VybxDJ8.png)
<br />
Fully functional worker defence

![winning](https://i.imgur.com/Wgh16Q0.png)
<br />
Winning Streak

![winstreak](https://i.imgur.com/WCVdpVS.png)
<br />
Only cool kids code in comic sans

![IfBotBugs](https://i.imgur.com/9qbIkil.png)
High level code

![Approval](https://i.imgur.com/oWZWiN3.png)
 Seal of approval

![onFrame](https://i.imgur.com/jERolkL.png)
Bot > intellij

<h3>Edit: 15/01/2019</h3>

The latest code on the github was for a debugging session with Yegers.

It pains me to say, i no longer have interest in further developing my bot. This may change in the future. 
I may get ideas every now and again and feel interested but this only lasts a short while.
I have none other than myself to blame, i embraced my bot as a "Broken meme bot" and coded it stupidly which lost any protential it had for being a top 10 bot. 


