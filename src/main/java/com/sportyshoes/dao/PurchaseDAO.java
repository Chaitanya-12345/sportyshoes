package com.sportyshoes.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.model.Purchase;
import com.sportyshoes.repository.PurchaseRepository;

@Service
public class PurchaseDAO {
	@Autowired
	PurchaseRepository repo;
	
	public Purchase insert(Purchase p1) {
		return repo.save(p1);
	}
	public List<Purchase>insertall(List<Purchase> p1){
		return repo.saveAll(p1);
	}
	public List<Purchase> getall(){
		return repo.findAll();
	}
	public String deleteById(Purchase p1) {
		repo.delete(p1);
		return "deleted the id value: "+p1;
	}
	
	public Purchase update(Purchase p1) {
		Purchase pp1=repo.findById(p1.getId()).orElse(null);
		pp1.setUser(p1.getUser());
		pp1.setProductname(p1.getProductname());
		pp1.setProductcategory(p1.getProductcategory());
		pp1.setProductprice(p1.getProductprice());
		return repo.save(pp1);
		
	}
	
	}



