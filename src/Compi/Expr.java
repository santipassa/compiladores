package Compi;

public abstract class Expr extends AST {
	private Expr expr;
	private Type type;
	private int offset;
	
	public Expr getExpr(){
		return expr;
	}

	public void setExpr(Expr x){
		expr = x;
	}

	public Type getType(){
		return type;
	}

	public void setType(Type x){
		type = x;
	}

	public void setOffset(int offset){
		this.offset = offset;
	}

	public int getOffset(){
		return this.offset;
	}

}
