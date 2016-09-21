package Compi;

import java.util.LinkedList;

public class Location extends Expr{

	LinkedList<String> param_id;

	public Location(String i, int n){
		setId(i);
		setLineNumber(n);	

	}
	public Location(String i, LinkedList<String> pi, int n){
		setId(i);
		this.param_id=pi;
		setLineNumber(n);	
	}
	public Location(String i, Expr e, int n){
		setId(i);
		this.expr=e;
		setLineNumber(n);	
	}
	public Location(String i, LinkedList<String> pi, Expr e, int n){
		setId(i);
		this.param_id=pi;
		this.expr=e;
		setLineNumber(n);	
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}

}
