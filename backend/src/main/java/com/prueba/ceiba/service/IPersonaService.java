package com.prueba.ceiba.service;

import com.prueba.ceiba.dto.Persona;
import com.prueba.ceiba.dto.Respuesta;

public interface IPersonaService {
	
	public Respuesta registrarPersona(Persona persona);
	public Respuesta getPersonas();

}
