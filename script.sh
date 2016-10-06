#!/bin/bash
echo "=====================================\n"
echo "========COMPILANDO EL JFLEX==========\n"
echo "=====================================\n"
java -jar lib/JFlex.jar -d src/Compi jflex/Scanner.jflex
echo "=====================================\n"
echo "========COMPILANDO EL CUP============\n"
echo "=====================================\n"
java -jar tools/java-cup-11b.jar -interface -locations -parser Parser -destdir src/Compi cup/Parser.cup
#export CLASSPATH=""
#for file in 'lib/'; do export CLASSPATH=$CLASSPATH:lib/$file; done
#echo $CLASSPATH 
echo "=====================================\n"
echo "========COMPILANDO LOS .JAVA=========\n"
echo "=====================================\n"
javac -cp .:lib/java-cup-11b-runtime.jar src/Compi/*.java -d bin/

echo "=====================================\n"
echo "============EJECUTANDO===============\n"
echo "=====================================\n"

cd test/test_correctos
I=$(ls | wc -l)

cd ../../bin/
for var in $(seq $I)
do
	echo "TEST $var"
	java -cp .:../lib/java-cup-11b-runtime.jar Compi.Main ../test/test_correctos/input$var.test	 
done
