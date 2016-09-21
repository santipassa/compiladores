package Compi;


public class Statement_expr extends Statement{

	Expr expr;

	public Statement_expr(Expr e, int n){
		this.expr=e;
		setLineNumber(n);

	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}


}
