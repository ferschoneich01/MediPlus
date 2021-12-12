package com.crud.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.demo.modelo.User;
import com.crud.demo.modeloDAO.IUser;
import com.crud.demo.serviceInterface.IUserService;


@Service
public class UserService implements IUserService {

	@Autowired
	private IUser dao;
	
	@Override
	public List<User> listar() {		
		return (List<User>) dao.findAll();
	}

	@Override
	public Optional<User> listarId(int id) {		
		return dao.findById(id);
	}

	@Override
	public int save(User p) {
		int res=0;
		User per=dao.save(p);
		if(!per.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		dao.deleteById(id);
		
	}

	@Override
	public boolean verifyUser(String Username, String Password) {
		boolean flag = false;
		for(int  i =0; i < listar().size(); i++) {
			if(listar().get(i).getUsername().equals(Username) && listar().get(i).getPassword().equals(Password)) {
				flag = true;
			}
		}
		
		return flag;
		
	}

	@Override
	public boolean verifyRegister(User u) {
		boolean flag = false;
		if(!u.getUsername().equals("") && !u.getPassword().equals("") && !u.getFullname().equals("") && !u.getAddres().equals("") &&
				!u.getBirthday().equals("") && !u.getCity().equals("") && !u.getCountry().equals("")) {
			flag = true;
		}
		return flag;
	}

}
