package Compi;
import java.util.LinkedList;
public class AssemblerGenerator{
	LinkedList<String> textSegment = new LinkedList<String>();
	LinkedList<String> dataSegment = new LinkedList<String>();

	public String readList(LinkedList<IntermediateCode> l){
        String res="";
		for(IntermediateCode i : l){
			
			if(i.getOperator().equals("SUM")){

				res=res+sum(i);

			}else if (i.getOperator().equals("RES")){
				res=res+res(i);

			}
		}
		return res;		
	}

		/*case RES:
	}
					res(i);
				case MUL:
					mul(i);
				case DIV:
					div(i);
				case MAY:
					may(i);
				case MEN:
					men(i);
				case MAYI:
					mayi(i);
				case MENI:
					meni(i);
				case IGUAL:
					igual(i);
				case AND:
					and(i);
				case OR:
					or(i);
				case RESERVE:
					reserve(i);
				case CALL:
					call(i);
				case ASIGN:
					asign(i);
				case ASIGNMAS:
					asignmas(i);
				case ASIGNMENOS:
					asignmenos(i);
				case JMPBREAK:
					jmpbreak(i);
				case JMPCONTINUE:
					jmpcontinue(i);
				*/


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


}