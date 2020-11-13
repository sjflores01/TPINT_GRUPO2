package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;



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
		
			e.printStackTrace();
		}
		
		Persona persona = usuario.getPersona();
		Direccion direccion = persona.getDireccion();
		
		
		
		String query = "call cargaUsuario('"+direccion.getCalle()+"',"+direccion.getNumero()+",'"+direccion.getDepto()+"','"+direccion.getLocalidad()+"','"+direccion.getProvincia()+"','"+persona.getDni()+"','"+persona.getCuil() +"','"+persona.getNombre()+"','"+persona.getApellido()+"','"+persona.getSexo()+"','"+persona.getEmail()+"','"+persona.getTelefono()+"','"+ persona.getFnac().getYear()+"-"+persona.getFnac().getMonth()+"-"+persona.getFnac().getDate()+"','"+usuario.getNombre()+"','"+usuario.getClave()+"')";
		java.sql.Connection cn = null;
		
		try {
			
			cn = DriverManager.getConnection(gestor.getConectoinString(),gestor.getUser(),gestor.getPass());
			java.sql.Statement st = cn.createStatement();
			st.executeUpdate(query);
			
			
		} catch (Exception e) {
			
			
			e.printStackTrace();
			
		}
		
		
		
		
		
		
	}
	
	
	public void modificarUsuario(Usuario usuario)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
		
		Persona persona = usuario.getPersona();
		Direccion direccion = persona.getDireccion();
		
		
		
		String query = "call modificarUsuario("+usuario.getId()+","+persona.getId()+","+direccion.getId()+ ",'"+direccion.getCalle()+"',"+direccion.getNumero()+",'"+direccion.getDepto()+"','"+direccion.getLocalidad()+"','"+direccion.getProvincia()+"','"+persona.getDni()+"','"+persona.getCuil() +"','"+persona.getNombre()+"','"+persona.getApellido()+"','"+persona.getSexo()+"','"+persona.getEmail()+"','"+persona.getTelefono()+"','"+ persona.getFnac().getYear()+"-"+persona.getFnac().getMonth()+"-"+persona.getFnac().getDate()+"','"+usuario.getClave()+"')";
		java.sql.Connection cn = null;
		
		try {
			
			cn = DriverManager.getConnection(gestor.getConectoinString(),gestor.getUser(),gestor.getPass());
			java.sql.Statement st = cn.createStatement();
			st.executeUpdate(query);
			
			
		} catch (Exception e) {
			
			
			e.printStackTrace();
			
		}
	}

	public void eliminarUsuario(int id) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
		
	
		
		
		String query = "call eliminarUsuario("+id+")";
		java.sql.Connection cn = null;
		
		try {
			
			cn = DriverManager.getConnection(gestor.getConectoinString(),gestor.getUser(),gestor.getPass());
			java.sql.Statement st = cn.createStatement();
			st.executeUpdate(query);
			
			
		} catch (Exception e) {
			
			
			e.printStackTrace();
			
		}
	}
	
	// LECTURA
	
	public ArrayList<Usuario> listarUsuarios(String search, int start, int total) {
		
		
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		java.sql.Connection cn = null;
		try {
			cn = DriverManager.getConnection(gestor.getConectoinString(),gestor.getUser(),gestor.getPass());
			String query = "call listarUsuarios('"+search+"', "+(start-1)+", "+total+")";
			java.sql.Statement st = cn.createStatement();
			java.sql.ResultSet rs = st.executeQuery(query);		
			
			while(rs.next())
			{
				Direccion direccion = new Direccion("ph", 0, "ph", "ph", "ph");
				Persona persona = new Persona(0, "ph","ph" , "ph", "ph", "ph", "ph", 'h', null , direccion);
				Usuario usuario = new Usuario(0, "ph", "ph", persona);
				
				direccion.setCalle(rs.getString(17));
				direccion.setDepto(rs.getString(19));
				direccion.setLocalidad(rs.getString(20));
				direccion.setNumero(rs.getInt(18));
				direccion.setProvincia(rs.getString(21));
				direccion.setId(rs.getInt(16));
				
				persona.setApellido(rs.getString(10));
				persona.setNombre(rs.getString(9));
				persona.setDni(rs.getString(7));
				persona.setCuil(rs.getString(8));
				persona.setEmail(rs.getString(13));
				persona.setTelefono(rs.getString(14));
				persona.setFnac(rs.getDate(15));		 		
				persona.setSexo(rs.getString(11).charAt(0));
				persona.setDireccion(direccion);
				persona.setId(rs.getInt(6));
				
				usuario.setClave(rs.getString(7));
				usuario.setNombre(rs.getString(8));
				usuario.setPersona(persona);
				usuario.setId(rs.getInt(1));
				
				lista.add(usuario);
				
				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
					
		
		
		
		
		
		return lista;
		
		
		
	}
	
	
	public Usuario leerUsuario(Integer id)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		java.sql.Connection cn = null;
		Direccion direccion = new Direccion("ph", 0, "ph", "ph", "ph");
		Persona persona = new Persona(0, "ph","ph" , "ghuyggh", "ph", "ph", "klkklhh", 'h', null , direccion);
		Usuario usuario = new Usuario(0, "ph", "ph", persona);
		try {
			cn = DriverManager.getConnection(gestor.getConectoinString(),gestor.getUser(),gestor.getPass());
			String query = "call leerUsuario("+id+")";
			java.sql.Statement st = cn.createStatement();
			java.sql.ResultSet rs = st.executeQuery(query);		
			
			rs.next();
			
				
				direccion.setCalle(rs.getString(17));
				direccion.setDepto(rs.getString(19));
				direccion.setLocalidad(rs.getString(20));
				direccion.setNumero(rs.getInt(18));
				direccion.setProvincia(rs.getString(21));
				direccion.setId(rs.getInt(16));
				
				persona.setApellido(rs.getString(10));
				persona.setNombre(rs.getString(9));
				persona.setDni(rs.getString(7));
				persona.setCuil(rs.getString(8));
				persona.setEmail(rs.getString(13));
				persona.setTelefono(rs.getString(14));
				persona.setFnac(rs.getDate(15));		 		
				persona.setSexo(rs.getString(11).charAt(0));
				persona.setDireccion(direccion);
				persona.setId(rs.getInt(6));
				
				usuario.setClave(rs.getString(7));
				usuario.setNombre(rs.getString(8));
				usuario.setPersona(persona);
				usuario.setId(rs.getInt(1));
				
							
			
		} catch (Exception e) {
			e.printStackTrace();
		}
					
		
		
		
		
		
		return usuario;
		
		
		
		
	}
	
	
	public Boolean chequearEmail(String mail) {
		
		boolean result = true;
		Integer cantidad;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		java.sql.Connection cn = null;
		try {
			cn = DriverManager.getConnection(gestor.getConectoinString(),gestor.getUser(),gestor.getPass());
			String query = "call contarMails('"+mail+"')";
			java.sql.Statement st = cn.createStatement();
			java.sql.ResultSet rs = st.executeQuery(query);		
			
			rs.next();			
			cantidad = rs.getInt(1);
			
			
			if(cantidad > 0)
			{
				result = false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}

	
	public Boolean chequearDni(String dni) {
	
		boolean result = true;
		Integer cantidad;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		java.sql.Connection cn = null;
		try {
			cn = DriverManager.getConnection(gestor.getConectoinString(),gestor.getUser(),gestor.getPass());
			String query = "call contarDni('"+dni+"')";
			java.sql.Statement st = cn.createStatement();
			java.sql.ResultSet rs = st.executeQuery(query);		
			
			rs.next();			
			cantidad = rs.getInt(1);
			
			
			if(cantidad > 0)
			{
				result = false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
		
	}

	public Boolean chequearNombreUsuario(String nombre) {
		
		boolean result = true;
		Integer cantidad;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		java.sql.Connection cn = null;
		try {
			cn = DriverManager.getConnection(gestor.getConectoinString(),gestor.getUser(),gestor.getPass());
			String query = "call contarUsuario('"+nombre+"')";
			java.sql.Statement st = cn.createStatement();
			java.sql.ResultSet rs = st.executeQuery(query);		
			
			rs.next();			
			cantidad = rs.getInt(1);
			
			
			if(cantidad > 0)
			{
				result = false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	
	//VERIFICAR LOG IN
	
		//funcion que verifica si se logea un administrador
		public Usuario confirmarAdmin(String nombre,String contraseña)
		
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				
			} catch (ClassNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			java.sql.Connection cn = null;
			Usuario usuarioAdim = new Usuario();
			
			try {
				cn = DriverManager.getConnection(gestor.getConectoinString(),gestor.getUser(),gestor.getPass());
				String query = "call Login_Admin("+nombre+", "+contraseña+")";
				java.sql.Statement st = cn.createStatement();
				java.sql.ResultSet rs = st.executeQuery(query);		
				
				rs.next();
				
				usuarioAdim.setId(rs.getInt(1));
				usuarioAdim.setNombre(rs.getString(3));
				usuarioAdim.setClave(rs.getString(4));
		
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return usuarioAdim;
			
		}	
		
		//funcion que verifica si se logea un usuario
	public Usuario confirmarUser(String nombre,String contraseña)
		
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				
			} catch (ClassNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			java.sql.Connection cn = null;
			Usuario usuarioUser = new Usuario();
			
			try {
				cn = DriverManager.getConnection(gestor.getConectoinString(),gestor.getUser(),gestor.getPass());
				String query = "call Login_User("+nombre+", "+contraseña+")";
				java.sql.Statement st = cn.createStatement();
				java.sql.ResultSet rs = st.executeQuery(query);		
				
				rs.next();
				
				usuarioUser.setId(rs.getInt(1));
				usuarioUser.setNombre(rs.getString(3));
				usuarioUser.setClave(rs.getString(4));
		
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return usuarioUser;
			
		}		
	
	
	
}


