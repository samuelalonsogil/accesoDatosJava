package controller;

import java.util.ArrayList;

import modeloDAO.ContratosDAO;
import modeloVO.Inquilinos;

public class Controller {
	ContratosDAO contratosDAO = new ContratosDAO();
	
	public ArrayList<Inquilinos> cargarBoxInquilinos(){
		return contratosDAO.cargarComboBoxInquilinos();
	}
}
