package Compi;

public class Statement_break extends Statement{
	public Statement_break(int n){
		setLineNumber(n);
		setId("break");
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}

}
