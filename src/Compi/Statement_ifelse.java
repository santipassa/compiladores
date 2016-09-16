package Compi;


public class Statement_ifelse extends Statement{

	Expr expr;
	int numeroLinea;
	Statement stat;
	Statement stat1;
	
	public Statement_ifelse(Expr e, Statement s, Statement se, int n){
		this.expr= e;
		this.numeroLinea=n;
		this.stat=s;
		this.stat1=se;

	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}


}
