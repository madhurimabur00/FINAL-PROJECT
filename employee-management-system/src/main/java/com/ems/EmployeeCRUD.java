package com.ems;

import java.time.LocalDate;


import javax.swing.JOptionPane;

import com.ems.entity.Employee;
import com.ems.exception.GlobalException;
import com.ems.model.EmployeeDTO;
import com.ems.service.EmployeeService;
import com.ems.serviceimpl.EmployeeServiceImpl;

public class EmployeeCRUD {
	
	
	static EmployeeService empService = new EmployeeServiceImpl();
	
	public static void saveEmployee()
	{
		Employee emp = new Employee();
		/*sc.nextLine();
		System.out.println("Enter name:");
		String name = sc.nextLine();
		System.out.println("Enter Address:");
		String add = sc.nextLine();
		System.out.println("Enter Salary: ");
		double sal = sc.nextDouble();
		sc.nextLine();
		System.out.println("enter contact number: ");
		String cont = sc.nextLine();
		System.out.println("Enter email: ");
		String email = sc.nextLine();
		System.out.println("Enter designation:");
		String des = sc.nextLine();
		System.out.println("Enter DOJ: ");
		LocalDate date = LocalDate.parse(sc.next());
		System.out.println("Enter username: ");
		String user = sc.next();
		System.out.println("Enter password:");
		String pass = sc.next();*/
		
		String name = JOptionPane.showInputDialog("Enter Name: ", "Type Here...");
		String add = JOptionPane.showInputDialog("Enter Address: ", "Type Here...");
		Double sal = Double.parseDouble(JOptionPane.showInputDialog("Enter Salary: ", "Type Here..."));
		String cont = JOptionPane.showInputDialog("Enter Phonbe Number: ", "Type Here...");
		String email = JOptionPane.showInputDialog("Enter Email: ", "Type Here...");
		String des = JOptionPane.showInputDialog("Enter Designation: ", "Type Here...");
		LocalDate date = LocalDate.parse(JOptionPane.showInputDialog("Enter D.O.J: ", "Type Here..."));
		String user = JOptionPane.showInputDialog("Enter Username: ", "Type Here...");
		String pass = JOptionPane.showInputDialog("Enter Password: ", "Type Here...");
		
		
		emp.setEmpName(name);
		emp.setEmpAddress(add);
		emp.setSalary(sal);
		emp.setContact(cont);
		emp.setEmail(email);
		emp.setDesignation(des);
		emp.setDOJ(date);
		emp.setUserName(user);
		emp.setPassword(pass);
		emp.setRole("employee");
		
		
		empService.saveEmployee(emp);
		System.out.println();
		System.out.println("Employee Details Saved!!");
		System.out.println("************************************************");
		System.out.println();
		
		
	}
	

	//getting employee details by using id
	public static void getEmployee() throws GlobalException
	{
		int id = Integer.parseInt(JOptionPane.showInputDialog("Enter id to search: ", "Type Here..."));
		
		EmployeeDTO emp1=empService.getEmployeeUsingId(id);
		
		System.out.println("Employee Name: "+emp1.getEmpName());
		System.out.println("Employee Address: "+emp1.getEmpAddress());
		System.out.println("Employee salary: "+emp1.getSalary());
		System.out.println("Employee contact: "+emp1.getContact());
		System.out.println("Employee email: "+emp1.getEmail());
		System.out.println();
		System.out.println("************************************************");
		System.out.println();
	}
	
	
	//UPDATING EMPLOYEE DETAILS
	public static void updateEmployee() throws GlobalException
	{
		Employee emp2 = new Employee();
		
		
		String name = JOptionPane.showInputDialog("Enter name: ", "Type Here...");
		String add = JOptionPane.showInputDialog("Enter address: ", "Type Here...");
		Double sal = Double.parseDouble(JOptionPane.showInputDialog("Enter salary: ", "Type Here..."));
		String cont = JOptionPane.showInputDialog("Enter phonbe number: ", "Type Here...");
		String email = JOptionPane.showInputDialog("Enter email: ", "Type Here...");
		String des = JOptionPane.showInputDialog("Enter designation: ", "Type Here...");
		LocalDate date = LocalDate.parse(JOptionPane.showInputDialog("Enter D.O.J: ", "Type Here..."));
		String user = JOptionPane.showInputDialog("Enter username: ", "Type Here...");
		String pass = JOptionPane.showInputDialog("Enter password: ", "Type Here...");
		
		emp2.setEmpName(name);
		emp2.setEmpAddress(add);
		emp2.setSalary(sal);
		emp2.setContact(cont);
		emp2.setEmail(email);
		emp2.setDesignation(des);
		emp2.setDOJ(date);
		emp2.setUserName(user);
		emp2.setPassword(pass);
		emp2.setRole("employee");
		
		empService.updateEmployee(Integer.parseInt(JOptionPane.showInputDialog("Enter id to "
				+ "update ", "Type Here...")), emp2);
		System.out.println();
		System.out.println("Employee details updated successfully!!");
		System.out.println("************************************************");
		System.out.println();
		
	}
		public static void deleteEmployee() throws GlobalException
		{
			int id = Integer.parseInt(JOptionPane.showInputDialog("Enter id to delete: ", "Type Here..."));
			empService.deleteEmployee(id);
			System.out.println();
			System.out.println("************************************************");
			System.out.println();
		}
		
		public static void login()
		{
			String user = JOptionPane.showInputDialog("Enter User Name: ", "Type Here...");
			String pass = JOptionPane.showInputDialog("Enter Password: ", "Type Here...");
			
			empService.login(user, pass);
			System.out.println();
			System.out.println(" Successfully logged in to Employee PORTAL!!");
			System.out.println("************************************************");
			System.out.println();
			
		}
		
		public static void afterLoginEmployee()
		{
			
			System.out.println();
			System.out.println("------------------------------------------");
			System.out.println("CHOOSE AN OPTION");
			System.out.println("------------------------------------------");
			System.out.println();
			System.out.println("1.Get Employee details by using Id\n"
	    			+ "2.Update Employee details"
	    			+ "\n3.Exit");
			String choice = JOptionPane.showInputDialog("Enter choice: ", "Type Here...");
	    	switch (choice)
	    	{
	    	
	    	case "1":
	    		getEmployee();
	    		break;
	    	case "2":
	    		updateEmployee();
	    		break;
	    	case "3":
	    		System.exit(0);
	    		break;
	    	default:
	    		System.out.println();
	    		System.out.println("WRONG INPUT!!");
	    		System.out.println("**********************************************");
	    		
	    		
	    		
	    	}


}
}
