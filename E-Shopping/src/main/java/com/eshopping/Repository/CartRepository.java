package com.eshopping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eshopping.entity.CartDetails;
import java.util.List;


public interface CartRepository extends JpaRepository<CartDetails, Integer>
{
	CartDetails findByProductidAndUserid(Integer productid, Integer userid);
}
