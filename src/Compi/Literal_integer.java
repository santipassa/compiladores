package Compi;

public class Literal_integer extends Expr {
	
		Integer literal_int;

		public Literal_integer(Integer i){
			type = new Type("integer");
			literal_int = i;
		}

}
