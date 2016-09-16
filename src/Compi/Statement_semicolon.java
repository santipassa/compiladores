package Compi;


public class Statement_semicolon extends Statement{

	public Statement_semicolon(int n){

		setLineNumber(n);

	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}

}
