package com.erdincozsertel.bookstore.dao.user;

import java.util.Collection;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Repository;

import com.erdincozsertel.bookstore.domain.User;

@Repository
public class UserCustomRepositoryImpl implements UserCustomRepository {

	@Autowired
	private EntityManager manager;

	@SuppressWarnings("deprecation")
	@Override
	public User findUserByEmail(String email) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(User.class);
		criteria.add(Restrictions.eqOrIsNull("email", email));
		return (User) criteria.uniqueResult();
	}

	@Override
	public User findUserByUsername(String username) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(User.class);
		criteria.add(Restrictions.eqOrIsNull("username", username));
		return (User) criteria.uniqueResult();
	}
	
//	private static Collection<? extends GrantedAuthority> getAuthorities(User user) {
//        String[] userRoles = user.getRoles().stream().map((role) -> role.getName()).toArray(String[]::new);
//        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
//        return authorities;
//    }

}
