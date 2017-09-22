package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.service.CafeService;

@Controller
@RequestMapping("/")
@SessionAttributes("cafedesc")
public class AdminCafeDescController {

private final CafeService service;
	
	@Autowired
	public AdminCafeDescController(CafeService service) {
		this.service = service;
	}
	
	@GetMapping("/cafedesc/{id}")
	public String desc(@PathVariable Integer id, Model model){
		model.addAttribute("cafe", service.findOne(id));
		return "cafedesc";
	}
	
	
	
}
