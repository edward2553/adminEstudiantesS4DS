package com.s4ds.entidades;

public class Estudiante {
	
	private int ID;
	private String nombre;
	private String apellido;
	private String grado;
	private Double promedio;
	private Estudiante siguiente;
	
	public Estudiante() {
		ID = 0;
		nombre = null;
		apellido = null;
		grado = null;
		this.siguiente = null;
	}
	public Estudiante(int ID,String Nombre,String Apellido,String Grado,Estudiante siguiente) {
		
		this.ID = ID;
		this.nombre = Nombre;
		this.apellido = Apellido;
		this.grado = Grado;
		this.siguiente = siguiente;
		
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
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
	public String getGrado() {
		return grado;
	}
	public void setGrado(String grado) {
		this.grado = grado;
	}
	
	public Estudiante getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(Estudiante siguiente) {
		this.siguiente = siguiente;
	}
	public Double getPromedio() {
		return promedio;
	}
	public void setPromedio(Double promedio) {
		this.promedio = promedio;
	}

}
