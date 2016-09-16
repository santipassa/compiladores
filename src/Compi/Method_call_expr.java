package Compi;

import java.util.LinkedList;

public class Method_call_expr extends Expr {

	String id;
	LinkedList<Expr> param_expr;
	LinkedList<String> param_id; 

	public Method_call_expr(String i, LinkedList<Expr> pe, LinkedList<String> pi, int n){
		this.id=i;
		this.param_expr=pe;
		this.param_id=pi;
		setLineNumber(n);	

	}
	public Method_call_expr(String i, int n){
		this.id=i;
		setLineNumber(n);	
	}
	public Method_call_expr(String i, LinkedList<String> pi, int n){
		this.id=i;
		this.param_id=pi;
		setLineNumber(n);	

	}
	public Method_call_expr(String i, int n, LinkedList<Expr> pe){
		this.id=i;
		this.param_expr=pe;
		setLineNumber(n);	

	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}

}	
