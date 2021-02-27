package com.prueba.ceiba.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Persona")
public class PersonaEntity {

	@Id
	private long cedula;
	private String nombre;
	@Temporal(TemporalType.DATE)
	private Date fecha;
	private String apellido;
	
	public PersonaEntity() {}

	public PersonaEntity(long cedula, String nombre, Date fecha, String apellido){
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
