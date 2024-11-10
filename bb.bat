@echo off
cls
title Backup
color 0f
set /p date=What is the date(ex: 10.20.09): 
if exist "backup\%date%" goto erase
:set
set f8="backup\%date%\extras"
set f7="backup\%date%\connectedfrom"
set f6="backup\%date%\CFG"
set f5="backup\%date%\characters"
set f2="backup\%date%\data"
set f3="backup\%date%\config"
set f4="backup\%date%\tools"
set f1="backup\%date%\"
md %f1%
md %f2%
md %f3%
md %f4%
md %f5%
md %f6%
md %f7%
md %f8%
copy "*.*" "%f1%"
copy "Data\CFG\*.*" "%f6%"
copy "Data\characters\*.*" "%f5%"
copy  "Data\config\*.*" "%f3%"
copy  "Data\connectedfrom\*.*" "%f7%"
copy "Data\data\*.*" "%f2%"
copy  "Data\extras\*.*" "%f8%"
copy "Data\tools\*.*" "%f4%"
echo.
echo Done!
pause>nul
exit

:erase
del "backup\%date%\*.*"
del "backup\%date%\characters\*.*"
del "backup\%date%\config\*.*"
del "backup\%date%\data\*.*"
del "backup\%date%\tools\*.*"
goto set