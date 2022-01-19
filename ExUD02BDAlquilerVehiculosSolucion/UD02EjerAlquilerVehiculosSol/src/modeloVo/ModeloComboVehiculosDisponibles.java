package modeloVo;

import java.util.ArrayList;

import javax.swing.JComboBox;

import controlador.Controlador;

public class ModeloComboVehiculosDisponibles extends JComboBox<Vehiculo>{
	
	ArrayList<Vehiculo> vehiculos = null;
	
	Controlador controlador = new Controlador();
	
	public ModeloComboVehiculosDisponibles(){
		cargarVehiculosDisponibles();
	}
	
	public void cargarVehiculosDisponibles(){
			
		vehiculos = controlador.cargarVehiculosDisponibles();
		for(Vehiculo vehiculo : vehiculos){
			this.addItem(vehiculo);
		}	
	}

	
}