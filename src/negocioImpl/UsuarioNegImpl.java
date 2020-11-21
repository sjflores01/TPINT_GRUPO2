package negocioImpl;

import java.awt.print.Printable;
import java.io.Console;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Parser;

import dao.UsuarioDao;
import daoImpl.UsuarioDaoImpl;
import dominio.Persona;
import dominio.Usuario;
import exceptions.DniException;
import exceptions.FechaNacException;
import negocio.UsuarioNeg;

public class UsuarioNegImpl implements UsuarioNeg {
	private UsuarioDao daoUsuario = new UsuarioDaoImpl();
	
	public UsuarioNegImpl() throws DniException, FechaNacException  {
		
	}
	
	public UsuarioNegImpl(UsuarioDao daoUsuario) {
		this.daoUsuario = daoUsuario;
	}

	@Override
	public boolean cargarUsuario(Usuario usuario) {
		Persona persona = usuario.getPersona();
		boolean result = false;
		try 
		{
			if(validarDni(persona.getDni()) && validarEdad(persona.getFnac())) {
				daoUsuario.cargarUsuario(usuario);
				result = true;
			}		
		}
		catch(DniException ex) 
		{
			ex.printStackTrace();
		}
		catch(FechaNacException ex) 
		{
			ex.printStackTrace();
		}
		
		return result;
	}

	@Override
	public boolean modificarUsuario(Usuario usuario) {
		Persona persona = usuario.getPersona();
		boolean result = false;
		try 
		{
			if(validarDni(persona.getDni()) && validarEdad(persona.getFnac())) {
				daoUsuario.modificarUsuario(usuario);
				result = true;
			}		
		}
		catch(DniException ex) 
		{
			ex.printStackTrace();
		}
		catch(FechaNacException ex) 
		{
			ex.printStackTrace();
		}
		
		return result;
		
	}

	@Override
	public void eliminarUsuario(int id) {
		daoUsuario.eliminarUsuario(id);
		
	}

	@Override
	public ArrayList<Usuario> listarUsuarios(String search) {
		return (ArrayList<Usuario>)daoUsuario.listarUsuarios(search);
	}

	@Override
	public Usuario leerUsuario(Integer id) {
		return (Usuario)daoUsuario.leerUsuario(id);
	}

	@Override
	public Boolean chequearEmail(String mail) {
		return daoUsuario.chequearEmail(mail);
	}

	@Override
	public Boolean chequearDni(String dni) {
		return daoUsuario.chequearDni(dni);
	}

	@Override
	public Boolean chequearNombreUsuario(String nombre) {
		return daoUsuario.chequearNombreUsuario(nombre);
	}

	@Override
	public int contarCuentas(int id) {
		return daoUsuario.contarCuentas(id);
	}

	@Override
	public Usuario confirmarAdmin(String nombre, String contraseña) {
		return daoUsuario.confirmarAdmin(nombre, contraseña);
	}

	@Override
	public Usuario confirmarUser(String nombre, String contraseña) {
		return daoUsuario.confirmarUser(nombre, contraseña);
	}

	@Override
	public Boolean chequearSiEsUsuario(String nombre, String contraseña) {
		
		Boolean result = false;
		UsuarioDaoImpl dao = new UsuarioDaoImpl();
		
		result = dao.chequeaCliente(nombre, contraseña);
		
		return result;
		
	}
	
	public boolean validarDni(String dni) {
		
		boolean result = true;
		System.out.println(dni.length());
		if(dni.length() != 8) {
			result = false;
			DniException ex = new DniException();
			throw ex;
		}
		return result;
	}
	
	private boolean validarEdad(Date fnac) {
		
		int edad = 0;
		Date fActual = new Date(0);
		fActual = Date.valueOf(LocalDate.now());
		
		edad = (fActual.getYear()-fnac.getYear())+1900;
		System.out.println(edad);
		
		if(fActual.getMonth() < fnac.getMonth()) {
			--edad;
			if(edad < 18) {
				FechaNacException ex = new FechaNacException();
				throw ex;
				
			}else {
				return true;
			}
		}if(fActual.getDay() < fnac.getDay()) {
			--edad;
				if(edad < 18) {
					FechaNacException ex = new FechaNacException();
					throw ex;
				}else {
					return true;
				}
		}
		if(edad <18) {
			FechaNacException ex = new FechaNacException();
			throw ex;
		}else {
			return true;
		}

	}
	
	
}
