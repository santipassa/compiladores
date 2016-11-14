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
        int maxOffset=build.getOffset();
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
        //System.out.println("ULTIMO OFFSET"+maxOffset);  
         IntermediateCodeVisitor iCodeVisitor = new IntermediateCodeVisitor(maxOffset);
         iCodeVisitor.visit(prog);
         java.util.LinkedList<IntermediateCode> l = iCodeVisitor.getList();
         String c = "";
         AssemblerGenerator asm = new AssemblerGenerator();
         System.out.println("--------ASSEMBLER GENERADO:--------");   
        
         
         for(IntermediateCode i : l ){
             c=c+"\n"+i.toString()+"\n";
         }
         String home="/home/camila/";
         PrintWriter out = new PrintWriter(home+"Escritorio/intermediate.ctds");
         out.println(c);
         out.close();

         
         PrintWriter out2 = new PrintWriter(home+"Escritorio/assembler.s");
         out2.println(asm.readList(l));
         out2.close();
    }

    public void syntax_error(Symbol sym){ 
	// Mute legacy Error Printing
		System.out.println("Syntax error" );
    	System.out.println("Error: "+sym );
    }


}
