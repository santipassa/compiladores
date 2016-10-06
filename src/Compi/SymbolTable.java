package Compi;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class SymbolTable {

	private String id;
	private boolean isArray;
	private boolean isMethod;
	private Type type;
	private AST ast;

	public SymbolTable(String id, AST ast){
		this.id = id;
		this.isMethod = false;
		this.isArray = false;
		this.ast = ast;
	}	

	public SymbolTable(String id, Type type, AST ast){
		this.id = id;
		this.type = type;
		this.isMethod = false;
		this.isArray = false;
		this.ast = ast;
	}	

	public SymbolTable(String id, boolean isMethod, AST ast){
		this.id = id;
		this.isArray = false;
		this.isMethod = isMethod;
		this.ast = ast;
	}	

	public SymbolTable(String id, Type type, boolean isArray, AST ast){
		this.id = id;
		this.type = type;
		this.isMethod = false;
		this.isArray = isArray;
		this.ast = ast;
	}

	public String getId(){
		return id;
	}

	public boolean isArray(){
		return isArray;
	}

	public boolean isMethod(){
		return isMethod;
	}

	public AST getAst(){
		return ast;
	}

	public Type getType(){
		return type;
	}

	public boolean equals(SymbolTable x){
		if (this.isMethod && x.isMethod)
			return (this.id.compareTo(x.id)==0);
		if (this.isArray && x.isArray)
			return (this.id.compareTo(x.id)==0);

		return (this.id.compareTo(x.id)==0);
	}

}

	//public Boolean getMethod(){
	//	return this.isMethod;
	//} 

	//public void setMethod(Boolean b){
	//	this.isMethod=b;
	//}

