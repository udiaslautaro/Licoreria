package model;

import java.util.ArrayList;

public class HistorialPedidos {
	
	ArrayList<Pedido> listaPedidos;
	
	public HistorialPedidos() {
		listaPedidos = new ArrayList<Pedido>();
	}
	
	public void agregarPedido(Pedido pedido) {
		listaPedidos.add(pedido);
	}
	
	public StringBuilder mostrarPedidosCliente(String codigo) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < listaPedidos.size(); i++) {
			if(listaPedidos.get(i).getCliente().getCodigo() == codigo) {
				builder.append(listaPedidos.get(i).getPedido());
			}
		}
		return builder;
	}
	
	public void eliminarPedido(Pedido pedido) {
		listaPedidos.remove(pedido);
	}
}
