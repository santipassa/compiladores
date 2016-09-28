public class IntermediateCodeVisitor implements ASTVisitor<AST>{
	 LinkedList<IntermediateCode> list;
	 int temporalCounter = 0;
	 int ifCounter = 0;
	 /*
		IntermediateCode constructor
		"OPERATOR",op1 AST,op2 AST,result AST

	 */
	public IntermediateCode(){
		list=new LinkedList<IntermediateCode>();
	}

	public String visit(Asign_op x){



	}



	public AST visit(Bin_op x){
		Expr tmp = new Expr();
		tmp.setId("TMP"+temporalCounter);
		temporalCounter++;
		if(x.getOp()=="+"){
			list.add(new IntermediateCode("SUM",x.getExpr1().accept(this),x.getExpr2().accept(this),tmp));
		}
		if(x.getOp()=="-"){
			list.add(new IntermediateCode("RES",x.getExpr1().accept(this),x.getExpr2().accept(this),tmp));
		}
		if(x.getOp()=="*"){
			list.add(new IntermediateCode("MUL",x.getExpr1().accept(this),x.getExpr2().accept(this),tmp));
		}

		if(x.getOp()=="/"){
			list.add(new IntermediateCode("DIV",x.getExpr1().accept(this),x.getExpr2().accept(this),tmp));
		}

		if(x.getOp()==">"){
			list.add(new IntermediateCode("MAY",x.getExpr1().accept(this),x.getExpr2().accept(this),tmp));
		}

		if(x.getOp()=="<"){
			list.add(new IntermediateCode("MEN",x.getExpr1().accept(this),x.getExpr2().accept(this),tmp));
		}

		if(x.getOp()==">="){
			list.add(new IntermediateCode("MAYI",x.getExpr1().accept(this),x.getExpr2().accept(this),tmp));
		}

		if(x.getOp()=="<="){
			list.add(new IntermediateCode("MENI",x.getExpr1().accept(this),x.getExpr2().accept(this),tmp));
		}

		if(x.getOp()=="=="){
			list.add(new IntermediateCode("IGUAL",x.getExpr1().accept(this),x.getExpr2().accept(this),tmp));
		}

		if(x.getOp()=="&&"){
			list.add(new IntermediateCode("AND",x.getExpr1().accept(this),x.getExpr2().accept(this),tmp));
		}

		if(x.getOp()=="||"){
			list.add(new IntermediateCode("OR",x.getExpr1().accept(this),x.getExpr2().accept(this),tmp));
		}
		return tmp;

	}

	public AST visit(Field_decl x){
		for (Name n : decl.getName()) {
				n.accept(this);                                                              
		} 
		return null;
	}

	public AST visit(Name x);
	
	public AST visit(Body x){
		return null;
	}



	public AST visit(Class_decl x){
		for (Field_Decl f: x.getField_decl()) {
			f.accept(this);
		}
		for (Method_decl md : x.getMethod_decl()) {
			md.accept(this);
		}
		return null;
	}



	public AST visit(Method_decl x){

	}
	
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
	public AST visit(Unary_op x){
	
			Expr tmp = new Expr();
			tmp.setId("TMP"+temporalCounter);
			temporalCounter++;
			if(x.getOperacion()=="!"){
				list.add(new IntermediateCode("NEG",x.getExpr().accept(this),null,tmp));
			}
			if(x.getOperacion()=="-"){
				list.add(new IntermediateCode("ABS",x.getExpr().accept(this),null,tmp));
			}

	}
	
	public AST visit(Block x);
	
	public AST visit(Method_call x);
	
	public AST visit(Statement_asig x){
	
			if(x.getAsign_op().getTipo()=="="){
				list.add(new IntermediateCode("ASIGN",x.getExpr().accept(this),null,x.getLocation().accept(this));
			}
			if(x.getAsign_op().getTipo()=="+="){
				list.add(new IntermediateCode("ASIGNMAS",x.getExpr().accept(this),null,x.getLocation().accept(this));
			}
			if(x.getAsign_op().getTipo()=="-="){
				list.add(new IntermediateCode("ASIGNMENOS",x.getExpr().accept(this),null,x.getLocation().accept(this));
			}
			return null;
	}
	public AST visit(Statement_break x){
	
		return list.add(new IntermediateCode("BREAK",null,null,null) ;
	}
	
	public AST visit(Statement_continue x){
	
		return list.add(new IntermediateCode("CONTINUE",null,null,null) ;
	}
	
	public AST visit(Statement_expr x){
	
		x.getExpr().accept(this);
		return null;
	}
	
	public AST visit(Statement_for x){
	
		return null;
	}
	
	public AST visit(Statement_if x){
	
		AST cond = x.getExpr().accept(this);
		list.add(new IntermediateCode("JMPF",cond,null,"LBLIF"+ifCounter)) ;
		x.getStatement().accept(this);
		list.add(new IntermediateCode("LBLIF"+ifCounter,null,null,null)) ;
		ifCounter++;
		return null;
	}
	public AST visit(Statement_ifelse x){
	
		AST cond= x.getExpr().accept(this);
		list.add(new IntermediateCode("JMPF",cond,null,"LBLELSE"+ifCounter));
		x.getStatement1().accept(this);
		list.add(new IntermediateCode("JMP",null,null,"LBLFIN"+ifCounter));
		list.add(new IntermediateCode("LBLELSE"+ifCounter,null,null,null));
		x.getStatement2().accept(this);
		list.add(new IntermediateCode("LBLFIN"+ifCounter,null,null,null));
		ifCounter++;
		return null;
	}

	public AST visit(Statement_semicolon x){
		return null;
	}
	
	public AST visit(Statement_void x){
		return null;
	}
	
	public AST visit(Statement_while x){
		return null;
	}
	
}
