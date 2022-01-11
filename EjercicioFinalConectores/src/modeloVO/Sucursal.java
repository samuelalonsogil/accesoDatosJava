package modeloVO;

public class Sucursal {
	int codSucursal;
	String ciudad;
	double activo;
	
	
	public Sucursal() {
		super();
	}
	public Sucursal(int codSucursal, String ciudad, double activo) {
		super();
		this.codSucursal = codSucursal;
		this.ciudad = ciudad;
		this.activo = activo;
	}
	public int getCodSucursal() {
		return codSucursal;
	}
	public void setCodSucursal(int codSucursal) {
		this.codSucursal = codSucursal;
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
	@Override
	public String toString() {
		return ciudad ;
	}
	
	
}
