package com.eshopping.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eshopping.entity.ProductDetails;


public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Integer>
{
	List<ProductDetails> findByPriceBetween(double minprice,double maxprice);
}
