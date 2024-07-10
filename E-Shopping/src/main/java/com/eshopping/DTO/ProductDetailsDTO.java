package com.eshopping.DTO;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailsDTO 
{
	private String productname;
	private double price;
	private int quantity;
	private String productbrand;
	private int discount;
	private String productcategory;
	private String gendercategory;
	private String color;

}
