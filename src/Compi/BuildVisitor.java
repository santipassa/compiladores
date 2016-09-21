package Compi;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

//import error.Error; // define class error


// String checker, concrete visitor 
public class BuildVisitor implements ASTVisitor<String> {
	LinkedList<TableLevel> pila;
	//llama al buscar de table level desde el tope hacia abajo
	public BuildVisitor(){
		pila = new LinkedList<TableLevel>();
	}

	public void push(TableLevel x){
		pila.add(x);
	}

	public void pop(){
		pila.removeLast();
	}

	@Override
	public String visit(Program expr) {
		TableLevel x = new TableLevel();
		if (expr.getClasses() != null)
			for (Class_decl c :expr.getClasses()){
				x.setSymbol(new SymbolTable(c));
				c.accept(this);
			}
		this.push(x);
		return "";
	}

	@Override
	public String visit(Class_decl expr) {
		TableLevel x = new TableLevel();
		this.push(x);
		if (expr.getField_decl() != null)
			for (Field_decl c :expr.getField_decl()){
				x.setSymbol(new SymbolTable(c));
				c.accept(this);
			}
		if (expr.getMethod_decl() != null)
			for (Method_decl c :expr.getMethod_decl()){
				x.setSymbol(new SymbolTable(c));
				c.accept(this);
			}
		
		return "";
	}

	@Override
	public String visit(Field_decl expr) {
		TableLevel x = new TableLevel();
		if (expr.getName() != null)
			for (Name c :expr.getName()){
				x.setSymbol(new SymbolTable(c));
				//no va c.accept(this);
			}
		//insertar atributo en el tope de la pila
			//pila.gettope.setsymbol
		return "";		
	}

	@Override
	public String visit(Name expr) {
		return " ";
	}

	@Override
	public String visit(Method_decl expr) {
		TableLevel x = new TableLevel();
		if (expr.getParam_decl() != null)
			for (Param_decl c : expr.getParam_decl()){
				x.setSymbol(new SymbolTable(c));
				c.accept(this);
			}
		this.push(x); //igual que el field_decl
		return "";
	}

	@Override
	public String visit(Body expr) {
		if (!(expr.isExtern())){
			TableLevel x = new TableLevel();
			x.setSymbol(new SymbolTable(expr.getBlock()));
			this.push(x); 
			expr.getBlock().accept(this);
		}
		
		return "" ;
	}

	@Override
	public String visit(Block expr) {
		TableLevel x = new TableLevel();
		this.push(x);
		if (expr.getField_decl() != null)
			for (Field_decl c :expr.getField_decl()){
				x.setSymbol(new SymbolTable(c));
				c.accept(this);
			}
		if (expr.getStatement() != null)
			for (Statement c :expr.getStatement()){
				x.setSymbol(new SymbolTable(c));
				c.accept(this);
			}
		
		return "";
	}

	@Override
	public String visit(Bin_op expr) {
		expr.accept(this);		//hago get de las dos expresiones y acept de cada una
	}	

	

	@Override
	public String visit(Param_decl expr) {
		return "";
	}

	@Override
	public String visit(Literal_boolean expr) {
		return expr.accept(this);
	}

	@Override
	public String visit(Literal_float expr) {
		return expr.accept(this);
	}

	@Override
	public String visit(Literal_integer expr) {
		return expr.accept(this);
	}

	@Override
	public String visit(Location expr) {
		return expr.accept(this); //llamo al buscar 
	}

	@Override
	public String visit(Method_call_expr expr) {
		return expr.accept(this); //obtengo el nombre del metodo y llamo al buscar de esta q llama a table
	}

	@Override
	public String visit(Unary_op expr) {
		return expr.accept(this);
	}


	@Override
	public String visit(Method_call expr) {
		return expr.accept(this);
	}

	@Override
	public String visit(Statement_asig expr) {
		return "";
	}

	@Override
	public String visit(Statement_break expr) {
		return "";
	}

	@Override
	public String visit(Statement_continue expr) {
		return "";
	}

	@Override
	public String visit(Statement_expr expr) {
		return "";
	}

	@Override
	public String visit(Statement_for expr) {
		return "";
	}

	@Override
	public String visit(Statement_if expr) {
		return "";
	}

	@Override
	public String visit(Statement_ifelse expr) {
		return "";
	}

	@Override
	public String visit(Statement_semicolon expr) {
		return "";
	}

	@Override
	public String visit(Statement_void expr) {
		return "";
	}

	@Override
	public String visit(Statement_while expr) {
		return "";
	}
		/*private List<Error> errors;

	private void addError(AST a, String desc) {
		errors.add(new Error(a.getLineNumber(), a.getColumnNumber(), desc));
	}

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}*/


}