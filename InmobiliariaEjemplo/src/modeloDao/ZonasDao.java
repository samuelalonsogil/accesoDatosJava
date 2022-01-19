package modeloDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.Conexion;
import modeloVo.Zonas;

public class ZonasDao {

	public ArrayList<Zonas> cargarZonas() {

		Conexion conexion = new Conexion();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<Zonas> zonas = null;
		String sql = "SELECT zoCodigo, zoNombre FROM Zonas ORDER By zoNombre";
		
		try {
			ps = conexion.getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			zonas = new ArrayList<Zonas>();
			while(rs.next()) {
				Zonas zona = new Zonas();
				zona.setCodigo(rs.getString("zoCodigo"));
				zona.setNombre(rs.getString("zoNombre"));
				zonas.add(zona);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		conexion.desconectar();
		return zonas;
	}

}
