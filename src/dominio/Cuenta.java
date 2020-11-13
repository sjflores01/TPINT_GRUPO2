package dominio;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Cuenta {

	Integer id;
	Usuario usuario;
	Date fechaCreacion;
	int tipoCta;
	String cbu;
	double saldo;

	//Contstructor
	public Cuenta(Integer id, int tipoCta, String cbu, double saldo, Usuario usuario) {
		super();
		this.id = id;
		this.tipoCta = tipoCta;
		this.cbu = cbu;
		this.saldo = saldo;
		this.usuario = usuario;
	}

	//Getters and setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public int getTipoCta() {
		return tipoCta;
	}

	public void setTipoCta(int tipoCta) {
		this.tipoCta = tipoCta;
	}

	public String getCbu() {
		return cbu;
	}

	public void setCbu(String cbu) {
		this.cbu = cbu;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	
}
