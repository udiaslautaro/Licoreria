package model;

public class Vino extends Bebida{
	

	
	private String tipo;
	private String bodega;
	private int a�o;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getBodega() {
		return bodega;
	}
	public void setBodega(String bodega) {
		this.bodega = bodega;
	}
	public int getA�o() {
		return a�o;
	}
	public void setA�o(int a�o) {
		this.a�o = a�o;
	}
	public Vino(String graduacion, String marca, float capacidad, String nombre, int stock, String origen,
			String codigo, String tipo, String bodega, int a�o) {
		super(graduacion, marca, capacidad, nombre, stock, origen, codigo);
		}
}
