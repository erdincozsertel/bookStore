package com.erdincozsertel.bookstore.domain;

import java.sql.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.erdincozsertel.bookstore.Gender;

@Entity
@Table(name = "writers")
public class Writer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer writerId;
	@Column(nullable = false, unique = true)
	@NotEmpty()
	private String writerName;
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "varchar(6)")
	private Gender gender;
	@Basic
	private Date birthDate;

	@OneToMany(mappedBy = "bookWriter")
	private List<Book> books;

	public Writer() {
	}

	public Writer(Integer writerId, String writerName, Gender gender, Date birthDate) {
		this.writerId = writerId;
		this.writerName = writerName;
		this.gender = gender;
		this.birthDate = birthDate;
	}

	public Writer(String writerName, Gender gender, Date birthDate) {
		this.writerName = writerName;
		this.gender = gender;
		this.birthDate = birthDate;
	}

	public Writer(String writerName) {
		this.writerName = writerName;
	}

//	public Writer(Integer writerId) {
//		this.writerId = writerId;
//		WriterDao writerDao = new WriterDaoImpl();
//		Writer writer = writerDao.getWriter(writerId);
//		this.writerName = writer.getWriterName();
//		this.gender = writer.getGender();
//		this.birthDate = writer.getBirthDate();
//	}

	public String getWriterName() {
		return writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Integer getWriterId() {
		return writerId;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setWriterId(Integer writerId) {
		this.writerId = writerId;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}