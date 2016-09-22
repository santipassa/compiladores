package Compi;

import java_cup.runtime.*;
import java.util.LinkedList;

public class Main{

public static void main(String args[]) throws Exception {
		
		ComplexSymbolFactory sf = new ComplexSymbolFactory();
		Symbol sym;
		
		if (args.length==0) sym = new Parser(new Scanner(System.in,sf),sf).parse();
		else sym = new Parser(new Scanner(new java.io.FileInputStream(args[0]),sf),sf).parse();
    	
		Program prog;
		prog = (Program)sym.value;
    	//ASTVisitor printv = new PrettyPrintVisitor();
    	ASTVisitor build = new BuildVisitor();
    	ASTVisitor checkmain = new CheckMainVisitor();
    	Integer cantMain = (Integer)checkmain.visit(prog);
    	if (cantMain != 1){
    		System.out.println("ERROR debe haber una clase main, con un metodo main");
    	}
    	System.out.println(prog.accept(build));
 
    }

    public void syntax_error(Symbol sym){ 
	// Mute legacy Error Printing
		System.out.println("Syntax error" );
    	System.out.println("Error: "+sym );
    }


}
