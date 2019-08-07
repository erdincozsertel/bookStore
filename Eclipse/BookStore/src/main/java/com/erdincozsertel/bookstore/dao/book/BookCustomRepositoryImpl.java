package com.erdincozsertel.bookstore.dao.book;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookCustomRepositoryImpl implements BookCustomRepository {

	@Autowired
	private EntityManager manager;
}
