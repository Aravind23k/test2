package com.accenture.sts.service;


import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.accenture.sts.controller.LoginController;
import com.accenture.sts.dao.LoginDAO;
import com.accenture.sts.entity.Employee;
import com.accenture.sts.entity.Upload_ticket;


public class LoginServiceImpl implements LoginService {
	private static Logger log = Logger.getLogger(LoginController.class);
	@Autowired
	private LoginDAO loginDAO;

	public Employee searchResource(String emp_Id, String pass) {
		
		log.info("Entering searchResource service Implementation");
		Employee employee = new Employee();
		try {
			employee = loginDAO.searchResource(emp_Id, pass);
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error("Exception e", exception);
		}
		return employee;
	}

	@Override
	public int changepwd(String empID, Employee employee)  {
		
		log.info("Entering changepassword service Implementation");
		int status = 0;
		try {
			status = loginDAO.changepwd(empID, employee);
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error("Exception e", exception);
		}
		return status;
	}
	public List<Upload_ticket> showDate() {

		log.info("Entering showDate service Implementation");
		List<Upload_ticket> showDate = null;
		try {
			showDate = loginDAO.showDate();
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error("Exception e", exception);
		}
		return showDate;
	}
	
	public List<Upload_ticket> showCreate() {

		log.info("Entering showCreate service Implementation");
		List<Upload_ticket> showCreate = null;
		try {
			showCreate = loginDAO.showCreate();
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error("Exception e", exception);
		}
		return showCreate;
	}

}
