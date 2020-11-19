package daoImpl;

import java.sql.DriverManager;
import java.util.ArrayList;

import dao.Gestor;
import dao.MovimientoDao;
import dominio.Cuenta;
import dominio.Movimiento;

public class MovimientoDaoImpl implements MovimientoDao{

	
	Gestor gestor = new Gestor();
	
	@Override
	public ArrayList<Movimiento> listarMovimientos(String cbu) {
		
		
		ArrayList<Movimiento> lista = new ArrayList<Movimiento>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		java.sql.Connection cn = null;
		try {
			cn = DriverManager.getConnection(gestor.getConectoinString(),gestor.getUser(),gestor.getPass());
			String query = "call listarMovimientos('"+cbu+"')";
			java.sql.Statement st = cn.createStatement();
			java.sql.ResultSet rs = st.executeQuery(query);		
			
			while(rs.next())
			{
				Movimiento mov = new Movimiento("ph", "ph", 0, null, "ph");
				
				mov.setOrigen(rs.getString(1));
				mov.setDestino(rs.getString(2));
				mov.setMonto(rs.getFloat(3));
				mov.setFecha(rs.getDate(4));
				mov.setConcepto(rs.getString(5));
				
				
				if(mov.getDestino().equals(cbu))
				{
					mov.setIngresa(true);
				} else
				{
					mov.setIngresa(false);
				}
				
				
				lista.add(mov);
				
				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
					
		
		
		
		
		
		return lista;
		
		
		
	}

	
	
}
