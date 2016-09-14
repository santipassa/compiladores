package Compi;

public abstract class Expr extends AST {
	Expr expr;
	protected Type type;
	
	public Type getType() {
		return this.type;
	}
	
	public void setType(Type t) {
		this.type = t;
	}
}
