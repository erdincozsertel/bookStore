package com.erdincozsertel.bookstore.service.category;

import java.util.List;
import com.erdincozsertel.bookstore.domain.Category;

public interface CategoryService {

	Category save(Category category);

	void update(Category category);

	void delete(Integer categoryId);

	List<Category> getCategoryList();

	String getCategoryName(Integer categoryId);

	Category getCategory(Integer categoryId);
	
	Category getCategoryByName(String categoryName);

}
