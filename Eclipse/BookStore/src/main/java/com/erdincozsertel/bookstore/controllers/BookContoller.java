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

	@RequestMapping("/bookRegister")
	public String bookRegister(@ModelAttribute("book") Book book, BindingResult result, ModelMap model) {
		String description = book.getBookDescription();
		if (description == null) {
			description = "";
		} else if (description.length() > 250) {
			description.substring(0, 250);
			description.concat(" ...");
		}
		if (book.getBookName() != null && book.getBookWriter() != null && book.getBookPublisher() != null
				&& !(book.getBookPrice().equals(null)) && book.getBookPrice().compareTo(BigDecimal.ZERO) > 0
				&& book.getBookCategory() != null) {
			Book existing = bookService.getBookByName(book.getBookName());
			if (existing != null) {
				result.rejectValue("bookName", null, "There is already a book registered with that name");
			}
			if (result.hasErrors()) {
				return "error";
			}
			LocalDateTime localDate = LocalDateTime.now();
			book.setInsertDate(localDate);
			book = bookService.save(book);
			if (book == null) {
				return "redirect:/addBook";
			} else {
				return "redirect:";
			}
		} else {
			return "redirect:/addBook";
		}
	}

	@RequestMapping("/showWriter")
	public String showWriter() {
		return "showWriter";
	}

	@RequestMapping("/addWriter")
	public String addWriter(@Valid @ModelAttribute("writer") Writer writer, BindingResult result, ModelMap model) {
		if (writer.getWriterName() != null && writer.getBirthDate() != null) {
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
		if (publisher.getPublisherName() != null) {
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
		} else {
			return "redirect:/addBook";
		}
	}

	@RequestMapping("/deleteWriter")
	public String deleteWriter(@RequestParam String writerId, Model model) {
		writerService.delete(Integer.valueOf(writerId));
		return "redirect:/showWriter";
	}

	@RequestMapping("/editWriter")
	public String editWriter(@RequestParam String writerId, Model model) {
		model.addAttribute("thisWriter", writerService.getWriter(Integer.valueOf(writerId)));
		return "writerEdit";
	}

	@RequestMapping("/editWriterPage")
	public String editWriterPage(@Valid @ModelAttribute("writer") Writer writer, BindingResult result, ModelMap model) {
		if (writer.getWriterId() != null && writer.getWriterName() != null && writer.getBirthDate() != null) {
			writer = writerService.save(writer);
			if (writer == null) {
				return "redirect:/showWriter";
			} else {
				return "redirect:/addBook";
			}
		} else {
			return "redirect:/showWriter";
		}
	}

	@RequestMapping("/deletePublisher")
	public String deletePublisher(@RequestParam String publisherId, Model model) {
		publisherService.delete(Integer.valueOf(publisherId));
		return "redirect:/showPublisher";
	}

	@RequestMapping("/editPublisher")
	public String editPublisher(@RequestParam String publisherId, Model model) {
		model.addAttribute("thisPublisher", publisherService.getPublisher(Integer.valueOf(publisherId)));
		return "publisherEdit";
	}

	@RequestMapping("/editPublisherPage")
	public String editPublisherPage(@Valid @ModelAttribute("publisher") Publisher publisher, BindingResult result,
			ModelMap model) {
		if (publisher.getPublisherId() != null && publisher.getPublisherName() != null) {
			publisher = publisherService.save(publisher);
			if (publisher == null) {
				return "redirect:/showPublisher";
			} else {
				return "redirect:/addBook";
			}
		} else {
			return "redirect:/showPublisher";
		}
	}

	@RequestMapping("/deleteBook")
	public String deleteBook(@RequestParam String bookId, Model model) {
		bookService.delete(Integer.valueOf(bookId));
		return "redirect:/";
	}

	@RequestMapping("/editBook")
	public String editBook(@RequestParam String bookId, Model model) {
		model.addAttribute("thisBook", bookService.getBook(Integer.valueOf(bookId)));
		return "bookEdit";
	}

	@RequestMapping("/editBookPage")
	public String editBookPage(@Valid @ModelAttribute("book") Book book, BindingResult result, ModelMap model) {
		if (book.getBookId() != null && book.getBookName() != null && book.getBookPrice() != null) {
			book = bookService.save(book);
			if (book == null) {
				return "redirect:/";
			} else {
				return "redirect:/";
			}
		} else {
			return "redirect:/";
		}
	}

}