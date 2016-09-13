import java.util.LinkedList;
public class Location extends Expr{

	String id;
	LinkedList<String> param_id;
	Expr expr;
	int numeroLinea;

	public Location(String i, int n){
		this.id=i;
		this.numeroLinea=n;

	}
	public Location(String i, LinkedList<String> pi, int n){
		this.id=i;
		this.param_id=pi;
		this.numeroLinea=n;
	}
	public Location(String i, Expr e, int n){
		this.id=i;
		this.expr=e;
		this.numeroLinea=n;
	}
	public Location(String i, LinkedList<String> pi, Expr e, int n){
		this.id=i;
		this.param_id=pi;
		this.expr=e;
		this.numeroLinea=n;

	}
}
