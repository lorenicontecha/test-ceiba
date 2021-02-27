package com.prueba.ceiba.service;

import com.prueba.ceiba.model.Persona;
import com.prueba.ceiba.model.Respuesta;

public interface IPersonaService {
	
	public Respuesta registrarPersona(Persona persona);
	public Respuesta getPersonas();

}
