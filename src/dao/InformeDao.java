package dao;

import java.util.ArrayList;

import dominio.Cuenta;
import dominio.Informe;
import dominio.Prestamo;

public interface InformeDao {
	
	public ArrayList<Informe> informePrestamos();
	public ArrayList<Informe> informeInpagos();
	
}
