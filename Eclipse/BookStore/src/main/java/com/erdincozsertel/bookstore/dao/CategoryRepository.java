package com.erdincozsertel.bookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erdincozsertel.bookstore.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
