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
import com.erdincozsertel.bookstore.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public String loginSubmit(@Valid @ModelAttribute("userLogin") UserForm userLogin, BindingResult result,
			ModelMap model) {
		if (result.hasErrors()) {
			return "error";
		}
		userLogin = userService.userLogin(userLogin);

		if (userLogin == null) {
			model.addAttribute("userLogin", new UserForm());
			model.addAttribute("user", new User());
			return "login";
		} else {
			return "result";
		}
	}

}
