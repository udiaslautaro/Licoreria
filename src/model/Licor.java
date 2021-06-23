package model;

public class Licor extends Bebida{
	


	private String tipo;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Licor(String graduacion, String marca, float capacidad, String nombre, int stock, String origen,
			int codigoLicor, double precio, String tipo) {
		super(graduacion, marca, capacidad, nombre, stock, origen, codigoLicor, precio);
		this.tipo = tipo;
	}

}
