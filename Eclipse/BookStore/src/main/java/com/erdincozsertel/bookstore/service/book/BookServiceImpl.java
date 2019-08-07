package com.erdincozsertel.bookstore.service.book;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erdincozsertel.bookstore.dao.book.BookCustomRepository;
import com.erdincozsertel.bookstore.dao.book.BookRepository;
import com.erdincozsertel.bookstore.domain.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookDao;

	@Autowired
	private BookCustomRepository bookRepo;

	@Override
	public Book save(Book book) {
		return bookDao.save(book);
	}

	@Override
	public void update(Book book) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(Integer bookId) {
		bookDao.deleteById(bookId);

	}

	@Override
	public Book getBook(Integer bookId) {
		return bookDao.getOne(bookId);
	}

	@Override
	public List<Book> getBookList() {
		return bookDao.findAll();
	}

	@Override
	public LocalDateTime getInsertDate(Integer bookId) {
		return getBook(bookId).getInsertDate();
	}

	@Override
	public Book getBookByName(String bookName) {
//		return categoryRepo.findCategoryByName(categoryName);
		return bookRepo.findBookByName(bookName);
	}

}
