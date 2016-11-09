package Compi;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class CheckTypeVisitor implements ASTVisitor<Type> {

	private LinkedList<ErrorCompi> errors;
	private int whileOrFor;
	private Type methodType;
	private LinkedList<Method_decl> method_list;

	public CheckTypeVisitor() {		
		errors = new LinkedList<ErrorCompi>();
		whileOrFor = 0;
		method_list = new LinkedList<Method_decl>();
	}

	private void addError(AST a, String desc) {
		errors.add(new ErrorCompi(a.getLineNumber(), "'"+a.getId()+"' "+desc));
	}

	public LinkedList<ErrorCompi> getErrors() {
		return errors;
	}

	private boolean paramCheck(LinkedList<Expr> expr, LinkedList<Param_decl> param){				
		if (expr==null && param==null)
			return true;
		else 
			if (expr==null || param==null)
				return false;
			else
				if (param.size()==expr.size()){
					for (int i=0; i<param.size(); i++){
						if (!param.get(i).getType().equals(expr.get(i).getType()))
							return false;	
					}
					return true;
				}
				else
					return false;
	}
	
	public Type visit(Program expr) {
		for(Class_decl c : expr.getClasses())
	 		c.accept(this);
	 	return null; 
	}

	public Type visit(Class_decl c) {
		if (c.getField_decl() != null)
			for (Field_decl f :  c.getField_decl())
				if (f.accept(this).toString().compareTo("void")==0)
					this.addError(f, "Incorrect type");
		if (c.getMethod_decl() != null)
			for (Method_decl m :  c.getMethod_decl())
				m.accept(this);
		return null;
	}

	public Type visit(Field_decl d) {
		return d.getType();
	}
	
	public Type visit(Method_decl m) {
		method_list.add(m);
		methodType = m.getType();
		if (!(m.getBody().isExtern())){
			Type aux = m.getBody().accept(this);
			if (aux==null){
				this.addError(m, "not found return"); // exigimos un return en bloque principal del metodo
				return null;
			}
		}
		return null;
	}

	public Type visit(Body b) {
		return b.getBlock().accept(this);
	}

	public Type visit(Block expr) {
		if (expr.getField_decl() != null)	
			for (Field_decl f :  expr.getField_decl())
				if (f.accept(this).toString().compareTo("void")==0)
					this.addError(f, "Incorrect type");
		Type ret = null;
		if (expr.getStatement() != null)
			for (Statement c :expr.getStatement())
				if (c.getId()=="expr" || c.getId()=="void")// caso return expr; ó return;
					ret = c.accept(this); // asumo que las expr son distintas de void
				else{
					if (c.getId()=="break" || c.getId()=="continue")
						if (whileOrFor==0)	
							this.addError(c, "Incorrect definition");	// no se deben definir aca
					c.accept(this);
				}
		return ret;	
	}
 	
	public Type visit(Statement_asig expr) {
		Type loc = expr.getLocation().accept(this);
		Type exp = expr.getExpr().accept(this);
		if (!loc.equals(exp))
			this.addError(expr.getLocation(), loc.toString()+expr.getAsign_op().toString()+exp.toString());
		return loc;
	}

	public Type visit(Statement_break expr) {
		return null;
	}

	public Type visit(Statement_continue expr) {
		return null;
	}

	public Type visit(Statement_expr expr) {
		Type returnType = expr.getExpr().accept(this);
		if (!methodType.equals(returnType))
			this.addError(expr, "Expected "+methodType.toString()+" not "+returnType.toString());
		return returnType;
	}

	public Type visit(Statement_for expr) {
		if (!((expr.getExpr1().accept(this).equals(expr.getExpr2().accept(this)) && 
				expr.getExpr1().accept(this).toString().compareTo("integer")==0) && 
				(expr.getType().toString().compareTo("integer")==0)))
			this.addError(expr, "Expected integer");
		whileOrFor++;
		expr.getStatement().accept(this);
		whileOrFor--;
		return null;
	}

	public Type visit(Statement_if expr) {
		Type cond = expr.getExpr().accept(this); 
		if (cond.toString().compareTo("bool")!=0)
			this.addError(expr, "Expected bool, not "+cond.toString());
		Statement aux = expr.getStatement();
		if (aux.getId()=="expr" || aux.getId()=="void")
			return aux.accept(this);
		if (aux.getId()=="break" || aux.getId()=="continue")
			if (whileOrFor==0)
				this.addError(aux, "Incorrect definition");		// no se deben definir aca
		aux.accept(this);
		return null;
	}

	public Type visit(Statement_ifelse expr) {
		Type cond = expr.getExpr().accept(this);
		if (cond.toString().compareTo("bool")!=0)
			this.addError(expr, "Expected bool, not "+cond.toString());
		Statement aux1 = expr.getStatement1();
		Statement aux2 = expr.getStatement2();
		if (aux1.getId()=="break" || aux1.getId()=="continue")
			if (whileOrFor==0)
				this.addError(aux1, "Incorrect definition");		// no se deben definir aca
		if (aux2.getId()=="break" || aux2.getId()=="continue")
			if (whileOrFor==0)
				this.addError(aux2, "Incorrect definition");		// no se deben definir aca
		Type s1 = aux1.accept(this);
		Type s2 = aux2.accept(this);
		if (aux1.getId()=="expr" || aux1.getId()=="void")
			return s1;
		if (aux2.getId()=="expr" || aux2.getId()=="void")
			return s2;
		return null;
	}

	public Type visit(Statement_semicolon expr) {
		return null;
	}

	public Type visit(Statement_void expr) {
		return new Type(expr.getId());
	}

	public Type visit(Statement_while expr) {
		Type cond = expr.getExpr().accept(this);
		if (cond.toString().compareTo("bool")!=0)
			this.addError(expr, "Expected bool, not "+cond.toString());
		whileOrFor++;
		expr.getStatement().accept(this);
		whileOrFor--;
		return null;
	}

	public Type visit(Bin_op expr) {
		Type expr1 = expr.getExpr1().accept(this);
		Type expr2 = expr.getExpr2().accept(this);
		if (!(expr1.equals(expr2) && expr.typeOk(expr1)))
			this.addError(expr, "Error: "+expr1.toString()+expr.getOperacion()+expr2.toString());
		expr.setType(expr.inferType(expr1));
		return expr.getType();
	}	
	
	public Type visit(Param_decl expr) {
		return null;
	}

	public Type visit(Literal_boolean expr) {
		return expr.getType();
	}

	public Type visit(Literal_float expr) {
		return expr.getType();
	}

	public Type visit(Literal_integer expr) {
		return expr.getType();
	}

	public Type visit(Location expr) {
		if (expr.isArray()){
			expr.getExpr().accept(this);
			Type type = new Type("integer");
			if (!(expr.getExpr().getType().equals(type)))
				this.addError(expr, "["+expr.getExpr().getType()+"]"+" expected integer");
		}
		return expr.getType();
	}

	public Type visit(Method_call_expr expr) {
		if (expr.getParam_expr()!=null)
			for (Expr e: expr.getParam_expr())
				e.accept(this);
		if (method_list.size()>0)
			for (Method_decl m: method_list)
				if (m.getId().compareTo(expr.getId())==0)
					if (!this.paramCheck(expr.getParam_expr(), m.getParam_decl()))
						this.addError(expr, " Illegal parameters");
		return expr.getType();
	}

	public Type visit(Unary_op expr) {
		Type expr1 = expr.getExpr().accept(this);
		if (!expr.typeOk(expr1))
			this.addError(expr, "Error: "+expr.getOperacion()+expr1.toString());
		expr.setType(expr.inferType(expr1));
		return expr.getType();
	}

	public Type visit(Name expr) {
		return null;
	}

	public Type visit(Method_call expr) {
		if (expr.getParam_expr()!=null)
			for (Expr e: expr.getParam_expr())
				e.accept(this);
		if (method_list.size()>0)
			for (Method_decl m: method_list)
				if (m.getId().compareTo(expr.getId())==0)
					if (!this.paramCheck(expr.getParam_expr(), m.getParam_decl()))
						this.addError(expr, " Illegal parameters");
		return null;
	}

	public Type visit(Asign_op expr) {
		return null;
	}
	
}