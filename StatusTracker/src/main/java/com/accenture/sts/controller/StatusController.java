package com.accenture.sts.controller;

import javax.servlet.http.HttpServletRequest;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.accenture.sts.entity.Ticket;
import com.accenture.sts.service.StatusServiceImpl;

@Controller
public class StatusController 
{
	
@Autowired
private StatusServiceImpl sserviceimpl;

	@RequestMapping(value = "/assignticket.htm", method = RequestMethod.GET)
	public String assignTicket(HttpServletRequest request, HttpServletResponse response,ModelMap model) 
	{
		HttpSession session = request.getSession();
		String emp_id=(String) session.getAttribute( "employee_id" );
		System.out.println("employee id");
		System.out.println(emp_id);
		
		String employee_id=request.getParameter("employee_id");
		String ticket_id=request.getParameter("ticket_id");
		String application_id=request.getParameter("application_id");
		
		System.out.println(employee_id);
		System.out.println(ticket_id);
		System.out.println(application_id);
		
		//Ticket ticket = sserviceimpl.assignTicket(employee_id,ticket_id,application_id);
		
	//	model.addAttribute(ticket);
		
		return "assignticket";
	
	}
}
