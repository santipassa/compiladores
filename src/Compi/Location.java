package Compi;

import java.util.LinkedList;

public class Location extends Expr{

	String id;
	LinkedList<String> param_id;

	public Location(String i, int n){
		this.id=i;
		setLineNumber(n);	

	}
	public Location(String i, LinkedList<String> pi, int n){
		this.id=i;
		this.param_id=pi;
		setLineNumber(n);	
	}
	public Location(String i, Expr e, int n){
		this.id=i;
		this.expr=e;
		setLineNumber(n);	
	}
	public Location(String i, LinkedList<String> pi, Expr e, int n){
		this.id=i;
		this.param_id=pi;
		this.expr=e;
		setLineNumber(n);	

	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}

}
