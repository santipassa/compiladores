package Compi;
public class Label extends AST{

	private String typeLBL;

	public Label(String t){
	
		typeLBL=t;
	}
	public String toString(){
		return typeLBL;
	}

	
	public <T> T accept(ASTVisitor<T> v){
		return null;
	}

}
