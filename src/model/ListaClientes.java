package model;

import java.util.ArrayList;

import interfaces.IIndicadorPosicion;

public class ListaClientes implements IIndicadorPosicion{
	
	ArrayList<Cliente> listaClientes;
	/**
	 * crea lista de clientes
	 */
	public ListaClientes() {
		listaClientes = new ArrayList<Cliente>();
	}
	
	/**
	 * agrega un cliente y asigna un codigo
	 * @param cliente
	 */
	public void agregarCliente(Cliente cliente) {
		listaClientes.add(cliente);
		cliente.setNombreUsuario(cliente.getNombre()+cliente.getApellido()+listaClientes.size()); 
		cliente.setCodigo("C00"+listaClientes.size()+1); //puse algo random, se puede cambiar
	}
	/**
	 * 
	 * @param nombreUsuario
	 * @return informacion del usuario
	 */
	public StringBuilder buscarCliente(String nombreUsuario) {
		StringBuilder builder  = new StringBuilder();
		for(int i = 0; i < listaClientes.size(); i++) {
			if(listaClientes.get(i).getNombreUsuario() == nombreUsuario) {
				builder.append(listaClientes.get(i).toString());
			}
		}
		return builder;
	}
	/**
	 * 
	 * @param nombreUsuario
	 * @param password
	 * @return true si verifica datos, false en caso contrario
	 */
	public boolean estaCliente(String nombreUsuario, String password) {
		boolean esta = false;
		for (int i = 0; i < listaClientes.size(); i++) {
			if (listaClientes.get(i).getNombreUsuario().equals(nombreUsuario) && listaClientes.get(i).getContraseña().equals(password) ) {
				esta = true;
			}
		}
		return esta;
	}
	/**
	 * devuelve posicion del usuario en la lista
	 */
	public int devolverPosicion(String nombreUsuario) {
		int pos = 0;
		for (int i = 0; i < listaClientes.size(); i++) {
			if (listaClientes.get(i).getNombreUsuario() == nombreUsuario) {
				pos = i;
			}
		}
		return pos;
	}
	/**
	 * 
	 * @param pos
	 * @return cliente
	 */
	public Cliente devolverCliente(int pos) {
		return listaClientes.get(pos);
	}
	/**
	 * 
	 * @return total de clientes
	 */
	public int totalClientes () {
		return listaClientes.size();
	}
}
