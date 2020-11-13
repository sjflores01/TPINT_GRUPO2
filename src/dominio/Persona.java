package dominio;

import java.sql.Date;

public class Persona {

	Integer id;
	String dni;
	String cuil;
	String nombre;
	String apellido;
	String telefono;
	String email;
	char sexo;
	Date fnac;
	
	Direccion direccion;

	//Constructor
	
	public Persona(Integer id, String dni,String cuil , String nombre, String apellido, String telefono, String email, char sexo, Date fnac,
			Direccion direccion) {
		super();
		this.id = id;
		this.dni = dni;
		this.cuil = cuil;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
		this.sexo = sexo;
		this.fnac = fnac;
		this.direccion = direccion;
	}

	
	//Getters and setters
	
	public Date getFnac() {
		return fnac;
	}


	public void setFnac(Date fnac) {
		this.fnac = fnac;
	}


	public String getCuil() {
		return cuil;
	}


	public void setCuil(String cuil) {
		this.cuil = cuil;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	

	
	
	
	
	
}
