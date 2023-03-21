package com.ems;


import javax.swing.JOptionPane;

import com.ems.entity.Admin;

import com.ems.exception.GlobalException;
import com.ems.model.AdminDTO;

import com.ems.service.AdminService;
import com.ems.serviceimpl.AdminServiceImpl;

public class AdminCRUD {
	
	static AdminService adminService = new AdminServiceImpl();

	public static void saveAdmin() 
	{
		Admin admin = new Admin(); 
		
		String name = JOptionPane.showInputDialog("Enter Name: ", "Type Here...");
		String email = JOptionPane.showInputDialog("Enter Email: ", "Type Here...");
		String user = JOptionPane.showInputDialog("Enter User Name : ", "Type Here...");
		String pass = JOptionPane.showInputDialog("Enter Password: ", "Type Here...");
		
		
		admin.setAdminName(name);
		admin.setAdminEmail(email);
		admin.setUserName(user);
		admin.setPassword(pass);
		admin.setRole("admin");
		
		adminService.saveAdmin(admin);
		System.out.println();
		System.out.println("Admin Details Saved Successfully!!");
		System.out.println("************************************************");
		System.out.println();
	}
	
	//get admin details using id
	public static void getAdmin() throws GlobalException
	{
		int id = Integer.parseInt(JOptionPane.showInputDialog("Enter id to search: ", "Type Here..."));
		
		AdminDTO adm1=adminService.getAdminUsingId(id);
		
		System.out.println("Admin Name: "+adm1.getAdminName());
		System.out.println("Admin Email: "+adm1.getAdminEmail());
		System.out.println();
		System.out.println("************************************************");
		System.out.println();
		
	}
	//update admin details using id
	public static void updateAdmin() throws GlobalException
	{
		Admin adm2 = new Admin();
		
		
		String name = JOptionPane.showInputDialog("Enter Admin Name: ", "Type Here...");
		String email = JOptionPane.showInputDialog("Enter Admin Email: ", "Type Here...");
		String user = JOptionPane.showInputDialog("Enter User Name: ", "Type Here...");
		String pass = JOptionPane.showInputDialog("Enter Password: ", "Type Here...");
		
		
		adm2.setAdminName(name);
		adm2.setAdminEmail(email);
		adm2.setUserName(user);
		adm2.setPassword(pass);
		
		adminService.updateAdmin(Integer.parseInt(JOptionPane.showInputDialog("Enter id to "
				+ "update ", "Type Here...")), adm2);
		System.out.println();
		System.out.println("Admin details updated successfully!!");		
		System.out.println("************************************************");
		System.out.println();
		
		
	}
	public static void deleteAdmin() throws GlobalException
	{
		int id = Integer.parseInt(JOptionPane.showInputDialog("Enter id to delete: ", "Type Here..."));
		adminService.deleteAdmin(id);
		System.out.println();
		System.out.println("Admin details deleted successfully!!");
		System.out.println("************************************************");
		System.out.println();
	}
	
	//login to admin
	public static void login()
	{
		String user = JOptionPane.showInputDialog("Enter User Name: ", "Type Here...");
		String pass = JOptionPane.showInputDialog("Enter Password: ", "Type Here...");
		
		adminService.login(user, pass);
	}
	
	//calling methods from empoyeeCRUD.
	public static void afterLoginAdmin()
	{
		System.out.println();
		System.out.println("------------------------------------------");
		System.out.println("CHOOSE AN OPTION");
		System.out.println("------------------------------------------");
		System.out.println();
		
		System.out.println("1.Save new Admin details"
				+ "\n2.Get Admin details by using Id\n"
    			+ "3.Update Admin details"
    			+ "\n4.Delete Admin details using id");
		System.out.println();
		System.out.println("------------------------------------------");
		System.out.println("5.Save new Employee"
				+ "\n6.Get Employee details  using Id\n"
    			+ "7.Update Employee details\n"
    			+ "8.Delete Employee details using id"
    			+ "\n9.Assign Employee to Department");
		System.out.println();
		System.out.println("------------------------------------------");
		System.out.println("10.Save new Department\n"
				+ "11.Get Department details  using Id\n"
    			+ "12.Update Department  details"
    			+ "\n13.Delete Department details using id");
		System.out.println();
		System.out.println("------------------------------------------");
		System.out.println("14.Save new Manager"
				+ "\n15.Get Manager details  using Id\n"
    			+ "16.Update Manager details"
    			+ "\n17.Delete Manager details using id"
    			+ "\n19.Exit");
		System.out.println("------------------------------------------");
		String choice = JOptionPane.showInputDialog("Enter choice: ", "Type Here...");
    	switch (choice)
    	{
    	case "1":
    		saveAdmin();
    		
    		break;
    	case "2":
    		getAdmin();
    		break;
    	case "3":
    		updateAdmin();
    		break;
    	case "4":
    		deleteAdmin();
    		break;
    	case "5":
    		EmployeeCRUD.saveEmployee();
    		
    		break;
    	case "6":
    		EmployeeCRUD.getEmployee();
    		break;
    	case "7":
    		EmployeeCRUD.updateEmployee();
    		break;
    	case "8":
    		EmployeeCRUD.deleteEmployee();
    		break;
    	case "9":
    		DepartmentCRUD.assignEmpTODept();
    		break;
    	case "10":
    		DepartmentCRUD.saveDepartment();
    		break;
    	case "11":
    		DepartmentCRUD.getDepartment();;
    		break;
    	case "12":
    		DepartmentCRUD.updateDepartment();
    		break;
    	case "13":
    		DepartmentCRUD.deleteDepartment();
    		break;
    	case "14":
    		ManagerCRUD.saveManager();
    		break;
    	case "15":
    		ManagerCRUD.getManager();;
    		break;
    	case "16":
    		ManagerCRUD.updateManager();
    		break;
    	case "17":
    		ManagerCRUD.deleteManager();
    		break;
    	case "18":
    		System.exit(0);
    		break;
    	default:
    		System.out.println("WRONG INPUT!!");
    	}
    
	}
    
	}

