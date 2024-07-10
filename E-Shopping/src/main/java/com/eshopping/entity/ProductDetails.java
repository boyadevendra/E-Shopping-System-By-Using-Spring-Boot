package com.eshopping.entity;

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
public class ProductDetails 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productid;
	
	@Column(name="Product_Name",nullable = false,length = 50)
	private String productname;
	
	@Column(name="Price",nullable = false,length = 50)
	private double price;
	
	@Column(name="Quantity")
	private int quantity;
	
	@Column(name="Product_Brand",unique = true)
	private String productbrand;
	
	@Column(name="Discount")
	private int discount;
	
	@Column(name="Product_Category")
	private String productcategory;
	
	@Column(name="Gender_Category")
	private String gendercategory;
	
	@Column(name="Color  ")
	private String color;

}
