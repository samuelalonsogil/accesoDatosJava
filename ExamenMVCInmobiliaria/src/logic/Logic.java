package logic;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.MyConnection;

public class Logic {
	

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
