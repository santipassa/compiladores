package Compi;

import java.util.LinkedList;

public class Method_call extends Statement {

	private LinkedList<Expr> param_expr;
	private String id_param; // object.id_param()
	private String clase; // 

	public Method_call(String i, LinkedList<Expr> pe, String pi, int n){
		setId(i);
		this.param_expr=pe;
		this.id_param=pi;
		setLineNumber(n);	
	}

	public Method_call(String i, int n){
		setId(i);
		setLineNumber(n);	
	}

	public Method_call(String i, String pi, int n){
		setId(i);
		this.id_param=pi;
		setLineNumber(n);	

	}
	public Method_call(String i, int n, LinkedList<Expr> pe){
		setId(i);
		this.param_expr=pe;
		setLineNumber(n);	

	}

	public String getClase(){
		return clase;
	}

	public void setClase(String clase){
		this.clase = clase;
	}

	public String getId_param(){
		return id_param;
	}

	public boolean isObjectCall(){
		return (id_param != null);
	}

	public LinkedList<Expr> getParam_expr(){
		return param_expr;
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}
	public String toString(){
		String res ="";
		for(Expr e : param_expr){
			res+=e.toString();
		}
		return res;
	}

}
