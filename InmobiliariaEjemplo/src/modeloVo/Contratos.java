package modeloVo;

import java.util.Date;

public class Contratos {
	private String codigo;
	private String dniInquilino;
	private String codInmueble;
	private Date fechaContrato;
	private Date fechaVencimiento;
	private double precio;
	
	// constructores
	public Contratos() {
		super();
	}


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






	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codContrato) {
		this.codigo = codContrato;
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
		return "Contratos [Codigo=" + codigo + ", dniInquilino="
				+ dniInquilino + ", codInmueble=" + codInmueble
				+ ", fechaContrato=" + fechaContrato + ", fechaVencimiento="
				+ fechaVencimiento + ", precio=" + precio + "]";
	}
	
	
	
	
	
	

}
