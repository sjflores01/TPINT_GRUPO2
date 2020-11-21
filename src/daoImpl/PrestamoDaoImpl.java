package daoImpl;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.CuentaDao;
import dao.Gestor;
import dao.PrestamoDao;
import dominio.Cuenta;
import dominio.Direccion;
import dominio.Persona;
import dominio.Prestamo;
import dominio.TipoCuenta;
import dominio.Usuario;

public class PrestamoDaoImpl implements PrestamoDao {

	Gestor gestor = new Gestor();

	
	public ArrayList<Prestamo> listarPrestamos() {

		ArrayList<Prestamo> lista = new ArrayList<Prestamo>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		java.sql.Connection cn = null;

		try {
			cn = DriverManager.getConnection(gestor.getConectoinString(), gestor.getUser(), gestor.getPass());
			String query = "call listarPrestamos()";
			java.sql.Statement st = cn.createStatement();
			java.sql.ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				Direccion direccion = new Direccion("ph", 0, "ph", "ph", "ph");
				Persona persona = new Persona(0, "ph", "ph", "ph", "ph", "ph", "ph", 'h', null, direccion);
				Usuario usuario = new Usuario(0, "ph", "ph", persona);

				persona.setApellido(rs.getString(22));
				persona.setNombre(rs.getString(21));
				persona.setDni(rs.getString(19));
				persona.setCuil(rs.getString(20));
				persona.setEmail(rs.getString(25));
				persona.setTelefono(rs.getString(26));
				persona.setFnac(rs.getDate(27));
				persona.setSexo(rs.getString(23).charAt(0));
				persona.setDireccion(direccion);
				persona.setId(rs.getInt(18));

				usuario.setClave(rs.getString(17));
				usuario.setNombre(rs.getString(16));
				usuario.setPersona(persona);
				usuario.setId(rs.getInt(13));

				
				Prestamo prestamo = new Prestamo(rs.getInt(1), usuario, rs.getDate(3), rs.getFloat(4),rs.getFloat(5),rs.getFloat(6), rs.getInt(7), rs.getInt(9), rs.getInt(8), rs.getString(12));

				lista.add(prestamo);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}
	
	
	public void aprobarPrestamo(int id) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		java.sql.Connection cn = null;

		try {
			
			cn = DriverManager.getConnection(gestor.getConectoinString(), gestor.getUser(), gestor.getPass());
			String query = "call aprobarPrestamo(" + id + ")";
			java.sql.Statement st = cn.createStatement();
			st.executeUpdate(query);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void cancelarPrestamo(int id) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		java.sql.Connection cn = null;

		try {
			
			cn = DriverManager.getConnection(gestor.getConectoinString(), gestor.getUser(), gestor.getPass());
			String query = "call cancelarPrestamo(" + id + ")";
			java.sql.Statement st = cn.createStatement();
			st.executeUpdate(query);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	@Override
	public void solicitarPrestamo(Prestamo pres) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
		
		
		
		
		
		String query = "call solicitarPrestamo('"+pres.getCbu()+"',"+pres.getUsuario().getId()+","+pres.getImportePedido()+","+pres.getImporteTotal()+","+pres.getMontoMensual()+","+pres.getCantCuotas()+")";
		java.sql.Connection cn = null;
		
		try {
			
			cn = DriverManager.getConnection(gestor.getConectoinString(),gestor.getUser(),gestor.getPass());
			java.sql.Statement st = cn.createStatement();
			st.executeUpdate(query);
			
			
		} catch (Exception e) {
			
			
			e.printStackTrace();
			
		}
		
		
		
	}


	@Override
	public ArrayList<Prestamo> listarPrestamosActivosDeUsuario(int id) {
		
		ArrayList<Prestamo> lista = new ArrayList<Prestamo>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		java.sql.Connection cn = null;

		try {
			cn = DriverManager.getConnection(gestor.getConectoinString(), gestor.getUser(), gestor.getPass());
			String query = "call listarPrestamosActivosDeUser("+id+")";
			java.sql.Statement st = cn.createStatement();
			java.sql.ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				Direccion direccion = new Direccion("ph", 0, "ph", "ph", "ph");
				Persona persona = new Persona(0, "ph", "ph", "ph", "ph", "ph", "ph", 'h', null, direccion);
				Usuario usuario = new Usuario(0, "ph", "ph", persona);

				persona.setApellido(rs.getString(22));
				persona.setNombre(rs.getString(21));
				persona.setDni(rs.getString(19));
				persona.setCuil(rs.getString(20));
				persona.setEmail(rs.getString(25));
				persona.setTelefono(rs.getString(26));
				persona.setFnac(rs.getDate(27));
				persona.setSexo(rs.getString(23).charAt(0));
				persona.setDireccion(direccion);
				persona.setId(rs.getInt(18));

				usuario.setClave(rs.getString(17));
				usuario.setNombre(rs.getString(16));
				usuario.setPersona(persona);
				usuario.setId(rs.getInt(13));

				
				Prestamo prestamo = new Prestamo(rs.getInt(1), usuario, rs.getDate(3), rs.getFloat(4),rs.getFloat(5),rs.getFloat(6), rs.getInt(7), rs.getInt(9), rs.getInt(8), rs.getString(12));

				lista.add(prestamo);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
		
		
	}


	@Override
	public int contarPrestamosPendientesDeUsuario(int id) {

		int cantidad = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		java.sql.Connection cn = null;

		try {
			cn = DriverManager.getConnection(gestor.getConectoinString(), gestor.getUser(), gestor.getPass());
			String query = "call contarPrestamosPendientes("+id+")";
			java.sql.Statement st = cn.createStatement();
			java.sql.ResultSet rs = st.executeQuery(query);

			rs.next(); 
			
			cantidad = rs.getInt(1);

			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return cantidad;
		
		
		
		
	}


	@Override
	public Prestamo leerPrestamo(int id) {
		
		

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		java.sql.Connection cn = null;

		try {
			cn = DriverManager.getConnection(gestor.getConectoinString(), gestor.getUser(), gestor.getPass());
			String query = "call leerPrestamo("+id+")";
			java.sql.Statement st = cn.createStatement();
			java.sql.ResultSet rs = st.executeQuery(query);

			rs.next(); 
				Direccion direccion = new Direccion("ph", 0, "ph", "ph", "ph");
				Persona persona = new Persona(0, "ph", "ph", "ph", "ph", "ph", "ph", 'h', null, direccion);
				Usuario usuario = new Usuario(0, "ph", "ph", persona);

				persona.setApellido(rs.getString(22));
				persona.setNombre(rs.getString(21));
				persona.setDni(rs.getString(19));
				persona.setCuil(rs.getString(20));
				persona.setEmail(rs.getString(25));
				persona.setTelefono(rs.getString(26));
				persona.setFnac(rs.getDate(27));
				persona.setSexo(rs.getString(23).charAt(0));
				persona.setDireccion(direccion);
				persona.setId(rs.getInt(18));

				usuario.setClave(rs.getString(17));
				usuario.setNombre(rs.getString(16));
				usuario.setPersona(persona);
				usuario.setId(rs.getInt(13));

				
				Prestamo prestamo = new Prestamo(rs.getInt(1), usuario, rs.getDate(3), rs.getFloat(4),rs.getFloat(5),rs.getFloat(6), rs.getInt(7), rs.getInt(9), rs.getInt(8), rs.getString(12));

				

				return prestamo;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		
		
		
		
	}


	@Override
	public void pagaCuota(int idCuenta, int idPrestamo) {
		

		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
		
		
		
		
		
		String query = "call PagarCuota("+idCuenta+","+idPrestamo+")";
		java.sql.Connection cn = null;
		
		try {
			
			cn = DriverManager.getConnection(gestor.getConectoinString(),gestor.getUser(),gestor.getPass());
			java.sql.Statement st = cn.createStatement();
			st.executeUpdate(query);
			
			
		} catch (Exception e) {
			
			
			e.printStackTrace();
			
		}
		
		
		
	}


}
