package com.erdincozsertel.bookstore.controllers;

import java.security.SecureRandom;

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

import com.erdincozsertel.bookstore.dao.MessageRepository;
import com.erdincozsertel.bookstore.domain.User;
import com.erdincozsertel.bookstore.form.PassTest;
import com.erdincozsertel.bookstore.form.UserForm;
import com.erdincozsertel.bookstore.util.EncodingPasswordUtil;

@Controller
public class IndexContoller {
	private String appMode;
	
	@Autowired
    private MessageRepository messageRepository;

	@Autowired
	public IndexContoller(Environment environment) {
		appMode = environment.getProperty("app-mode");
	}

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("msgs", messageRepository.findAll());
		return "index";
	}

	@RequestMapping("/userregister")
	public String register(Model model) {
    	model.addAttribute("userLogin", new UserForm());
		model.addAttribute("user", new User());
		return "login";
	}

	@GetMapping("/userlogin")
	public String login(Model model) {
		model.addAttribute("userLogin", new UserForm());
		model.addAttribute("user", new User());
		return "login";
	}
	
	@GetMapping("/passWordTest1")
	public String passTest(Model model) {
		model.addAttribute("passT", new PassTest());
		return "pTest";
	}
	
	@PostMapping("/passWordTest2")
	public String passTestMap(@Valid @ModelAttribute("passT") PassTest passT, BindingResult result,
			ModelMap model) {
		String passOriginal= passT.getPassword();
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
//		password = EncodingPasswordUtil.hashPassword(password, salt);
		String passHash1 = EncodingPasswordUtil.hashPassword(passOriginal, salt);
		String passHash2 = EncodingPasswordUtil.hashPassword(passOriginal, salt);
		String passHash3 = EncodingPasswordUtil.hashPassword(passOriginal, salt);
		
		System.out.println("passHash1 = "+passHash1+" passHash2 = "+passHash2+" passHash3 = "+passHash3+" ");

		return "pTest";
		
	}
	

}