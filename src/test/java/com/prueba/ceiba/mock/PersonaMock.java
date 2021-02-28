package com.prueba.ceiba.mock;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.http.HttpStatus;

import com.prueba.ceiba.constantes.PersonaConstantes;
import com.prueba.ceiba.model.Persona;
import com.prueba.ceiba.model.Respuesta;

public class PersonaMock {

	public static Persona getPersonaMockMayor18() {
		ZoneId defaultZoneId = ZoneId.systemDefault();
		LocalDate date = LocalDate.now().minusYears(19);
		Date date19year = Date.from(date.atStartOfDay(defaultZoneId).toInstant());
		return new Persona(12345, "daniel", date19year, "prada");
	}

	
	public static Persona getPersonaMockEdad17() {
		ZoneId defaultZoneId = ZoneId.systemDefault();
		LocalDate date = LocalDate.now().minusYears(17);
		Date date19year = Date.from(date.atStartOfDay(defaultZoneId).toInstant());
		return new Persona(12346, "daniel", date19year, "prada");
	}
	
	
	public static Persona getPersonaMockEdad18() {
		ZoneId defaultZoneId = ZoneId.systemDefault();
		LocalDate date = LocalDate.now().minusYears(18);
		Date date19year = Date.from(date.atStartOfDay(defaultZoneId).toInstant());
		return new Persona(12347, "daniel", date19year, "prada");
	}
	
	public static Respuesta getResponseMockMayor18() {
		return new Respuesta(HttpStatus.BAD_REQUEST.value(), PersonaConstantes.MENSAJE_EDAD_INCORRECTA,
				new ArrayList<>());
	}
	
	public static Respuesta getResponseCorrecto() {
		return new Respuesta(HttpStatus.OK.value(), PersonaConstantes.MENSAJE_OK, new ArrayList<>());
	}

}
