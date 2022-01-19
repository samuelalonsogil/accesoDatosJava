package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {
	
	static String bd = "ud02BdSubastas";
	static String login = "root";
	static String password = "admin";
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
			//	System.out.println(url);
			/*
			 * if (conn==null){
			 * System.out.println("Conexión a base de datos "+bd+" no se ha podido realizar"
			 * ); }
			 */
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
