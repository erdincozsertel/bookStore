package com.erdincozsertel.bookstore.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.erdincozsertel.bookstore.domain.UserLogin;

@Controller
public class LoginController {

	@PostMapping("/login")
	public String loginSubmit(@Valid @ModelAttribute("userLogin") UserLogin userLogin, BindingResult result,
			ModelMap model) {
		if (result.hasErrors()) {
			return "error";
		}
		String username = userLogin.getUsername();
		String password = userLogin.getPassword();
		
		return "result";
	}
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		response.setContentType("text/html");
//		User user;
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		// TODO: password hashing
//
//		if (username.isEmpty() || password.isEmpty()) {
//			RequestDispatcher req = request.getRequestDispatcher("/WEB-INF/login.html");
//			req.forward(request, response);
//		} else {
//			user = new User(username, password);
//			boolean loginStatus;
//			UserDao userDao = new UserDaoImpl();
//			loginStatus = userDao.isUser(user);
//
//			if (loginStatus) {
//				// TODO Session start
//				response.sendRedirect("/bookDatabase");
//			} else {
//				RequestDispatcher req = request.getRequestDispatcher("/WEB-INF/login.html");
//				req.forward(request, response);
//			}
//		}
//	}

}
