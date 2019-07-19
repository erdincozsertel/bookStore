package com.erdincozsertel.bookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

@Controller
public class IndexContoller {
    private String appMode;

    @Autowired
    public IndexContoller(Environment environment){
        appMode = environment.getProperty("app-mode");
    }

    @RequestMapping("/register")
    public String register(Model model){
    	if (Request.valueOf("register_button") != null) {
			
		}
        return "register";
    }
    
    @RequestMapping("/login")
    public String login(Model model) {
    	return "login";
    }
    
}