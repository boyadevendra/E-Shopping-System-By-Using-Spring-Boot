package com.eshopping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eshopping.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>
{
	
}
