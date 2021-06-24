package model;

import java.io.Serializable;

public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String apellido;
	private String dni;
	private String codigo; 
	private String contrase�a;
	private String nacimiento;
	private String nombre;
	private String nombreUsuario;

	
	/**
	 * 
	 * @return devuelve nombre del cliente
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * asigna nombre al cliente
	 * @param nombre nombre del cliente
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * 
	 * @return devuelve apellido del cliente
	 */
	public String getApellido() {
		return apellido;
	}
	/**
	 * asigna apellido al cliente
	 * @param apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	/**
	 * 
	 * @return dni del cliente
	 */
	public String getDni() {
		return dni;
	}
	/**
	 * asigna nro de dni al cliente
	 * @param dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	/**
	 * 
	 * @return codigo de cliente
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * agina codigo al cliente
	 * @param codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	/**
	 * 
	 * @return contrase�a del cliente
	 */
	public String getContrase�a() {
		return contrase�a;
	}
	/**
	 * asigna contrase�a al usuario
	 * @param contrase�a
	 */
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	/**
	 * 
	 * @return fecha de nacimiento del cliente
	 */
	public String getNacimiento() {
		return nacimiento;
	}
	/**
	 * asigna fecha de nacimiento del cliente
	 * @param nacimiento
	 */
	public void setNacimiento(String nacimiento) {
		this.nacimiento = nacimiento;
	}
	/**
	 * 
	 * @return nombre de usuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	/**
	 * asigna nombre de usuario a cliente
	 * @param nombreUsuario
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	/**
	 * constructor del cliente
	 * @param apellido
	 * @param dni
	 * @param codigo
	 * @param contrase�a
	 * @param nacimiento
	 * @param nombre
	 * @param nombreUsuario
	 */
	public Cliente(String apellido, String dni, String codigo, String contrase�a, String nacimiento, String nombre, String nombreUsuario) {
		super();
		this.apellido = apellido;
		this.dni = dni;
		this.codigo = codigo;
		this.contrase�a = contrase�a;
		this.nacimiento = nacimiento;
		this.nombre = nombre;
		this.nombreUsuario = nombreUsuario;
	}
	/**
	 * constructor vac�o de cliente
	 */
	public Cliente() {
		
	}
		

}
