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
			// TODO: handle exception
			e.printStackTrace();
		}
		
		Persona persona = usuario.getPersona();
		Direccion direccion = persona.getDireccion();
		
		
		
		String query = "call cargaUsuario('"+direccion.getCalle()+"',"+direccion.getNumero()+",'"+direccion.getDepto()+"','"+direccion.getLocalidad()+"','"+direccion.getProvincia()+"','"+persona.getDni()+"','"+persona.getCuil() +"','"+persona.getNombre()+"','"+persona.getApellido()+"','"+persona.getSexo()+"','"+persona.getEmail()+"','"+persona.getTelefono()+"','"+ persona.getFnac().getYear()+"-"+persona.getFnac().getMonth()+"-"+persona.getFnac().getDay()+"','"+usuario.getNombre()+"','"+usuario.getClave()+"')";
		java.sql.Connection cn = null;
		
		try {
			
			cn = DriverManager.getConnection(gestor.getConectoinString(),gestor.getUser(),gestor.getPass());
			java.sql.Statement st = cn.createStatement();
			st.executeUpdate(query);
			
			
		} catch (Exception e) {
			
			
			e.printStackTrace();
			
		}
		
		
		
		
		
		
	}
	
	
	
	public ArrayList<Usuario> listarUsuarios() {
		
		
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
			String query = "call listarUsuarios()";
			java.sql.Statement st = cn.createStatement();
			java.sql.ResultSet rs = st.executeQuery(query);		
			
			while(rs.next())
			{
				Direccion direccion = new Direccion("ph", 0, "ph", "ph", "ph");
				Persona persona = new Persona(0, "ph","ph" , "ph", "ph", "ph", "ph", 'h', null , direccion);
				Usuario usuario = new Usuario(0, "ph", "ph", persona);
				
				direccion.setCalle(rs.getString(16));
				direccion.setDepto(rs.getString(18));
				direccion.setLocalidad(rs.getString(19));
				direccion.setNumero(rs.getInt(17));
				direccion.setProvincia(rs.getString(20));
				direccion.setId(rs.getInt(15));
				
				persona.setApellido(rs.getString(9));
				persona.setNombre(rs.getString(8));
				persona.setDni(rs.getString(6));
				persona.setCuil(rs.getString(7));
				persona.setEmail(rs.getString(12));
				persona.setTelefono(rs.getString(13));
			//	persona.setFnac(rs.getDate(14));		 		
			//	persona.setSexo('m');
				persona.setDireccion(direccion);
				persona.setId(rs.getInt(5));
				
				usuario.setClave(rs.getString(4));
				usuario.setNombre(rs.getString(3));
				usuario.setPersona(persona);
				usuario.setId(rs.getInt(0));
				
				lista.add(usuario);
				
				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
					
		
		
		
		
		
		return lista;
		
		
		
	}
	
	
	
	
	

	
	
	
}


































