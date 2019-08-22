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
public class PublisherContoller {
	private String appMode;

	@Autowired
	public PublisherContoller(Environment environment) {
		appMode = environment.getProperty("app-mode");
	}

	@Autowired
	private PublisherService publisherService;

	@ModelAttribute("publisher")
	private Publisher publisher() {
		return new Publisher();
	}

	@ModelAttribute("publisherList")
	private List<Publisher> publisherList() {
		return publisherService.getPublisherList();
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

	@RequestMapping("/deletePublisher")
	public String deletePublisher(@RequestParam String publisherId, Model model) {
		if (publisherService.getPublisher(Integer.valueOf(publisherId)).getBooks().isEmpty()) {
			publisherService.delete(Integer.valueOf(publisherId));
			return "redirect:/showPublisher";
		} else {
			return "redirect:/showPublisher";
		}
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

}