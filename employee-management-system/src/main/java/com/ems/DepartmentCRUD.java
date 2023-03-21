package com.ems;

import javax.swing.JOptionPane;


import com.ems.entity.Department;

import com.ems.exception.GlobalException;
import com.ems.model.DepartmentDTO;

import com.ems.service.DepartmentService;
import com.ems.serviceimpl.DepartmentServiceImpl;

public  class DepartmentCRUD {
	static DepartmentService deptService= new DepartmentServiceImpl();
	
	public static  void saveDepartment() {
		Department dept= new Department();
		String deptName= JOptionPane.showInputDialog("Enter department name: ", "Type Here...");
		int total= Integer.parseInt(JOptionPane.showInputDialog("Enter total employee: ", "Type Here..."));
		String loc=JOptionPane.showInputDialog("Enter location: ", "Type Here...");
		
		dept.setDeptName(deptName);
		dept.setTotalEmp(total);
		dept.setLocation(loc);
		
		
		deptService.saveDepartment(dept);
		System.out.println("New department details added!!");
		System.out.println("************************************************");
		System.out.println();
	}
	
		
		public static void getDepartment() throws GlobalException {
			int id=Integer.parseInt(JOptionPane.showInputDialog("Enter ID to search Department Details: ", "Type Here..."));
			DepartmentDTO dept1=deptService.getDeptUsingId(id);
			
			System.out.println("department Name: "+dept1.getDeptName());
			System.out.println("department Location: "+dept1.getLocation());
			System.out.println("Total Employee: "+dept1.getTotalEmp());
			
		}
		
		public static void updateDepartment() throws GlobalException
		{
			Department dept2= new Department(); 
			String deptName= JOptionPane.showInputDialog("Enter department name: ", "Type Here...");
			int total= Integer.parseInt(JOptionPane.showInputDialog("Enter total employee: ", "Type Here..."));
			String loc=JOptionPane.showInputDialog("Enter location: ", "Type Here...");
			
			dept2.setDeptName(deptName);
			dept2.setTotalEmp(total);
			dept2.setLocation(loc);
			
			
			deptService.updateDepartment(Integer.parseInt(JOptionPane.showInputDialog("Enter id to update Department Details ", "Type Here...")), dept2);
			System.out.println("Department details updated successfully!!");
			System.out.println("************************************************");
			System.out.println();
			

	}
		public static void deleteDepartment() throws GlobalException
		{
			int id = Integer.parseInt(JOptionPane.showInputDialog("Enter id to delete Department Details: ", "Type Here..."));
			deptService.deleteDepartmentusingId(id);
			System.out.println("Department details deleted successfully!!");
			System.out.println("************************************************");
			System.out.println();
		}
		public static void assignEmpTODept() throws GlobalException
		{
			int deptId=Integer.parseInt(JOptionPane.showInputDialog("Enter Department ID: ", "Type Here..."));
			int id=Integer.parseInt(JOptionPane.showInputDialog("Enter Employee ID: ", "Type Here..."));
			
			deptService.assignEmployeeToDept(id, deptId);
			JOptionPane.showMessageDialog(null, "Employee Assigned Successfully!!");
			
		}

}


