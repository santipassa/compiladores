#!/bin/bash
files=`ls test/test_errores/*.ctds`
cd bin/

for file in $files ; do 
	echo ""
	echo "------------------------------------------------------------"
	echo "------------------------------------------------------------"
    echo "------- Test $file ... ------"
    java -cp .:../lib/java-cup-11b-runtime.jar Compi.Main ../$file  
done