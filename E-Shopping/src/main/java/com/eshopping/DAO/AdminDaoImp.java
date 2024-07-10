package com.eshopping.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eshopping.DTO.AdminDTO;
import com.eshopping.Repository.AdminRepository;
import com.eshopping.entity.Admin;
@Component
public class AdminDaoImp implements AdminDao
{
	@Autowired
	AdminRepository adminRepository;
	@Override
	public Admin AdminRegistration(AdminDTO adminDTO) 
	{
		Admin details=new Admin();
		details.setAdminname(adminDTO.getAdminname());
		details.setEmailid(adminDTO.getEmailid());
		details.setPassword(adminDTO.getPassword());
		details.setRole(adminDTO.getRole());
		Admin result = adminRepository.save(details);
		
		return result;
	}
	@Override
	public List<Admin> getAllDetails() {
		List<Admin> list = adminRepository.findAll();
		return list;
	}
	
}
