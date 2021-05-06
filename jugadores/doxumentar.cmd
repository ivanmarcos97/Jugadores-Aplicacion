@CHCP 65001 > NUL
@ECHO OFF

SET nombre=ControlJugadores
SET nombrepaquete=jugadores.liga
SET rutapaquete=jugadores\liga

SET OLDPATH=%PATH%
SET PATH=c:\java\doxygen;c:\java\graphviz;%PATH%
SET CLASSPATH=bin
SET JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF-8

ECHO %nombre%
ECHO ---
ECHO.

doxygen Doxyfile-1.8.20-personalizado 2> doxumentar.log

DIR dox

ECHO.
ECHO No documentados:
findstr /r /c:"not.*documented" < doxumentar.log | find /c "warning"

ECHO.

SET PATH=%OLDPATH%
PAUSE