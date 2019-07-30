package com.erdincozsertel.bookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erdincozsertel.bookstore.domain.Message;

public interface MessageRepository extends JpaRepository<Message, Integer>{

}
