package modeloDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.MyConnection;
import modeloVo.Inmuebles;
import modeloVo.InmueblesPropietarios;

public class InmueblesDao {
	
	/*buscar inmuebles*/
	public ArrayList<InmueblesPropietarios> buscarInmuebles
	(String codeZona, int size, boolean pool, boolean garaje,boolean garden) {
		
		MyConnection myConection = new MyConnection();
		ArrayList<InmueblesPropietarios> listaInmuebles = new ArrayList<InmueblesPropietarios>();
		
		String query = "SELECT inCodigo, inDireccion, inPrecio, inEstado,  coFechaVencimiento, "
				+ "CONCAT(prApellidos, ', ', prNombre) As propietario, " + 
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
			PreparedStatement ps = myConection.getConnection().prepareStatement(query);
			
			ps.setString(1, codeZona);
			ps.setInt(2, size);
			ps.setBoolean(3, garaje);
			ps.setBoolean(4, garden);
			ps.setBoolean(5, pool);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next() ) {
				listaInmuebles.add(new InmueblesPropietarios(
						rs.getString("inCodigo"),
						rs.getString("inDireccion"),
						rs.getDouble("inPrecio"),
						rs.getBoolean("inEstado"),
						rs.getDate("coFechaVencimiento"),
						rs.getString("propietario"),
						rs.getString("prTelefono")
				));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		myConection.disconnect();
		
		
		
		return listaInmuebles;
	}
	
	/*cargar inmuebles pasando el dni del propietario*/
	public ArrayList <Inmuebles> cargarInmueblesPropietario(String dni) {
		MyConnection myConection = new MyConnection();
		ArrayList<Inmuebles> inmuebles = new ArrayList<Inmuebles>();
		
		String query = "SELECT inCodigo, inDireccion, inCodZona, inEstado, inDniPropietario, inSuperficie, "
				+ "inNUmHabitaciones, inNumBanhos, inTerraza, inPiscina, inJardin, inGaraje, inPrecio "
				+ "FROM Inmuebles WHERE inDniPropietario = ?";
		
		try {
			PreparedStatement ps = myConection.getConnection().prepareStatement(query);
			ps.setString(1, dni);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				inmuebles.add( new Inmuebles( 
						rs.getString("inCodigo"),
						rs.getString("inDireccion"),
						rs.getString("inCodZona"),
						rs.getInt("inEstado"),
						rs.getString("inDniPropietario"),
						rs.getInt("inSuperficie"),
						rs.getInt("inNumHabitaciones"),
						rs.getInt("inNumBanhos"),
						rs.getBoolean("inTerraza"),
						rs.getBoolean("InPiscina"),
						rs.getBoolean("inJardin"),
						rs.getBoolean("inGaraje"),
						rs.getInt("inPrecio")
				 ));
				
				
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			myConection.disconnect();
		}
		return inmuebles;
	}
	
	/*cargar los inmuebles*/
	public ArrayList <Inmuebles> cargarInmuebles() {
		MyConnection myConection = new MyConnection();
		ArrayList<Inmuebles> inmuebles = new ArrayList<Inmuebles>();
		
		String query = "SELECT * FROM Inmuebles WHERE inEstado = 0 ?";
		
		try {
			PreparedStatement ps = myConection.getConnection().prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				inmuebles.add( new Inmuebles( 
						rs.getString("inCodigo"),
						rs.getString("inDireccion"),
						rs.getString("inCodZona"),
						rs.getInt("inEstado"),
						rs.getString("inDniPropietario"),
						rs.getInt("inSuperficie"),
						rs.getInt("inNumHabitaciones"),
						rs.getInt("inNumBanhos"),
						rs.getBoolean("inTerraza"),
						rs.getBoolean("InPiscina"),
						rs.getBoolean("inJardin"),
						rs.getBoolean("inGaraje"),
						rs.getInt("inPrecio")
				 ));
				
				
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			myConection.disconnect();
		}
		return inmuebles;
	}
		
}
		