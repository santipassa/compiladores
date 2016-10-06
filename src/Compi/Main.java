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

    	BuildVisitor build = new BuildVisitor();
        CheckTypeVisitor type = new CheckTypeVisitor();
    	ASTVisitor mainVisitor = new MainVisitor();
    	
        Integer cantMain = (Integer)mainVisitor.visit(prog);
    	
        prog.accept(build);
        if (build.getErrors().isEmpty()){
            System.out.println("Type Errors");
            prog.accept(type);
            if (!type.getErrors().isEmpty())
                for (ErrorCompi e: type.getErrors())
                    System.out.println(e.toString());    
        }else{
            System.out.println("Build Errors");
            for (ErrorCompi e: build.getErrors())
                System.out.println(e.toString());

        }
 

            
        IntermediateCodeVisitor iCodeVisitor = new IntermediateCodeVisitor();
        iCodeVisitor.visit(prog);
        java.util.LinkedList<IntermediateCode> l = iCodeVisitor.getList();
        System.out.println("======IMPRIMIENDO CODIGO INTERMEDIO======");
        for(IntermediateCode i : l ){
            System.out.println(i.toString()+"\n");
        }
    }

    public void syntax_error(Symbol sym){ 
	// Mute legacy Error Printing
		System.out.println("Syntax error" );
    	System.out.println("Error: "+sym );
    }


}
