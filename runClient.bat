@echo off
setlocal enabledelayedexpansion

:: Run the game
echo Running Boomerang...
java -cp bin;lib\json-simple-1.1.jar Boomerang 127.0.0.1 8080


:: End the script
exit /b %EXIT_CODE%