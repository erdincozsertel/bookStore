package com.erdincozsertel.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erdincozsertel.bookstore.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>
{

}