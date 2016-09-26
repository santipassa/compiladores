package Compi;

public class Statement_ifelse extends Statement{
	private Expr expr;
	private Statement stat1;
	private Statement stat2;
	
	public Statement_ifelse(Expr e, Statement s, Statement se, int n){
		this.expr= e;
		setLineNumber(n);
		this.stat1=s;
		this.stat2=se;
		setId("ifelse");
	}

	public Expr getExpr(){
		return expr;
	}

	public void setExpr(Expr x){
		expr = x;
	}

	public Statement getStatement1(){
		return stat1;
	}

	public void setStatement1(Statement x){
		stat1 = x;
	}

	public Statement getStatement2(){
		return stat2;
	}

	public void setStatement2(Statement x){
		stat2 = x;
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}

}
