package modeloVO;

public class Zonas {
	String codigo, nombre;

	public Zonas(String codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public Zonas() {
		super();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Zonas [codigo=" + codigo + ", nombre=" + nombre + "]";
	}
	
	
}
