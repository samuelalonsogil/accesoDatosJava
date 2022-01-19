package modeloVo;

import java.util.Date;

public class Vehiculo {
	private String matricula;
	private String marca;
	private String modelo;
	private String grupo;
	private int plazas;
	private int puertas;
	private int capacidad;
	private int edadMinima;
	private Date fecCompra;
	private int codOficina;
	private Boolean disponible;
	private int precio;
	public Vehiculo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Vehiculo(String matricula, String marca, String modelo, String grupo, int plazas, int puertas, int capacidad,
			int edadMinima, Date fecCompra, int codOficina, Boolean disponible, int precio) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.grupo = grupo;
		this.plazas = plazas;
		this.puertas = puertas;
		this.capacidad = capacidad;
		this.edadMinima = edadMinima;
		this.fecCompra = fecCompra;
		this.codOficina = codOficina;
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
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public int getPlazas() {
		return plazas;
	}
	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}
	public int getPuertas() {
		return puertas;
	}
	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public int getEdadMinima() {
		return edadMinima;
	}
	public void setEdadMinima(int edadMinima) {
		this.edadMinima = edadMinima;
	}
	public int getCodOficina() {
		return codOficina;
	}
	public void setCodOficina(int codOficina) {
		this.codOficina = codOficina;
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
	
	public Date getFecCompra() {
		return fecCompra;
	}

	public void setFecCompra(Date fecCompra) {
		this.fecCompra = fecCompra;
	}
	@Override
	public String toString() {
		return matricula + ", " + marca + ", " + modelo  +", precio=" + precio;
	}
	
	

}
