package controlador;

import java.sql.Date;
import java.util.ArrayList;

import logic.Logic;
import modeloDao.ContratosDao;
import modeloDao.InmueblesDao;
import modeloDao.InquilinosDao;
import modeloDao.ZonasDao;
import modeloVo.Inmuebles;
import modeloVo.InmueblesPropietarios;
import modeloVo.Inquilinos;
import modeloVo.Zonas;
import utilidades.ConvertirFechas;

public class Controller {
	ZonasDao zonasDAO = new ZonasDao();
	Logic logic = new Logic();
	InmueblesDao inmueblesDao = new InmueblesDao();
	ConvertirFechas convertirFechas = new ConvertirFechas();
	ContratosDao contratosDao = new ContratosDao();
	InquilinosDao inquilinosDao = new InquilinosDao();
	
	public ArrayList<Inquilinos> cargarInquilinos(){
		return inquilinosDao.cargarInquilinos();
	}
	
	public int newContract
	(String code,String dni ,String codInmueble, Date fechaContrato, Date fechaVencimiento, double precio) { 
		return contratosDao.nuevoContrato(code, dni, codInmueble, fechaContrato, fechaVencimiento, precio);
	}
	
	public ArrayList<Inmuebles> cargarInmuebles(){
		return inmueblesDao.cargarInmuebles();
	}
	
	public ArrayList<InmueblesPropietarios> buscarInmuebles
	(String codeZona, int size, boolean pool, boolean garaje,boolean garden){
		return inmueblesDao.buscarInmuebles(codeZona, size, pool, garaje, garden);
	}
	
	public ArrayList<Inmuebles> cargarInmueblesPropietario(String dni){
		return inmueblesDao.cargarInmueblesPropietario(dni);
	}
	
	public ArrayList<Zonas> getZonas(){
		return zonasDAO.cargarZonas();
	}
	
	public boolean actualizarPrecio(String porcentaje, String codeZona) {
		return zonasDAO.actualizarPrecio(porcentaje, codeZona);
	}
	
	public boolean validateNull(String code) {
		return logic.validarNulo(code);
	}

	
	}
	
}
