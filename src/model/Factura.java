package model;

public class Factura {

	private float monto;
	private String fecha;
	private String codigoCliente;
	private String medioDePago;
	private Pedido pedido;
	
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
	public Pedido getPedido() {
		return pedido;
	}
	
	private Factura(float monto, String fecha, String codigoCliente, String medioDePago, Pedido pedido) {
		super();
		this.monto = monto;
		this.fecha = fecha;
		this.codigoCliente = codigoCliente;
		this.medioDePago = medioDePago;
		this.pedido = pedido;
	}
	/* Constructor para Consumidor Final*/
	
	private Factura(float monto, String fecha, String medioDePago, Pedido pedido) {
		super();
		this.monto = monto;
		this.fecha = fecha;
		this.medioDePago = medioDePago;
		this.pedido = pedido;
	}
	
	//Realiza un interes de 10% si se paga con tarjeta.
	private float precioFinal() {
		float precio;
		
		if(medioDePago == "Tarjeta") {
			precio = (float) (monto * 1.1);
		}
		else {
			precio = monto;
		}
		return precio;
	}
	
	//Muestra Detalle factura
	@Override
	public String toString() {
		return "Factura [monto=" + monto + ", fecha=" + fecha + ", codigoCliente=" + codigoCliente + ", medioDePago="
				+ medioDePago + "]";
	}
	
	
	
}
