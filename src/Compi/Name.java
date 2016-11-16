package Compi;

public class Name extends AST {

	private int int_literal;
	private boolean isArray;
	private int offset;
	private boolean isAttribute;
	
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

	public int getIntLiteral(){
		return int_literal;
	}

	public boolean equals(String x){
		return (this.getId().compareTo(x)==0);
	}

	public void setOffset(int offset){
		this.offset = offset;
	}

	public int getOffset(){
		return this.offset;
	}

	public void setIsAttribute(boolean isAttribute){
		this.isAttribute = isAttribute;
	}

	public boolean isAttribute(){
		return this.isAttribute;
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
