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
		return operator+" "+getStr(op1)+" "+getStr(op2)+" "+getStr(result);
	}

	private String getStr(AST op){
		if(op!=null){
			return op.toString();
		}else{
			return "null";
		}
	}





}