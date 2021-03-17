package com.employee.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.employee.Dao.employeedao;
import com.employee.Model.EmployeeEntity;

@Controller
public class webController {
    @Autowired
    employeedao logindao;
	
	@RequestMapping("/")
	public String login()
    {
    	return "login";
    }
    @RequestMapping("/employees")
    public ModelAndView loginController(@RequestParam(required=false,name="username") String username,@RequestParam(required=false,name="password") String password,HttpSession session)
	{
    	ModelAndView mv=new ModelAndView();
		System.out.println("Hellowrold"+username+password);
		if(username==null || password==null)
		{
			username="";
			password="";
		}
		if(logindao.CheckLogin(username,password)==true)
		{
			
			session.setAttribute("username",username);
			List<EmployeeEntity> employeesList=logindao.getData();
			session.setAttribute("employeelist",employeesList);
			mv.setViewName("ShowEmployees");
		return mv;
		}
		else {
			mv.setViewName("login");
		return mv;
		}
	}
    @RequestMapping("/Employee")
   public ModelAndView employees(HttpSession session)
    {
    	ModelAndView mv=new ModelAndView();
    	List<EmployeeEntity> employees=logindao.getData();
    	session.setAttribute("employeelist",employees);
		mv.setViewName("ShowEmployees");
		return mv;
    }
		@RequestMapping("/home.htm")
		public ModelAndView homeController(@RequestParam(required = false,name="EmpName") String name,@RequestParam(required = false,name="EmpLocation") String location,@RequestParam(required = false,name="EmpEmail") String email,@RequestParam(required = false,name="EmpDOB") String dob) {
			EmployeeEntity employee=new EmployeeEntity();
		employee.setEmployee_Name(name);
		employee.setDate_of_Birth(dob);
		employee.setEmail(email);
		employee.setLocation(location);
		logindao.addData(employee);
			ModelAndView mv=new ModelAndView("Home");
			return mv;
		}
		@RequestMapping("/backHome")
		public String backtoHome()
		{
			return "Home";
		}
		@RequestMapping("/logout")
		public String logout(HttpSession session)
		{
			session.removeAttribute("username");
			session.invalidate();
			return "login";
		}
		@RequestMapping("/editEmployee")
		public ModelAndView editemployee(@RequestParam(name="empcode") int empcode,HttpSession session)
		{
			ModelAndView mv=new ModelAndView();
			mv.setViewName("EditEmployee");
			session.setAttribute("empcode",empcode);
			return mv;
		}
		@RequestMapping("/update")
		public ModelAndView editsave(HttpSession session,@RequestParam(required = false,name="EmpName") String name,@RequestParam(required = false,name="EmpLocation") String location,@RequestParam(required = false,name="EmpEmail") String email,@RequestParam(required = false,name="EmpDOB") String dob)
		{
			ModelAndView mv=new ModelAndView();
			EmployeeEntity employee=new EmployeeEntity();
			employee.setEmployee_Name(name);
			employee.setDate_of_Birth(dob);
			employee.setEmail(email);
			employee.setLocation(location);
			employee.setEmployee_Code(Integer.parseInt(""+session.getAttribute("empcode")));
			logindao.update(employee);
			mv.setViewName("EditEmployee");
			return mv;
		}
	}
