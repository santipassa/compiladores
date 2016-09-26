package Compi;

public class Unary_op extends Expr {
	private Expr expr;
	private String operacion;

	public Unary_op(String op, Expr r, int n){
		operacion = op;
		expr = r;
		setLineNumber(n);
	}
	
	public String getOperacion(){
		return operacion;
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}

}
