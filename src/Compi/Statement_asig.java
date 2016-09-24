package Compi;

public class Statement_asig extends Statement{
	Location location;
	Asign_op asign_op;
	Expr expr;

	public Statement_asig(Location l, Asign_op a, Expr e){
		this.location=l;
		this.asign_op=a;
		this.expr=e;
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}
	
	Location getLocation(){
		return location;
	}

}
