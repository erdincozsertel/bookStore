package com.erdincozsertel.bookstore.service;

import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erdincozsertel.bookstore.dao.CategoryCustomRepository;
import com.erdincozsertel.bookstore.dao.CategoryRepository;
import com.erdincozsertel.bookstore.domain.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryDao;

	@Autowired
	private CategoryCustomRepository categoryRepo;

	@Override
	public void save(Category category) {
		categoryDao.save(category);

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
	public List<Category> getCategoryList() throws ServletException {
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

}
