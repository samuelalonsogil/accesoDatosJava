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
	
	
	public ArrayList<ListadoCuentas> cargarCuentas(){
		
		MyConnection myConnection = new MyConnection();
		String query = "SELECT cuCodCuenta, cuCodSucursal, suCiudad, cuSaldo FROM cuentas JOIN sucursales s on cuentas.cuCodSucursal = s.suCodSucursal";
		
		ArrayList<ListadoCuentas> cuentas = new ArrayList<ListadoCuentas>();
		
		try {
			PreparedStatement ps = myConnection.getConnection().prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while( rs.next() ) {
				ListadoCuentas listadoCuentas = new ListadoCuentas ();
				listadoCuentas.setCodCuenta(rs.getInt("cuCodCuenta"));
				listadoCuentas.setCodSucursal(rs.getInt("cuCodSucursal"));
				listadoCuentas.setCiudad(rs.getNString("suCiudad"));
				listadoCuentas.setActivo(rs.getDouble("cuSaldo"));
				cuentas.add(listadoCuentas);
			}
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		
		myConnection.disconnect();
		
		return cuentas;
	}
	
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
			String query = "SELECT suCiudad FROM Sucursales ORDER BY suCodSucursal";
		
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
		String query03 = "UPDATE Sucursales SET suActivo = suActivo + (?) WHERE suCiudad = (?)";
		int rows = 0;
		
		try {
			PreparedStatement ps01 = myConnection.getConnection().prepareStatement(query01);
			PreparedStatement ps02 = myConnection.getConnection().prepareStatement(query02);
			PreparedStatement ps03 = myConnection.getConnection().prepareStatement(query03);
			
			myConnection.getConnection().setAutoCommit(false);
			
			ps01.setInt(1, cuenta.getCodCuenta() );
			ps01.setInt(2, cuenta.getCodSucursal() );
			ps01.setDate(3,(java.sql.Date) cuenta.getFechaCreacion() );
			ps01.setInt(4, cuenta.getSaldo() );
			
			rows = ps01.executeUpdate();
			
			ps02.setString(1, cliente.getDni());
			ps02.setInt(2, cuenta.getCodCuenta());
			
			rows = ps02.executeUpdate();
			
			ps03.setInt(1, cuenta.getSaldo() );
			ps03.setString(2, codigoCiudad(cuenta.getCodSucursal()) );
			
			rows = ps03.executeUpdate();
			
			myConnection.getConnection().commit();
			myConnection.getConnection().setAutoCommit(true);
			
			
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return rows;
	}
	
	public String codigoCiudad(int code) {
		String ciudad;
		
		if(code == 1) {
			ciudad ="Vigo";
			return ciudad;
		}
		else if (code == 2) {
			ciudad = "Porriño";
			return ciudad;
		}
		else if (code == 3) {
			ciudad = "Redondela";
			return ciudad;
		}
		else 
			ciudad = "Nigrán";
			return ciudad;
	}
	
	/*modify account*/
	public int actualizar(Cuenta cuenta, Cliente cliente) {
		MyConnection myConnection = new MyConnection();
		
		String query01 = "UPDATE Cuentas SET cuCodSucursal = (?), cuFechaCreacion = (?), cuSaldo = (?) WHERE cuCodCuenta = (?)";
		String query02 = "UPDATE CuentasClientes SET ccDni = (?) WHERE ccCodCuenta = (?) && ccDni = (?)";
		String query03 = "UPDATE Sucursales SET suActivo = suActivo + ( (?) - (SELECT cuSaldo FROM Cuentas WHERE cuCodCuenta = (?) )) WHERE suCiudad = (?)";
		int rows = 0;
		
		try {
			PreparedStatement ps01 = myConnection.getConnection().prepareStatement(query01);
			PreparedStatement ps02 = myConnection.getConnection().prepareStatement(query02);
			PreparedStatement ps03 = myConnection.getConnection().prepareStatement(query03);
			
			myConnection.getConnection().setAutoCommit(false);
			
			ps01.setInt(1, cuenta.getCodSucursal() );
			ps01.setDate(2,(java.sql.Date) cuenta.getFechaCreacion() );
			ps01.setInt(3, cuenta.getSaldo() );
			ps01.setInt(4, cuenta.getCodCuenta() );
			
			rows = ps01.executeUpdate();
			
			ps02.setString(1, cliente.getDni());
			ps02.setInt(2, cuenta.getCodCuenta());
			ps02.setString(3, cliente.getDni());
			
			rows = ps02.executeUpdate();
			
			ps03.setInt(1, cuenta.getSaldo() );
			ps03.setInt(2, cuenta.getCodCuenta() );
			ps03.setString(3, codigoCiudad( cuenta.getCodSucursal() ) );
			
			rows = ps03.executeUpdate();
			
			
			myConnection.getConnection().commit();
			myConnection.getConnection().setAutoCommit(true);
			
			
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return rows;
	}
	
	/*delete account*/
	public int deleteAccount(Cuenta cuenta, Cliente cliente) {
		MyConnection myConnection = new MyConnection();
		
		String query01 = "DELETE FROM Cuentas WHERE cuCodCuenta = (?)";
		String query02 = "DELETE FROM CuentasClientes WHERE ccCodCuenta = (?)";
		String query03 = "UPDATE Sucursales SET suActivo = suActivo - ( ( SELECT cuSaldo FROM Cuentas WHERE cuCodCuenta = (?) ) ) WHERE suCodSucursal = (SELECT cuCodSucursal FROM Cuentas WHERE cuCodCuenta = (?))";
		
		int rows = 0;
		
		try {
			PreparedStatement ps01 = myConnection.getConnection().prepareStatement(query01);
			PreparedStatement ps02 = myConnection.getConnection().prepareStatement(query02);
			PreparedStatement ps03 = myConnection.getConnection().prepareStatement(query03);
			
			myConnection.getConnection().setAutoCommit(false);
			
			
			ps03.setInt(1, cuenta.getCodCuenta() );
			ps03.setInt(2, cuenta.getCodCuenta() ) ;
			
			rows = ps03.executeUpdate();
			
			ps02.setInt(1, cuenta.getCodCuenta());
			
			rows = ps02.executeUpdate();
			
			ps01.setInt(1, cuenta.getCodCuenta() );
			
			rows = ps01.executeUpdate();
			
			myConnection.getConnection().commit();
			myConnection.getConnection().setAutoCommit(true);
			
			
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return rows;
	}
	
	/*public ArrayList<ListadoCuentas> cargarListadoCuentas(Cliente cliente){
		
		MyConnection myConnection = new MyConnection();
		ListadoCuentas listado= new ListadoCuentas();
		ArrayList<ListadoCuentas> listadoCuentas = new ArrayList<ListadoCuentas>();
		
		String query = "SELECT clNombre, clApellidos, cuCodCuenta, cuCodSucursal, suCiudad, cuSaldo\r\n"
				+ "FROM Cuentas c\r\n"
				+ "JOIN Sucursales s on c.cuCodSucursal = s.suCodSucursal\r\n"
				+ "JOIN Cuentasclientes ccl on ccl.ccCodCuenta = c.cuCodCuenta\r\n"
				+ "JOIN Clientes cl on cl.clDni = ccl.ccDni";
		
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
	}*/
	
}
