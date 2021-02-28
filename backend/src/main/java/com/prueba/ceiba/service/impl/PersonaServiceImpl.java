package com.prueba.ceiba.service.impl;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.prueba.ceiba.constantes.PersonaConstantes;
import com.prueba.ceiba.converter.PersonaConversor;
import com.prueba.ceiba.dto.Persona;
import com.prueba.ceiba.dto.Respuesta;
import com.prueba.ceiba.entity.PersonaEntity;
import com.prueba.ceiba.repository.IPersonaRepository;
import com.prueba.ceiba.service.IPersonaService;

@Service
public class PersonaServiceImpl implements IPersonaService {

	@Autowired
	private IPersonaRepository personaRepository;

	@Autowired
	private PersonaConversor conversor;

	@Override
	public Respuesta registrarPersona(Persona person) {

		if (this.cedulaInvalida(person)) {
			return new Respuesta(HttpStatus.BAD_REQUEST.value(), PersonaConstantes.MENSAJE_CEDULA_INCORRECTA,
					new ArrayList<>());
		}

		if (!this.edadValida(person)) {
			return new Respuesta(HttpStatus.BAD_REQUEST.value(), PersonaConstantes.MENSAJE_EDAD_INCORRECTA,
					new ArrayList<>());
		}

		PersonaEntity personaEntity = conversor.converterToEntity(person);

		try {
			personaRepository.save(personaEntity);
			return new Respuesta(HttpStatus.OK.value(), PersonaConstantes.MENSAJE_OK, new ArrayList<>());
		} catch (Exception e) {
			return new Respuesta(HttpStatus.BAD_REQUEST.value(), PersonaConstantes.MENSAJE_ERROR_NO_ESPERADO,
					new ArrayList<>());
		}

	}

	private boolean cedulaInvalida(Persona person) {

		return person != null ? personaRepository.existsById(person.getCedula()) : true;
	}

	private boolean edadValida(Persona person) {
		if (person != null) {
			Integer edad = calcularEdad(person);
			return edad != null && edad > PersonaConstantes.EDAD_MAXIMA;
		}

		return false;
	}

	private Integer calcularEdad(Persona person) {
		LocalDate fechaNacimiento = convertToLocalDate(person.getFecha());
		LocalDate fechaActual = LocalDate.now();
		Period periodo = Period.between(fechaNacimiento, fechaActual);
		return periodo.getYears();
	}

	public LocalDate convertToLocalDate(Date fechaNacimiento) {
		return Instant.ofEpochMilli(fechaNacimiento.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
	}

	@Override
	public Respuesta getPersonas() {
		try {
			List<PersonaEntity> listaPersonasEntity = (List<PersonaEntity>) personaRepository.findAll();
			List<Persona> listaPersonasModel = new ArrayList<>();
			listaPersonasEntity.forEach(x -> listaPersonasModel.add(conversor.converterToModel(x)));
			return new Respuesta(HttpStatus.OK.value(), PersonaConstantes.MENSAJE_OK, listaPersonasModel);

		} catch (Exception e) {
			return new Respuesta(HttpStatus.BAD_REQUEST.value(), PersonaConstantes.MENSAJE_ERROR_NO_ESPERADO,
					new ArrayList<>());
		}

	}

}
