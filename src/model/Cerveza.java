package model;

public class Cerveza extends Bebida{

	private String variedad;


	public void setTipo(String tipo) {
		this.variedad = tipo;
	}

	public Cerveza(String graduacion, String marca, float capacidad, String nombre, int stock, String origen,
			int codigoCerveza, double precio, String Variedad) {
		super(graduacion, marca, capacidad, nombre, stock, origen, codigoCerveza, precio);
		this.variedad = Variedad;
	}

	public String getVariedad() {
		return variedad;
	}

		
	
	
}
