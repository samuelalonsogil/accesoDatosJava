package modeloDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.Conexion;
import convertirFechasDate.ConvertirFechas;
import modeloVo.Cliente;
import modeloVo.Vehiculo;
import modeloVo.VehiculoCliente;
import modeloVo.VehiculoDisponibles;

public class VehiculoDao {

	public ArrayList<Vehiculo> cargarVehiculosDisponibles() {
		Conexion conexion = new Conexion();

		PreparedStatement ps = null;
		ResultSet rs = null;
		Vehiculo vehiculo = null;
		ArrayList<Vehiculo> vehiculos = new ArrayList<>();
		try{
			String consulta = "SELECT veMatricula, veMarca, veModelo, veGrupo, vePlazas, vePuertas,"
					+ "veCapacidad, veEdadMinima,  veFecCompra, veCodOficina, veDisponible, vePrecio FROM Vehiculos "
					+ "WHERE veDisponible = true";

			ps = conexion.getConnection().prepareStatement(consulta);
			rs = ps.executeQuery();

			while(rs.next()){
				vehiculo = new Vehiculo();
				vehiculo.setMatricula(rs.getString(1));
				vehiculo.setMarca(rs.getString(2));
				vehiculo.setModelo(rs.getString(3));
				vehiculo.setGrupo(rs.getString(4));
				vehiculo.setPlazas(rs.getInt(5));
				vehiculo.setPuertas(rs.getInt(6));
				vehiculo.setCapacidad(rs.getInt(7));
				vehiculo.setEdadMinima(rs.getInt(8));
				vehiculo.setFecCompra(rs.getDate(9));
				vehiculo.setCodOficina(rs.getInt(10));
				vehiculo.setDisponible(rs.getBoolean(11));
				vehiculo.setPrecio(rs.getInt(12));
				vehiculos.add(vehiculo);
			}
		}catch(SQLException sq){
			sq.printStackTrace();
		}finally{
			conexion.desconectar();
		}	
		return vehiculos;
	}

	public ArrayList<VehiculoDisponibles> cargarVehiculosDisponibles(String plazas, String puertas, String capacidad,
			String antiguedad, String precio) {
		Conexion conexion = new Conexion();

		PreparedStatement ps = null;
		ResultSet rs = null;
		VehiculoDisponibles vehiculo = null;
		ArrayList<VehiculoDisponibles> vehiculos = new ArrayList<>();
		try{
			String consulta = "SELECT veMatricula, veMarca, veModelo,  YEAR(CURDATE()) - YEAR(veFecCompra),  vePrecio FROM Vehiculos "
					+ "WHERE veDisponible = true AND vePlazas >= ? AND vePuertas >= ? AND veCapacidad >= ? AND "
					+ "YEAR(CURDATE()) - YEAR(veFecCompra) < ? AND vePrecio < ?";

			ps = conexion.getConnection().prepareStatement(consulta);
			ps.setInt(1, Integer.parseInt(plazas));
			ps.setInt(2, Integer.parseInt(puertas));
			ps.setInt(3, Integer.parseInt(capacidad));
			ps.setInt(4, Integer.parseInt(antiguedad));
			ps.setInt(5, Integer.parseInt(precio));
			
			rs = ps.executeQuery();

			while(rs.next()){
				vehiculo = new VehiculoDisponibles();
				vehiculo.setMatricula(rs.getString(1));
				vehiculo.setMarca(rs.getString(2));
				vehiculo.setModelo(rs.getString(3));
				vehiculo.setAntiguedad(rs.getInt(4));
				vehiculo.setPrecio(rs.getInt(5));
			
				vehiculos.add(vehiculo);
			}
		}catch(SQLException sq){
			sq.printStackTrace();
		}finally{
			conexion.desconectar();
		}	
		return vehiculos;
	}

	public int nuevoNuevoAlquiler(VehiculoCliente vehCli) {
		Conexion conexion = new Conexion();

		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		
		int filas =  0;
		
		String insertar = "INSERT INTO VehiculosClientes (vcDni, vcMatricula, vcFecInicio, vcDias, vcSeguro) "
				+ "VALUES (?, ?, ?, ?, ?)";
		
		String actualizar = "UPDATE Vehiculos SET veDisponible = false WHERE veMatricula = ?";
	
		try{
			
			ps = conexion.getConnection().prepareStatement(insertar);
			ps.setString(1, vehCli.getDni());
			ps.setString(2, vehCli.getMatricula());
			ps.setDate(3, ConvertirFechas.convertirJavaDateASqlDate(vehCli.getFecInicio()));
			ps.setInt(4, vehCli.getDias());
			ps.setString(5, vehCli.getSeguro());
			
			ps1 = conexion.getConnection().prepareStatement(actualizar);
			ps1.setString(1, vehCli.getMatricula());
			
			conexion.getConnection().setAutoCommit(false);		
			filas = ps.executeUpdate();
			filas = ps1.executeUpdate();
			
			conexion.getConnection().commit();
				
		}catch(SQLException sq){
			try {
				conexion.getConnection().rollback();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			sq.printStackTrace();
		}finally{
			conexion.desconectar();
		}	
		return filas;
	}

}
