package controlador;

import java.util.ArrayList;

import logica.Logica;
import modeloDao.*;
import modeloVo.*;


public class Controlador {
	
	ContratoDao contratoDao = new ContratoDao();
	InquilinoDao inquilinoDao = new InquilinoDao();
	InmuebleDao inmuebleDao = new InmuebleDao();
	ZonasDao zonasDao = new ZonasDao();
	PropietarioDao propietarioDao = new PropietarioDao();
	
	Logica logica = new Logica();
	
	public ConsultaContrato consultaContrato(String codigo) {
		
		return contratoDao.consultaContrato(codigo);
	}
	public boolean validarNulo(String codigo) {
		
		return logica.validarNulo(codigo);
	}
	public ConsultaContrato consultaPrimero() {
		
		return contratoDao.consultaPrimero();
	}
	public ConsultaContrato consultaUltimo() {
		
		return contratoDao.consultaUltimo();
	}
	public ConsultaContrato consultaAnterior(String codigo) {
		// TODO Auto-generated method stub
		return contratoDao.consultaAnterior(codigo);
	}
	public ArrayList<Inquilinos> cargarInquilinos() {
		
		return inquilinoDao.cargarInquilinos();
	}
	public ArrayList<Inmuebles> cargarInmuebles() {
		
		return inmuebleDao.cargarInmuebles();
	}
	public boolean isDigito(char keyChar) {
		
		return logica.isDigito(keyChar);
	}
	public int insertarContrato(Contratos contrato) {
		
		return contratoDao.insertarContrato(contrato);
	}
	public ArrayList<Zonas> cargarZonas() {
		
		return zonasDao.cargarZonas();
	}
	public boolean actualizarPrecio(Zonas zona, String incremento) {
		return inmuebleDao.actualizarPrecio(zona, incremento);
		
	}
	public ArrayList<Propietario> cargarPropietarios() {
		
		return propietarioDao.cargarPropietarios();
	}
	public int modificarPropietario(Propietario propietario) {
		
		return propietarioDao.modificarPropietario(propietario);
	}
	public int eliminarPropietario(String dni) {
		
		return propietarioDao.eliminarPropietario(dni);
	}
	public ArrayList <Inmuebles> comprobarInmuebles(String dni) {
		return inmuebleDao.inmueblesPropietario(dni);
		
	}
	public ArrayList<InmueblesPropietarios> buscarInmuebles(String codigo, int tam, boolean pis, boolean gar,
			boolean jar) {
		
		return inmuebleDao.buscarInmuebles(codigo, tam, pis, gar,jar);
	}
	

}
