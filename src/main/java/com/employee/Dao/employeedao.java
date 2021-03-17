package com.employee.Dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.employee.Model.EmployeeEntity;
import com.employee.Model.loginEntity;

@Component
public class employeedao {
	@Autowired
	SessionFactory sf;
	
	@Transactional
	public Boolean CheckLogin(String username,String password)
	{
//		Session session=sf.getCurrentSession();
//		Query query=session.createQuery("from login where username=:a and password=:b");
//		query.setParameter("a",username);
//		query.setParameter("b",password);
//		if(!(query.uniqueResult()==null))
//		{
//			return true;
//		}
//		return false;
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();        
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));        
		messageConverters.add(converter);  
		RestTemplate resttemplate=new RestTemplate();
		resttemplate.setMessageConverters(messageConverters); 
		//
		ResponseEntity<loginEntity[]> response =
				  resttemplate.getForEntity(
				  "http://localhost:8081/EmployeeSpring/login",
				  loginEntity[].class);
				loginEntity[] logins = response.getBody();
				List<loginEntity> login=Arrays.asList(logins);
				if(!login.isEmpty())
				{
					if(login.get(0).getUsername().equals(username) && login.get(0).getPassword().equals(password))
					{
						return true;
					}
				}
		       return false;
		
	}
@Transactional
	public List<EmployeeEntity> getData() {
//		Session session=sf.getCurrentSession();
//		Query query=session.createQuery("from employeetab");
//		List<EmployeeEntity> employees=query.list();
//		return employees;
	List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();        
	MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
	converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));        
	messageConverters.add(converter);  
	RestTemplate resttemplate=new RestTemplate();
	resttemplate.setMessageConverters(messageConverters); 
	//
	ResponseEntity<EmployeeEntity[]> response =
			  resttemplate.getForEntity(
			  "http://localhost:8081/EmployeeSpring/Employee",
			  EmployeeEntity[].class);
			EmployeeEntity[] employees = response.getBody();
			List<EmployeeEntity> employeesList=Arrays.asList(employees);
	       return employeesList;
}
@Transactional
public void addData(EmployeeEntity employee) {

	RestTemplate resttemplate=new RestTemplate();
	HttpEntity<EmployeeEntity> entity = new HttpEntity<EmployeeEntity>(employee);
	resttemplate.exchange("http://localhost:8081/EmployeeSpring/Employee/update",HttpMethod.POST,entity,String.class).getBody();
}
@Transactional
public void update(EmployeeEntity employee) {
	RestTemplate resttemplate=new RestTemplate();
	HttpEntity<EmployeeEntity> entity = new HttpEntity<EmployeeEntity>(employee);
	resttemplate.exchange("http://localhost:8081/EmployeeSpring/Employee/saveorupdate",HttpMethod.POST,entity,String.class).getBody();
	System.out.println("dataupdated");
}
}
