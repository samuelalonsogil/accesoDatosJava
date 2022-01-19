package logica;

public class Logica {

	public boolean validarNulo(String codigo) {
		if(codigo.length() == 0)
			return true;
		else
			return false;
	}

	public boolean isDigito(char keyChar) {
		if(Character.isDigit(keyChar)) {
			return false;
		}else {
			return true;
		}
				
	}

}
