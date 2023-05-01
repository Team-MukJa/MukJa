package com.trip.mukja.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.trip.mukja.model.dto.MemberDTO;

public class CustomAuthenticaionProvider implements AuthenticationProvider {

	@Autowired
	private CustomLoadUserByUsername customLoadUserByUsername;

	@Autowired
	private PasswordEncoder passwordEncoder;


	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		MemberDTO member = (MemberDTO) customLoadUserByUsername.loadUserByUsername(authentication.getName().toString());
		String reqPassword = authentication.getCredentials().toString();
		if (!passwordEncoder.matches(reqPassword, member.getPassword()))
			throw new BadCredentialsException("Not Found User");

		return new UsernamePasswordAuthenticationToken(member, null, member.getAuthorities());

	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
