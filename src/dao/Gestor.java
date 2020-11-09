package dao;

public class Gestor {

	//CONGIF PARAMETERS
	String host = "jdbc:mysql://localhost:3306/";
	String user = "root";
	String pass = "root";
	String dbname = "TPINT_GRUPO2";
	
	
	public Gestor() {
		// TODO Auto-generated constructor stub
	}

	public String getConectoinString() {
		
		
		return host + dbname;
	}
	
	public String getUser() {
		return user;
	}
	
	public String getPass()
	{
		return pass;
	}
	
	
}
