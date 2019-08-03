package com.myfitpage.controller;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myfitpage.entity.Food;
import com.myfitpage.entity.User;
import com.myfitpage.repository.FoodRepository;
import com.myfitpage.repository.UserRepository;
import com.myfitpage.service.FoodService;
import com.myfitpage.service.UserService;

@Controller
public class HomeController {
	
	private FoodService foodService;
	private UserService userService;
	private FoodRepository foodRepository;
	private UserRepository userRepository;
	
	@Autowired
	private void setUserService(UserService userService) {
		this.userService = userService;
	}
	
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
		model.addAttribute("food", foodService.getAllByUser(userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName())));
		return "main";
	}
	
	@RequestMapping("/action/{id}/{no}")
	public String buttonAction(@PathVariable(value="id") Long id, @PathVariable(value="no") Integer no) {
		foodService.action(id, no);
		return("redirect:/");
	}
	
	//@Scheduled(fixedRate = 5000)
	@Scheduled(cron = "0 1 0 * * *")
		public void createNew() {
		for (final User user : userRepository.findAll()) {
			if (foodService.getAllByUserByDate(user, LocalDate.now()).isEmpty()) {
				Food food = new Food(LocalDate.now(),0,0,0,0,0,0,0,0, userRepository.findOne(user.getUsername()));
				foodRepository.save(food);
				System.out.println("Scheduled Task: Új nap hozzáadva. -> " + user.getUsername());
			}
		}
	}
	
}
