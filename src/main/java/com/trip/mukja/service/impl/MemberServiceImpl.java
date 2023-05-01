package com.trip.mukja.service.impl;

import java.util.Map;

import com.trip.mukja.model.dto.MemberDTO;
import com.trip.mukja.model.mapper.MemberMapper;
import com.trip.mukja.service.MemberService;

public class MemberServiceImpl implements MemberService {
	
	
	private MemberMapper memberMapper;

	public MemberServiceImpl(MemberMapper memberMapper) {
		super();
		this.memberMapper = memberMapper;
	}

	@Override
	public int idCheck(String userId) throws Exception {
//		return memberDao.idCheck(userId);
		return 1;

	}

	@Override
	public int joinMember(MemberDTO memberDTO) throws Exception {
//		return memberDao.joinMember(memberDTO);
		return 1;

	}

	@Override
	public MemberDTO loginMember(Map<String,String> map) throws Exception {
//		return memberDao.loginMember(userId, userPwd);
		return ;

	}

	@Override
	public int modifyInfo(MemberDTO memberDTO) {
		return 0;
//		return memberDao.modifyInfo(memberDTO);

	}

	@Override
	public void deleteMember(String userId) {
//		memberDao.deleteMember(userId);
		
	}

}
