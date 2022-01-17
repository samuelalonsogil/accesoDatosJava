package DAOModels;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.Conexion;
import VOModels.Cliente;

public class ClienteDAO {

	public static ArrayList<Cliente> getClientes() {
		Conexion connection = new Conexion();
		ArrayList<Cliente> clientes = new ArrayList<>();
		
		String query = "select * from clientes";
		
        try {
            PreparedStatement ps = connection.getConection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                clientes.add(new Cliente(
                        rs.getInt("clDni"),
                        rs.getString("clNombre"),
                        rs.getString("clApellidos"),
                        rs.getLong("clTelefono")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        
		return clientes;
	}

}
