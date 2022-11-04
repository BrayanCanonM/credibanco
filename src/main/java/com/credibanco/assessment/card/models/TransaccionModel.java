package com.credibanco.assessment.card.models;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "TRANSACCION")
public class TransaccionModel 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int idTransaccion;
	
	private String pan;
	private String numReferencia;
	private double totalCompra;
	private String direccionCompra;
	private String estadoCompra;
	private LocalDateTime fecha;
	
	
	public int getIdTransaccion() {
		return idTransaccion;
	}
	public void setIdTransaccion(int idTransaccion) {
		this.idTransaccion = idTransaccion;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
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
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
	
	
	
}
