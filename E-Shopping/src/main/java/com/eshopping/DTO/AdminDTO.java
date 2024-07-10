package com.eshopping.DTO;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDTO 
{
	private String adminname;
	private String emailid;
	private String password;
	private String role;
}
