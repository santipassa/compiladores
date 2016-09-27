public class IntermediateCodeVisitor implements ASTVisitor<AST>{
	 LinkedList<IntermediateCode> list;
	 /*
		IntermediateCode constructor
		"OPERATOR",op1 AST,op2 AST,result AST

	 */
	public IntermediateCode(){
		list=new LinkedList<IntermediateCode>();
	}

	public String visit(Asign_op x){



	}



	public AST visit(Bin_op x);

	public AST visit(Field_decl x){
		for (Name n : decl.getName()) {
				n.accept(this);                                                              
		} 
		return null;
	}

	







	public AST visit(Name x);
	public AST visit(Body x);



	public AST visit(Class_decl x){
		for (Field_Decl f: x.getField_decl()) {
			f.accept(this);
		}
		for (Method_decl md : x.getMethod_decl()) {
			md.accept(this);
		}
		return null;
	}



	public AST visit(Method_decl x);
	public AST visit(Param_decl x);
	public AST visit(Literal_boolean x);
	public AST visit(Literal_float x);
	public AST visit(Literal_integer x){
		list.add(new IntermediateCode())
	}
	public AST visit(Location x);
	public AST visit(Method_call_expr x);
	public AST visit(Program x){
		for(Class_decl c : x.getClasses())
	 		c.accept(this);
	 	return null;
	}
	public AST visit(Unary_op x);
	public AST visit(Block x);
	public AST visit(Method_call x);
	public AST visit(Statement_asig x){

			list.add(new IntermediateCode("ASIGN",x.getExpr().accept(this),null,x.getLocation().accept(this));


	}
	public AST visit(Statement_break x){
		return list.add(new IntermediateCode("BREAK",null,null,null) ;
	}
	public AST visit(Statement_continue x){
		return list.add(new IntermediateCode("CONTINUE",null,null,null) ;
	}
	public AST visit(Statement_expr x);
	public AST visit(Statement_for x);
	public AST visit(Statement_if x);
	public AST visit(Statement_ifelse x);
	public AST visit(Statement_semicolon x);
	public AST visit(Statement_void x);
	public AST visit(Statement_while x);
	


}
