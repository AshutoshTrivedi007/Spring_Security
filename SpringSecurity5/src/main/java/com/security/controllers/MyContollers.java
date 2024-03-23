package com.security.controllers;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.entites.User;
import com.security.service.UserService;

@RestController
@RequestMapping("/api")
public class MyContollers 
{

	@Autowired
	private UserService service;
	
	
	@PostMapping("/register")
	public User registerUser(@RequestBody User user)
	{		
	 return	service.createUser(user);
	}
	

	
	
	@GetMapping("/home")
	@PreAuthorize("hasAuthority('USER')")
	public String homePage()
	{	
		return "homepage";
	}
	
	

	@GetMapping("/admin")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String adminPage()
	{	
		return "adminPage";
	}
	
}
