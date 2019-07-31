package com.myfitpage.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.myfitpage.entity.User;

public interface UserRepository extends CrudRepository<User, String> {
	
	@Query(value="SELECT u FROM User u where username = :name")
	User findOne(@Param("name") String name);
	
	User findByUsername(String username);

}
