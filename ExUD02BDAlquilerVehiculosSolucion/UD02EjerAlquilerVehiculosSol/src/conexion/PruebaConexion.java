package conexion;

import javax.swing.JOptionPane;

public class PruebaConexion {

	public static void main(String[] args) {
		Conexion conexion = new Conexion();
		
		if(conexion != null)
			JOptionPane.showMessageDialog(null, "Conexión a la base de datos OK");
			
		else
			JOptionPane.showMessageDialog(null, "Conexión a la base de datos no se ha podido realizar");

	}

}
