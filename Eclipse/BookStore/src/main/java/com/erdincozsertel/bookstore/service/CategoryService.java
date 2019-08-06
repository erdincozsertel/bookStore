package com.erdincozsertel.bookstore.service;

import java.util.List;
import com.erdincozsertel.bookstore.domain.Category;

public interface CategoryService {

	void save(Category category);

	void update(Category category);

	void delete(Integer categoryId);

	List<Category> getCategoryList();

	String getCategoryName(Integer categoryId);

	Category getCategory(Integer categoryId);

}
