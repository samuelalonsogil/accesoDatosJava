package modeloVo;

import java.util.Date;

public class VehiculoCliente {
	private String dni;
	private String matricula;
	private Date fecInicio;
	private int dias;
	private String seguro;
	public VehiculoCliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VehiculoCliente(String dni, String matricula, Date fecInicio, int dias, String seguro) {
		super();
		this.dni = dni;
		this.matricula = matricula;
		this.fecInicio = fecInicio;
		this.dias = dias;
		this.seguro = seguro;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public Date getFecInicio() {
		return fecInicio;
	}
	public void setFecInicio(Date fecInicio) {
		this.fecInicio = fecInicio;
	}
	public int getDias() {
		return dias;
	}
	public void setDias(int dias) {
		this.dias = dias;
	}
	public String getSeguro() {
		return seguro;
	}
	public void setSeguro(String seguro) {
		this.seguro = seguro;
	}
	@Override
	public String toString() {
		return "VehiculoCliente [dni=" + dni + ", matricula=" + matricula + ", fecInicio=" + fecInicio + ", dias="
				+ dias + ", seguro=" + seguro + "]";
	}
	
	

}
