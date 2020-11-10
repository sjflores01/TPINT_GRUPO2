package validacion;

public class Fecha {

	
	
	public boolean probarFecha(String fecha)
	{
		boolean result = true;
		
		boolean day = false;
		boolean month = false;
		boolean year = false;
		
		String day = "";
		String month = "";
		String year = "";
		
		for(int i = 0; i < fecha.length(); i++)
		{
		   
			if(day == false)
			{
				if (Character.isDigit(fecha.charAt(i)))
				{
					
				}
			
			}
			
			
			
			
			
		}
												
		
		
		return result;
		
		
	}
	
	
	
}
