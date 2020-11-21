package daoImpl;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.CuentaDao;
import dao.Gestor;
import dao.InformeDao;
import dao.PrestamoDao;
import dominio.Cuenta;
import dominio.Direccion;
import dominio.Informe;
import dominio.Persona;
import dominio.Prestamo;
import dominio.TipoCuenta;
import dominio.Usuario;

public class InformeDaoImpl implements InformeDao {

	Gestor gestor = new Gestor();

	
	public ArrayList<Informe> informePrestamos() {

		ArrayList<Informe> lista = new ArrayList<Informe>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		java.sql.Connection cn = null;

		try {
			cn = DriverManager.getConnection(gestor.getConectoinString(), gestor.getUser(), gestor.getPass());
			
			String query = "call informePrestamos()";
			
			java.sql.Statement st = cn.createStatement();
			java.sql.ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				
				Informe i = new Informe(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5));
				
				lista.add(i);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}
	
	


}
