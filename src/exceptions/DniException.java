package exceptions;

public class DniException extends RuntimeException{
	public DniException() {
		
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Dni Incorrecto. Error de longitud.";
	}
	
	
}
