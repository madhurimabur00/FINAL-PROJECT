package com.ems.serviceimpl;

import org.modelmapper.ModelMapper;

import com.ems.dao.DepartmentDAO;
import com.ems.daoimpl.DepartmentDAOImpl;
import com.ems.entity.Department;
import com.ems.exception.GlobalException;
import com.ems.model.DepartmentDTO;
import com.ems.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {

	DepartmentDAO deptDAO = new DepartmentDAOImpl();
	
	//save details
	@Override
	public void saveDepartment(Department department) {
		deptDAO.saveDepartment(department);
		}

	//get details by using id
	@Override
	public DepartmentDTO getDeptUsingId(int id) {
		Department department=deptDAO.getDepartmentUsingId(id);
		if(department!=null)
		{
			return  new ModelMapper().map(department, DepartmentDTO.class);
		} 
		else 
			throw new GlobalException("depatment details not found!!");
		
	}

//update details by using id
	@Override
	public DepartmentDTO updateDepartment(int id, Department department) {
		Department dept=deptDAO.updateDepartment(id, department);
		if(dept!=null)
		{
			return  new ModelMapper().map(department, DepartmentDTO.class);
		}
		else
			{
			throw new GlobalException("depatment with "+id+" not found!!");
			}
		
	}

	//delete details by using id
	@Override
	public void deleteDepartmentusingId(int id) {
		deptDAO.deleteDepartmentusingId(id);
		
	}


	@Override
	public void assignEmployeeToDept(int employeeId, int deptId) {
		deptDAO.assignEmployeeToDept(employeeId, deptId);
		
	}
}
