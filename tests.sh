#!/bin/bash
files=`ls test/test_errores/*.ctds`
cd bin/

for file in $files ; do 
    echo "------- Test $file ... ------"
    echo "-----------------------------"
    java -cp .:../lib/java-cup-11b-runtime.jar Compi.Main ../$file  
done