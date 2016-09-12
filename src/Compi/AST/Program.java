import java.util.LinkedList;
public class Program{
	private LinkedList<Class_decl> class_declList;

	public Program(Class_decl c){
		this.class_declList = new  LinkedList<Class_decl>();
		class_decl.add(c);

	}
	public void addClass_decl(Class_decl c){
		class_declList.add(c);
	}

}