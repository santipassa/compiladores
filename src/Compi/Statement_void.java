package Compi;

public class Statement_void extends Statement{
	public Statement_void(int n){
		setLineNumber(n);
		setId("void");
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}
	public String toString(){
		return "void";
	}

}
