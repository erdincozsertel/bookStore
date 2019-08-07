package com.erdincozsertel.bookstore.dao.book;

import com.erdincozsertel.bookstore.domain.Book;

public interface BookCustomRepository {
	
	Book findBookByName (String bookName);

}
