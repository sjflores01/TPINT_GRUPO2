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
	public ArrayList<Usuario> listarUsuarios(String search, int start, int total) {
		return (ArrayList<Usuario>)daoUsuario.listarUsuarios(search, start, total);
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
	
	
}
