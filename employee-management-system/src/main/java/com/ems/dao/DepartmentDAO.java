package com.ems.dao;

import com.ems.entity.Department;



public interface DepartmentDAO {
	void saveDepartment(Department department);
	Department getDepartmentUsingId(int id);
	Department updateDepartment(int id, Department department);
	void deleteDepartmentusingId(int id);
	void assignEmployeeToDept(int employeeId, int deptId);
	
}
