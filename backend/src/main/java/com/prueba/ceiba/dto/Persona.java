package com.prueba.ceiba.dto;

import java.io.Serializable;
import java.util.Date;

public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;
	private long cedula;
	private String nombre;
	private Date fecha;
	private String apellido;

	public Persona() {

	}

	public Persona(long cedula, String nombre, Date fecha, String apellido) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.fecha = fecha;
		this.apellido = apellido;
	}

	public long getCedula() {
		return cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}
