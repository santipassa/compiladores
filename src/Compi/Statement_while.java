package Compi;


public class Statement_while extends Statement{

	Expr expr;
	int numeroLinea;
	Statement stat;

	public Statement_while(Expr e, Statement s,int n){
		this.expr= e;
		this.numeroLinea=n;
		this.stat=s;

	}



}