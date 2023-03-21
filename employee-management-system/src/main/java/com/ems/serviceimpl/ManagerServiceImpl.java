package com.ems.serviceimpl;

import org.modelmapper.ModelMapper;


import com.ems.dao.ManagerDAO;

import com.ems.daoimpl.ManagerDAOImpl;

import com.ems.entity.Manager;
import com.ems.exception.GlobalException;

import com.ems.model.ManagerDTO;
import com.ems.service.ManagerService;

public class ManagerServiceImpl implements ManagerService {

	ManagerDAO managerDAO = new ManagerDAOImpl();
	@Override
	public void saveManager(Manager manager) {
	    
		managerDAO.saveManager(manager);
	}

	@Override
	public ManagerDTO getManagerUsingId(int id) {
		Manager manager=managerDAO.getManagerUsingId(id);
		if(manager!=null)
		{
			return  new ModelMapper().map(manager, ManagerDTO.class);
		} 
		else 
			throw new GlobalException("Manager details not found!!");
		
		
	}

	@Override
	public ManagerDTO updateManager(int id, Manager manager) {
		Manager man=managerDAO.updateManager(id, manager);
		if(man!=null)
		{
			return  new ModelMapper().map(manager, ManagerDTO.class);
		}
		else
			{
			throw new GlobalException("Manager with "+id+" not found!!");
			}
		
	}

	@Override
	public void deleteManager(int id) {
		managerDAO.deleteManager(id);
		
	}

	@Override
	public boolean login(String userName, String password) {
		return managerDAO.login(userName, password);
	}

}
