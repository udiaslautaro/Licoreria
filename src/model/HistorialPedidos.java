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
			if(listaPedidos.get(i).getCliente().getCodigo().equals(codigo)) {
				builder.append(listaPedidos.get(i).mostrarPedido());
			}
		}
		return builder;
	}
	public void eliminarPedido(Pedido pedido) {
		for(int i = 0; i < pedido.tamañoPedido(); i++) {
			int cantUnidades = pedido.devolverElemento(i).getCantidad();
			pedido.devolverElemento(i).sumarStock(cantUnidades);
		}
		listaPedidos.remove(pedido);
	}
	public int tamañoListaPedidos() {
		return listaPedidos.size();
	}
	public Pedido devolverPorPosicion(int i) {
		return listaPedidos.get(i);
	}
}
