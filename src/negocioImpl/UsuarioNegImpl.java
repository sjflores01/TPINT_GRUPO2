package negocioImpl;

import java.util.ArrayList;

import dao.UsuarioDao;
import daoImpl.UsuarioDaoImpl;
import dominio.Usuario;
import negocio.UsuarioNeg;

public class UsuarioNegImpl implements UsuarioNeg{
	private UsuarioDao daoUsuario = new UsuarioDaoImpl();
	
	public UsuarioNegImpl() {
		
	}
	
	public UsuarioNegImpl(UsuarioDao daoUsuario) {
		this.daoUsuario = daoUsuario;
	}

	@Override
	public void cargarUsuario(Usuario usuario) {
		daoUsuario.cargarUsuario(usuario);
	}

	@Override
	public void modificarUsuario(Usuario usuario) {
		daoUsuario.modificarUsuario(usuario);
		
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
	
	
}
