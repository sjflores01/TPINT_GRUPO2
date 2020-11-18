package dao;

import java.util.ArrayList;

import dominio.Cuenta;
import dominio.Prestamo;

public interface PrestamoDao {
	
	public ArrayList<Prestamo> listarPrestamos();
	public void aprobarPrestamo(int id);
	public void cancelarPrestamo(int id);
	
}
