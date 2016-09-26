package Compi;

// Abstract visitor
public interface ASTVisitor<T> {

	T visit(Asign_op x);
	T visit(Bin_op x);
	T visit(Field_decl x);
	T visit(Name x);
	T visit(Body x);
	T visit(Class_decl x);
	T visit(Method_decl x);
	T visit(Param_decl x);
	T visit(Literal_boolean x);
	T visit(Literal_float x);
	T visit(Literal_integer x);
	T visit(Location x);
	T visit(Method_call_expr x);
	T visit(Program x);
	T visit(Unary_op x);
	T visit(Block x);
	T visit(Method_call x);
	T visit(Statement_asig x);
	T visit(Statement_break x);
	T visit(Statement_continue x);
	T visit(Statement_expr x);
	T visit(Statement_for x);
	T visit(Statement_if x);
	T visit(Statement_ifelse x);
	T visit(Statement_semicolon x);
	T visit(Statement_void x);
	T visit(Statement_while x);
	

}
