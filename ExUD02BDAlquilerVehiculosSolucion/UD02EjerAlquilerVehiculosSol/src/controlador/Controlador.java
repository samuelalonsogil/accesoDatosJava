package controlador;

import java.util.ArrayList;

import logica.Logica;
import modeloDao.ClienteDao;
import modeloDao.VehiculoDao;
import modeloVo.Cliente;
import modeloVo.Vehiculo;
import modeloVo.VehiculoCliente;
import modeloVo.VehiculoDisponibles;
import vista.Form01Alquileres;
import vista.Form02ClienteNuevo;

public class Controlador {
	
	// se instancian los formularios para poder relacionarlos y que no se creen cada vez
	
	private Form01Alquileres form01Alquileres;
	private Form02ClienteNuevo form02CliNuevo;
	
	private Logica logica;
	
	private ClienteDao clienteDao = new ClienteDao();
	private VehiculoDao vehiculoDao = new VehiculoDao();

	
	// creamos los getters y setters

	public Form01Alquileres getForm01Alquileres() {
		return form01Alquileres;
	}

	public void setForm01Alquileres(Form01Alquileres form01Alquileres) {
		this.form01Alquileres = form01Alquileres;
	}

	public Form02ClienteNuevo getForm02CliNuevo() {
		return form02CliNuevo;
	}

	public void setForm02CliNuevo(Form02ClienteNuevo form02CliNuevo) {
		this.form02CliNuevo = form02CliNuevo;
	}

	public Logica getLogica() {
		return logica;
	}

	public void setLogica(Logica logica) {
		this.logica = logica;
	}

	public void mostrarNuevoCliente() {
		form02CliNuevo.setVisible(true);
		
	}

	public ArrayList<Cliente> cargarClientes() {
		
		return clienteDao.cargarClientes();
	}

	public boolean validarNulo(String text) {
		return logica.validarNulo(text);
	}

	public boolean isDigitte(char keyChar) {
		return logica.isDigitte(keyChar);
	}

	public boolean comprobarLongitud(int length, int i) {
		
		return logica.comprobarLongitud(length, i);
	}

	public Cliente consultarCliente(String dni) {
		
		return clienteDao.consultarCliente(dni);
	}

	public int nuevoCliente(Cliente cliente) {
		
		return clienteDao.nuevoCliente(cliente);
	}

	public ArrayList<Vehiculo> cargarVehiculosDisponibles() {
		
		return vehiculoDao.cargarVehiculosDisponibles();
	}

	public ArrayList<VehiculoDisponibles> cargarVehiculosDisponibles(String plazas, String puertas, String capacidad,
			String antiguedad, String precio) {
		return vehiculoDao.cargarVehiculosDisponibles(plazas, puertas, capacidad, antiguedad, precio);
	}

	public int nuevoNuevoAlquiler(VehiculoCliente vehCli) {
		
		return vehiculoDao.nuevoNuevoAlquiler(vehCli);
	}
	


	
	
	

	

	
	



	
	

}
