package com.trip.mukja.service;

import com.trip.mukja.model.dto.MemberDTO;

public interface MemberService {

	int idCheck(String userId) throws Exception;
	int joinMember(MemberDTO memberDTO) throws Exception;
	MemberDTO loginMember(String userId, String userPwd) throws Exception;
	int modifyInfo(MemberDTO memberDTO);
	
	void deleteMember(String userId);
}
