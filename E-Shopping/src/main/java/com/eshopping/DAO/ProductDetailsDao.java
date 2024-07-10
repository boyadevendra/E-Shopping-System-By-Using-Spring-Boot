package com.eshopping.DAO;

import java.util.List;

import com.eshopping.DTO.ProductDetailsDTO;
import com.eshopping.entity.ProductDetails;

public interface ProductDetailsDao 
{
	ProductDetails saveProductDetails(ProductDetailsDTO productDetailsDTO);
	List<ProductDetails> getAllProductDetails();
	
	List<ProductDetails> getProductByPrice(double minprice,double maxprice);
	
	 ProductDetails getProductById(Integer id);
}
