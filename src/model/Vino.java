package model;

public class Vino extends Bebida{
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tipo;
	private String bodega;
	private int año;
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
	 * @return año de produccion
	 */
	public int getAño() {
		return año;
	}
	/**
	 * asigna año al vino
	 * @param año
	 */
	public void setAño(int año) {
		this.año = año;
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
	 * @param año
	 */
	public Vino(String graduacion, String marca, float capacidad, String nombre, int stock, String origen,
			int codigo, double precio, String tipo, String bodega, int año) {
		super(graduacion, marca, capacidad, nombre, stock, origen, codigo, precio);
		this.año = año;
		this.bodega = bodega;
		this.tipo = tipo;
		}
}
