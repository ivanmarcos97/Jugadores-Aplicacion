@CHCP 65001 > NUL
@ECHO OFF

SET nombre=jugadores bin + doc + dox + dist

ECHO %nombre%
ECHO ---
ECHO.

FOR %%D in (bin,doc,dox,dist) do (
	IF EXIST %%D (
		RMDIR /S /Q %%D
		ECHO Borrado %%D
	)
)
ECHO.

PAUSE