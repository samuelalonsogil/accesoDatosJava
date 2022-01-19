package modeloVO;

public class Inmuebles {
	String codigo,direccion, codZona, dniPropietario;
	boolean estado, terraza, jardin, piscina, garaje;
	int superficie,numHabitaciones,numBanhos, precio;
	public Inmuebles(String codigo, String direccion, String codZona, String dniPropietario, boolean estado,
			boolean terraza, boolean jardin, boolean piscina, boolean garaje, int superficie, int numHabitaciones,
			int numBanhos, int precio) {
		super();
		this.codigo = codigo;
		this.direccion = direccion;
		this.codZona = codZona;
		this.dniPropietario = dniPropietario;
		this.estado = estado;
		this.terraza = terraza;
		this.jardin = jardin;
		this.piscina = piscina;
		this.garaje = garaje;
		this.superficie = superficie;
		this.numHabitaciones = numHabitaciones;
		this.numBanhos = numBanhos;
		this.precio = precio;
	}
	public Inmuebles() {
		super();
	}
	
	
	public Inmuebles(String direccion) {
		super();
		this.direccion = direccion;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCodZona() {
		return codZona;
	}
	public void setCodZona(String codZona) {
		this.codZona = codZona;
	}
	public String getDniPropietario() {
		return dniPropietario;
	}
	public void setDniPropietario(String dniPropietario) {
		this.dniPropietario = dniPropietario;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public boolean isTerraza() {
		return terraza;
	}
	public void setTerraza(boolean terraza) {
		this.terraza = terraza;
	}
	public boolean isJardin() {
		return jardin;
	}
	public void setJardin(boolean jardin) {
		this.jardin = jardin;
	}
	public boolean isPiscina() {
		return piscina;
	}
	public void setPiscina(boolean piscina) {
		this.piscina = piscina;
	}
	public boolean isGaraje() {
		return garaje;
	}
	public void setGaraje(boolean garaje) {
		this.garaje = garaje;
	}
	public int getSuperficie() {
		return superficie;
	}
	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
	public int getNumHabitaciones() {
		return numHabitaciones;
	}
	public void setNumHabitaciones(int numHabitaciones) {
		this.numHabitaciones = numHabitaciones;
	}
	public int getNumBanhos() {
		return numBanhos;
	}
	public void setNumBanhos(int numBanhos) {
		this.numBanhos = numBanhos;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Inmuebles [codigo=" + codigo + ", direccion=" + direccion + ", codZona=" + codZona + ", dniPropietario="
				+ dniPropietario + ", estado=" + estado + ", terraza=" + terraza + ", jardin=" + jardin + ", piscina="
				+ piscina + ", garaje=" + garaje + ", superficie=" + superficie + ", numHabitaciones=" + numHabitaciones
				+ ", numBanhos=" + numBanhos + ", precio=" + precio + "]";
	}
	
	
}
