package Compi;

import java.util.LinkedList;

public class Method_call_expr extends Expr {

	private LinkedList<Expr> param_expr;
	private String param_id; // object.param_id()
	private Type type_param; // tipo del .param_id()


	public Method_call_expr(String i, LinkedList<Expr> pe, String pi, int n){
		setId(i);
		this.param_expr=pe;
		this.param_id=pi;
		setLineNumber(n);	

	}
	public Method_call_expr(String i, int n){
		setId(i);
		setLineNumber(n);	
	}
	public Method_call_expr(String i, String pi, int n){
		setId(i);
		this.param_id=pi;
		setLineNumber(n);	

	}
	public Method_call_expr(String i, int n, LinkedList<Expr> pe){
		setId(i);
		this.param_expr=pe;
		setLineNumber(n);	

	}

	public void setParamType(Type x){
		type_param = x;
	}

	public Type getParamType(){
		return type_param;
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}
	public String toString(){
		return "";
	}
}	
