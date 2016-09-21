package Compi;

import java.util.LinkedList;

public class Block extends Statement{
	
	LinkedList<Field_decl> field_declList;
	LinkedList<Statement> statement_List;

	public Block(LinkedList<Field_decl> f,LinkedList<Statement> s, int n){
		this.field_declList=f;
		this.statement_List=s;
		setLineNumber(n);	
	}
	public Block(LinkedList<Field_decl> f,int n){
		this.field_declList=f;
		setLineNumber(n);	
	}
	public Block(int n, LinkedList<Statement> s){
		this.statement_List=s;
		setLineNumber(n);	
		
	}
	public Block(int n){
		setLineNumber(n);	
		
	}

	public LinkedList<Field_decl> getField_decl(){
		return field_declList;
	}

	public LinkedList<Statement> getStatement(){
		return statement_List;
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}

}