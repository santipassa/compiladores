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
    	BuildVisitor build = new BuildVisitor();
    	ASTVisitor mainVisitor = new MainVisitor();
    	Integer cantMain = (Integer)mainVisitor.visit(prog);
    	if (cantMain != 1){
    		//System.out.println("Programa incorrecto debe haber una clase main, con un metodo main");
    	} else {
            //System.out.println("Programa correcto, clase main con metodo main");
        } 
    	prog.accept(build);
        if (build.getErrors().isEmpty())
            System.out.println("No hay errores en el BUILD");
        else
            for (ErrorCompi e: build.getErrors())
                System.out.println(e.toString());
            
        IntermediateCodeVisitor iCodeVisitor = new IntermediateCodeVisitor();
        iCodeVisitor.visit(prog);
        java.util.LinkedList<IntermediateCode> l = iCodeVisitor.getList();
        for(IntermediateCode i : l ){
            System.out.println(i.toString());
        }
    }

    public void syntax_error(Symbol sym){ 
	// Mute legacy Error Printing
		System.out.println("Syntax error" );
    	System.out.println("Error: "+sym );
    }


}
