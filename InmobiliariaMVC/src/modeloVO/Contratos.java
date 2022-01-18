package modeloVO;

import java.sql.Date;

public class Contratos {
	String codigo, dniInquilino, codInmueble;
	Date fechaContrato, fechaVencimiento;
	double precio;
	public Contratos(String codigo, String dniInquilino, String codInmueble, Date fechaContrato, Date fechaVencimiento,
			double precio) {
		super();
		this.codigo = codigo;
		this.dniInquilino = dniInquilino;
		this.codInmueble = codInmueble;
		this.fechaContrato = fechaContrato;
		this.fechaVencimiento = fechaVencimiento;
		this.precio = precio;
	}
	public Contratos() {
		super();
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDniInquilino() {
		return dniInquilino;
	}
	public void setDniInquilino(String dniInquilino) {
		this.dniInquilino = dniInquilino;
	}
	public String getCodInmueble() {
		return codInmueble;
	}
	public void setCodInmueble(String codInmueble) {
		this.codInmueble = codInmueble;
	}
	public Date getFechaContrato() {
		return fechaContrato;
	}
	public void setFechaContrato(Date fechaContrato) {
		this.fechaContrato = fechaContrato;
	}
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Contratos [codigo=" + codigo + ", dniInquilino=" + dniInquilino + ", codInmueble=" + codInmueble
				+ ", fechaContrato=" + fechaContrato + ", fechaVencimiento=" + fechaVencimiento + ", precio=" + precio
				+ "]";
	}
	
	
}
