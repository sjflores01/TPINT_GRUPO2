package dominio;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Prestamo {

	Integer id;
	Usuario usuario;
	Date fecha;
	float importePedido;
	float importeTotal;
	float montoMensual;
	int cantCuotas;
	int plazoPago;
	boolean aprobado;
	boolean rechazado;

	public boolean isAprobado() {
		return aprobado;
	}
	public void setAprobado(boolean aprobado) {
		this.aprobado = aprobado;
	}
	public boolean isRechazado() {
		return rechazado;
	}
	public void setRechazado(boolean rechazado) {
		this.rechazado = rechazado;
	}
	//Contstructor
	public Prestamo(Integer id, Usuario usuario, Date fecha, float importePedido, float importeTotal, float montoMensual, int cantCuotas, int plazoPago) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.fecha = fecha;
		this.importePedido = importePedido;
		this.importeTotal = importeTotal;
		this.cantCuotas = cantCuotas;
		this.importePedido = importePedido;
		this.plazoPago = plazoPago;
	}
	public Prestamo() {
		super();
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public float getImportePedido() {
		return importePedido;
	}
	public void setImportePedido(float importePedido) {
		this.importePedido = importePedido;
	}
	public float getImporteTotal() {
		return importeTotal;
	}
	public void setImporteTotal(float importeTotal) {
		this.importeTotal = importeTotal;
	}
	public float getMontoMensual() {
		return montoMensual;
	}
	public void setMontoMensual(float montoMensual) {
		this.montoMensual = montoMensual;
	}
	public int getCantCuotas() {
		return cantCuotas;
	}
	public void setCantCuotas(int cantCuotas) {
		this.cantCuotas = cantCuotas;
	}
	public int getPlazoPago() {
		return plazoPago;
	}
	public void setPlazoPago(int plazoPago) {
		this.plazoPago = plazoPago;
	}

	
}
