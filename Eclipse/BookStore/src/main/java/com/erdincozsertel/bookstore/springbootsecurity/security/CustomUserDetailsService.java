package com.erdincozsertel.bookstore.springbootsecurity.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.erdincozsertel.bookstore.dao.UserCustomRepository;
import com.erdincozsertel.bookstore.dao.UserRepository;
import com.erdincozsertel.bookstore.domain.User;

public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userDao;

	@Autowired
	private UserCustomRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user;
		user = userRepo.findUserByEmail(userName);
		try {
			if (user == null) {
				throw new UsernameNotFoundException("Username " + userName + " not found");
			}
		} catch (Exception UsernameNotFoundException) {
			UsernameNotFoundException.printStackTrace();
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				getAuthorities(user));
	}

	private static Collection<? extends GrantedAuthority> getAuthorities(User user) {
		String[] userRoles = user.getRoles().stream().map((role) -> role.getName()).toArray(String[]::new);
		Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
		return authorities;
	}
}
