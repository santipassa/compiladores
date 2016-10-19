package Compi;

import java_cup.runtime.*;
import java.util.LinkedList;
import java.io.*;

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
    	MainVisitor mainVisitor = new MainVisitor();
    	PrettyPrintVisitor pretty = new PrettyPrintVisitor();

        prog.accept(build);
        if (build.getErrors().isEmpty()){
            System.out.println("**BUILD correcto");
            prog.accept(type);
            if (type.getErrors().isEmpty()){
                System.out.println("**TYPE correcto");
                prog.accept(mainVisitor);
                if (mainVisitor.getErrors().isEmpty())
                    System.out.println("**MAIN correcto");
                else
                    for (ErrorCompi e: mainVisitor.getErrors())
                        System.out.println(e.toString());
            }
            else    
                for (ErrorCompi e: type.getErrors())
                    System.out.println(e.toString());    
        }else
            for (ErrorCompi e: build.getErrors())
                System.out.println(e.toString());
 
        //prog.accept(pretty);
            
         IntermediateCodeVisitor iCodeVisitor = new IntermediateCodeVisitor();
         iCodeVisitor.visit(prog);
         java.util.LinkedList<IntermediateCode> l = iCodeVisitor.getList();
         String c = "";
         for(IntermediateCode i : l ){
             c=c+"\n"+i.toString()+"\n";
         }
         PrintWriter out = new PrintWriter("/home/claudio/Escritorio/intermediate.ctds");
         out.println(c);
         out.close();
    }

    public void syntax_error(Symbol sym){ 
	// Mute legacy Error Printing
		System.out.println("Syntax error" );
    	System.out.println("Error: "+sym );
    }


}
