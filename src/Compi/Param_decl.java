package Compi;

public class Param_decl extends AST {
	private String id;
	private Type type;

	public Param_decl(String i,Type t,int n){
		this.id=i;
		this.type=t;
		setLineNumber(n);	
	}
	
	public String getId(){
		return this.id;
	}
	
	public Type getType(){
		return this.type;
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}
	
}