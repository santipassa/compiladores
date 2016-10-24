package Compi;
import java.util.LinkedList;
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
			/*case "DIV":
				res=res+div(i);
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
			case "IGUAL":
				res=res+igual(i);
				break;
			case "AND":
				res=res+and(i);
				break;
			case "OR":
				res=res+or(i);
				break;
			case "RESERVE":
				res=res+reserve(i);
				break;
			case "METH":
				res=res+meth(i);
				break;
			case "NEG":
				res=res+neg(i);
				break;
			case "ABS":
				res=res+abs(i);
				break;
			case "CALL":
				res=res+call(i);
				break;
			case "ASIGN":
				res=res+asign(i);
				break;
			case "ASIGNMAS":
				res=res+asignmas(i);
				break;
			case "ASIGNMENOS":
				res=res+asignmenos(i);
				break;
			case "JMPBREAK":
				res=res+jmpbreak(i);
				break;
			case "JMPCONTINUE":
				res=res+jmpcontinue(i);
				break;
			case "LBLFOR":
				res=res+lblfor(i);
				break;
			case "LABELFORFIN":
				res=res+lblforfin(i);
				break;
			case "JMPF":
				res=res+jmpf(i);
				break;
			case "INC":
				res=res+inc(i);
				break;
			case "JMP":
				res=res+jmp(i);
				break;
			case "LBLIF":
				res=res+lblif(i);
				break;
			case "LBLELSE":
				res=res+lblelse(i);
				break;
			case "LBLFIN":
				res=res+lblfin(i);
				break;
			case "LBLWHILE":
				res=res+lblwhile(i);
				break;
			case "LBLWHILEFIN":
				res=res+lblwhilefin(i);
				break;*/
			}
		}
	return res;
	}


	public String sum(IntermediateCode i){
		Expr op1Expr = (Expr) i.getOp1();
		Expr op2Expr = (Expr) i.getOp2();
		Expr resultExpr = (Expr) i.getResult();  
		String result;
		String op1;
		String op2;
		try{
			int op1Int = Integer.parseInt(op1Expr.toString());
			op1 = "$"+op1Int;
		}catch(Exception e){

			op1=op1Expr.getOffset()+"(%rbp)";
		}

		try{
			int op2Int = Integer.parseInt(op2Expr.toString());
			op2 = "$"+op2Int;
		}catch(Exception e){

			op2=op2Expr.getOffset()+"(%rbp)";
		}

		result="mov "+op1+","+resultExpr.getOffset()+"(%rbp)\n";
		result=result+"add "+op2+", "+resultExpr.getOffset()+"(%rbp)\n";
		return result;



	}
	public String res(IntermediateCode i){
		Expr op1Expr = (Expr) i.getOp1();
		Expr op2Expr = (Expr) i.getOp2();
		Expr resultExpr = (Expr) i.getResult();  
		String result;
		String op1;
		String op2;
		try{
			int op1Int = Integer.parseInt(op1Expr.toString());
			op1 = "$"+op1Int;
		}catch(Exception e){

			op1=op1Expr.getOffset()+"(%rbp)";
		}

		try{
			int op2Int = Integer.parseInt(op2Expr.toString());
			op2 = "$"+op2Int;
		}catch(Exception e){

			op2=op2Expr.getOffset()+"(%rbp)";
		}

		result="mov "+op1+","+resultExpr.getOffset()+"(%rbp)\n";
		result=result+"sub "+resultExpr.getOffset()+", "+op2+"(%rbp)\n";
		return result;
	}

	public String mul(IntermediateCode i){
		Expr op1Expr = (Expr) i.getOp1();
		Expr op2Expr = (Expr) i.getOp2();
		Expr resultExpr = (Expr) i.getResult();  
		String result;
		String op1;
		String op2;
		try{
			int op1Int = Integer.parseInt(op1Expr.toString());
			op1 = "$"+op1Int;
		}catch(Exception e){

			op1=op1Expr.getOffset()+"(%rbp)";
		}

		try{
			int op2Int = Integer.parseInt(op2Expr.toString());
			op2 = "$"+op2Int;
		}catch(Exception e){

			op2=op2Expr.getOffset()+"(%rbp)";
		}

		result="mov "+op1+","+resultExpr.getOffset()+"(%rbp)\n";
		result=result+"imul "+op2+", "+resultExpr.getOffset()+"(%rbp)\n";
		return result;
	}




}