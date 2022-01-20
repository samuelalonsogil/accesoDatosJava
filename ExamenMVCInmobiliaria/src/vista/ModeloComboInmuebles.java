package vista;

import java.util.ArrayList;

import javax.swing.JComboBox;

import controlador.Controller;
import modeloVo.Inmuebles;

public class ModeloComboInmuebles extends JComboBox<Inmuebles> {
	ArrayList <Inmuebles> inmuebles = null;
	Controller controller= new Controller();

	public ModeloComboInmuebles() {
		
		cargarInmuebles();
	}

	private void cargarInmuebles() {
		inmuebles = controller.cargarInmuebles();
		
		for(Inmuebles inmueble : inmuebles) {
			this.addItem(inmueble);
		}
		
		
	}
	
	

}
