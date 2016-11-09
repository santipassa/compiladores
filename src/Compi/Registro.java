package Compi;
public class Registro extends Expr{

	private String nombre;

	public Registro(String n){
	
		nombre=n;
	}
	public String toString(){
		return nombre;
	}

	
	public <T> T accept(ASTVisitor<T> v){
		return null;
	}

}
