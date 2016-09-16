package Compi;


public class Statement_void extends Statement{

	public Statement_void(int n){

		setLineNumber(n);

	}


	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}

}
