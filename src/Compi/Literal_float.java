package Compi;

public class Literal_float extends Expr {
	
		float literal_float;

		public Literal_float(float f){
			type = new Type("float");
			literal_float = f;
		}

}
