package Compi;

import java.util.LinkedList;

public class Method_call extends Statement {

	private String firstId;
	private LinkedList<Expr> param_expr;
	private LinkedList<String> param_id; 

	public Method_call(String i, LinkedList<Expr> pe, LinkedList<String> pi, int n){
		setId(i);
		firstId = i;
		this.param_expr=pe;
		this.param_id=pi;
		setLineNumber(n);	
	}

	public Method_call(String i, int n){
		setId(i);
		firstId = i;
		setLineNumber(n);	
	}

	public Method_call(String i, LinkedList<String> pi, int n){
		setId(i);
		firstId = i;
		this.param_id=pi;
		setLineNumber(n);	

	}
	public Method_call(String i, int n, LinkedList<Expr> pe){
		setId(i);
		firstId = i;
		this.param_expr=pe;
		setLineNumber(n);	

	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}


}
