package Compi;

public class Literal_integer extends Expr {
	
	private Integer literal_int;

	public Literal_integer(Integer i){
		setType(new Type("integer"));
		literal_int = i;
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}

}
