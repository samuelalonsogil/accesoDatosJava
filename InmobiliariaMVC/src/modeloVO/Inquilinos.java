package modeloVO;

public class Inquilinos {
	String dni, nombre, direccion, ciudad;
	int codPostal, telefono;
	double salario;
	public Inquilinos(String dni, String nombre, String direccion, String ciudad, int codPostal, int telefono,
			double salario) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.codPostal = codPostal;
		this.telefono = telefono;
		this.salario = salario;
	}
	public Inquilinos() {
		super();
	}
	
	
	
	public Inquilinos(String dni, String nombre) {
		super();
		this.dni = dni;
		this.nombre = nombre;
	}
	public Inquilinos(String nombre) {
		super();
		this.nombre = nombre;
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
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	@Override
	public String toString() {
		return "Inquilinos [dni=" + dni + ", nombre=" + nombre + ", direccion=" + direccion + ", ciudad=" + ciudad
				+ ", codPostal=" + codPostal + ", telefono=" + telefono + ", salario=" + salario + "]";
	}
	
	
}
