package negocioImpl;

import java.util.ArrayList;

import dao.CuentaDao;
import daoImpl.CuentaDaoImpl;
import dominio.Cuenta;
import dominio.Usuario;
import negocio.CuentaNeg;


public class CuentaNegImpl implements CuentaNeg{
	
	private CuentaDao daoCuenta = new CuentaDaoImpl();
	
	public CuentaNegImpl() {
		
	}
	
	public CuentaNegImpl(CuentaDao daoCuenta) {
		super();
		this.daoCuenta = daoCuenta;
	}

	@Override
	public void cargarCuenta(int idUsuario, int tipoCta) {
		daoCuenta.cargarCuenta(idUsuario, tipoCta);
	}

	@Override
	public void modificarCuenta(int tipoCta, double saldo, int id) {
		daoCuenta.modificarCuenta(tipoCta, saldo, id);
	}

	@Override
	public ArrayList<Cuenta> listarCuentas(String search) {
		return daoCuenta.listarCuentas(search);
	}

	@Override
	public void eliminarCuenta(int id) {
		daoCuenta.eliminarCuenta(id);
	}

	@Override
	public Cuenta getCuenta(Integer id) {
		return daoCuenta.getCuenta(id);
	}

	@Override
	public ArrayList<Cuenta> listarCuentasXUsuario(int idUsuario) {
		return daoCuenta.listarCuentasXUsuario(idUsuario);
	}

	
	
}
