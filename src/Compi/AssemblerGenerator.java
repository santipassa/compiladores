public class AssemblerGenerator{
	LinkedList<String> textSegment = new LinkedList<String>();
	LinkedList<String> dataSegment = new LinkedList<String>();

	public String readList(LinkedList<IntermediateCode> l){

		for(IntermediateCode i : l){
			switch(i.getOperator()){
				case SUM: 
					sum(i);
				case RES:
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
				


				












			}





		}



	}

}