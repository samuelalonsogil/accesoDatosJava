package modeloDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import connection.MyConnection;
import convertirFechasDate.ConvertirFechas;
import modeloVO.Cliente;
import modeloVO.Cuenta;
import modeloVO.CuentaCliente;
import modeloVO.ListadoCuentas;
import modeloVO.Sucursal;

public class CuentaDAO {
	
	
	public ArrayList<Cliente> cargarClientes(){
		
		MyConnection myConnection = new MyConnection();
		String query = "SELECT clNombre, clApellidos, clDni, clTelefono FROM Clientes ORDER BY clNombre";
		
		ArrayList<Cliente> clientes= new ArrayList<Cliente>();
		
		try {
			PreparedStatement ps = myConnection.getConnection().prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while( rs.next() ) {
				Cliente cliente = new Cliente();
				cliente.setNombre(rs.getString("clNombre") );
				cliente.setApellidos(rs.getString( "clApellidos" ) );
				cliente.setDni(rs.getString("clDni"));
				cliente.setTelefono(rs.getInt("clTelefono"));
				clientes.add(cliente);
			}
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		
		myConnection.disconnect();
		
		return clientes;
	}
	
	public ArrayList<Sucursal> cargarSucursales(){
			
			MyConnection myConnection = new MyConnection();
			String query = "SELECT suCiudad FROM Sucursales ORDER BY suCiudad";
		
		ArrayList<Sucursal> sucursales= new ArrayList<Sucursal>();
		
		try {
			PreparedStatement ps = myConnection.getConnection().prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while( rs.next() ) {
				Sucursal sucursal = new Sucursal();
				sucursal.setCiudad(rs.getString("suCiudad") );
				
				sucursales.add(sucursal);
			}
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		
		myConnection.disconnect();
		
		return sucursales;
	}
	
	/*add new account*/
	public int nuevaCuenta(Cuenta cuenta, Cliente cliente) {
		
		MyConnection myConnection = new MyConnection();
		
		String query01 = "INSERT INTO Cuentas VALUES (?, ?, ?, ?)";
		String query02 = "INSERT INTO CuentasClientes VALUES (?, ?)";
		int rows = 0;
		
		try {
			PreparedStatement ps01 = myConnection.getConnection().prepareStatement(query01);
			PreparedStatement ps02 = myConnection.getConnection().prepareStatement(query02);
			
			myConnection.getConnection().setAutoCommit(false);
			
			ps01.setInt(1, cuenta.getCodCuenta() );
			ps01.setInt(2, cuenta.getCodSucursal() );
			ps01.setDate(3,(java.sql.Date) cuenta.getFechaCreacion() );
			ps01.setInt(4, cuenta.getSaldo() );
			
			rows = ps01.executeUpdate();
			
			ps02.setString(1, cliente.getDni());
			ps02.setInt(2, cuenta.getCodCuenta());
			
			rows = ps02.executeUpdate();
			
			myConnection.getConnection().commit();
			myConnection.getConnection().setAutoCommit(true);
			
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return rows;
	}
	
	public ArrayList<ListadoCuentas> cargarListadoCuentas(){
		
		MyConnection myConnection = new MyConnection();
		ListadoCuentas listado= new ListadoCuentas();
		ArrayList<ListadoCuentas> listadoCuentas = new ArrayList<ListadoCuentas>();
		
		String query = "SELECT cuCodCuenta, suCodSucursal, suCiudad, suActivo"
				+ " FROM Cuentas JOIN Sucursales ON suCodSucursal = cuCodSucursal";
		
		try {
			PreparedStatement ps = myConnection.getConnection().prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while( rs.next() ) {
				listado.setCodCuenta(rs.getInt("cuCodCuenta"));
				listado.setCodSucursal(rs.getInt("suCodSucursal"));
				listado.setCiudad(rs.getString("suCiudad"));
				listado.setActivo(rs.getDouble("suActivo"));
				
				listadoCuentas.add(listado);
			}
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		myConnection.disconnect();
		return listadoCuentas;
	}
	
	
	public static void main(String[] args) {
		CuentaDAO cuentaDAO = new CuentaDAO();
	}
}
