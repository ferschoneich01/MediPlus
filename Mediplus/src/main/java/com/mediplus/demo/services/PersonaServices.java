package com.mediplus.demo.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediplus.demo.IntefazServices.IPersonaServices;
import com.mediplus.demo.Interfaces.IPersona;
import com.mediplus.demo.model.Persona;

@Service
public class PersonaServices implements IPersonaServices{
	
	@Autowired	
	private IPersona data;
			
	public List<Persona> listar() {
		// TODO Auto-generated method stub
		return (List<Persona>)data.findAll();
	}

	public Optional<Persona> listarId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int save(Persona p) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
