package ua.controller;

import java.security.Principal;


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

import ua.model.request.CafeRequest;
import ua.service.CafeService;

@Controller
@RequestMapping("/addcafe")
@SessionAttributes("addcafe")
public class AddCafeController {

	
	private final CafeService service;
	
	@Autowired
	public AddCafeController(CafeService service) {
		this.service = service;
	}
	
	@ModelAttribute("addcafe")
	public CafeRequest getForm() {
		return new CafeRequest();
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return "redirect:/cafe";
	}
	
	@PostMapping
	public String save(@ModelAttribute("addcafe")  CafeRequest request,Model model, SessionStatus status,Principal principal) {
		if(request.getName().isEmpty()||request.getAddress().isEmpty()||request.getFullDescription().isEmpty()||
				request.getShortDescription().isEmpty()||request.getPhone().isEmpty()){
			if(request.getName().isEmpty()) model.addAttribute("emptyName",true);
			if(request.getAddress().isEmpty())model.addAttribute("emptyAddress",true);
			if(request.getFullDescription().isEmpty())model.addAttribute("emptyFD",true);
			if(request.getShortDescription().isEmpty())model.addAttribute("emptySD",true);
			if(request.getPhone().isEmpty())model.addAttribute("emptyPhone",true);
			return showForm(model);
		}
		service.save(request,principal);
		return cancel(status);
	}
	
	@GetMapping
	public String showForm(Model model) {
		model.addAttribute("times", service.findAllOpenCloses());
		model.addAttribute("types",service.findAllTypes());
		return "addcafe";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model) {
		model.addAttribute("addcafe", service.findOne(id));
		return showForm(model);
	}
	
}
