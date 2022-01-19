package modeloDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.Conexion;
import modeloVo.Propietario;

public class PropietarioDao {

	public ArrayList<Propietario> cargarPropietarios() {
		
		Conexion conexion = new Conexion();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM Propietarios ORDER BY prApellidos, prNombre";
		
		ArrayList<Propietario> propietarios = null;
		
		try {
			ps = conexion.getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			
			propietarios = new ArrayList<Propietario>();
			
			while(rs.next()) {
				Propietario propietario = new Propietario();
				propietario.setDni(rs.getString("prDNI"));
				propietario.setNombre(rs.getString("prNombre"));
				propietario.setApellidos(rs.getString("prApellidos"));
				propietario.setDireccion(rs.getString("prDireccion"));
				propietario.setCiudad(rs.getString("prCiudad"));
				propietario.setCodPostal(rs.getInt("prCodPostal"));
				propietario.setProvincia(rs.getString("prProvincia"));
				propietario.setTelefono(rs.getString("prTelefono"));
				
				propietarios.add(propietario);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		conexion.desconectar();
		return propietarios;
	}

	public int modificarPropietario(Propietario propietario) {
		Conexion conexion = new Conexion();
		PreparedStatement ps = null;
		int filas = 0;
		
		String sql = "UPDATE Propietarios SET prNombre = ?, prApellidos = ?,"
				+ " prDireccion = ?, prCiudad = ?, prCodPostal = ?, "
				+ "prProvincia = ?, prTelefono = ? WHERE prDNI = ?";
		
		try {
			ps = conexion.getConnection().prepareStatement(sql);
			ps.setString(1, propietario.getNombre());
			ps.setString(2, propietario.getApellidos());
			ps.setString(3, propietario.getDireccion());
			ps.setString(4, propietario.getCiudad());
			ps.setInt(5, propietario.getCodPostal());
			ps.setString(6, propietario.getProvincia());
			ps.setString(7, propietario.getTelefono());
			ps.setString(8, propietario.getDni());
			
			filas = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return filas;
	}

	public int eliminarPropietario(String dni) {
		Conexion conexion = new Conexion();
		
		PreparedStatement ps = null;
		int filas = 0;
		
		String sql = "DELETE FROM Propietarios WHERE prDNI = ?";
		
		try {
			ps = conexion.getConnection().prepareStatement(sql);
			ps.setString(1, dni);
			
			filas = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		return filas;
	}

}
