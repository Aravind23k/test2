package com.accenture.sts.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="Tester_Comment")
public class Tester_comment 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Comment_ID")
	private String comment_id;
	
	@ManyToOne
	@JoinColumn(name="Ticket_ID")
	private String ticket_id;
	
	@Column(name="Comment_Desc")
	private String comment_desc;
	
	@Column(name="Status")
	private String status;
	
	@Column(name="Activity")
	private String activity;

	@Temporal(TemporalType.DATE)
	@Column(name="Date")
	private String date;
	

	public String getComment_id() {
		return comment_id;
	}

	public void setComment_id(String comment_id) {
		this.comment_id = comment_id;
	}

	public String getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(String ticket_id) {
		this.ticket_id = ticket_id;
	}

	public String getComment_desc() {
		return comment_desc;
	}

	public void setComment_desc(String comment_desc) {
		this.comment_desc = comment_desc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
