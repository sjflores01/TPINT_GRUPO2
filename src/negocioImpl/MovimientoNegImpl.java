package negocioImpl;

import java.util.ArrayList;

import dao.MovimientoDao;
import daoImpl.CuentaDaoImpl;
import daoImpl.MovimientoDaoImpl;
import dominio.Movimiento;
import negocio.MovimientoNeg;

public class MovimientoNegImpl implements MovimientoNeg {

	@Override
	public ArrayList<Movimiento> listarMovimientos(String cbu) {
		
		
		MovimientoDao dao = new MovimientoDaoImpl();
			
		return dao.listarMovimientos(cbu);
		
		
	}

	@Override
	public void hacerTransferencia(Movimiento mov) {
		
		MovimientoDao dao = new MovimientoDaoImpl();
		
		dao.hacerTransferencia(mov);
		
	}

	@Override
	public ArrayList<Movimiento> listarMovimientosImporteFiltrado(String cbu, String importe) {
		
		MovimientoDao dao = new MovimientoDaoImpl();
		return dao.listarMovimientosImporteFiltrado(cbu,importe);
	}

}
