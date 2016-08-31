#!/bin/bash
echo "=====================================\n"
echo "========COMPILANDO EL JFLEX==========\n"
echo "=====================================\n"
java -jar lib/jflex-1.6.1.jar -d src/compiladores jflex/analisislexico.flex
echo "=====================================\n"
echo "========COMPILANDO EL CUP============\n"
echo "=====================================\n"
java -jar lib/java-cup-11a.jar -parser Parser -destdir src/compiladores cup/gramatica.cup
mkdir -p classes
#export CLASSPATH=""
#for file in 'lib/'; do export CLASSPATH=$CLASSPATH:lib/$file; done
#echo $CLASSPATH 
echo "=====================================\n"
echo "========COMPILANDO LOS .JAVA=========\n"
echo "=====================================\n"
javac -cp lib/jflex-1.6.1.jar:lib/java-cup-11a.jar src/compiladores/*.java -d classes/

