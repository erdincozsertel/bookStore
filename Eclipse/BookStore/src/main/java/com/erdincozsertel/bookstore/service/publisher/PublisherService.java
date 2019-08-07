package com.erdincozsertel.bookstore.service.publisher;

import java.util.List;

import com.erdincozsertel.bookstore.domain.Publisher;

public interface PublisherService {

	Publisher save(Publisher publisher);

	void update(Publisher publisher);

	void delete(Integer publisherId);

	List<Publisher> getPublisherList();

	String getPublisherName(Integer publisherId);

	Publisher getPublisher(Integer publisherId);
	
	Publisher getPublisherByName (String publisherName);

}
