package ua.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.model.filter.CafeFilter;
import ua.repository.CafeViewRepository;
import ua.service.CafeService;
import ua.service.MealService;

@Controller
@RequestMapping("/yura")
public class SeeAllController {
	
	private final CafeViewRepository repository;

//private final CafeService cafeService;

private final MealService mealService;
	
	@Autowired
	public SeeAllController(CafeViewRepository repository,MealService mealService) {
		this.repository = repository;
		this.mealService = mealService;
	}
	
	@ModelAttribute("cafeFilter")
	public CafeFilter getFilter(){
		return new CafeFilter();
	}
	
	@GetMapping("/allcafe")
	public String showAllCafe(Model model , @ModelAttribute("cafeFilter") CafeFilter filter, @PageableDefault Pageable pageable){
		model.addAttribute("cafes",repository.findAll(filter, pageable));
		return "allcafe";
	}
	
	@GetMapping("/allmeal")
	public String showAllMeal(Model model) {
		model.addAttribute("meals", mealService.findAllView());
		model.addAttribute("ingredients", mealService.findAllIngredients());
		return "allmeal";
	}
}
