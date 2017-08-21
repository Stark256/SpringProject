package ua.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.entity.User;
import ua.service.UserService;

@Controller
@RequestMapping("/admin/user")
public class AdminUserController {
	
private final UserService service;

@Autowired
public AdminUserController(UserService service) {
	this.service=service;
}

@GetMapping
public String show(Model model) {
	model.addAttribute("users",service.findAll());
	return "user";
}

@GetMapping("/delete/{id}")
public String delete(@PathVariable Integer id) {
	service.delete(id);
	return "redirect:/admin/user";
}

@PostMapping
public String save(@RequestParam String firstName,@RequestParam String lastName,@RequestParam String email
		,@RequestParam String login,@RequestParam String password,@RequestParam int date,
		@RequestParam int month,@RequestParam int year) {
	service.save(new User(firstName,lastName,email,login,password,LocalDate.of(year,month,date)));
	return "redirect:/admin/user";
}


}
