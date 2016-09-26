package Compi;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class CheckTypeVisitor implements ASTVisitor<Type> {
	public CheckTypeVisitor() {		
	}
	
	public Type visit(Program expr) {
		for(Class_decl c : expr.getClasses())
	 		c.accept(this);
	 	return null; 
	}

	public Type visit(Class_decl c) {
		for (Method_decl m :  c.getMethod_decl())
			m.accept(this);
		return null;
	}

	public Type visit(Field_decl d) {
		return null;
	}
	
	public Type visit(Method_decl m) {
		if (!(m.getBody().isExtern()))
			if (m.getBody().accept(this).toString() != m.getType().toString())
				System.out.println("ERROR");
		return null;
	}

	public Type visit(Body b) {
		return b.getBlock().accept(this);
	}

	public Type visit(Block expr) {
		Type ret;
		ret = null;
		if (expr.getStatement() != null)
			for (Statement c :expr.getStatement())
				if (c.getId()=="expr")// caso return expr
					ret = c.accept(this);
				else	
					c.accept(this);
		return ret;	
	}
 	
	public Type visit(Statement_asig expr) {
		if (!(expr.getLocation().getType().equals(expr.getExpr().getType())))
			System.out.println("ERROR");
		return null;
	}

	public Type visit(Statement_break expr) {
		return null;
	}

	public Type visit(Statement_continue expr) {
		return null;
	}

	public Type visit(Statement_expr expr) {
		return expr.getExpr().getType();
	}

	public Type visit(Statement_for expr) {
		if (!(expr.getExpr1().getType().equals(expr.getExpr2().getType()) && 
						expr.getExpr1().getType().toString() == "integer"))
			System.out.println("ERROR");
		expr.getStatement().accept(this);
		return null;
	}

	public Type visit(Statement_if expr) {
		if (expr.getExpr().getType().toString()!="boolean")
			System.out.println("ERROR");
		expr.getStatement().accept(this);
		return null;
	}

	public Type visit(Statement_ifelse expr) {
		if (expr.getExpr().getType().toString()!="boolean")
			System.out.println("ERROR");
		expr.getStatement1().accept(this);
		expr.getStatement2().accept(this);
		return null;
	}

	public Type visit(Statement_semicolon expr) {
		return null;
	}

	public Type visit(Statement_void expr) {
		return null;
	}

	public Type visit(Statement_while expr) {
		if (expr.getExpr().getType().toString()!="boolean")
			System.out.println("ERROR");
		expr.getStatement().accept(this);
		return null;
	}

	public Type visit(Bin_op expr) {
		if (!(expr.getExpr1().getType().equals(expr.getExpr2().getType()) && expr.typeOk(expr.getExpr1().getType())))
			System.out.println("ERROR");
		return null;
	}	
	
	public Type visit(Param_decl expr) {
		return null;
	}

	public Type visit(Literal_boolean expr) {
		return null;
	}

	public Type visit(Literal_float expr) {
		return null;
	}

	public Type visit(Literal_integer expr) {
		return null;
	}

	public Type visit(Location expr) {
		return null;
	}

	public Type visit(Method_call_expr expr) {
		return null;
	}

	public Type visit(Unary_op expr) {
		return null;
	}

	public Type visit(Name expr) {
		return null;
	}

	public Type visit(Method_call expr) {
		return null;
	}

	public Type visit(Asign_op expr) {
		return null;
	}
	
}