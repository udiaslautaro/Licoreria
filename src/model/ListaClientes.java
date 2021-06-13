package model;

import java.util.ArrayList;

public class ListaClientes {
	
	ArrayList<Cliente> listaClientes;
	
	public ListaClientes() {
		listaClientes = new ArrayList<Cliente>();
	}
	
	//Cuando agrega un cliente genera un codigo y se lo asigna
	public void agregarCliente(Cliente cliente) {
		listaClientes.add(cliente);
		cliente.setNombreUsuario(cliente.getNombre()+cliente.getApellido()); 
		cliente.setCodigo("C000"+listaClientes.size()+1); //puse algo random, se puede cambiar
	}
	
	public StringBuilder buscarCliente(String nombreUsuario) {
		StringBuilder builder  = new StringBuilder();
		for(int i = 0; i < listaClientes.size(); i++) {
			if(listaClientes.get(i).getNombreUsuario() == nombreUsuario) {
				builder.append(listaClientes.get(i).toString());
			}
		}
		return builder;
	}
}
