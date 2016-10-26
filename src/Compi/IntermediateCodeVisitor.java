 package Compi; 

import java.util.LinkedList;
public class IntermediateCodeVisitor implements ASTVisitor<AST>{
	 public LinkedList<IntermediateCode> list;
	 public LinkedList<Label> lblentrada;
	 public LinkedList<Label> lblsalida;
	 int temporalCounter = 0;
	 int ifCounter = 0;
	 int whileCounter = 0;
	 int maxOffset;
	
	public LinkedList<IntermediateCode> getList(){
		return list;
	}
	public IntermediateCodeVisitor(int maxOffset){
		list=new LinkedList<IntermediateCode>();
		lblsalida = new LinkedList<Label>();
		lblentrada = new LinkedList<Label>();
		this.maxOffset=maxOffset;
	}

	public AST visit(Asign_op x){
		
		return null;
	}

	public AST visit(Bin_op x){
		Location tmp = new Location("TMP"+temporalCounter,temporalCounter);
		tmp.setOffset(maxOffset);
		maxOffset-=4;
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
		return null;
	}

	public AST visit(Name x){
		Location tmp ;
		
		if(x.isArray()){
			tmp = new Location("TMPARRAY"+temporalCounter,temporalCounter);
			tmp.setOffset(maxOffset);
			maxOffset-=4;
		
		}else{
			tmp = new Location("TMP"+temporalCounter,temporalCounter);
			tmp.setOffset(maxOffset);
			maxOffset-=4;
		
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
		if (x.getField_decl() != null)
			for (Field_decl f : x.getField_decl()) {
				f.accept(this);
			}
		if (x.getMethod_decl() != null)
			for (Method_decl md : x.getMethod_decl()) {
				md.accept(this);
			}
		return null;
	}



	public AST visit(Method_decl x){

		maxOffset = x.getOffset();
		list.add(new IntermediateCode("MDECL",null,null,new Label("METH"+x.getId())) );
		x.getBody().accept(this);
		list.add(new IntermediateCode("ENDMETH",null,null,null));

		return null;

	}
	
	public AST visit(Param_decl x){
		return null;
	}
	
	public AST visit(Literal_boolean x){
		
		return x;
	}
	
	public AST visit(Literal_float x){
		
		return x;
	}
	
	public AST visit(Literal_integer x){
		
		return x;
	}
	
	public AST visit(Location x){
		return x;
	}
	
	public AST visit(Method_call_expr x){
		
		
		return null;
	}
	
	public AST visit(Program x){
		if (x.getClasses() != null)
			for(Class_decl c : x.getClasses())
	 			c.accept(this);
	 	return null;
	}
	public AST visit(Unary_op x){
	
			Location tmp = new Location("TMP"+temporalCounter,temporalCounter);
			tmp.setOffset(maxOffset);
			maxOffset-=4;
		
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
		if(x.getField_decl()!=null){
			for(Field_decl f : x.getField_decl()){
				f.accept(this);
				
			}
		}
		if(x.getStatement()!=null){
			for(Statement s : x.getStatement()){
				s.accept(this);
				
			}
		}
		return null;
	}

	
	public AST visit(Method_call x){
		list.add(new IntermediateCode("CALL",null,null,new Label("METH"+x.getId())));
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
		Label l = lblsalida.getLast();
		list.add(new IntermediateCode("JMP",null,null,l));
		return null;
	}
	
	public AST visit(Statement_continue x){
		Label l = lblentrada.getLast();
		list.add(new IntermediateCode("JMP",null,null,l));
		return null;
	}
	
	public AST visit(Statement_expr x){
	
		x.getExpr().accept(this);
		return null;
	}
	
	public AST visit(Statement_for x){
		whileCounter++;
		Location evalCota = new Location("cota",0);
		evalCota.setOffset(maxOffset);
		maxOffset-=4;
		Location i = new Location(x.getId(),0);
		i.setOffset(x.getOffset());
		AST exp1 = x.getExpr1().accept(this);
		AST exp2 = x.getExpr2().accept(this);
		list.add(new IntermediateCode("ASIGN",exp1,null,i));
		list.add(new IntermediateCode("ASIGN",exp2,null,evalCota));
		list.add(new IntermediateCode("LBL",null,null,new Label("LBLFOR" + whileCounter)));
		lblentrada.add(new Label("LBLFOR" + whileCounter));
		list.add(new IntermediateCode("JMPF",evalCota,i,new Label("LBLFORFIN" + whileCounter)));
		lblsalida.add(new Label("LBLFORFIN" + whileCounter));
		x.getStatement().accept(this);
		list.add(new IntermediateCode("INC",null,null,i));
		list.add(new IntermediateCode("JMP",null,null, new Label("LBLFOR" + whileCounter)));
		list.add(new IntermediateCode("LBL",null,null,new Label("LBLFORFIN" + whileCounter)));
		lblsalida.removeLast();
		lblentrada.removeLast();
		whileCounter--;
		return null;
		
	}
	
	public AST visit(Statement_if x){
		
		AST cond = x.getExpr().accept(this);
		list.add(new IntermediateCode("JMPF",cond,new Literal_boolean(true),new Label("LBLIF"+ifCounter))) ;
		x.getStatement().accept(this);
		list.add(new IntermediateCode("LBL",null,null,new Label("LBLIF"+ifCounter))) ;
		ifCounter++;
		return null;
	}
	public AST visit(Statement_ifelse x){
	
		AST cond= x.getExpr().accept(this);
		list.add(new IntermediateCode("JMPF",cond,new Literal_boolean(true),new Label("LBLELSE"+ifCounter)));
		x.getStatement1().accept(this);
		list.add(new IntermediateCode("JMP",null,null,new Label("LBLFIN"+ifCounter)));
		list.add(new IntermediateCode("LBL",null,null,new Label("LBLELSE"+ifCounter)));
		x.getStatement2().accept(this);
		list.add(new IntermediateCode("LBL",null,null,new Label("LBLFIN"+ifCounter)));
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
		whileCounter++;
		list.add(new IntermediateCode("LBL",null,null,new Label("LBLWHILE" + whileCounter)));
		lblentrada.add(new Label("LBLWHILE" + whileCounter));
		AST cond = x.getExpr().accept(this);
		list.add(new IntermediateCode("JMPF",cond,new Literal_boolean(true),new Label("LBLWHILEFIN" + whileCounter)));
		lblsalida.add(new Label("LBLWHILEFIN" + whileCounter));
		x.getStatement().accept(this);
		list.add(new IntermediateCode("JMP",null,null, new Label("LBLWHILE" + whileCounter)));
		list.add(new IntermediateCode("LBL",null,null,new Label("LBLWHILEFIN" + whileCounter)));
		
		whileCounter--;
		lblsalida.removeLast();
		lblentrada.removeLast();
		return null;

	}
	
}
