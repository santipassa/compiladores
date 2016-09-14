package Compi;

public class Method_decl extends AST {	
	Type type;
	String id;
	Body body;
	java.util.LinkedList<Param_decl> param_declList;

	public Method_decl(Type t,String id,Body b,int n){
		this.type=t;
		this.id=id;
		this.body=b;
		setLineNumber(n);
	}
	
	public Method_decl(Type t,String id,java.util.LinkedList<Param_decl> p,Body b,int n){
		this.type=t;
		this.id=id;
		this.body=b;
		this.param_declList=p;
		setLineNumber(n);
	}	
}