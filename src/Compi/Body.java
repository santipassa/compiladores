package Compi;

public class Body extends AST{
	private Block block;
	private boolean extern;
	
	public Body(Block b){
		this.block=b;
		extern = false;
	}

	public Body(int n){
		extern = true;
		setLineNumber(n);
	}

	public boolean isExtern(){
		return extern;
	}

	public Block getBlock(){
		return block;
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}

}