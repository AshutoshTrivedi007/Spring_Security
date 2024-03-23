package com.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.entites.User;
import com.security.repo.UserRepo;

@Service
public class UserServiceImp implements UserService  
{
 
    @Autowired
	UserRepo repo;
    
    @Autowired
    PasswordEncoder passwordEncoder;
     
  
    
    @Override
	public User createUser(User user) 
    {
    	user.setPass(passwordEncoder.encode(user.getPass()));
		return repo.save(user);
		  
	}

 

	

}

