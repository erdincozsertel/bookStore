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
public class CategoryContoller {
	private String appMode;

	@Autowired
	public CategoryContoller(Environment environment) {
		appMode = environment.getProperty("app-mode");
	}

	@Autowired
	private MessageRepository messageRepository;

	@Autowired
	private CategoryService categoryService;

	@ModelAttribute("category")
	private Category category() {
		return new Category();
	}

	@ModelAttribute("categoryList")
	private List<Category> categoryList() {
		return categoryService.getCategoryList();
	}

	@RequestMapping("/showCategory")
	public String showCategory() {
		return "showCategory";
	}

	@RequestMapping("/addCategory")
	public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult result,
			ModelMap model) {
		if (category.getCategoryName() != null) {
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
		} else {
			return "redirect:/addBook";
		}
	}

	@RequestMapping("/deleteCategory")
	public String deleteCategory(@RequestParam String categoryId, Model model) {
		categoryService.delete(Integer.valueOf(categoryId));
		return "redirect:/showCategory";
	}

	@RequestMapping("/editCategory")
	public String editCategory(@RequestParam String categoryId, Model model) {
		model.addAttribute("thisCategory", categoryService.getCategory(Integer.valueOf(categoryId)));
		return "categoryEdit";
	}

	@RequestMapping("/editCategoryPage")
	public String editCategoryPage(@Valid @ModelAttribute("category") Category category, BindingResult result,
			ModelMap model) {
		if (category.getCategoryId() != null && category.getCategoryName() != null) {
			category = categoryService.save(category);
			if (category == null) {
				return "redirect:/showCategory";
			} else {
				return "redirect:/addBook";
			}
		} else {
			return "redirect:/showCategory";
		}
	}
	
	@RequestMapping("/lookBooks4Category")
	public String lookBooks4Category(@RequestParam String categoryId, Model model) {
		model.addAttribute("searchedBooks", categoryService.getCategory(Integer.valueOf(categoryId)).getBooks());
		return "bookResult";
	}

}