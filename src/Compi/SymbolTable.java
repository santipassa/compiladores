package Compi;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class SymbolTable {

	private String id;
	private String type;
	private boolean isMethod;
	private LinkedList<Field_decl> field_declList;
	private LinkedList<Method_decl> method_declList;

	// classes
	public SymbolTable(String id, LinkedList<Field_decl> field_declList, LinkedList<Method_decl> method_declList){
		this.id = id;
		this.isMethod = false;
		this.field_declList = field_declList;
		this.method_declList = method_declList;
	}	

	// methods
	public SymbolTable(String id, String type, boolean isMethod){
		this.id = id;
		this.type = type;
		this.isMethod = isMethod;
	}	

	// declarations
	public SymbolTable(String id, String type){
		this.id = id;
		this.type = type;
		this.isMethod = false;
	}

	public String getId(){
		return id;
	}

	public String getTypeString(){
		return type;
	}	

	public boolean equals(SymbolTable x){
		return (this.id == x.id && this.type == x.type && this.isMethod == x.isMethod);
	}
}

	//public Boolean getMethod(){
	//	return this.isMethod;
	//} 

	//public void setMethod(Boolean b){
	//	this.isMethod=b;
	//}

