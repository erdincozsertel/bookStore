package com.erdincozsertel.bookstore.service;

import java.util.List;

import javax.servlet.ServletException;

import com.erdincozsertel.bookstore.domain.Publisher;

public interface PublisherService {

	void save(Publisher publisher);

	void update(Publisher publisher);

	void delete(Integer publisherId);

	List<Publisher> getPublisherList() throws ServletException;

	String getPublisherName(Integer publisherId);

	Publisher getPublisher(Integer publisherId);

}
