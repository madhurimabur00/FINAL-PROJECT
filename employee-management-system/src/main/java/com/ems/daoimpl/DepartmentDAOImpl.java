package com.ems.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ems.config.HibernateUtil;
import com.ems.dao.DepartmentDAO;
import com.ems.entity.Department;
import com.ems.entity.Employee;

public class DepartmentDAOImpl implements DepartmentDAO {

	@Override
	public void saveDepartment(Department department) {
		try(Session session=HibernateUtil.getSession())
		{
			session.beginTransaction();
			
			session.save(department);
			
			session.getTransaction().commit();
			
			
			session.clear();
		}
		catch (HibernateException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		
	}

}

	@Override
	public Department getDepartmentUsingId(int id) {
		try(Session session=HibernateUtil.getSession())
		{
			Department department= session.get(Department.class, id);
			return department;
		}
		catch (HibernateException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}

	

	@Override
	public Department updateDepartment(int id, Department department) {
		try(Session session=HibernateUtil.getSession())
		{
			Department dept=session.get(Department.class, id);
			dept.setDeptName(department.getDeptName());
			dept.setTotalEmp(department.getTotalEmp());
			dept.setLocation(department.getLocation());
			
			session.beginTransaction();
			session.saveOrUpdate(dept);
			session.getTransaction().commit();
			
		
		return dept;
	}

catch (HibernateException e) 
{
	System.out.println(e.getMessage());
}
catch (Exception e)
{
	System.out.println(e.getMessage());
}
return null;
	}
	
	@Override
	public void assignEmployeeToDept(int employeeId, int deptId) {
		try(Session session=HibernateUtil.getSession())
		{
			Employee emp = session.get(Employee.class, employeeId);
			Department dept = session.get(Department.class, deptId);
			
			List<Employee> employees = new ArrayList<>();
			employees.add(emp);
			dept.setEmployees(employees);
			emp.setDept(dept);
			
			dept.setTotalEmp(dept.getTotalEmp()+1);
			
			session.beginTransaction();
			session.saveOrUpdate(dept);
			session.getTransaction().commit();
		}
	catch (HibernateException e) {
		System.out.println(e.getMessage());
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
	
		
	}

	@Override
	public void deleteDepartmentusingId(int id) {
		try(Session session=HibernateUtil.getSession())
		{
			Department dept=session.load(Department.class, id);
			session.beginTransaction();
			int input=JOptionPane.showConfirmDialog(null, "do you want to delete all departmentdetails??","Are you sure??"
					, JOptionPane.YES_NO_OPTION);
			
			if(input ==0)
				
			{
				session.delete(dept);
				
				JOptionPane.showMessageDialog(null,"deleted successfully");
				
			}else
			{
				JOptionPane.showMessageDialog(null,"User wants to return mainmenu");	
			}
			session.getTransaction().commit();
		}
		catch (HibernateException e) 
		{
			System.out.println(e.getMessage());
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
}
