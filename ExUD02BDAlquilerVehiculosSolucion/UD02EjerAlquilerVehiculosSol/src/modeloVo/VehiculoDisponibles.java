package modeloVo;

import java.util.Date;

public class VehiculoDisponibles {
	private String matricula;
	private String marca;
	private String modelo;
	private int antiguedad;
	private Boolean disponible;
	private int precio;
	
	public VehiculoDisponibles() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	

	public VehiculoDisponibles(String matricula, String marca, String modelo, int antiguedad, Boolean disponible,
			int precio) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.antiguedad = antiguedad;
		this.disponible = disponible;
		this.precio = precio;
	}





	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Boolean getDisponible() {
		return disponible;
	}
	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}





	@Override
	public String toString() {
		return "VehiculoDisponibles [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo
				+ ", antiguedad=" + antiguedad + ", disponible=" + disponible + ", precio=" + precio + "]";
	}
	
	
	
	
	

}
