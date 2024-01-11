package com.qsp.ems.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "employee")
public class Employee {

//	---Base Attributes---

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "e_id")
	private int employeeId;

	@Column(name = "e_name")
	private String employeeName;

	@Column(name = "e_position")
	private String positionName;

	@Column(name = "e_salary")
	private double salary;

	@CreationTimestamp
	@Column(name = "e_doj")
	private LocalDateTime dOJ;

	@Column(name = "e_working_status")
	private boolean workingStatus;

//	---Mapping Attributes---

	@ManyToOne
	private Department department;
	
	@ManyToMany
	private List<Project> projects;

//	---Getters Setters---
	
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDateTime getdOJ() {
		return dOJ;
	}

	public void setdOJ(LocalDateTime dOJ) {
		this.dOJ = dOJ;
	}

	public boolean isWorkingStatus() {
		return workingStatus;
	}

	public void setWorkingStatus(boolean workingStatus) {
		this.workingStatus = workingStatus;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

//	---No Arguement Constructor---
	
	public Employee() {

	}

}
