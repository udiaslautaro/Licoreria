package model;

import java.util.ArrayList;

public class Pedido {

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
	public void agregarAlPedido(Bebida bebida) {
		if(bebida.getStock() > 0) {
			pedido.add(bebida);
			bebida.restarStock();
		}
	}
	
	//elimina una bebida del pedido
	public void elminarDelPedido(Bebida bebida) {
		pedido.remove(bebida);
		bebida.sumarStock();
	}
	
	//calcula el precio final del pedido
	public double montoPedido() {
		double monto = 0;
		for (int i = 0; i < pedido.size(); i++) {
			monto += pedido.get(i).getPrecio();
		}
		return monto;
	}

	public StringBuilder mostrarPedido() {
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i <pedido.size(); i++) {
			builder.append(pedido.get(i).toString());
		}
		return builder;
	}
}
