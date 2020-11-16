package negocio;

import java.sql.Date;

public interface FechaNeg {

	public Integer getDia(String cadena);
	public Integer getMonth(String cadena);
	public Integer getYear(String cadena);
	public String  getString(Date date);
	public String getStringNoDatabase(Date date);
	
	
	
}
