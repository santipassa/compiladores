package Compi;

import java.util.LinkedList;
public class IntermediateCode{
	String operator;
	AST op1;
	AST op2;
	AST result;
	int offset;
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
	public String getOperator(){
		return this.operator;
	}

	public AST getOp1(){
		return this.op1;
	}

	public AST getOp2(){
		return this.op2;
	}

	public AST getResult(){
		return this.result;
	}
	public void setOffset(int offset){
		this.offset=offset;
	}
	public int getOffset(){
		return this.offset;
	}



}