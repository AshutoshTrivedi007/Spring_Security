package com.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.security.entites.User;
import com.security.repo.UserRepo;

public class MyUserDetailsService implements UserDetailsService
{
	
	@Autowired
	UserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
	Optional<User> user =repo.findByEmail(username);
	 return user.map(MyUserDetails::new)
			 .orElseThrow(()->new UsernameNotFoundException("user not found="+username));
	}


}
