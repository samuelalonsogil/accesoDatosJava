	package DAOModels;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.Conexion;
import VOModels.Cliente;
import VOModels.ClienteTransaccion;

public class ClienteTransaccionDAO {

	public static ArrayList<ClienteTransaccion> getClienteTransaccion(int codDni) {
		Conexion connection = new Conexion();
		ArrayList<ClienteTransaccion> sol = new ArrayList<>();
		
		String query = "select clientes.clDni, c.ccCodCuenta, c2.cuSaldo, c2.cuCodSucursal from clientes join cuentasclientes c on clientes.clDni = c.ccDni join cuentas c2 on c2.cuCodCuenta = c.ccCodCuenta where clientes.clDni = " + codDni;
		
        try {
            PreparedStatement ps = connection.getConection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                sol.add(new ClienteTransaccion(
                        rs.getInt("clDni"),
                        rs.getInt("ccCodCuenta"),
                        rs.getInt("cuSaldo"), 
                        rs.getInt("cuCodSucursal")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
		
		return sol;
	}
	
}
