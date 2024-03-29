package com.erdincozsertel.bookstore.dao.publisher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erdincozsertel.bookstore.domain.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

}
