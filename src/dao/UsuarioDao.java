package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;



import dominio.Direccion;
import dominio.Persona;
import dominio.Usuario;

public class UsuarioDao {

	Gestor gestor = new Gestor();
	
	
	//CARGA
	
	
	public void cargarUsuario(Usuario usuario)
	{

		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		cargarPersona(usuario.getPersona());
		Integer personaId = ultimaPersona();
		
		String query = "Insert into Usuarios(idPersona,estado,nombreUsuario,clave) values ('+"+ personaId +"','"+true +"','"+usuario.getNombre()+"','"+usuario.getClave()+"')";
		java.sql.Connection cn = null;
		
		try {
			
			cn = DriverManager.getConnection(gestor.getConectoinString(),gestor.getUser(),gestor.getPass());
			java.sql.Statement st = cn.createStatement();
			st.executeUpdate(query);
			
			
		} catch (Exception e) {
			
			
			e.printStackTrace();
			
		}
		
		
		
		
		
		
	}
	
	
	
	
	
	private void cargarPersona(Persona persona)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		cargarDireccion(persona.getDireccion());
		Integer idDireccion = ultimaIdDireccion();
		
		String query = "Insert into Personas(dni,nombre,apellido,sexo,idDireccion,email,telefono)"
				+ "values('"+ persona.getDni()+"','"+persona.getNombre()+"','"+persona.getApellido()+"','"+persona.getSexo()+"','"+idDireccion+"','"+persona.getEmail()+"','"+persona.getTelefono()+"')";
		java.sql.Connection cn = null;
		
		try {
			
			cn = DriverManager.getConnection(gestor.getConectoinString(),gestor.getUser(),gestor.getPass());
			java.sql.Statement st = cn.createStatement();
			st.executeUpdate(query);
			
			
		} catch (Exception e) {
			
			
			e.printStackTrace();
			
		}
		
		
		
		
	}
	
	
	
	private void cargarDireccion(Direccion direccion)
	{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		String query = "Insert into Direcciones(calle,numero,dpto,localidad,provincia) values ('" +direccion.getCalle() + "','"+direccion.getNumero()+"','" + direccion.getDepto() + "','" + direccion.getLocalidad()+"','" + direccion.getProvincia()+"')";
		java.sql.Connection cn = null;
		
		try {
			
			cn = DriverManager.getConnection(gestor.getConectoinString(),gestor.getUser(),gestor.getPass());
			java.sql.Statement st = cn.createStatement();
			st.executeUpdate(query);
			
			
		} catch (Exception e) {
			
			
			e.printStackTrace();
			
		}
	
	
	
	}
	

	
	private Integer ultimaIdDireccion()
	{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		Integer result;
		
		java.sql.Connection cn = null;
		try {
			
			cn = DriverManager.getConnection(gestor.getConectoinString(),gestor.getUser(),gestor.getPass());
			java.sql.Statement st = cn.createStatement();
			String query = "SELECT id FROM Direcciones ORDER BY id DESC LIMIT 1;";
			
			ResultSet rs = st.executeQuery(query);
			rs.next();
			result = rs.getInt(0);
			
		} catch (Exception e) {
			e.printStackTrace();
			result = -1;
		}
		
		return result;
		
	}
	
	private Integer ultimaPersona()
	{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		Integer result;
		
		java.sql.Connection cn = null;
		try {
			
			cn = DriverManager.getConnection(gestor.getConectoinString(),gestor.getUser(),gestor.getPass());
			java.sql.Statement st = cn.createStatement();
			String query = "SELECT id FROM Personas ORDER BY id DESC LIMIT 1;";
			
			ResultSet rs = st.executeQuery(query);
			rs.next();
			result = rs.getInt(0);
			
		} catch (Exception e) {
			e.printStackTrace();
			result = -1;
		}
		
		return result;
		
	}
	
	
}


































