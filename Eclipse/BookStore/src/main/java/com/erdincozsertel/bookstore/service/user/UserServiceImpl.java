package com.erdincozsertel.bookstore.service.user;

import java.security.SecureRandom;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erdincozsertel.bookstore.Gender;
import com.erdincozsertel.bookstore.dao.user.UserCustomRepository;
import com.erdincozsertel.bookstore.dao.user.UserRepository;
import com.erdincozsertel.bookstore.domain.User;
import com.erdincozsertel.bookstore.form.UserForm;
import com.erdincozsertel.bookstore.util.EncodingPasswordUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userDao;

	@Autowired
	private UserCustomRepository userRepo;

	@Override
	public User getUserByEmail(String email) {
		return userRepo.findUserByEmail(email);
	}

	@Override
	public User getUserByUsername(String username) {
		return userRepo.findUserByUsername(username);
	}

	@Override
	public User saveUser(User user) {
		return userDao.save(user);
	}

	@Override
	public User userRegister(User user) {
		String name = user.getName();
		String surname = user.getSurname();

		String username = user.getUsername();
		String password = user.getPassword();

		String email = user.getEmail();

		Integer accountType;

		if (user.getAccountType() != null) {
			accountType = user.getAccountType();
		} else {
			accountType = 0;
		}

		user.setAccountType(accountType);

		Gender gender = user.getGender();
		Date birthDate = user.getBirthDate();

		if (name != null || surname != null || username != null || password != null || email != null
				|| accountType != null || gender != null || birthDate.toString() != null) {
			SecureRandom random = new SecureRandom();
			byte[] salt = new byte[16];
			user.setSalt(salt);
			random.nextBytes(salt);
			password = EncodingPasswordUtil.hashPassword(password, salt);
			if (user.getPassword() == password) {
				return null;
			} else {
				user.setPassword(password);
				user.setSalt(salt);
				user = saveUser(user);
				return user;
			}
		} else {
			return null;
		}
	}

	@Override
	public UserForm userLogin(UserForm user) {
		String username = user.getUsername();
		String password = user.getPassword();
		User dbUser = userRepo.findUserByUsername(username);
		if (dbUser == null) {
			return null;
		} else {
			byte[] salt = dbUser.getSalt();
			password = EncodingPasswordUtil.hashPassword(password, salt);

			byte[] dbHash = dbUser.getPassword().getBytes();
			byte[] inHash = password.getBytes();
			Integer diff = dbHash.length ^ inHash.length;
			for (int i = 0; i < dbHash.length && i < inHash.length; i++) {
				diff |= dbHash[i] ^ inHash[i];
			}

			if (diff == 0) {
				user.setPassword(password);
				return user;
			} else {
				return null;
			}
		}
	}

}
