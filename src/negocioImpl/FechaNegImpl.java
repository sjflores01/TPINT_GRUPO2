package negocioImpl;

import java.sql.Date;

import negocio.FechaNeg;

public class FechaNegImpl implements FechaNeg {

	@Override
	public Integer getDia(String cadena) {
		
		String x = "";
		int result;
		 x += cadena.charAt(8);
		 x += cadena.charAt(9);
		 try {
			
			 result = Integer.parseInt(x);
			 
		} catch (Exception e) {
			
			result = 1;
		}
		 
		 return result;
		 
		 
		 
	}

	@Override
	public Integer getMonth(String cadena) {
		
		String x = "";
		int result;
		 x += cadena.charAt(5);
		 x += cadena.charAt(6);
		 try {
			
			 result = Integer.parseInt(x);
			 
		} catch (Exception e) {
			
			result = 1;
		}
		 
		 return result;
		 
		
		
	}

	@Override
	public Integer getYear(String cadena) {
		String x = "";
		int result;
		 x += cadena.charAt(0);
		 x += cadena.charAt(1);
		 x += cadena.charAt(2);
		 x += cadena.charAt(3);
		 try {
			
			 result = Integer.parseInt(x);
			 
		} catch (Exception e) {
			
			result = 1900;
		}
		 
		 return result;
		
	}

	@Override
	public String getString(Date date) {
		
		String result = "";
		
		result += (date.getYear() +1900);
		result += '-';
		
		if(date.getMonth() < 9)
		{
			result += '0';
		}		
		result += (date.getMonth() + 1);
				
		result += '-';

		if(date.getDate() < 10)
		{
			result += '0';
		}
		
		
		result += date.getDate();
		
		
		return result;
	}

	@Override
	public String getStringNoDatabase(Date date) {
		
		
	String result = "";
		
		result += date.getYear();
		result += '-';
		
		if(date.getMonth() < 9)
		{
			result += '0';
		}		
		result += date.getMonth() ;
				
		result += '-';

		if(date.getDate() < 10)
		{
			result += '0';
		}
		
		
		result += date.getDate();
		
		
		return result;
		
		
		
	}

}















