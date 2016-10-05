package Compi;

public class Statement_asig extends Statement{
	private Location location;
	private Asign_op asign_op;
	private Expr expr;

	public Statement_asig(Location l, Asign_op a, Expr e){
		this.location=l;
		this.asign_op=a;
		this.expr=e;
		setId("asig");
	}

	public Location getLocation(){
		return location;
	}

	public Expr getExpr(){
		return expr;
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}

	public Asign_op getAsign_op(){
		return asign_op;
	}
	public String toString(){
		return location.toString()+asign_op.toString()+expr.toString();
	}

}
