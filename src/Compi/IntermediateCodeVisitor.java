package Compi;

import java.util.LinkedList;
public class IntermediateCodeVisitor implements ASTVisitor<AST>{
	 LinkedList<IntermediateCode> list;
	 int temporalCounter = 0;
	 int ifCounter = 0;
	 /*
		IntermediateCode constructor
		"OPERATOR",op1 AST,op2 AST,result AST

	 */
	public IntermediateCodeVisitor(){
		list=new LinkedList<IntermediateCode>();
	}

	
	

	public AST visit(Asign_op x){
		return null;
	}

	public AST visit(Bin_op x){
		Location tmp = new Location("TMP"+temporalCounter,temporalCounter);
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
		for (Name n : x.getName()) {
				n.accept(this);                                                              
		} 
		return null;
	}

	public AST visit(Name x){
		Location tmp ;
		
		if(x.isArray()){
			tmp = new Location("TMPARRAY"+temporalCounter,temporalCounter);
			
		}else{
			tmp = new Location("TMP"+temporalCounter,temporalCounter);
		}
		temporalCounter++;
		return tmp;
	}
	
	public AST visit(Body x){
		if(!x.isExtern()){
			x.getBlock().accept(this);
		}
		return null;
	}



	public AST visit(Class_decl x){
		for (Field_decl f : x.getField_decl()) {
			f.accept(this);
		}
		for (Method_decl md : x.getMethod_decl()) {
			md.accept(this);
		}
		return null;
	}



	public AST visit(Method_decl x){
		list.add(new IntermediateCode("METH"+x.getId(),null,null,null) );
		x.getBody().accept(this);
		return null;

	}
	
	public AST visit(Param_decl x){
		return null;
	}
	
	public AST visit(Literal_boolean x){
		list.add(new IntermediateCode("RESERVE",x,null,null));
		return null;
	}
	
	public AST visit(Literal_float x){
		list.add(new IntermediateCode("RESERVE",x,null,null));
		return null;
	}
	
	public AST visit(Literal_integer x){
		list.add(new IntermediateCode("RESERVE",x,null,null));
		return null;
	}
	
	public AST visit(Location x){
		return null;
	}
	
	public AST visit(Method_call_expr x){
		return null;
	}
	
	public AST visit(Program x){
		for(Class_decl c : x.getClasses())
	 		c.accept(this);
	 	return null;
	}
	public AST visit(Unary_op x){
	
			Location tmp = new Location("TMP"+temporalCounter,temporalCounter);
			temporalCounter++;
			if(x.getOperacion()=="!"){
				list.add(new IntermediateCode("NEG",x.getExpr().accept(this),null,tmp));
			}
			if(x.getOperacion()=="-"){
				list.add(new IntermediateCode("ABS",x.getExpr().accept(this),null,tmp));
			}
			return null;
	}
	
	public AST visit(Block x){
		return null;
	}

	
	public AST visit(Method_call x){
		list.add(new IntermediateCode("CALL",new Label("METH"+x.getId()),null,null));
		return null;
	}
	
	public AST visit(Statement_asig x){
	
			if(x.getAsign_op().getTipo()=="="){
				list.add(new IntermediateCode("ASIGN",x.getExpr().accept(this),null,x.getLocation().accept(this)));
			}
			if(x.getAsign_op().getTipo()=="+="){
				list.add(new IntermediateCode("ASIGNMAS",x.getExpr().accept(this),null,x.getLocation().accept(this)));
			}
			if(x.getAsign_op().getTipo()=="-="){
				list.add(new IntermediateCode("ASIGNMENOS",x.getExpr().accept(this),null,x.getLocation().accept(this)));
			}
			return null;
	}
	public AST visit(Statement_break x){
		list.add(new IntermediateCode("BREAK",null,null,null)) ;
		return null;
	}
	
	public AST visit(Statement_continue x){
		list.add(new IntermediateCode("CONTINUE",null,null,null)) ;
		return null;
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
		list.add(new IntermediateCode("JMPF",cond,null,new Label("LBLIF"+ifCounter))) ;
		x.getStatement().accept(this);
		list.add(new IntermediateCode("LBLIF"+ifCounter,null,null,null)) ;
		ifCounter++;
		return null;
	}
	public AST visit(Statement_ifelse x){
	
		AST cond= x.getExpr().accept(this);
		list.add(new IntermediateCode("JMPF",cond,null,new Label("LBLELSE"+ifCounter)));
		x.getStatement1().accept(this);
		list.add(new IntermediateCode("JMP",null,null,new Label("LBLFIN"+ifCounter)));
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
