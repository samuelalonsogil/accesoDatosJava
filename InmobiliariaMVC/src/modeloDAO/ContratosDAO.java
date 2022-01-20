package modeloDAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.MyConnection;
import modeloVO.Inquilinos;
import modeloVO.ListaContratos;

public class ContratosDAO {
	
	/*listar contratos*/
	public ArrayList<ListaContratos> listarContratos(String codigoContrato) {
		MyConnection myConnection = new MyConnection();
		String query = "SELECT coCodigo, coDNIInquilino, inNombre, inquilinos.inDireccion, prDNI, prNombre, prApellidos, coFechaContrato, coFechaVencimiento, coPrecio\r\n"
				+ "FROM ud02bdinmobiliariacasas.contratos JOIN Inquilinos ON inDni = coDNIInquilino\r\n"
				+ "JOIN Inmuebles ON coCodInmueble = inCodigo\r\n"
				+ "JOIN Propietarios ON prDni = inDniPropietario\r\n"
				+ "WHERE coCodigo = (?)";
		ArrayList<ListaContratos> listaContratos= new ArrayList<>();
		
		try {
			PreparedStatement ps = myConnection.getConnection().prepareStatement(query);
			ps.setString(1, codigoContrato);
			ResultSet rs = ps.executeQuery();
			
			while( rs.next() ) {
				listaContratos.add( new ListaContratos( 
						rs.getString("coCodigo"),
						rs.getString("inNombre"),
						rs.getString("inquilinos.inDireccion"),
						rs.getString("prNombre"),
						rs.getString("prApellidos"),
						rs.getDate("coFechaContrato"),
						rs.getDate("coFechaVencimiento"),
						rs.getDouble("coPrecio")));
			}
			
		} catch (Exception e) {
		}
		
		return listaContratos;
	}
	
	/*cargar inquilinos*/
	public ArrayList<Inquilinos> cargarInquilinos(){
		MyConnection myConnection = new MyConnection();
		
		String query = "SELECT * FROM Inquilinos";
		ArrayList<Inquilinos> inquilinos = new ArrayList<>();
		
		try {
			PreparedStatement ps = myConnection.getConnection().prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while( rs.next() ) {
				inquilinos.add( new Inquilinos ( 
						rs.getString("inDNI"),
						rs.getString("inNombre"),
						rs.getString("inDireccion"),
						rs.getString("inCiudad"),
						rs.getInt("inCodPostal"),
						rs.getInt("inTelefono"),
						rs.getDouble("inSalario")
						 ));
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
