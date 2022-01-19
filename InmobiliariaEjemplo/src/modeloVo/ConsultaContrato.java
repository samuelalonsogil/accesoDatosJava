package modeloVo;

import java.util.Date;

public class ConsultaContrato {
	private String codContrato;
	private String dniInquilino;
	private String nbInquilino;
	private String direccion;
	private String dniPropietario;
	private String nbPropietario;
	private Date fecContrato;
	private Date fecVencimiento;
	private double precio;
	
	public ConsultaContrato() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ConsultaContrato(String codContrato, String dniInquilino, String nbInquilino, String direccion,
			String dniPropietario, String nbPropietario, Date fecContrato, Date fecVencimiento, double precio) {
		super();
		this.codContrato = codContrato;
		this.dniInquilino = dniInquilino;
		this.nbInquilino = nbInquilino;
		this.direccion = direccion;
		this.dniPropietario = dniPropietario;
		this.nbPropietario = nbPropietario;
		this.fecContrato = fecContrato;
		this.fecVencimiento = fecVencimiento;
		this.precio = precio;
	}
	public String getCodContrato() {
		return codContrato;
	}
	public void setCodContrato(String codContrato) {
		this.codContrato = codContrato;
	}
	public String getDniInquilino() {
		return dniInquilino;
	}
	public void setDniInquilino(String dniInquilino) {
		this.dniInquilino = dniInquilino;
	}
	public String getNbInquilino() {
		return nbInquilino;
	}
	public void setNbInquilino(String nbInquilino) {
		this.nbInquilino = nbInquilino;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getDniPropietario() {
		return dniPropietario;
	}
	public void setDniPropietario(String dniPropietario) {
		this.dniPropietario = dniPropietario;
	}
	public String getNbPropietario() {
		return nbPropietario;
	}
	public void setNbPropietario(String nbPropietario) {
		this.nbPropietario = nbPropietario;
	}
	public Date getFecContrato() {
		return fecContrato;
	}
	public void setFecContrato(Date fecContrato) {
		this.fecContrato = fecContrato;
	}
	public Date getFecVencimiento() {
		return fecVencimiento;
	}
	public void setFecVencimiento(Date fecVencimiento) {
		this.fecVencimiento = fecVencimiento;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	
	

}
