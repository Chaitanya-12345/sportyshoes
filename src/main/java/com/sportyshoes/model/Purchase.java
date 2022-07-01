package com.sportyshoes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Purchase {
	@Id
	
	
	private int  id;
	private String user;
	private String productname;
    private String productprice;
	private String productcategory;

}
