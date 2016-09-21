package Compi;

public abstract class AST {
	private String id;
	private int lineNumber;
	private int colNumber;
	
	public int getLineNumber() {
		return lineNumber;
	}
	
	public void setLineNumber(int ln) {
		lineNumber = ln;
	}
	
	public int getColumnNumber() {
		return colNumber;
	}
	
	public void setColumnNumber(int cn) {
		colNumber = cn;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String x) {
		id = x;
	}

	public abstract <T> T accept(ASTVisitor<T> v);
}
