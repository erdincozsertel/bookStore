package com.erdincozsertel.bookstore.dao.writer;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.erdincozsertel.bookstore.domain.Writer;

@Repository
public class WriterCustomRepositoryImpl implements WriterCustomRepository {
	
	@Autowired
	private EntityManager manager;

	@Override
	public Writer findWriterByName(String writerName) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Writer.class);
		criteria.add(Restrictions.eqOrIsNull("writerName", writerName));
		return (Writer) criteria.uniqueResult();
	}

}
