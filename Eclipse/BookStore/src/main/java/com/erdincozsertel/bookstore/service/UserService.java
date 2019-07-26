package com.erdincozsertel.bookstore.service;

import com.erdincozsertel.bookstore.domain.User;
import com.erdincozsertel.bookstore.form.UserForm;

public interface UserService {

	User getUserByEmail(String email);

	User saveUser(User user);

	User userRegister(User user);

	UserForm userLogin(UserForm user);

}
