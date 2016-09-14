package Compi;

import java.util.LinkedList;

public class Field_decl extends AST {
	Type type;
	LinkedList<Name> list_names;

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

}