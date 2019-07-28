package com.myfitpage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
		return "main";
	}
	
	@RequestMapping("/action/{id}/{no}")
	public String buttonAction(@PathVariable(value="id") Long id, @PathVariable(value="no") Integer no) {
		foodService.action(id, no);
		return("redirect:/");
	}
	

}
