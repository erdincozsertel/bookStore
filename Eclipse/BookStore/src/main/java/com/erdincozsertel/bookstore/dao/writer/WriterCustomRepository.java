package com.erdincozsertel.bookstore.dao.writer;

import com.erdincozsertel.bookstore.domain.Writer;

public interface WriterCustomRepository {

	Writer findWriterByName(String writerName);

}
