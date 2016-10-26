package Compi;

public class Method_decl extends AST {	
	private Type type;
	private Body body;
	private java.util.LinkedList<Param_decl> param_declList;
	private int offset;

	public Method_decl(Type t,String id,Body b,int n){
		this.type=t;
		setId(id);
		this.body=b;
		setLineNumber(n);
	}
	
	public Method_decl(Type t,String id,java.util.LinkedList<Param_decl> p,Body b,int n){
		this.type=t;
		setId(id);
		this.body=b;
		this.param_declList=p;
		setLineNumber(n);
	}	

	public java.util.LinkedList<Param_decl> getParam_decl(){
		return param_declList;
	}
	
	public Body getBody(){
		return body;
	}

	public Type getType(){
		return type;
	}

	public Type getMethodType(String id){
		if (this.getId().compareTo(id)==0)
			return type;
		return null;
	}

	public void setOffset(int offset){
		this.offset = offset;
	}

	public int getOffset(){
		return this.offset;
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}

	@Override
	public String toString() {
		return "\n"+type.toString() +" "+ getId();
	}

}