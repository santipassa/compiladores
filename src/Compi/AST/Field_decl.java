import java.util.LinkedList;
public class Field_decl{
	Type type;
	int numeroLinea
	List_names list_names;

	public Field_decl(Type t,List_names l, int numeroLinea){
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
	public List_names getList_names(){
		return this.list_names;
	}
	public void setList_names(List_names l){
		this.list_names=l;
	}

}