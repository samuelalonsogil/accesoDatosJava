package DAOModels;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.Conexion;
import VOModels.Cliente;
import VOModels.ListadoCuentas;

public class ListadoCuentasDAO {
	
	public static ArrayList<ListadoCuentas> getLista(String nombre, String apellidos) {
		
		Conexion connection = new Conexion();
		ArrayList<ListadoCuentas> listados = new ArrayList<>();
		
		String query = "select clientes.clNombre, clientes.clApellidos, c.ccCodCuenta, c2.cuCodSucursal, s.suCiudad, c2.cuSaldo "
				+ "from clientes "
				+ "join cuentasclientes c on clientes.clDni = c.ccDni "
				+ "join cuentas c2 on c.ccCodCuenta = c2.cuCodCuenta "
				+ "join sucursales s on c2.cuCodSucursal = s.suCodSucursal "
				+ "where clientes.clNombre = \"" + nombre + "\" and clientes.clApellidos =\"" + apellidos + "\"";
		
        try {
            PreparedStatement ps = connection.getConection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                listados.add(new ListadoCuentas(
                        rs.getInt("ccCodCuenta"),
                        rs.getInt("cuCodSucursal"),
                        rs.getString("suCiudad"),
                        rs.getLong("cuSaldo")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
		
		return listados;
	}
	
	public static ArrayList<ListadoCuentas> getAllCuentas() {
		
		Conexion connection = new Conexion();
		ArrayList<ListadoCuentas> listados = new ArrayList<>();
		
		String query = "select * from cuentas";
		
        try {
            PreparedStatement ps = connection.getConection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                listados.add(new ListadoCuentas(
                        rs.getInt("cuCodCuenta"),
                        rs.getInt("cuCodSucursal"),
                        rs.getLong("cuSaldo")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
		
		return listados;
	}
}
