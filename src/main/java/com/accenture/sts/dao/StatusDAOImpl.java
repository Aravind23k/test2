package com.accenture.sts.dao;

import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.accenture.sts.controller.StatusController;
import com.accenture.sts.entity.Application;
import com.accenture.sts.entity.Clarification;
import com.accenture.sts.entity.Dev_comment;
import com.accenture.sts.entity.Employee;
import com.accenture.sts.entity.Ticket;

public class StatusDAOImpl implements StatusDAO {
	private static Logger log = Logger.getLogger(StatusController.class);
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Employee> showAllResource() {
	
		log.info("Entering showAllResource DAO");
		sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Criteria criteria = session.createCriteria(Employee.class);
		criteria.addOrder(Order.asc("employee_name"));
		criteria.setProjection(Projections.property("employee_name"));
		List<Employee> res = criteria.list();

		session.getTransaction().commit();
		
		return res;
	}

	@SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
	@Override
	public List<Object[]> showticketstatus(String ticketid, String resource) {
		
		log.info("Entering showticketstatus DAO");
		sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List ticketList = null;

		Criteria criteria = session.createCriteria(Ticket.class, "ticket");
		criteria.setFetchMode("dev_comment", FetchMode.JOIN);
		criteria.setFetchMode("employee", FetchMode.JOIN);
		criteria.createAlias("dev_comment", "dev_comment");
		criteria.createAlias("employee", "employee");

		ProjectionList projList = Projections.projectionList();
		projList.add(Projections.distinct(Projections.property("ticket.ticket_id")));
		projList.add(Projections.property("ticket.ticket_type"));
		projList.add(Projections.property("ticket.employee"));
		projList.add(Projections.property("dev_comment.date"));
		projList.add(Projections.property("dev_comment.status"));
		projList.add(Projections.property("dev_comment.comment_desc"));
		criteria.setProjection(projList);

		if (ticketid.equals("select") && resource.equals("")) {
			ticketList = criteria.list();
		} else {

			if ((!ticketid.equals("select")) && resource.equals("")) {
				criteria.add(Restrictions.eq("ticket.ticket_id", ticketid));
				ticketList = criteria.list();
			} else if (ticketid.equals("select") && (!resource.equals(""))) {
				criteria.add(Restrictions.eq("employee.employee_name", resource));
				ticketList = criteria.list();
			} else {
				log.info("check in dao");
			}
		}
		session.getTransaction().commit();
		
		return ticketList;
	}

	@SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
	@Override
	public List<Object[]> showdaystatus(String ticketid, String resource, String days) {
		
		log.info("Entering showdaystatus DAO");
		int day = Integer.parseInt(days);
		day = day - 1;

		sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List dayList = null;

		Criteria criteria = session.createCriteria(Ticket.class, "ticket");
		criteria.setFetchMode("dev_comment", FetchMode.JOIN);
		criteria.setFetchMode("employee", FetchMode.JOIN);
		criteria.createAlias("dev_comment", "dev_comment");
		criteria.createAlias("employee", "employee");

		ProjectionList projList = Projections.projectionList();
		projList.add(Projections.property("ticket.ticket_id"));
		projList.add(Projections.property("ticket.ticket_type"));
		projList.add(Projections.property("ticket.employee"));
		projList.add(Projections.property("dev_comment.date"));
		projList.add(Projections.property("dev_comment.status"));
		projList.add(Projections.property("dev_comment.comment_desc"));
		criteria.setProjection(projList);

		if (ticketid.equals("select") && (!(resource.equals("")) && !(days.equals("")))) {
			criteria.add(Restrictions.eq("employee.employee_name", resource));
			criteria.add(Restrictions
					.sqlRestriction("date between DATE_SUB(curdate(), INTERVAL '" + day + "' DAY) and curdate()"));
			dayList = criteria.list();
		} else if (resource.equals("") && (!(ticketid.equals("select")) && !(days.equals("")))) {
			criteria.add(Restrictions.eq("ticket.ticket_id", ticketid));
			criteria.add(Restrictions
					.sqlRestriction("date between DATE_SUB(curdate(), INTERVAL '" + day + "' DAY) and curdate()"));
			dayList = criteria.list();
		} else {
			log.info("check in dao");
		}
		session.getTransaction().commit();
		
		return dayList;
	}

	@SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
	@Override
	public List<Object[]> showAllReport(Employee employee, Ticket ticket) {
		
		log.info("Entering showAllReport DAO");
		List TicketList = null;
		sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Criteria criteria = session.createCriteria(Ticket.class, "ticket");
		criteria.setFetchMode("dev_comment", FetchMode.JOIN);
		criteria.setFetchMode("employee", FetchMode.JOIN);
		criteria.setFetchMode("Application", FetchMode.JOIN);
		criteria.createAlias("dev_comment", "dev_comment");
		criteria.createAlias("employee", "employee");

		ProjectionList projList = Projections.projectionList();
		projList.add(Projections.property("ticket.employee"));
		projList.add(Projections.property("ticket.ticket_id"));
		projList.add(Projections.property("ticket.ticket_type"));
		projList.add(Projections.property("ticket.ticket_desc"));
		projList.add(Projections.property("ticket.application"));
		projList.add(Projections.property("ticket.priority"));
		projList.add(Projections.property("dev_comment.activity"));
		projList.add(Projections.property("dev_comment.status"));
		projList.add(Projections.property("dev_comment.comment_desc"));
		projList.add(Projections.property("ticket.start_date"));
		criteria.setProjection(projList);

		Date curdate = new Date();

		criteria.add(Restrictions.eq("ticket.worked_on_today", "yes"));
		criteria.add(Restrictions.eq("dev_comment.date", curdate));
		criteria.addOrder(Order.asc("employee.employee_name"));

		TicketList = criteria.list();
		session.getTransaction().commit();	
		return TicketList;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Object[]> resname() {
		
		log.info("Entering cresname DAO");
		List<Object[]> result = null;
		try {
			SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
			System.out.println("resDAOImplname...name");
			Session session = sessionfactory.getCurrentSession();
			session.beginTransaction();

			Criteria cr = session.createCriteria(Employee.class);
			cr.setProjection(Projections.property("employee_name"));
			cr.setProjection((Projections.groupProperty("employee_name")));

			result = cr.list();
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Object[]> applist() {
		
		log.info("Entering applist DAO");
		List<Object[]> result = null;
		try {
			SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
			System.out.println("resDAOImplname...name");
			Session session = sessionfactory.getCurrentSession();
			session.beginTransaction();

			Criteria cr = session.createCriteria(Application.class);
			cr.setProjection(Projections.property("application_name"));
			cr.setProjection((Projections.groupProperty("application_name")));
			result = cr.list();
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Object[]> showAllResource(String resname, String appname, String activity, String curname,
			String release, String startDateFrom, String startDateTo, String endDateFrom, String endDateTo) {

		log.info("Entering showAllResource DAO");
		sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Object[]> result = null;
		String hql="select "
			        +"employee1_.Employee_Name as y0_, "
			        +"this_.Ticket_ID as y1_, "
			        +"this_.Ticket_type as y2_, "
			        +"this_.Ticket_Desc as y3_, "
			        +"app2_.Application_Name as y4_, "
			        +"this_.Priority as y5_, "
			        +"dev_commen5_.Activity as y6_, "
			        +"dev_commen5_.Status as y7_,  "
			        +"tester_com3_.Tester as y8_, "
			        +"dev_commen5_.Comment_Desc as y9_, "
			        +"this_.Start_date as y10_, "
			        +"this_.End_date as y11_, "
			        +"documentat4_.Remedy as y12_, "
			        +"documentat4_.Document_Desc as y13_, "
			        +"this_.Release_ticket as y14_, "
			        +"this_.Ticket_ID as y15_ "
			        +"from "
			        +"Ticket_Details this_ " 
			        +"inner join "
			        +"Application app2_ " 
			        +"on this_.Application_ID=app2_.Application_ID "
			        +"left outer join "
			        +" ( select "
			        +"a.ticket_id, "
                    +"status, "
			        +"activity, "
		            +"Comment_Desc "    
			        +"from  "
	                +"Dev_Comment a "    
			        +"inner join "
			        +" ( "
			        +"select "
			        +"ticket_id, "
			        +"max(date) as date "       
			        +"from "
			        +"Dev_Comment "       
			        +"group by "
			        +"ticket_id "     
			        +") b "      
			        +"on a.ticket_id=b.ticket_id "      
			        +"and a.date = b.date "  
			        +")dev_commen5_ " 
			        +"on this_.Ticket_ID=dev_commen5_.Ticket_ID "      
			        +"left outer join "
			        +"Documentation documentat4_ " 
			        +"on this_.Ticket_ID=documentat4_.Ticket_ID "
			        +"inner join "
			        +"Employee_details employee1_ " 
			        +"on this_.Employee_ID=employee1_.Employee_ID "  
			        +"left outer join "
			        +"Tester_Comment tester_com3_ " 
			        +"on this_.Ticket_ID=tester_com3_.Ticket_ID "
			        +"where 1=1 ";
		String b = "";
		System.out.println("resname" + resname);
		if (resname != "") {
			hql += "and employee1_.Employee_Name= '" + resname + "'";
		}
		if (appname != "") {
			hql += "and app2_.Application_Name = '" + appname + "'";
		}
		if (curname != "") {
			hql += "and dev_commen5_.Status = '" + curname + "'";

		}
		if (activity != "") {
			hql += "and dev_commen5_.Activity = '" + activity + "'";
		}
		if (release != "") {
			hql += "and this_.Release_ticket = '" + release + "'";
		}
		if (startDateFrom != "") {
			hql += "and this_.Start_date between '" + startDateFrom + "' and '" + startDateTo + "'";
		}
		if (endDateFrom != "") {
			hql += "and this_.End_date between '" + endDateFrom + "' and '" + endDateTo + "'";
		}
		if (b == "") {
			hql += " group by this_.Ticket_ID";
		}
		Query query = session.createSQLQuery(hql);
		result = query.list();
		session.getTransaction().commit();
		return result;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Object[]> getDailystatus() {

		log.info("Entering getDailystatus DAO");
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.getCurrentSession();
		session.beginTransaction();

		Date date = new Date();

		Criteria criteria = session.createCriteria(Ticket.class, "Ticket");
		criteria.setFetchMode("employee", FetchMode.JOIN);
		criteria.setFetchMode("application", FetchMode.JOIN);
		criteria.setFetchMode("dev_comment", FetchMode.JOIN);
		criteria.createAlias("dev_comment", "dev_comment");

		ProjectionList projList = Projections.projectionList();

		projList.add(Projections.property("Ticket.employee"));
		projList.add(Projections.property("Ticket.ticket_id"));
		projList.add(Projections.property("Ticket.ticket_type"));
		projList.add(Projections.property("Ticket.ticket_desc"));
		projList.add(Projections.property("Ticket.application"));
		projList.add(Projections.property("Ticket.priority"));
		projList.add(Projections.property("dev_comment.activity"));
		projList.add(Projections.property("dev_comment.status"));
		projList.add(Projections.property("Ticket.updated_on"));
		projList.add(Projections.property("dev_comment.comment_desc"));
		projList.add(Projections.property("Ticket.worked_on_today"));

		criteria.setProjection(projList);
		criteria.add(Restrictions.eq("Ticket.updated_on", date));
		criteria.add(Restrictions.eq("dev_comment.date", date));
		List<Object[]> List = criteria.list();

		session.getTransaction().commit();	
		return List;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Object[]> getInprogressTicket() {

		log.info("Entering getInprogressTicket DAO");
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.getCurrentSession();
		session.beginTransaction();

		Criteria criteria = session.createCriteria(Ticket.class, "Ticket");
		criteria.setFetchMode("employee", FetchMode.JOIN);
		criteria.setFetchMode("application", FetchMode.JOIN);
		criteria.setFetchMode("dev_comment", FetchMode.JOIN);
		criteria.createAlias("dev_comment", "dev_comment");

		ProjectionList projList = Projections.projectionList();

		projList.add(Projections.distinct(Projections.property("Ticket.ticket_id")));
		projList.add(Projections.property("Ticket.employee"));
		projList.add(Projections.property("Ticket.ticket_type"));
		projList.add(Projections.property("Ticket.ticket_desc"));
		projList.add(Projections.property("Ticket.application"));
		projList.add(Projections.property("Ticket.priority"));
		projList.add(Projections.property("dev_comment.activity"));
		projList.add(Projections.property("dev_comment.status"));
		projList.add(Projections.property("Ticket.updated_on"));
		projList.add(Projections.property("dev_comment.comment_desc"));

		criteria.setProjection(projList);
		criteria.add(Restrictions.eq("dev_comment.status", "In Progress"));
		criteria.add(Restrictions.sqlRestriction("DATEDIFF(updated_on,start_date) >= 5"));

		List<Object[]> List = criteria.list();
		session.getTransaction().commit();	
		return List;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Object[]> getNotreportedList() {

		log.info("Entering getNotreportedList DAO");
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.getCurrentSession();
		session.beginTransaction();

		Date date = new Date();

		Criteria criteria = session.createCriteria(Ticket.class, "Ticket");
		criteria.setFetchMode("employee", FetchMode.JOIN);
		criteria.setFetchMode("application", FetchMode.JOIN);
		criteria.createAlias("employee", "employee");

		ProjectionList projList = Projections.projectionList();
		projList.add(Projections.groupProperty("Ticket.employee"));
		projList.add(Projections.property("employee.employee_id"));
		projList.add(Projections.property("employee.email"));
		projList.add(Projections.property("employee.designation"));
		criteria.setProjection(projList);
		criteria.add(Restrictions.ne("Ticket.updated_on", date));

		List<Object[]> List = criteria.list();
		session.getTransaction().commit();	
		return List;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Object[]> showclarify() {

		log.info("Entering showclarify DAO");
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.getCurrentSession();
		session.beginTransaction();

		// FIXME
		String hql ="select "
				+"this_.Ticket_ID, "
				+"this_.Ticket_type,"
		        +"employee3_.Employee_Name, "
		        +"this_.Ticket_Desc, "
		        +"app.Application_Name, "
		        +"dev_commen4_.Status, "
		        +"clarificat1_.Clarification_Desc, "
		        +"clarificat1_.Employee_Res "
		        +"from "
		        +"Ticket_Details this_ " 
		        +"inner join "
		        +"Employee_details employee3_ " 
		        +"on    this_.Employee_ID=employee3_.Employee_ID "
				+"inner join "
		        +"application app " 
		        +"on this_.Application_ID=app.Application_ID "
		        +"inner join "
		        +"clarification clarificat1_ " 
		        +"on this_.Ticket_ID=clarificat1_.Ticket_ID " 
		        +"left outer join "
		        +"( select "
		        +"a.ticket_id, "
                +"status, "
		        +"a.date "
		        +"from "
		        +"Dev_Comment a "    
		        +"inner join "
		        +"( "
		        +"select "
		        +"ticket_id, "
		        +"max(date) as date "       
		        +"from "
		        +"Dev_Comment "       
		        +"group by "
		        +"ticket_id "     
		        +" ) b "      
		        +"on a.ticket_id=b.ticket_id "      
		        +"and a.date = b.date "  
		        +")dev_commen4_  "
		        +"on this_.Ticket_ID=dev_commen4_.Ticket_ID ";

		Query query = session.createSQLQuery(hql);
		List<Object[]> result = query.list();
		session.getTransaction().commit();		
		return result;
	}

	@SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
	@Override
	public List<Object[]> toclarify(String ticketID) {

		log.info("Entering toclarify DAO");
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.getCurrentSession();
		session.beginTransaction();

		Criteria crit = session.createCriteria(Ticket.class, "Ticket");
		crit.setFetchMode("dev_comment", FetchMode.JOIN);
		crit.createAlias("dev_comment", "dev_comment", CriteriaSpecification.LEFT_JOIN);
		crit.createAlias("employee", "employee", CriteriaSpecification.LEFT_JOIN);
		crit.createAlias("application", "application", CriteriaSpecification.LEFT_JOIN);

		Criteria criteria = session.createCriteria(Dev_comment.class);
		criteria.createAlias("ticket", "ticket");
		ProjectionList proj = Projections.projectionList();
		proj.add(Projections.max("date"));
		criteria.setProjection(proj);
		criteria.add(Restrictions.eq("ticket.ticket_id", ticketID));
		List clarifyresult = criteria.list();

		Date date = (Date) clarifyresult.get(0);

		ProjectionList projList = Projections.projectionList();
		projList.add(Projections.property("Ticket.ticket_id"));
		projList.add(Projections.property("Ticket.ticket_type"));
		projList.add(Projections.property("employee.employee_name"));
		projList.add(Projections.property("Ticket.ticket_desc"));
		projList.add(Projections.property("application.application_name"));
		projList.add(Projections.max("dev_comment.date"));
		projList.add(Projections.property("dev_comment.status"));
		projList.add(Projections.groupProperty("Ticket.ticket_id"));
		crit.setProjection(projList);
		crit.add(Property.forName("dev_comment.date").eq(date));
		crit.add(Restrictions.eq("Ticket.ticket_id", ticketID));

		List<Object[]> result = crit.list();
		session.getTransaction().commit();		
		return result;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public int clarify(String ticketID, String supervisorcomment) {

		log.info("Entering clarify DAO");
		int status = 0;
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.getCurrentSession();
		session.beginTransaction();

		Date date = new Date();

		Criteria criteria = session.createCriteria(Clarification.class);
		criteria.createAlias("ticket", "ticket");
		criteria.add(Restrictions.eq("ticket.ticket_id", ticketID));
		List<Clarification> results = criteria.list();

		Criteria crite = session.createCriteria(Ticket.class);
		crite.add(Restrictions.eq("ticket_id", ticketID));
		List<Ticket> tick = crite.list();

		Clarification clarify = new Clarification();
		clarify.setClarification_desc(supervisorcomment);
		clarify.setDate(date);
		clarify.setTicket(tick.get(0));

		if (results.size() >= 0) {
			session.save(clarify);
			status = 1;
		} else {
			status = -1;
		}
		session.getTransaction().commit();	
		return status;
	}

	@SuppressWarnings({ "deprecation", "rawtypes" })
	@Override
	public int responseclarification(String ticketID, String employee_response, String supervisorComment) {

		log.info("Entering responseclarification DAO");
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.getCurrentSession();
		session.beginTransaction();

		Criteria criteria = session.createCriteria(Clarification.class);

		criteria.add(Restrictions.eq("ticket.ticket_id", ticketID));
		criteria.add(Restrictions.eq("clarification_desc", supervisorComment));
		criteria.add(Restrictions.eq("flag", 0));
		criteria.setProjection(Projections.property("clarification_id"));

		List clarifyresult = criteria.list();

		int id = (int) clarifyresult.get(0);
		int flag = 1;
		Clarification clarify = (Clarification) session.load(Clarification.class, id);
		clarify.setEmployee_res(employee_response);
		clarify.setFlag(flag);

		session.update(clarify);
		int status = 1;		
		session.getTransaction().commit();	
		return status;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Object[]> assignedClarification(String empID) {

		log.info("Entering assignedClarification DAO");
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.getCurrentSession();
		session.beginTransaction();

		// FIXME
		String hql = "select "
		        +"this_.Ticket_ID as y0_, "
		        +"this_.Ticket_type as y1_, "
		        +"this_.Ticket_Desc as y2_, "
		        +"dev_commen2_.Status as y3_, "
		        +"clarificat1_.Clarification_Desc as y4_ " 
		        +"from "
		        +"Ticket_Details this_ " 
		        +"inner join "
		        +"clarification clarificat1_ "
		        +"on this_.Ticket_ID=clarificat1_.Ticket_ID " 
                +"left outer join "
		        +"( "
		        +"select "
		        +"a.ticket_id, "
		        +"status, "
		        +"a.date "    
		        +"from "
		        +"Dev_Comment a "    
		        +"inner join "
				+"( "
		        +"select "
				+"ticket_id, "
		        +"max(date) as date "      
		        +"from "
		        +"Dev_Comment "       
		        +"group by "
		        +"Ticket_ID "     
		        +" ) b " 
		        +"on a.ticket_id=b.ticket_id "  
                +"and a.date =b.date "
		        +")dev_commen2_ "
                +"on this_.Ticket_ID=dev_commen2_.Ticket_ID "
                +"inner join "
		       	+"Employee_details employee3_ " 
		        +"on this_.Employee_ID=employee3_.Employee_ID " 
	            +"where "
		        +"employee3_.Employee_ID=? " 
		        +"and clarificat1_.Flag=0 ";

		Query query = session.createSQLQuery(hql);
		query.setParameter(0, empID);
		List<Object[]> result = query.list();
		session.getTransaction().commit();		
		return result;
	}

	@SuppressWarnings({ "deprecation", "rawtypes" })
	@Override
	public int deleteclarification(String ticketID, String supervisor_comment) {

		log.info("Entering deleteclarification DAO");
		int status = 0;
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.getCurrentSession();
		session.beginTransaction();

		Criteria criteria = session.createCriteria(Clarification.class);
		criteria.add(Restrictions.eq("ticket.ticket_id", ticketID));
		criteria.add(Restrictions.eq("clarification_desc", supervisor_comment));
		criteria.setProjection(Projections.property("clarification_id"));

		List clarifyresult = criteria.list();
		int id = (int) clarifyresult.get(0);

		Clarification clarify = new Clarification();
		clarify.setClarification_id(id);

		if (clarifyresult.size() > 0) {
			status = 1;
			session.delete(clarify);
		} else {
			status = -1;
		}
		session.getTransaction().commit();		
		return status;
	}

}
