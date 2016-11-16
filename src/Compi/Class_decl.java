package Compi;

import java.util.LinkedList;

class Class_decl extends AST {
	
	private LinkedList<Field_decl> field_declList;
	private LinkedList<Method_decl> method_declList;
	private int offset;

	public Class_decl(String id,LinkedList<Field_decl> f, LinkedList<Method_decl> m,int numeroLinea){
		this.field_declList=f;
		this.method_declList=m;
		setId(id);
		setLineNumber(numeroLinea);
	}

	public Class_decl(String id,int numeroLinea){
		field_declList = null;
		method_declList = null;
		setId(id);
		setLineNumber(numeroLinea);
	}

	public Class_decl(String id,LinkedList<Field_decl> f,int numeroLinea){
		this.field_declList=f;
		setId(id);
		setLineNumber(numeroLinea);
	}

	public Class_decl(String id,int numeroLinea,LinkedList<Method_decl> m){
		this.method_declList=m;
		setId(id);
		setLineNumber(numeroLinea);
	}
	
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

	public Type getAttributeType(String id){
		if (field_declList == null)
			return null;
		else
			for (Field_decl f: field_declList)
				if (f.getAttributeType(id)!=null)
					return f.getType();
		return null;
	}


	public Type getMethodType(String id){
		if (method_declList == null)
			return null;
		else
			for (Method_decl m: method_declList)
				if (m.getMethodType(id)!=null)
					return m.getType();
		return null;
	}

	public boolean getAttributeIsArray(String id){
		if (field_declList == null)
			return false;
		else
			for (Field_decl f: field_declList)
				if (f.getAttributeIsArray(id))
					return true;
		return false;
	}

	public int getOffset(String id){
		for (Field_decl f: field_declList)
			if (f.searchName(id))
				return f.getOffset(id);
		return 0;
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
		return "class "+getId()+"\n";
	}	
}