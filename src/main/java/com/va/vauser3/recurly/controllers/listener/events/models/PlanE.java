package com.va.vauser3.recurly.controllers.listener.events.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "plan")
public class PlanE {
	
	@XmlElement(name = "plan_code")
	private String planCode;
	
	@XmlElement(name = "name")
	private String name;	

	@XmlElement(name = "version")
	private Integer version;
	

	public String getPlanCode() {
		return planCode;
	}

	public String getName() {
		return name;
	}
	
	public Integer getVersion() {
		return version;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("PlanE{");
		sb.append("planCode='").append(this.getPlanCode()).append('\'');
		sb.append(", name='").append(this.getName()).append('\'');
		sb.append(", version='").append(this.getVersion()).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
