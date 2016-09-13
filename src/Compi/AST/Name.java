public class Name{
	String id;
	int numeroLinea;
	int int_literal;
	Boolean esArreglo;
	
	public Name(String i,int n){
		this.id=i;
		this.numeroLinea=n;
		this.esArreglo=false;
	}

	public Name(String i,int il,int n){
		this.id=i;
		this.numeroLinea=n;
		this.int_literal=il;
		this.esArreglo=true;
	}
}