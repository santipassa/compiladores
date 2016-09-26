package Compi;

public class Literal_boolean extends Expr {
	
	private boolean literal_bool;

	public Literal_boolean(boolean b){
		setType(new Type("boolean"));
		literal_bool = b;
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}

}
