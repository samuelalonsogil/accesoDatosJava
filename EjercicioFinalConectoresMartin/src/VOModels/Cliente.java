package VOModels;

public class Cliente {
	
	private int dni;
	private String nombre;
	private String apellidos;
	private long telefono;
	
	public Cliente(int dni, String nombre, String apellidos, long telefono) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
	}
	
	public int getDni() {
		return dni;
	}
	
	public void setDni(int dni) {
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
	
	public long getTelefono() {
		return telefono;
	}
	
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono
				+ "]";
	}
	
}
