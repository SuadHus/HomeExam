@echo off
setlocal enabledelayedexpansion

:: Run the game
echo Running Boomerang...
java -cp bin;lib\json-simple-1.1.jar Boomerang 8080


:: End the script
exit /b %EXIT_CODE%