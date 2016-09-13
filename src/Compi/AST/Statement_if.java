public class Statement_if extends Statement{

	Expr expr;
	int numeroLinea;
	Statement stat;

	public Statement_if(Expr e, Statement s,int n){
		this.expr= e;
		this.numeroLinea=n;
		this.stat=s;

	}



}
