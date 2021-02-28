package com.prueba.ceiba.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.ceiba.dto.Persona;
import com.prueba.ceiba.dto.Respuesta;
import com.prueba.ceiba.service.IPersonaService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class PersonaController {

	@Autowired
	private IPersonaService personaService;

	@PostMapping("/addPerson")
	public Respuesta addPerson(@RequestBody Persona person,  HttpServletResponse response) {
		Respuesta respuesta = personaService.registrarPersona(person);
		response.setStatus(respuesta.getCodigoHttp());
		return respuesta;
	}

	@GetMapping("/getPerson")
	public Respuesta getPerson( HttpServletResponse response) {
		Respuesta respuesta = personaService.getPersonas();
		response.setStatus(respuesta.getCodigoHttp());
		return respuesta;
	}

}
