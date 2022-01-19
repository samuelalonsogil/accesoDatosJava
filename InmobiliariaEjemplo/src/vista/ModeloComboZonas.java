package vista;

import java.util.ArrayList;

import javax.swing.JComboBox;

import controlador.Controlador;
import modeloVo.Zonas;

public class ModeloComboZonas extends JComboBox<Zonas>{
	
	ArrayList<Zonas> zonas = new ArrayList<Zonas>();
	Controlador controlador = new Controlador();
	

	public ModeloComboZonas() {
		super();
		cargarZonas();
	}

	private void cargarZonas() {

		zonas = controlador.cargarZonas();
		for(Zonas zona : zonas) {
			this.addItem(zona);
		}
	}
}
