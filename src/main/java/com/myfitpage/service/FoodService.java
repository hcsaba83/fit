package com.myfitpage.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.myfitpage.entity.Food;
import com.myfitpage.entity.User;
import com.myfitpage.repository.FoodRepository;

@Service
public class FoodService {
	
	private FoodRepository foodRepository;
	
	
	public FoodService(FoodRepository foodRepository) {
		super();
		this.foodRepository = foodRepository;
	}

	public List<Food> getAll() {
		return foodRepository.findAll();
	}
	
	public List<Food> getAllByUser(User user) {
		return foodRepository.findAllByUser(user);
	}
	
	public List<Food> getAllByUserByDate(User user, LocalDate date) {
		return foodRepository.findAllByUserByDate(user, date);
	}
	
	public List<Food> getAllByUserDesc(User user) {
		return foodRepository.findAllByUserDesc(user);
	}

	public Food getById(Long id)  {
		return foodRepository.findOne(id);
	}

	public void action(Long id, Integer no) {
		Food dailyfood = getById(id);
		Integer x = no;
		if(dailyfood.getMeal(no) < 5)
			dailyfood.setMeal(dailyfood.getMeal(no)+1, no);
		else
			dailyfood.setMeal(0, no);
		foodRepository.save(dailyfood);
		System.out.println("Action lefutott: "+id+"-"+no);
	}

}
