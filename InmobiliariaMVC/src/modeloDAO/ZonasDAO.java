package modeloDAO;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.MyConnection;
import modeloVO.Zonas;

public class ZonasDAO {
	public ArrayList<Zonas> cargarZonas(){
		MyConnection myConnection = new MyConnection();
		
		String query = "SELECT * FROM Zonas";
		ArrayList<Zonas> zonas = new ArrayList<>();
		
		try {
			PreparedStatement ps = myConnection.getConnection().prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while( rs.next() ) {
				zonas.add( new Zonas ( 
						rs.getString("zoCodigo"),
						rs.getString("zoNombre")
						 ));
			}
			
		} catch (Exception e) {
		}
		myConnection.disconnect();
		
		return zonas;
	}
	
	/*actualizar precio en el formulario 1*/
	public boolean actualizarPrecio( String porcentaje, String codeZona) {

		MyConnection myConnection= new MyConnection();
		CallableStatement cs;
		
		String query = "CALL prIncrementarPrecio(?, ?)";
		boolean sw = true; 
		
		try {
			cs = myConnection.getConnection().prepareCall(query);
			cs.setFloat(2,  ( (Float.parseFloat(porcentaje) ) /100 ) +1  ) ;
			cs.setString(1, codeZona);
			System.out.println(cs);
			sw = cs.execute();		
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		myConnection.disconnect();
				
		return sw;
	}


}


