package controller;

import java.sql.Date;
import java.util.ArrayList;

import modeloDAO.ContratosDAO;
import modeloDAO.InmueblesDAO;
import modeloDAO.ZonasDAO;
import modeloVO.Inmuebles;
import modeloVO.Inquilinos;
import modeloVO.Zonas;

public class Controller {
	ContratosDAO contratosDAO = new ContratosDAO();
	InmueblesDAO inmueblesDAO = new InmueblesDAO();
	ZonasDAO zonasDAO = new ZonasDAO();
	
	public boolean actualizarPrecioZonas(String porcentaje, String codeZona) {
		return zonasDAO.actualizarPrecio(porcentaje, codeZona );
	}
	
	public ArrayList<Zonas> cargarZonas(){
		return zonasDAO.cargarZonas();
	}
	
	public ArrayList<Inquilinos> cargarInquilinos(){
		return contratosDAO.cargarInquilinos();
	}
	
	public ArrayList<Inmuebles> cargarInmuebles(){
		return inmueblesDAO.cargarInmuebles();
	}
	
	public int nuevoContrato(String code, String dni ,String codInmueble, Date fechaContrato, Date fechaVencimiento, double precio) {
		return contratosDAO.nuevoContrato(code,dni,codInmueble, fechaContrato, fechaVencimiento, precio);
	}
}
