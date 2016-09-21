package Compi;

public class Name extends AST {

	int int_literal;
	Boolean esArreglo;
	
	public Name(String i,int n){
		setId(i);
		this.esArreglo=false;
		setLineNumber(n);	
	}

	public Name(String i,int il,int n){
		setId(i);
		this.int_literal=il;
		this.esArreglo=true;
		setLineNumber(n);	
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}

	@Override
	public String toString() {
		if (esArreglo) 
			return getId()+"["+int_literal+"]";
		else
			return getId();
	}

}
