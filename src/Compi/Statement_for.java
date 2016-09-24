package Compi;


public class Statement_for extends Statement{

	Expr expr1;
	Expr expr2;
	Statement stat;

	public Statement_for(String i, Expr e, Expr e1, Statement s, int n){
		setId(i);
		this.expr1=e;
		this.expr2=e1;
		this.stat=s;
		setLineNumber(n);
		setId("for");
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}

	@Override
	public String toString() {
		String rtn = "for " + getId() + expr1.toString() + expr2.toString() + stat.toString();
		
		return rtn;
	}

	public Expr getExpr1(){
		return expr1;
	}

	public Expr getExpr2(){
		return expr2;
	}

	public void setExpr1(Expr x){
		expr1 = x;
	}

	public void setExpr2(Expr x){
		expr2 = x;
	}

	public Statement getStatement(){
		return stat;
	}

	public void setStatement(Statement x){
		stat = x;
	}

}
