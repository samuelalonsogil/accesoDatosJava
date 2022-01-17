package VOModels;

public class ClienteTransaccion {

	private int dni;
	private int numCuenta;
	private int saldo;
	private int codSucursal;
	
	public ClienteTransaccion(int dni, int numCuenta, int saldo, int codSucursal) {
		this.dni = dni;
		this.numCuenta = numCuenta;
		this.saldo = saldo;
		this.codSucursal = codSucursal;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(int numCuenta) {
		this.numCuenta = numCuenta;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	
	public int getCodSucursal() {
		return codSucursal;
	}
	
	public void setCodSucursal(int codSucursal) {
		this.codSucursal = codSucursal;
	}

	@Override
	public String toString() {
		return "ClienteTransaccion [dni=" + dni + ", numCuenta=" + numCuenta + ", saldo=" + saldo + "]";
	}
	
}
