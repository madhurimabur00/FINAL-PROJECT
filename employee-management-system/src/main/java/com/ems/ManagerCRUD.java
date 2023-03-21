package com.ems;

import javax.swing.JOptionPane;


import com.ems.entity.Manager;
import com.ems.exception.GlobalException;

import com.ems.model.ManagerDTO;
import com.ems.service.ManagerService;

import com.ems.serviceimpl.ManagerServiceImpl;

public class ManagerCRUD {
	
	static ManagerService managerService = new ManagerServiceImpl();

	public static void saveManager() 
	{
		Manager manager= new Manager(); 
		
		String manName = JOptionPane.showInputDialog("Enter Name: ", "Type Here...");
		String manEmail = JOptionPane.showInputDialog("Enter Email: ", "Type Here...");
		String manAdd = JOptionPane.showInputDialog("Enter Address: ", "Type Here...");
		double manSalary = Double.parseDouble(JOptionPane.showInputDialog("Enter Salary: ", "Type Here..."));
		String user = JOptionPane.showInputDialog("Enter User Name : ", "Type Here...");
		String pass = JOptionPane.showInputDialog("Enter Password: ", "Type Here...");
		
		
		manager.setManName(manName);
		manager.setManEmail(manEmail);
		manager.setManAdd(manAdd);
		manager.setManSalary(manSalary);
		manager.setUserName(user);
		manager.setPassword(pass);
		manager.setRole("manager");
		
		managerService.saveManager(manager);
		System.out.println();
		System.out.println("Manager Details Saved!!");
		System.out.println("************************************************");
		System.out.println();
	}
	public static void getManager() throws GlobalException
	{
		int id = Integer.parseInt(JOptionPane.showInputDialog("Enter id to search: ", "Type Here..."));
		
		ManagerDTO manager1=managerService.getManagerUsingId(id);
		
		System.out.println("Manager Name: "+manager1.getManName());
		System.out.println("Manager Email: "+manager1.getManEmail());
		System.out.println("Manager Address: "+manager1.getManAdd());
		System.out.println("Manager Salary: "+manager1.getManSalary());
		System.out.println();
		System.out.println("************************************************");
		System.out.println();
		
	}
	public static void updateManager() throws GlobalException
	{
		Manager manager2 = new Manager();
		
		
		String manName = JOptionPane.showInputDialog("Enter Manager Name: ", "Type Here...");
		String manEmail = JOptionPane.showInputDialog("Enter Manager Email: ", "Type Here...");
		String manAdd  = JOptionPane.showInputDialog("Enter Manager Address: ", "Type Here...");
		double manSalary = Double.parseDouble(JOptionPane.showInputDialog("Enter Manager Salary: ", "Type Here..."));
		
		String user = JOptionPane.showInputDialog("Enter User Name: ", "Type Here...");
		String pass = JOptionPane.showInputDialog("Enter Password: ", "Type Here...");
		
		
		manager2.setManName(manName);
		manager2.setManEmail(manEmail);
		manager2.setManAdd(manAdd);
		manager2.setManSalary(manSalary);
		manager2.setUserName(user);
		manager2.setPassword(pass);
		
		managerService.updateManager(Integer.parseInt(JOptionPane.showInputDialog("Enter id "
				+ "to update ", "Type Here...")), manager2);
		System.out.println();
		System.out.println("Manager details updated successfully!!");
		System.out.println("************************************************");
		System.out.println();
	}
	
	public static void deleteManager() throws GlobalException
	{
		int id = Integer.parseInt(JOptionPane.showInputDialog("Enter id to delete: ", "Type Here..."));
		managerService.deleteManager(id);
	}
	
	public static void afterLoginManager()
	{
		
		System.out.println();
		System.out.println("------------------------------------------");
		System.out.println("CHOOSE AN OPTION");
		System.out.println("------------------------------------------");
		System.out.println("1.Get Manager details by using Id\n"
    			+ "2.Update Manager  details\n3.Exit");
		String choice = JOptionPane.showInputDialog("Enter choice: ", "Type Here...");
    	switch (choice)
    	{
    	
    	case "1":
    		getManager();
    		break;
    	case "2":
    		updateManager();
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
    	
