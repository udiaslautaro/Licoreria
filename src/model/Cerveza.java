package model;

public class Cerveza extends Bebida{

	private String variedad;


	public void setTipo(String tipo) {
		this.variedad = tipo;
	}

	public Cerveza(String graduacion, String marca, float capacidad, String nombre, int stock, String origen,
			String codigo, double precio, String Variedad) {
		super(graduacion, marca, capacidad, nombre, stock, origen, codigo, precio);
		this.variedad = Variedad;
	}

	public String getVariedad() {
		return variedad;
	}

		
	
	
}
