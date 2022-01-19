package modeloDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.Conexion;
import modeloVo.Inquilinos;

public class InquilinoDao {

	public ArrayList<Inquilinos> cargarInquilinos() {
		Conexion conexion = new Conexion();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<Inquilinos> inquilinos = null;
		Inquilinos inquilino = null;
		
		String sql = "SELECT  * FROM Inquilinos ORDER BY inNombre";
		
		try {
			ps = conexion.getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			inquilinos = new ArrayList<Inquilinos>();
			while(rs.next()) {
				inquilino = new Inquilinos();
				inquilino.setDni(rs.getString("inDni"));
				inquilino.setNombre(rs.getString("inNombre"));
				inquilino.setDireccion(rs.getString("inDireccion"));
				inquilino.setCodPostal(rs.getInt("inCodPostal"));
				inquilino.setCiudad(rs.getString("inCiudad"));
				inquilino.setSalario(rs.getDouble("inSalario"));
				inquilino.setTelefono(rs.getString("inTelefono"));
				
				inquilinos.add(inquilino);
			}
		}catch(SQLException e) {
				e.printStackTrace();
		}finally {
			conexion.desconectar();
		}
	
		return inquilinos;
	}

}
