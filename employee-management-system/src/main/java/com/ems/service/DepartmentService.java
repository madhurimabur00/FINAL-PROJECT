package com.ems.service;

import com.ems.entity.Department;
import com.ems.model.DepartmentDTO;

public interface DepartmentService {
	void saveDepartment(Department department);
	DepartmentDTO getDeptUsingId(int id);
	DepartmentDTO updateDepartment(int id, Department department);
	void deleteDepartmentusingId(int id);
	void assignEmployeeToDept(int employeeId, int deptId);
	
	
	
}
