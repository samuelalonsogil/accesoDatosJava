package modeloVO;

import java.sql.Date;

public class Transaccion {
	int codCuenta, cantidad;
	Date fechaCreacion;
	String tipo;
	public Transaccion(int codCuenta, int cantidad, Date fechaCreacion, String tipo) {
		super();
		this.codCuenta = codCuenta;
		this.cantidad = cantidad;
		this.fechaCreacion = fechaCreacion;
		this.tipo = tipo;
	}
	public int getCodCuenta() {
		return codCuenta;
	}
	public void setCodCuenta(int codCuenta) {
		this.codCuenta = codCuenta;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		return "Transaccion [codCuenta=" + codCuenta + ", cantidad=" + cantidad + ", fechaCreacion=" + fechaCreacion
				+ ", tipo=" + tipo + "]";
	}
	
	
}
