package com.erdincozsertel.bookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erdincozsertel.bookstore.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}