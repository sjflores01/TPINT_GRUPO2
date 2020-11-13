package dominio;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Cuenta {

	Integer id;
	Usuario usuario;
	Date fechaCreacion;
	TipoCuenta tipoCuenta;
	String cbu;
	double saldo;

	//Contstructor
	public Cuenta(Integer id, String cbu, double saldo, Usuario usuario, Date fechaCreacion, TipoCuenta tipoCuenta) {
		super();
		this.id = id;
		this.cbu = cbu;
		this.saldo = saldo;
		this.usuario = usuario;
		this.fechaCreacion = fechaCreacion;
		this.tipoCuenta = tipoCuenta;
	}
	public Cuenta() {
		super();
	}

	//Getters and setters

	public Integer getId() {
		return id;
	}

	public TipoCuenta getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(TipoCuenta tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
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
