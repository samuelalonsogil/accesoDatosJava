package modeloVo;

import java.sql.Time;


public class Lote {
	
	private int codigo;
	private int precioSalida;
	private int pujaMax;
	private Time tiempo;
	private boolean adjudicado;
	public Lote() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Lote(int codigo, int precioSalida, int pujaMax, Time tiempo, boolean adjudicado) {
		super();
		this.codigo = codigo;
		this.precioSalida = precioSalida;
		this.pujaMax = pujaMax;
		this.tiempo = tiempo;
		this.adjudicado = adjudicado;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getPrecioSalida() {
		return precioSalida;
	}
	public void setPrecioSalida(int precioSalida) {
		this.precioSalida = precioSalida;
	}
	public int getPujaMax() {
		return pujaMax;
	}
	public void setPujaMax(int pujaMax) {
		this.pujaMax = pujaMax;
	}
	public Time getTiempo() {
		return tiempo;
	}
	public void setTiempo(Time time) {
		this.tiempo = time;
	}
	public boolean isAdjudicado() {
		return adjudicado;
	}
	public void setAdjudicado(boolean adjudicado) {
		this.adjudicado = adjudicado;
	}
	
}
