package Compi;

public class Bin_op extends Expr {
	private Expr expr1;
	private Expr expr2;
	private String operacion;

	public Bin_op(Expr l, String op, Expr r, int n){
		operacion = op;
		expr1 = l;
		expr2 = r;
		setLineNumber(n);
	}

	public Expr getExpr1(){
		return expr1;
	}

	public Expr getExpr2(){
		return expr2;
	}
	
	public boolean typeOk(Type x){
		
		if (operacion == "+" || operacion == "-" || operacion == "*" || operacion == "/" || operacion == "%" || 
			operacion == "<" || operacion == ">" || operacion == "<=" || operacion == ">=" || operacion == "!=")
			return (x.toString() == "integer" || x.toString() == "float");
		
		if (operacion == "==")
			return (x.toString() == "integer" || x.toString() == "float" || x.toString() == "boolean");
		
		if (operacion == "!" || operacion == "||" || operacion == "&&")
			return (x.toString() == "boolean"); 
		return false;
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}
	public String getOp(){
		return operacion;
	}

}
