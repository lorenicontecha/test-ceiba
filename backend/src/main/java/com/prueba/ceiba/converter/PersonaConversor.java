package com.prueba.ceiba.converter;

import org.springframework.stereotype.Component;

import com.prueba.ceiba.dto.Persona;
import com.prueba.ceiba.entity.PersonaEntity;

@Component
public class PersonaConversor {

	public Persona converterToModel(PersonaEntity personaEntity) {

		return personaEntity != null
				? new Persona(personaEntity.getCedula(), personaEntity.getNombre(), personaEntity.getFecha(),
						personaEntity.getApellido())
				: null;
	}

	public PersonaEntity converterToEntity(Persona persona) {

		return persona != null
				? new PersonaEntity(persona.getCedula(), persona.getNombre(), persona.getFecha(), persona.getApellido())
				: null;
	}

}
