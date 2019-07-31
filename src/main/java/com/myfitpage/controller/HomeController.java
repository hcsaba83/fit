package com.myfitpage.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myfitpage.entity.Food;
import com.myfitpage.repository.FoodRepository;
import com.myfitpage.repository.UserRepository;
import com.myfitpage.service.FoodService;

@Controller
public class HomeController {
	
	private FoodService foodService;
	private FoodRepository foodRepository;
	private UserRepository userRepository;
	
	@Autowired
	private void setFoodService(FoodService foodService) {
		this.foodService = foodService;
	}
	
	@Autowired
	private void setFoodRepository(FoodRepository foodRepository) {
		this.foodRepository = foodRepository;
	}
	
	@Autowired
	private void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@RequestMapping("/")
	public String main(Model model) {
		model.addAttribute("food", foodService.getAll());
		return "main";
	}
	
	@RequestMapping("/action/{id}/{no}")
	public String buttonAction(@PathVariable(value="id") Long id, @PathVariable(value="no") Integer no) {
		foodService.action(id, no);
		return("redirect:/");
	}
	
	@Scheduled(fixedRate = 200000)
	public void createNew() {
		Food food = new Food(new Date(),0,0,0,0,0,0,0,0, userRepository.findOne("jancsi01"));
		foodRepository.save(food);
		System.out.println("Scheduled Task");
	}

}
