package Compi;

import java.util.ArrayList;
import java.util.List;

//import error.Error; // define class error


// String checker, concrete visitor 
public class PrettyPrintVisitor implements ASTVisitor<String> {
	
	@Override
	public String visit(Program expr) {
		String conc;
		conc = " -------------\n";
		if (expr.getClasses() != null)
			for (Class_decl c :expr.getClasses())
				conc = c.accept(this)+conc;

		return conc;
	}

	@Override
	public String visit(Class_decl expr) {
		String conc;
		conc = expr.toString();

		if (expr.getField_decl() != null)
			for (Field_decl c :expr.getField_decl())
				conc = conc+c.accept(this);

		if (expr.getMethod_decl() != null)
			for (Method_decl c :expr.getMethod_decl())
				conc = conc+c.accept(this);

		return conc;
	}

	@Override
	public String visit(Field_decl expr) {
		String conc;
		conc = expr.toString();

		for (Name c :expr.getName())
			conc = conc + c.accept(this);

		return conc+"\n";		
	}

	@Override
	public String visit(Name expr) {
		return expr.toString();
	}

	@Override
	public String visit(Method_decl expr) {
		return expr.toString();
	}

	@Override
	public String visit(Bin_op expr) {
		return expr.accept(this);		
	}	

	@Override
	public String visit(Body expr) {
		return expr.accept(this);
	}

	@Override
	public String visit(Param_decl expr) {
		return expr.accept(this);
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
		return expr.accept(this);
	}

	@Override
	public String visit(Method_call_expr expr) {
		return expr.accept(this);
	}

	@Override
	public String visit(Unary_op expr) {
		return expr.accept(this);
	}

	@Override
	public String visit(Block expr) {
		return expr.accept(this);
	}

	@Override
	public String visit(Method_call expr) {
		return expr.accept(this);
	}

	@Override
	public String visit(Statement_asig expr) {
		return expr.accept(this);
	}

	@Override
	public String visit(Statement_break expr) {
		return expr.accept(this);
	}

	@Override
	public String visit(Statement_continue expr) {
		return expr.accept(this);
	}

	@Override
	public String visit(Statement_expr expr) {
		return expr.accept(this);
	}

	@Override
	public String visit(Statement_for expr) {
		return expr.accept(this);
	}

	@Override
	public String visit(Statement_if expr) {
		return expr.accept(this);
	}

	@Override
	public String visit(Statement_ifelse expr) {
		return expr.accept(this);
	}

	@Override
	public String visit(Statement_semicolon expr) {
		return expr.accept(this);
	}

	@Override
	public String visit(Statement_void expr) {
		return expr.accept(this);
	}

	@Override
	public String visit(Statement_while expr) {
		return expr.accept(this);
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
