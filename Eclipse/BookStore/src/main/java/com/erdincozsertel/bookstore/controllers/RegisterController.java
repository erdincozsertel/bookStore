package com.erdincozsertel.bookstore.controllers;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.Date;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.erdincozsertel.bookstore.domain.User;
import com.erdincozsertel.bookstore.domain.UserLogin;
import com.erdincozsertel.bookstore.domain.User.Gender;

@Controller
public class RegisterController {

	@PostMapping("/register")
	public String registerSubmit(@Valid @ModelAttribute("user") User user, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "error";
		}
		String name = user.getName();
		String surname = user.getSurname();

		String username = user.getUsername();
		String password = user.getPassword();

		String email = user.getEmail();

		Integer accountType;

		if (user.getAccountType() != null) {
			accountType = user.getAccountType();
		} else {
			accountType = 0;
		}

		user.setAccountType(accountType);

		Gender gender = user.getGender();
		Date birthDate = user.getBirthDate();

		if (name != null || surname != null || username != null || password != null || email != null
				|| accountType != null || gender != null || birthDate != null) {
			model.addAttribute("userLogin", new UserLogin());
			model.addAttribute("user", new User());
			return "login";
		} else {
			SecureRandom random = new SecureRandom();
			byte[] salt = new byte[16];
			user.setSalt(salt);
			random.nextBytes(salt);
			try {
				KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
				SecretKeyFactory factory;
				factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
				byte[] hash = factory.generateSecret(spec).getEncoded();
				password = hash.toString();
			} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (user.getPassword() == password || user.getSalt() == salt) {
				model.addAttribute("userLogin", new UserLogin());
				model.addAttribute("user", new User());
				return "login";				
			} else {
				user.setPassword(password);
				user.setSalt(salt);
				//TODO:Insert to database
			}

		}

		return "result";
	}
//		else {
//			boolean insertSuccess = false;
//			User user = new User(username, password, gender, birthDate);
//
//			UserDao userDao = new UserDaoImpl();
//			insertSuccess = userDao.save(user);
//
//			if (insertSuccess) {
//				response.sendRedirect("/bookDatabase");
//			} else {
//				RequestDispatcher req = request.getRequestDispatcher("/WEB-INF/register.html");
//				req.include(request, response);
//			}
//		}
//	}
}
