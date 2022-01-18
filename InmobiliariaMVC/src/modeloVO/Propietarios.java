package modeloVO;

public class Propietarios {
	String dni, nombre, apellidos, direccion, provincia;
	int codPostal, telefono;
	
	
	public Propietarios(String dni, String nombre, String apellidos, String direccion, String provincia, int codPostal,int telefono) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.provincia = provincia;
		this.codPostal = codPostal;
		this.telefono = telefono;
	}
	public Propietarios() {
		super();
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
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public int getCodPostal() {
		return codPostal;
	}
	public void setCodPostal(int codPostal) {
		this.codPostal = codPostal;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	@Override
	public String toString() {
		return "Propietarios [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion="
				+ direccion + ", provincia=" + provincia + ", codPostal=" + codPostal + ", telefono=" + telefono + "]";
	}
	
	

}
