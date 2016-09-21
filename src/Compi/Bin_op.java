package Compi;

public class Bin_op extends Expr {
	Expr expr1;
	Expr expr2;
	String operacion;

	public Bin_op(Expr l, String op, Expr r, int n){
		operacion = op;
		expr1 = l;
		expr2 = r;
		setLineNumber(n);
	}
	
	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}

	public Expr getExpr1(){
		return expr1;
	}

	public Expr getExpr2(){
		return expr2;
	}
	
}
