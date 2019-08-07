package com.erdincozsertel.bookstore.service.book;

import java.util.List;
import java.time.LocalDateTime;
import com.erdincozsertel.bookstore.domain.Book;

public interface BookService {

	Book save(Book book);

	void update(Book book);

	void delete(Integer bookId);

	Book getBook(Integer bookId);
	
	Book getBookByName(String bookName);

	List<Book> getBookList();

	LocalDateTime getInsertDate(Integer bookId);

}
