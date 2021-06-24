package model;

public class Licor extends Bebida{
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tipo;
	/**
	 * 
	 * @return devuelve tipo de licor
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * 
	 * @param tipo recibe el tipo de licor y lo asigna
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * constructor de la clase
	 * @param graduacion del licor
	 * @param marca del licor
	 * @param capacidad del licor
	 * @param nombre del licor
	 * @param stock unidades del licor en stock
	 * @param origen del licor
	 * @param codigoLicor del licor
	 * @param precio del licor
	 * @param tipo del licor
	 */
	public Licor(String graduacion, String marca, float capacidad, String nombre, int stock, String origen,
			int codigoLicor, double precio, String tipo) {
		super(graduacion, marca, capacidad, nombre, stock, origen, codigoLicor, precio);
		this.tipo = tipo;
	}

}
