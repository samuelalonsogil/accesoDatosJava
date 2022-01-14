package logic;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.MyConnection;

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

	public boolean checkCuentas(int code) throws SQLException{
		
		MyConnection myConnection = new MyConnection();
		String query = "SELECT cuCodCuenta FROM Cuentas WHERE cuCodCuenta = \"" + code + "\"";
			
			PreparedStatement ps = myConnection.getConnection().prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			if( rs.next() ) return false;
			
			else return true;
	}
}
