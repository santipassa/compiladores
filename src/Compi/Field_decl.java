package Compi;

import java.util.LinkedList;

public class Field_decl extends AST {
	private Type type;
	private LinkedList<Name> list_names;

	public Field_decl(Type t,LinkedList<Name> l, int numeroLinea){
		this.type=t;
		list_names = l; 
		setLineNumber(numeroLinea);
	}

	public Type getType(){
		return this.type;
	}

	public void setType(Type t){
		this.type=t;
	}

	public LinkedList<Name> getName(){
		return list_names;
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}

	@Override
	public String toString() {
		return type.toString() +" ";
	}
	
}