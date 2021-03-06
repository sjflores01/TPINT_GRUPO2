package dao;

import java.util.ArrayList;

import dominio.Usuario;

public interface UsuarioDao {
	
	public void cargarUsuario(Usuario usuario);
	public void modificarUsuario(Usuario usuario);
	public void eliminarUsuario(int id);
	public ArrayList<Usuario> listarUsuarios(String search);
	public Usuario leerUsuario(Integer id);
	public Boolean chequearEmail(String mail);
	public Boolean chequearDni(String dni);
	public Boolean chequearNombreUsuario(String nombre);
	public int contarCuentas(int id);
	public Usuario confirmarAdmin(String nombre,String contraseņa);
	public Usuario confirmarUser(String nombre,String contraseņa);
	public Boolean chequeaCliente(String nombre, String contraseņa);
}
