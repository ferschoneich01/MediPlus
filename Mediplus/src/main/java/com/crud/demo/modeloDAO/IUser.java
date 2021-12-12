package com.crud.demo.modeloDAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crud.demo.modelo.User;

@Repository
public interface IUser extends CrudRepository<User, Integer>{

}
