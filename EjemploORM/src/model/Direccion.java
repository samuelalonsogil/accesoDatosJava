package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
}
