package com.erdincozsertel.bookstore.service.publisher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erdincozsertel.bookstore.dao.publisher.PublisherCustomRepository;
import com.erdincozsertel.bookstore.dao.publisher.PublisherRepository;
import com.erdincozsertel.bookstore.domain.Publisher;

@Service
public class PublisherServiceImpl implements PublisherService {

	@Autowired
	private PublisherRepository publisherDao;

	@Autowired
	private PublisherCustomRepository publisherRepo;

	@Override
	public Publisher save(Publisher publisher) {
		return publisherDao.save(publisher);

	}

	@Override
	public void update(Publisher publisher) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer publisherId) {
		publisherDao.deleteById(publisherId);

	}

	@Override
	public List<Publisher> getPublisherList() {
		return publisherDao.findAll();
	}

	@Override
	public String getPublisherName(Integer publisherId) {
		return getPublisher(publisherId).getPublisherName();
	}

	@Override
	public Publisher getPublisher(Integer publisherId) {
		return publisherDao.getOne(publisherId);
	}

	@Override
	public Publisher getPublisherByName(String publisherName) {
		return publisherRepo.findPublisherByName(publisherName);
	}

}
