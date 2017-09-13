package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.service.CafeIndexService;

@Controller
@RequestMapping("/admin/cafeindex")
@SessionAttributes("cafeindex")
public class AdminCafeTopFiveController {

	private final CafeIndexService service;
	
	@Autowired
	public AdminCafeTopFiveController(CafeIndexService service) {
		this.service = service;
	}
	

	@GetMapping
	public String show(Model model) {
		model.addAttribute("cafes", service.findTopFiveCafe());
		return "cafeindex";
	}


	
}
