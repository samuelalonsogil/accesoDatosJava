package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Direcciones")
public class Direccion {
	@Id
	@Column(name = "diId")
	private int id;
	
	@Column(name = "diDireccion", nullable = false, length = 40)
	private String direccion;
	
	@Column(name = "diCiudad", nullable = false, length = 40)
	private String ciudad;
	
	@Column(name = "diProvincia", nullable = false, length = 40)
	private String provincia;

	
	public Direccion() {
		super();
	}

	public Direccion(int id, String direccion, String ciudad, String provincia) {
		super();
		this.id = id;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.provincia = provincia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	
}
