package conexion;

public class PruebaConexion {

	public static void main(String[] args) {
		Conexion conexion = new Conexion();
		
		if(conexion != null)
			System.out.println("Conexi�n a la base de datos OK");
		else
			System.out.println("Conexi�n a la base de datos no se ha podido realizar");

	}

}
