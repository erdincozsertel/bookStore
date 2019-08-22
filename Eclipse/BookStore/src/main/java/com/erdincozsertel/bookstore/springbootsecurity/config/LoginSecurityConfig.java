//package com.erdincozsertel.bookstore.springbootsecurity.config;
//
//import org.springframework.beans.factory.annotation.Autowired;	
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;	
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;	
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;	
//
//public class LoginSecurityConfig extends WebSecurityConfigurerAdapter{	
//	@Autowired	
//	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {	
//		authenticationMgr.inMemoryAuthentication()	
//			.withUser("defuser").password("defpass").roles("USER");	
//	}	
//
//	@Override	
//	protected void configure(HttpSecurity http) throws Exception {	
//		http.authorizeRequests()	
//			.antMatchers("/homePage").access("hasRole('ROLE_USER')")	
//			.and()	
//				.formLogin().loginPage("/userlogin")	
//				.defaultSuccessUrl("/homePage")	
//				.failureUrl("/userlogin?error")	
//				.usernameParameter("username").passwordParameter("password")					
//			.and()	
//				.logout().logoutSuccessUrl("/loginPage?logout"); 	
//
//	}	
//
//}