package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Pedido implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList <Bebida> pedido;
	private Cliente cliente;
	/**
	 * crea nuevo pedido
	 * @param cliente
	 */
	public Pedido(Cliente cliente) {
		pedido = new ArrayList<>();
		this.cliente = cliente;
	}
	/**
	 * 
	 * @return cliente que realiza el pedido
	 */
	public Cliente getCliente() {
		return cliente;
	}
	/**
	 * 
	 * @return pedido
	 */
	public ArrayList<Bebida> getPedido() {
		return pedido;
	}

	public void setPedido(ArrayList<Bebida> pedido) {
		this.pedido = pedido;
	}

	/**
	 * agrega una bebida al pedido
	 * @param bebida
	 * @param cantidad de bebidas a agregar al pedido
	 */
	public void agregarAlPedido(Bebida bebida, int cantidad) {
		pedido.add(bebida);
		bebida.restarStock(cantidad);
	}
	
	/**
	 * elimina una bebida del pedido
	 * @param bebida
	 * @param cantidad
	 */
	public void elminarDelPedido(Bebida bebida, int cantidad) {
		pedido.remove(bebida);
		bebida.sumarStock(cantidad);
	}

	/**
	 * 
	 * @return muestra un pedido
	 */
	public StringBuilder mostrarPedido() {
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i <pedido.size(); i++) {
			builder.append(pedido.get(i).toString());
		}
		return builder;
	}
	/**
	 * 
	 * @return total de bebidas en el pedido
	 */
	public int tamañoPedido() {
		return pedido.size();
	}
	/**
	 * muestra bebida del pedido
	 * @param i posicion en la lista de pedido
	 * @return
	 */
	public Bebida devolverElemento(int i) {
		return pedido.get(i);
	}
}
