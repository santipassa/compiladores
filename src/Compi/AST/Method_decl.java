
public class Method_decl{
	Type type;
	String id;
	int numeroLinea;
	Body body;
	java.util.LinkedList<Param_decl> param_declList;
	public Method_decl(Type t,String id,Body b,int n){
		this.type=t;
		this.id=id;
		this.body=b;
		this.numeroLinea=n;
	}
	public Method_decl(Type t,String id,java.util.LinkedList<Param_decl> p,Body b,int n){
		this.type=t;
		this.id=id;
		this.body=b;
		this.numeroLinea=n;
		this.param_decl=p;

	}	
}