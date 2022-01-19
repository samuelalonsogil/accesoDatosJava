package modeloVo;

public class Inmuebles {
	private String codigo;
	private String direccion;
	private String codZona;
	private int estado;
	private String dniPropietario;
	private int superficie;
	private int numHabitaciones;
	private int numBanhos;
	private boolean terraza; // 1. SI 0. NO
	private boolean jardin; // 1. SI 0. NO
	private boolean piscina; // 1. SI 0. NO
	private boolean garaje; // 1. SI 0. NO
	private int precio;
	
	
	public Inmuebles() {
		super();
	}
	
	public Inmuebles(String codigo, String direccion, String codZona, int estado, String dniPropietario, int superficie,
			int numHabitaciones, int numBanhos, boolean terraza, boolean jardin, boolean piscina, boolean garaje,
			int precio) {
		super();
		this.codigo = codigo;
		this.direccion = direccion;
		this.codZona = codZona;
		this.estado = estado;
		this.dniPropietario = dniPropietario;
		this.superficie = superficie;
		this.numHabitaciones = numHabitaciones;
		this.numBanhos = numBanhos;
		this.terraza = terraza;
		this.jardin = jardin;
		this.piscina = piscina;
		this.garaje = garaje;
		this.precio = precio;
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

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getDniPropietario() {
		return dniPropietario;
	}

	public void setDniPropietario(String dniPropietario) {
		this.dniPropietario = dniPropietario;
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


	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return codigo +", " +direccion;
	}
	
	
	

}
