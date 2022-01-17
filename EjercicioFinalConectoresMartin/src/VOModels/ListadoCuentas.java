package VOModels;

public class ListadoCuentas {
	
	private int codCuenta;
	private int codSucursal;
	private String nomSucursal;
	private long saldo;
	
	public ListadoCuentas(int codCuenta, int codSucursal, String nomSucursal, long saldo) {
		this.codCuenta = codCuenta;
		this.codSucursal = codSucursal;
		this.nomSucursal = nomSucursal;
		this.saldo = saldo;
	}

	public ListadoCuentas(int codCuenta, int codSucursal, long saldo) {
		super();
		this.codCuenta = codCuenta;
		this.codSucursal = codSucursal;
		this.saldo = saldo;
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

	public String getNomSucursal() {
		return nomSucursal;
	}

	public void setNomSucursal(String nomSucursal) {
		this.nomSucursal = nomSucursal;
	}

	public long getSaldo() {
		return saldo;
	}

	public void setSaldo(long saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "ListadoCuentas [codCuenta=" + codCuenta + ", codSucursal=" + codSucursal + ", nomSucursal="
				+ nomSucursal + ", saldo=" + saldo + "]";
	}

	
}
