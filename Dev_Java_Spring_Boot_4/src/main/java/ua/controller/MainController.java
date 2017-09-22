package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ua.entity.User;
import ua.service.CafeIndexService;

@Controller
public class MainController {

private final CafeIndexService service;
	
	@Autowired
	public MainController(CafeIndexService service) {
		this.service = service;
	}
	
	@GetMapping("/")
	public String index(Model model, User user) {
		if(user!=null) {
			model.addAttribute("message", "Hello "+user.getEmail());
			System.out.println(user.getRole());
			System.out.println(user.getPassword());
		} else {
			model.addAttribute("message", "Hello unregistered user");
		}
		model.addAttribute("cafes", service.findTopFiveCafe());
		return "index";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
}
