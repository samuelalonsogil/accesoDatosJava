package connection;

public class MyConnectionTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		MyConnection myConnection = new MyConnection();
		if (myConnection != null) System.out.println("Conexi�n OK");
		else System.out.println("Error al conectar");
	}

}
