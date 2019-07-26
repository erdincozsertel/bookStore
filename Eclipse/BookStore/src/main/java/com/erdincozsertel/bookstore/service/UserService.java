package com.erdincozsertel.bookstore.service;

import com.erdincozsertel.bookstore.domain.User;
import com.erdincozsertel.bookstore.domain.UserLogin;

public interface UserService {

	User getUserByEmail(String email);

	User saveUser(User user);

	User userRegister(User user);

	UserLogin userLogin(UserLogin user);

}
