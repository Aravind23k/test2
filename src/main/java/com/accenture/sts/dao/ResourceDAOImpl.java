package com.accenture.sts.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.accenture.sts.controller.ResourceController;
import com.accenture.sts.entity.Employee;


public class ResourceDAOImpl implements ResourceDAO {
	@Autowired
	private SessionFactory sessionFactory;
	private static Logger log = Logger.getLogger(ResourceController.class);
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public int addResource(String empID, Employee employee) {

		log.info("Entering AddResource DAO");
		sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Employee emp = new Employee();
		emp.setEmployee_name(employee.getEmployee_name());
		emp.setEmployee_id(employee.getEmployee_id());
		emp.setIs_admin(employee.getIs_admin());
		emp.setRole(employee.getRole());
		emp.setEmail(employee.getEmail());
		emp.setPassword("pass");
		emp.setIs_active("Yes");
		emp.setIs_include("Yes");
		int status = -1;
		try {
			Criteria cr = session.createCriteria(Employee.class);
			cr.add(Restrictions.eq("employee_id", employee.getEmployee_id()));
			List<Employee> results = cr.list();

			if (results.size() == 0) {
				session.save(emp);
				status = 1;
			} else {
				status = -1;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		session.getTransaction().commit();
		return status;
	}

	@SuppressWarnings({ "deprecation", "rawtypes" })
	public int modifyResource(Employee employee) {
		
		log.info("Entering modifyResource DAO");
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.getCurrentSession();
		session.beginTransaction();
		int status = 0;
		try {
			Criteria criteria = session.createCriteria(Employee.class);
			criteria.add(Restrictions.eq("employee_name", employee.getEmployee_name()));
			criteria.setProjection(Projections.property("employee_id"));
			List emplist = criteria.list();

			String empid = (String) emplist.get(0);

			Employee emp = (Employee) session.load(Employee.class, empid);
			emp.setIs_active(employee.getIs_active());
			emp.setIs_include(employee.getIs_include());
			emp.setIs_admin(employee.getIs_admin());
			emp.setReport(employee.isReport());
			emp.setRole(employee.getRole());
			
			session.update(emp);
			status = 1;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		session.getTransaction().commit();
		return status;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Object[]> resname() {
		
		log.info("Entering resname DAO");
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionfactory.getCurrentSession();
		session.beginTransaction();
		List<Object[]> result = null;
		try {
			Criteria cr = session.createCriteria(Employee.class);
			cr.setProjection(Projections.property("employee_name"));
			cr.setProjection((Projections.groupProperty("employee_name")));
			result = cr.list();
			
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		session.getTransaction().commit();		
		return result;

	}
}
