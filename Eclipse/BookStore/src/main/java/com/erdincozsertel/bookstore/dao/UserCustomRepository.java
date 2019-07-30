package com.erdincozsertel.bookstore.dao;

import com.erdincozsertel.bookstore.domain.User;

public interface UserCustomRepository {

	User findUserByEmail(String email);
	
	User findUserByUsername(String username);
}
