package modeloDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.MyConnection;
import modeloVo.Inquilinos;

public class InquilinosDao {
	
	/*cargar inquilinos*/
	public ArrayList <Inquilinos> cargarInquilinos() {
		MyConnection myConection = new MyConnection();
		ArrayList<Inquilinos> inquilinos= new ArrayList<Inquilinos>();
		
		String query = "SELECT  * FROM Inquilinos";
		
		try {
			PreparedStatement ps = myConection.getConnection().prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				inquilinos.add( new Inquilinos( 
						rs.getString("inDni"),
						rs.getString("inNombre"),
						rs.getString("inDireccion"),
						rs.getString("inCiudad"),
						rs.getInt("inCodPostal"),
						rs.getString("inTelefono"),
						rs.getDouble("inSalario")
						
				));
				
				
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			myConection.disconnect();
		}
		return inquilinos;
	}
		 
}// fin de la clase
