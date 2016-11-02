package Compi;
import java.util.LinkedList;
public class AssemblerGenerator{
	int countLabel=0;
	/*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
	/* PELIGROOOOOOO!!!!!! NO USAR NUNCA EL EAX, SOLO LO USA EL RETORNO DE UN METODO, USAR DESDE EBX EN ADELANTE */
	/*///////////////////////////////////////////////////////////////////////////////////////////////////////////*/
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
			case "DIV":
				res=res+div(i);
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
			case "CALL":
				res=res+call(i);
				break;

			case "JMPF":
				res=res+jmpf(i);
				break;
			case "IGUAL":
				res=res+igual(i);
				break;
			
			case "ABS":
				res=res+abs(i);
				break;
			case "MAY":
				res=res+may(i);
				break;
			case "MEN":
				res=res+men(i);
				break;
			case "MAYI":
				res=res+mayi(i);
				break;
			case "MENI":
				res=res+meni(i);
				break;
			case "AND":
				res=res+and(i);
				break;
			case "OR":
				res=res+or(i);
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
		result="movl "+op1+","+"%ebx\n";
		result=result+"movl "+op2+","+"%ecx\n";
		result=result+"addl %ebx, %ecx\n";
		result=result+"movl %ecx, "+resultExpr.getOffset()+"(%ebp)\n";
		return result;
	}
	public String res(IntermediateCode i){
		Expr resultExpr = (Expr) i.getResult();  
		String result;
		String op1 = getAsmOp(i.getOp1());
		String op2 = getAsmOp(i.getOp2());
		result="movl "+op2+",%ebx\n";
		result=result+"subl "+op1+",%ebx\n";
		result=result+"movl %ebx, "+resultExpr.getOffset()+"(%ebp)\n";
		return result;
	}

	public String mul(IntermediateCode i){
		Expr resultExpr = (Expr) i.getResult();  
		String result;
		String op1 = getAsmOp(i.getOp1());
		String op2 = getAsmOp(i.getOp2());
		result="movl "+op1+", %ebx\n";
		result=result+"imull "+op2+", %ebx\n";
		result=result+"%ebx, "+resultExpr.getOffset()+"(%ebp)\n";
		return result;
	}

	public String div(IntermediateCode i){
		Expr resultExpr = (Expr) i.getResult();  
		String result;
		String op1 = getAsmOp(i.getOp1());
		String op2 = getAsmOp(i.getOp2());
		result="movl %eax,%ebx\n"; //guardo el viejo eax esto es por las dudas si antes hubo una llamada a metodo.
		result="movl "+op1+",%eax\n";
		result=result+"cltd\n";
		result=result+"idivl "+op2+"\n";
		result=result+"%eax, "+resultExpr.getOffset()+"(%ebp)\n";
		result="movl %ebx,%eax\n"; //restauro el viejo eax
		return result;
	}

	public String asign(IntermediateCode i){
		Expr resultExpr = (Expr) i.getResult();  
		String result;
		String op1 = getAsmOp(i.getOp1());
		result="movl "+op1+", %ebx\n";
		result=result+"movl %ebx, "+resultExpr.getOffset()+"(%ebp)\n";
		return result;
	}
	public String asignmas(IntermediateCode i){
		Expr resultExpr = (Expr) i.getResult();  
		String result;
		String op1 = getAsmOp(i.getOp1());
		result="addl "+op1+", "+resultExpr.getOffset()+"(%ebp)\n";
		return result;
	}
	public String asignmenos(IntermediateCode i){
		Expr resultExpr = (Expr) i.getResult();  
		String result;
		String op1 = getAsmOp(i.getOp1());
		result= "movl "+op1+", %ebx\n";
		result=result+"subl "+resultExpr.getOffset()+"(%ebp), %ebx\n";
		result= result+"movl  %ebx, "+resultExpr.getOffset()+"(%ebp)\n";
		return result;
	}

	public String jmp(IntermediateCode i){
		Label lblTojump = (Label) i.getResult();
		String result;
		result= "jmp ."+lblTojump.toString()+"\n";	
		return result;
	}

	public String mdecl(IntermediateCode i){
		Label lbl = (Label) i.getResult();
		String result;
		result= ".globl "+lbl.toString()+"\n.type "+ lbl.toString()+", @function\n";
		result= result+lbl.toString()+":\n"+prologo(i.getOffset());	
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
		}else if(a instanceof Registro){
			Registro r = (Registro)a;
			return r.toString();
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
		result="movl "+ getAsmOp(resultExpr)+", %eax\n";
		return result;
	}
	public String call(IntermediateCode i){
		Label lblTojump = (Label) i.getResult();
		String result;
		result="call "+lblTojump.toString()+"\n";
		return result;
	}
	
	public String igual(IntermediateCode i){
		Location loc = (Location) i.getResult();
		String op1 = getAsmOp(i.getOp1());
		String op2 = getAsmOp(i.getOp2());
		String result;
		result="cmpl "+op1+", "+op2+"\n";
		String lbl1= ".L"+countLabel;
		result= result+"je "+lbl1+"\n";
		countLabel++;
		String lbl2= ".L"+countLabel;
		result= result+"movl $0, "+loc.getOffset()+"(%ebp)\n";
		result= result+"jmp "+lbl2+"\n";
		result= result+lbl1+":\n";
		result= result+"movl $1, "+loc.getOffset()+"(%ebp)\n";
		result= result+lbl2+":\n";
		countLabel++;
		return result;
	}

	public String may(IntermediateCode i){
		Location loc = (Location) i.getResult();
		String op1 = getAsmOp(i.getOp1());
		String op2 = getAsmOp(i.getOp2());
		String result;
		result="cmp "+op1+", "+op2+"\n";
		String lbl1= ".L"+countLabel;
		result= result+"jg "+lbl1+"\n";
		countLabel++;
		String lbl2= ".L"+countLabel;
		result= result+"movl $0, "+loc.getOffset()+"(%ebp)\n";
		result= result+"jmp "+lbl2+"\n";
		result= result+lbl1+":\n";
		result= result+"movl $1, "+loc.getOffset()+"(%ebp)\n";
		result= result+lbl2+":\n";
		countLabel++;
		return result;
	}

	public String men(IntermediateCode i){
		Location loc = (Location) i.getResult();
		String op1 = getAsmOp(i.getOp1());
		String op2 = getAsmOp(i.getOp2());
		String result;
		result="cmp "+op1+", "+op2+"\n";
		String lbl1= ".L"+countLabel;
		result= result+"jl "+lbl1+"\n";
		countLabel++;
		String lbl2= ".L"+countLabel;
		result= result+"movl $0, "+loc.getOffset()+"(%ebp)\n";
		result= result+"jmp "+lbl2+"\n";
		result= result+lbl1+":\n";
		result= result+"movl $1, "+loc.getOffset()+"(%ebp)\n";
		result= result+lbl2+":\n";
		countLabel++;
		return result;
	}

	public String mayi(IntermediateCode i){
		Location loc = (Location) i.getResult();
		String op1 = getAsmOp(i.getOp1());
		String op2 = getAsmOp(i.getOp2());
		String result;
		result="cmp "+op1+", "+op2+"\n";
		String lbl1= ".L"+countLabel;
		result= result+"jge "+lbl1+"\n";
		countLabel++;
		String lbl2= ".L"+countLabel;
		result= result+"movl $0, "+loc.getOffset()+"(%ebp)\n";
		result= result+"jmp "+lbl2+"\n";
		result= result+lbl1+":\n";
		result= result+"movl $1, "+loc.getOffset()+"(%ebp)\n";
		result= result+lbl2+":\n";
		countLabel++;
		return result;
	}

	public String meni(IntermediateCode i){
		Location loc = (Location) i.getResult();
		String op1 = getAsmOp(i.getOp1());
		String op2 = getAsmOp(i.getOp2());
		String result;
		result="cmp "+op1+", "+op2+"\n";
		String lbl1= ".L"+countLabel;
		result= result+"jle "+lbl1+"\n";
		countLabel++;
		String lbl2= ".L"+countLabel;
		result= result+"movl $0, "+loc.getOffset()+"(%ebp)\n";
		result= result+"jmp "+lbl2+"\n";
		result= result+lbl1+":\n";
		result= result+"movl $1, "+loc.getOffset()+"(%ebp)\n";
		result= result+lbl2+":\n";
		countLabel++;
		return result;
	}

	public String and(IntermediateCode i){
		Location loc = (Location) i.getResult();
		String op1 = getAsmOp(i.getOp1());
		String op2 = getAsmOp(i.getOp2());
		String result;
		String lbl1= ".L"+countLabel;
		countLabel++;
		String lbl2= ".L"+countLabel;
		countLabel++;
		String lbl3= ".L"+countLabel;
		result="cmp "+op1+", "+"$1\n";
		result= result+"je "+lbl1+"\n";
		result= result+"movl $0, "+loc.getOffset()+"(%ebp)\n";
		result= result+"jmp "+lbl3+"\n";
		result= result+lbl1+":\n";
		result= result+"cmp "+op2+", "+"$1\n";
		result= result+"je "+lbl2+"\n";
		result= result+"movl $0, "+loc.getOffset()+"(%ebp)\n";
		result= result+"jmp "+lbl3+"\n";
		result= result+lbl2+":\n";
		result=result+"movl $1, "+loc.getOffset()+"(%ebp)\n";
		result= result+lbl3+":\n";
		countLabel++;
		return result;
	}

	public String or(IntermediateCode i){
		Location loc = (Location) i.getResult();
		String op1 = getAsmOp(i.getOp1());
		String op2 = getAsmOp(i.getOp2());
		String result;
		String lbl1= ".L"+countLabel;
		countLabel++;
		String lbl2= ".L"+countLabel;
		countLabel++;
		String lbl3= ".L"+countLabel;
		result="cmp "+op1+", "+"$1\n";
		result= result+"jne "+lbl1+"\n";
		result= result+"movl $1, "+loc.getOffset()+"(%ebp)\n";
		result= result+"jmp "+lbl3+"\n";
		result= result+lbl1+":\n";
		result= result+"cmp "+op2+", "+"$1\n";
		result= result+"jne "+lbl2+"\n";
		result= result+"movl $1, "+loc.getOffset()+"(%ebp)\n";
		result= result+"jmp "+lbl3+"\n";
		result= result+lbl2+":\n";
		result=result+"movl $0, "+loc.getOffset()+"(%ebp)\n";
		result= result+lbl3+":\n";
		countLabel++;
		return result;
	}

	public String abs(IntermediateCode i){
		Location loc = (Location) i.getResult();
		AST op1 = i.getOp1();
		String result;

		if(op1 instanceof Literal_integer){
			String opstr=op1.toString();
			result="movl $-"+opstr+","+loc.getOffset()+"(%ebp)\n";
		}else{
			Location op1Loc = (Location) i.getOp1();
			result="movl "+op1Loc.getOffset()+"(%ebp), %ebx\n";
			result=result+"negl %ebx\n";
			result=result+"movl %ebx, "+loc.getOffset()+"(%ebp)\n";
		}
		
		return result;
	}

}