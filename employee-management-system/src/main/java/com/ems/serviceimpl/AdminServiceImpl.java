package com.ems.serviceimpl;



import org.modelmapper.ModelMapper;


import com.ems.dao.AdminDAO;

import com.ems.daoimpl.AdminDAOImpl;

import com.ems.entity.Admin;

import com.ems.exception.GlobalException;
import com.ems.model.AdminDTO;

import com.ems.service.AdminService;

public class AdminServiceImpl implements AdminService{
	
	AdminDAO adminDAO = new AdminDAOImpl();

	@Override
	public void saveAdmin(Admin admin) {
		adminDAO.saveAdmin(admin);
		
	}

	@Override
	public AdminDTO getAdminUsingId(int id) {
		Admin admin = adminDAO.getAdminUsingId(id);
		if (admin!=null)
		{
			return new ModelMapper().map(admin, AdminDTO.class);
		
			
		}
		else 
			throw new GlobalException("Admin details not found!!");
		
		
	}

	@Override
	public AdminDTO updateAdmin(int id, Admin admin) {
		Admin emp = adminDAO.updateAdmin(id, admin);
		if(emp!=null)
		{
			return new ModelMapper().map(emp, AdminDTO.class);
		}
		else
			throw new GlobalException("Admin with "+id+" not found!");
		
		
	}

	@Override
	public void deleteAdmin(int id) {
		adminDAO.deleteAdmin(id);
		
	}

	@Override
	public boolean login(String userName, String password) {
		return adminDAO.login(userName, password);
		
	}

}
