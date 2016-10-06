package Compi;

import java.util.LinkedList;

public class Method_call_expr extends Expr {

	private LinkedList<Expr> param_expr;
	private String id_param; // object.param_id()

	public Method_call_expr(String i, LinkedList<Expr> pe, String pi, int n){
		setId(i);
		this.param_expr=pe;
		this.id_param=pi;
		setLineNumber(n);	

	}
	public Method_call_expr(String i, int n){
		setId(i);
		setLineNumber(n);	
	}
	public Method_call_expr(String i, String pi, int n){
		setId(i);
		this.id_param=pi;
		setLineNumber(n);	

	}
	public Method_call_expr(String i, int n, LinkedList<Expr> pe){
		setId(i);
		this.param_expr=pe;
		setLineNumber(n);	

	}

	public String getId_param(){
		return id_param;
	}

	public boolean isObjectCall(){
		return (id_param != null);
	}

	public LinkedList<Expr> getParam_expr(){
		return param_expr;
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}
	public String toString(){
		return "";
	}
}	
