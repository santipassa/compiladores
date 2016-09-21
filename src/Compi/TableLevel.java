package Compi;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class TableLevel{

	LinkedList<SymbolTable> lista;

	public TableLevel(){
		lista = new LinkedList<SymbolTable>();
	}

	public void setSymbol(SymbolTable x){
		lista.add(x);
	}
	//buscar en la lista el nombre 
}
