package com.erdincozsertel.bookstore.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookId;

	@Column(nullable = false)
	@NotEmpty()
	private String bookName;
	@ManyToOne
	private Writer bookWriter;
	@ManyToOne
	private Publisher bookPublisher;
//	@Column(nullable = false /*, precision=5, scale=2*/)
//	@DecimalMin("0.00")
//	@DecimalMax("999.99")
//	@NotEmpty()
	private BigDecimal bookPrice;
	@ManyToOne
	private Category bookCategory;
	@Basic
	private LocalDateTime insertDate;

	public Book() {
	}

	public Book(Book book) {
		this.bookId = book.getBookId();
		this.bookName = book.getBookName();
		this.bookWriter = book.getBookWriter();
		this.bookPublisher = book.getBookPublisher();
		this.bookPrice = book.getBookPrice();
		this.bookCategory = book.getBookCategory();
		this.insertDate = book.getInsertDate();
	}

	public Book(Integer bookId, String bookName, Writer bookWriter, Publisher bookPublisher, BigDecimal bookPrice,
			Category bookCategory, LocalDateTime insertDate) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookWriter = bookWriter;
		this.bookPublisher = bookPublisher;
		this.bookPrice = bookPrice;
		this.bookCategory = bookCategory;
		this.insertDate = insertDate;
	}

	public Integer getBookId() {
		return bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public Writer getBookWriter() {
		return bookWriter;
	}

	public Publisher getBookPublisher() {
		return bookPublisher;
	}

	public BigDecimal getBookPrice() {
		return bookPrice;
	}

	public Category getBookCategory() {
		return bookCategory;
	}

	public LocalDateTime getInsertDate() {
		return insertDate;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public void setBookWriter(Writer bookWriter) {
		this.bookWriter = bookWriter;
	}

	public void setBookPublisher(Publisher bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	public void setBookPrice(BigDecimal bookPrice) {
		this.bookPrice = bookPrice;
	}

	public void setBookCategory(Category bookCategory) {
		this.bookCategory = bookCategory;
	}

	public void setInsertDate(LocalDateTime insertDate) {
		this.insertDate = insertDate;
	}

}