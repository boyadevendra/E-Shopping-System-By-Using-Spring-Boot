package com.eshopping.DAO;

import java.util.List;

import com.eshopping.DTO.UserDetailsDTO;
import com.eshopping.entity.UserDetails;

public interface userDetailsDao 
{
	UserDetails UserRegistration(UserDetailsDTO userDetailsDao);
	
	List<UserDetails> getallDetails();
	
	UserDetails readByEmailIdOrMobileNumberAndPassword(String emailidormobilenumber,String password);
}
