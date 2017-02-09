package com.accenture.sts.service;


import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.accenture.sts.controller.TicketController;
import com.accenture.sts.dao.TicketDAO;
import com.accenture.sts.entity.Application;
import com.accenture.sts.entity.Dev_comment;
import com.accenture.sts.entity.Documentation;
import com.accenture.sts.entity.Employee;
import com.accenture.sts.entity.Tester_comment;
import com.accenture.sts.entity.Ticket;
import com.accenture.sts.entity.Upload_ticket;

public class TicketServiceImpl implements TicketService {
	private static Logger log = Logger.getLogger(TicketController.class);
	@Autowired
	private TicketDAO ticketDAO;

	@Override
	public List<Application> getAllApp() {

		log.info("Entering getAllApp service Implementation");
		List<Application> appList = new ArrayList<Application>();
		try {
			appList = ticketDAO.showAllApp();
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error("Exception e", exception);
		}
		return appList;
	}

	@Override
	public boolean addticket(String empID, String ticketid, String ticket_desc, Employee employee, Application appl)  {

		log.info("Entering addticket service Implementation");
		boolean insertStatus = false;
		try {
			insertStatus = ticketDAO.addticket(empID, ticketid, ticket_desc, employee, appl);
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error("Exception e", exception);
		}
		return insertStatus;
	}

	@Override
	public List<Object[]> showDeleteTickets() {

		log.info("Entering showDeleteTickets service Implementation");
		List<Object[]> ticket = new ArrayList<>();
		try {
			ticket = ticketDAO.showDeleteTickets();
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error("Exception e", exception);
		}
		return ticket;
	}

	@Override
	public void deleteTicket(String ticket_id) {

		log.info("Entering deleteTicket service Implementation");
		try {
			ticketDAO.deleteTicket(ticket_id);
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error("Exception e", exception);
		}
	}

	@Override
	public List<Object[]> getclosedTickets(String empID) {

		log.info("Entering getclosedTickets service Implementation");
		List<Object[]> closedtickets = new ArrayList<Object[]>();
		try {
			closedtickets = ticketDAO.showclosedtickets(empID);
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error("Exception e", exception);
		}
		return closedtickets;

	}

	@Override
	public int updateDocumentDetails(String Ticketid, Documentation document, Ticket ticket1) {

		log.info("Entering updateDocumentDetails service Implementation");
		int status = 0;
		try {
			status = ticketDAO.updateDocument(Ticketid, document, ticket1);
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error("Exception e", exception);
		}
		return status;
	}

	@Override
	public List<Object[]> ticketList(String emp_Id) {

		log.info("Entering ticketList service Implementation");
		List<Object[]> ticket = new ArrayList<Object[]>();
		try {
			ticket = ticketDAO.ticketList(emp_Id);
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error("Exception e", exception);
		}
		return ticket;
	}

	@Override
	public List<Object[]> fetchTicket(String emp_Id) {

		log.info("Entering fetchTicket service Implementation");
		List<Object[]> showDocument = new ArrayList<Object[]>();
		try {
			showDocument = ticketDAO.showClosedTickets(emp_Id);
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error("Exception e", exception);
		}
		return showDocument;
	}

	@Override
	public int assignnewTicket(Employee emp, Ticket ticket, String ticket_id, String application_name) {

		log.info("Entering assignnewTicket service Implementation");
		int update = 0;
		try {
			update = ticketDAO.assignTicket(emp, ticket, ticket_id, application_name);
		} catch (Exception exception) {
			exception.printStackTrace();
			exception.printStackTrace();
			log.error("Exception e", exception);
		}
		return update;
	}

	@Override
	public List<Object[]> showToassign()  {

		log.info("Entering showToassign service Implementation");
		List<Object[]> insert = null;
		try {
			insert = ticketDAO.showToassign();
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error("Exception e", exception);
		}
		return insert;
	}

	@Override
	public List<Employee> showEmployee()  {

		log.info("Entering showEmployee service Implementation");
		List<Employee> emplist = null;
		try {
			emplist = ticketDAO.showEmployee();
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error("Exception e", exception);
		}
		return emplist;
	}

	public List<Object[]> showToreassign() {

		log.info("Entering showToreassign service Implementation");
		List<Object[]> insert = null;
		try {
			insert = ticketDAO.showToreassign();
		} catch (Exception exception) {
			exception.printStackTrace();
			exception.printStackTrace();
			log.error("Exception e", exception);
		}
		return insert;
	}

	public int reassignTicket(String oldemp, String newemp, Ticket ticket) {

		log.info("Entering reassignTicket service Implementation");
		int update = 0;
		try {
			update = ticketDAO.reassignTicket(oldemp, newemp, ticket);
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error("Exception e", exception);
		}
		return update;
	}

	@Override
	public int updateTicketDetails(Ticket ticket, Dev_comment dev, Tester_comment test, String app) {

		log.info("Entering updateTicketDetails service Implementation");
		int status = 0;
		try {
			status = ticketDAO.updateTicket(ticket, dev, test, app);
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error("Exception e", exception);
		}
		return status;

	}

	public Employee getEmployeeDetails(String empid) {

		log.info("Entering getEmployeeDetails service Implementation");
		Employee emp_list = null;
		try {
			emp_list = ticketDAO.getEmployeeDetails(empid);
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error("Exception e", exception);
		}
		return emp_list;

	}

	public Application getApplicationDetails(String app) {

		log.info("Entering getApplicationDetails service Implementation");
		Application app_list = null;
		try {
			app_list = ticketDAO.getApplicationDetails(app);
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error("Exception e", exception);
		}
		return app_list;
	}

	public int releaseTicket(String ticketId, String release) {

		log.info("Entering releaseTicket service Implementation");
		int status = 0;
		try {
			status = ticketDAO.releaseTicket(ticketId, release);
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error("Exception e", exception);
		}
		return status;
	}

	public List<Object[]> release() {

		log.info("Entering release service Implementation");
		List<Object[]> showTickets = new ArrayList<Object[]>();
		try {
			showTickets = ticketDAO.showRelease();
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error("Exception e", exception);
		}
		return showTickets;
	}
	
	public List<Upload_ticket> showDate() {

		log.info("Entering showDate service Implementation");
		List<Upload_ticket> insert = null;
		try {
			insert = ticketDAO.showDate();
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error("Exception e", exception);
		}
		return insert;	
	} 
}
