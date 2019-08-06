package com.erdincozsertel.bookstore.service;

import java.util.List;

import com.erdincozsertel.bookstore.domain.Writer;

public interface WriterService {

	void save(Writer writer);

	void update(Writer writer);

	void delete(Integer writerId);

	List<Writer> getWriterList();

	String getWriterName(Integer writerId);

	Writer getWriter(Integer writerId);

}
