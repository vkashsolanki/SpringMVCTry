package com.mvc.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.hiber.FactroyProvider;
import com.mvc.models.Employee;

@Controller
public class ControllerClass 
{
	@GetMapping(value = "/")
	public String home(Model model)
	{
		model.addAttribute("title", "RegisterPage");
		return "index";
	}

//	@PostMapping(value = "/register")

//	public String register(@RequestParam String name,@RequestParam String email,@RequestParam String password,@RequestParam String mobile,Model model)
//	{
//	Employee employee=new Employee();
//	employee.setName(name);
//	employee.setEmail(email);
//	employee.setMobile(mobile);
//	employee.setPassword(password);
//	
//	model.addAttribute("emp", employee);
//		return "contect";
//
//	}	
	

	@PostMapping(value = "/register")
	public String register(@ModelAttribute Employee employee,Model model)
	{
	SessionFactory factory=FactroyProvider.getFactory();
    Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(employee);
		transaction.commit();
    session.close();
	model.addAttribute("emp", employee);
		return "login";		
	}	

	@PostMapping(value = "/login")
	public String login(@ModelAttribute Employee employee,Model model,HttpServletRequest request,HttpServletResponse response)
	{
	SessionFactory factory=FactroyProvider.getFactory();
    Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		
		String q="from Employee where email=:e and password=:p";
		
		Query query=session.createQuery(q);
		query.setParameter("e", employee.getEmail());
		query.setParameter("p", employee.getPassword());
		Employee employee2=(Employee) query.uniqueResult();
		model.addAttribute("emp", employee);
		if(employee2==null)
	    {
        	try {
        		
			PrintWriter out=response.getWriter();
			out.println("Invalid Email or Password");
			RequestDispatcher dispatcher=request.getRequestDispatcher("login");
					dispatcher.include(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    }
		transaction.commit();
    session.close();
    
    
    return "SocialMedia";		
    
	}	
	
	
}
