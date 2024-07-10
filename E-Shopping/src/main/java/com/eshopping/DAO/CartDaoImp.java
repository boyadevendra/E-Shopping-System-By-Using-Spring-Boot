package com.eshopping.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eshopping.Repository.CartRepository;
import com.eshopping.entity.CartDetails;

@Component
public class CartDaoImp implements CartDao 
{
	@Autowired
	CartRepository cartRepository;

	@Override
	public CartDetails saveCartDetails(CartDetails cartdetails) 
	{
		CartDetails save = cartRepository.save(cartdetails);
		return save;
	}

	@Override
	public CartDetails findCartDetailsUserIdAndProductId(Integer userid, Integer productid) {
		
		return cartRepository.findByProductidAndUserid(productid, userid);
	}


	

}
