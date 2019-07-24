package com.erdincozsertel.bookstore.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erdincozsertel.bookstore.domain.User;
import com.erdincozsertel.bookstore.domain.UserLogin;

@Controller
public class IndexContoller {
	private String appMode;

	@Autowired
	public IndexContoller(Environment environment) {
		appMode = environment.getProperty("app-mode");
	}

	@RequestMapping("/")
	public String index(Model model) {
		return "index";
	}

	@RequestMapping("/register")
	public String register(Model model) {
//    	if (Request.valueOf("register_button") != null) {
//			
//		}
		return "register";
	}

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("userLogin", new UserLogin());
		model.addAttribute("user", new User());
		return "login";
	}

}