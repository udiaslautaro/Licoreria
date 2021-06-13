package model;

public class Cliente {

	private String apellido;
	private String dni;
	private String codigo; 
	private String contraseña;
	private String nacimiento;
	private String nombre;
	private String nombreUsuario;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getNacimiento() {
		return nacimiento;
	}
	public void setNacimiento(String nacimiento) {
		this.nacimiento = nacimiento;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	private Cliente(String apellido, String dni, String codigo, String contraseña, String nacimiento, String nombre, String nombreUsuario) {
		super();
		this.apellido = apellido;
		this.dni = dni;
		this.codigo = codigo;
		this.contraseña = contraseña;
		this.nacimiento = nacimiento;
		this.nombre = nombre;
		this.nombreUsuario = nombreUsuario;
	}
	
	public Cliente() {
		
	}
	
	

}
