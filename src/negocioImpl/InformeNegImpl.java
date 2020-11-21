package negocioImpl;

import java.util.ArrayList;

import dao.CuentaDao;
import dao.InformeDao;
import dao.PrestamoDao;
import daoImpl.CuentaDaoImpl;
import daoImpl.InformeDaoImpl;
import daoImpl.PrestamoDaoImpl;
import dominio.Cuenta;
import dominio.Informe;
import dominio.Prestamo;
import negocio.CuentaNeg;
import negocio.InformeNeg;
import negocio.PrestamoNeg;


public class InformeNegImpl implements InformeNeg{
	
	private InformeDao daoInforme = new InformeDaoImpl();
	
	public InformeNegImpl() { }
	

	@Override
	public ArrayList<Informe> informePrestamos() {
		return daoInforme.informePrestamos();
	}

	
}
