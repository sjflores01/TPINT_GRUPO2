package dao;

import java.util.ArrayList;

import dominio.Cuenta;
import dominio.Prestamo;

public interface PrestamoDao {
	
	public ArrayList<Prestamo> listarPrestamos();
	public void aprobarPrestamo(int id);
	public void cancelarPrestamo(int id);
	public void solicitarPrestamo(Prestamo pres);
	public ArrayList<Prestamo> listarPrestamosActivosDeUsuario(int id);
	public int contarPrestamosPendientesDeUsuario(int id);
	public Prestamo leerPrestamo(int id);
	public void pagaCuota(int idCuenta, int idPrestamo);
	
}
