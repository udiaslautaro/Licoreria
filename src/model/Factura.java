package model;

import java.util.Date;

public class Factura {

	private float monto;
	private Date fecha;
	private String codigoCliente;
	private int medioDePago;
	private Pedido pedido;
	
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public int getMedioDePago() {
		return medioDePago;
	}
	public void setMedioDePago(int medioDePago) {
		this.medioDePago = medioDePago;
	}
	public Pedido getPedido() {
		return pedido;
	}
	
	public Factura(float monto, Date fecha, String codigoCliente, int medioDePago, Pedido pedido) {
		super();
		this.monto = monto;
		this.fecha = fecha;
		this.codigoCliente = codigoCliente;
		this.medioDePago = medioDePago;
		this.pedido = pedido;
	}
	/* Constructor para Consumidor Final*/
	
	public Factura(float monto, Date fecha, int medioDePago, Pedido pedido) {
		super();
		this.monto = monto;
		this.fecha = fecha;
		this.medioDePago = medioDePago;
		this.pedido = pedido;		
	}


	//Realiza un interes de 10% si se paga con tarjeta.
	public float precioFinal() {
		float precio;
		if(medioDePago == 1) {
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
		return "Factura [Fecha =" +fecha+ "Monto Total=" + monto + ", medioDePago="
				+ medioDePago +", Precio Final" + precioFinal() + "]";
	}
	
	
	
}
