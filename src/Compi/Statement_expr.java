package Compi;


public class Statement_expr extends Statement{

	Expr expr;
	int numeroLinea;

	public Statement_expr(Expr e, int n){
		this.expr=e;
		this.numeroLinea=n;

	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}


}
