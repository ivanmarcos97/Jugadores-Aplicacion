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

REM Descargar https://docs.oracle.com/en/java/javase/11/docs/api/element-list
javadoc -verbose ^
	-sourcepath src ^
	-d doc ^
	-linkoffline https://docs.oracle.com/en/java/javase/11/docs/api/ . ^
	-overview src\overview.html ^
	-locale es_ES ^
	--frames ^
	-author ^
	-version ^
	-private ^
	-linksource ^
	-subpackages %nombrepaquete%


DIR doc\%rutapaquete%
ECHO.

SET PATH=%OLDPATH%
PAUSE