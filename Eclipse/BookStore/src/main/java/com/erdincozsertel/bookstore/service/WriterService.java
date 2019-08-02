package com.erdincozsertel.bookstore.service;

import java.util.List;

import javax.servlet.ServletException;

import com.erdincozsertel.bookstore.domain.Writer;

public interface WriterService {

	void save(Writer writer);

	void update(Writer writer);

	void delete(Integer writerId);

	List<Writer> getWriterList() throws ServletException;

	String getWriterName(Integer writerId);

	Writer getWriter(Integer writerId);

}
