package vista;

import java.util.ArrayList;

import javax.swing.JComboBox;

import controlador.Controller;
import modeloVo.Zonas;

public class ModeloComboZonas extends JComboBox<Zonas>{
	
	ArrayList<Zonas> zonas = new ArrayList<Zonas>();
	Controller controller= new Controller();
	

	public ModeloComboZonas() {
		super();
		cargarZonas();
	}

	private void cargarZonas() {

		zonas = controller.getZonas();
		for(Zonas zona : zonas) {
			this.addItem(zona);
		}
	}
}
