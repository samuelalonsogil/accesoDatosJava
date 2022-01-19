package modeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connection.MyConnection;
import modeloVO.Inmuebles;
import modeloVO.Inquilinos;

public class InmueblesDAO {
	
	public ArrayList<Inmuebles> cargarInmuebles() {
		MyConnection myConnection = new MyConnection();
		
		String query = "SELECT * FROM Inmuebles";
		ArrayList<Inmuebles> inmuebles = new ArrayList<>();
		
		try {
			PreparedStatement ps = myConnection.getConnection().prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while( rs.next() ) {
				inmuebles.add( new Inmuebles( 
						rs.getString("inCodigo"),
						rs.getString("inDireccion") ) 
						);
				}
			
		} catch (Exception e) {
		}
		myConnection.disconnect();
		
		return inmuebles;
	}

	
}
