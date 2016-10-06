package Compi;

public class Statement_semicolon extends Statement{
	public Statement_semicolon(int n){
		setLineNumber(n);
		setId("semicolon");
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}

	public String toString(){
		return ";";
	}

}
