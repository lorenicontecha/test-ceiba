package com.prueba.ceiba.service;

import java.util.List;

import com.prueba.ceiba.model.Person;

public interface IPersonaService {
	
	public void registrarPersona(Person persona);
	public List<Person> getPersonas();

}
