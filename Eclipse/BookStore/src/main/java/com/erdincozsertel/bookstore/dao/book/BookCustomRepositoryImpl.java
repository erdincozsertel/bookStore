package com.erdincozsertel.bookstore.dao.book;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.erdincozsertel.bookstore.domain.Book;

@Repository
public class BookCustomRepositoryImpl implements BookCustomRepository {

	@Autowired
	private EntityManager manager;

	@Override
	public Book findBookByName(String bookName) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Book.class);		
		criteria.add(Restrictions.eqOrIsNull("bookName", bookName));
		return (Book) criteria.uniqueResult();
	}
	
}
