package controlador;

import logica.Logica;
import vista.Form01Alquileres;
import vista.Form02ClienteNuevo;


public class Main {

	// los atributos de la clase son los formularios  el controlador y la clase Logica si existe
	
	Form01Alquileres form01Alquileres;
	Form02ClienteNuevo form02CliNuevo;
	
	Controlador controlador;
	Logica logica;
	
	
	public static void main(String[] args) {
		
		Main main = new Main();
		main.iniciar();
	}

	private void iniciar() {
		
		/*Se instancian las clases*/
		form01Alquileres = new Form01Alquileres();
		form02CliNuevo = new Form02ClienteNuevo();
		
		controlador = new Controlador();
		logica = new Logica();
		
		/*Se establecen las relaciones entre clases*/
		form01Alquileres.setControlador(controlador);
		form02CliNuevo.setControlador(controlador);
		
		logica.setControlador(controlador);
		
		controlador.setForm01Alquileres(form01Alquileres);
		controlador.setForm02CliNuevo(form02CliNuevo);
		
		controlador.setLogica(logica);
		
		form01Alquileres.setVisible(true);
	
		
		
		
	}

}
