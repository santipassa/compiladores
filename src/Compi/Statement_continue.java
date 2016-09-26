package Compi;

public class Statement_continue extends Statement{
	public Statement_continue(int n){
		setLineNumber(n);
		setId("continue");
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}

}
