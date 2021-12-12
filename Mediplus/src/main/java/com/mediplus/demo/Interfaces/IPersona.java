package com.mediplus.demo.Interfaces;

import com.mediplus.demo.model.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersona extends CrudRepository<Persona, Integer>{
	
}
