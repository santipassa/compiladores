package Compi;

public class Type {

	String tipo;

	public Type(String t){
		this.tipo=t;

	}
	
	@Override
	public String toString(){
		return this.tipo;
	}

	public boolean equals(Type x){
		return this.tipo == x.tipo;
	}

}