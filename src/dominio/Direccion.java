package dominio;

public class Direccion {

	String calle;
	Integer numero;
	String depto;
	String localidad;
	String provincia;
	Integer id;

	//Constructor
	



	public Direccion(String calle, Integer numero, String depto, String localidad, String provincia) {
		super();
		this.calle = calle;
		this.numero = numero;
		this.depto = depto;
		this.localidad = localidad;
		this.provincia = provincia;
	}
	
	
	
	//Getters and setters
	public Integer getId() {
		return id;
	}
	
	
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getDepto() {
		return depto;
	}
	public void setDepto(String depto) {
		this.depto = depto;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
}
