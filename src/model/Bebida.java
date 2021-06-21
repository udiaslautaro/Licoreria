package model;

public class Bebida {

	private String graduacion;
	private String marca;
	private float capacidad;
	private String nombre;
	private int stock;
	private String origen;
	private String codigo;
	private double precio;
	private int cantidad;
	
	
	
	public Bebida(String graduacion, String marca, float capacidad, String nombre, int stock, String origen,
			String codigo, double precio) {
		super();
		this.graduacion = graduacion;
		this.marca = marca;
		this.capacidad = capacidad;
		this.nombre = nombre;
		this.stock = stock;
		this.origen = origen;
		this.codigo = codigo;
		this.precio = precio;
	}
	public String getGraduacion() {
		return graduacion;
	}
	public void setGraduacion(String graduacion) {
		this.graduacion = graduacion;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public float getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(float capacidad) {
		this.capacidad = capacidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio (double precio) {
		this.precio = precio;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getCantidad() {
		return cantidad;
	}
	@Override
	
	public String toString() {
		return "Bebida [graduacion=" + graduacion + ", marca=" + marca + ", capacidad=" + capacidad + ", nombre="
				+ nombre + ", stock=" + stock + ", origen=" + origen + ", codigo=" + codigo + "]\n";
	}
	
	public void restarStock(int cantidadUnidades) {
		this.setStock(stock - cantidadUnidades);
	}
	
	public void sumarStock(int cantidadUnidades) {
		this.setStock(stock +cantidadUnidades);
	}
	
	public String infoBebida() {
		return "Codigo: "+codigo + "Nombre: "+nombre+"Marca: "+marca+"Capacidad: "+capacidad+"Precio: "+precio+"\n";
	}
	public double precioPorCantidad(int cantidad) {
		return this.precio*cantidad;
	}
}
