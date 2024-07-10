package com.eshopping.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eshopping.DTO.ProductDetailsDTO;
import com.eshopping.Repository.ProductDetailsRepository;
import com.eshopping.entity.ProductDetails;
@Repository
public class ProductDetailsDaoImp implements ProductDetailsDao
{
	@Autowired
	ProductDetailsRepository productDetailsRepository;

	@Override
	public ProductDetails  saveProductDetails(ProductDetailsDTO productDetailsDTO) 
	{
		ProductDetails product=new ProductDetails();
		
		product.setProductname(productDetailsDTO.getProductname());
		product.setPrice(productDetailsDTO.getPrice());
		product.setQuantity(productDetailsDTO.getQuantity());
		product.setProductbrand(productDetailsDTO.getProductbrand());
		product.setDiscount(productDetailsDTO.getDiscount());
		product.setProductcategory(productDetailsDTO.getProductcategory());
		product.setGendercategory(productDetailsDTO.getGendercategory());
		product.setColor(productDetailsDTO.getColor());
		
		ProductDetails productDetails = productDetailsRepository.save(product);
		return productDetails;
	}

	@Override
	public List<ProductDetails> getAllProductDetails() 
	{
		List<ProductDetails> list = productDetailsRepository.findAll();
		
		return list;
	}

	@Override
	public List<ProductDetails> getProductByPrice(double minprice, double maxprice) 
	{
		List<ProductDetails> byPriceBetween = productDetailsRepository.findByPriceBetween(minprice, maxprice);
		return byPriceBetween;
	}

	@Override
	public ProductDetails getProductById(Integer id) 
	{
		ProductDetails byProductid = productDetailsRepository.findById(id).orElse(new ProductDetails());
		return byProductid;
	}

}
