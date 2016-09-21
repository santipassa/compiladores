package Compi;

public class SymbolTable{

	AST ast;
	String obj;

	public SymbolTable(Program a){
		ast = a;
		obj = "Program";
	}


	public SymbolTable(Class_decl a){
		ast = a;
		obj = "Class";
	}	

	public SymbolTable(Field_decl a){
		ast = a;
		obj = "Field_decl";
	}	

	public SymbolTable(Method_decl a){
		ast = a;
		obj = "Method_decl";
	}	

	public SymbolTable(Name a){
		ast = a;
		obj = "Name";
	}	

	public SymbolTable(Body a){
		ast = a;
		obj = "Body";
	}	

	public SymbolTable(Block a){
		ast = a;
		obj = "Block";
	}	

	public SymbolTable(Statement a){
		ast = a;
		obj = "Statement";
	}	

	public SymbolTable(Param_decl a){
		ast = a;
		obj = "Param_decl";
	}	





	//public Boolean getMethod(){
	//	return this.isMethod;
	//} 

	//public void setMethod(Boolean b){
	//	this.isMethod=b;
	//}




}
