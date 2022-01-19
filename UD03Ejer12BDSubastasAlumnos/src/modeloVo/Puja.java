package modeloVo;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.Timer;

public class Puja {
	private int coLote ;
	private String usuario;
	private Date fechaHora;
	private int cantidad;
	
	public Puja() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Puja(int coLote, String usuario, Date fechaHora, int cantidad) {
		super();
		this.coLote = coLote;
		this.usuario = usuario;
		this.fechaHora = fechaHora;
		this.cantidad = cantidad;
	}

	public int getCoLote() {
		return coLote;
	}

	public void setCoLote(int coLote) {
		this.coLote = coLote;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	
	
	
	
	
	

}
