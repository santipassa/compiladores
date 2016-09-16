package Compi;

import java.util.LinkedList;

class Class_decl extends AST {
	
	private String id;
	private LinkedList<Field_decl> field_declList;
	private LinkedList<Method_decl> method_declList;

	// CONSTRUCTORES
	public Class_decl(String id,LinkedList<Field_decl> f, LinkedList<Method_decl> m,int numeroLinea){
		this.field_declList=f;
		this.method_declList=m;
		this.id=id;
		setLineNumber(numeroLinea);
	}
	public Class_decl(String id,int numeroLinea){
		field_declList = null;
		method_declList = null;
		this.id=id;
		setLineNumber(numeroLinea);
	}
	public Class_decl(String id,LinkedList<Field_decl> f,int numeroLinea){
		this.field_declList=f;
		this.id=id;
		setLineNumber(numeroLinea);
	}
	public Class_decl(String id,int numeroLinea,LinkedList<Method_decl> m){
		this.method_declList=m;
		this.id=id;
		setLineNumber(numeroLinea);
	}
	/////////////////////////////
	public String getId(){
		return this.id;
	}
	public void setId(String id){
		this.id=id;
	}
	//////////////////////////////
	public void addMethod_decl(Method_decl m){
		method_declList.add(m);
	}
	public void addField_decl(Field_decl f){
		field_declList.add(f);
	}

	public LinkedList<Field_decl> getField_decl(){
		return field_declList;
	}

	public LinkedList<Method_decl> getMethod_decl(){
		return method_declList;
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}

	@Override
	public String toString() {
		return "class "+getId()+"\n";
	}
	
}