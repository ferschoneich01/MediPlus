package com.crud.demo.serviceInterface;

import java.util.List;
import java.util.Optional;

import com.crud.demo.modelo.User;

public interface IUserService {
	public List<User> listar();

	public Optional<User> listarId(int id);

	public int save(User p);

	public void delete(int id);
	
	public boolean verifyUser(String username, String Password);
	
	public boolean verifyRegister(User u);
}
