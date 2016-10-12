package Compi;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class TableLevel{

	private LinkedList<SymbolTable> list;

	public LinkedList<SymbolTable> getList(){
		return list;
	}

	public TableLevel(){
		list = new LinkedList<SymbolTable>();
	}

	public boolean isEmpty(){
		return list.isEmpty();
	}

	public void setSymbol(SymbolTable x){
		list.add(x);
	}

	public boolean search(SymbolTable x){
		for (SymbolTable s :list)
			if (s.equals(x))
				return true;
		return false;
	}

	public SymbolTable searchClass(String x){
		if (!list.isEmpty())
			for (SymbolTable t :list){ // busco la misma clase
				if (t.getId().compareTo(x) == 0) 
					return t;	
			}
		return null;
	}

	//buscar en la list el nombre 
	public SymbolTable searchSymbol(String x, boolean isMethod){
		if (!list.isEmpty())
			for (SymbolTable t :list){
				if (t.getId().compareTo(x)==0){
					if (t.isMethod()==isMethod)
						return t;						
				}
			}
		return null;
	}

}
