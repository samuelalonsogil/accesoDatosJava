package logica;

import controlador.Controlador;

public class Logica {
	
	Controlador controlador;

	public Controlador getControlador() {
		return controlador;
	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
	
	
	public boolean validarNulo(String texto) {
		if(texto.length() == 0)
			return true;
		else
			return false;
	}

	public boolean isDigitte(char keyChar) {
		if(!Character.isDigit(keyChar)){ 
			return false;
		}else
			return true;
	}

	public boolean comprobarLongitud(int length, int i) {
		if(length == i)
			return true;
		else
			return false;
	}
	
	

}
