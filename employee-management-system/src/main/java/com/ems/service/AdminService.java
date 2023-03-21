package com.ems.service;

import com.ems.entity.Admin;
import com.ems.model.AdminDTO;

public interface AdminService {
	void saveAdmin(Admin admin);
	AdminDTO getAdminUsingId(int id);
	AdminDTO updateAdmin(int id,Admin admin );
	void deleteAdmin (int id);
	boolean login(String userName, String password);
}
