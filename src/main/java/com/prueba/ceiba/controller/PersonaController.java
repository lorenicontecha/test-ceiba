package com.prueba.ceiba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.ceiba.model.Person;
import com.prueba.ceiba.service.IPersonaService;

@RestController
@RequestMapping("/api")
public class PersonaController {
	
	@Autowired
	private IPersonaService personaService;
	
	@PostMapping("/addPerson")
	public void addPerson(@RequestBody Person person) {
		 personaService.registrarPersona(person);
	}
	
	@GetMapping("/getPerson")
	public List<Person> getPerson(){
		return personaService.getPersonas();
	}

}
