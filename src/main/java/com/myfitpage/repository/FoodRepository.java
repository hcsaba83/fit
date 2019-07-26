package com.myfitpage.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.myfitpage.entity.Food;


@Repository
public interface FoodRepository extends CrudRepository<Food, Long> {

	List<Food> findAll();
	
}
