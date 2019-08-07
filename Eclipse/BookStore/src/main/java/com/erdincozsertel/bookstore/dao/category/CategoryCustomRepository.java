package com.erdincozsertel.bookstore.dao.category;

import com.erdincozsertel.bookstore.domain.Category;

public interface CategoryCustomRepository {

	Category findCategoryByName(String categoryName);

}
