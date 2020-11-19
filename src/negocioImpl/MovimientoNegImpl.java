package negocioImpl;

import java.util.ArrayList;

import daoImpl.CuentaDaoImpl;
import daoImpl.MovimientoDaoImpl;
import dominio.Movimiento;
import negocio.MovimientoNeg;

public class MovimientoNegImpl implements MovimientoNeg {

	@Override
	public ArrayList<Movimiento> listarMovimientos(String cbu) {
		
		
		MovimientoDaoImpl dao = new MovimientoDaoImpl();
			
		return dao.listarMovimientos(cbu);
		
		
	}

}
