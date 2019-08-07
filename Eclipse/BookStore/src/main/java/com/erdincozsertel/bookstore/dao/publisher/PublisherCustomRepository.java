package com.erdincozsertel.bookstore.dao.publisher;

import com.erdincozsertel.bookstore.domain.Publisher;

public interface PublisherCustomRepository {

	Publisher findPublisherByName(String publisherName);

}
