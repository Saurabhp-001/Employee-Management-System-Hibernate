package com.qsp.ems.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.qsp.ems.model.Department;
import com.qsp.ems.model.Employee;
import com.qsp.ems.model.Project;

public class Controller {

	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pgadmin");
	static EntityManager entityManager = entityManagerFactory.createEntityManager();
	static EntityTransaction entityTransaction = entityManager.getTransaction();

//	1.Add Data
//	1.1.Add Employee
	public boolean addEmployee(Employee employeeToAdd, Department departmentToUpdate) {

		if (employeeToAdd != null) {

			if (departmentToUpdate != null) {
				
				entityTransaction.begin();
				entityManager.persist(employeeToAdd);
				entityManager.merge(departmentToUpdate);
				entityTransaction.commit();
				return true;
			}
//			Insert Only Employee
			entityTransaction.begin();
			entityManager.persist(employeeToAdd);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

//	1.2.Add Department
	public boolean addDepartment(Department departmentToAdd) {

		if (departmentToAdd != null) {

			entityTransaction.begin();
			entityManager.persist(departmentToAdd);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

//	1.3.Add Project
	public boolean addProject(Project projectToAdd) {

		if (projectToAdd != null) {

			entityTransaction.begin();
			entityManager.persist(projectToAdd);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

//	2.Find Data
//	2.1.Find Employee
	public Employee findEmployee(int employeeId) {

		return entityManager.find(Employee.class, employeeId);
	}

//	2.1.1.Find All Employees
	public List<Employee> findAllEmployees() {

		String jpql = "SELECT e FROM Employee e";
		TypedQuery<Employee> typedQuery = entityManager.createQuery(jpql, Employee.class);
		List<Employee> employees = typedQuery.getResultList();
		return employees;
	}

//	2.2.Find Department
	public Department findDepartment(int departmentId) {

		return entityManager.find(Department.class, departmentId);
	}

//	2.2.1.Find All Departments
	public List<Department> findAllDepartments() {

		String jpql = "SELECT d FROM Department d";
		TypedQuery<Department> typedQuery = entityManager.createQuery(jpql, Department.class);
		List<Department> departments = typedQuery.getResultList();
		return departments;
	}

//	2.3.Find Project
	public Project findProject(int projectId) {

		return entityManager.find(Project.class, projectId);
	}

//	2.3.1.Find All Projects
	public List<Project> findAllProjects() {

		String jpql = "SELECT p FROM Project p";
		TypedQuery<Project> typedQuery = entityManager.createQuery(jpql, Project.class);
		List<Project> projects = typedQuery.getResultList();
		return projects;
	}

//	3.Update Data
//	3.1.Update Employee
	public boolean updateEmployee(Employee employeeToUpdate) {
		
		entityTransaction.begin();
		Employee updatedEmployee = entityManager.merge(employeeToUpdate);
		entityTransaction.commit();
		
		if (updatedEmployee != null) {
			return true;
		}
		return false;
	}
//	3.1.2.Update Employee Department
	public boolean updateEmployeeDepartment(Employee employeeToUpdate, Department departmentToUpdate) {
		
		if (employeeToUpdate != null && departmentToUpdate != null) {
			
			entityTransaction.begin();
			entityManager.merge(employeeToUpdate);
			entityManager.merge(departmentToUpdate);
			entityTransaction.commit();
			return true;
		}
		return false;
	}
	
//	3.2.Update Department
	public boolean updateDepartment(Department departmentToUpdate) {
		
		entityTransaction.begin();
		Department updatedDepartment = entityManager.merge(departmentToUpdate);
		entityTransaction.commit();
		
		if (updatedDepartment != null) {
			return true;
		}
		return false;
	}

//	3.3.Update Project
	public boolean updateProject(Project projectToUpdate) {
		
		entityTransaction.begin();
		Project updatedProject = entityManager.merge(projectToUpdate);
		entityTransaction.commit();
		
		if (updatedProject != null) {
			return true;
		}
		return false;
	}

//	4.Delete Data
//	4.1.Delete Employee
	public boolean removeEmployee(int employeeIdToRemove) {

		Employee employeeToRemove = findEmployee(employeeIdToRemove);
		if (employeeToRemove != null) {

			entityTransaction.begin();
			entityManager.remove(employeeToRemove);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

//	4.2.Delete Department
	public boolean removeDepartment(int departmentIdToRemove) {

		Department departmentToRemove = findDepartment(departmentIdToRemove);
		if (departmentToRemove != null) {

			entityTransaction.begin();
			entityManager.remove(departmentToRemove);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

//	4.3.Delete Project
	public boolean removeProject(int projectIdToRemove) {

		Project projectToRemove = findProject(projectIdToRemove);
		if (projectToRemove != null) {

			entityTransaction.begin();
			entityManager.remove(projectToRemove);
			entityTransaction.commit();
			return true;
		}
		return false;
	}
}
