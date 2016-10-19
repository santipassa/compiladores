package Compi;

import java.util.ArrayList;
import java.util.List;

//import error.Error; // define class error


// String checker, concrete visitor 
public class PrettyPrintVisitor implements ASTVisitor<String> {
	
	@Override
	public String visit(Program expr) {
		String conc = "";
		if (expr.getClasses() != null)
			for (Class_decl c :expr.getClasses())
				c.accept(this);
		return "";
	}

	@Override
	public String visit(Class_decl expr) {
		if (expr.getField_decl() != null)
			for (Field_decl c :expr.getField_decl())
				c.accept(this);

		if (expr.getMethod_decl() != null)
			for (Method_decl c :expr.getMethod_decl())
				c.accept(this);

		return "";
	}

	@Override
	public String visit(Field_decl expr) {
		for (Name c :expr.getName())
			c.accept(this);
		return "";		
	}

	@Override
	public String visit(Name expr) {
		System.out.println(expr.getId()+" var "+expr.getOffset());
		return "";
	}

	@Override
	public String visit(Method_decl expr) {
		if (expr.getParam_decl() != null)
			for (Param_decl c :expr.getParam_decl())
				c.accept(this);
		expr.getBody().accept(this);
		return "";
	}

	@Override
	public String visit(Param_decl expr) {
		System.out.println(expr.getId()+" param "+expr.getOffset());
		return "";
	}

	@Override
	public String visit(Bin_op expr) {
		return "";		
	}	

	@Override
	public String visit(Body expr) {
		if (!(expr.isExtern()))
			expr.getBlock().accept(this);
		return "";
	}

	@Override
	public String visit(Literal_boolean expr) {
		return "";
	}

	@Override
	public String visit(Literal_float expr) {
		return "";
	}

	@Override
	public String visit(Literal_integer expr) {
		return "";
	}

	@Override
	public String visit(Location expr) {
		System.out.println(expr.getId()+" loc "+expr.getOffset());
		return "";
	}

	@Override
	public String visit(Method_call_expr expr) {
		if (expr.getParam_expr()!=null)
			for (Expr e: expr.getParam_expr())
				System.out.println(e.getId()+" call "+e.getOffset());
		return "";
	}

	@Override
	public String visit(Unary_op expr) {
		return "";
	}

	@Override
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

	@Override
	public String visit(Method_call expr) {
		if (expr.getParam_expr()!=null)
			for (Expr e: expr.getParam_expr())
				System.out.println(e.getId()+" call "+e.getOffset());
		return "";
	}

	@Override
	public String visit(Statement_asig expr) {
		expr.getLocation().accept(this);
		expr.getExpr().accept(this);
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
		expr.getExpr().accept(this);
		expr.getStatement().accept(this);
		return "";
	}

	@Override
	public String visit(Statement_ifelse expr) {
		expr.getExpr().accept(this);
		expr.getStatement1().accept(this);
		expr.getStatement2().accept(this);
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

	public String visit(Asign_op expr) {
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
