@echo off
@color 0A

:menu
cls
echo 1. Purple
echo 2. Bryan
echo 3. Ecgberth
echo 4. ifLocal
echo 5. reset
set /p input="Action?"
if %input%==1 (goto:purple)
if %input%==2 (goto:Bryan)
if %input%==3 (goto:Eggbirth)
if %input%==4 (goto:ifLocal)
if %input%==5 (goto:reset)
if %input% LEQ 0 (goto:menu)
echo %input%



:purple
xcopy "E:\Starcraft\Brood War\bwapi-data\batch copies\Purplewave\bwapi.ini" "E:\Starcraft\Brood War\bwapi-data\bwapi.ini"
echo purple
goto menu

:Bryan
xcopy "E:\Starcraft\Brood War\bwapi-data\batch copies\bryan\bwapi.ini" "E:\Starcraft\Brood War\bwapi-data\bwapi.ini"
echo bryan
goto menu

:Eggbirth
xcopy "E:\Starcraft\Brood War\bwapi-data\batch copies\Jabbo\bwapi.ini" "E:\Starcraft\Brood War\bwapi-data\bwapi.ini"
echo egg
goto menu

:ifLocal
xcopy "E:\Starcraft\Brood War\bwapi-data\batch copies\ifLocal\bwapi.ini" "E:\Starcraft\Brood War\bwapi-data\bwapi.ini"
echo ifLocal
goto menu

:reset
xcopy "E:\Starcraft\Brood War\bwapi-data\batch copies\reset\bwapi.ini" "E:\Starcraft\Brood War\bwapi-data\bwapi.ini"
echo reset
goto menu
