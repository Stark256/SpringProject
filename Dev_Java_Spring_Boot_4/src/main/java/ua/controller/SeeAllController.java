package ua.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.service.CafeService;
import ua.service.MealService;

@Controller
@RequestMapping("/yura")
public class SeeAllController {

private final CafeService cafeService;

private final MealService mealService;
	
	@Autowired
	public SeeAllController(CafeService cafeService,MealService mealService) {
		this.cafeService = cafeService;
		this.mealService = mealService;
	}
	
	@GetMapping("/allcafe")
	public String showAllCafe(Model model ){
		model.addAttribute("cafes",cafeService.findAllViews());
		return "allcafe";
	}
	
	@GetMapping("/allmeal")
	public String showAllMeal(Model model) {
		model.addAttribute("meals", mealService.findAllView());
		model.addAttribute("ingredients", mealService.findAllIngredients());
		return "allmeal";
	}
}
