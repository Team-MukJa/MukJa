package com.trip.mukja.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig { 

	@Autowired
	private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
	
	@Autowired
	private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;
	
	@Autowired
	private CustomAuthenticaionProvider customAuthenticaionProvider;
	
	@Autowired
//	 userDetailsService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http
	      .csrf().disable()
	      ;

	    http
	      .authorizeRequests()
	        .antMatchers("/member").hasAnyRole("USER")
	        .anyRequest().permitAll() 
	            ;

	    http
	      .formLogin()
	        .loginProcessingUrl("/member/login")
	        .usernameParameter("userId")
	        .passwordParameter("userPwd")
	        .successHandler(customAuthenticationSuccessHandler)
	        .failureHandler(customAuthenticationFailureHandler)
	      ;

	    http
	      .sessionManagement()
	        .maximumSessions(1)
	        .maxSessionsPreventsLogin(true) 
	      ;
	    
		return http.build();
	}
	
	@Bean
	 protected AuthenticationManager authenticationManager (AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	
	  }
}
