package com.eshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eshopping.DAO.ProductDetailsDao;
import com.eshopping.DAO.userDetailsDao;
import com.eshopping.DTO.UserDetailsDTO;
import com.eshopping.entity.ProductDetails;
import com.eshopping.entity.UserDetails;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@Controller
public class UserController 
{
	@Autowired
	ProductDetailsDao productDetailsDao;
	
	@Autowired
	userDetailsDao userDetailsDao;
	
	@RequestMapping("/registration")
	public String userRegistrationPage(Model model)
	{
		model.addAttribute("userdetails",new UserDetailsDTO());
		return"UserRegistration";
	}
	
//	registration kosam chesanu
//	@RequestMapping("/registrationdetails")
//	//@ResponseBody
//	public String userRegistrationDetails(UserDetails user,Model model)
//	{	
//		UserDetails userRegistration = userDetailsDao.UserRegistration(user);
//		if(userRegistration!=null)
//		{
//			model.addAttribute("msg","registration sucessfull");
//			model.addAttribute("userdetails",new UserDetails());
//			return"UserRegistration";
//		}
//		else
//		{
//			model.addAttribute("msg","registration not  sucessfull");
//			model.addAttribute("userdetails",new UserDetails());
//			return"UserRegistration";
//		}
//	}
	
	@RequestMapping("/registrationdetails")
	public String UserRegsitrationDetails(UserDetailsDTO userdetailsDto,Model model)
	{
		List<UserDetails> getallDetails = userDetailsDao.getallDetails();
		long emailcount = getallDetails.stream().filter((userdetails->userdetails.getEmailid().equalsIgnoreCase(userdetailsDto.getEmailid()))
				).count();
		long passwordcount=getallDetails.stream().filter((password->password.getPassword().equalsIgnoreCase(userdetailsDto.getPassword()))).count();
		if(emailcount>0)
		{
			model.addAttribute("emailmsg","Emailid Already  Existed");
			model.addAttribute("userdetails",userdetailsDto);
			return"UserRegistration";
		}
		if(passwordcount>0)
		{
			model.addAttribute("passwordmsg","password Already  Existed");
			model.addAttribute("userdetails",userdetailsDto);
			return"UserRegistration";
		}
		UserDetails userRegistration = userDetailsDao.UserRegistration(userdetailsDto);
		if(userRegistration!=null)
		{
			return"UserLogin";
		}
		else
		{
			return "UserRegistration";
		}
	}
	
	@RequestMapping("/LoginPage")
	public String userLoginPage()
	{
		return "UserLogin";
	}
	
	@RequestMapping("/userlogin")	
	public String userlogin(@RequestParam("emailid") String emailidormoobilenumber, String password,Model model,HttpServletRequest request)
	{
		UserDetails userDetails = userDetailsDao.readByEmailIdOrMobileNumberAndPassword(emailidormoobilenumber, password);
		if(userDetails!=null)
		{
			System.out.println("user Login");
			
			request.getSession().setAttribute("userid", userDetails.getUserid());
			
			 request.getSession().setAttribute("username", userDetails.getFirstname());
			 
			model.addAttribute("msg",userDetails.getFirstname());
			List<ProductDetails> allProductDetails = productDetailsDao.getAllProductDetails();
			
			model.addAttribute("listofproduct",allProductDetails);
			
			
			request.getSession().setAttribute("allproducts", allProductDetails);
			
			
			return "AllProductDetails";
		}
		else
		{
			model.addAttribute("msg", " invalid userDetails");
			return "UserLogin";
		}
	}
}
