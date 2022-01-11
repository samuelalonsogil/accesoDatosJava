package modeloVO;

public class CuentaCliente {
	String dni;
	int codCuenta;
	public CuentaCliente(String dni, int codCuenta) {
		super();
		this.dni = dni;
		this.codCuenta = codCuenta;
	}
	
	public CuentaCliente() {
		super();
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
	@Override
	public String toString() {
		return "CuentaCliente [dni=" + dni + ", codCuenta=" + codCuenta + "]";
	}
	
	

}
