package com.qsp.ems.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Project {

//	---Base Attributes---

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int projectId;
	
	@Column(name = "name")
	private String projectName;
	
	@Column(name = "description")
	private String projectDescriptoin;

//	---Mapping Attribute---

	@ManyToMany
	private List<Employee> employees;

//	---Getters Setters---
	
	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDescriptoin() {
		return projectDescriptoin;
	}

	public void setProjectDescriptoin(String projectDescriptoin) {
		this.projectDescriptoin = projectDescriptoin;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

//	---No Arguement Constructor---
	
	public Project() {

	}

}
