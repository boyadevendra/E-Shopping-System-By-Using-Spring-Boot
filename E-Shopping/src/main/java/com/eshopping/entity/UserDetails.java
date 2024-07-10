package com.eshopping.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userid;
	
	@Column(name="First_Name",nullable = false,length = 50)
	private String firstname;
	
	@Column(name="Last_Name",nullable = false,length = 50)
	private String lastname;
	
	@Column(name="Email_id",unique = true, nullable = false,length = 50)
	private String emailid;
	
	@Column(name="Password",unique = true, nullable = false,length = 6)
	private String password;
	
	@Column(name="Mobile_Numbder",unique = true, nullable = false,length = 10)
	private long mobilenumber;
	
	@Column(name="Adress",nullable = false,length =50)
	private String adress;
	
	@Column(name="Gender",nullable = false)
	private String gender;
	
	@Column(name="Date_Of_Birth")
	private LocalDate dateofbirth;
	
	@Column(name="Age",length = 3)
	private  int age;
	
	@Column(name="PinCode",nullable = false)
	private int pin;
	
	@Column(name="Landmark",nullable = false)
	private String landmark;
	
	@Column(name="State", nullable = false)
	private String state;
	
}
