package com.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class MyConfig 
{

	@Bean
	public UserDetailsService  userDetailsService(PasswordEncoder encoder)
	{
		UserDetails admin=User.withUsername("surya")
		.password(encoder.encode("surya123"))
		.roles("ADMIN")
		.build();
		
		UserDetails user=User.withUsername("ram")
		.password(encoder.encode("ram123"))
		.roles("USER")
		.build();		
		return new InMemoryUserDetailsManager(admin,user);
	
	}
	
	
	@Bean
	public SecurityFilterChain config(HttpSecurity httpSecurity) throws Exception
	{	
	return httpSecurity.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers("/androjava/go")
		.permitAll()
		.and()
		.authorizeHttpRequests()
		.requestMatchers("/androjava/**")
		.authenticated()
	
		 .and()
		//.formLogin()
		//.and()
		 .httpBasic()
		 .and()
		.build();		
	}
	

	@Bean
	PasswordEncoder passwordEncoder()
	{  
	//PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	return new BCryptPasswordEncoder();
		
	}
	
	
	
	
	
	
	
	

}
