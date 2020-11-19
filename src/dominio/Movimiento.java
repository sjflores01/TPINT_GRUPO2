package dominio;

import java.sql.Date;

public class Movimiento {

	// Parametros
	
	String origen;
	String destino;
	float monto;
	Date fecha;
	String concepto;
	Boolean ingresa;
	
	// Constructor
	
	public Movimiento(String origen, String destino, float monto, Date fecha, String concepto) {
		super();
		this.origen = origen;
		this.destino = destino;
		this.monto = monto;
		this.fecha = fecha;
		this.concepto = concepto;
	}

	
	
	// getters and setters



	public float getMonto() {
		return monto;
	}

	public String getOrigen() {
		return origen;
	}



	public void setOrigen(String origen) {
		this.origen = origen;
	}



	public String getDestino() {
		return destino;
	}



	public void setDestino(String destino) {
		this.destino = destino;
	}



	public void setMonto(float monto) {
		this.monto = monto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public Boolean getIngresa() {
		return ingresa;
	}

	public void setIngresa(Boolean ingresa) {
		this.ingresa = ingresa;
	}
	
	// Metodos
	
	public String getMontoAsString() {
		
		String result = "";
		
		if(ingresa)
		{
			result = Float.toString(monto);
		} else
		{
			result = "-"+ Float.toString(monto);
		}
		
		return result;
	}
	
	public String getFechaAsString() {
		
		String result = "";
		
		result +=  Integer.toString(fecha.getDay()) + "/";
		result += Integer.toString(fecha.getMonth()) + "/";
		result += Integer.toString(fecha.getYear() + 1900);
		
		return result;
		
	}
	
}









