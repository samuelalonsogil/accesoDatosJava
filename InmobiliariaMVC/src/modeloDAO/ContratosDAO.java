package modeloDAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connection.MyConnection;
import modeloVO.Inquilinos;

public class ContratosDAO {
	
	public ArrayList<Inquilinos> cargarComboBoxInquilinos(){
		MyConnection myConnection = new MyConnection();
		
		String query = "SELECT inNombre FROM Inquilinos";
		ArrayList<Inquilinos> inquilinos = new ArrayList<>();
		
		try {
			PreparedStatement ps = myConnection.getConnection().prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while( rs.next() ) {
				inquilinos.add( new Inquilinos ( 
						rs.getString("inNombre") ) );
			}
			
		} catch (Exception e) {
		}
		myConnection.disconnect();
		
		return inquilinos;
	}
	
	public int nuevoContrato(int code, String inquilino,String direccion, Date fechaContrato, Date fechaVencimiento, double precio) {
		return 0;
	}
	
}
