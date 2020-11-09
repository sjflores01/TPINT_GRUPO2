package dominio;

public class Usuario {

	Integer id;
	String nombre;
	String clave;
	
	Persona persona;

	//Contstructor
	public Usuario(Integer id, String nombre, String clave, Persona persona) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.clave = clave;
		this.persona = persona;
	}

	//Getters and setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) { 
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	
	
	
	
}
