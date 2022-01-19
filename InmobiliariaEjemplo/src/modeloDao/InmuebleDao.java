package modeloDao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.Conexion;
import modeloVo.Inmuebles;
import modeloVo.InmueblesPropietarios;
import modeloVo.Inquilinos;
import modeloVo.Zonas;

public class InmuebleDao {

	public ArrayList<Inmuebles> cargarInmuebles() {

			Conexion conexion = new Conexion();
			
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			ArrayList<Inmuebles> inmuebles = null;
			Inmuebles inmueble = null;
			
			String sql = "SELECT  * FROM Inmuebles WHERE inEstado = 0 ORDER BY inCodigo";
			
			try {
				ps = conexion.getConnection().prepareStatement(sql);
				rs = ps.executeQuery();
				inmuebles = new ArrayList<Inmuebles>();
				while(rs.next()) {
					inmueble = new Inmuebles();
					inmueble.setCodigo(rs.getString("inCodigo"));
					inmueble.setDireccion(rs.getString("inDireccion"));
					inmueble.setCodZona(rs.getString("inCodZona"));
					inmueble.setDniPropietario(rs.getString("inDniPropietario"));
					inmueble.setEstado(rs.getInt("inEstado"));
					inmueble.setNumHabitaciones(rs.getInt("inNumHabitaciones"));
					inmueble.setNumBanhos(rs.getInt("inNumBanhos"));
					inmueble.setTerraza(rs.getBoolean("inTerraza"));
					inmueble.setPiscina(rs.getBoolean("InPiscina"));
					inmueble.setJardin(rs.getBoolean("inJardin"));
					inmueble.setGaraje(rs.getBoolean("inGaraje"));
					inmueble.setPrecio(rs.getInt("inPrecio"));
					
					
					inmuebles.add(inmueble);
				}
			}catch(SQLException e) {
					e.printStackTrace();
			}finally {
				conexion.desconectar();
			}
		
			return inmuebles;
	}

	public boolean actualizarPrecio(Zonas zona, String incremento) {

		Conexion conexion = new Conexion();
		
		CallableStatement cs = null;
		
		String sql = "CALL prInsertarPrecioInmuebles(?, ?)";
		
		boolean sw = true; // no se ha ejecjutado
		
		try {
			cs = conexion.getConnection().prepareCall(sql);
			cs.setString(1, zona.getCodigo());
			cs.setInt(2, Integer.parseInt(incremento));
			
			// ejecutar procedimiento
			sw = cs.execute();		
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		conexion.desconectar();
				
		return sw;
	}

	public ArrayList <Inmuebles> inmueblesPropietario(String dni) {
		Conexion conexion = new Conexion();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<Inmuebles> inmuebles = null;
		
		String sql = "SELECT inCodigo, inDireccion, inCodZona, inEstado, inDniPropietario, inSuperficie, "
				+ "inNUmHabitaciones, inNumBanhos, inTerraza, inPiscina, inJardin, inGaraje, inPrecio "
				+ "FROM Inmuebles WHERE inDniPropietario = ?";
		
		try {
			ps = conexion.getConnection().prepareStatement(sql);
			ps.setString(1, dni);
			
			rs = ps.executeQuery();
			inmuebles = new ArrayList<Inmuebles>();
			while(rs.next()) {
				Inmuebles inmueble = new Inmuebles();
				inmueble.setCodigo(rs.getString("inCodigo"));
				inmueble.setDireccion(rs.getString("inDireccion"));
				inmueble.setCodZona(rs.getString("inCodZona"));
				inmueble.setDniPropietario(rs.getString("inDniPropietario"));
				inmueble.setEstado(rs.getInt("inEstado"));
				inmueble.setNumHabitaciones(rs.getInt("inNumHabitaciones"));
				inmueble.setNumBanhos(rs.getInt("inNumBanhos"));
				inmueble.setTerraza(rs.getBoolean("inTerraza"));
				inmueble.setPiscina(rs.getBoolean("InPiscina"));
				inmueble.setJardin(rs.getBoolean("inJardin"));
				inmueble.setGaraje(rs.getBoolean("inGaraje"));
				inmueble.setPrecio(rs.getInt("inPrecio"));
				inmueble.setSuperficie(rs.getInt("inSuperficie"));
				
				inmuebles.add(inmueble);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			conexion.desconectar();
		}
		return inmuebles;
	}

	public ArrayList<InmueblesPropietarios> buscarInmuebles(String codigo, int tam, boolean pis, boolean gar,
			boolean jar) {
		
		Conexion conexion = new Conexion ();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<InmueblesPropietarios> inmuebles = null;
		
		String sql = "SELECT inCodigo, inDireccion, inPrecio, inEstado,  coFechaVencimiento, "
				+ "CONCAT(prApellidos, ', ', prNombre) As pro, " + 
				"prTelefono " + 
				"FROM inmuebles LEFT JOIN  Propietarios  ON prDni = inDNIPropietario " + 
				"LEFT JOIN  Contratos ON coCodInmueble = inCodigo " + 
				"WHERE (inEstado = 0 OR  " + 
				"(MONTH(coFechaVencimiento) = MONTH(CURDATE()) AND YEAR(coFechaVencimiento)"
				+ "= YEAR(CURDATE()))) " + 
				" AND inCodZona = ? " + 
				" AND inSuperficie >= ? " + 
				" AND inGaraje = ? " + 
				" AND inJardin = ? " + 
				" AND inPiscina = ?";
		
		try {
			ps = conexion.getConnection().prepareStatement(sql);
			ps.setString(1, codigo);
			ps.setInt(2, tam);
			ps.setBoolean(3, gar);
			ps.setBoolean(4, jar);
			ps.setBoolean(5, pis);
				
			rs = ps.executeQuery();
			
			inmuebles = new ArrayList<InmueblesPropietarios>();
			
			while(rs.next()) {
				InmueblesPropietarios inPro = new InmueblesPropietarios();
				inPro.setCodigoInmueble(rs.getString(1));
				inPro.setDireccion(rs.getString(2));
				inPro.setPrecio(rs.getDouble(3));
				inPro.setEstado(rs.getBoolean(4));
				inPro.setFechaVencimiento(rs.getDate(5));
				inPro.setPropietario(rs.getString(6));
				inPro.setTelefono(rs.getString(7));
				
				inmuebles.add(inPro);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		conexion.desconectar();
		
		
		
		return inmuebles;
	}

}
