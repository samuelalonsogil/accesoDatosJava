package modeloVO;

import java.sql.Date;

public class ListaContratos {
	String codigoCuenta, nombreInquilino, direccion, nombrePropietario, apellidosNombre;
	Date fechaContrato, fechaVencimiento;
	double precio;
	
	public ListaContratos() {
		
	}

	public ListaContratos(String codigoCuenta, String nombreInquilino, String direccion, String nombrePropietario,
			String apellidosNombre, Date fechaContrato, Date fechaVencimiento, double precio) {
		
		this.codigoCuenta = codigoCuenta;
		this.nombreInquilino = nombreInquilino;
		this.direccion = direccion;
		this.nombrePropietario = nombrePropietario;
		this.apellidosNombre = apellidosNombre;
		this.fechaContrato = fechaContrato;
		this.fechaVencimiento = fechaVencimiento;
		this.precio = precio;
	}

	public String getCodigoCuenta() {
		return codigoCuenta;
	}

	public void setCodigoCuenta(String codigoCuenta) {
		this.codigoCuenta = codigoCuenta;
	}

	public String getNombreInquilino() {
		return nombreInquilino;
	}

	public void setNombreInquilino(String nombreInquilino) {
		this.nombreInquilino = nombreInquilino;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombrePropietario() {
		return nombrePropietario;
	}

	public void setNombrePropietario(String nombrePropietario) {
		this.nombrePropietario = nombrePropietario;
	}

	public String getApellidosNombre() {
		return apellidosNombre;
	}

	public void setApellidosNombre(String apellidosNombre) {
		this.apellidosNombre = apellidosNombre;
	}

	public Date getFechaContrato() {
		return fechaContrato;
	}

	public void setFechaContrato(Date fechaContrato) {
		this.fechaContrato = fechaContrato;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "ListaContratos [codigoCuenta=" + codigoCuenta + ", nombreInquilino=" + nombreInquilino + ", direccion="
				+ direccion + ", nombrePropietario=" + nombrePropietario + ", apellidosNombre=" + apellidosNombre
				+ ", fechaContrato=" + fechaContrato + ", fechaVencimiento=" + fechaVencimiento + ", precio=" + precio
				+ "]";
	}
	
	
}
