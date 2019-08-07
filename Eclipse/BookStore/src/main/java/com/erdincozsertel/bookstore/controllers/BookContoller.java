package com.erdincozsertel.bookstore.controllers;

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
	private MessageRepository messageRepository;

	@Autowired
	private WriterService writerService;

	@Autowired
	private PublisherService publisherService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private BookService bookService;

	@Autowired
	public BookContoller(Environment environment) {
		appMode = environment.getProperty("app-mode");
	}

	@ModelAttribute("book")
	private Book book() {
		return new Book();
	}

	@ModelAttribute("bookList")
	private List<Book> bookList() {
		return bookService.getBookList();
	}

	@ModelAttribute("category")
	private Category category() {
		return new Category();
	}

	@ModelAttribute("categoryList")
	private List<Category> categoryList() {
		return categoryService.getCategoryList();
	}

	@ModelAttribute("publisher")
	private Publisher publisher() {
		return new Publisher();
	}

	@ModelAttribute("publisherList")
	private List<Publisher> publisherList() {
		return publisherService.getPublisherList();
	}

	@ModelAttribute("writer")
	private Writer writer() {
		return new Writer();
	}

	@ModelAttribute("writerList")
	public List<Writer> writerList() {
		return writerService.getWriterList();
	}

	@RequestMapping("/addBook")
	public String addBook(Model model) {
//		model.addAttribute("userLogin", new UserForm());
//		model.addAttribute("user", new User());
		return "bookRegister";
	}

	@RequestMapping("/showWriter")
	public String showWriter() {
		return "showWriter";
	}

	@RequestMapping("/addWriter")
	public String addWriter(@Valid @ModelAttribute("writer") Writer writer, BindingResult result, ModelMap model) {
		Writer existing = writerService.getWriterByName(writer.getWriterName());
		if (existing != null) {
			result.rejectValue("writer", null, "There is already a writer with that name");
		}
		if (result.hasErrors()) {
			return "error";
		}
		writer = writerService.save(writer);
		if (writer == null) {
			return "redirect:/showWriter";
		} else {
			return "redirect:/addBook";
		}

	}

	@RequestMapping("/showPublisher")
	public String showPublisher() {
		return "showPublisher";
	}

	@RequestMapping("/addPublisher")
	public String addPublisher(@Valid @ModelAttribute("publisher") Publisher publisher, BindingResult result,
			ModelMap model) {
		Publisher existing = publisherService.getPublisherByName(publisher.getPublisherName());
		if (existing != null) {
			result.rejectValue("publisher", null, "There is already a publisher with that name");
		}
		if (result.hasErrors()) {
			return "error";
		}
		publisher = publisherService.save(publisher);
		if (publisher == null) {
			return "redirect:/showPublisher";
		} else {
			return "redirect:/addBook";
		}

	}

	@RequestMapping("/showCategory")
	public String showCategory() {
		return "showCategory";
	}

	@RequestMapping("/addCategory")
	public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult result,
			ModelMap model) {
		Category existing = categoryService.getCategoryByName(category.getCategoryName());
		if (existing != null) {
			result.rejectValue("category", null, "There is already a category with that name");
		}
		if (result.hasErrors()) {
			return "error";
		}
		category = categoryService.save(category);
		if (category == null) {
			return "redirect:/showCategory";
		} else {
			return "redirect:/addBook";
		}

	}

}