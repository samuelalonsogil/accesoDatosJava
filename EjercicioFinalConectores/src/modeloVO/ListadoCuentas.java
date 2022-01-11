package modeloVO;

public class ListadoCuentas {
	int codSucursal, codCuenta;
	String ciudad;
	double activo;
	
	public ListadoCuentas() {
		super();
	}

	public ListadoCuentas(int codSucursal, int codCuenta, String ciudad, double activo) {
		super();
		this.codSucursal = codSucursal;
		this.codCuenta = codCuenta;
		this.ciudad = ciudad;
		this.activo = activo;
	}

	public int getCodSucursal() {
		return codSucursal;
	}

	public void setCodSucursal(int codSucursal) {
		this.codSucursal = codSucursal;
	}

	public int getCodCuenta() {
		return codCuenta;
	}

	public void setCodCuenta(int codCuenta) {
		this.codCuenta = codCuenta;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public double getActivo() {
		return activo;
	}

	public void setActivo(double activo) {
		this.activo = activo;
	}
	
	
}
