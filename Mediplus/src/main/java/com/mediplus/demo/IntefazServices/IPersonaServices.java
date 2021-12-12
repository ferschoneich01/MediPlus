package com.mediplus.demo.IntefazServices;

import java.util.List;
import java.util.Optional;
import com.mediplus.demo.model.Persona;

public interface IPersonaServices {
	public List<Persona>listar();
	public Optional<Persona>listarId(int id);
	public int save(Persona p);
	public void delete(int id);
}
