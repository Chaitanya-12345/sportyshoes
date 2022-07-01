package com.sportyshoes.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sportyshoes.dao.ProductDAO;
import com.sportyshoes.dao.UserDAO;

import com.sportyshoes.model.Product;
import com.sportyshoes.model.User;

@Controller

public class AdminController {
	@Autowired
	UserDAO dao;
	
	@RequestMapping("/Login")
	public ModelAndView login(HttpServletRequest req,HttpServletResponse res) {
		
     String username=req.getParameter("username");
		String password=req.getParameter("password");
		

		ModelAndView mv=new ModelAndView();
		
		if(username.equals("admin")&& password.equals("admin"))
	 {
			mv.setViewName("Welcome.jsp");
			}
				else {
			    	  mv.setViewName("changepwd.jsp");
			      }
			    	  
			
			return mv;
}
      @RequestMapping("/changepw")
	public ModelAndView changepw(HttpServletRequest req,HttpServletResponse res) {
    String username=req.getParameter("username");
      String oldPwd=req.getParameter("OLDpwd");
      String newPwd=req.getParameter("newpassword");
      String conPwd=req.getParameter("conpassword");
      
      ModelAndView mv=new ModelAndView();
      if(newPwd.equals(conPwd)) {
      dao.changepwd(username, conPwd);
      mv.setViewName("changepwdsuccess.jsp");
      }
      else {
    	  mv.setViewName("changepw.jsp");
      }
    	  
      return mv;
	}
      @RequestMapping("/Logout")
  	public ModelAndView logout(HttpServletRequest req,HttpServletResponse res) {
  		
    	  ModelAndView mv=new ModelAndView();
    	  mv.setViewName("Logout.jsp");
      
    	  return mv;
}
}
