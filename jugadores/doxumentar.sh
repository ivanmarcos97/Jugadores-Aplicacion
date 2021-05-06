#!/bin/bash
nombre=ListaFlexibleEnteros

echo $nombre
echo ---
echo

doxygen Doxyfile-1.8.13-personalizado 2> doxumentar.log

tree -f dox
echo "No documentados: $(grep "not documented" doxumentar.log | wc -l)"

echo
