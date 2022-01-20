package modeloVo;

import java.util.Date;

public class InmueblesPropietarios {
	private String codigoInmueble;
	private String direccion;
	private double precio;
	private boolean estado;
	private Date fechaVencimiento;
	private String propietario;
	private String telefono;
	
	public InmueblesPropietarios() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public InmueblesPropietarios(String codigoInmueble, String direccion, double precio, boolean estado, Date fechaVencimiento,
			String propietario, String telefono) {
		super(); 
		this.codigoInmueble = codigoInmueble;
		this.direccion = direccion;
		this.precio = precio;
		this.estado = estado;
		this.fechaVencimiento = fechaVencimiento;
		this.propietario = propietario;
		this.telefono = telefono;
	}

	public String getCodigoInmueble() {
		return codigoInmueble;
	}


	public void setCodigoInmueble(String codigoInmueble) {
		this.codigoInmueble = codigoInmueble;
	}


	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	

	public boolean isEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}


	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}


	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}


	@Override
	public String toString() {
		return "InmueblesPropietarios [direccion=" + direccion + ", precio="
				+ precio + ", propietario=" + propietario + ", telefono="
				+ telefono + "]";
	}
	
}
