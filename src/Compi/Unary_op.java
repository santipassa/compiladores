package Compi;

public class Unary_op extends Expr {
	private String operacion;

	public Unary_op(String op, Expr r, int n){
		operacion = op;
		setExpr(r);
		setLineNumber(n);
	}
	
	public boolean typeOk(Type x){		
		if (operacion == "!")
			return (x.toString() == "bool");
		if (operacion == "-")	
			return (x.toString() == "integer" || x.toString() == "float");
		return false;
	}

	public Type inferType(Type x){
		if (operacion == "!")
			return new Type("bool");
		return x;
	}

	public String getOperacion(){
		return operacion;
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}
	public String toString(){
		return operacion;
	}

}
