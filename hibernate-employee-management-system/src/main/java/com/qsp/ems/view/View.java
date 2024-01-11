package com.qsp.ems.view;

import java.util.List;
import java.util.Scanner;

import com.qsp.ems.controller.Controller;
import com.qsp.ems.model.Department;
import com.qsp.ems.model.Employee;
import com.qsp.ems.model.Project;

public class View {

	static Scanner sc = new Scanner(System.in);
	static Controller controller = new Controller();

	public static void main(String[] args) {

		do {

			System.out.println("\n--- EMPLOYEE MANAGEMENT SYSTEM ---");
			System.out.println("\n-----------------");
			System.out.println("| 1.Insert Data |");
			System.out.println("| 2.Find Data   |");
			System.out.println("| 3.Update Data |");
			System.out.println("| 4.Delete Data |");
			System.out.println("| 0.Exit        |");
			System.out.println("-----------------");

//			User Input For Switch
			System.out.print("Enter Number To Select : ");
			int userChoice = sc.nextInt();
			sc.nextLine();

//			Switch Case For Menu Driven Loop
			switch (userChoice) {

//-----------------------------------------------------------------

//		1.Insert Data
			case 1:

				System.out.println("\n-------------------------------");
				System.out.println("|         INSERT DATA         |");
				System.out.println("-------------------------------");
				System.out.println("| 1.Insert Employee Details   |");
				System.out.println("| 2.Insert Dapartment Details |");
				System.out.println("| 3.Insert Project Details    |");
				System.out.println("-------------------------------");

//				User Input For Insert Data
				System.out.print("Enter Number To Select : ");
				int insertChoice = sc.nextInt();
				sc.nextLine();

//			Insert Data Sub Switch
				switch (insertChoice) {

//			1.1.Insert Employee
				case 1:

					System.out.println("\n--- INSERT EMPLOYEE DETAILS ---");

					Employee employeeToAdd = new Employee();
					System.out.print("\nEnter Employee Name : ");
					employeeToAdd.setEmployeeName(sc.nextLine());
					System.out.print("Enter Employee Position : ");
					employeeToAdd.setPositionName(sc.nextLine());
					System.out.print("Enter Employee Salary : ");
					employeeToAdd.setSalary(sc.nextDouble());
					sc.nextLine();
					
//					Work Status
					System.out.println("---------------------");
					System.out.println("Is " + employeeToAdd.getEmployeeName() + " Working On Any Project ?");
					System.out.println("1.Yes \n2.No");
					System.out.println("---------------------");
					System.out.print("Enter Number To Select : ");
					int workStatusChoice = sc.nextInt();
					sc.nextLine();
					boolean workStatus = true;
					if (workStatusChoice == 2) {
						workStatus = false;
					}
					employeeToAdd.setWorkingStatus(workStatus);

//					Assign Department To Employee
					System.out.println("\n-------------------------------");
					System.out.println("1.Assign Department To Employee \n2.Not Now (You Can Update Employee Department Later)");
					System.out.println("-------------------------------");
					System.out.println("Enter Number To Select : ");
					int assignDepartmentToEmployee = sc.nextInt();
					sc.nextLine();
					
//					1.Assign Department To Employee
					Department assignDepartment = null;
					if (assignDepartmentToEmployee == 1) {
						
						System.out.println("--- ASSIGN DEPARTMENT TO EMPLOYEE ---");
						System.out.println();
//						Function To Assign Department
						assignDepartment = assignDepartment(employeeToAdd);
//						Set Department To Employee
						employeeToAdd.setDepartment(assignDepartment);
//						Add Employee To Department
						assignDepartment.getEmployees().add(employeeToAdd);

					} 
					
//					2.Don't Assign Department
					else {
						System.err.println("\n< No Department Assign To Employee >");
						System.err.println("You Can Assign Department In 'Update Data' Option");
					}
					
//					Call addEmployee Function With Employee And Updated Department
					if (controller.addEmployee(employeeToAdd, assignDepartment)) {
						System.out.println("\n< Employee Data Inserted >");
					} else {
						System.err.println("\n< Employee Data Inserted >");
					}

					break;

//			1.2.Insert Department
				case 2:

					System.out.println("\n--- INSERT DEPARTMENT DETAILS ---");

					Department departmentToAdd = new Department();
					System.out.print("\nEnter Department Name : ");
					departmentToAdd.setDepartmentName(sc.nextLine());

					if (controller.addDepartment(departmentToAdd)) {
						System.out.println("\n< Department Data Inserted >");
					} else {
						System.err.println("\n< Department Data Not Inserted >");
					}

					break;

//			1.3.Insert Project
				case 3:

					System.out.println("\n--- INSERT PROJECT DETAILS ---");

					Project projectToAdd = new Project();
					System.out.print("\nEnter Project Name : ");
					projectToAdd.setProjectName(sc.nextLine());
					System.out.print("Enter Project Description : ");
					projectToAdd.setProjectDescriptoin(sc.nextLine());

					if (controller.addProject(projectToAdd)) {
						System.out.println("\n< Project Data Inserted >");
					} else {
						System.err.println("\n< Project Data Not Inserted >");
					}

					break;

				default:
					System.err.println("\n< Invalid Choice >");
					break;
				}
//			Sub Switch End

				break;

//-----------------------------------------------------------------

//		2.Find Data
			case 2:

				System.out.println("\n-----------------------------");
				System.out.println("|         FIND DATA         |");
				System.out.println("-----------------------------");
				System.out.println("| 1.Find Employee Details   |");
				System.out.println("| 2.Find Dapartment Details |");
				System.out.println("| 3.Find Project Details    |");
				System.out.println("-----------------------------");

//				User Input For Find Data
				System.out.print("Enter Number To Select : ");
				int findChoice = sc.nextInt();
				sc.nextLine();

//			Find Data Sub Switch
				switch (findChoice) {

//			2.1.Find Employee
				case 1:

					System.out.println("\n----------------------------");
					System.out.println("|   FIND EMPLOYEE DETAILS  |");
					System.out.println("----------------------------");
					System.out.println("| 1.Find Specific Employee |");
					System.out.println("| 2.Get All Employees 	   |");
					System.out.println("----------------------------");
					System.out.print("Enter Nnubmer To Select : ");
					int findEmployeeChoice = sc.nextInt();
					sc.nextLine();

//					1.Find Specific Employee
					if (findEmployeeChoice == 1) {

						System.out.println("\n--- FIND EMPLOYEE DETAILS ---");
						System.out.print("\nEnter Employee Id To Find : ");
						int employeeIdToFind = sc.nextInt();
						sc.nextLine();

						Employee foundEmployee = controller.findEmployee(employeeIdToFind);

						if (foundEmployee != null) {

							System.out.println("\n--- EMPLOYEE DETAILS ---");
							System.out.println("\nEmployee Id --------------> " + foundEmployee.getEmployeeId());
							System.out.println("Employee Name ------------> " + foundEmployee.getEmployeeName());
							System.out.println("Employee Position --------> " + foundEmployee.getPositionName());
							System.out.println("Employee Salary ----------> " + foundEmployee.getSalary());
							System.out.println("Employee Joining Data ----> " + foundEmployee.getdOJ());
							System.out.println("Employee Working Status --> " + foundEmployee.isWorkingStatus());
							System.out.println("--------------------------");
							int departmentId = 00;
							String departmentName = "Not Assigned";
							if (foundEmployee.getDepartment() != null) {
								departmentId = foundEmployee.getDepartment().getDepartmentId();
								departmentName = foundEmployee.getDepartment().getDepartmentName();
							}
							System.out.println("Employee Department Id ---> " + departmentId);
							System.out.println("Employee Department Name -> " + departmentName);
							System.out.println("---------------------------");

						} else {
							System.err.println("\n< Employee Id - " + employeeIdToFind + " Not Found >");
						}

					}
//					2.Find All Employees
					else if (findEmployeeChoice == 2) {

						List<Employee> allEmployees = controller.findAllEmployees();
						if (!allEmployees.isEmpty()) {

							System.out.println("\n--- EMPLOYEE DETAILS ---");
							System.out.println();
//							Print All Employee Details
							System.out.println("===============================");
							for (Employee employee : allEmployees) {

								System.out.println("Employee Id --------------> " + employee.getEmployeeId());
								System.out.println("Employee Name ------------> " + employee.getEmployeeName());
								System.out.println("Employee Position --------> " + employee.getPositionName());
								System.out.println("Employee Salary ----------> " + employee.getSalary());
								System.out.println("Employee Joining Data ----> " + employee.getdOJ());
								System.out.println("Employee Working Status --> " + employee.isWorkingStatus());
								System.out.println("--------------------------");
								int departmentId = 00;
								String departmentName = "Not Assigned";
								if (employee.getDepartment() != null) {
									departmentId = employee.getDepartment().getDepartmentId();
									departmentName = employee.getDepartment().getDepartmentName();
								}
								System.out.println("Employee Department Id ---> " + departmentId);
								System.out.println("Employee Department Name -> " + departmentName);
								System.out.println("\n===============================");
							}

						} else {
							System.err.println("\n< No Employees Found, Please Add Employee >");
						}

					}

					break;

//			2.2.Find Department
				case 2:

					System.out.println("------------------------------");
					System.out.println("|   FIND DEPARTMENT DETAILS  |");
					System.out.println("------------------------------");
					System.out.println("| 1.Find Specific Department |");
					System.out.println("| 2.Get All Departments	     |");
					System.out.println("------------------------------");
					System.out.print("Enter Nubmer To Select : ");
					int findDepartmentChoice = sc.nextInt();
					sc.nextLine();

//					1.Find Specific Department
					if (findDepartmentChoice == 1) {

						System.out.println("\n--- FIND DEPARTMENT DETAILS ---");
						System.out.print("\nEnter Department Id : ");
						int departmentIdToFind = sc.nextInt();
						sc.nextLine();

						Department foundDepartment = controller.findDepartment(departmentIdToFind);

						if (foundDepartment != null) {

							System.out.println("\n--- DEPARTMENT DETAILS ---");
							System.out.println("\nDepartment Id -----> " + foundDepartment.getDepartmentId());
							System.out.println("Department Name ---> " + foundDepartment.getDepartmentName());
							System.out.println("--------------------");

						} else {
							System.err.println("\n< Department Id - " + departmentIdToFind + " Not Found >");
						}

					}
//					2.Find All Departments
					else if (findDepartmentChoice == 2) {

						List<Department> allDepartments = controller.findAllDepartments();
						if (!allDepartments.isEmpty()) {

							System.out.println("\n--- DEPARTMENT DETAILS ---");
							System.out.println();
//							Print All Department Details
							for (Department department : allDepartments) {

								System.out.println("Department Id -----> " + department.getDepartmentId());
								System.out.println("Department Name ---> " + department.getDepartmentName());
								System.out.println("--------------------");
							}

						} else {
							System.err.println("\n< No Department Found, Please Add Department >");
						}

					}

					break;

//			2.3.Find Project
				case 3:

					System.out.println("\n---------------------------");
					System.out.println("|   FIND PROJECT DETAILS  |");
					System.out.println("---------------------------");
					System.out.println("| 1.Find Specific Project |");
					System.out.println("| 2.Get All Project 	  |");
					System.out.println("---------------------------");
					System.out.print("Enter Number To Select : ");
					int findProjectChoice = sc.nextInt();
					sc.nextLine();

//					1.Find Specific Project
					if (findProjectChoice == 1) {

						System.out.println("\n--- FIND PROJECT DETAILS ---");
						System.out.print("\nEnter Project Id : ");
						int projectIdToFind = sc.nextInt();
						sc.nextLine();

						Project foundProject = controller.findProject(projectIdToFind);

						if (foundProject != null) {

							System.out.println("\n--- PROJECT DETAILS ---");
							System.out.println("\nProject Id ---------------> " + foundProject.getProjectId());
							System.out.println("Project Name -------------> " + foundProject.getProjectName());
							System.out.println("Department Description ---> " + foundProject.getProjectDescriptoin());
							System.out.println("---------------------------");

						} else {
							System.err.println("\n< Project Id - " + projectIdToFind + " Not Found >");
						}

					}
//					2.Find All Departments
					else if (findProjectChoice == 2) {

						List<Project> allProjects = controller.findAllProjects();
						if (!allProjects.isEmpty()) {

							System.out.println("\n--- PROJECT DETAILS ---");
							System.out.println();
//							Print All Project Details
							for (Project project : allProjects) {

								System.out.println("Project Id ---------------> " + project.getProjectId());
								System.out.println("Project Name -------------> " + project.getProjectName());
								System.out.println("Department Description ---> " + project.getProjectDescriptoin());
								System.out.println("---------------------------");
							}

						} else {
							System.err.println("\n< No Project Found, Please Add Project >");
						}

					}

					break;

				default:
					System.err.println("\n< Invalid Choice >");
					break;
				}
//			Sub Switch End

				break;

//-----------------------------------------------------------------

//		3.Update Data
			case 3:

				System.out.println("\n-------------------------------");
				System.out.println("|         UPDATE DATA         |");
				System.out.println("-------------------------------");
				System.out.println("| 1.Update Employee Details   |");
				System.out.println("| 2.Update Dapartment Details |");
				System.out.println("| 3.Update Project Details    |");
				System.out.println("-------------------------------");

//				User Input For Update Data
				System.out.print("Enter Number To Select : ");
				int updateChoice = sc.nextInt();
				sc.nextLine();

//			Update Data Sub Switch
				switch (updateChoice) {

//			3.1.Update Employee
				case 1:

					System.out.println("\n------------------------------------");
					System.out.println("|      UPDATE EMPLOYEE DETAILS     |");
					System.out.println("------------------------------------");
					System.out.println("| 1.Update Employee Name   	  	   |");
					System.out.println("| 2.Update Employee Position       |");
					System.out.println("| 3.Update Employee Salary     	   |");
					System.out.println("| 4.Update Employee Working Status |");
					System.out.println("| 5.Update Employee Department	   |");
					System.out.println("| 6.Update Employee Projects	   |");
					System.out.println("------------------------------------");
					System.out.print("Enter Number To Select : ");
					int updateEmployeeChoice = sc.nextInt();
					sc.nextLine();

//					Sub Switch For Update Employee
					switch (updateEmployeeChoice) {

//					3.1.1.Update Name
					case 1:

						System.out.println("\n--- UPDATE EMPLOYEE NAME ---");
						System.out.print("\nEnter Employee Id To Update Name : ");
						int employeeIdToUpdateName = sc.nextInt();
						sc.nextLine();
						Employee employeeTOUpdateName = controller.findEmployee(employeeIdToUpdateName);
						if (employeeTOUpdateName != null) {

							System.out.print(
									"\nChange Employee Name - '" + employeeTOUpdateName.getEmployeeName() + "' To : ");
							employeeTOUpdateName.setEmployeeName(sc.nextLine());

							if (controller.updateEmployee(employeeTOUpdateName)) {
								System.out.println("\n< Employee Name Updated >");
							} else {
								System.err.println("\n< Employee Name Not Updated >");
							}

						} else {
							System.err.println("\n< Employee Id - " + employeeIdToUpdateName + " Not Found >");
						}

						break;

//					3.1.2.Update Position
					case 2:

						System.out.println("\n--- UPDATE EMPLOYEE POSITION ---");
						System.out.print("\nEnter Employee Id To Update Position : ");
						int employeeIdToUpdatePosition = sc.nextInt();
						sc.nextLine();
						Employee employeeToUpdatePosition = controller.findEmployee(employeeIdToUpdatePosition);
						if (employeeToUpdatePosition != null) {

							System.out.print("\nChange Employee Position - '"
									+ employeeToUpdatePosition.getPositionName() + "' To : ");
							employeeToUpdatePosition.setPositionName(sc.nextLine());

							if (controller.updateEmployee(employeeToUpdatePosition)) {
								System.out.println("\n< Employee Position Updated >");
							} else {
								System.err.println("\n< Employee Position Not Updated >");
							}

						} else {
							System.err.println("\n< Employee Id - " + employeeIdToUpdatePosition + " Not Found >");
						}

						break;

//					3.1.3.Update Salary
					case 3:

						System.out.println("\n--- UPDATE EMPLOYEE SALARY ---");
						System.out.print("\nEnter Employee Id To Update Salary : ");
						int employeeIdToUpdateSalary = sc.nextInt();
						sc.nextLine();
						Employee employeeToUpdateSalary = controller.findEmployee(employeeIdToUpdateSalary);
						if (employeeToUpdateSalary != null) {

							System.out.print(
									"Change Employee Salary - '" + employeeToUpdateSalary.getSalary() + "' To : ");
							employeeToUpdateSalary.setSalary(sc.nextDouble());
							sc.nextLine();

							if (controller.updateEmployee(employeeToUpdateSalary)) {
								System.out.println("\n< Employee Salary Updated >");
							} else {
								System.err.println("\n< Employee Salary Not Updated >");
							}

						} else {
							System.err.println("\n< Employee Id - " + employeeIdToUpdateSalary + " Not Found >");
						}

						break;

//					3.1.4.Update Work Status
					case 4:

						System.out.println("\n--- UPDATE EMPLOYEE WORK STATUS ---");
						System.out.print("\nEnter Employee Id To Update Work Status : ");
						int employeeIdToUpdateWorkStatus = sc.nextInt();
						sc.nextLine();
						Employee employeeToUpdateWorkStatus = controller.findEmployee(employeeIdToUpdateWorkStatus);
						if (employeeToUpdateWorkStatus != null) {

//							Work Status
							System.out.println("---------------------");
							System.out.println(
									"Is " + employeeToUpdateWorkStatus.getEmployeeName() + " Working On Any Project ?");
							System.out.println("1.Yes \n2.No");
							System.out.println("---------------------");
							System.out.print("Enter Number To Select : ");
							int workStatusChoice = sc.nextInt();
							sc.nextLine();
							boolean workStatus = true;
							if (workStatusChoice == 2) {
								workStatus = false;
							}
							employeeToUpdateWorkStatus.setWorkingStatus(workStatus);

							if (controller.updateEmployee(employeeToUpdateWorkStatus)) {
								System.out.println("\n< Employee Work Status Updated >");
							} else {
								System.err.println("\n< Employee Work Status Not Updated >");
							}

						} else {
							System.err.println("\n< Employee Id - " + employeeIdToUpdateWorkStatus + " Not Found >");
						}

						break;

//					3.1.5.Update Employee Department
					case 5:

						System.out.println("\n--- UPDATE EMPLOYEE DEPARTMENT ---");
						System.out.print("\nEnter Employee Id To Update : ");
						int employeeIdToUpdateDepartment = sc.nextInt();
						sc.nextLine();
						Employee employeeToUpdateDepartment = controller.findEmployee(employeeIdToUpdateDepartment);

						if (employeeToUpdateDepartment != null) {

							Department employeeDepartment = employeeToUpdateDepartment.getDepartment();
							if (employeeDepartment != null) {
								
								System.out.println("\nDepartment Deatils Of Employee - " + employeeIdToUpdateDepartment + " :");
								System.out.println("--------------------------------------");
								System.out.println("Department Id : " + employeeDepartment.getDepartmentId());
								System.out.println("Department Name : " + employeeDepartment.getDepartmentName());
								System.out.println("--------------------------------------");
								
								System.out.println("\nWant To Change Department For " + employeeToUpdateDepartment.getEmployeeName());
								System.out.println("1.Yes \n2.No");
								System.out.println("------------------------------------------");
								System.out.println("Enter Number To Select : ");
								int changeDepartmentChoice = sc.nextInt();
								sc.nextLine();
								
								if (changeDepartmentChoice == 1) {
									
//									Function To Assign Department
									Department departmentToAssign = assignDepartment(employeeToUpdateDepartment);
//									Remove Employee From Previous Department
									employeeDepartment.getEmployees().remove(employeeToUpdateDepartment);
//									Assign Department To Employee
									employeeToUpdateDepartment.setDepartment(departmentToAssign);
//									Add Employee To Department
									departmentToAssign.getEmployees().add(employeeToUpdateDepartment);
//									Call updateEmployeeDepartment With Employee And Department
									if (controller.updateEmployeeDepartment(employeeToUpdateDepartment, departmentToAssign)) {
										System.out.println("\n< Employee Department Updated >");
									} else {
										System.err.println("\n< Employee Department Not Updated >");
									}
									
								} else {
									System.out.println("\n< Employee Department Not Changed >");
								}
								
							} else {
							
//								Same Function In Insert Employee
								System.err.println("\n< No Department Assigned To Employee>");
								System.out.println("\nWant To Assign Department To Employee ?");
								System.out.println("1.Yes \n2.No");
								System.out.println("---------------------------------------");
								System.out.print("Enter Number To Select : ");
								int updateDepartmentChoice = sc.nextInt();
								sc.nextLine();
								
								if (updateDepartmentChoice == 1) {
									
//									Function To Assign Department
									Department assignDepartment = assignDepartment(employeeToUpdateDepartment);
//									Set Department To Employee
									employeeToUpdateDepartment.setDepartment(assignDepartment);
//									Add Employee To Department
									assignDepartment.getEmployees().add(employeeToUpdateDepartment);
									
//									Call updateEmployeeDepartment With Employee And Department
									if (controller.updateEmployeeDepartment(employeeToUpdateDepartment, assignDepartment)) {
										System.out.println("\n< Employee Department Updated >");
									} else {
										System.err.println("\n< Employee Department Not Updated >");
									}
									
								} else {
									System.err.println("\n< No Department Assigned To Employee >");
								}
								
							}

						} else {
							System.err.println("\n< Employee Id - " + employeeIdToUpdateDepartment + " Not Found >");
						}

						break;

//					3.1.6.Update Employee Project
					case 6:

						break;

					default:
						System.err.println("< Invalid Choice >");
						break;
					}

//					Sub Switch For Update Employee Ends
					break;

//			3.2.Update Department
				case 2:

//					Add More Options
					System.out.println("\n-------------------------------");
					System.out.println("|  UPDATE DEPARTMENT DETAILS  |");
					System.out.println("-------------------------------");
					System.out.println("|  1.Update Department Name   |");
					System.out.println("-------------------------------");
					System.out.print("Enter Number To Select : ");
//					int updateDepartmentChoice = sc.nextInt();
//					sc.nextLine();
					System.out.println("\n--- UPDATE DEPARTMENT NAME ---");
					System.out.print("\nEnter Department Id To Update : ");
					int departmentIdToUpdateName = sc.nextInt();
					sc.nextLine();
					Department departmentToUpdateName = controller.findDepartment(departmentIdToUpdateName);
					System.out.print(
							"Change Department Name - '" + departmentToUpdateName.getDepartmentName() + "' To : ");
					departmentToUpdateName.setDepartmentName(sc.nextLine());

					if (controller.updateDepartment(departmentToUpdateName)) {
						System.out.println("\n< Department Name Updated >");
					} else {
						System.err.println("\n< Department Name Not Updated >");
					}

					break;

//			3.3.Update Project
				case 3:

					System.out.println("\n--------------------------------");
					System.out.println("|    UPDATE PROJECT DETAILS    |");
					System.out.println("--------------------------------");
					System.out.println("| 1.Update Project Name	       |");
					System.out.println("| 2.Update Project Description |");
					System.out.println("--------------------------------");
					System.out.println("\nEnter Number To Select : ");
					int updateProjectChoice = sc.nextInt();
					sc.nextLine();

//					Sub Switch For Update Project
					switch (updateProjectChoice) {

//					3.3.1.Update Project Name
					case 1:

						System.out.println("\n--- UPDATE PROJECT NAME ---");
						System.out.print("\nEnter Project Id To Update : ");
						int projectIdToUpdateName = sc.nextInt();
						sc.nextLine();
						Project projectToUpdateName = controller.findProject(projectIdToUpdateName);
						System.out.print("Change Project Name - '" + projectToUpdateName.getProjectName() + "' To : ");
						projectToUpdateName.setProjectName(sc.nextLine());

						if (controller.updateProject(projectToUpdateName)) {
							System.out.println("\n< Project Name Updated >");
						} else {
							System.err.println("\n< Project Name Not Updated >");
						}

						break;

//					3.3.2.Update Project Description
					case 2:

						System.out.println("\n--- UPDATE PROJECT DESCRIPTION ---");
						System.out.print("\nEnter Project Id To Update : ");
						int projectIdToUpdateDescription = sc.nextInt();
						sc.nextLine();
						Project projectToUpdateDescription = controller.findProject(projectIdToUpdateDescription);
						System.out.print("Change Project Description - '" + projectToUpdateDescription.getProjectName()
								+ "' To : ");
						projectToUpdateDescription.setProjectDescriptoin(sc.nextLine());

						if (controller.updateProject(projectToUpdateDescription)) {
							System.out.println("\n< Project Name Updated >");
						} else {
							System.err.println("\n< Project Description Not Updated >");
						}

						break;

					default:
						System.err.println("\n< Invalid Choice >");
						break;
					}
//					Sub Switch End
					break;

				default:
					System.err.println("\n< Invalid Choice >");
					break;
				}
//			Sub Switch End

				break;

//-----------------------------------------------------------------

//		4.Delete Data
			case 4:

				System.out.println("\n-------------------------------");
				System.out.println("|         DELETE DATA         |");
				System.out.println("-------------------------------");
				System.out.println("| 1.Delete Employee Details   |");
				System.out.println("| 2.Delete Dapartment Details |");
				System.out.println("| 3.Delete Project Details    |");
				System.out.println("-------------------------------");

//				User Input For Delete Data
				System.out.print("Enter Number To Select : ");
				int deleteChoice = sc.nextInt();
				sc.nextLine();

//			Delete Data Sub Switch
				switch (deleteChoice) {

//			4.1.Delete Employee
				case 1:

					System.out.println("\n--- DELETE EMPLOYEE DETAILS ---");
					System.out.print("\nEnter Employee Id To Remove : ");
					int employeeIdToRemove = sc.nextInt();
					sc.nextLine();

					if (controller.removeEmployee(employeeIdToRemove)) {
						System.out.println("\n< Employee Id - " + employeeIdToRemove + " Removed >");
					} else {
						System.err.println("\n< Employee Id - " + employeeIdToRemove + " Not Found >");
					}

					break;

//			4.2.Delete Department
				case 2:

					System.out.println("\n--- DELETE DEPARTMENT DETAILS ---");
					System.out.print("\nEnter Department Id To Remove : ");
					int departmentIdToRemove = sc.nextInt();
					sc.nextLine();

					if (controller.removeDepartment(departmentIdToRemove)) {
						System.out.println("\n< Department Id - " + departmentIdToRemove + " Removed >");
					} else {
						System.err.println("\n< Department Id - " + departmentIdToRemove + " Not Found >");
					}

					break;

//			4.3.Delete Project
				case 3:

					System.out.println("\n--- DELETE PROJECT DETAILS ---");
					System.out.print("\nEnter Project Id To Remove : ");
					int projectIdToRemove = sc.nextInt();
					sc.nextLine();

					if (controller.removeProject(projectIdToRemove)) {
						System.out.println("\n< Project Id - " + projectIdToRemove + " Removed >");
					} else {
						System.err.println("\n< Project Id - " + projectIdToRemove + " Not Found >");
					}

					break;

				default:
					System.err.println("\n< Invalid Choice >");
					break;
				}
//			Sub Switch End

				break;

//-----------------------------------------------------------------

//		0.Exit
			case 0:
				System.out.println("\n--- THANK YOU ---");
				sc.close();
				System.exit(0);
				break;

//		Default
			default:
				System.err.println("\n< INVALID CHOICE >");
				break;
			}

//-----------------------------------------------------------

//			System.out.println("\n-----------------------------");
//			System.out.println("| 1.Add Employee Details    |");
//			System.out.println("| 2.Find Employee Details   |");
//			System.out.println("| 3.Update Employee Details |");
//			System.out.println("| 4.Remove Employee	 	 	|");
//			System.out.println("|---------------------------|");
//			System.out.println("| 5.Add Department Details  |");
//			System.out.println("| 6.Find Department Details |");
//			System.out.println("|---------------------------|");
//			System.out.println("| 7.Add Project Details     |");
//			System.out.println("| 8.Find Project Details    |");
//			System.out.println("|---------------------------|");
//			System.out.println("| 0.Exit                    |");
//			System.out.println("-----------------------------");

		} while (true);
	}

//	Function To Assign Department
	public static Department assignDepartment(Employee employee) {
		
		List<Department> departmentsToAssign = controller.findAllDepartments();
		System.out.println();
		for (Department department : departmentsToAssign) {
			
			System.out.println("Department Id -----> " + department.getDepartmentId());
			System.out.println("Department Name ---> " + department.getDepartmentName());
			System.out.println("--------------------");
		}
		System.out.print("Select Department Id To Assign For " + employee.getEmployeeName() + " : ");
		int selectedDepartmentId = sc.nextInt();
		sc.nextLine();
		Department selectedDepartment = controller.findDepartment(selectedDepartmentId);
		return selectedDepartment;
	}
	
}
