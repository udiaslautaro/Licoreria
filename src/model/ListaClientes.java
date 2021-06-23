package model;

import java.util.ArrayList;

import interfaces.IIndicadorPosicion;

public class ListaClientes implements IIndicadorPosicion{
	
	ArrayList<Cliente> listaClientes;
	
	public ListaClientes() {
		listaClientes = new ArrayList<Cliente>();
	}
	
	//Cuando agrega un cliente genera un codigo y se lo asigna.
	//Primero verifica que ese nombre no este repetido. Si lo está, entonces crea otro nombre con
	//un número al final
/**	public void agregarCliente(Cliente cliente) {
		listaClientes.add(cliente);
		for(int i = 0; i < listaClientes.size(); i++) {
			if( listaClientes.get(i).getNombre() == cliente.getNombre() && listaClientes.get(i).getApellido() == cliente.getApellido()) {
				cliente.setNombreUsuario(cliente.getNombre()+cliente.getApellido()+i);
			}
			else {
				cliente.setNombreUsuario(cliente.getNombre()+cliente.getApellido()); 
			}
		}
		cliente.setCodigo("C000"+listaClientes.size()+1); //puse algo random, se puede cambiar
	}*/
	public void agregarCliente(Object cliente) {
		listaClientes.add((Cliente) cliente);
		for(int i = 0; i < listaClientes.size(); i++) {
			if( listaClientes.get(i).getNombre() == ((Cliente) cliente).getNombre() && listaClientes.get(i).getApellido() == ((Cliente) cliente).getApellido()) {
				((Cliente) cliente).setNombreUsuario(((Cliente) cliente).getNombre()+((Cliente) cliente).getApellido()+i);
			}
			else {
				((Cliente) cliente).setNombreUsuario(((Cliente) cliente).getNombre()+((Cliente) cliente).getApellido()); 
			}
		}
		((Cliente) cliente).setCodigo("C000"+listaClientes.size()+1); //puse algo random, se puede cambiar
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
	
	public boolean estaCliente(String nombreUsuario, String password) {
		boolean esta = false;
		for (int i = 0; i < listaClientes.size(); i++) {
			if (listaClientes.get(i).getNombreUsuario() == nombreUsuario && listaClientes.get(i).getContraseña() == password) {
				esta = true;
			}
		}
		return esta;
	}
	
	public int devolverPosicion(String nombreUsuario) {
		int pos = 0;
		for (int i = 0; i < listaClientes.size(); i++) {
			if (listaClientes.get(i).getNombreUsuario() == nombreUsuario) {
				pos = i;
			}
		}
		return pos;
	}
	
	public Cliente devolverCliente(int pos) {
		return listaClientes.get(pos);
	}
	
	public int totalClientes () {
		return listaClientes.size();
	}
}
