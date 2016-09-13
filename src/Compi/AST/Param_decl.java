public class Param_decl{
	private String id;
	private Type type;
	private int numeroLinea;
	public Param_decl(String i,Type t,int n){
		this.id=i;
		this.type=t;
		this.numeroLinea=n;
	}
	public String getId(){
		return this.id;
	}
	public Type getType(){
		return this.type;
	}
	public int getNumeroLinea(){
		return this.numeroLinea;
	}

}