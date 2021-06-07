package model;

public class Cerveza extends Bebida{

	private String variedad;


	public void setTipo(String tipo) {
		this.variedad = tipo;
	}

	private Cerveza(String graduacion, String marca, float capacidad, String nombre, int stock, String origen,
			String codigo, String Variedad) {
		super(graduacion, marca, capacidad, nombre, stock, origen, codigo);
	}

	public String getVariedad() {
		return variedad;
	}

		
	
	
}
