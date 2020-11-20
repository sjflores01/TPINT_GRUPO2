package dao;

import java.util.ArrayList;

import dominio.Cuenta;
import dominio.Movimiento;
import dominio.Usuario;

public interface CuentaDao {
	
	public void cargarCuenta(int idUsuario, int tipoCta);
	public void modificarCuenta(int tipoCta, float saldo, int id);
	public ArrayList<Cuenta> listarCuentas(String search);
	public void eliminarCuenta(int id);
	public Cuenta getCuenta(Integer id);
	public ArrayList<Cuenta> listarCuentasXUsuario(int idUsuario);
	public Boolean chequearCbu(String cbu);
	public int getIdConCbu(String cbu);
	
}
