package controller;

import java.util.ArrayList;

import modeloDao.CuentaDAO;
import modeloVO.Cliente;
import modeloVO.Cuenta;
import modeloVO.CuentaCliente;
import modeloVO.Sucursal;

public class Controller {
	CuentaDAO cuentaDAO = new CuentaDAO();
	
	public ArrayList<Cliente> cargarClientes(){
		return cuentaDAO.cargarClientes();
	}
	
	public ArrayList<Sucursal> cargarSucursales(){
		return cuentaDAO.cargarSucursales();
	}
	
	public int newAccount(Cuenta cuenta, Cliente cliente) {
		return cuentaDAO.nuevaCuenta(cuenta, cliente);
	}

}
