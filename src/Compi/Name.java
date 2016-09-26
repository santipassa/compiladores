package Compi;

public class Name extends AST {

	private int int_literal;
	private boolean isArray;
	
	public Name(String i,int n){
		setId(i);
		this.isArray=false;
		setLineNumber(n);	
	}

	// array
	public Name(String i,int il,int n){
		setId(i);
		this.int_literal=il;
		this.isArray=true;
		setLineNumber(n);	
	}

	public boolean isArray(){
		return isArray;
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}

	@Override
	public String toString() {
		if (isArray) 
			return getId()+"["+int_literal+"]";
		else
			return getId();
	}

}
