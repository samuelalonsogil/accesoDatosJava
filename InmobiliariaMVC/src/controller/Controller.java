package controller;

import java.sql.Date;
import java.util.ArrayList;

import modeloDAO.ContratosDAO;
import modeloDAO.InmueblesDAO;
import modeloVO.Inmuebles;
import modeloVO.Inquilinos;

public class Controller {
	ContratosDAO contratosDAO = new ContratosDAO();
	InmueblesDAO inmueblesDAO = new InmueblesDAO();
	
	
	public ArrayList<Inquilinos> cargarBoxInquilinos(){
		return contratosDAO.cargarComboBoxInquilinos();
	}
	
	public ArrayList<Inmuebles> cargarBoxDirecciones(){
		return inmueblesDAO.cargarComboBoxDirecciones();
	}
	
	public int nuevoContrato(String code, String dni ,String codInmueble, Date fechaContrato, Date fechaVencimiento, double precio) {
		return contratosDAO.nuevoContrato(code,dni,codInmueble, fechaContrato, fechaVencimiento, precio);
	}
}
