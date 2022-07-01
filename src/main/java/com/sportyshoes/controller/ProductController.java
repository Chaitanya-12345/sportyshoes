package com.sportyshoes.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sportyshoes.dao.ProductDAO;

import com.sportyshoes.model.Product;


@Controller

public class ProductController {

	@Autowired
		ProductDAO dao;
		
		@RequestMapping("/productinsert")
		public ModelAndView productinsert(HttpServletRequest req,HttpServletResponse res) {
			String id=req.getParameter("id");
			int uid=Integer.parseInt(id);
	     String name=req.getParameter("name");
			String price=req.getParameter("price");
			String category=req.getParameter("category");
			
			Product p=new Product();
			p.setId(uid);
			p.setName(name);
			p.setPrice(price);
			p.setCategory(category);
			Product pd=dao.insert(p);
			ModelAndView mv=new ModelAndView();
			
			if(pd!=null) {
				mv.setViewName("productinsertsuccess.jsp");
				}
				return mv;
		}
		
	@RequestMapping("/productgetall")
	public ModelAndView getProduct(HttpServletRequest req,HttpServletResponse res) {
		ModelAndView mv=new ModelAndView();
		List<Product> list=dao.getall();
		mv.setViewName("Productdisplay.jsp");
		mv.addObject("list",list);
		return mv;
	}
	@RequestMapping("/productupdate")
	public ModelAndView updateProduct(HttpServletRequest req,HttpServletResponse res) {
		String id=req.getParameter("id");
		int uid=Integer.parseInt(id);
     String name=req.getParameter("name");
		String price=req.getParameter("price");
		String category=req.getParameter("category");
		
		Product p=new Product();
		p.setId(uid);
		p.setName(name);
		p.setPrice(price);
		p.setCategory(category);
		
		
		Product ud=dao.update(p);
		ModelAndView mv=new ModelAndView();
		if(ud!=null) {
			mv.setViewName("Productupdatesuccess.jsp");
			}
			return mv;
	}
		
	@RequestMapping("/productdelete")
	public ModelAndView deleteProduct(HttpServletRequest req,HttpServletResponse res) {
		String id=req.getParameter("id");
		int uid=Integer.parseInt(id);

		Product p=new Product();
		p.setId(uid);
		String ud=dao.deleteById(p);
		ModelAndView mv=new ModelAndView();
		if(ud!=null) {
			mv.setViewName("Productdeletesuccess.jsp");
			}
			return mv;
	}
		
			}
