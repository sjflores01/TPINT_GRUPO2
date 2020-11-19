package negocio;

import java.util.ArrayList;

import dominio.Movimiento;

public interface MovimientoNeg {

	public ArrayList<Movimiento> listarMovimientos(String cbu);
}
