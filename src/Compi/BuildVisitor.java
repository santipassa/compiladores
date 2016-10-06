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

	private void createLevel(TableLevel x){
		stack.add(x);
	}

	private void closeLevel(){
		stack.removeLast();
	}

	// Busca la clase, y lo retorna
	private SymbolTable searchClass(String x){
		return (stack.get(0).searchClass(x));
	}

	// Busca el location, y lo retorna
	// Se busca en los niveles en el orden de la pila
	private SymbolTable searchSymbol(String x){
		SymbolTable sym;
		for (int i=stack.size()-1; i>0; i--){
			sym = stack.get(i).searchSymbol(x);
			if (sym!=null)
				return sym; 	
		}
		return null;
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
				x.setSymbol(new SymbolTable(c.getId(), c));
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
	}

	public String visit(Field_decl expr) {
		SymbolTable aux;
		if (expr.getName() != null)
			for (Name c :expr.getName()){
				if (c.isArray())
					aux = new SymbolTable(c.getId(), expr.getType(), true, c);
				else	
					aux = new SymbolTable(c.getId(), expr.getType(), c);
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
		SymbolTable aux = new SymbolTable(expr.getId(), true, expr);
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
			if (this.searchClass(expr.getType().toString())==null) 
				this.addError(expr, " Undefined type");	
		stack.getLast().setSymbol(new SymbolTable(expr.getId(), expr.getType(), expr));
		return "";		
	}

	public String visit(Body expr) {
		if (!(expr.isExtern()))
			expr.getBlock().accept(this);
		return "";
	}

	// create one level for each block
	public String visit(Block expr) {
		TableLevel x = new TableLevel();
		this.createLevel(x);
		if (expr.getField_decl() != null)
			for (Field_decl c :expr.getField_decl()){
				c.accept(this);
			}
		if (expr.getStatement() != null)
			for (Statement c :expr.getStatement()){
				c.accept(this);
			}
		this.closeLevel();
		return "";
	}

	public String visit(Statement_asig expr) {
		expr.getLocation().accept(this);
		expr.getExpr().accept(this);
		return "";
	}

	public String visit(Location expr) {
		SymbolTable symbol = this.searchSymbol(expr.getId()); 
		if (symbol==null)
			this.addError(expr, "Undefined");
		else{
			if (expr.isObjectCall())	// Si es una llamada a un objeto
				if (!expr.getType().isObject())	// Si el tipo de la var no es una clase
					this.addError(expr, "It is not an object");
				else{
					SymbolTable sym = this.searchClass(expr.getType().toString());
					if (sym==null) // Si no existe la clase
						this.addError(expr, " Undefined type");
					else{
						Class_decl class_decl = (Class_decl) sym.getAst();
						Type attType = class_decl.getAttributeType(expr.getId_param());
						if (attType==null) // Si el atributo no existe
							this.addError(expr, "."+expr.getId_param()+" Undefined");
						else{
							boolean attIsArray = class_decl.getAttributeIsArray(expr.getId_param());
							if (attIsArray && symbol.isArray()){
								expr.setType(attType);
								expr.getExpr().accept(this);
							}
							else
								if (!attIsArray && !symbol.isArray())
									expr.setType(attType);
								else
									this.addError(expr, "."+expr.getId_param()+" not array");
						}							
					}
				}
			else
				if (symbol.isArray()){
					expr.setType(symbol.getType()); 	
					expr.getExpr().accept(this);
				}
				else
					expr.setType(symbol.getType());
		}
		return ""; 
	}

	public String visit(Asign_op expr) {
		return "";
	}

	public String visit(Method_call_expr expr) {
		SymbolTable symbol; 
		if (expr.isObjectCall()){	// Si es una llamada a un objeto
			symbol = this.searchSymbol(expr.getId()); // busca en atributos tambien??
			if (symbol==null)
				this.addError(expr, "Undefined");
			else{
				SymbolTable sym = this.searchClass(symbol.getType().toString());
				if (sym==null) // Si no existe la clase
					this.addError(expr, " Undefined type");
				else{
					Class_decl class_decl = (Class_decl) sym.getAst();
					Type methodType = class_decl.getMethodType(expr.getId_param());
					if (methodType==null) // Si el metodo no existe
						this.addError(expr, "."+expr.getId_param()+" Undefined");
					else
						expr.setType(methodType);						
				}
			}
		}	
		else{
			System.out.println("IS VAR LOCATION    "+expr.getId());
			symbol = this.searchSymbol(expr.getId());
			expr.setType(symbol.getType());
		}
		
		if (expr.getParam_expr()!=null)
			for (Expr e: expr.getParam_expr())
				e.accept(this);
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
		SymbolTable symbol; 
		if (expr.isObjectCall()){	// Si es una llamada a un objeto
			symbol = this.searchSymbol(expr.getId()); // busca en atributos tambien??
			if (symbol==null)
				this.addError(expr, "Undefined");
			else{
				SymbolTable sym = this.searchClass(symbol.getType().toString());
				if (sym==null) // Si no existe la clase
					this.addError(expr, " Undefined type");
				else{
					Class_decl class_decl = (Class_decl) sym.getAst();
					Type methodType = class_decl.getMethodType(expr.getId_param());
					if (methodType==null) // Si el metodo no existe
						this.addError(expr, "."+expr.getId_param()+" Undefined");
					else
						expr.setClase(methodType.toString());						
				}
			}
		}	
		else{

			System.out.println("IS VAR LOCATION    "+expr.getId());
			symbol = this.searchSymbol(expr.getId());
			expr.setClase(symbol.getType().toString());
		}
		
		if (expr.getParam_expr()!=null)
			for (Expr e: expr.getParam_expr())
				e.accept(this);
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