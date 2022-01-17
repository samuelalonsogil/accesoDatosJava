package DAOModels;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.Conexion;
import VOModels.Sucursal;

public class SucursalDAO {
	
	public static ArrayList<Sucursal> getSucursales() {
		Conexion connection = new Conexion();
		ArrayList<Sucursal> sol = new ArrayList<>();
		
		String query = "select * from sucursales";
		
		try {
			
            PreparedStatement ps = connection.getConection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	sol.add(new Sucursal(
            		rs.getInt("suCodSucursal"),
					rs.getString("suCiudad"),
					rs.getInt("suActivo")));
            }
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		
		return sol;
	}

}
