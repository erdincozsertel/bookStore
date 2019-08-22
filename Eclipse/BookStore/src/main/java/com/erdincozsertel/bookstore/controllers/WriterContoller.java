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
import com.erdincozsertel.bookstore.domain.Writer;
import com.erdincozsertel.bookstore.service.book.BookService;
import com.erdincozsertel.bookstore.service.category.CategoryService;
import com.erdincozsertel.bookstore.service.writer.WriterService;

@Controller
public class WriterContoller {
	private String appMode;

	@Autowired
	public WriterContoller(Environment environment) {
		appMode = environment.getProperty("app-mode");
	}

	@Autowired
	private MessageRepository messageRepository;

	@Autowired
	private WriterService writerService;

	@Autowired
	private CategoryService categoryService;

	@ModelAttribute("writer")
	private Writer writer() {
		return new Writer();
	}

	@ModelAttribute("writerList")
	public List<Writer> writerList() {
		return writerService.getWriterList();
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

	@RequestMapping("/deleteWriter")
	public String deleteWriter(@RequestParam String writerId, Model model) {
		if (writerService.getWriter(Integer.valueOf(writerId)).getBooks().isEmpty()) {
			writerService.delete(Integer.valueOf(writerId));
			return "redirect:/showWriter";
		} else {
			return "redirect:/showWriter";

		}
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
}