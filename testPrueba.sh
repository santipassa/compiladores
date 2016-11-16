#!/bin/bash
echo "=====================================\n"
echo "============EJECUTANDO===============\n"
echo "=====================================\n"

cd test/
I=$(ls | wc -l)

cd ../bin/
echo "Compiling testPrueba.test ..."
java -cp .:../lib/java-cup-11b-runtime.jar Compi.Main ../test/testPrueba.test	 
echo "Ensambling assembler.s ..."
cd ~/Escritorio
gcc assembler.s
echo "Executing a.out ..."
cd ~/Escritorio
echo "OUTPUT FROM a.out: "
./a.out
