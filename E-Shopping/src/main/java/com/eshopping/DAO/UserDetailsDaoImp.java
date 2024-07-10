package com.eshopping.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eshopping.DTO.UserDetailsDTO;
import com.eshopping.Repository.UserRepository;
import com.eshopping.entity.UserDetails;
@Component
public class UserDetailsDaoImp  implements userDetailsDao
{
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails UserRegistration(UserDetailsDTO userdetailsDto) 
	{
		UserDetails details=new UserDetails();
		details.setFirstname(userdetailsDto.getFirstname());
		details.setLastname(userdetailsDto.getLastname());
		details.setEmailid(userdetailsDto.getEmailid());
		details.setPassword(userdetailsDto.getPassword());
		details.setMobilenumber(userdetailsDto.getMobilenumber());
		details.setGender(userdetailsDto.getGender());
		details.setAdress(userdetailsDto.getAdress());
		details.setPin(userdetailsDto.getPin());
		details.setLandmark(userdetailsDto.getLandmark());
		details.setAge(userdetailsDto.getAge());
		details.setDateofbirth(userdetailsDto.getDateofbirth());
		details.setState(userdetailsDto.getState());
		
		UserDetails userDetails = userRepository.save(details);
		return userDetails;
	}

	@Override
	public List<UserDetails> getallDetails() {
		List<UserDetails> all = userRepository.findAll();
		return all;
		
	}

	@Override
	public UserDetails readByEmailIdOrMobileNumberAndPassword(String emailidormobilenumber, String password) 
	{
		UserDetails byEmailidOrMobilenumberAndPassword = userRepository.readByEmailidOrMobilenumberAndPassword(emailidormobilenumber, password);
		
		return byEmailidOrMobilenumberAndPassword;
	}

}
