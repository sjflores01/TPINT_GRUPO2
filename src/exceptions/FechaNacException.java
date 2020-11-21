package exceptions;

public class FechaNacException extends RuntimeException{
	
	public FechaNacException() {
		
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Fecha de Nacimiento Incorrecta. Error de Edad invalida.";
	}

}
