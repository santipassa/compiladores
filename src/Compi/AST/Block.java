import java.util.LinkedList;
public class Block extends Statement{
	
	LinkedList<Field_decl> field_declList;
	LinkedList<Statement> statement_List;
	int numeroLinea;
	public Block(LinkedList<Field_decl> f,LinkedList<Statement> s, int n){
		this.field_declList=f;
		this.statement_List=s;
		this.numeroLinea=n;
	}
	public Block(LinkedList<Field_decl> f,int n){
		this.field_declList=f;
		this.numeroLinea=n;
	}
	public Block(LinkedList<Statement> s, int n){
		this.statement_List=s;
		this.numeroLinea=n;
		
	}

}