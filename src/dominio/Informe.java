package dominio;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Informe {

	int cantidadPrestamos;
	int cuotasPagas;
	double promedioCuotas;
	double promedioSaldoPedido;
	double saldoMensual;

	
	public Informe() {
		super();
	}

	public Informe(int cantidadPrestamos, int cuotasPagas, double promedioCuotas, double promedioSaldoPedido, double saldoMensual) {
		super();
		this.cantidadPrestamos = cantidadPrestamos;
		this.cuotasPagas = cuotasPagas;
		this.promedioCuotas = promedioCuotas;
		this.promedioSaldoPedido = promedioSaldoPedido;
		this.saldoMensual = saldoMensual;
	}

	
	public int getCantidadPrestamos() {
		return cantidadPrestamos;
	}

	public void setCantidadPrestamos(int cantidadPrestamos) {
		this.cantidadPrestamos = cantidadPrestamos;
	}

	public int getCuotasPagas() {
		return cuotasPagas;
	}

	public void setCuotasPagas(int cuotasPagas) {
		this.cuotasPagas = cuotasPagas;
	}

	public double getPromedioCuotas() {
		return promedioCuotas;
	}

	public void setPromedioCuotas(double promedioCuotas) {
		this.promedioCuotas = promedioCuotas;
	}

	public double getPromedioSaldoPedido() {
		return promedioSaldoPedido;
	}

	public void setPromedioSaldoPedido(double promedioSaldoPedido) {
		this.promedioSaldoPedido = promedioSaldoPedido;
	}

	public double getSaldoMensual() {
		return saldoMensual;
	}

	public void setSaldoMensual(double saldoMensual) {
		this.saldoMensual = saldoMensual;
	}
	
	
	
}
