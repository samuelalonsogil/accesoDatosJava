package DAOModels;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Conexion.Conexion;
import VOModels.Cliente;

public class TransaccionesDAO {

	public static void modification(int numCuenta, int cantidad, int numSucursal) {
		
		int num = getNumber() + 1;
		
		Conexion connection = new Conexion();
		String query01 = "update sucursales set suActivo = suActivo + " + cantidad + " where suCodSucursal = " + numSucursal;
		String query02 = "update cuentas set cuSaldo = cuSaldo + " + cantidad + " where cuCodCuenta = " + numCuenta;
		String query03 = "insert into transacciones values (?, ?, ?, ?, ?)";

		try {
			
			PreparedStatement ps01 = connection.getConection().prepareStatement(query01);
			PreparedStatement ps02 = connection.getConection().prepareStatement(query02);
			PreparedStatement ps03 = connection.getConection().prepareStatement(query03);			
						
			connection.getConection().setAutoCommit(false);
			
			ps03.setInt(1, num);
			ps03.setInt(2, numCuenta);
			
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			ps03.setTimestamp(3, date);
			
			if (cantidad > 0) {
				ps03.setString(4, "I");
			}
			else if (cantidad < 0) {
				ps03.setString(4, "R");
			}
			
			ps03.setInt(5, cantidad);
			
			ps01.executeUpdate();
			ps02.executeUpdate();
			ps03.executeUpdate();
			
			connection.getConection().commit();
			connection.getConection().setAutoCommit(true);
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
				
	}
	
	
	public static void transaction(int numCuenta1, int numCuenta2, int cantidad, int numSucursal1, int numSucursal2) {
		
		int num = getNumber() + 1;

		Conexion connection = new Conexion();
		String query01 = "update sucursales set suActivo = suActivo - " + cantidad + " where suCodSucursal = " + numSucursal1;
		String query02 = "update sucursales set suActivo = suActivo + " + cantidad + " where suCodSucursal = " + numSucursal2;  
		String query03 = "update cuentas set cuSaldo = cuSaldo - " + cantidad + " where cuCodCuenta = " + numCuenta1;
		String query04 = "update cuentas set cuSaldo = cuSaldo + " + cantidad + " where cuCodCuenta = " + numCuenta2;
		String query05 = "insert into transacciones values (?, ?, ?, \"R\", ?)";
		String query06 = "insert into transacciones values (?, ?, ?, \"I\", ?)";

		try {
			
			PreparedStatement ps01 = connection.getConection().prepareStatement(query01);
			PreparedStatement ps02 = connection.getConection().prepareStatement(query02);
			PreparedStatement ps03 = connection.getConection().prepareStatement(query03);
			PreparedStatement ps04 = connection.getConection().prepareStatement(query04);
			PreparedStatement ps05 = connection.getConection().prepareStatement(query05);
			PreparedStatement ps06 = connection.getConection().prepareStatement(query06);
						
			connection.getConection().setAutoCommit(false);
			
			ps05.setInt(1, num);
			ps05.setInt(2, numCuenta1);
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			ps05.setTimestamp(3, date);
			ps05.setInt(4, cantidad);
			
			ps06.setInt(1, num + 1);
			ps06.setInt(2, numCuenta2);
			ps06.setTimestamp(3, date);
			ps06.setInt(4, cantidad);
			
			ps01.executeUpdate();
			ps02.executeUpdate();
			ps03.executeUpdate();
			ps04.executeUpdate();
			ps05.executeUpdate();
			ps06.executeUpdate();
			
			connection.getConection().commit();
			connection.getConection().setAutoCommit(true);
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	
	public static int getNumber() {
		Conexion connection = new Conexion(); 
		String query01 = "select count(*) from transacciones";

		
		int sol = 0;
		
        try {
            PreparedStatement ps = connection.getConection().prepareStatement(query01);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                sol = rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        
		return sol;
	}
	
}
