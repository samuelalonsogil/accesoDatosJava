package modeloDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.Conexion;
import convertirFechasDate.ConvertirFechas;
import modeloVo.ConsultaContrato;
import modeloVo.Contratos;

public class ContratoDao {

	public ConsultaContrato consultaContrato(String codigo) {
		
		Conexion conexion = new Conexion();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String consultaSQL = "SELECT coCodigo, coDNIInquilino, inNombre, inquilinos.inDireccion, prDNI, "
				+ "	CONCAT(prNombre, ' ', prApellidos), coFechaContrato, coFechaVencimiento, coPrecio "
				+ "FROM ud02bdinmobiliariacasas.contratos JOIN Inquilinos ON inDni = coDNIInquilino "
				+ "JOIN Inmuebles ON coCodInmueble = inCodigo "
				+ "JOIN Propietarios ON prDni = inDniPropietario " 
				+ "WHERE coCodigo = ?";
		
		ConsultaContrato cContrato = null;
		
		try {
			ps = conexion.getConnection().prepareStatement(consultaSQL);
			ps.setString(1, codigo);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				cContrato = new ConsultaContrato();
				cContrato.setCodContrato(rs.getString("coCodigo"));
				cContrato.setDniInquilino(rs.getString("coDniInquilino"));
				cContrato.setNbInquilino(rs.getString("inNombre"));
				cContrato.setDireccion(rs.getString(4));
				cContrato.setDniPropietario(rs.getString(5));
				cContrato.setNbPropietario(rs.getString(6));
				cContrato.setFecContrato(rs.getDate(7));
				cContrato.setFecVencimiento(rs.getDate(8));
				cContrato.setPrecio(rs.getDouble(9));
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return cContrato;
	}

	public ConsultaContrato consultaPrimero() {

		Conexion conexion = new Conexion();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT coCodigo, coDNIInquilino, inNombre, inquilinos.inDireccion, prDNI, "
				+ "	CONCAT(prNombre, ' ', prApellidos), coFechaContrato, coFechaVencimiento, "
				+ " coPrecio"
				+ "	FROM ud02bdinmobiliariacasas.contratos JOIN Inquilinos "
				+ " ON inDni = coDNIInquilino"
				+ "	JOIN Inmuebles ON coCodInmueble = inCodigo"
				+ " JOIN Propietarios ON prDni = inDniPropietario"
				+ " ORDER BY coCodigo ASC LIMIT 1"; 
		
		ConsultaContrato cContrato = null;
		
		
		try {
			ps = conexion.getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				cContrato = new ConsultaContrato();
				cContrato.setCodContrato(rs.getString("coCodigo"));
				cContrato.setDniInquilino(rs.getString("coDniInquilino"));
				cContrato.setNbInquilino(rs.getString("inNombre"));
				cContrato.setDireccion(rs.getString(4));
				cContrato.setDniPropietario(rs.getString(5));
				cContrato.setNbPropietario(rs.getString(6));
				cContrato.setFecContrato(rs.getDate(7));
				cContrato.setFecVencimiento(rs.getDate(8));
				cContrato.setPrecio(rs.getDouble(9));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return cContrato;
	}

	public ConsultaContrato consultaUltimo() {
Conexion conexion = new Conexion();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT coCodigo, coDNIInquilino, inNombre, inquilinos.inDireccion, prDNI, "
				+ "	CONCAT(prNombre, ' ', prApellidos), coFechaContrato, coFechaVencimiento, "
				+ " coPrecio"
				+ "	FROM ud02bdinmobiliariacasas.contratos JOIN Inquilinos "
				+ " ON inDni = coDNIInquilino"
				+ "	JOIN Inmuebles ON coCodInmueble = inCodigo"
				+ " JOIN Propietarios ON prDni = inDniPropietario"
				+ " ORDER BY coCodigo DESC LIMIT 1"; 
		
		ConsultaContrato cContrato = null;
		
		
		try {
			ps = conexion.getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				cContrato = new ConsultaContrato();
				cContrato.setCodContrato(rs.getString("coCodigo"));
				cContrato.setDniInquilino(rs.getString("coDniInquilino"));
				cContrato.setNbInquilino(rs.getString("inNombre"));
				cContrato.setDireccion(rs.getString(4));
				cContrato.setDniPropietario(rs.getString(5));
				cContrato.setNbPropietario(rs.getString(6));
				cContrato.setFecContrato(rs.getDate(7));
				cContrato.setFecVencimiento(rs.getDate(8));
				cContrato.setPrecio(rs.getDouble(9));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return cContrato;
	}

	public ConsultaContrato consultaAnterior(String codigo) {
Conexion conexion = new Conexion();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String consultaSQL = "SELECT coCodigo, coDNIInquilino, inNombre, inquilinos.inDireccion, prDNI, "
				+ "	CONCAT(prNombre, ' ', prApellidos), coFechaContrato, coFechaVencimiento, coPrecio "
				+ "FROM ud02bdinmobiliariacasas.contratos JOIN Inquilinos ON inDni = coDNIInquilino "
				+ "JOIN Inmuebles ON coCodInmueble = inCodigo "
				+ "JOIN Propietarios ON prDni = inDniPropietario " 
				+ "WHERE coCodigo < ? oRDER BY coCodigo DESC LIMIT 1";
		
		ConsultaContrato cContrato = null;
		
		try {
			ps = conexion.getConnection().prepareStatement(consultaSQL);
			ps.setString(1, codigo);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				cContrato = new ConsultaContrato();
				cContrato.setCodContrato(rs.getString("coCodigo"));
				cContrato.setDniInquilino(rs.getString("coDniInquilino"));
				cContrato.setNbInquilino(rs.getString("inNombre"));
				cContrato.setDireccion(rs.getString(4));
				cContrato.setDniPropietario(rs.getString(5));
				cContrato.setNbPropietario(rs.getString(6));
				cContrato.setFecContrato(rs.getDate(7));
				cContrato.setFecVencimiento(rs.getDate(8));
				cContrato.setPrecio(rs.getDouble(9));
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return cContrato;
	}

	

	public int insertarContrato(Contratos contrato) {
		Conexion conexion = new Conexion();
		PreparedStatement ps = null;
		
		int filas = 0;
		
		String sql = "INSERT INTO Contratos (coCodigo, coDniInquilino, coCodInmueble, coFechaContrato, "
				+ "coFechaVencimiento, coPrecio)"
				+ "VALUES ( ?, ?, ?, ?, ?, ?)";
		String sql1 = "UPDATE Inmuebles SET inEstado = 1 WHERE inCodigo = ?";
		
		try {
			conexion.getConnection().setAutoCommit(false);
			ps = conexion.getConnection().prepareStatement(sql);
			ps.setString(1, contrato.getCodigo());
			ps.setString(2, contrato.getDniInquilino());
			ps.setString(3, contrato.getCodInmueble());
			ps.setDate(4, ConvertirFechas.convertirJavaDateASqlDate(contrato.getFechaContrato()));
			ps.setDate(5, ConvertirFechas.convertirJavaDateASqlDate(contrato.getFechaVencimiento()));
			ps.setDouble(6, contrato.getPrecio());
			
			filas = ps.executeUpdate();
			
			// ejercutar la actualización
			ps = conexion.getConnection().prepareStatement(sql1);
			ps.setString(1, contrato.getCodInmueble());
			
			filas = ps.executeUpdate();
			conexion.getConnection().commit();
		}catch(SQLException e) {
			try {
				conexion.getConnection().rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return filas;
	}

	

}
