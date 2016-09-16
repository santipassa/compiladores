package Compi;

public class Body extends AST{
	Block block;
	boolean extern;
	
	public Body(Block b){
		this.block=b;
		extern = false;
	}

	public Body(int n){
		extern = true;
		setLineNumber(n);
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}

}