package com.prueba.ceiba.repository;

import org.springframework.data.repository.CrudRepository;

import com.prueba.ceiba.entity.PersonaEntity;

public interface IPersonaRepository  extends CrudRepository<PersonaEntity, Long>{

}
