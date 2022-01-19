package vista;

import java.util.ArrayList;

import javax.swing.JComboBox;

import controlador.Controlador;
import modeloVo.Inmuebles;

public class ModeloComboInmuebles extends JComboBox<Inmuebles> {
	ArrayList <Inmuebles> inmuebles = null;
	Controlador controlador = new Controlador();

	public ModeloComboInmuebles() {
		
		cargarInmuebles();
	}

	private void cargarInmuebles() {
		inmuebles = controlador.cargarInmuebles();
		
		for(Inmuebles inmueble : inmuebles) {
			this.addItem(inmueble);
		}
		
		
	}
	
	

}
