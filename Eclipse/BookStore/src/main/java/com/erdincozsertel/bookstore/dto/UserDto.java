package com.erdincozsertel.bookstore.dto;

import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.erdincozsertel.bookstore.Gender;
import com.erdincozsertel.bookstore.domain.User;

public class UserDto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NotEmpty
	private String name;
	@NotEmpty
	private String surname;

	@NotEmpty
	private String username;

	@NotEmpty
	private String password;
	private byte[] salt;

	@Email
	@NotEmpty
	private String email;

	@NotEmpty
	private Integer accountType;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Basic
	private Date birthDate;

	public UserDto(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.surname = user.getSurname();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.salt = user.getSalt();
		this.email = user.getEmail();
		this.accountType = user.getAccountType();
		this.gender = user.getGender();
		this.birthDate = user.getBirthDate();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAccountType() {
		return accountType;
	}

	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}

	public byte[] getSalt() {
		return salt;
	}

	public void setSalt(byte[] salt) {
		this.salt = salt;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
