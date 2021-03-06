package Compi;

public class Param_decl extends AST {

	private Type type;
	private int offset;

	public Param_decl(String i,Type t,int n){
		setId(i);
		this.type=t;
		setLineNumber(n);	
	}
	
	public Type getType(){
		return this.type;
	}

	public boolean equals(Param_decl x){
		return (this.getId().compareTo(x.getId())==0 && this.type.equals(x.getType()));
	}

	public void setOffset(int offset){
		this.offset = offset;
	}

	public int getOffset(){
		return this.offset;
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}

	@Override
	public String toString() {
		return "("+type.toString() +" "+ getId()+")" ;
	}
	
}