package com.eshopping.DAO;

import com.eshopping.entity.CartDetails;

public interface CartDao 
{
	CartDetails saveCartDetails(CartDetails cartdetails);
	
	CartDetails findCartDetailsUserIdAndProductId(Integer userid,Integer productid);
}
