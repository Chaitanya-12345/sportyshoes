package com.sportyshoes.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;


import com.sportyshoes.model.Product;
import com.sportyshoes.model.User;
import com.sportyshoes.repository.UserRepository;

@Service

public class UserDAO {
	@Autowired
	UserRepository repo;
	
	public User insert(User u) {
		return repo.save(u);
	}
	public List<User>insertall(List<User> u){
		return repo.saveAll(u);
	}
	public List<User> getall(){
		return repo.findAll();
	}
	public String deleteById(User u) {
		repo.delete(u);
		return "deleted the id value: "+u;
	}
	
	public User update(User u) {
		User uu=repo.findById(u.getId()).orElse(null);
		uu.setFirstname(u.getFirstname());
		uu.setLastname(u.getLastname());
		uu.setEmail(u.getEmail());
		uu.setPassword(u.getPassword());
		return repo.save(uu);
		
	}
	public String changepwd(String username,String changepwd) {
		repo.updatePassword(username, changepwd);
		return "password changed successfully";
	}
}
	

