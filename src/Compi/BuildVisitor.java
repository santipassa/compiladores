package Compi;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

// String checker, concrete visitor 
public class BuildVisitor implements ASTVisitor<String> {

	private LinkedList<TableLevel> stack;
	private LinkedList<ErrorCompi> errors;

	public BuildVisitor(){
		stack = new LinkedList<TableLevel>();
		errors = new LinkedList<ErrorCompi>();
	}

	private void printLevel(int i){
		for (SymbolTable s: stack.get(i).getList())
			System.out.println(s.getId());
	}

	private void createLevel(TableLevel x){
		stack.add(x);
	}

	private void closeLevel(){
		stack.removeLast();
	}

	// Busca el location, si lo encuentra copia info del tipo
	private boolean searchSymbol(Expr x){	
		return (stack.get(2).searchSymbol(x) || stack.get(1).searchSymbol(x));
	}

	private boolean searchMethodExprSymbol(Method_call_expr x){	
		return (stack.get(1).searchMethodExprSymbol(x));
	}

	private boolean searchMethodSymbol(Method_call x){	
		return (stack.get(1).searchMethodSymbol(x));
	}

	// Busca la clase, si la encuentra copia info del tipo
	private boolean searchClass(String x){
		return (stack.get(0).searchClass(x));
	}

	// Busca el atributo en la clase, si la encuentra copia info del tipo, y si es arreglo la expr
	private boolean searchAtrInClass(Expr x){
		return (stack.get(0).searchAtrClass(x));
	}

	private void addError(AST a, String desc) {
		errors.add(new ErrorCompi(a.getLineNumber(), a.getId()+" "+desc));
	}

	public LinkedList<ErrorCompi> getErrors() {
		return errors;
	}

	// 1° level
	public String visit(Program expr) {
		TableLevel x = new TableLevel();
		this.createLevel(x);
		if (expr.getClasses() != null)
			for (Class_decl c :expr.getClasses()){
				x.setSymbol(new SymbolTable(c.getId(), c.getField_decl(), c.getMethod_decl()));
				c.accept(this);
			}
		return "";
	}

	// 2° level
	public String visit(Class_decl expr) {
		TableLevel x = new TableLevel();
		this.createLevel(x);
		if (expr.getField_decl() != null)
			for (Field_decl c :expr.getField_decl()){
				if (c.getType().isObject() || c.getType().toString()=="void")
					this.addError(c, "Invalid type");
				c.accept(this);
			}
		if (expr.getMethod_decl() != null)
			for (Method_decl c :expr.getMethod_decl()){
				c.accept(this);
			}
		this.closeLevel();
		return "";
	}// los atributos deben ser de tipos basicos. solo se puede hacer x.Atr/met

	public String visit(Field_decl expr) {
		SymbolTable aux;
		if (expr.getName() != null)
			for (Name c :expr.getName()){
				if (c.isArray())
					aux = new SymbolTable(c.getId(), true, expr.getType().toString());
				else	
					aux = new SymbolTable(c.getId(), expr.getType().toString());
				if (stack.getLast().search(aux))	// Repeated checking
					this.addError(c, "Redefined");
				stack.getLast().setSymbol(aux);
			}
		return "";		
	}

	public String visit(Name expr) {
		return "";
	}

	public String visit(Method_decl expr) {
		SymbolTable aux = new SymbolTable(expr.getId(), expr.getType().toString(), true);
		if (stack.getLast().search(aux))	// Repeated checking
			this.addError(expr, "Redefined");
		stack.getLast().setSymbol(aux);
	// 3° level
		TableLevel x = new TableLevel();
		this.createLevel(x);
		if (expr.getParam_decl() != null)
			for (Param_decl c : expr.getParam_decl())
				c.accept(this);
		expr.getBody().accept(this);
		this.closeLevel();
		return "";
	}

	public String visit(Param_decl expr) {
		if (expr.getType().isObject())
			if (!this.searchClass(expr.getType().toString())) 
				this.addError(expr, " Undefined type");	
		stack.getLast().setSymbol(new SymbolTable(expr.getId(), expr.getType().toString()));
		return "";		
	}

	public String visit(Body expr) {
		if (!(expr.isExtern()))
			expr.getBlock().accept(this);
		return "";
	}

	public String visit(Block expr) {
		if (expr.getField_decl() != null)
			for (Field_decl c :expr.getField_decl()){
				c.accept(this);
			}
		if (expr.getStatement() != null)
			for (Statement c :expr.getStatement()){
				c.accept(this);
			}
		return "";
	}

	public String visit(Statement_asig expr) {
		expr.getLocation().accept(this);
		expr.getExpr().accept(this);
		return "";
	}

	public String visit(Location expr) {
		if (!this.searchSymbol(expr))
			this.addError(expr, "Undefined");
		else{
			if (expr.isObjectCall())	// x.color;
				if (!expr.getType().isObject())	// int x;	
					this.addError(expr, "It is not an object");
				else{
					if (!this.searchClass(expr.getType().toString())) 
						this.addError(expr, " Undefined type");	 
					if (!this.searchAtrInClass(expr)) // object.param, si no existe el param
						this.addError(expr, "."+expr.getParamId()+" Undefined");
				}
			if (expr.isArray())
				expr.getExpr().accept(this);
		}
		return ""; 
	}

	public String visit(Asign_op expr) {
		return "";
	}

	public String visit(Method_call_expr expr) {
		if (!this.searchMethodExprSymbol(expr))
			this.addError(expr, " Undefined");
		return ""; 
	}

	public String visit(Unary_op expr) {
		expr.getExpr().accept(this);
		return "";
	}

	public String visit(Bin_op expr) {
		expr.getExpr1().accept(this);		
		expr.getExpr2().accept(this);
		return "";
	}	

	public String visit(Method_call expr) {
		if (!this.searchMethodSymbol(expr))
			this.addError(expr, " Undefined");
		return ""; 
	}

	public String visit(Statement_break expr) {
		return "";
	}

	public String visit(Statement_continue expr) {
		return "";
	}

	public String visit(Statement_expr expr) {
		expr.getExpr().accept(this);
		return "";
	}

	public String visit(Statement_for expr) {
		expr.getExpr1().accept(this);
		expr.getExpr2().accept(this);
		expr.getStatement().accept(this);
		return "";
	}

	public String visit(Statement_if expr) {
		expr.getExpr().accept(this);
		expr.getStatement().accept(this);
		return "";
	}

	public String visit(Statement_ifelse expr) {
		expr.getExpr().accept(this);
		expr.getStatement1().accept(this);
		expr.getStatement2().accept(this);
		return "";
	}

	public String visit(Statement_semicolon expr) {
		return "";
	}

	public String visit(Statement_void expr) {
		return "";
	}

	public String visit(Statement_while expr) {
		expr.getExpr().accept(this);
		expr.getStatement().accept(this);
		return "";
	}

	public String visit(Literal_boolean expr) {
		return "";
	}

	public String visit(Literal_float expr) {
		return "";
	}

	public String visit(Literal_integer expr) {
		return "";
	}

}