package Compi;

public class Type {

	private String tipo;

	public Type(String t){
		this.tipo=t;
	}
	
	public boolean isObject(){
		return (tipo!="integer" && tipo!="float" && tipo!="void" && tipo!="boolean");
	}

	@Override
	public String toString(){
		return this.tipo;
	}

	public boolean equals(Type x){
		return this.tipo == x.tipo;
	}

}