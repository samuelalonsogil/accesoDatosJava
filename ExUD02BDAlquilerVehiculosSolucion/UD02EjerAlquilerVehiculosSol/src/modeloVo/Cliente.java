package modeloVo;

public class Cliente {
	private String dni;
	private String nombre;
	private String direccion;
	private String ciudad;
	private int codPostal;
	private String provincia;
	private int telefono;
	private String numTarjeta;
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Cliente(String dni, String nombre, String direccion, String ciudad, int codPostal, String provincia,
			int telefono, String numTarjeta) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.codPostal = codPostal;
		this.provincia = provincia;
		this.telefono = telefono;
		this.numTarjeta = numTarjeta;
	}



	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(int codPostal) {
		this.codPostal = codPostal;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}



	public String getCiudad() {
		return ciudad;
	}



	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}



	@Override
	public String toString() {
		return dni + ",  " + nombre;
	}

	
	
	
	

}
