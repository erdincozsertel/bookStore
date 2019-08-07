package com.erdincozsertel.bookstore.service.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erdincozsertel.bookstore.dao.category.CategoryCustomRepository;
import com.erdincozsertel.bookstore.dao.category.CategoryRepository;
import com.erdincozsertel.bookstore.domain.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryDao;

	@Autowired
	private CategoryCustomRepository categoryRepo;

	@Override
	public Category save(Category category) {
		return categoryDao.save(category);

	}

	@Override
	public void update(Category category) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer categoryId) {
		categoryDao.deleteById(categoryId);

	}

	@Override
	public List<Category> getCategoryList() {
		return categoryDao.findAll();
	}

	@Override
	public String getCategoryName(Integer categoryId) {
		return getCategory(categoryId).getCategoryName();
	}

	@Override
	public Category getCategory(Integer categoryId) {
		return categoryDao.getOne(categoryId);
	}

	@Override
	public Category getCategoryByName(String categoryName) {
		return categoryRepo.findCategoryByName(categoryName);
	}

}
