package com.credibanco.assessment.card.models;

import javax.persistence.*;

@Entity
@Table(name = "TARJETA")
public class TarjetaModel 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int idTarjeta;
	
	private String numeroTarjeta;
	private String titular;
	private String cedula;
	private String tipo;
	private String telefono;
	private String estado;
	private String numValidacion;
	
	
	public int getIdTarjeta() {
		return idTarjeta;
	}
	public void setIdTarjeta(int numero) {
		this.idTarjeta = numero;
	}
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(String numero) {
		this.numeroTarjeta = numero;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String numValidacion) {
		this.estado = numValidacion;
	}
	public String getNumValidacion() {
		return numValidacion;
	}
	public void setNumValidacion(String numValidacion) {
		this.numValidacion = numValidacion;
	}
	
	
	
}
