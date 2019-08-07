package com.erdincozsertel.bookstore.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.erdincozsertel.bookstore.domain.User;
import com.erdincozsertel.bookstore.form.UserForm;
import com.erdincozsertel.bookstore.service.user.UserService;

@Controller
public class RegisterController {

	@Autowired
	private UserService userService;


	@PostMapping("/register")
	public String registerSubmit(@Valid @ModelAttribute("user") User user, BindingResult result, ModelMap model) {
		User existing = userService.getUserByEmail(user.getEmail());
		if (existing != null) {
			result.rejectValue("email", null, "There is already an account registered with that email");
		}
		if (result.hasErrors()) {
			return "error";
		}		
		user = userService.userRegister(user);
		if (user == null) {
			model.addAttribute("userLogin", new UserForm());
			model.addAttribute("user", new User());
			return "login";
		} else {
			return "redirect:";
		}		
	}
}
