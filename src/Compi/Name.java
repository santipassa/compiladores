package Compi;

public class Name extends AST {
	String id;
	int int_literal;
	Boolean esArreglo;
	
	public Name(String i,int n){
		this.id=i;
		this.esArreglo=false;
		setLineNumber(n);	
	}

	public Name(String i,int il,int n){
		this.id=i;
		this.int_literal=il;
		this.esArreglo=true;
		setLineNumber(n);	
	}
}