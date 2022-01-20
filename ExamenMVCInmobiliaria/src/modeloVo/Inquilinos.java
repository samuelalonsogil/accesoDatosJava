package modeloVo;
public class Inquilinos {
	private String dni;
	private String nombre;
	private String direccion;
	private String ciudad;
	private int codPostal;
	private String telefono;
	private double salario;
	
	
	// constructores
	


	
	public Inquilinos
	(String dni, 
	String nombre, 
	String direccion, 
	String ciudad, 
	int codPostal, 
	String telefono,
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


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public double getSalario() {
		return salario;
	}


	public void setSalario(double salario) {
		this.salario = salario;
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



	@Override
	public String toString() {
		return nombre;
	}
	
	
	
	

}
