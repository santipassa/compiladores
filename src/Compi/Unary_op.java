package Compi;

public class Unary_op extends Expr {
	Expr expr;
	String operacion;

	public Unary_op(String op, Expr r, int n){
		operacion = op;
		expr = r;
		setLineNumber(n);
	}
	

}
