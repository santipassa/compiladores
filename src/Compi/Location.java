package Compi;

import java.util.LinkedList;

public class Location extends Expr {

	private boolean isArray;
	private LinkedList<String> param_id;

	public Location(String i, int n){
		setId(i);
		setLineNumber(n);
		isArray = false;
	}

	public Location(String i, LinkedList<String> pi, int n){
		setId(i);
		this.param_id=pi;
		setLineNumber(n);	
		isArray = false;
	}

	// Array location
	public Location(String i, Expr e, int n){
		setId(i);
		setExpr(e);
		setLineNumber(n);	
		isArray = true;
	}

	// Array location
	public Location(String i, LinkedList<String> pi, Expr e, int n){
		setId(i);
		this.param_id=pi;
		setExpr(e);
		setLineNumber(n);
		isArray = true;	
	}

	public boolean isArray(){
		return isArray;
	}

	public boolean isObjectCall(){
		return (param_id != null);
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}

}
