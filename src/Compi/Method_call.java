package Compi;

import java.util.LinkedList;

public class Method_call extends Statement {

	private LinkedList<Expr> param_expr;
	private String param_id; // object.param_id()

	public Method_call(String i, LinkedList<Expr> pe, String pi, int n){
		setId(i);
		this.param_expr=pe;
		this.param_id=pi;
		setLineNumber(n);	
	}

	public Method_call(String i, int n){
		setId(i);
		setLineNumber(n);	
	}

	public Method_call(String i, String pi, int n){
		setId(i);
		this.param_id=pi;
		setLineNumber(n);	

	}
	public Method_call(String i, int n, LinkedList<Expr> pe){
		setId(i);
		this.param_expr=pe;
		setLineNumber(n);	

	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}


}
