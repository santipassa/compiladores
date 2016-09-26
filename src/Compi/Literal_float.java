package Compi;

public class Literal_float extends Expr {

	private float literal_float;

	public Literal_float(float f){
		setType(new Type("float"));
		literal_float = f;
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}

	@Override
	public String toString() {
		return "aca esta el float "+String.valueOf(literal_float);
	}

}
