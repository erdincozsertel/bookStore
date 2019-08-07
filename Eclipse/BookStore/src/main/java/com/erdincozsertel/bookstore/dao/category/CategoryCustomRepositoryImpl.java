package com.erdincozsertel.bookstore.dao.category;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.erdincozsertel.bookstore.domain.Category;

@Repository
public class CategoryCustomRepositoryImpl implements CategoryCustomRepository {

	@Autowired
	private EntityManager manager;

	@Override
	public Category findCategoryByName(String categoryName) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Category.class);		
		criteria.add(Restrictions.eqOrIsNull("categoryName", categoryName));
		return (Category) criteria.uniqueResult();
	}
}
