package com.trip.mukja.security;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.trip.mukja.model.dto.MemberDTO;
import com.trip.mukja.model.mapper.MemberMapper;

public class CustomLoadUserByUsername implements UserDetailsService {

	MemberMapper memberMapper;
	
	public MemberDTO loadUserByUsername(String userId) {
		MemberDTO member = memberMapper.getOne(userId);
		if(member == null) throw new UsernameNotFoundException("Not Found User");
		return member;
	}
}
