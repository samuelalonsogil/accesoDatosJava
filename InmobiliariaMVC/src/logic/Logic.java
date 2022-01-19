package logic;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.MyConnection;

public class Logic {
public boolean checkCuentas(String code) throws SQLException{
		
		MyConnection myConnection = new MyConnection();
		String query = "SELECT coCodigo FROM Contratos WHERE coCodigo= \"" + code + "\"";
			
			PreparedStatement ps = myConnection.getConnection().prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			if( rs.next() ) return false;
			
			else return true;
	}
}
