package com.sportyshoes.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sportyshoes.dao.PurchaseDAO;
import com.sportyshoes.model.Purchase;

@Controller

public class PurchaseController {
	@Autowired
	PurchaseDAO dao;
	
	@RequestMapping("/purchaseinsert")
	public ModelAndView insert(HttpServletRequest req,HttpServletResponse res) {
		String id=req.getParameter("id");
		int uid=Integer.parseInt(id);
		String user=req.getParameter("user");
     String productname=req.getParameter("productname");
		String productprice=req.getParameter("productprice");
		String productcategory=req.getParameter("productcategory");
		
		Purchase p1=new Purchase();
		p1.setId(uid);
		p1.setUser(user);
		p1.setProductname(productname);
		p1.setProductprice(productprice);
		p1.setProductcategory(productcategory);
		
		Purchase pd=dao.insert(p1);
		ModelAndView mv=new ModelAndView();
		
		if(pd!=null) {
			mv.setViewName("Purchaseinsertsuccess.jsp");
			}
			return mv;
	}
	
@RequestMapping("/purchasegetall")
public ModelAndView getPurchase(HttpServletRequest req,HttpServletResponse res) {
	ModelAndView mv=new ModelAndView();
	List<Purchase> list=dao.getall();
	mv.setViewName("Purchasedisplay.jsp");
	mv.addObject("list",list);
	return mv;
}
@RequestMapping("/purchaseupdate")
public ModelAndView updatePurchase(HttpServletRequest req,HttpServletResponse res) {
	String id=req.getParameter("id");
	int uid=Integer.parseInt(id);
	String user=req.getParameter("user");
 String productname=req.getParameter("productname");
	String productprice=req.getParameter("productprice");
	String productcategory=req.getParameter("productcategory");
	
	Purchase p1=new Purchase();
	p1.setId(uid);
	p1.setUser(user);
	p1.setProductname(productname);
	p1.setProductprice(productprice);
	p1.setProductcategory(productcategory);
	
	
	Purchase ud=dao.update(p1);
	ModelAndView mv=new ModelAndView();
	if(ud!=null) {
		mv.setViewName("Purchaseupdatesuccess.jsp");
		}
		return mv;
}
	
@RequestMapping("/purchasedelete")
public ModelAndView deletePurchase(HttpServletRequest req,HttpServletResponse res) {
	String id=req.getParameter("id");
	int uid=Integer.parseInt(id);

	Purchase p1=new Purchase();
	p1.setId(uid);
	String ud=dao.deleteById(p1);
	ModelAndView mv=new ModelAndView();
	if(ud!=null) {
		mv.setViewName("Purchasedeletesuccess.jsp");
		}
		return mv;
}
	
		}



