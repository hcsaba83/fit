package com.myfitpage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.myfitpage.service.FoodService;

@Controller
public class HomeController {
	
	private FoodService foodService;
	
	public HomeController(FoodService foodService) {
		super();
		this.foodService = foodService;
	}

	@RequestMapping("/")
	public String main(Model model) {
		model.addAttribute("food", foodService.getAll());
		System.out.println("MainPage Loaded!");
		return "main";
	}

}
