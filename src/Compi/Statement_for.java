package Compi;


public class Statement_for extends Statement{

	Expr expr;
	Expr expr2;
	Statement stat;

	public Statement_for(String i, Expr e, Expr e1, Statement s, int n){
		setId(i);
		this.expr=e;
		this.expr2=e1;
		this.stat=s;
		setLineNumber(n);
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}

	@Override
	public String toString() {
		String rtn = "for " + getId() + expr.toString() + expr2.toString() + stat.toString();
		
		return rtn;
	}

}
