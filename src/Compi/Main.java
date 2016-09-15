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
    	//ASTVisitor printv = new PrettyVisitor();
    	//printv.visit(prog);

    }

    public void syntax_error(Symbol sym){ 
	// Mute legacy Error Printing
		System.out.println("Syntax error" );
    	System.out.println("Error: "+sym );
    }


}
