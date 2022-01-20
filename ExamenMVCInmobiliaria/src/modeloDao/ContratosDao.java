package modeloDao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.MyConnection;

public class ContratosDao {

	/*insertar nuevo contrato*/
	public int nuevoContrato(String code,String dni ,String codInmueble, Date fechaContrato, Date fechaVencimiento, double precio) {
		MyConnection myConnection = new MyConnection();
		
		String query01 = "INSERT INTO Contratos VALUES (?, ?, ?, ?, ?, ?)";
		String query02 = "UPDATE Inmuebles SET inEstado = 1 WHERE inCodigo = (?)";
		
		int rows = 0;
		
		try {
			PreparedStatement ps01 = myConnection.getConnection().prepareStatement(query01);
			PreparedStatement ps02 = myConnection.getConnection().prepareStatement(query02);
			
			myConnection.getConnection().setAutoCommit(false);
			
			ps01.setString(1, code);
			ps01.setString(2, dni);
			ps01.setString(3, codInmueble);
			ps01.setDate(4, (java.sql.Date) fechaContrato);
			ps01.setDate(5,	(java.sql.Date) fechaVencimiento);
			ps01.setDouble(6, precio);
			System.out.println(ps01);
			rows = ps01.executeUpdate();
			System.out.println(ps01);
			ps02.setString(1, code);
			
			rows = ps02.executeUpdate();
			
			myConnection.getConnection().commit();
			myConnection.getConnection().setAutoCommit(true);
			
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		return rows;
	}
	

}
