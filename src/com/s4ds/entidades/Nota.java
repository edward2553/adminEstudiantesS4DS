package com.s4ds.entidades;

public class Nota {

	private int id_est;
	private String nombre;
	private Double porcentaje;
	private Double valor;
	private Nota siguiente;

	public Nota() {
		nombre = null;
		porcentaje = null;
		valor = null;
		siguiente = null;
		id_est = 0;
	}
	public Nota(int id_est, String nombre, Double porc, Double valor,Nota siguiente) {

		this.id_est = id_est;
		this.nombre = nombre;
		this.porcentaje = porc;
		this.valor = valor;
		this.siguiente = siguiente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Nota getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Nota siguiente) {
		this.siguiente = siguiente;
	}
	
	public int getId_est() {
		return id_est;
	}
	public void setId_est(int id_est) {
		this.id_est = id_est;
	}

}
