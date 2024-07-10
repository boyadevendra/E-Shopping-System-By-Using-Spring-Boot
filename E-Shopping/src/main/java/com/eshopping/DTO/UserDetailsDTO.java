package com.eshopping.DTO;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsDTO 
{
	
     private String firstname;
	
	private String lastname;
	
	private String emailid;
	
	private String password;
	
	private long mobilenumber;
	
	private String adress;
	
	private String gender;
	
	private LocalDate dateofbirth;
	
	private  int age;
	
	private int pin;
	
	private String landmark;
	
	private String state;
}
