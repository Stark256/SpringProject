package ua.controller;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.entity.OpenClose;
import ua.service.OpenCloseService;

@Controller
@RequestMapping("/admin/time")
public class AdminOpenCloseController {
	
private final OpenCloseService service;
	
	@Autowired
	public AdminOpenCloseController(OpenCloseService service) {
		this.service=service;
	}
	
	@GetMapping
	public String show(Model model) {
		model.addAttribute("times",service.findAll());
		return "time";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		service.delete(id);
		return "redirect:/admin/time";
	}
	
	@PostMapping
	public String save(@RequestParam int hh,@RequestParam int hv) {
		service.save(new OpenClose(LocalTime.of(hh, hv)));
		return "redirect:/admin/time";
	}
}
