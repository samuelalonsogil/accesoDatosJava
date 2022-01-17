package Conexion;

public class PruebaConexion {

	public static void main(String[] args) {
		Conexion conexion = new Conexion();
		
		if(conexion != null)
			System.out.println("Conexion ok");
		else
			System.out.println("Error al conectar");
	}
}