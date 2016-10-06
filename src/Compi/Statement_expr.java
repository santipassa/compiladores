package Compi;

public class Statement_expr extends Statement{
	private Expr expr;

	public Statement_expr(Expr e, int n){
		setExpr(e);
		setLineNumber(n);
		setId("expr");
	}

	public Expr getExpr(){
		return expr;
	}

	public void setExpr(Expr x){
		expr = x;
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}
	public String toString(){
		return expr.toString();
	}
}
