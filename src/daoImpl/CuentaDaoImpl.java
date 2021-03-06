package daoImpl;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.CuentaDao;
import dao.Gestor;
import dominio.Cuenta;
import dominio.Direccion;
import dominio.Movimiento;
import dominio.Persona;
import dominio.TipoCuenta;
import dominio.Usuario;

public class CuentaDaoImpl implements CuentaDao {

	Gestor gestor = new Gestor();

	// CARGA

	public void cargarCuenta(int idUsuario, int tipoCta) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String query = "call cargaCuenta(" + idUsuario + "," + tipoCta + ")";
		java.sql.Connection cn = null;

		try {

			cn = DriverManager.getConnection(gestor.getConectoinString(), gestor.getUser(), gestor.getPass());
			java.sql.Statement st = cn.createStatement();
			st.executeUpdate(query);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
	
	public void modificarCuenta(int tipoCta, float saldo, int id)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String query = "call modificarCuenta("+tipoCta+","+saldo+","+id+")";
		java.sql.Connection cn = null;
		
		try {
			
			cn = DriverManager.getConnection(gestor.getConectoinString(),gestor.getUser(),gestor.getPass());
			java.sql.Statement st = cn.createStatement();
			st.executeUpdate(query);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Cuenta> listarCuentas(String search) {

		ArrayList<Cuenta> lista = new ArrayList<Cuenta>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		java.sql.Connection cn = null;

		try {
			cn = DriverManager.getConnection(gestor.getConectoinString(), gestor.getUser(), gestor.getPass());
			String query = "call listarCuentas('" + search + "')";
			java.sql.Statement st = cn.createStatement();
			java.sql.ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				Direccion direccion = new Direccion("ph", 0, "ph", "ph", "ph");
				Persona persona = new Persona(0, "ph", "ph", "ph", "ph", "ph", "ph", 'h', null, direccion);
				Usuario usuario = new Usuario(0, "ph", "ph", persona);
				TipoCuenta tipoCuenta = new TipoCuenta(rs.getInt(8), rs.getString(9));

				direccion.setCalle(rs.getString(26));
				direccion.setDepto(rs.getString(28));
				direccion.setLocalidad(rs.getString(29));
				direccion.setNumero(rs.getInt(27));
				direccion.setProvincia(rs.getString(30));
				direccion.setId(rs.getInt(25));

				persona.setApellido(rs.getString(19));
				persona.setNombre(rs.getString(18));
				persona.setDni(rs.getString(16));
				persona.setCuil(rs.getString(17));
				persona.setEmail(rs.getString(22));
				persona.setTelefono(rs.getString(23));
				persona.setFnac(rs.getDate(24));
				persona.setSexo(rs.getString(20).charAt(0));
				persona.setDireccion(direccion);
				persona.setId(rs.getInt(15));

				usuario.setClave(rs.getString(14));
				usuario.setNombre(rs.getString(13));
				usuario.setPersona(persona);
				usuario.setId(rs.getInt(2));

				Cuenta cuenta = new Cuenta(rs.getInt(1), rs.getString(5), rs.getFloat(6), usuario, rs.getDate(3),
						tipoCuenta);

				lista.add(cuenta);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	public void eliminarCuenta(int id) {

		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		String query = "call eliminarCuenta(" + id + ")";
		java.sql.Connection cn = null;

		try {

			cn = DriverManager.getConnection(gestor.getConectoinString(), gestor.getUser(), gestor.getPass());
			java.sql.Statement st = cn.createStatement();
			st.executeUpdate(query);

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	public Cuenta getCuenta(Integer id) {

		Cuenta cuenta = new Cuenta();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		java.sql.Connection cn = null;

		try {

			cn = DriverManager.getConnection(gestor.getConectoinString(), gestor.getUser(), gestor.getPass());
			String query = "call getCuenta(" + id + ")";
			java.sql.Statement st = cn.createStatement();
			java.sql.ResultSet rs = st.executeQuery(query);

			rs.next();

			Direccion direccion = new Direccion("ph", 0, "ph", "ph", "ph");
			Persona persona = new Persona(0, "ph", "ph", "ph", "ph", "ph", "ph", 'h', null, direccion);
			Usuario usuario = new Usuario(0, "ph", "ph", persona);
			TipoCuenta tipoCuenta = new TipoCuenta(rs.getInt(8), rs.getString(9));

			direccion.setCalle(rs.getString(26));
			direccion.setDepto(rs.getString(28));
			direccion.setLocalidad(rs.getString(29));
			direccion.setNumero(rs.getInt(27));
			direccion.setProvincia(rs.getString(30));
			direccion.setId(rs.getInt(25));

			persona.setApellido(rs.getString(19));
			persona.setNombre(rs.getString(18));
			persona.setDni(rs.getString(16));
			persona.setCuil(rs.getString(17));
			persona.setEmail(rs.getString(22));
			persona.setTelefono(rs.getString(23));
			persona.setFnac(rs.getDate(24));
			persona.setSexo(rs.getString(20).charAt(0));
			persona.setDireccion(direccion);
			persona.setId(rs.getInt(15));

			usuario.setClave(rs.getString(14));
			usuario.setNombre(rs.getString(13));
			usuario.setPersona(persona);
			usuario.setId(rs.getInt(2));

			cuenta = new Cuenta(rs.getInt(1), rs.getString(5), rs.getFloat(6), usuario, rs.getDate(3), tipoCuenta);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return cuenta;
	}

	@Override
	public ArrayList<Cuenta> listarCuentasXUsuario(int idUsuario) {
		ArrayList<Cuenta> lista = new ArrayList<Cuenta>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		java.sql.Connection cn = null;

		try {
			cn = DriverManager.getConnection(gestor.getConectoinString(), gestor.getUser(), gestor.getPass());
			String query = "call traerCuentasUsuario("+idUsuario+")";
			java.sql.Statement st = cn.createStatement();
			java.sql.ResultSet rs = st.executeQuery(query);
			Cuenta cuenta;
			TipoCuenta tipoCuenta;

			while (rs.next()) {

				tipoCuenta = new TipoCuenta();
				cuenta = new Cuenta();
				
				cuenta.setId(rs.getInt(1));
				tipoCuenta.setId(rs.getInt(4));
				tipoCuenta.setDescripcion(rs.getString(9));
				cuenta.setTipoCuenta(tipoCuenta);
				cuenta.setCbu(rs.getString(5));
				cuenta.setSaldo(rs.getFloat(6));

				lista.add(cuenta);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	@Override
	public Boolean chequearCbu(String cbu) {
		
		Boolean result = true;
		int i;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		java.sql.Connection cn = null;

		try {
			cn = DriverManager.getConnection(gestor.getConectoinString(), gestor.getUser(), gestor.getPass());
			String query = "call chequearCbu('"+cbu+"')";
			java.sql.Statement st = cn.createStatement();
			java.sql.ResultSet rs = st.executeQuery(query);
			

			 rs.next(); 
			 i = rs.getInt(1);
				
			 if(i == 0)
			 {
				result = false;
			 }
			 

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
		
		
		
		
		
		
	}

	@Override
	public int getIdConCbu(String cbu) {
		
		int id = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		java.sql.Connection cn = null;

		try {
			cn = DriverManager.getConnection(gestor.getConectoinString(), gestor.getUser(), gestor.getPass());
			String query = "call getIdCuenta('"+cbu+"')";
			java.sql.Statement st = cn.createStatement();
			java.sql.ResultSet rs = st.executeQuery(query);
			

			 rs.next(); 
			 id = rs.getInt(1);
				
			 
			 

		} catch (Exception e) {
			e.printStackTrace();
		}

		return id;
		
		
		
		
	}



	

}









