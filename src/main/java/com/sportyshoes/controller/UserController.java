package com.sportyshoes.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sportyshoes.dao.UserDAO;
import com.sportyshoes.model.User;


@Controller

public class UserController {
	@Autowired
	UserDAO dao;
	
	@RequestMapping("/userinsert")
	public ModelAndView userinsert(HttpServletRequest req,HttpServletResponse res) {
		String id=req.getParameter("id");
		int uid=Integer.parseInt(id);
     String firstname=req.getParameter("firstname");
		String lastname=req.getParameter("lastname");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		User u=new User();
		u.setId(uid);
		u.setFirstname(firstname);
		u.setLastname(lastname);
		u.setEmail(email);
		u.setPassword(password);
		
		User ud=dao.insert(u);
		ModelAndView mv=new ModelAndView();
		
		if(ud!=null) {
			mv.setViewName("Userinsertsuccess.jsp");
			}
			return mv;
	}
	
	@RequestMapping("/usergetall")
	public ModelAndView getUsers(HttpServletRequest req,HttpServletResponse res) {
		ModelAndView mv=new ModelAndView();
		List<User> list=dao.getall();
		mv.setViewName("Userdisplay.jsp");
		mv.addObject("list",list);
		return mv;
	}

	@RequestMapping("/userupdate")
	public ModelAndView updateUser(HttpServletRequest req,HttpServletResponse res) {
		String id=req.getParameter("id");
		int uid=Integer.parseInt(id);
     String firstname=req.getParameter("firstname");
		String lastname=req.getParameter("lastname");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		User u=new User();
		u.setId(uid);
		u.setFirstname(firstname);
		u.setLastname(lastname);
		u.setEmail(email);
		u.setPassword(password);
		
		User ud=dao.update(u);
		ModelAndView mv=new ModelAndView();
		if(ud!=null) {
			mv.setViewName("Userupdatesuccess.jsp");
			}
			return mv;
		
	}
	@RequestMapping("/userdelete")
	public ModelAndView deleteUser(HttpServletRequest req,HttpServletResponse res) {
		String id=req.getParameter("id");
		int uid=Integer.parseInt(id);

		User u=new User();
		u.setId(uid);
		String  ud=dao.deleteById(u);
		ModelAndView mv=new ModelAndView();
		if(ud!=null) {
			mv.setViewName("Userdeletesuccess.jsp");
			}
			return mv;
	}
		
	
	
}

	



