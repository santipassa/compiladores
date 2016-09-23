package Compi;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class MainVisitor implements ASTVisitor<Integer>{

	public MainVisitor(){

	}

	@Override
	public Integer visit(Program expr) {
		int cantMain = 0;
		if (expr.getClasses() != null)

			for (Class_decl c : expr.getClasses()) {
				if (c.getId().equals("main"))
				cantMain = cantMain + c.accept(this);
			}
		return cantMain;
	}

	@Override
	public Integer visit(Class_decl expr) {
		int cantMain = 0;
		if (expr.getMethod_decl() != null)
			for (Method_decl c : expr.getMethod_decl()) {
				cantMain = cantMain + c.accept(this);
			}
		return cantMain;
	}

	@Override
	public Integer visit(Method_decl expr) {
		if (expr.getParam_decl() == null)
			if (expr.getId().equals("main")) 
				return 1;
			
		return 0;
	}

	
	@Override
	public Integer visit(Field_decl expr) {
		return 0;
	}

	@Override
	public Integer visit(Name expr) {
		return 0;
	}

	@Override
	public Integer visit(Body expr) {
		return 0 ;
	}

	@Override
	public Integer visit(Block expr) {
		return 0;
	}
	@Override
	public Integer visit(Bin_op expr) {
		return 0;

	}	

	@Override
	public Integer visit(Param_decl expr) {
		return 0;
	}

	@Override
	public Integer visit(Literal_boolean expr) {
		return 0;
	}

	@Override
	public Integer visit(Literal_float expr) {
		return 0;
	}

	@Override
	public Integer visit(Literal_integer expr) {
		return 0;
	}

	@Override
	public Integer visit(Location expr) {
		return 0;  

	}

	@Override
	public Integer visit(Method_call_expr expr) {
		return 0; 

	}

	@Override
	public Integer visit(Unary_op expr) {
		return 0;
	}


	@Override
	public Integer visit(Method_call expr) {
		return 0;
	}

	@Override
	public Integer visit(Statement_asig expr) {
		return 0;
	}

	@Override
	public Integer visit(Statement_break expr) {
		return 0;
	}

	@Override
	public Integer visit(Statement_continue expr) {
		return 0;
	}

	@Override
	public Integer visit(Statement_expr expr) {
		return 0;
	}

	@Override
	public Integer visit(Statement_for expr) {
		return 0;
	}

	@Override
	public Integer visit(Statement_if expr) {
		return 0;
	}

	@Override
	public Integer visit(Statement_ifelse expr) {
		return 0;
	}

	@Override
	public Integer visit(Statement_semicolon expr) {
		return 0;
	}

	@Override
	public Integer visit(Statement_void expr) {
		return 0;
	}

	@Override
	public Integer visit(Statement_while expr) {
		return 0;
	}

}
