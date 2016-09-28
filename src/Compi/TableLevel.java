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

	public void setSymbol(SymbolTable x){
		list.add(x);
	}

	public boolean search(SymbolTable x){
		for (SymbolTable s :list)
			if (s.equals(x))
				return true;
		return false;
	}

	public boolean isEmpty(){
		return list.isEmpty();
	}

	public boolean searchAtrClass(Expr x){
		Location loc = (Location) x;
		Name name = new Name(loc.getParamId(), 0);
		Name aux;
		if (!list.isEmpty())
			for (SymbolTable t :list) // busco la misma clase
				if (t.getId().compareTo(loc.getType().toString())==0){ 
					for (Field_decl f :t.getField_declList()){ // busco el atributo
						aux = f.containsName(name); 
						if (aux != null){	
							loc.setType(f.getType()); // le asigno el tipo correspondiente
							loc.setIsArray(aux.isArray());
							return true;	
						}
					}
				}
		return false;
	}

	public boolean searchClass(String x){
		if (!list.isEmpty())
			for (SymbolTable t :list){ // busco la misma clase
				if (t.getId().compareTo(x) == 0) 
					return true;	
			}
		return false;
	}

	//buscar en la list el nombre 
	public boolean searchSymbol(Expr x){
		Location aux = (Location) x;
		if (!list.isEmpty())
			for (SymbolTable t :list){
				if (t.getId().compareTo(aux.getId())==0){
					aux.setType(new Type(t.getTypeString()));
					aux.setIsArray(t.getIsArray());
					return true;						
				}
			}
		return false;
	}

	public boolean searchMethodExprSymbol(Method_call_expr x){
		if (!list.isEmpty())
			for (SymbolTable t :list){
				if (t.getId().compareTo(x.getId())==0 && t.getIsMethod()){
					x.setType(new Type(t.getTypeString()));
					return true;						
				}
			}
		return false;
	}

	public boolean searchMethodSymbol(Method_call x){
		if (!list.isEmpty())
			for (SymbolTable t :list){
				if (t.getId().compareTo(x.getId())==0 && t.getIsMethod()){
					//x.setType(new Type(t.getTypeString()));
					return true;						
				}
			}
		return false;
	}

}
