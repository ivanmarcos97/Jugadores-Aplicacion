@CHCP 65001 > NUL
REM @ECHO OFF

SET nombre=ControlJugadores
SET nombrepaquete=jugadores.liga
SET rutapaquete=jugadores\liga

SET OLDPATH=%PATH%
SET PATH=c:\java\jdk11\bin;%PATH%
SET CLASSPATH=bin
SET JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF-8

ECHO %nombrepaquete%.%nombre%
ECHO ---
ECHO.

REM javac -sourcepath src -d bin src\%rutapaquete%\%nombre%.java

jar --create ^
--verbose ^
--file %nombre%.jar ^
--main-class %nombrepaquete%.%nombre% ^
-C bin "."
DIR /s %CLASSPATH%\%rutapaquete%\*.class
ECHO.

DIR *.jar

MKDIR dist
XCOPY *.jar dist /B
XCOPY ejecutarjar.cmd dist /B
PAUSE
SET PATH=%OLDPATH%