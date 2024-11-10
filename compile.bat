@echo off
"C:\Users\Administrator\.jdks\corretto-1.8.0_382\bin\javac.exe"  -classpath deps/log4j-1.2.15.jar;deps/everythingrs-api.jar;deps/jython.jar;deps/GTLVote.jar;deps/xstream.jar;deps/mina.jar;deps/mysql.jar;deps/poi.jar;deps/slf4j.jar;deps/slf4j-nop.jar -d bin src/*.java src/clip/*.java src/clip/region/*.java
pause