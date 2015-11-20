package com.j3source.recurly.events.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "plan")
public class PlanE {
	
	@XmlElement(name = "plan_code")
	private String planCode;
	
	@XmlElement(name = "name")
	private String name;

	public String getPlanCode() {
		return planCode;
	}

	public String getName() {
		return name;
	}
}
