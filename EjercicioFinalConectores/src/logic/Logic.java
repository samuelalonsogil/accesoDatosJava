package logic;

public class Logic {
	
	public boolean validarNulo(String text) {
		if(text.length() == 0)
			return true;
		else
			return false;
	}

	public boolean isDigitte(char keyChar) {
		
		if(Character.isDigit(keyChar))
			return true;
		else
			return false;
	}


}
