package Compi;
import java.util.LinkedList;

public class Program extends AST {

	private LinkedList<Class_decl> class_declList;

	public Program(Class_decl c){
		this.class_declList = new  LinkedList<Class_decl>();
		class_declList.add(c);
	}

	public void addClass(Class_decl c){
		class_declList.add(c);
	}

}