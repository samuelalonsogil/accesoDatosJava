package VOModels;

public class Sucursal {
	
	private int cod;
	private String ciudad;
	private int saldo;
	
	public Sucursal(int cod, String ciudad, int saldo) {
		this.cod = cod;
		this.ciudad = ciudad;
		this.saldo = saldo;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Sucursal [cod=" + cod + ", ciudad=" + ciudad + ", saldo=" + saldo + "]";
	}

}
