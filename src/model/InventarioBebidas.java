package model;

import java.util.ArrayList;

import interfaces.IIndicadorPosicion;

public class InventarioBebidas implements IIndicadorPosicion{
	
	ArrayList<Bebida> listaBebidas;
	
	/**
	 * crea inventario de bebidas
	 */
	public InventarioBebidas() {
		listaBebidas = new ArrayList<>();
	}
	
	/**
	 * agrega un tipo de bebida al inventario
	 * @param bebida
	 */
	public void agregarBebida(Bebida bebida) {
		listaBebidas.add(bebida);
	}
	
	/**
	 * elimina del inventario de bebidas
	 * @param codigo de bebida a eliminar
	 */
	public void eliminarBebidaPorCodigo (int codigo) {
		for(int i = 0; i < listaBebidas.size(); i++) {
			if (listaBebidas.get(i).getCodigo() == codigo) {
				listaBebidas.remove(i);
			}
		}		
	}
	
	/**
	 * 
	 * @return muestra todo el inventario de bebidas
	 */
	public StringBuilder mostrarTodoInventario() {
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i <listaBebidas.size(); i++) {
			builder.append(listaBebidas.get(i).toString());
		}
		return builder;
	}
	
	/**
	 * 
	 * @param codigo de bebida
	 * @return busca una bebida por codigo
	 */
	public String buscarPorCodigo(int codigo) {
		String detalleBebida = "";
		for (int i = 0; i < listaBebidas.size(); i++) {
			if (listaBebidas.get(i).getCodigo() == codigo) {
				detalleBebida = listaBebidas.get(i).toString();
			}
		}
		return detalleBebida;
	}
	/**
	 * agrega stock a una bebida de la que se ingresa el codigo por parámetro
	 * @param codigoBebida
	 * @param stock stock a agregar
	 */
	public void modificarStock(int codigoBebida, int stock) {
		int i= devolverPosicion(codigoBebida);
		listaBebidas.get(i).setStock(listaBebidas.get(i).getStock()+stock);
		}
		
	/**
	 * 
	 * @param codigo
	 * @return true si el codigo existe y false en caso contrario
	 */
	public boolean codigoExiste (int codigo) {
		boolean bool=false;
		for (int i=0; i< listaBebidas.size(); i++) {
			if (listaBebidas.get(i).getCodigo() == codigo) {
				bool=true;
				}
			}
		return bool; 
	}
	/**
	 * 
	 * @param codigoBebida
	 * @return posicion de la bebida en la lista
	 */
	public int devolverPosicion(int codigoBebida) {
		int pos=-1;
		for (int i = 0; i < listaBebidas.size(); i++) {
			if (listaBebidas.get(i).getCodigo() == codigoBebida) {
				pos = i;
			}
		}
		return pos;
		}
	/**
	 * modifica precio de una bebida
	 * @param precio
	 * @param i posicion de la bebida en la lista
	 */
	public void modificarPrecio(float precio, int i) {
		listaBebidas.get(i).setPrecio(precio);
		
	}
	/**
	 * 
	 * @return total de bebidas en el inventario
	 */
	public int totalBebidas() {
		return listaBebidas.size();
	}
	/**
	 * 
	 * @param pos
	 * @return bebida en la posicion ingresada de la lista
	 */
	public Bebida devolverPorPosicion(int pos) {
		return listaBebidas.get(pos);
	}
	
	/**
	 * 
	 * @return Muestra solo la informacion de las bebidas que hay en stock
	 */
	public StringBuilder mostrarInfoBebidas() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < listaBebidas.size(); i++) {
			if(listaBebidas.get(i).getStock() > 0){
				builder.append(listaBebidas.get(i).infoBebida());
			}
		}
		return builder;
	}

	@Override
	public int devolverPosicion(String elemento) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
 