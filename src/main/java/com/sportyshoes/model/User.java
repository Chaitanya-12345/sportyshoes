package com.sportyshoes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class User {
	@Id
	  
	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	 
	
}
