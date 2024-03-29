package com.erdincozsertel.bookstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erdincozsertel.bookstore.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
