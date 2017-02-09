package com.accenture.sts.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Application")
public class Application 
{   
	@Id
	@Column(name="Application_ID")
	private String application_id;
	
	@Column(name="Application_Name")
	private String application_name;
	
	@Column(name="Application_Shortname")
	private String application_shortname;
	
	public String getApplication_id() {
		return application_id;
	}
	public void setApplication_id(String application_id) {
		this.application_id = application_id;
	}
	public String getApplivation_name() {
		return application_name;
	}
	public void setApplivation_name(String applivation_name) {
		this.application_name = applivation_name;
	}
	public String getAplication_shortname() {
		return application_shortname;
	}
	public void setAplication_shortname(String aplication_shortname) {
		this.application_shortname = aplication_shortname;
	}
	
}
