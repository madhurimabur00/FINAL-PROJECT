package com.ems.service;

import com.ems.entity.Manager;
import com.ems.model.ManagerDTO;

public interface ManagerService {
	void saveManager(Manager manager);
	ManagerDTO getManagerUsingId(int id);
	ManagerDTO updateManager(int id,Manager manager);
	void deleteManager (int id);
	boolean login(String userName, String password);
}
