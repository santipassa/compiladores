package Compi;

import java.util.LinkedList;
public class IntermediateCode{
	String operator;
	AST op1;
	AST op2;
	AST result;
	public IntermediateCode(String operator,AST op1, AST op2,AST result){
		this.operator=operator;
		this.op1=op1;
		this.op2=op2;
		this.result=result;
	}
	public String toString(){
		return operator+" "+op1.toString()+" "+op2.toString()+" "+result.toString();
	}





}