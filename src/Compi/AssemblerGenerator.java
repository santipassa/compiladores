package Compi;
import java.util.LinkedList;
//import java.util.*;
public class AssemblerGenerator{
	LinkedList<String> textSegment = new LinkedList<String>();
	LinkedList<String> dataSegment = new LinkedList<String>();
	

	public String readList(LinkedList<IntermediateCode> l){
        String res="";
		for(IntermediateCode i : l){
            switch (i.getOperator()) {
			case "SUM":
				res=res+sum(i);
				break;
			case "RES":
				res=res+res(i);
				break;
			case "MUL":
				res=res+mul(i);
				break;
			case "ASIGN":
				res=res+asign(i);
				break;

			case "LBL":
				res=res+lbl(i);
				break;
			case "JMP":
				res=res+jmp(i);
				break;
			case "ASIGNMAS":
				res=res+asignmas(i);
				break;
			case "ASIGNMENOS":
				res=res+asignmenos(i);
				break;
			case "MDECL":
				res=res+mdecl(i);
				break;
			
			case "ENDMETH":
				res=res+endmeth(i);
				break;

			case "RETURNMETH":
				res=res+returnMeth(i);
				break;
			}

		}
	return res;
	}


	public String sum(IntermediateCode i){
		Expr resultExpr = (Expr) i.getResult();  
		String result;
		String op1 = getAsmOp(i.getOp1());
		String op2 = getAsmOp(i.getOp2());
		result="mov "+op1+","+resultExpr.getOffset()+"(%ebp)\n";
		result=result+"add "+op2+", "+resultExpr.getOffset()+"(%ebp)\n";
		return result;
	}
	public String res(IntermediateCode i){
		Expr resultExpr = (Expr) i.getResult();  
		String result;
		String op1 = getAsmOp(i.getOp1());
		String op2 = getAsmOp(i.getOp2());
		result="mov "+op2+",%eax\n";
		result=result+"sub "+op1+",%eax\n";
		result=result+"mov %eax, "+resultExpr.getOffset()+"(%ebp)\n";
		return result;
	}

	public String mul(IntermediateCode i){
		Expr resultExpr = (Expr) i.getResult();  
		String result;
		String op1 = getAsmOp(i.getOp1());
		String op2 = getAsmOp(i.getOp2());
		result="mov "+op1+","+resultExpr.getOffset()+"(%ebp)\n";
		result=result+"imul "+op2+", "+resultExpr.getOffset()+"(%ebp)\n";
		return result;
	}
	public String asign(IntermediateCode i){
		Expr resultExpr = (Expr) i.getResult();  
		String result;
		String op1 = getAsmOp(i.getOp1());
		result="mov "+op1+","+resultExpr.getOffset()+"(%ebp)\n";
		return result;
	}
	public String asignmas(IntermediateCode i){
		Expr resultExpr = (Expr) i.getResult();  
		String result;
		String op1 = getAsmOp(i.getOp1());
		result="add "+op1+", "+resultExpr.getOffset()+"(%ebp)\n";
		return result;
	}
	public String asignmenos(IntermediateCode i){
		Expr resultExpr = (Expr) i.getResult();  
		String result;
		String op1 = getAsmOp(i.getOp1());
		result= "mov "+op1+", %eax\n";
		result=result+"sub "+resultExpr.getOffset()+"(%ebp), %eax\n";
		result= result+"mov  %eax, "+resultExpr.getOffset()+"(%ebp)\n";
		return result;
	}

	public String jmp(IntermediateCode i){
		Label lblTojump = (Label) i.getResult();
		String result;
		result= "jmp ."+lblTojump.toString()+"\n";
		
		return result;
	}
	public String inc(IntermediateCode i){
		Location var = (Location) i.getResult();
		String result;
		result= "inc "+var.getOffset()+"(%ebp)\n";
		
		return result;
	}
	public String mdecl(IntermediateCode i){
		Label lbl = (Label) i.getResult();
		String result;
		result= "."+lbl.toString()+":\n"+prologo(i.getOffset());
		
		return result;
	}

	public String lbl(IntermediateCode i){
		Label lbl = (Label) i.getResult();
		String result;
		result= "."+lbl.toString()+":\n";
		
		return result;
	}

	public String jmpf(IntermediateCode i){
		Label lblTojump = (Label) i.getResult();
		String result;
		result="cmp "+getAsmOp(i.getOp1())+", 1\n";
		result= result+"jne ."+lblTojump.toString()+"\n";
		
		return result;
	} 
	public String endmeth(IntermediateCode i){
		return "leave\nret\n";
	}


	public String getAsmOp(AST a){
		if(a instanceof Literal_integer){
			return "$"+a.toString();

		}else if(a instanceof Location){
			Location l = (Location)a;
			return l.getOffset()+"(%ebp)";
		}
		return "";
	}
	
	private String prologo(int offset){
		String prologo = "pushl %ebp\nmovl %esp,%ebp\nsubl $"+Math.abs(offset)+", %esp\n";
		return prologo;
	}
	
	public String returnMeth(IntermediateCode i){
		Expr resultExpr = (Expr) i.getResult();  
		String result;
		result="mov "+resultExpr.getOffset()+"(%ebp), %eax\n";
		return result;
	}
	
}