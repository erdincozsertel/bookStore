package com.erdincozsertel.bookstore.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "publishers")
public class Publisher {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer publisherId;

	@Column(nullable = false, unique = true)
	@NotEmpty()
	private String publisherName;

	@OneToMany(mappedBy = "bookPublisher")
	private List<Book> books;

	public Publisher(Integer publisherId, String publisherName) {
		this.publisherId = publisherId;
		this.publisherName = publisherName;
	}

	public Publisher() {
	}

	public Integer getPublisherId() {
		return publisherId;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setPublisherId(Integer publisherId) {
		this.publisherId = publisherId;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}