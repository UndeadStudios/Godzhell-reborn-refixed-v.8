@echo off
REM created by Arean
title Server Automated Restarter and Crash Detector
:start
set time=14400
ping 127.0.0.1 -n 2 > NUL
start runserver.bat
:loop
cls
IF %time% GTR 0 (
set /a time=%time% - 1
set /a min=%time%/60
echo Next Restart In %time% Seconds or %min% Minutes.
ping 127.0.0.1 -n 2 > NUL
tasklist /FI "IMAGENAME eq java.exe" 2>NUL | find /I /N "java.exe" >NUL
if "%ERRORLEVEL%"=="0" goto loop

goto start
)
taskkill /f /im java.exe
cls
goto start