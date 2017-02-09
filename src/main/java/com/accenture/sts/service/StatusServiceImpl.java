package com.accenture.sts.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.accenture.sts.controller.StatusController;
import com.accenture.sts.dao.StatusDAO;
import com.accenture.sts.entity.Employee;
import com.accenture.sts.entity.Ticket;

public class StatusServiceImpl implements StatusService {
	private static Logger log = Logger.getLogger(StatusController.class);
	@Autowired
	private StatusDAO statusDAO;

	public List<Object[]> getAllReport(Employee employee, Ticket ticket) {

		log.info("Entering getAllReport service Implementation");
		List<Object[]> Tickets = new ArrayList<Object[]>();
		try {
			Tickets = statusDAO.showAllReport(employee, ticket);
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error("Exception e", exception);
		}
		return Tickets;
	}

	public List<Employee> getAllResource() {

		log.info("Entering getAllResource service Implementation");
		List<Employee> resList = new ArrayList<Employee>();
		try {
			resList = statusDAO.showAllResource();
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error("Exception e", exception);
		}
		return resList;
	}

	public List<Object[]> getTicketstatus(String ticketid, String resource) {

		log.info("Entering getTicketstatus service Implementation");
		List<Object[]> showtickets = new ArrayList<Object[]>();
		try {
			showtickets = statusDAO.showticketstatus(ticketid, resource);
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error("Exception e", exception);
		}
		return showtickets;
	}

	public List<Object[]> getDaystatus(String ticketid, String resource, String days) {

		log.info("Entering getDaystatus service Implementation");
		List<Object[]> showdays = new ArrayList<Object[]>();
		try {
			showdays = statusDAO.showdaystatus(ticketid, resource, days);
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error("Exception e", exception);
		}
		return showdays;
	}

	public List<Object[]> namelist() {

		log.info("Entering namelist service Implementation");
		List<Object[]> resname = new ArrayList<Object[]>();
		try {
			resname = statusDAO.resname();
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error("Exception e", exception);
		}
		return resname;
	}

	public List<Object[]> applist() {

		log.info("Entering applist service Implementation");
		List<Object[]> applist = new ArrayList<Object[]>();
		try {
			applist = statusDAO.applist();
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error("Exception e", exception);
		}
		return applist;
	}

	public List<Object[]> getAllResource(String resname, String appname, String activity, String curname,
			String release,  String startDateFrom, String startDateTo, String endDateFrom, String endDateTo) {

		log.info("Entering getAllResource service Implementation");
		List<Object[]> showResource = new ArrayList<Object[]>();
		try {
			showResource = statusDAO.showAllResource(resname, appname, activity, curname, release,
					startDateFrom, startDateTo, endDateFrom, endDateTo);
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error("Exception e", exception);
		}
		return showResource;
	}

	public List<Object[]> getDailystatus() throws ClassNotFoundException, SQLException {

		log.info("Entering getDailystatus service Implementation");
		List<Object[]> insert = null;
		try {
			insert = statusDAO.getDailystatus();
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error("Exception e", exception);
		}
		return insert;
	}

	public List<Object[]> getInprogressTicket() throws ClassNotFoundException, SQLException {

		log.info("Entering getInprogressTicket service Implementation");
		List<Object[]> insert = null;
		try {
			insert = statusDAO.getInprogressTicket();
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error("Exception e", exception);
		}
		return insert;
	}

	public List<Object[]> getNotreportedList() throws ClassNotFoundException, SQLException {

		log.info("Entering getNotreportedList service Implementation");
		List<Object[]> insert = null;
		try {
			insert = statusDAO.getNotreportedList();
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error("Exception e", exception);
		}
		return insert;
	}

	public List<Object[]> allclarify() {

		log.info("Entering allclarify service Implementation");
		List<Object[]> showClarify = new ArrayList<Object[]>();
		try {
			showClarify = statusDAO.showclarify();
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error("Exception e", exception);
		}
		return showClarify;
	}

	public List<Object[]> toClarify(String ticketID) {

		log.info("Entering toClarify service Implementation");
		List<Object[]> Tickets = new ArrayList<Object[]>();
		try {
			Tickets = statusDAO.toclarify(ticketID);
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error("Exception e", exception);
		}
		return Tickets;
	}

	public int calrify(String ticketID, String supervisorcomment) {

		log.info("Entering calrify service Implementation");
		int status = 0;
		try {
			status = statusDAO.clarify(ticketID, supervisorcomment);
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error("Exception e", exception);
		}
		return status;
	}

	public int responseclarification(String ticketID, String employee_response, String supervisorComment) {

		log.info("Entering responseclarification service Implementation");
		int status = 0;
		try {
			status = statusDAO.responseclarification(ticketID, employee_response, supervisorComment);
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error("Exception e", exception);
		}
		return status;
	}

	public List<Object[]> assignedClarification(String empID) {

		log.info("Entering assignedClarification service Implementation");
		List<Object[]> ticketList = new ArrayList<Object[]>();
		try {
			ticketList = statusDAO.assignedClarification(empID);

		} catch (Exception exception) {
			exception.printStackTrace();
			log.error("Exception e", exception);
		}
		return ticketList;
	}

	public int deleteclarification(String ticketID, String supervisor_comment) {

		log.info("Entering deleteclarification service Implementation");
		int status = 0;
		try {
			status = statusDAO.deleteclarification(ticketID, supervisor_comment);

		} catch (Exception exception) {
			exception.printStackTrace();
			log.error("Exception e", exception);
		}
		return status;
	}

}
