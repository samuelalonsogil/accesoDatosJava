package modeloVo;

public class Producto {

	private int codigo;
	private String nombre;
	private String descripcion;
	private int codLote;
	private String categgoria;
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Producto(int codigo, String nombre, String descripcion, int codLote, String categgoria) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.codLote = codLote;
		this.categgoria = categgoria;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCodLote() {
		return codLote;
	}
	public void setCodLote(int codLote) {
		this.codLote = codLote;
	}
	public String getCateggoria() {
		return categgoria;
	}
	public void setCateggoria(String categgoria) {
		this.categgoria = categgoria;
	}
	
	
	
}
