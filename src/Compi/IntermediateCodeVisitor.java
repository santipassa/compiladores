 package Compi; 

import java.util.LinkedList;
public class IntermediateCodeVisitor implements ASTVisitor<AST>{
	 public LinkedList<IntermediateCode> list;
	 public LinkedList<Label> lblentrada;
	 public LinkedList<Label> lblsalida;
	 int temporalCounter;
	 int ifCounter = 0;
	 int whileCounter = 0;
	 int maxOffset;
	 private String className; // auxiliar
	
	public LinkedList<IntermediateCode> getList(){
		return list;
		
	}
	public IntermediateCodeVisitor(int maxOffset){
		temporalCounter=0;
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

		if(x.getOp()=="%"){
			list.add(new IntermediateCode("MOD",x.getExpr1().accept(this),x.getExpr2().accept(this),tmp));
		}
		return tmp;

	}

	public AST visit(Field_decl x){
		return null;
	}

	public AST visit(Name x){
		Location tmp ;
		tmp = new Location("TMP"+temporalCounter,temporalCounter);
		tmp.setOffset(maxOffset);
		maxOffset-=4;
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
				className=x.getId();
				md.accept(this);
			}
		return null;
	}



	public AST visit(Method_decl x){
		maxOffset = x.getOffset();
		temporalCounter=0;
		if (!x.getBody().isExtern()){
			String id;
			/*if (x.getId().compareTo("main")!=0)
				id = className+x.getId();
			else*/
				id = x.getId();
			IntermediateCode methodDecl = new IntermediateCode("MDECL",null,null,new Label(id));
			list.add(methodDecl);
			x.getBody().accept(this);
			
			IntermediateCode endMeth = new IntermediateCode("ENDMETH",null,null,null);
			methodDecl.setOffset(maxOffset);
			list.add(endMeth);
		}

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
		if(x.isArray()){
			list.add(new IntermediateCode("ARRAY", x, x.getExpr().accept(this), null));		
		}
		return x;
	}
	
	public AST visit(Method_call_expr x){
		LinkedList<Expr> params = x.getParam_expr();
		LinkedList<Expr> acceptParams = new LinkedList<Expr>();
		if (params!=null){
			Expr aux;
			for(Expr e: params){
				aux = (Expr) e.accept(this);
				acceptParams.add(aux);
			}
			x.setParam_expr(acceptParams);
		}
		/*String id="";
		if (!x.isExtern()){
			if (x.isObjectCall())
				id = x.getClaseContenedora()+x.getId_param();
			else{
				id = x.getClaseContenedora()+x.getId();		
			}
		}else{
			id=x.getId();
		}
		list.add(new IntermediateCode("CALL", x, null, new Label(id)));*/
		list.add(new IntermediateCode("CALL", x, null, new Label(x.getId())));
		return new Registro("%eax");
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
			return tmp;
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
		LinkedList<Expr> params = x.getParam_expr();
		LinkedList<Expr> acceptParams = new LinkedList<Expr>();
		if (params!=null){
			Expr aux;
			for(Expr e: params){
				aux = (Expr) e.accept(this);
				acceptParams.add(aux);
			}
			x.setParam_expr(acceptParams);
		}			
		/*String id="";
		if (!x.isExtern()){
			if (x.isObjectCall())
				id = x.getClaseContenedora()+x.getId_param();
			else{
				id = x.getClaseContenedora()+x.getId();		
			}
		}else{
			id=x.getId();
		}
		list.add(new IntermediateCode("CALL", x, null, new Label(id)));
		*/list.add(new IntermediateCode("CALL", x, null, new Label(x.getId())));
		return null;
	}
	
	public AST visit(Statement_asig x){
			AST op = x.getExpr().accept(this);
			if(x.getAsign_op().getTipo()=="="){
				list.add(new IntermediateCode("ASIGN",op,null,x.getLocation().accept(this)));
			}
			if(x.getAsign_op().getTipo()=="+="){
				list.add(new IntermediateCode("ASIGNMAS",op,null,x.getLocation().accept(this)));
			}
			if(x.getAsign_op().getTipo()=="-="){
				list.add(new IntermediateCode("ASIGNMENOS",op,null,x.getLocation().accept(this)));
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
		list.add(new IntermediateCode("RETURNMETH",null,null,x.getExpr().accept(this)));
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
		list.add(new IntermediateCode("LBL",null,null,new Label("LBLFOR" + x.getLineNumber())));
		lblentrada.add(new Label("LBLFOR" + x.getLineNumber()));
		list.add(new IntermediateCode("JMPF",evalCota,i,new Label("LBLFORFIN" + x.getLineNumber())));
		lblsalida.add(new Label("LBLFORFIN" + x.getLineNumber()));
		x.getStatement().accept(this);
		list.add(new IntermediateCode("SUM",i,new Literal_integer(1),i));
		list.add(new IntermediateCode("JMP",null,null, new Label("LBLFOR" + x.getLineNumber())));
		list.add(new IntermediateCode("LBL",null,null,new Label("LBLFORFIN" + x.getLineNumber())));
		lblsalida.removeLast();
		lblentrada.removeLast();
		whileCounter--;
		return null;
		
	}
	
	public AST visit(Statement_if x){
		AST cond = x.getExpr().accept(this);
		int savedIfCounter=ifCounter;
		list.add(new IntermediateCode("JMPF",cond,new Literal_boolean(true),new Label("LBLIF"+x.getLineNumber()))) ;
		x.getStatement().accept(this);
		list.add(new IntermediateCode("LBL",null,null,new Label("LBLIF"+x.getLineNumber()))) ;
		ifCounter++;
		return null;
	}
	public AST visit(Statement_ifelse x){
		AST cond= x.getExpr().accept(this);
		list.add(new IntermediateCode("JMPF",cond,new Literal_boolean(true),new Label("LBLELSE"+x.getLineNumber())));
		x.getStatement1().accept(this);
		list.add(new IntermediateCode("JMP",null,null,new Label("LBLFIN"+x.getLineNumber())));
		list.add(new IntermediateCode("LBL",null,null,new Label("LBLELSE"+x.getLineNumber())));
		x.getStatement2().accept(this);
		list.add(new IntermediateCode("LBL",null,null,new Label("LBLFIN"+x.getLineNumber())));
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
		list.add(new IntermediateCode("LBL",null,null,new Label("LBLWHILE" + x.getLineNumber())));
		lblentrada.add(new Label("LBLWHILE" + x.getLineNumber()));
		AST cond = x.getExpr().accept(this);
		list.add(new IntermediateCode("JMPF",cond,new Literal_boolean(true),new Label("LBLWHILEFIN" + x.getLineNumber())));
		lblsalida.add(new Label("LBLWHILEFIN" + x.getLineNumber()));
		x.getStatement().accept(this);
		list.add(new IntermediateCode("JMP",null,null, new Label("LBLWHILE" + x.getLineNumber())));
		list.add(new IntermediateCode("LBL",null,null,new Label("LBLWHILEFIN" + x.getLineNumber())));
		whileCounter--;
		lblsalida.removeLast();
		lblentrada.removeLast();
		return null;

	}
	
}
