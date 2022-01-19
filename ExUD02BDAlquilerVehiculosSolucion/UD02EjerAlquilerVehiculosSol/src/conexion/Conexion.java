package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {
	
	static String bd = "UD02BDAlquilerVehiculos";
	static String login = "samu";
	static String password = "staraptor2";
	static String url = "jdbc:mysql://localhost/"+bd+
		"?noAccessToProcedureBodies=true&useServerPrepStmts=true&serverTimezone=Europe/Madrid&useSSL=false";

	
	Connection conn = null;

	/** Constructor de DbConnection */
	public Conexion() {
		try{
			//obtenemos el driver de para mysql
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//obtenemos la conexión
			conn = DriverManager.getConnection(url,login,password);
	
		}
		catch(SQLException e){
			System.out.println(e);
		}catch(ClassNotFoundException e){
			System.out.println(e);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	/**Permite retornar la conexión*/
	public Connection getConnection(){
		return conn;
	}

	public void desconectar(){
		conn = null;
	}
}
