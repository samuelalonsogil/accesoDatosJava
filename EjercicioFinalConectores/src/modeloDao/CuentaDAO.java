package modeloDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import connection.MyConnection;
import modeloVO.Cliente;
import modeloVO.ClienteTransaccion;
import modeloVO.Cuenta;
import modeloVO.ListadoCuentas;
import modeloVO.Sucursal;

public class CuentaDAO {
	
	/*modificicar los activos de las sucursales cuando se hace una transacción*/
	public static void modificarActivoSucursales(int codCuenta, int cantidad, int codSucursal) {
		
		int num = getNumberOfAccounts() + 1;
		
		MyConnection myConnection = new MyConnection();
		String query01 = "UPDATE Sucursales SET suActivo = suActivo + " + cantidad + " WHERE suCodSucursal = " + codSucursal;
		String query02 = "UPDATE Cuentas SET cuSaldo = cuSaldo + " + cantidad + " WHERE cuCodCuenta = " + codCuenta;
		String query03 = "INSERT INTO Transacciones VALUES (?, ?, ?, ?, ?)";

		try {
			
			PreparedStatement ps01 = myConnection.getConnection().prepareStatement(query01);
			PreparedStatement ps02 = myConnection.getConnection().prepareStatement(query02);
			PreparedStatement ps03 = myConnection.getConnection().prepareStatement(query03);			
						
			myConnection.getConnection().setAutoCommit(false);
			
			ps03.setInt(1, num);
			ps03.setInt(2, codCuenta);
			
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			
			ps03.setTimestamp(3, date);
			
			if (cantidad > 0)  ps03.setString(4, "I");
			else if (cantidad < 0) ps03.setString(4, "R");
			
			ps03.setInt(5, cantidad);
			
			ps01.executeUpdate();
			ps02.executeUpdate();
			ps03.executeUpdate();
			
			myConnection.getConnection().commit();
			myConnection.getConnection().setAutoCommit(true);
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
				
	}

	/*numero de cuentas totales*/
	public static int getNumberOfAccounts() {
		MyConnection myConnection = new MyConnection();
		String query01 = "SELECT COUNT(*) FROM Transacciones";
		int number = 0;
		
        try {
            PreparedStatement ps = myConnection.getConnection().prepareStatement(query01);
            ResultSet rs = ps.executeQuery();

            while (rs.next())  number = rs.getInt(1);
            
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        
		return number;
	}
	
	/*transacciones de cuentas*/
	public void transactions(int codCuenta01, int codCuenta02, int cantidad, int codSucursal01, int codSucursal02) {
		
		int num = getNumberOfAccounts() + 1;

		MyConnection  myConnection = new MyConnection();
		String query01 = "UPDATE Sucursales SET suActivo = suActivo - " + cantidad + " WHERE suCodSucursal = " + codSucursal01;
		String query02 = "UPDATE sucursales set suActivo = suActivo + " + cantidad + " WHERE suCodSucursal = " + codSucursal02;  
		String query03 = "UPDATE cuentas set cuSaldo = cuSaldo - " + cantidad + " WHERE cuCodCuenta = " + codCuenta01;
		String query04 = "UPDATE cuentas set cuSaldo = cuSaldo + " + cantidad + " WHERE cuCodCuenta = " + codCuenta02;
		String query05 = "INSERT INTO Transacciones VALUES (?, ?, ?, \"R\", ?)";
		String query06 = "INSERT INTO Transacciones VALUES (?, ?, ?, \"I\", ?)";

		try {
			
			PreparedStatement ps01 = myConnection.getConnection().prepareStatement(query01);
			PreparedStatement ps02 = myConnection.getConnection().prepareStatement(query02);
			PreparedStatement ps03 = myConnection.getConnection().prepareStatement(query03);
			PreparedStatement ps04 = myConnection.getConnection().prepareStatement(query04);
			PreparedStatement ps05 = myConnection.getConnection().prepareStatement(query05);
			PreparedStatement ps06 = myConnection.getConnection().prepareStatement(query06);
						
			myConnection.getConnection().setAutoCommit(false);
			
			ps05.setInt(1, num);
			ps05.setInt(2, codCuenta01);
			
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			
			ps05.setTimestamp(3, date);
			ps05.setInt(4, cantidad);
			
			ps06.setInt(1, num + 1);
			ps06.setInt(2, codCuenta02);
			ps06.setTimestamp(3, date);
			ps06.setInt(4, cantidad);
			
			ps01.executeUpdate();
			ps02.executeUpdate();
			ps03.executeUpdate();
			ps04.executeUpdate();
			ps05.executeUpdate();
			ps06.executeUpdate();
			
			myConnection.getConnection().commit();
			myConnection.getConnection().setAutoCommit(true);
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	
	/*cargar cuentas en comboBox de transacciones*/
	public ArrayList<ClienteTransaccion> cargarCuentasBox(String dni){
		MyConnection myConnection = new MyConnection();
		String query = "select clientes.clDni, c.ccCodCuenta, c2.cuSaldo, c2.cuCodSucursal from clientes join cuentasclientes c on clientes.clDni = c.ccDni join cuentas c2 on c2.cuCodCuenta = c.ccCodCuenta where clientes.clDni = " + dni;
		
		ArrayList<ClienteTransaccion> cuentas = new ArrayList<>();
		try {
			PreparedStatement ps = myConnection.getConnection().prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while( rs.next() ) {
				ClienteTransaccion clienteTransaccion= new ClienteTransaccion();
				clienteTransaccion.setCodCuenta( rs.getInt( "cuCodCuenta" ) );
				clienteTransaccion.setActivos( rs.getDouble( "cuSaldo" ) );
				cuentas.add(clienteTransaccion);
			}
		} catch (Exception e) {
		}
		myConnection.disconnect();
		return cuentas;
	}
	
	/*cargar cuentas en tabla*/
	public ArrayList<ListadoCuentas> cargarCuentas(String nombre, String apellido){
		
		MyConnection myConnection = new MyConnection();
		String query = "SELECT cuCodCuenta, cuCodSucursal, suCiudad, cuSaldo\r\n"
				+ "FROM Sucursales su\r\n"
				+ "JOIN Cuentas cu on su.suCodSucursal = cu.cuCodSucursal\r\n"
				+ "JOIN cuentasclientes ccl on cu.cuCodCuenta = ccl.ccCodCuenta\r\n"
				+ "JOIN Clientes cl on ccl.ccDni = cl.clDni\r\n"
				+ "WHERE cl.clNombre =\"" + nombre + "\" AND cl.clApellidos =\"" + apellido + "\"";
		
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
	
	/*cargar clientes en comboBox*/
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
	
	/*cargar comboBox sucursales*/
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
	
	/*insertar nueva cuenta*/
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
	
	/*transformar codigo de sucursal en nombre de ciudad*/
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
	
	/*modificar cuenta*/
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
	
	/*eliminar cuenta*/
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
	
	
	
}
