package com.erdincozsertel.bookstore.domain;

import java.sql.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.erdincozsertel.bookstore.Gender;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(nullable = false)
	@NotEmpty()
	private String name;
	@Column(nullable = false)
	@NotEmpty
	private String surname;

	@Column(nullable = false, unique = true)
	@NotEmpty
	private String username;
	@Column(nullable = false)
	@NotEmpty
	@Size(min = 4)
	private String password;
	private byte[] salt;

	@Column(nullable = false, unique = true)
	@NotEmpty
	@Email(message = "{errors.invalid_email}")
	private String email;

	private Integer accountType;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "varchar(6)")
	private Gender gender;

	@Basic
	private Date birthDate;

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "user_role", joinColumns = {
			@JoinColumn(name = "USER_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID") })
	private List<Role> roles;

	public User() {
	}

//	public User(UserDto userDto) {
//		this.id = userDto.getId();
//		this.name = userDto.getName();
//		this.surname = userDto.getSurname();
//		this.username = userDto.getUsername();
//		this.password = userDto.getPassword();
//		this.salt = userDto.getSalt();
//		this.email = userDto.getEmail();
//		this.accountType = userDto.getAccountType();
//		this.gender = userDto.getGender();
//		this.birthDate = userDto.getBirthDate();
//	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public User(Integer id, String name, String surname, String username, String password, byte[] salt, String email,
			Integer accountType, Gender gender, Date birthDate) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.password = password;
		this.salt = salt;
		this.email = email;
		this.accountType = accountType;
		this.gender = gender;
		this.birthDate = birthDate;
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

	public void setId(Integer id) {
		this.id = id;
	}

	public Gender getGender() {
		return gender;
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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}