package Compi;

import java.util.LinkedList;

public class Location extends Expr {

	private boolean isArray;
	private String id_param; // object.id_param

	public Location(String i, int n){
		setId(i);
		setLineNumber(n);
		isArray = false;
	}

	public Location(String i, String pi, int n){
		setId(i);
		this.id_param=pi;
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
	public Location(String i, String pi, Expr e, int n){
		setId(i);
		this.id_param=pi;
		setExpr(e);
		setLineNumber(n);
		isArray = true;	
	}

	public boolean isArray(){
		return isArray;
	}

	public void setIsArray(boolean x){
		isArray = x;
	}

	public boolean isObjectCall(){
		return (id_param != null);
	}

	public String getId_param(){
		return id_param;
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}

}
