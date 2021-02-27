package com.prueba.ceiba.repository;

import org.springframework.data.repository.CrudRepository;

import com.prueba.ceiba.entity.PersonEntity;

public interface IPersonaRepository  extends CrudRepository<PersonEntity, Integer>{

}
