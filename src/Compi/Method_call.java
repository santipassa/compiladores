package Compi;

import java.util.LinkedList;

public class Method_call extends Statement {

	private LinkedList<Expr> param_expr;
	private String id_param; // object.id_param()
	private Type type; // Tipo del id_param()
	private String claseContenedora;
	private boolean isExtern;
	private int offsetObject;

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

	public void setIsExtern(boolean isExtern){
		this.isExtern=isExtern;
	}

	public boolean isExtern(){
		return isExtern;
	}

	public Type getType(){
		return this.type;
	}

	public void setType(Type type){
		this.type = type;
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

	public void setParam_expr(LinkedList<Expr> param_expr){
		this.param_expr = param_expr;
	}

	public void setClaseContenedora(String claseContenedora){
		this.claseContenedora=claseContenedora;
	}

	public String getClaseContenedora(){
		return this.claseContenedora;
	}

	public void setOffsetObject(int offsetObject){
		this.offsetObject = offsetObject;
	}

	public int getOffsetObject(){
		return this.offsetObject;
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}
	public String toString(){
		String res ="";
		if (param_expr != null){
			for(Expr e : param_expr){
				res+=e.toString();
			}
		}
		return res;
	}

}
