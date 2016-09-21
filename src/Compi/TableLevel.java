package Compi;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class TableLevel{

	LinkedList<SymbolTable> list;

	public TableLevel(){
		list = new LinkedList<SymbolTable>();
	}

	public void setSymbol(SymbolTable x){
		list.add(x);
	}

	//buscar en la list el nombre 
	public boolean searchSymbol(String x){
		if (!list.isEmpty())
			for (SymbolTable t :list)
				if (t.equals(x))
					return true;	
		return false;
	}

}
