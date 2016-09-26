public class IntermediateCodeVisitor implements ASTVisitor<AST>{
	 LinkedList<IntermediateCode> list;

	public IntermediateCode(){
		list=new LinkedList<IntermediateCode>();
	}

	public String visit(Asign_op x){



	}



	public AST visit(Bin_op x);
	public AST visit(Field_decl x);
	public AST visit(Name x);
	public AST visit(Body x);
	public AST visit(Class_decl x);
	public AST visit(Method_decl x);
	public AST visit(Param_decl x);
	public AST visit(Literal_boolean x);
	public AST visit(Literal_float x);
	public AST visit(Literal_integer x){
		list.add(new IntermediateCode())
	}
	public AST visit(Location x);
	public AST visit(Method_call_expr x);
	public AST visit(Program x);
	public AST visit(Unary_op x);
	public AST visit(Block x);
	public AST visit(Method_call x);
	public AST visit(Statement_asig x){
			list.add(new IntermediateCode("ASIGN",x.getExpr().accept(this),null,x.getLocation().accept(this))


	}
	public AST visit(Statement_break x);
	public AST visit(Statement_continue x);
	public AST visit(Statement_expr x);
	public AST visit(Statement_for x);
	public AST visit(Statement_if x);
	public AST visit(Statement_ifelse x);
	public AST visit(Statement_semicolon x);
	public AST visit(Statement_void x);
	public AST visit(Statement_while x);
	


}
