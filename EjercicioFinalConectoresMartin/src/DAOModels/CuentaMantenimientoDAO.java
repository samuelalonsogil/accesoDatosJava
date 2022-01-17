package DAOModels;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Conexion.Conexion;

public class CuentaMantenimientoDAO {

	public static void newAcc(int nAcc, int dniCliente, int codSucursal, Date fecha, int saldo) {
		
		Conexion connection = new Conexion();
		
		String query01 = "INSERT INTO Cuentas VALUES (?, ?, ?, ?)";
		String query02 = "INSERT INTO CuentasClientes VALUES (?, ?)";
		String query03 = "update sucursales set suActivo = suActivo + " + saldo + " where suCodSucursal = " + codSucursal;
		
		try {
			PreparedStatement ps01 = connection.getConection().prepareStatement(query01);
			PreparedStatement ps02 = connection.getConection().prepareStatement(query02);
			PreparedStatement ps03 = connection.getConection().prepareStatement(query03);
			
			connection.getConection().setAutoCommit(false);
			
			ps01.setInt(1, nAcc );
			ps01.setInt(2, codSucursal );
			ps01.setDate(3, fecha );
			ps01.setInt(4, saldo );
			
			ps01.executeUpdate();
			
			ps02.setString(1, String.valueOf(dniCliente));
			ps02.setInt(2, nAcc);
			
			ps02.executeUpdate();
			
			ps03.executeUpdate();
			
			connection.getConection().commit();
			connection.getConection().setAutoCommit(true);
			
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	
	public static void updateAcc(int nAcc, int dniCliente, int codSucursal, Date fecha, int saldo) {
		Conexion connection = new Conexion();
		
		String query01 = "update sucursales set suActivo = suActivo + (" + saldo + " - (select cuSaldo from cuentas where cuCodCuenta = " + nAcc + ")) where suCodSucursal = " + codSucursal;
		String query02 = "update cuentas set cuCodSucursal = " + codSucursal + ", cuFechaCreacion = \"" + fecha + "\", cuSaldo = " + saldo + " where cuCodCuenta = " + nAcc;
		String query03 = "update cuentasclientes set ccDni = " + dniCliente + " where ccCodCuenta = " + nAcc;
		
		try {
			PreparedStatement ps01 = connection.getConection().prepareStatement(query01);
			PreparedStatement ps02 = connection.getConection().prepareStatement(query02);
			PreparedStatement ps03 = connection.getConection().prepareStatement(query03);
			
			connection.getConection().setAutoCommit(false);
			
			ps01.executeUpdate();
			ps02.executeUpdate();
			ps03.executeUpdate();
			
			connection.getConection().commit();
			connection.getConection().setAutoCommit(true);
			
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	
	public static void deleteAcc(int nAcc) {
		Conexion connection = new Conexion();
		
		String query01 = "update sucursales set suActivo = suActivo - (select cuSaldo from cuentas where cuCodCuenta = " + nAcc + ") where suCodSucursal = (select cuCodSucursal from cuentas where cuCodCuenta = " + nAcc + ")";
		String query02 = "delete from cuentasclientes where ccCodCuenta = " + nAcc;
		String query03 = "delete from cuentas where cuCodCuenta = " + nAcc;
	
		try {
			PreparedStatement ps01 = connection.getConection().prepareStatement(query01);
			PreparedStatement ps02 = connection.getConection().prepareStatement(query02);
			PreparedStatement ps03 = connection.getConection().prepareStatement(query03);
			
			connection.getConection().setAutoCommit(false);
			
			ps01.executeUpdate();
			ps02.executeUpdate();
			ps03.executeUpdate();
			
			connection.getConection().commit();
			connection.getConection().setAutoCommit(true);
			
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	
}
