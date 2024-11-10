@echo off
title Ghreborn Old
COLOR 0A
"C:\Users\Administrator\.jdks\corretto-1.8.0_382\jre\bin\java.exe" -Xmx7g -cp bin;deps/GTLVote.jar;deps/everythingrs-api.jar;deps/poi.jar;deps/mysql.jar;deps/mina.jar;deps/slf4j.jar;deps/slf4j-nop.jar;deps/jython.jar;log4j-1.2.15.jar; server
pause