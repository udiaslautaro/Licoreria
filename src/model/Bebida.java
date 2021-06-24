package model;

import java.io.Serializable;

public class Bebida implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String graduacion;
	private String marca;
	private float capacidad;
	private String nombre;
	private int stock;
	private String origen;
	private int codigo;
	private double precio;
	private int cantidad;
	
	
	/**
	 * constructor de la clase bebida
	 * @param graduacion de la bebida
	 * @param marca de la bebida
	 * @param capacidad de la bebida
	 * @param nombre de la bebida
	 * @param stock cantidad de bebidas que se dispone
	 * @param origen país de origen de la bebida
	 * @param codigo2 de la bebida
	 * @param precio de la bebida x unidad
	 */
	public Bebida(String graduacion, String marca, float capacidad, String nombre, int stock, String origen,
			int codigo2, double precio) {
		super();
		this.graduacion = graduacion;
		this.marca = marca;
		this.capacidad = capacidad;
		this.nombre = nombre;
		this.stock = stock;
		this.origen = origen;
		this.codigo = codigo2;
		this.precio = precio;
	}
	/**
	 * 
	 * @return graduacion de la bebida
	 */
	public String getGraduacion() {
		return graduacion;
	}
	/**
	 * asigna una graduacion a la bebida
	 * @param graduacion
	 */
	public void setGraduacion(String graduacion) {
		this.graduacion = graduacion;
	}
	/**
	 * 
	 * @return devuelve la marca de la bebida
	 */
	public String getMarca() {
		return marca;
	}
	/**
	 * asigna un valor a la marca de la bebida
	 * @param marca de la bebida
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}
	/**
	 * 
	 * @return devuelve la capacidad de la bebida en litros
	 */
	public float getCapacidad() {
		return capacidad;
	}
	/**
	 * asigna un valor a la capacidad de la bebida en litros
	 * @param capacidad en litros de la bebida
	 */
	public void setCapacidad(float capacidad) {
		this.capacidad = capacidad;
	}
	/**
	 * 
	 * @return nombre de la bebida
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * recibe nombre de la bebida y la asigna
	 * @param nombre de la bebida
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * 
	 * @return stock actual de la bebida
	 */
	public int getStock() {
		return stock;
	}
	/**
	 * asigna un stock a la bebida
	 * @param stock
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}
	/**
	 * 
	 * @return devuelve país de origen de la bebida
	 */
	public String getOrigen() {
		return origen;
	}
	/**
	 * asigna un país de origen a la bebida
	 * @param origen de la bebida
	 */
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	/**
	 * 
	 * @return codigo de la bebida
	 */
	public int getCodigo() {
		return codigo;
	}
	/**
	 * asigna un codigo a la bebida
	 * @param codigo
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	/**
	 * 
	 * @return devuelve precio de la unidad de bebida
	 */
	public double getPrecio() {
		return precio;
	}
	/**
	 * asina precio por unidad de la bebida
	 * @param precio por unidad
	 */
	public void setPrecio (double precio) {
		this.precio = precio;
	}
	/**
	 * cantidad que se solicita de bebida
	 * @param cantidad
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * 
	 * @return cantidad de bebidas solicitadas
	 */
	public int getCantidad() {
		return cantidad;
	}
	@Override
	
	public String toString() {
		return "Bebida [graduacion=" + graduacion + ", marca=" + marca + ", capacidad=" + capacidad + ", nombre="
				+ nombre + ", stock=" + stock + ", origen=" + origen + ", codigo=" + codigo + "]\n";
	}
	
	/**
	 * al realizar pedido resta las unidades del stock 
	 * @param cantidadUnidades unidades que se pidieronde la bebida
	 */
	public void restarStock(int cantidadUnidades) {
		this.setStock(stock - cantidadUnidades);
	}
	/**
	 * al cancelar pedido suma las unidades al stock
	 * @param cantidadUnidades unidades que se devuelven de la bebida
	 */
	public void sumarStock(int cantidadUnidades) {
		this.setStock(stock +cantidadUnidades);
	}
	/**
	 * 
	 * @return información de las bebidas
	 */
	public String infoBebida() {
		return "Codigo: "+codigo + "Nombre: "+nombre+"Marca: "+marca+"Capacidad: "+capacidad+"Precio: "+precio+"\n";
	}
	/**
	 * 
	 * @param cantidad
	 * @return precio total por cantidad de bebidas solicitadas
	 */
	public double precioPorCantidad(int cantidad) {
		return this.precio*cantidad;
	}
}
