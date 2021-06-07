package model;

public class Factura {

	private float monto;
	private String fecha;
	private String codigoCliente;
	private String medioDePago;
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public String getMedioDePago() {
		return medioDePago;
	}
	public void setMedioDePago(String medioDePago) {
		this.medioDePago = medioDePago;
	}
	
	private Factura(float monto, String fecha, String codigoCliente, String medioDePago) {
		super();
		this.monto = monto;
		this.fecha = fecha;
		this.codigoCliente = codigoCliente;
		this.medioDePago = medioDePago;
	}
	/* Constructor para Consumidor Final*/
	
	private Factura(float monto, String fecha, String medioDePago) {
		super();
		this.monto = monto;
		this.fecha = fecha;
		this.medioDePago = medioDePago;
	}
	

	
}
