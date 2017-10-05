package ua.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.entity.Cafe;
import ua.entity.OpenClose;
import ua.service.CafeService;
import ua.service.OpenCloseService;

@Controller
@RequestMapping("/admin/time")
@SessionAttributes("time")
public class AdminOpenCloseController {
	
private final OpenCloseService service;

private final CafeService cafeService;
	
	@Autowired
	public AdminOpenCloseController(OpenCloseService service,CafeService cafeService) {
		this.service=service;
		this.cafeService=cafeService;
	}
	
	@GetMapping
	public String show(Model model) {
		model.addAttribute("times",service.findAll());
		return "time";
	}
	
	@ModelAttribute("time")
	public OpenClose getForm(){
		return new OpenClose();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		List<Cafe> cafes=cafeService.findAllCafeByTimeId(id);
		for (Cafe cafe : cafes) {
			cafeService.delete(cafe.getId());
		}
		service.delete(id);
		return "redirect:/admin/time";
	}
	
	@GetMapping("cancel")
	public String cancel(SessionStatus status){
		status.setComplete();
		return "redirect:/admin/time";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id,Model model){
		model.addAttribute("time",service.findOne(id));
		return show(model);
	}
	
	@PostMapping
	public String save(@ModelAttribute("time") OpenClose openClose,Model model,SessionStatus status) {
		List<OpenClose> times=service.findAll();
		boolean unique=false;
		for (OpenClose openClose2 : times) {
			if(openClose.getTime().equals(openClose2.getTime())){
				unique=true;
			}
		}
		if(unique){
			model.addAttribute("notUnique", true);
			return show(model);
		}
		service.save(openClose);
		return cancel(status);
	}
}
