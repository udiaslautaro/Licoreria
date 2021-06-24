package model;

import java.util.ArrayList;

public class HistorialPedidos {
	
	ArrayList<Pedido> listaPedidos;
	/**
	 * construye una lista de pedidos
	 */
	public HistorialPedidos() {
		listaPedidos = new ArrayList<Pedido>();
	}
	/**
	 * agrega un pedido a la lista
	 * @param pedido
	 */
	public void agregarPedido(Pedido pedido) {
		listaPedidos.add(pedido);
	}
	/**
	 * recibe un codigo de cliente y muestra sus pedidos
	 * @param codigo del cliente
	 * @return devuelve todos los pedidos de cierto cliente
	 */
	public StringBuilder mostrarPedidosCliente(String codigo) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < listaPedidos.size(); i++) {
			if(listaPedidos.get(i).getCliente().getCodigo().equals(codigo)) {
				builder.append(listaPedidos.get(i).mostrarPedido());
			}
		}
		return builder;
	}
	/**
	 * elimina un pedido
	 * @param pedido
	 */
	public void eliminarPedido(Pedido pedido) {
		for(int i = 0; i < pedido.tamañoPedido(); i++) {
			int cantUnidades = pedido.devolverElemento(i).getCantidad();
			pedido.devolverElemento(i).sumarStock(cantUnidades);
		}
		listaPedidos.remove(pedido);
	}
	/**
	 * 
	 * @return devuelve la cantidad total de pedidos realizados
	 */
	public int tamañoListaPedidos() {
		return listaPedidos.size();
	}
	/**
	 * 
	 * @param i un entero, posicion
	 * @return devuelve el pedido de la posicion i en la lista de pedidos
	 */
	public Pedido devolverPorPosicion(int i) {
		return listaPedidos.get(i);
	}
}
