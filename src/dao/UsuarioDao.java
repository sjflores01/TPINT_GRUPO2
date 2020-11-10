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
	
	
	
	public void modificarUsuario(Usuario usuario) {
		
		
		
		
		
		
	}
	
	
	
	
	

	
	
	
}


































