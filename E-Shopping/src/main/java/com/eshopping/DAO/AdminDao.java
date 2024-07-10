package com.eshopping.DAO;

import java.util.List;

import com.eshopping.DTO.AdminDTO;
import com.eshopping.entity.Admin;

public interface AdminDao
{
	Admin AdminRegistration(AdminDTO adminDTO);
	List<Admin> getAllDetails();
}
