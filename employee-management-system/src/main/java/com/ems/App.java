package com.ems;




import java.util.Scanner;


import javax.swing.JOptionPane;

import com.ems.service.AdminService;
import com.ems.service.EmployeeService;
import com.ems.service.ManagerService;
import com.ems.serviceimpl.AdminServiceImpl;
import com.ems.serviceimpl.EmployeeServiceImpl;
import com.ems.serviceimpl.ManagerServiceImpl;



public class App 
{
	static AdminService adminService=new AdminServiceImpl();
	static EmployeeService employeeService=new EmployeeServiceImpl();
	static ManagerService managerService=new ManagerServiceImpl();
	
	static Scanner sc = new Scanner(System.in);
	
    public static void main( String[] args )
    {
    	mainMenu();
    }
    
    
    public static void mainMenu() {
    	int ch;
    	 do {
    		 System.out.println();
    		 
        System.out.println( "Welcome to Employee Management System!!" );
        System.out.println("------------------------------------------");
        System.out.println("-------------CHOOSE AN OPTION-------------");
        System.out.println("1) Admin Portal\n2)"
        		+ " Employee Portal"
        		+ "\n3) Manager Portal"
        		+ "\n4) Exit");
        System.out.println("------------------------------------------");
       // ch = sc.nextInt();
        ch =Integer.parseInt(JOptionPane.showInputDialog("Enter choice: ", "Type Here..."));
        switch(ch)
        {
        case 1:
        	mainAdmin();
        	break;
        case 2:
        	mainUser();
        	break;
        case 3:
        	mainManager();
        	break;
        case 4:
        	System.exit(0);
        	break;
        default:
        	System.out.println("WRONG INPUT!!");
        }
    	 }while(ch!=4);
        
    }
    
    //FOR EMPLOYEE
    public static void mainUser() {
    	
    	System.out.println();
    	System.out.println("------------------------------------------");
    	System.out.println("<<<<<<<<<Welcome to Employee portal>>>>>>>>");
    	System.out.println("------------------------------------------");
    	do {
    		System.out.println();
    		System.out.println("1)LOGIN\n2)EXIT");
    	String choice = JOptionPane.showInputDialog("Enter choice: ", "Type Here...");
    	switch (choice)
    	{
    	case "1":
    		boolean status =employeeService.login(JOptionPane.showInputDialog("Enter UserName: ", "Type Here..."), 
    				JOptionPane.showInputDialog("Enter Password: ", "Type Here..."));
    		if(status==true)
    		{
    			EmployeeCRUD.afterLoginEmployee();
    		}else
    		{
    			JOptionPane.showMessageDialog(null, "WRONG INPUT!!");
    		}
    			break;
    	case "2":
    		mainMenu() ;
    		break;
    	default:
			System.out.println("WRONG INPUT!!");
    		}
    	}while(true);
    }
    
    	//FOR ADMIN
    public static void mainAdmin() {
    	System.out.println();
    	System.out.println("------------------------------------------");
    	System.out.println("<<<<<<<<<Welcome to Admin portal>>>>>>>>");
    	System.out.println("------------------------------------------");
    	do {
    		
    		System.out.println("1)LOGIN\n2)EXIT");
    	String choice = JOptionPane.showInputDialog("Enter choice: ", "Type Here...");
    	switch (choice)
    	{
    	case "1":
    		boolean status =adminService.login(JOptionPane.showInputDialog("Enter UserName: ", "Type Here..."),
    				JOptionPane.showInputDialog("Enter Password: ", "Type Here..."));
    		if(status==true)
    		{
    			AdminCRUD.afterLoginAdmin();
    		}else
    		{
    			JOptionPane.showMessageDialog(null, "WRONG INPUT!!");
    		}
    			
    		break;
    	case "2":
    		mainMenu() ;
    		break; 
    		default:
    			System.out.println("WRONG INPUT!!");
    		}
    	 }while(true);
    	 
    }
public static void mainManager() {
    	
    	System.out.println();
    	System.out.println("------------------------------------------");
    	System.out.println("<<<<<<<<<Welcome to Manager portal>>>>>>>>");
    	System.out.println("------------------------------------------");
    	do {
    		System.out.println();
    		System.out.println("1)LOGIN\n2)EXIT");
    	String choice = JOptionPane.showInputDialog("Enter choice: ", "Type Here...");
    	switch (choice)
    	{
    	case "1":
    		boolean status =managerService.login(JOptionPane.showInputDialog("Enter UserName: ", "Type Here..."), 
    				JOptionPane.showInputDialog("Enter Password: ", "Type Here..."));
    		if(status==true)
    		{
    			ManagerCRUD.afterLoginManager();
    		}else
    		{
    			JOptionPane.showMessageDialog(null, "WRONG INPUT!!");
    		}
    			break;
    	case "2":
    		mainMenu() ;
    		break;
    	default:
			System.out.println("WRONG INPUT!!");
    
    		}
    	}while(true);
    }
    
}
    
    
    

