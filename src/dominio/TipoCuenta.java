package dominio;

public class TipoCuenta {

	Integer id;
	String descripcion;

	//Contstructor
	public TipoCuenta(Integer id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

	//Getters and setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
}
