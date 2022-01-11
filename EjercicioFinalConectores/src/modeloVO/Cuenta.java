package modeloVO;

import java.sql.Date;

public class Cuenta {
	
	int codCuenta, codSucursal, saldo;
	Date fechaCreacion;
	
	public Cuenta(int codCuenta, int codSucursal, int saldo, Date fechaCreacion) {
		super();
		this.codCuenta = codCuenta;
		this.codSucursal = codSucursal;
		this.saldo = saldo;
		this.fechaCreacion = fechaCreacion;
	}

	public Cuenta() {
		super();
	}

	public int getCodCuenta() {
		return codCuenta;
	}

	public void setCodCuenta(int codCuenta) {
		this.codCuenta = codCuenta;
	}

	public int getCodSucursal() {
		return codSucursal;
	}

	public void setCodSucursal(int codSucursal) {
		this.codSucursal = codSucursal;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Cuenta [codCuenta=" + codCuenta + ", codSucursal=" + codSucursal + ", saldo=" + saldo
				+ ", fechaCreacion=" + fechaCreacion + "]";
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	

}
