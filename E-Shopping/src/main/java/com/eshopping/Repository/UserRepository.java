package com.eshopping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eshopping.entity.UserDetails;
import java.util.List;


public interface UserRepository extends JpaRepository<UserDetails, Integer>
{

	@Query("select users from UserDetails users where (users.emailid=?1 or users.mobilenumber=?1) and users.password=?2")
	UserDetails readByEmailidOrMobilenumberAndPassword(String emailid,String password);
}
