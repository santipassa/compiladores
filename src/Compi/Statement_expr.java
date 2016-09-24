package Compi;

// return expr
public class Statement_expr extends Statement{

	Expr expr;

	public Statement_expr(Expr e, int n){
		setExpr(e);
		setLineNumber(n);
		setId("expr");
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}

	public Expr getExpr(){
		return expr;
	}

	public void setExpr(Expr x){
		expr = x;
	}


}
