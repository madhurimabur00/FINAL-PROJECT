package com.ems.service;

import com.ems.entity.Employee;
import com.ems.model.EmployeeDTO;

public interface EmployeeService {
	void saveEmployee(Employee employee);
	EmployeeDTO getEmployeeUsingId(int id);
	EmployeeDTO updateEmployee(int id, Employee employee);
	void deleteEmployee(int id);
	boolean login(String userName, String password);
	
}
