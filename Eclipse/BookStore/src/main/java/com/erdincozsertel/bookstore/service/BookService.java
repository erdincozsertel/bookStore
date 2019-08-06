package com.erdincozsertel.bookstore.service;

import java.util.List;
import java.time.LocalDateTime;
import com.erdincozsertel.bookstore.domain.Book;

public interface BookService {

	void save(Book book);

	void update(Book book);

	void delete(Integer bookId);

	Book getBook(Integer bookId);

	List<Book> getBookList();

	LocalDateTime getInsertDate(Integer bookId);

}
