package negocio;

import java.util.ArrayList;

import dominio.Cuenta;
import dominio.Prestamo;

public interface PrestamoNeg {

	public ArrayList<Prestamo> listarPrestamos();
	public void aprobarPrestamo(int id);
	public void cancelarPrestamo(int id);
}
