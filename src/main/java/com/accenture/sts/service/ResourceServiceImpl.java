package com.accenture.sts.service;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.accenture.sts.controller.ResourceController;
import com.accenture.sts.dao.ResourceDAO;
import com.accenture.sts.entity.Employee;

public class ResourceServiceImpl implements ResourceService {
	private static Logger log = Logger.getLogger(ResourceController.class);
	@Autowired
	private ResourceDAO resourceDAO;

	@Override
	public int createResource(String empID, Employee employee) {
		
		log.info("Entering createResource service Implementation");
		int status = 0;
		try {
			status = resourceDAO.addResource(empID, employee);
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error("Exception e", exception);
		}
		return status;
	}

	@Override
	public List<Object[]> resname() {
		
		log.info("Entering resname service Implementation");
		List<Object[]> NameList = new ArrayList<Object[]>();
		try {
			NameList = resourceDAO.resname();
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error("Exception e", exception);
		}
		return NameList;
	}

	@Override
	public int modifyResource(Employee employee) {

		log.info("Entering modifyResource service Implementation");
		int status = 0;
		try {
			status = resourceDAO.modifyResource(employee);
		} catch (Exception exception) {
			exception.printStackTrace();
			log.error("Exception e", exception);
		}
		return status;
	}
}
