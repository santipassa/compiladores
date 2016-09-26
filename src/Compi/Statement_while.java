package Compi;

public class Statement_while extends Statement{
	private Expr expr;
	private Statement stat;

	public Statement_while(Expr e, Statement s,int n){
		this.expr= e;
		setLineNumber(n);
		this.stat=s;
		setId("while");
	}

	public Expr getExpr(){
		return expr;
	}

	public void setExpr(Expr x){
		expr = x;
	}

	public Statement getStatement(){
		return stat;
	}

	public void setStatement(Statement x){
		stat = x;
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}
	
}