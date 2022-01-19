package modeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connection.MyConnection;
import modeloVO.Inmuebles;
import modeloVO.Inquilinos;

public class InmueblesDAO {
	
	public ArrayList<Inmuebles> cargarComboBoxDirecciones() {
		MyConnection myConnection = new MyConnection();
		
		String query = "SELECT inDireccion, inCodigo FROM Inmuebles";
		ArrayList<Inmuebles> inmuebles = new ArrayList<>();
		
		try {
			PreparedStatement ps = myConnection.getConnection().prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while( rs.next() ) {
				inmuebles.add( new Inmuebles( 
						rs.getString("inDireccion"),
						rs.getString("inCodigo")) 
						);
				}
			
		} catch (Exception e) {
		}
		myConnection.disconnect();
		
		return inmuebles;
	}

	
}
