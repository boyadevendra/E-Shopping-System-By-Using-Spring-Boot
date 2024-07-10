package com.eshopping.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDetails 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cartid;
	private Integer productid;
	private Integer userid;
	private String productname;
	private double price;
}
