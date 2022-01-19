package aaConvertirFechasDate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import javax.swing.JOptionPane;

public class ConvertirFechas {

	// Covertir un tipo Date en un String
	public static String convertirDateString(Date fec) {
		try {
			// Obtenemos solamente la fecha pero usamos slash en lugar de guiones
			DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String fecConvertida = fecha.format(fec);
			return fecConvertida;
		} catch (NullPointerException np) {
			JOptionPane.showMessageDialog(null, "Sin fecha");
		}
		return null;
	}// fin convertirDateStrig

	////////////////////////////////////////////////////////////////

	// Covertir un tipo String en un Date
	public static Date convertirStringDate(String fecNac) {
		try {
			// convertir la fecha de un String a un tipo Date
			SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date fechaNac = (Date) formatoDelTexto.parse(fecNac);
			return fechaNac;
		} catch (ParseException pe) {
			JOptionPane.showMessageDialog(null, "Error al introducir la fecha.", "Información",
					JOptionPane.INFORMATION_MESSAGE);
		}
		return null;
	}// fin convertirStringDate

	///////////////////////////////////////////////////////////////////////////////////////////////////

	// Cambia de java Date a SQL Date
	public static java.sql.Date convertirJavaDateASqlDate(java.util.Date date) {
		System.out.println(date);
		
		
		return new java.sql.Date(date.getTime());
	}

	

}
