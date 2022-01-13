package model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name = "Personas", schema = "UD03Hibernate", indexes = { @Index (name = "nbIndice", columnList = "peApellidos", unique = true) } )
@SequenceGenerator(name = "PersonaSeq", sequenceName = "id_Persona", initialValue = 1, allocationSize = 10)
@TableGenerator(name = "PersonaTable", initialValue = 1, pkColumnName = "Entity", pkColumnValue = "ID", allocationSize = 10, table = "Entity Generator")
public class Persona implements Serializable{
	
	@Id
	@Column(name = "peIdPersona")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	//@GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "PersonaSeq")
	//@GeneratedValue(strategy= GenerationType.TABLE, generator = "PersonaTable")
	private int idPersona;
	
	@Column(name = "peNombre", length = 15, nullable= false)
	private String nombre;
	
	@Column(name = "peApellidos", length = 45, nullable= false ,unique = true)
	String apellidos;
	
	@Column(name = "peSalario", scale = 2)
	private double salario;
	
	
	@Column(name = "peFechaNacimiento", updatable = false)
	@Temporal(TemporalType.DATE)
	private Calendar fechaNacimiento;
	
	@Column(name="peEstadoCivil", nullable = false, length = 12)
	@Enumerated(value = EnumType.STRING)
	private Estado estado;
	
	@Column(name = "peFoto")
	@Basic(fetch = FetchType.LAZY)
	@Lob
	private byte[] foto;
	
	public enum Estado{
		Casado, Divorciado, Soltero, Viudo
	}
	
	public Persona() {
		super();
	}

	public Persona(int idPersona, String nombre, String apellidos, double salario, Calendar fechaNacimiento,
			Estado estado) {
		super();
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.salario = salario;
		this.fechaNacimiento = fechaNacimiento;
		this.estado = estado;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apelllidos) {
		this.apellidos = apelllidos;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Calendar getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Calendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, estado, fechaNacimiento, idPersona, nombre, salario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(apellidos, other.apellidos) && estado == other.estado
				&& Objects.equals(fechaNacimiento, other.fechaNacimiento) && idPersona == other.idPersona
				&& Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(salario) == Double.doubleToLongBits(other.salario);
	}
	
	
	
	
	
	

}
