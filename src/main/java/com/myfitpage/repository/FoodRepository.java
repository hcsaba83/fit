package com.myfitpage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.myfitpage.entity.Food;
import com.myfitpage.entity.User;


@Repository
public interface FoodRepository extends CrudRepository<Food, Long> {

	List<Food> findAll();
	
	@Query(value="SELECT f FROM Food f where id = :id")
	Food findOne(@Param("id") Long id);
	

	List<Food> findAllByUser(User user);

	
}
