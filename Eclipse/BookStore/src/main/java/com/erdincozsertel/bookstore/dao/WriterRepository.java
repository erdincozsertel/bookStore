package com.erdincozsertel.bookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erdincozsertel.bookstore.domain.Writer;

@Repository
public interface WriterRepository extends JpaRepository<Writer, Integer> {

}
