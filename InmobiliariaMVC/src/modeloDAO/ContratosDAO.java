package modeloDAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.MyConnection;
import modeloVO.Inquilinos;

public class ContratosDAO {
	
	/*cargar comboBox inquilinos*/
	public ArrayList<Inquilinos> cargarComboBoxInquilinos(){
		MyConnection myConnection = new MyConnection();
		
		String query = "SELECT inNombre, inDNI FROM Inquilinos";
		ArrayList<Inquilinos> inquilinos = new ArrayList<>();
		
		try {
			PreparedStatement ps = myConnection.getConnection().prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while( rs.next() ) {
				inquilinos.add( new Inquilinos ( 
						rs.getString("inNombre"),
						rs.getString("inDNI")) );
			}
			
		} catch (Exception e) {
		}
		myConnection.disconnect();
		
		return inquilinos;
	}
	
	/*insertar nuevo contrato*/
	public int nuevoContrato(String code,String dni ,String codInmueble, Date fechaContrato, Date fechaVencimiento, double precio) {
		MyConnection myConnection = new MyConnection();
		
		String query01 = "INSERT INTO Contratos VALUES (?, ?, ?, ?, ?, ?)";
		String query02 = "UPDATE Inmuebles SET Estado = 1 WHERE inCodigo = (?)";
		
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
