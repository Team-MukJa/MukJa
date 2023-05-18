package com.trip.mukja.service;


import java.util.Map;

import com.trip.mukja.model.dto.MemberDTO;
public interface MemberService {



	int idCheck(String userId) throws Exception;
	
	int joinMember(MemberDTO memberDTO) throws Exception;
	
	String loginMember(MemberDTO memberDTO) throws Exception;
	
	int modifyInfo(MemberDTO memberDTO);
	
	int deleteMember(String userId);
	
	MemberDTO getOne(String userId);
}
