package modeloVo;

public class Propietario { 
	private String dni;
	private String nombre;
	private String apellidos;
	private String direccion;
	private String ciudad;
	private int codPostal;
	private String provincia;
	private String telefono;
	
	
	
	
	
	
	
	public Propietario(String dni, String nombre, String apellidos, String direccion, String ciudad, int codPostal,
			String provincia, String telefono) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.codPostal = codPostal;
		this.provincia = provincia;
		this.telefono = telefono;
	}
	public Propietario() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
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
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	@Override
	public String toString() {
		return "Propietario [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion="
				+ direccion + ", ciudad=" + ciudad + ", codPostal=" + codPostal + ", provincia=" + provincia
				+ ", telefono=" + telefono + "]";
	}

	
	
	

}
