package com.ems.dao;



import com.ems.entity.Manager;

public interface ManagerDAO {

	void saveManager(Manager manager);
	Manager getManagerUsingId(int id);
	Manager updateManager(int id,Manager manager);
	void deleteManager (int id);
	boolean login(String userName, String password);
}
