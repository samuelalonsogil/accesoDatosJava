package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	String bd = "ud02bdinmobiliariacasas", user = "samu", password = "staraptor2",
			url = "jdbc:mysql://localhost:3306/"+bd+"?serverTimezone=Europe/Madrid&useSSL = false";


	Connection connection;

	public Connection getConnection() {
		return connection;
	}

	public MyConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void disconnect() {
		connection = null;
	}
}
