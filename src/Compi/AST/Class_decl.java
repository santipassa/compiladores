import java.util.LinkedList;
class Class_decl{
	private String id;
	private int numeroLinea;
	LinkedList<Field_decl> field_declList;
	LinkedList<Method_decl> method_declList;
	// CONSTRUCTORES
	public Class_decl(String id,Field_decl f,Method_decl m,int numeroLinea){
		field_declList = new LinkedList<Field_decl>();
		field_declList.add(f);
		method_declList = new LinkedList<Method_decl>();
		method_declList.add(m);
		this.id=id;
		this.numeroLinea=numeroLinea;
	}
	public Class_decl(String id,int numeroLinea){
		field_declList = null;
		method_declList = null;
		this.id=id;
		this.numeroLinea=numeroLinea;
	}
	public Class_decl(String id,Field_decl f,int numeroLinea){
		field_declList = new LinkedList<Field_decl>();
		field_declList.add(f);
		method_declList = null;
		this.id=id;
		this.numeroLinea=numeroLinea;
	}
	public Class_decl(String id,Method_decl m,int numeroLinea){
		field_declList = null;
		method_declList = new LinkedList<Method_decl>();
		method_declList.add(m);
		this.id=id;
		this.numeroLinea=numeroLinea;
	}
	/////////////////////////////
	public String getId(){
		return this.id;
	}
	public void setId(String id){
		this.id=id;
	}
	//////////////////////////////
	public int getNumeroLinea(){
		return this.numeroLinea;
	}
	public void setNumeroLinea(int numeroLinea){
		this.numeroLinea=numeroLinea;
	}
	//////////////////////////////
	public void addMethod_decl(Method_decl m){
		method_declList.add(m);
	}
	public void addField_decl(Field_decl f){
		field_declList.add(f)
	}
}