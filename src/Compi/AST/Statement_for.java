public class Statement_for extends Statement{

	String id;
	Expr expr;
	Expr expr2;
	Statement stat;
	int numeroLinea;

	public Statement_for(String i, Expr e, Expr e1, Statement s, int n){
		this.id=i;
		this.expr=e;
		this.expr2=e1;
		this.stat=s;
		this.numeroLinea=n;
	}



}
