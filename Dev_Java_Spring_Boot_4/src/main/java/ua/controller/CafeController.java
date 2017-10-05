package ua.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.entity.Meal;
import ua.entity.Table;
import ua.service.CafeService;
import ua.service.MealService;
import ua.service.TableService;

@Controller
@RequestMapping("/cafe")
public class CafeController {

	private final CafeService service;
	
	 private final TableService serviceTable;
	 
	 private final MealService serviceMeal;
	
	@Autowired
	public CafeController(CafeService service,TableService serviceTable,MealService serviceMeal) {
		this.service = service;
		this.serviceTable = serviceTable;
		this.serviceMeal = serviceMeal;
	}
	
	
	
	@GetMapping
	public String show(Model model,Principal principal) {
		model.addAttribute("cafes",service.findAllCafeByUserEmail(principal.getName()));
		
		return "cafe";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		List<Table> tables=serviceTable.findTablesByCafeId(id);
		for (Table table : tables) {
			serviceTable.delete(table.getId());
		}
		List<Meal> meals=serviceMeal.findAllMealsByCafeId(id);
		for (Meal meal : meals) {
			serviceMeal.delete(meal.getId());
		}
		service.delete(id);
		return "redirect:/cafe";
	}
	
	

}
