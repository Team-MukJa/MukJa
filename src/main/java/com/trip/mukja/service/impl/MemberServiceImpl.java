package com.trip.mukja.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.trip.mukja.model.dto.MemberDTO;
import com.trip.mukja.model.mapper.MemberMapper;
import com.trip.mukja.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	
	
	private MemberMapper memberMapper;

	public MemberServiceImpl(MemberMapper memberMapper) {
		super();
		this.memberMapper = memberMapper;
	}

	@Override
	public int idCheck(String userId) throws Exception {
		return 1;

	}

	@Override
	public int joinMember(MemberDTO memberDTO) throws Exception {
		return memberMapper.joinMember(memberDTO);

	}

	@Override
	public MemberDTO loginMember(MemberDTO memberDTO) throws Exception {
		return memberMapper.loginMember(memberDTO);

	}

	@Override
	public int modifyInfo(MemberDTO memberDTO) {
		return memberMapper.modifyInfo(memberDTO);

	}

	@Override
	public int deleteMember(String userId) {
		return memberMapper.deleteMember(userId);
		
	}

	@Override
	public MemberDTO getOne(String userId) {
		return memberMapper.getOne(userId);
	}

}
