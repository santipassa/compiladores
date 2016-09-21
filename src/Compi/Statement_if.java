package Compi;


public class Statement_if extends Statement{

	Expr expr;
	Statement stat;

	public Statement_if(Expr e, Statement s,int n){
		this.expr= e;
		setLineNumber(n);
		this.stat=s;

	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}

	@Override
	public String toString() {
		String rtn = "if " + expr.toString() + '\n' + stat.toString();
		
		return rtn;
	}

}
