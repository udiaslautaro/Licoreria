package model;

import java.util.ArrayList;

public class InventarioBebidas {
	
	ArrayList<Bebida> listaBebidas;
	
	public InventarioBebidas() {
		listaBebidas = new ArrayList<>();
	}
	
	//agrega un tipo de bebida al inventario
	public void agregarBebida(Bebida bebida) {
		listaBebidas.add(bebida);
	}
	
	//elimina del inventario de bebidas
	public void eliminarBebidaPorCodigo (String codigo) {
		for(int i = 0; i < listaBebidas.size(); i++) {
			if (listaBebidas.get(i).getCodigo() == codigo) {
				listaBebidas.remove(i);
			}
		}		
	}
	
	//muestra todo el inventario de bebidas
	public StringBuilder mostrarTodoInventario() {
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i <listaBebidas.size(); i++) {
			builder.append(listaBebidas.get(i).toString());
		}
		return builder;
	}
	
	//busca una bebida por codigo
	public String buscarPorCodigo(String codigo) {
		String detalleBebida = "";
		for (int i = 0; i < listaBebidas.size(); i++) {
			if (listaBebidas.get(i).getCodigo() == codigo) {
				detalleBebida = listaBebidas.get(i).toString();
			}
		}
		return detalleBebida;
	}
	public void modificarStock(String codigo, int stock) {
		for (int i=0; i< listaBebidas.size(); i++) {
			if (listaBebidas.get(i).getCodigo() == codigo) {
				listaBebidas.get(i).setStock(listaBebidas.get(i).getStock()+stock);
			}
		}
	}
	public boolean codigoExiste (String codigo) {
		boolean bool=false;
		for (int i=0; i< listaBebidas.size(); i++) {
			if (listaBebidas.get(i).getCodigo() == codigo) {
				bool=true;
				}
			}
		return bool; 
	}
}
 