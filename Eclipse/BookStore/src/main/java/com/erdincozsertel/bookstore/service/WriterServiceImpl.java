package com.erdincozsertel.bookstore.service;

import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erdincozsertel.bookstore.dao.WriterCustomRepository;
import com.erdincozsertel.bookstore.dao.WriterRepository;
import com.erdincozsertel.bookstore.domain.Writer;

@Service
public class WriterServiceImpl implements WriterService {

	@Autowired
	private WriterRepository writerDao;

	@Autowired
	private WriterCustomRepository writerRepo;

	@Override
	public void save(Writer writer) {
		writerDao.save(writer);
	}

	@Override
	public void update(Writer writer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer writerId) {
		writerDao.deleteById(writerId);
	}

	@Override
	public List<Writer> getWriterList() throws ServletException {
		return writerDao.findAll();
	}

	@Override
	public String getWriterName(Integer writerId) {
		return getWriter(writerId).getWriterName();
	}

	@Override
	public Writer getWriter(Integer writerId) {
		return writerDao.getOne(writerId);
	}

}
