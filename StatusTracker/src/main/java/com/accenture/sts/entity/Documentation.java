package com.accenture.sts.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="documentation")
public class Documentation 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Documentation_ID")
	private String documentation_id;
	
	@OneToOne
	@JoinColumn(name="Ticket_ID")
	private String ticket_id;
	
	@Column(name="Doc_Comment")
	private String doc_comment;
	
	@Column(name="Remedy")
	private String remedy;
	
	@Column(name="Document_Desc")
	private String document_desc;
	
	public String getDocumentation_id() 
	{
		return documentation_id;
	}
	public void setDocumentation_id(String documentation_id) {
		this.documentation_id = documentation_id;
	}
	public String getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(String ticket_id) {
		this.ticket_id = ticket_id;
	}
	public String getDoc_comment() {
		return doc_comment;
	}
	public void setDoc_comment(String doc_comment) {
		this.doc_comment = doc_comment;
	}
	public String getRemedy() {
		return remedy;
	}
	public void setRemedy(String remedy) {
		this.remedy = remedy;
	}
	public String getDocument_desc() {
		return document_desc;
	}
	public void setDocument_desc(String document_desc) {
		this.document_desc = document_desc;
	}

}
