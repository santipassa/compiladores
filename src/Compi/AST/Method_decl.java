import java.util.LinkedList;
public class Method_decl{
	Type type;
	String id;
	int numeroLinea;
	Body body;
	Param_decl param_decl;
	public Method_decl(Type t,String id,Body b,int n){
		this.type=t;
		this.id=id;
		this.body=b;
		this.numeroLinea=n;
		this.param_decl=null;

	}
	public Method_decl(Type t,String id,Param_decl p,Body b,int n){
		this.type=t;
		this.id=id;
		this.body=b;
		this.numeroLinea=n;
		this.param_decl=p;

	}	
}