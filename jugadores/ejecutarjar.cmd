@CHCP 65001 > NUL
@ECHO OFF

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

java -jar %nombre%.jar %args%

ECHO.

PAUSE
SET PATH=%OLDPATH%