package Compi;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class TableLevel{

	private LinkedList<SymbolTable> list;

	public TableLevel(){
		list = new LinkedList<SymbolTable>();
	}

	public void setSymbol(SymbolTable x){
		list.add(x);
	}

	public boolean search(SymbolTable x){
		return list.contains(x);
	}

	public boolean isEmpty(){
		return list.isEmpty();
	}

	//buscar en la list el nombre 
	public boolean searchSymbol(Expr x){
		if (!list.isEmpty())
			for (SymbolTable t :list)
				if (t.getId() == x.getId()){
					x.setType(new Type(t.getTypeString()));
					return true;						
				}
		return false;
	}

}
