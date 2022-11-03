package com.credibanco.assessment.card.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSACCION")
public class TransaccionModel 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int idTransaccion;
	
	private String PAN;
	private String numReferencia;
	private double totalCompra;
	private String direccionCompra;
	private String estadoCompra;
	public int getIdTransaccion() {
		return idTransaccion;
	}
	public void setIdTransaccion(int idTransaccion) {
		this.idTransaccion = idTransaccion;
	}
	public String getPAN() {
		return PAN;
	}
	public void setPAN(String pAN) {
		PAN = pAN;
	}
	public String getNumReferencia() {
		return numReferencia;
	}
	public void setNumReferencia(String numReferencia) {
		this.numReferencia = numReferencia;
	}
	public double getTotalCompra() {
		return totalCompra;
	}
	public void setTotalCompra(double totalCompra) {
		this.totalCompra = totalCompra;
	}
	public String getDireccionCompra() {
		return direccionCompra;
	}
	public void setDireccionCompra(String direccionCompra) {
		this.direccionCompra = direccionCompra;
	}
	public String getEstadoCompra() {
		return estadoCompra;
	}
	public void setEstadoCompra(String estadoCompra) {
		this.estadoCompra = estadoCompra;
	}
	
	
	
	
}
