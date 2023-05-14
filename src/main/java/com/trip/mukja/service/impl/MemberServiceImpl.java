package com.trip.mukja.service.impl;

import com.trip.mukja.model.dto.MemberDTO;
import java.util.Map;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.trip.mukja.model.dto.MemberDTO;
import com.trip.mukja.model.mapper.MemberMapper;
import com.trip.mukja.service.MemberService;

@Service
// final로 선언된 필드들의 생성자를 만들어준다.
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	
	
	private final MemberMapper memberMapper;
	private final BCryptPasswordEncoder encoder;

	@Override
	public int idCheck(String userId) throws Exception {
		return 1;

	}

	@Override
	public int joinMember(MemberDTO memberDTO) throws Exception {
		// encoder를 통하여 비밀번호를 암호화 시켜준다.
		memberDTO.setUserPwd(encoder.encode(memberDTO.getUserPwd()));
		return memberMapper.joinMember(memberDTO);

	}

	@Override
	public String loginMember(MemberDTO memberDTO) throws Exception {
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
