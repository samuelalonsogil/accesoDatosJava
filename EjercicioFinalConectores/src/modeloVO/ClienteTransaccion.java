package modeloVO;

public class ClienteTransaccion {
	String dni;
	int codCuenta;
	double activos;
	
	public ClienteTransaccion(String dni, int codCuenta, double activos) {
		super();
		this.dni = dni;
		this.codCuenta = codCuenta;
		this.activos = activos;
	}

	public ClienteTransaccion() {
		super();
	}

	public ClienteTransaccion(int codCuenta, double activos) {
		super();
		this.codCuenta = codCuenta;
		this.activos = activos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getCodCuenta() {
		return codCuenta;
	}

	public void setCodCuenta(int codCuenta) {
		this.codCuenta = codCuenta;
	}

	public double getActivos() {
		return activos;
	}

	public void setActivos(double activos) {
		this.activos = activos;
	}
	
	
}
