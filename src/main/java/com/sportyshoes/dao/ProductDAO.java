package com.sportyshoes.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.model.Product;
import com.sportyshoes.repository.ProductRepository;

@Service
public class ProductDAO {
	@Autowired
	ProductRepository repo;
	
	public Product insert(Product p) {
		return repo.save(p);
	}
	public List<Product>insertall(List<Product> p){
		return repo.saveAll(p);
	}
	public List<Product> getall(){
		return repo.findAll();
	}
	public String deleteById(Product p) {
		repo.delete(p);
		return "deleted the id value: "+p;
	}
	
	public Product update(Product p) {
		Product pp=repo.findById(p.getId()).orElse(null);
		pp.setName(p.getName());
		pp.setPrice(p.getPrice());
		pp.setCategory(pp.getCategory());
		return repo.save(pp);
		
	}

}
