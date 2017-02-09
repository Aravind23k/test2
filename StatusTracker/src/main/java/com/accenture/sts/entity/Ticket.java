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
@Table(name="Ticket_Details")
public class Ticket 
{
  @Id
  @Column(name="Ticket_ID")
  private String ticket_id;
   
  @Column(name="Ticket_Desc")
  private String ticket_desc;
  
  @ManyToOne
  @JoinColumn(name = "Employee_ID")
  private String employee_id;
  
  @ManyToOne
  @JoinColumn(name = "Application_ID")
  private String application_id;
  
  @Column(name="Ticket_type")
  private String ticket_type;
  
  @Column(name="Priority")
  private int priority;
  
  @Column(name="Worked_on_today")
  private String worked_on_today;
  
  @Column(name="Created_by")
  private String created_by;
  
  @Temporal(TemporalType.DATE)
  @Column(name="Created_On")  
  private String created_on;
  
  @Temporal(TemporalType.DATE)
  @Column(name="Updated_On") 
  private String updated_on;
  
  @Temporal(TemporalType.DATE)
  @Column(name="Start_date") 
  private String start_date;
  
  @Temporal(TemporalType.DATE)
  @Column(name="End_date") 
  private String end_date;
  
  @Column(name="Release_ticket")
  private String release_ticket;

public String getTicket_id()
{
	return ticket_id;
}

public void setTicket_id(String ticket_id) 
{
	this.ticket_id = ticket_id;
}

public String getTicket_desc() 
{
	return ticket_desc;
}

public void setTicket_desc(String ticket_desc) 
{
	this.ticket_desc = ticket_desc;
}

public String getEmployee_id() 
{
	return employee_id;
}

public void setEmployee_id(String employee_id) 
{
	this.employee_id = employee_id;
}

public String getApplication_id() 
{
	return application_id;
}

public void setApplication_id(String application_id)
{
	this.application_id = application_id;
}

public String getTicket_type() 
{
	return ticket_type;
}

public void setTicket_type(String ticket_type) 
{
	this.ticket_type = ticket_type;
}

public int getPriority() 
{
	return priority;
}

public void setPriority(int priority) 
{
	this.priority = priority;
}

public String getWorked_on_today()
{
	return worked_on_today;
}

public void setWorked_on_today(String worked_on_today)
{
	this.worked_on_today = worked_on_today;
}

public String getCreated_by() 
{
	return created_by;
}

public void setCreated_by(String created_by)
{
	this.created_by = created_by;
}

public String getCreated_on()
{
	return created_on;
}

public void setCreated_on(String created_on) 
{
	this.created_on = created_on;
}

public String getUpdated_on() 
{
	return updated_on;
}

public void setUpdated_on(String updated_on)
{
	this.updated_on = updated_on;
}

public String getStart_date()
{
	return start_date;
}

public void setStart_date(String start_date)
{
	this.start_date = start_date;
}

public String getEnd_date() 
{
	return end_date;
}

public void setEnd_date(String end_date) 
{
	this.end_date = end_date;
}

public String getRelease_ticket()
{
	return release_ticket;
}

public void setRelease_ticket(String release_ticket) 
{
	this.release_ticket = release_ticket;
}
  
  
}
