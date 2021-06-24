package model;

public class Cerveza extends Bebida{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String variedad;

	/**
	 * asina un tipo de cerveza
	 * @param tipo
	 */
	public void setTipo(String tipo) {
		this.variedad = tipo;
	}
	
	/**
	 * constructor clase cerveza
	 * @param graduacion de la cerveza
	 * @param marca marca de la cerveza
	 * @param capacidad capacidad en litros de la cerveza
	 * @param nombre nombre de la cerveza
	 * @param stock stock de la cerveza
	 * @param origen de la cerveza
	 * @param codigoCerveza codigo de la cerveza
	 * @param precio precio por unidad de la cerveza
	 * @param Variedad variedad de la cerveza
	 */
	public Cerveza(String graduacion, String marca, float capacidad, String nombre, int stock, String origen,
			int codigoCerveza, double precio, String Variedad) {
		super(graduacion, marca, capacidad, nombre, stock, origen, codigoCerveza, precio);
		this.variedad = Variedad;
	}
	/**
	 * 
	 * @return devuelve variedad de cerveza
	 */
	public String getVariedad() {
		return variedad;
	}

		
	
	
}
