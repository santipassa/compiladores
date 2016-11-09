package Compi;
import java.util.LinkedList;
public class AssemblerGenerator{
	private LinkedList<String> edx= new LinkedList<String>();
	int countLabel=0;
	int countLabelsForDebug=0;
	boolean isMain = false;
	//imprime eax al finalizar cada metodo para ver que devuelve al finalizar.
	boolean debugMode = true;
	/*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
	/* PELIGROOOOOOO!!!!!! NO USAR NUNCA EL EAX, SOLO LO USA EL RETORNO DE UN METODO, USAR DESDE EBX EN ADELANTE */
	/*///////////////////////////////////////////////////////////////////////////////////////////////////////////*/
	private void addEdx(String str){
		edx.add(str);
	}

	private String getEdx(){
		String aux = edx.pollFirst();
		if (aux == null)
			return "";
		else
			return aux;
	}

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
			case "ARRAY":
				res=res+array(i);
				break;
			}

		}
	return res;
	}

	private String resultLocation(AST ast){
		if(ast instanceof Location){
			Location loc = (Location) ast;
			if (loc.isArray()){
				return loc.getOffset()+"(%ebp, %edx, 4)\n";
			}
		}	
		Expr resultExpr = (Expr) ast;
		return resultExpr.getOffset()+"(%ebp)\n";
		
	}

	private String sum(IntermediateCode i){
		String result;
		String op1 = getAsmOp(i.getOp1());
		String op2 = getAsmOp(i.getOp2());
		result=getEdx()+"movl "+op1+","+"%ebx\n";
		result=result+getEdx()+"movl "+op2+","+"%ecx\n";
		result=result+"addl %ebx, %ecx\n";
		result=result+getEdx()+"movl %ecx, "+resultLocation(i.getResult());
		return result;
	}
	private String res(IntermediateCode i){
		String result;
		String op1 = getAsmOp(i.getOp1());
		String op2 = getAsmOp(i.getOp2());
		String aux = getEdx();
		result=getEdx()+"movl "+op2+","+"%ebx\n";
		result=result+aux+"movl "+op1+","+"%ecx\n";
		result=result+"subl %ebx, %ecx\n";
		result=result+getEdx()+"movl %ecx, "+resultLocation(i.getResult());
		return result;
	}

	private String mul(IntermediateCode i){
		String result;
		String op1 = getAsmOp(i.getOp1());
		String op2 = getAsmOp(i.getOp2());
		result=getEdx()+"movl "+op1+","+"%ebx\n";
		result=result+getEdx()+"movl "+op2+","+"%ecx\n";
		result=result+"imull %ebx, %ecx\n";
		result=result+getEdx()+"movl %ecx, "+resultLocation(i.getResult());
		return result;
	}

	private String div(IntermediateCode i){
		String result;
		String op1 = getAsmOp(i.getOp1());
		String op2 = getAsmOp(i.getOp2());
		result="movl %eax,%ebx\n"; //guardo el viejo eax esto es por las dudas si antes hubo una llamada a metodo.
		result=getEdx()+"movl "+op1+",%eax\n";
		result=result+"cltd\n";
		result=result+"movl "+op2+",%ecx\n";
		result=result+getEdx()+"idivl %ecx\n";
		result=result+getEdx()+"movl %eax, "+resultLocation(i.getResult());
		result=result+"movl %ebx,%eax\n"; //restauro el viejo eax
		return result;
	}

	private String asign(IntermediateCode i){
		String result;
		String op1 = getAsmOp(i.getOp1());
		result=getEdx()+"movl "+op1+", %ebx\n";
		result=result+getEdx()+"movl %ebx, "+resultLocation(i.getResult());
		return result;
	}
	private String asignmas(IntermediateCode i){
		String result;
		String op1 = getAsmOp(i.getOp1());
		result=getEdx()+"movl "+op1+", %ebx\n";
		result=result +getEdx()+ "addl %ebx, "+resultLocation(i.getResult());
		return result;
	}
	private String asignmenos(IntermediateCode i){
		String result;
		String op1 = getAsmOp(i.getOp1());
		result= getEdx()+"movl "+op1+", %ebx\n";
		result=result+getEdx()+"subl "+getAsmOp(i.getResult())+"(%ebp), %ebx\n";
		result= result+getEdx()+"movl  %ebx, "+resultLocation(i.getResult());
		return result;
	}

	private String jmp(IntermediateCode i){
		Label lblTojump = (Label) i.getResult();
		String result;
		result= "jmp ."+lblTojump.toString()+"\n";	
		return result;
	}

	private String mdecl(IntermediateCode i){
		Label lbl = (Label) i.getResult();
		String result;
		isMain = lbl.toString().equals("main");
		result=(debugMode && isMain)?printEaxBegin(lbl.toString()):"\n";
		result= result+".globl "+lbl.toString()+"\n.type "+ lbl.toString()+", @function\n";
		result= result+lbl.toString()+":\n"+prologo(i.getOffset());	
		return result;
	}

	private String lbl(IntermediateCode i){
		Label lbl = (Label) i.getResult();
		String result;
		result= "."+lbl.toString()+":\n";	
		return result;
	}

	private String jmpf(IntermediateCode i){
		Label lblTojump = (Label) i.getResult();
		String result;
		result="movl $1, %ebx\n";
		result=result+getEdx()+"cmpl "+getAsmOp(i.getOp1())+", %ebx \n";
		result= result+"jne ."+lblTojump.toString()+"\n";
		return result;
	} 

	private String endmeth(IntermediateCode i){
		String result = (debugMode && isMain )?printEaxEnd():"\n";
		return result+"leave\nret\n";
	}


	private String getAsmOp(AST a){
		//faltan los literals boolean y flotantes (hay que ver como se tratan)
		if(a instanceof Literal_integer){
			return "$"+a.toString();

		}else if(a instanceof Location){
			Location l = (Location)a;
			if (l.isArray())
				return l.getOffset()+"(%ebp, %edx, 4)";
			else
				return l.getOffset()+"(%ebp)";
		}else if(a instanceof Literal_boolean){
			if (a.toString().compareTo("True")==0)
				return "$1";
			else 
				return "$0";
		}else if(a instanceof Registro){
			Registro r = (Registro)a;
			return r.toString();
		}
		return "";
	}
	
	private String prologo(int offset){
		String prologo = "pushl %ebp\nmovl %esp,%ebp\nsubl $"+(Math.abs(offset)-4)+", %esp\n";
		return prologo;
	}
	
	private String returnMeth(IntermediateCode i){
		AST resultExpr = i.getResult();  
		String result;
		result=getEdx()+"movl "+ getAsmOp(resultExpr)+", %eax\n";
		return result;
	}
	private String call(IntermediateCode i){
		AST op1 = i.getOp1();
		LinkedList<Expr> params;
		if(op1 instanceof Method_call){
			Method_call mcall = (Method_call) op1;
			params = mcall.getParam_expr();
		}
		else{
			Method_call_expr mcall = (Method_call_expr) op1;
			params = mcall.getParam_expr();
		}

		String result="";
		if (params!=null){
			result = "subl	$"+(params.size()*4)+", %esp\n";
			int index = 0;
			String str;
			for(Expr e : params){
				result = result+"movl "+getAsmOp(e)+", "+index+"(%esp)\n";
				index = index +4;
			}
		}

		Label lblTojump = (Label) i.getResult();
		result=result+"call "+lblTojump.toString()+"\n";
		return result;
	}
	
	private String igual(IntermediateCode i){
		String op1 = getAsmOp(i.getOp1());
		String op2 = getAsmOp(i.getOp2());
		String result;
		String aux = getEdx();
		result=getEdx()+"movl "+op2+", %ebx\n";
		result=result+aux+"cmpl "+op1+", %ebx\n";
		String lbl1= ".L"+countLabel;
		result= result+"je "+lbl1+"\n";
		countLabel++;
		String lbl2= ".L"+countLabel;
		aux = getEdx();
		result= result+aux+"movl $0, "+resultLocation(i.getResult());
		result= result+"jmp "+lbl2+"\n";
		result= result+lbl1+":\n";
		result= result+aux+"movl $1, "+resultLocation(i.getResult());
		result= result+lbl2+":\n";
		countLabel++;
		return result;
	}

	private String may(IntermediateCode i){
		String op1 = getAsmOp(i.getOp1());
		String op2 = getAsmOp(i.getOp2());
		String result;
		String aux = getEdx();
		result=getEdx()+"movl "+op2+", %ebx\n";
		result=result+aux+"cmpl "+op1+", %ebx\n";
		String lbl1= ".L"+countLabel;
		result= result+"jl "+lbl1+"\n";
		countLabel++;
		String lbl2= ".L"+countLabel;
		aux = getEdx();
		result= result+aux+"movl $0, "+resultLocation(i.getResult());
		result= result+"jmp "+lbl2+"\n";
		result= result+lbl1+":\n";
		result= result+aux+"movl $1, "+resultLocation(i.getResult());
		result= result+lbl2+":\n";
		countLabel++;
		return result;
	}

	private String men(IntermediateCode i){
		String op1 = getAsmOp(i.getOp1());
		String op2 = getAsmOp(i.getOp2());
		String result;
		String aux = getEdx();
		result=getEdx()+"movl "+op2+", %ebx\n";
		result=result+aux+"cmpl "+op1+", %ebx\n";
		String lbl1= ".L"+countLabel;
		result= result+"jg "+lbl1+"\n";
		countLabel++;
		String lbl2= ".L"+countLabel;
		aux = getEdx();
		result= result+aux+"movl $0, "+resultLocation(i.getResult());
		result= result+"jmp "+lbl2+"\n";
		result= result+lbl1+":\n";
		result= result+aux+"movl $1, "+resultLocation(i.getResult());
		result= result+lbl2+":\n";
		countLabel++;
		return result;
	}

	private String mayi(IntermediateCode i){
		String op1 = getAsmOp(i.getOp1());
		String op2 = getAsmOp(i.getOp2());
		String result;
		String aux = getEdx();
		result=getEdx()+"movl "+op2+", %ebx\n";
		result=result+aux+"cmpl "+op1+", %ebx\n";
		String lbl1= ".L"+countLabel;
		result= result+"jle "+lbl1+"\n";
		countLabel++;
		String lbl2= ".L"+countLabel;
		aux = getEdx();
		result= result+aux+"movl $0, "+resultLocation(i.getResult());
		result= result+"jmp "+lbl2+"\n";
		result= result+lbl1+":\n";
		result= result+aux+"movl $1, "+resultLocation(i.getResult());
		result= result+lbl2+":\n";
		countLabel++;
		return result;
	}

	private String meni(IntermediateCode i){
		String op1 = getAsmOp(i.getOp1());
		String op2 = getAsmOp(i.getOp2());
		String result;
		String aux = getEdx();
		result=getEdx()+"movl "+op2+", %ebx\n";
		result=result+aux+"cmpl "+op1+", %ebx\n";
		String lbl1= ".L"+countLabel;
		result= result+"jge "+lbl1+"\n";
		countLabel++;
		String lbl2= ".L"+countLabel;
		aux = getEdx();
		result= result+aux+"movl $0, "+resultLocation(i.getResult());
		result= result+"jmp "+lbl2+"\n";
		result= result+lbl1+":\n";
		result= result+aux+"movl $1, "+resultLocation(i.getResult());
		result= result+lbl2+":\n";
		countLabel++;
		return result;
	}

	private String and(IntermediateCode i){
		String op1 = getAsmOp(i.getOp1());
		String op2 = getAsmOp(i.getOp2());
		String result;
		String lbl1= ".L"+countLabel;
		countLabel++;
		String lbl2= ".L"+countLabel;
		countLabel++;
		String lbl3= ".L"+countLabel;
		result=getEdx()+"cmpl $1, "+op1+"\n";
		result= result+"je "+lbl1+"\n";
		String aux = getEdx();
		String aux1 = getEdx();
		result= result+aux1+"movl $0, "+resultLocation(i.getResult());
		result= result+"jmp "+lbl3+"\n";
		result= result+lbl1+":\n";
		result= result+aux+"cmpl $1, "+op2+"\n";
		result= result+"je "+lbl2+"\n";
		result= result+aux1+"movl $0, "+resultLocation(i.getResult());
		result= result+"jmp "+lbl3+"\n";
		result= result+lbl2+":\n";
		result=result+aux1+"movl $1, "+resultLocation(i.getResult());
		result= result+lbl3+":\n";
		countLabel++;
		return result;
	}

	private String or(IntermediateCode i){
		String op1 = getAsmOp(i.getOp1());
		String op2 = getAsmOp(i.getOp2());
		String result;
		String lbl1= ".L"+countLabel;
		countLabel++;
		String lbl2= ".L"+countLabel;
		countLabel++;
		String lbl3= ".L"+countLabel;
		result=getEdx()+"cmpl $1, "+op1+"\n";
		result= result+"jne "+lbl1+"\n";
		String aux = getEdx();
		String aux1 = getEdx();
		result= result+aux1+"movl $1, "+resultLocation(i.getResult());
		result= result+"jmp "+lbl3+"\n";
		result= result+lbl1+":\n";
		result= result+aux+"cmpl $1, "+op2+"\n";
		result= result+"jne "+lbl2+"\n";
		result= result+aux1+"movl $1, "+resultLocation(i.getResult());
		result= result+"jmp "+lbl3+"\n";
		result= result+lbl2+":\n";
		result=result+aux1+"movl $0, "+resultLocation(i.getResult());
		result= result+lbl3+":\n";
		countLabel++;
		return result;
	}

	private String abs(IntermediateCode i){
		AST op1 = i.getOp1();
		String result;

		if(op1 instanceof Literal_integer){
			String opstr=op1.toString();
			result=getEdx()+"movl $-"+opstr+","+resultLocation(i.getResult());
		}else{
			result=getEdx()+"movl "+getAsmOp(i.getOp1())+"(%ebp), %ebx\n";
			result=result+"negl %ebx\n";
			result=result+"movl %ebx, "+resultLocation(i.getResult());
		}
		
		return result;
	}

	private String array(IntermediateCode i){
		AST loc = i.getOp2();
		String result;
		if(loc instanceof Literal_integer){
			String opstr=loc.toString();
			result="movl $"+opstr+", %edx\n";
		}else{
			Location op = (Location) loc;
			result="movl "+op.getOffset()+"(%ebp), %edx\n";
		}
		addEdx(result);
		return "";
	}

	private String printEaxEnd(){
		String result="movl	%eax, 4(%esp)\nmovl	$.LC"+countLabelsForDebug+", (%esp)\ncall	printf\n";
		countLabelsForDebug++;
		return result;

	}
	private String printEaxBegin(String methodName){
		String result=".LC"+countLabelsForDebug+":\n.string	\"EAX VALUE FROM "+methodName+" %i\\n\"\n";
		return result;
	}
}