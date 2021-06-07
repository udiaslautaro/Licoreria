package model;

public class Vino extends Bebida{
	

	
	private String tipo;
	private String bodega;
	private int año;
	
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
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
	public Vino(String graduacion, String marca, float capacidad, String nombre, int stock, String origen,
			String codigo, String tipo, String bodega, int año) {
		super(graduacion, marca, capacidad, nombre, stock, origen, codigo);
		}
}
