
package com.ems.serviceimpl;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ems.dao.EmployeeDAO;
import com.ems.daoimpl.EmployeeDAOImpl;
import com.ems.entity.Employee;
import com.ems.exception.GlobalException;
import com.ems.model.EmployeeDTO;
import com.ems.service.EmployeeService;


public class EmployeeServiceImpl implements EmployeeService {


	 private static final Logger logger =LoggerFactory.getLogger(EmployeeServiceImpl.class);
	 
	//accessing the data access layer(DAO) to call the methods
	EmployeeDAO employeeDAO = new EmployeeDAOImpl();
	
	@Override
	public void saveEmployee(Employee employee) {
		logger.info("New Employee Details Added!!" +employee.toString());
		employeeDAO.saveEmployee(employee);
		
	}

	@Override
	public EmployeeDTO getEmployeeUsingId(int id) {
		Employee employee = employeeDAO.getEmployeeUsingId(id);
		if (employee!=null)
		{
		logger.info("Employee with id"+id+"was retrieved at"+new Date());
			return new ModelMapper().map(employee, EmployeeDTO.class);
		
			
		}
		else 
			throw new GlobalException("Employee details not found!");
		
	}

	@Override
	public EmployeeDTO updateEmployee(int id, Employee employee) {
		Employee emp = employeeDAO.updateEmployee(id, employee);
		if(emp!=null)
		{
			return new ModelMapper().map(emp, EmployeeDTO.class);
		}
		else
			throw new GlobalException("Employee with "+id+" not found!");
		
	}

	@Override
	public void deleteEmployee(int id) {
		employeeDAO.deleteEmployee(id);
		
	}

	@Override
	public boolean login(String userName, String password) {
		return employeeDAO.login(userName, password);
		
	}

}
