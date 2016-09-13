import java.util.LinkedList;
public class Field_decl{
	Type type;
	int numeroLinea
	LinkedList<Name> list_names;

	public Field_decl(Type t,LinkedList<Name> l, int numeroLinea){
		this.type=t;
		list_namesList = l; 
		this.numeroLinea=numeroLinea;
	}
	public Type getType(){
		return this.type;
	}
	public void setType(Type t){
		this.type=t;
	}
	public int getNumeroLinea(){
		return numeroLinea;
	}	
	public void setNumeroLinea(int n){
		this.numeroLinea=n;
	}

}