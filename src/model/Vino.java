package model;

public class Vino extends Bebida{
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tipo;
	private String bodega;
	private int a�o;
	/**
	 * 
	 * @return tipo de vino
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * asigna tipo al vino
	 * @param tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * 
	 * @return bodega del vino
	 */
	public String getBodega() {
		return bodega;
	}
	/**
	 * asigna bodega al vino
	 * @param bodega
	 */
	public void setBodega(String bodega) {
		this.bodega = bodega;
	}
	/**
	 * 
	 * @return a�o de produccion
	 */
	public int getA�o() {
		return a�o;
	}
	/**
	 * asigna a�o al vino
	 * @param a�o
	 */
	public void setA�o(int a�o) {
		this.a�o = a�o;
	}
	/**
	 * constructor del vino
	 * @param graduacion
	 * @param marca
	 * @param capacidad
	 * @param nombre
	 * @param stock
	 * @param origen
	 * @param codigo
	 * @param precio
	 * @param tipo
	 * @param bodega
	 * @param a�o
	 */
	public Vino(String graduacion, String marca, float capacidad, String nombre, int stock, String origen,
			int codigo, double precio, String tipo, String bodega, int a�o) {
		super(graduacion, marca, capacidad, nombre, stock, origen, codigo, precio);
		this.a�o = a�o;
		this.bodega = bodega;
		this.tipo = tipo;
		}
}
