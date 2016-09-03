#!/bin/bash
echo "=====================================\n"
echo "========COMPILANDO EL JFLEX==========\n"
echo "=====================================\n"
java -jar lib/JFlex.jar -d src/Example jflex/Scanner.jflex
echo "=====================================\n"
echo "========COMPILANDO EL CUP============\n"
echo "=====================================\n"
java -jar tools/java-cup-11b.jar -interface -locations -parser Parser -destdir src/Example cup/Parser.cup
#export CLASSPATH=""
#for file in 'lib/'; do export CLASSPATH=$CLASSPATH:lib/$file; done
#echo $CLASSPATH 
echo "=====================================\n"
echo "========COMPILANDO LOS .JAVA=========\n"
echo "=====================================\n"
javac -cp .:lib/java-cup-11b-runtime.jar src/Example/*.java -d bin/

echo "=====================================\n"
echo "============EJECUTANDO===============\n"
echo "=====================================\n"
cd bin/

for var in $(seq 5)
do
	echo "TEST $var"
	java -cp .:../lib/java-cup-11b-runtime.jar Example.Parser ../test/input$var.test	 
done