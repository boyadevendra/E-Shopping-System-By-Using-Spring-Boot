package com.eshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eshopping.DAO.AdminDao;
import com.eshopping.DTO.AdminDTO;
import com.eshopping.entity.Admin;

@Controller
public class AdminController 
{
	@Autowired
	AdminDao admindao;
	
	@RequestMapping("/AdminRegistrationPage")
	public String loginpage(Model model)
	{
		model.addAttribute("admin", new AdminDTO());
		
		return "AdminRegistration";
	}
	@RequestMapping("/AdminRegistration")
	public String AdminRegsitration(AdminDTO admin,Model model)
	{
		List<Admin> allDetails = admindao.getAllDetails();
		long emailcount = allDetails.stream().filter((details->details.getEmailid().equalsIgnoreCase(admin.getAdminname()))).count();
		long passcount = allDetails.stream().filter((password->password.getPassword().equals(admin.getPassword()))).count();
		if(emailcount>0)
		{
			model.addAttribute("admin", admin);
			model.addAttribute("emailmsg","Already EmailId Existed");
			return"AdminRegistration";
		}
		if(passcount>0)
		{
			model.addAttribute("admin", admin);
			model.addAttribute("passmsg","Already password Existed");
			return"AdminRegistration";
		}
	     Admin	saveDetails=admindao.AdminRegistration(admin);
	     if(saveDetails!=null)
	     {
	    	 model.addAttribute("msg", "Login sucessfull");
	    	 return"AdminLogin";
	     }
		else
		{
			
			return"AdminRegistration";
			
		}
	}
	
}
