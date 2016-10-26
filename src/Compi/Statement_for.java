package Compi;

public class Statement_for extends Statement{
	private Expr expr1;
	private Expr expr2;
	private Statement stat;
	private int offset;
	private Type type;

	public Statement_for(String i, Expr e, Expr e1, Statement s, int n){
		setId(i);
		this.expr1=e;
		this.expr2=e1;
		this.stat=s;
		setLineNumber(n);
		
	}

	public Expr getExpr1(){
		return expr1;
	}

	public Expr getExpr2(){
		return expr2;
	}

	public void setExpr1(Expr x){
		expr1 = x;
	}

	public void setExpr2(Expr x){
		expr2 = x;
	}

	public Statement getStatement(){
		return stat;
	}

	public void setStatement(Statement x){
		stat = x;
	}

	public void setOffset(int offset){
		this.offset = offset;
	}

	public int getOffset(){
		return this.offset;
	}

	public Type getType(){
		return type;
	}

	public void setType(Type x){
		type = x;
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}

	@Override
	public String toString() {
		String rtn = "for " + getId() + expr1.toString() + expr2.toString() + stat.toString();		
		return rtn;
	}

}
