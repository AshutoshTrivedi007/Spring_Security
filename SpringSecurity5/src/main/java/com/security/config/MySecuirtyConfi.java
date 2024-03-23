package com.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.security.service.MyUserDetailsService;
import com.security.service.UserServiceImp;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class MySecuirtyConfi 
{	
    @Bean
    public UserDetailsService userDetailsService()
    {	
    return  new MyUserDetailsService();	
    }
	
	
    @Bean
	public PasswordEncoder passwordEncoder()
	{
	return new BCryptPasswordEncoder();	
	}
	
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
    {
    	return httpSecurity.csrf().disable()
    			.authorizeHttpRequests()
    			.requestMatchers("/api/register","api/test")
    			.permitAll()
    			.and()
    			.authorizeHttpRequests()
    			.requestMatchers("/api/**")
    			.authenticated()
    			.and()
    			//.formLogin()
    			.httpBasic()
    			.and()
    			.build();
    }
    
    
  @Bean  			
  public AuthenticationProvider  authenticationProvider()
  {
	  DaoAuthenticationProvider  authenticationProvider=new DaoAuthenticationProvider();
	  authenticationProvider.setUserDetailsService(userDetailsService());
	  authenticationProvider.setPasswordEncoder(passwordEncoder());
	return authenticationProvider;	  
  }
  
    	
    }
    
	
