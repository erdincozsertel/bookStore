package com.erdincozsertel.bookstore.controllers;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.erdincozsertel.bookstore.dao.MessageRepository;
import com.erdincozsertel.bookstore.domain.Book;
import com.erdincozsertel.bookstore.domain.Category;
import com.erdincozsertel.bookstore.domain.Publisher;
import com.erdincozsertel.bookstore.domain.Writer;
import com.erdincozsertel.bookstore.service.book.BookService;
import com.erdincozsertel.bookstore.service.category.CategoryService;
import com.erdincozsertel.bookstore.service.publisher.PublisherService;
import com.erdincozsertel.bookstore.service.writer.WriterService;

@Controller
public class BookContoller {
	private String appMode;

	@Autowired
	public BookContoller(Environment environment) {
		appMode = environment.getProperty("app-mode");
	}

	@Autowired
	private MessageRepository messageRepository;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private PublisherService publisherService;

	@Autowired
	private WriterService writerService;

	@Autowired
	private BookService bookService;

	@ModelAttribute("book")
	private Book book() {
		return new Book();
	}

	@ModelAttribute("bookList")
	private List<Book> bookList() {
		return bookService.getBookList();
	}

	@ModelAttribute("categoryList")
	private List<Category> categoryList() {
		return categoryService.getCategoryList();
	}

	@ModelAttribute("publisherList")
	private List<Publisher> publisherList() {
		return publisherService.getPublisherList();
	}

	@ModelAttribute("writerList")
	public List<Writer> writerList() {
		return writerService.getWriterList();
	}

	@RequestMapping("/addBook")
	public String addBook(Model model) {
		return "bookRegister";
	}

//	@RequestMapping("/bookRegister")
//	public String bookRegister(@ModelAttribute("book") Book book, BindingResult result, ModelMap model) {
//		String description = book.getBookDescription();
//		if (description == null) {
//			description = "";
//		} else if (description.length() > 250) {
//			description.substring(0, 250);
//			description.concat(" ...");
//		}
//		if (book.getBookName() != null && book.getBookWriter() != null && book.getBookPublisher() != null
//				&& !(book.getBookPrice().equals(null)) && book.getBookPrice().compareTo(BigDecimal.ZERO) > 0
//				&& book.getBookCategory() != null) {
//			Book existing = bookService.getBookByName(book.getBookName());
//			if (existing != null) {
//				result.rejectValue("bookName", null, "There is already a book registered with that name");
//			}
//			if (result.hasErrors()) {
//				return "error";
//			}
//			LocalDateTime localDate = LocalDateTime.now();
//			book.setInsertDate(localDate);
//			book = bookService.save(book);
//			if (book == null) {
//				return "redirect:/addBook";
//			} else {
//				return "redirect:";
//			}
//		} else {
//			return "redirect:/addBook";
//		}
//	}

//	@RequestMapping("/deleteBook")
//	public String deleteBook(@RequestParam String bookId, Model model) {
//		bookService.delete(Integer.valueOf(bookId));
//		return "redirect:/";
//	}
//
//	@RequestMapping("/editBook")
//	public String editBook(@RequestParam String bookId, Model model) {
//		model.addAttribute("thisBook", bookService.getBook(Integer.valueOf(bookId)));
//		return "bookEdit";
//	}

//	@RequestMapping("/editBookPage")
//	public String editBookPage(@Valid @ModelAttribute("book") Book book, BindingResult result, ModelMap model) {
//		if (book.getBookId() != null && book.getBookName() != null && book.getBookPrice() != null) {
//			book = bookService.save(book);
//			if (book == null) {
//				return "redirect:/";
//			} else {
//				return "redirect:/";
//			}
//		} else {
//			return "redirect:/";
//		}
//	}
	
//	@RequestMapping("/bookTable")
//	public String adminBookTable(Model model) {
//		return "adminBookTable";
//	}
	
	@RequestMapping("/allBooksList")
	public String allBooksList(Model model) {
		model.addAttribute("searchedBooks", bookService.getBookList());
		return "bookResult";
	}
}