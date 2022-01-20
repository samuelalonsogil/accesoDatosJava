package vista;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

import controlador.Controller;
import modeloVo.Inquilinos;

public class ModeloComboInquilinos extends JComboBox<Inquilinos> {
	
	ArrayList <Inquilinos> inquilinos = null;
	
	Controller controller= new Controller();

	public ModeloComboInquilinos() {
		cargarInquilinos();
	}

	private void cargarInquilinos() {
		inquilinos = controller.cargarInquilinos();
		
		for(Inquilinos inquilino : inquilinos) {
			this.addItem(inquilino);
		}
		
	}
	
	
	

}
