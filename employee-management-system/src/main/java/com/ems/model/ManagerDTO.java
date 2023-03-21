package com.ems.model;

import java.util.List;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ManagerDTO  {

	private int id;
	private String manName;
	private String manEmail;
	private String manAdd;
	private double manSalary;
	
	
	private DepartmentDTO dept;
}
