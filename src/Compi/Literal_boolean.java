package Compi;

public class Literal_boolean extends Expr {
	
		boolean literal_bool;

		public Literal_boolean(boolean b){
			type = new Type("boolean");
			literal_bool = b;
		}

}
