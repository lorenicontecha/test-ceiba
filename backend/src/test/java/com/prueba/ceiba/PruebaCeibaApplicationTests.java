package com.prueba.ceiba;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.prueba.ceiba.dto.Persona;
import com.prueba.ceiba.dto.Respuesta;
import com.prueba.ceiba.mock.PersonaMock;
import com.prueba.ceiba.service.IPersonaService;

@SpringBootTest
class PruebaCeibaApplicationTests {
	
	@Autowired
	private IPersonaService personaService;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void cedulaIncorrectaMayor18() {
		Persona persona = PersonaMock.getPersonaMockMayor18();
		
		Respuesta respuesta = personaService.registrarPersona(persona);
		
		assertEquals(respuesta.getMensaje(), PersonaMock.getResponseMockMayor18().getMensaje());
		
	}
	
	@Test
	public void cedulaIncorrecta18() {
		Persona persona = PersonaMock.getPersonaMockEdad18();
		
		Respuesta respuesta = personaService.registrarPersona(persona);
		
		assertEquals(respuesta.getMensaje(), PersonaMock.getResponseMockMayor18().getMensaje());
		
	}
	
	@Test
	public void cedulaCorrecta() {
		Persona persona = PersonaMock.getPersonaMockEdad17();
		
		Respuesta respuesta = personaService.registrarPersona(persona);
		
		assertEquals(respuesta.getMensaje(), PersonaMock.getResponseCorrecto().getMensaje());
		
	}

}
