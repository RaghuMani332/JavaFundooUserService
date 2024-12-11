package com.fundoouserservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.fundoouserservice.dao.UserDao;
import com.fundoouserservice.exception.UserNotFoundException;

@Component
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDao dao;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		System.out.println("in MY USER DETAILS SERVICE Class");
		 MyUserDetails userDetails = dao.findByEmail(email).map(u -> new MyUserDetails(u)).orElseThrow(() -> new UserNotFoundException("the given user id is incorrect"));
		return userDetails;
	}

}
