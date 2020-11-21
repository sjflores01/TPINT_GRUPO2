package negocioImpl;

import java.util.ArrayList;

import dao.CuentaDao;
import dao.PrestamoDao;
import daoImpl.CuentaDaoImpl;
import daoImpl.PrestamoDaoImpl;
import dominio.Cuenta;
import dominio.Prestamo;
import negocio.CuentaNeg;
import negocio.PrestamoNeg;


public class PrestamoNegImpl implements PrestamoNeg{
	
	private PrestamoDao daoPrestamo = new PrestamoDaoImpl();
	
	public PrestamoNegImpl() {
		
	}
	

	@Override
	public ArrayList<Prestamo> listarPrestamos() {
		return daoPrestamo.listarPrestamos();
	}

	@Override
	public void aprobarPrestamo(int id) {
		daoPrestamo.aprobarPrestamo(id);
	}
	
	@Override
	public void cancelarPrestamo(int id) {
	     daoPrestamo.cancelarPrestamo(id);
	}


	@Override
	public void solicitarPrestamo(Prestamo pres) {
		
		daoPrestamo.solicitarPrestamo(pres);
		
	}


	@Override
	public ArrayList<Prestamo> listarPrestamosActivosDeUser(int id) {
	
		return daoPrestamo.listarPrestamosActivosDeUsuario(id);
	}


	@Override
	public int contarPrestamosPendientesDeUser(int id) {

		return daoPrestamo.contarPrestamosPendientesDeUsuario(id);
	}


	@Override
	public Prestamo leerPrestamo(int id) {
		
		return daoPrestamo.leerPrestamo(id);
	}


	@Override
	public void pagarCuota(int idCuenta, int idPrestamo) {
		
		daoPrestamo.pagaCuota(idCuenta, idPrestamo);
		
	}
	
	
}
