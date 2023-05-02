package com.trip.mukja.service.impl;

import com.trip.mukja.model.dto.MemberDTO;
import com.trip.mukja.service.MemberService;

public class MemberServiceImpl implements MemberService {
	
	private static MemberService memberService = new MemberServiceImpl();
	
	private MemberServiceImpl() {
	}
	
	public static MemberService getMemberService() {
		return memberService;
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
	public MemberDTO loginMember(String userId, String userPwd) throws Exception {
//		return memberDao.loginMember(userId, userPwd);
		return null;

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
