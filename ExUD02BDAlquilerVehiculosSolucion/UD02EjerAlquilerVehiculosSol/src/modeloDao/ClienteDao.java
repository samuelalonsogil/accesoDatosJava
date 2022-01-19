package modeloDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.Conexion;
import modeloVo.Cliente;


public class ClienteDao {
	 public static ArrayList<Cliente> cargarClientes() {
		Conexion conexion = new Conexion();

		PreparedStatement ps = null;
		ResultSet rs = null;
		Cliente cliente = null;
		ArrayList<Cliente> clientes = new ArrayList<>();
		try{
			String consulta = "SELECT clDni, clNombre, clDireccion, clCiudad, clCodigoPostal, clProvincia,"
					+ "clTelefono, clNumTarjeta FROM Clientes "
					+ "ORDER BY clNombre";

			ps = conexion.getConnection().prepareStatement(consulta);
			rs = ps.executeQuery();

			while(rs.next()){
				cliente = new Cliente();
				cliente.setDni(rs.getString(1));
				cliente.setNombre(rs.getString(2));
				cliente.setDireccion(rs.getString(3));
				cliente.setCiudad(rs.getString(4));
				cliente.setCodPostal(rs.getInt(5));
				cliente.setProvincia(rs.getString(6));
				cliente.setTelefono(rs.getInt(7));
				cliente.setNumTarjeta(rs.getString(8));
				clientes.add(cliente);
			}
		}catch(SQLException sq){
			sq.printStackTrace();
		}finally{
			conexion.desconectar();
		}	
		return clientes;
	}

	public Cliente consultarCliente(String dni) {
		Conexion conexion = new Conexion();

		PreparedStatement ps = null;
		ResultSet rs = null;
		Cliente cliente = null;
	
		try{
			String consulta = "SELECT clDni, clNombre, clDireccion, clCiudad, clCodigoPostal, clProvincia,"
					+ "clTelefono, clNumTarjeta FROM Clientes "
					+ "WHERE clDni = ?";

			ps = conexion.getConnection().prepareStatement(consulta);
			ps.setString(1, dni);
			rs = ps.executeQuery();

			if(rs.next()){
				cliente = new Cliente();
				cliente.setDni(rs.getString(1));
				cliente.setNombre(rs.getString(2));
				cliente.setDireccion(rs.getString(3));
				cliente.setCiudad(rs.getString(4));
				cliente.setCodPostal(rs.getInt(5));
				cliente.setProvincia(rs.getString(6));
				cliente.setTelefono(rs.getInt(7));
				cliente.setNumTarjeta(rs.getString(8));
				
			}
		}catch(SQLException sq){
			sq.printStackTrace();
		}finally{
			conexion.desconectar();
		}	
		return cliente;
	}

	public int nuevoCliente(Cliente cl) {
		Conexion conexion = new Conexion();

		PreparedStatement ps = null;
	
		int filas =  0;
	
		try{
			String consulta = "INSERT INTO Clientes (clDni, clNombre, clDireccion, clCiudad, clCodigoPostal, clProvincia,"
					+ "clTelefono, clNumTarjeta) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

			ps = conexion.getConnection().prepareStatement(consulta);
			ps.setString(1, cl.getDni());
			ps.setString(2, cl.getNombre());
			ps.setString(3, cl.getDireccion());
			ps.setString(4, cl.getCiudad());
			ps.setInt(5, cl.getCodPostal());
			ps.setString(6, cl.getProvincia());
			ps.setInt(7, cl.getTelefono());
			ps.setString(8, cl.getNumTarjeta());
			
			filas = ps.executeUpdate();
			
		}catch(SQLException sq){
			sq.printStackTrace();
		}finally{
			conexion.desconectar();
		}	
		return filas;
	}
	 

}
