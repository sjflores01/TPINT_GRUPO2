package negocio;

import java.util.ArrayList;

import dominio.Usuario;

public interface UsuarioNeg {
	
	public boolean cargarUsuario(Usuario usuario);
	public boolean modificarUsuario(Usuario usuario);
	public void eliminarUsuario(int id);
	public ArrayList<Usuario> listarUsuarios(String search);
	public Usuario leerUsuario(Integer id);
	public Boolean chequearEmail(String mail);
	public Boolean chequearDni(String dni);
	public Boolean chequearNombreUsuario(String nombre);
	public int contarCuentas(int id);
	public Usuario confirmarAdmin(String nombre,String contraseņa);
	public Usuario confirmarUser(String nombre,String contraseņa);
	public Boolean chequearSiEsUsuario(String nombre, String contraseņa);
	
}
