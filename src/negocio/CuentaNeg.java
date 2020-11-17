package negocio;

import java.util.ArrayList;

import dominio.Cuenta;

public interface CuentaNeg {
	public void cargarCuenta(int idUsuario, int tipoCta);
	public void modificarCuenta(int tipoCta, double saldo, int id);
	public ArrayList<Cuenta> listarCuentas(String search);
	public void eliminarCuenta(int id);
	public Cuenta getCuenta(Integer id);
}
