package dao;

import java.util.ArrayList;


import dominio.Movimiento;

public interface MovimientoDao {

	
	public ArrayList<Movimiento> listarMovimientos(String cbu);
	public void hacerTransferencia(Movimiento mov);
}
