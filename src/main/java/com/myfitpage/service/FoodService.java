package com.myfitpage.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.myfitpage.entity.Food;
import com.myfitpage.repository.FoodRepository;

@Service
public class FoodService {
	
	private FoodRepository foodrepository;
	
	
	public FoodService(FoodRepository foodrepository) {
		super();
		this.foodrepository = foodrepository;
	}


	public List<Food> getAll() {
		return foodrepository.findAll();
	}

}
