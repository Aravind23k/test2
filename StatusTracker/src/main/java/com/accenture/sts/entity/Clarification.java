package com.accenture.sts.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="clarification")
public class Clarification 
{
	@Id
	@Column(name="Clarification_ID")
	private String clarification_id;
	
	@ManyToOne
	@JoinColumn(name="Ticket_ID")
	private String ticket_id;
	
	@Column(name="Clarification_Desc")
	private String clarification_desc;
	
	@Column(name="Employee_Res")
	private String employee_res;
	
	@Column(name="Flag")
	private int flag;
	
	@Temporal(TemporalType.DATE)
	@Column(name="Date") 
	private String date;

	
	public String getClarification_id() {
		return clarification_id;
	}

	public void setClarification_id(String clarification_id) {
		this.clarification_id = clarification_id;
	}

	public String getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(String ticket_id) {
		this.ticket_id = ticket_id;
	}

	public String getClarification_desc() {
		return clarification_desc;
	}

	public void setClarification_desc(String clarification_desc) {
		this.clarification_desc = clarification_desc;
	}

	public String getEmployee_res() {
		return employee_res;
	}

	public void setEmployee_res(String employee_res) {
		this.employee_res = employee_res;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
