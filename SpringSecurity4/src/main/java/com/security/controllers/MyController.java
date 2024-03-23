package com.security.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/androjava")
public class MyController {


	
@GetMapping(value = "/hi")	
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public String sayHello()
{
return "hello Spring boot";	
}

@GetMapping(value = "/bye")	
@PreAuthorize("hasAuthority('ROLE_USER')")
public String sayBye()
{
	return "bye Spring boot";
	
}

@GetMapping(value = "/go")	
public String sayGo()
{
	return "go Spring boot";
	
}


	
}

