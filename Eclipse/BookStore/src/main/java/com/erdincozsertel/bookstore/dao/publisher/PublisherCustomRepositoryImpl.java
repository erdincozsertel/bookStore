package com.erdincozsertel.bookstore.dao.publisher;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.erdincozsertel.bookstore.domain.Publisher;

@Repository
public class PublisherCustomRepositoryImpl implements PublisherCustomRepository {

	@Autowired
	private EntityManager manager;

	@Override
	public Publisher findPublisherByName(String publisherName) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Publisher.class);
		criteria.add(Restrictions.eqOrIsNull("publisherName", publisherName));
		return (Publisher) criteria.uniqueResult();
	}

}
