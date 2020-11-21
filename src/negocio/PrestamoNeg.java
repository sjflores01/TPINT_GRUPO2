package negocio;

import java.util.ArrayList;

import dominio.Cuenta;
import dominio.Prestamo;

public interface PrestamoNeg {

	public ArrayList<Prestamo> listarPrestamos();
	public void aprobarPrestamo(int id);
	public void cancelarPrestamo(int id);
	public void solicitarPrestamo(Prestamo pres);
	public ArrayList<Prestamo> listarPrestamosActivosDeUser(int id);
	public int contarPrestamosPendientesDeUser(int id);
	public Prestamo leerPrestamo(int id);
	public void pagarCuota(int idCuenta, int idPrestamo);
}
