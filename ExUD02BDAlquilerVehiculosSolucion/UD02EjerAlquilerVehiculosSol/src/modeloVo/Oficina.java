package modeloVo;

public class Oficina {
	private int  idOficina;
	private String direccion;
	private String ciudad;
	private String codPostal;
	private String provincia;
	private String telefono;
	public Oficina() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Oficina(int idOficina, String direccion, String ciudad, String codPostal, String provincia,
			String telefono) {
		super();
		this.idOficina = idOficina;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.codPostal = codPostal;
		this.provincia = provincia;
		this.telefono = telefono;
	}
	public int getIdOficina() {
		return idOficina;
	}
	public void setIdOficina(int idOficina) {
		this.idOficina = idOficina;
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
	public String getCodPostal() {
		return codPostal;
	}
	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	@Override
	public String toString() {
		return "Oficina [idOficina=" + idOficina + ", direccion=" + direccion + ", ciudad=" + ciudad + ", codPostal="
				+ codPostal + ", provincia=" + provincia + ", telefono=" + telefono + "]";
	}
	
	
	

}
 