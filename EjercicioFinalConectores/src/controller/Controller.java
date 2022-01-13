package controller;

import java.util.ArrayList;

import modeloDao.CuentaDAO;
import modeloVO.Cliente;
import modeloVO.Cuenta;
import modeloVO.CuentaCliente;
import modeloVO.ListadoCuentas;
import modeloVO.Sucursal;

public class Controller {
	CuentaDAO cuentaDAO = new CuentaDAO();
	
	public ArrayList<Cliente> cargarClientes(){
		return cuentaDAO.cargarClientes();
	}
	
	public ArrayList<Sucursal> cargarSucursales(){
		return cuentaDAO.cargarSucursales();
	}
	
	public ArrayList<ListadoCuentas> cargarCuentas(String nombre, String apellidos){
		return cuentaDAO.cargarCuentas(nombre, apellidos);
	}
	
	public int newAccount(Cuenta cuenta, Cliente cliente) {
		return cuentaDAO.nuevaCuenta(cuenta, cliente);
	}
	
	public int modify(Cuenta cuenta, Cliente cliente) {
		return cuentaDAO.actualizar(cuenta, cliente);
	}
	
	public int deleteAccount(Cuenta cuenta, Cliente cliente) {
		return cuentaDAO.deleteAccount(cuenta, cliente);
	}
	
	/*public ArrayList<ListadoCuentas> listarCuentas(Cliente cliente){
		return cuentaDAO.cargarListadoCuentas(cliente);
	}*/

}
