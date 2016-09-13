import java.util.LinkedList;
public class Method_call extends Statement{

	String id;
	LinkedList<Expr> param_expr;
	LinkedList<String> param_id; 
	int numeroLinea;
	public Method_call(String i, LinkedList<Expr> pe, LinkedList<String> pi, int n){
		this.id=i;
		this.param_expr=pe;
		this.param_id=pi;
		this.numeroLinea=n;

	}
	public Method_call(String i, int n){
		this.id=i;
		this.numeroLinea=n;
	}
	public Method_call(String i, LinkedList<String> pi, int n){
		this.id=i;
		this.param_id=pi;
		this.numeroLinea=n;

	}
	public Method_call(String i, LinkedList<Expr> pe, int n){
		this.id=i;
		this.param_expr=pe;
		this.numeroLinea=n;

	}



}
