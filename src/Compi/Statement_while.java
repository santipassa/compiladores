package Compi;


public class Statement_while extends Statement{

	Expr expr;
	Statement stat;

	public Statement_while(Expr e, Statement s,int n){
		this.expr= e;
		setLineNumber(n);
		this.stat=s;

	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}

}