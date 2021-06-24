package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Pedido implements Serializable{

	private ArrayList <Bebida> pedido;
	private Cliente cliente;

	public Pedido(Cliente cliente) {
		pedido = new ArrayList<>();
		this.cliente = cliente;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public ArrayList<Bebida> getPedido() {
		return pedido;
	}

	public void setPedido(ArrayList<Bebida> pedido) {
		this.pedido = pedido;
	}

	//agrega una bebida al pedido
	public void agregarAlPedido(Bebida bebida, int cantidad) {
		pedido.add(bebida);
		bebida.restarStock(cantidad);
	}
	
	//elimina una bebida del pedido
	public void elminarDelPedido(Bebida bebida, int cantidad) {
		pedido.remove(bebida);
		bebida.sumarStock(cantidad);
	}


	public StringBuilder mostrarPedido() {
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i <pedido.size(); i++) {
			builder.append(pedido.get(i).toString());
		}
		return builder;
	}
	public int tamañoPedido() {
		return pedido.size();
	}
	public Bebida devolverElemento(int i) {
		return pedido.get(i);
	}
}
