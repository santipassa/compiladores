package Compi;

public class Param_decl extends AST {

	private Type type;

	public Param_decl(String i,Type t,int n){
		setId(i);
		this.type=t;
		setLineNumber(n);	
	}
	
	public Type getType(){
		return this.type;
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